package api.factory;

import api.Api;
import api.UserApi;
import util.AppApi;

public class ApiFactoryImpl implements ApiFactory {

    @Override
    public Api getApi(AppApi appApi) {
        //noinspection SwitchStatementWithTooFewBranches
        switch (appApi) {
            case USER_API:
                return new UserApi();
        }

        // Throw if no case match
        throw new IllegalStateException("Unexpected value: " + appApi.name());
    }
}
