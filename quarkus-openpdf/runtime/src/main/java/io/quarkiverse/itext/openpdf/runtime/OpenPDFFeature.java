package io.quarkiverse.itext.openpdf.runtime;

import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.hosted.RuntimeClassInitialization;

import com.lowagie.text.pdf.PdfPublicKeySecurityHandler;

public class OpenPDFFeature implements Feature {

    private final static String REASON = "OpenPDF runtime initialization";

    @Override
    public void afterRegistration(AfterRegistrationAccess access) {
        RuntimeClassInitialization.initializeAtRunTime(PdfPublicKeySecurityHandler.class.getName());
    }

    @Override
    public String getDescription() {
        return REASON;
    }

}