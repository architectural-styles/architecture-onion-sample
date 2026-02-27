package com.application.onion.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.application.onion")
class OnionArchitectureTest {

    @ArchTest
    static final ArchRule domainShouldNotDependOnAnything =
            noClasses()
                    .that().resideInAPackage("com.application.onion.domain..")
                    .should().dependOnClassesThat()
                    .resideInAnyPackage(
                            "com.application.onion.application..",
                            "com.application.onion.infrastructure.."
                    );

    @ArchTest
    static final ArchRule applicationShouldNotDependOnInfrastructure =
            noClasses()
                    .that().resideInAPackage("com.application.onion.application..")
                    .should().dependOnClassesThat()
                    .resideInAPackage("com.application.onion.infrastructure..");

    @ArchTest
    static final ArchRule infrastructureShouldNotDependOnServiceImpl =
            noClasses()
                    .that().resideInAPackage("com.application.onion.infrastructure..")
                    .should().dependOnClassesThat()
                    .resideInAPackage("com.application.onion.application.service..");

    @ArchTest
    static final ArchRule inAdaptersShouldNotDependOnOutAdapters =
            noClasses()
                    .that().resideInAPackage("com.application.onion.infrastructure.adapter.in..")
                    .should().dependOnClassesThat()
                    .resideInAPackage("com.application.onion.infrastructure.adapter.out..");

    @ArchTest
    static final ArchRule outAdaptersShouldNotDependOnInAdapters =
            noClasses()
                    .that().resideInAPackage("com.application.onion.infrastructure.adapter.out..")
                    .should().dependOnClassesThat()
                    .resideInAPackage("com.application.onion.infrastructure.adapter.in..");
}