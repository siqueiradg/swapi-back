package dev.swapi.model;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "dev.swapi", importOptions = ImportOption.DoNotIncludeTests.class)
public class ModelDTOArchTest {

    private static final String DTO_PACKAGE = "..model.dto.*";

    @ArchTest
    public static final ArchRule dtos_should_beNamedDTO =
            classes().that().resideInAPackage(DTO_PACKAGE).should().haveSimpleNameContaining("DTO");

    @ArchTest
    public static final ArchRule dtos_should_beInsideDTOPackage =
            classes().that().haveSimpleNameContaining("DTO").should().resideInAPackage(DTO_PACKAGE);
}
