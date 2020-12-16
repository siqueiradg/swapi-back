package dev.swapi.controller;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.web.bind.annotation.RestController;

@AnalyzeClasses(packages = "dev.swapi", importOptions = DoNotIncludeTests.class)
public class ControllerArchTest {

    private static final String CONTROLLER_PACKAGE = "..controller";
    private static final String CONFIG_PACKAGE = "..config";
    private static final String MODEL_PACKAGE = "..model";
    private static final String REPOSITORY_PACKAGE = "..repository";

    @ArchTest
    public static final ArchRule controllers_should_be_named_controller =
            classes()
                    .that()
                    .resideInAPackage(CONTROLLER_PACKAGE)
                    .should()
                    .haveSimpleNameContaining("Controller");

    @ArchTest
    public static final ArchRule controller_should_be_annotatedWithController =
            classes()
                    .that()
                    .resideInAPackage(CONTROLLER_PACKAGE)
                    .should()
                    .beAnnotatedWith(RestController.class);

    @ArchTest
    public static final ArchRule controller_should_not_dependsOnRepositoryClientAndModel =
            noClasses()
                    .that()
                    .resideInAPackage(CONTROLLER_PACKAGE)
                    .should()
                    .dependOnClassesThat()
                    .resideInAnyPackage(CONFIG_PACKAGE, REPOSITORY_PACKAGE, MODEL_PACKAGE);
}

