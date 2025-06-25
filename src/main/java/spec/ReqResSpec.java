package spec;

import config.Configuration;
import config.ConfigurationManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;

import java.util.Map;

import static java.util.Map.entry;

public class ReqResSpec {

    private static final Configuration configuration = ConfigurationManager.getConfig();

    @Getter
    private static final RequestSpecification requestSpec;

    static {
        requestSpec = new RequestSpecBuilder()
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
