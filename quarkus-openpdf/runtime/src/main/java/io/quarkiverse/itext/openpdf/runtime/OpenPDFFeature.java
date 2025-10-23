package io.quarkiverse.itext.openpdf.runtime;

import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.hosted.RuntimeClassInitialization;
import org.openpdf.pdf.ITextOutputDevice;
import org.openpdf.renderer.colorspace.PDFColorSpace;
import org.openpdf.renderer.font.ttf.AdobeGlyphList;
import org.openpdf.text.pdf.PdfPublicKeySecurityHandler;



public class OpenPDFFeature implements Feature {

    private final static String REASON = "OpenPDF runtime initialization";

    @Override
    public void afterRegistration(AfterRegistrationAccess access) {
        // itext core
        RuntimeClassInitialization.initializeAtRunTime(PdfPublicKeySecurityHandler.class.getName());

        // image renderer
        RuntimeClassInitialization.initializeAtRunTime(AdobeGlyphList.class.getName());
        RuntimeClassInitialization.initializeAtRunTime(PDFColorSpace.class.getName());

        // html renderer
        RuntimeClassInitialization.initializeAtRunTime(ITextOutputDevice.class.getName());
    }

    @Override
    public String getDescription() {
        return REASON;
    }

}
