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
                .when().get("/openpdf/helloWorldPdf")
                .then()
                .statusCode(200)
                .body(is("Hello OpenPDF"));
    }

    @Test
    public void testConformanceA1BEndpoint() {
        given()
                .when().get("/openpdf/conformanceA1B")
                .then()
                .statusCode(200)
                .body(is("Conformance A1B"));
    }
}