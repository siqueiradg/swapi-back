package dev.swapi.service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Service;

@AnalyzeClasses(packages = "dev.swapi", importOptions = DoNotIncludeTests.class)
public class ServiceArchTest {

    private static final String SERVICE_PACKAGE = "..service";

    @ArchTest
    public static final ArchRule services_should_be_named_service =
            classes()
                    .that()
                    .resideInAPackage(SERVICE_PACKAGE)
                    .should()
                    .haveSimpleNameContaining("Service");

    @ArchTest
    public static final ArchRule service_should_be_annotatedWithService =
            classes()
                    .that()
                    .resideInAPackage(SERVICE_PACKAGE)
                    .should()
                    .beAnnotatedWith(Service.class);
}



