package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.CreateUserModel;
import spec.ReqResSpec;
import util.ApiEndpoints;

public class UserApi implements Api {

    public Response getUser(int id) {
        return RestAssured.given(ReqResSpec.getRequestSpec())
            .get(ApiEndpoints.USERS.path + "/" + id);
    }

    public Response createUser(CreateUserModel createUserModel) {
        return RestAssured.given(ReqResSpec.getRequestSpec())
            .body(createUserModel)
            .post(ApiEndpoints.USERS.path);
    }

    public Response putUser(int id, CreateUserModel createUserModel) {
        return RestAssured.given(ReqResSpec.getRequestSpec())
            .body(createUserModel)
            .put(ApiEndpoints.USERS.path + "/" + id);
    }

    public Response patchUser(int id, CreateUserModel createUserModel) {
        return RestAssured.given(ReqResSpec.getRequestSpec())
            .body(createUserModel)
            .patch(ApiEndpoints.USERS.path + "/" + id);
    }

    public Response deleteUser(int id) {
        return RestAssured.given(ReqResSpec.getRequestSpec())
            .delete(ApiEndpoints.USERS.path + "/" + id);
    }
}
