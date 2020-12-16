package dev.swapi.config;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.context.annotation.Configuration;

@AnalyzeClasses(packages = "dev.swapi", importOptions = DoNotIncludeTests.class)
public class ConfigArchTest {

    private static final String CONFIG_PACKAGE = "dev.swapi.config";

    @ArchTest
    public static final ArchRule configs_should_beNamedConfig =
            classes().that().resideInAPackage(CONFIG_PACKAGE).should().haveSimpleNameContaining("Config");

    @ArchTest
    public static final ArchRule configs_should_beAnnotatedWithConfiguration =
            classes()
                    .that()
                    .areInterfaces()
                    .and()
                    .resideInAPackage(CONFIG_PACKAGE)
                    .should()
                    .beAnnotatedWith(Configuration.class);
}

