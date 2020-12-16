package dev.swapi.mapper;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "dev.swapi", importOptions = ImportOption.DoNotIncludeTests.class)
public class MapperArchTest {

    private static final String MAPPER_PACKAGE = "dev.swapi.mapper";

    @ArchTest
    public static final ArchRule configs_should_beNamedMapper =
            classes().that().resideInAPackage(MAPPER_PACKAGE).should().haveSimpleNameContaining("Mapper");
}
