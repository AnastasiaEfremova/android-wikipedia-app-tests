package helpers;

import config.BrowserstackConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.aeonbits.owner.ConfigFactory;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BrowserstackHelper {
    private static final BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(config.userName(), config.accessKey())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }

    public static String uploadApp() {
        String url = "https://api-cloud.browserstack.com/app-automate/upload";
        Map<String, Object> dataBody = new HashMap<>();
        dataBody.put("url", config.appUrl() + config.appName());

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("data", dataBody);

        Response response = given()
                .header("Authorization", "Basic " + Base64.getEncoder().encodeToString((config.userName()
                        + ":" + config.accessKey()).getBytes()))
                .body(requestBody).contentType(ContentType.JSON)
                .post(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().response();
        return response.jsonPath().getString("app_url");
    }
}