package io.quarkiverse.poi.deployment.devui;

import io.quarkus.deployment.IsDevelopment;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.devui.spi.page.CardPageBuildItem;
import io.quarkus.devui.spi.page.Page;
import io.quarkus.devui.spi.page.PageBuilder;

/**
 * Dev UI card for displaying important details such as the iText library version.
 */
public class ItextDevUIProcessor {

    @BuildStep(onlyIf = IsDevelopment.class)
    void createVersion(BuildProducer<CardPageBuildItem> cardPageBuildItemBuildProducer) {
        final CardPageBuildItem card = new CardPageBuildItem();

        final PageBuilder versionPage = Page.externalPageBuilder("iText Version")
                .icon("font-awesome-regular:file-pdf")
                .url("https://itextpdf.com/")
                .doNotEmbed()
                .staticLabel("2.1.7"); // this will never change as its last open source version

        card.addPage(versionPage);

        card.setCustomCard("qwc-itext-card.js");

        cardPageBuildItemBuildProducer.produce(card);
    }
}
