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

    @Test
    public void testEncryptedAes256Endpoint() {
        given()
                .when().get("/openpdf/encrypted-aes256")
                .then()
                .statusCode(200)
                .body(is(
                        "Demo   Name   Signature   Date  Elizabeth Schultz (Apr 24, 2018) Elizabeth Schultz Apr 24, 2018 Elizabeth Schultz Sue Northrop (Apr 24, 2018) Apr 24, 2018 Sue Northrop"));
    }

    @Test
    public void testImageRenderer() {
        given()
                .when().get("/openpdf/renderer-image")
                .then()
                .statusCode(200)
                .body(is(
                        "Rendered page 1 to page_1.png"));
    }

    @Test
    public void testHtmlRenderer() {
        given()
                .when().get("/openpdf/renderer-html")
                .then()
                .statusCode(200)
                .body(is(
                        "PDF created: flying-saucer-hello.pdf"));
    }

    @Test
    public void testHtmlRendererTrueType() {
        given()
                .when().get("/openpdf/renderer-html-truetype-font")
                .then()
                .statusCode(200)
                .body(is(
                        "PDF created: flying-saucer-hello-truetype-font.pdf"));
    }
}
