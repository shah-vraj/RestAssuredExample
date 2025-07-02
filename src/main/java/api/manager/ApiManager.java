package api.manager;

import api.UserApi;
import api.factory.ApiFactory;
import api.factory.ApiFactoryImpl;
import util.AppApi;

public class ApiManager {

    private final ApiFactory apiFactory = new ApiFactoryImpl();

    public UserApi getUserApi() {
        return (UserApi) apiFactory.getApi(AppApi.USER_API);
    }
}
