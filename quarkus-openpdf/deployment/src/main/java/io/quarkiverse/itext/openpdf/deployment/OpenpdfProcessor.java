package io.quarkiverse.itext.openpdf.deployment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jboss.jandex.ClassInfo;
import org.jboss.jandex.DotName;

import io.quarkiverse.itext.openpdf.runtime.OpenPDFFeature;
import io.quarkus.deployment.annotations.BuildProducer;
import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.CombinedIndexBuildItem;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import io.quarkus.deployment.builditem.IndexDependencyBuildItem;
import io.quarkus.deployment.builditem.NativeImageEnableAllCharsetsBuildItem;
import io.quarkus.deployment.builditem.NativeImageFeatureBuildItem;
import io.quarkus.deployment.builditem.nativeimage.NativeImageResourceBundleBuildItem;
import io.quarkus.deployment.builditem.nativeimage.NativeImageResourcePatternsBuildItem;
import io.quarkus.deployment.builditem.nativeimage.ReflectiveClassBuildItem;
import io.quarkus.logging.Log;

class OpenPDFProcessor {

    private static final String FEATURE = "openpdf";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    NativeImageFeatureBuildItem nativeImageFeature() {
        return new NativeImageFeatureBuildItem(OpenPDFFeature.class);
    }

    @BuildStep
    void indexTransitiveDependencies(BuildProducer<IndexDependencyBuildItem> index) {
        index.produce(new IndexDependencyBuildItem("com.github.librepdf", "openpdf"));
    }

    @BuildStep
    NativeImageEnableAllCharsetsBuildItem enableAllCharsetsBuildItem() {
        return new NativeImageEnableAllCharsetsBuildItem();
    }

    @BuildStep
    void registerOpenPdfFonts(BuildProducer<NativeImageResourcePatternsBuildItem> nativeImageResourcePatterns) {
        final NativeImageResourcePatternsBuildItem.Builder builder = NativeImageResourcePatternsBuildItem.builder();
        builder.includeGlob("**/pdf/fonts/**");
        builder.includeGlob("**/font-fallback/**");
        nativeImageResourcePatterns.produce(builder.build());
    }

    @BuildStep
    void registerOpenPdfResources(BuildProducer<NativeImageResourceBundleBuildItem> resourceBundleBuildItem) {
        // Register resource bundles
        resourceBundleBuildItem.produce(new NativeImageResourceBundleBuildItem("com/lowagie/text/error_messages/en.lng"));
        resourceBundleBuildItem.produce(new NativeImageResourceBundleBuildItem("com/lowagie/text/error_messages/nl.lng"));
        resourceBundleBuildItem.produce(new NativeImageResourceBundleBuildItem("com/lowagie/text/error_messages/pt.lng"));
    }

    @BuildStep
    void registerOpenPdfForReflection(BuildProducer<ReflectiveClassBuildItem> reflectiveClass,
            CombinedIndexBuildItem combinedIndex) {
        final List<String> classNames = new ArrayList<>(
                collectSubclasses(combinedIndex, com.lowagie.text.Image.class.getName()));
        classNames.add(com.lowagie.text.PageSize.class.getName());
        classNames.add(com.lowagie.text.Utilities.class.getName());
        classNames.add(com.lowagie.text.pdf.PdfName.class.getName());
        classNames.add(com.lowagie.text.pdf.interfaces.PdfVersion.class.getName());

        Log.debugf("OpenPDF Reflection: %s", classNames);
        // methods and fields
        reflectiveClass.produce(
                ReflectiveClassBuildItem.builder(classNames.toArray(new String[0])).methods().fields().build());
    }

    public List<String> collectSubclasses(CombinedIndexBuildItem combinedIndex, String className) {
        List<String> classes = combinedIndex.getIndex()
                .getAllKnownSubclasses(DotName.createSimple(className))
                .stream()
                .map(ClassInfo::toString)
                .collect(Collectors.toList());
        classes.add(className);
        return classes;
    }
}
