package dev.swapi.repository;

import com.tngtech.archunit.core.importer.ImportOption.DoNotIncludeTests;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Repository;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "dev.swapi", importOptions = DoNotIncludeTests.class)
public class RepositoryArchTest {

    private static final String REPOSITORY_PACKAGE = "..repository";

    @ArchTest
    public static final ArchRule repository_should_be_named_repository =
            classes()
                    .that()
                    .resideInAPackage(REPOSITORY_PACKAGE)
                    .should()
                    .haveSimpleNameContaining("Repository");

    @ArchTest
    public static final ArchRule repository_should_be_annotatedWithRepository =
            classes()
                    .that()
                    .resideInAPackage(REPOSITORY_PACKAGE)
                    .should()
                    .beAnnotatedWith(Repository.class);
}



