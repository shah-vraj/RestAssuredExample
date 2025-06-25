package spec;

import config.Configuration;
import config.ConfigurationManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static java.util.Map.entry;

public class ReqResSpec {

    private static final Configuration configuration = ConfigurationManager.getConfig();

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
            .setBaseUri(configuration.baseUrl())
            .addHeaders(
                Map.ofEntries(
                    entry("x-api-key", configuration.apiKey()) // API key
                )
            )
            .setRelaxedHTTPSValidation()
            .setContentType(ContentType.JSON)
            .build();
    }
}
