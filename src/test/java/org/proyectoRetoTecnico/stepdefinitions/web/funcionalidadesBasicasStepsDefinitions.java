package org.proyectoRetoTecnico.stepdefinitions.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import tasks.web.UseMenuHeader;
import tasks.web.UseSearchNavigation;
import tasks.web.UseSidebarMenu;
import usertinterfaces.web.HomePage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static usertinterfaces.web.DocumentationPage.tituloSeccion;
import static usertinterfaces.web.HomePage.titulo_homepage;

public class funcionalidadesBasicasStepsDefinitions {
    @Managed(driver = "chrome")
    private WebDriver navegador;
    private final Actor actor = Actor.named("Global");
    private final HomePage homePage = new HomePage();

    @When("que el usuario ingresa a la pagina principal")
    public void queElUsuarioIngresaALaPaginaPrincipal() {
        actor.can(BrowseTheWeb.with(navegador));
        actor.wasAbleTo(Open.browserOn(homePage));
    }

    @Then("valida que la web funciona correctamente")
    public void validaQueLaWebFuncionaCorrectamente() {
        actor.should(seeThat(the(titulo_homepage), isPresent()));
    }

    @And("ingresa a la pagina documentacion")
    public void ingresaALaPaginaDocumentacion() {
        actor.wasAbleTo(
                UseMenuHeader.irDocumentacion()
        );
    }

    @And("selecciona un articulo del navegador {string}")
    public void seleccionaUnArticuloDelNavegador(String busqueda) {
        actor.wasAbleTo(
                UseSidebarMenu.clickLink(busqueda)
        );
    }

    @Then("Verifica que la redireccion a la pagina {string} funciona correctamente")
    public void verificaQueLaRedireccionALaPaginaFuncionaCorrectamente(String pagina) {
        actor.should(seeThat(the(tituloSeccion(pagina)), isPresent()));
    }

    @And("realiza una busqueda con la palabra {string}")
    public void realizaUnaBusquedaConLaPalabra(String pagina) {
        actor.wasAbleTo(
                UseSearchNavigation.realizarBusqueda(pagina)
        );
    }


}
