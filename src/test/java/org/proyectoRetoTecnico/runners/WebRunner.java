package org.proyectoRetoTecnico.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/web",
        glue = "org.proyectoRetoTecnico.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty", "html:target/Informe_PruebasWEB.html"},
        tags = "@web"
)
public class WebRunner {
}