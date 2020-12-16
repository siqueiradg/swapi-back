package dev.swapi.utils;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Component;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "dev.swapi", importOptions = DoNotIncludeTests.class)
public class UtilsArchTest {

    private static final String UTILS_PACKAGE = "..utils";

    @ArchTest
    public static final ArchRule utils_should_be_named_utils =
            classes()
                    .that()
                    .resideInAPackage(UTILS_PACKAGE)
                    .should()
                    .haveSimpleNameContaining("Util");

    @ArchTest
    public static final ArchRule utils_should_be_annotatedWithComponent =
            classes()
                    .that()
                    .resideInAPackage(UTILS_PACKAGE)
                    .should()
                    .beAnnotatedWith(Component.class);
}



