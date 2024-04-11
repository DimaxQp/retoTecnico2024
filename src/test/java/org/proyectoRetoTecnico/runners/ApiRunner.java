package org.proyectoRetoTecnico.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = "org.proyectoRetoTecnico.stepdefinitions.api",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty", "html:target/Informe_PruebasAPI.html"},
        tags = "@api"
)
public class ApiRunner {
}