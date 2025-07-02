package api.factory;

import api.Api;
import util.AppApi;

public interface ApiFactory {
    Api getApi(AppApi appApi);
}
