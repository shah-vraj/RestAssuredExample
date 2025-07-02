package stepdef;

import api.UserApi;
import api.manager.ApiManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import model.CreateUserModel;
import model.CreateUserResponseModel;
import model.UpdateUserResponseModel;
import model.UserModel;
import org.testng.Assert;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class UserSteps {

    private final UserApi userApi;
    private Response response;

    public UserSteps(ApiManager apiManager) {
        this.userApi = apiManager.getUserApi();
    }

    @When("I send a GET request to fetch user with id {int}")
    public void iSendAGETRequestToFetchUserWithId(int id) {
        response = userApi.getUser(id);
    }

    @Then("The response code should be {int}")
    public void theResponseCodeShouldBe(int code) {
        Assert.assertEquals(response.statusCode(), code);
    }

    @And("The email should be {string}")
    public void theEmailShouldBe(String email) {
        UserModel userModel = response.as(UserModel.class);
        Assert.assertEquals(userModel.data.email, email);
    }

    @When("I send a POST request to add valid user")
    public void iSendAPOSTRequestToAddValidUser() {
        response = userApi.createUser(getValidUser());
    }

    @And("I should receive valid id")
    public void iShouldReceiveValidId() {
        CreateUserModel createUserModel = getValidUser();
        CreateUserResponseModel createUserResponseModel = response.as(CreateUserResponseModel.class);
        Assert.assertEquals(createUserResponseModel.name, createUserModel.name);
        Assert.assertEquals(createUserResponseModel.job, createUserModel.job);
        Assert.assertNotNull(createUserResponseModel.id);
    }

    @When("I send a PUT request to update user data with id {int}")
    public void iSendAPUTRequestToUpdateUserData(int id) {
        response = userApi.putUser(id, getUpdatedUser());
    }

    @And("I should receive updated data")
    public void iShouldReceiveUpdatedData() {
        CreateUserModel createUserModel = getUpdatedUser();
        UpdateUserResponseModel updateUserResponseModel = response.as(UpdateUserResponseModel.class);

        Instant updateDateTime = Instant.parse(updateUserResponseModel.getUpdatedAt());
        LocalDateTime updatedDateTime = LocalDateTime.ofInstant(updateDateTime, ZoneOffset.UTC);
        LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);

        Assert.assertEquals(updateUserResponseModel.name, createUserModel.name);
        Assert.assertEquals(updateUserResponseModel.job, createUserModel.job);
        Assert.assertEquals(updatedDateTime.getMonth(), now.getMonth());
        Assert.assertEquals(updatedDateTime.getYear(), now.getYear());
    }

    @When("I send a PATCH request to update user data with id {int}")
    public void iSendAPATCHRequestToUpdateUserData(int id) {
        response = userApi.patchUser(id, getUpdatedUser());
    }

    private CreateUserModel getValidUser() {
        return CreateUserModel.builder()
            .name("Vraj")
            .job("Leader")
            .build();
    }

    private CreateUserModel getUpdatedUser() {
        return CreateUserModel.builder()
            .name("Vraj")
            .job("Co-Leader")
            .build();
    }

    @When("I send a DELETE request to delete a user with id {int}")
    public void iSendADELETERequestToDeleteAUserWithId(int id) {
        response = userApi.deleteUser(id);
    }
}
