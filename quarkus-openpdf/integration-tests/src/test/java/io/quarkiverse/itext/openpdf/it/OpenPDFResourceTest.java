package io.quarkiverse.itext.openpdf.it;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class OpenPDFResourceTest {

    @Test
    public void testhelloWorldPdfEndpoint() {
        given()
                .when().get("/openpdf")
                .then()
                .statusCode(200)
                .body(is("Hello OpenPDF"));
    }
}