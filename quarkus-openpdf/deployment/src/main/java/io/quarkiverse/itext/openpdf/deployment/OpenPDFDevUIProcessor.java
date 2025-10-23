package io.quarkiverse.itext.openpdf.deployment;

import io.quarkus.deployment.IsDevelopment;
import java.util.jar.Manifest;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.devui.spi.page.CardPageBuildItem;
import io.quarkus.devui.spi.page.ExternalPageBuilder;
import io.quarkus.devui.spi.page.Page;
import org.openpdf.text.pdf.interfaces.PdfVersion;
import java.io.InputStream;
import java.net.URL;




/**
 * Dev UI card for displaying important details such as the OpenPDF library version.
 */
public class OpenPDFDevUIProcessor {

    @BuildStep(onlyIf = IsDevelopment.class)
    void createVersion(BuildProducer<CardPageBuildItem> cardPageBuildItemBuildProducer) {
        final CardPageBuildItem card = new CardPageBuildItem();

        final ExternalPageBuilder versionPage = Page.externalPageBuilder("OpenPDF Version")
                .icon("font-awesome-solid:tag")
                .url("https://github.com/LibrePDF/OpenPDF")
                .doNotEmbed()
                .staticLabel(getManifest(PdfVersion.class).getMainAttributes().getValue("Bundle-Version"));

        card.addPage(versionPage);

        card.setCustomCard("qwc-openpdf-card.js");

        cardPageBuildItemBuildProducer.produce(card);
    }

    public static Manifest getManifest(Class<?> clz) {
        String resource = "/" + clz.getName().replace(".", "/") + ".class";
        String fullPath = clz.getResource(resource).toString();
        String archivePath = fullPath.substring(0, fullPath.lastIndexOf("!") + 1);

        try (InputStream input = new URL(archivePath + "/META-INF/MANIFEST.MF").openStream()) {
            return new Manifest(input);
        } catch (Exception e) {
            throw new RuntimeException("Loading MANIFEST for class " + clz + " failed! " + fullPath, e);
        }
    }
}
