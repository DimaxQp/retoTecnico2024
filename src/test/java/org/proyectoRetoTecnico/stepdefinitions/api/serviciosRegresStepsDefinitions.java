package org.proyectoRetoTecnico.stepdefinitions.api;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Steps;
import starter.ReqresAPI;
import starter.utils.constants.Constant;
import starter.utils.constants.ReqresResponses;

import java.io.File;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static org.hamcrest.Matchers.equalTo;

public class serviciosRegresStepsDefinitions {
    @Steps
    ReqresAPI reqresAPI;

    @Given("que se publica crear usuario con JSON válido")
    public void queSePublicaCrearUsuarioConJSONVálido() {
        File json = new File(Constant.JSON_REQUEST + "/RequestUser.json");
        reqresAPI.postCreateUser(json);
    }

    @When("se envía la solicitud para crear un usuario")
    public void seEnvíaLaSolicitudParaCrearUnUsuario() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @And("debería devolver el código de estado {int}")
    public void deberíaDevolverElCódigoDeEstado(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("el cuerpo de la respuesta debería tener el nombre {string} y el trabajo {string}")
    public void elCuerpoDeLaRespuestaDeberíaTenerElNombreYElTrabajo(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

    @Then("validar el esquema JSON para crear usuario")
    public void validarElEsquemaJSONParaCrearUsuario() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/CreateUserSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("que se obtiene la lista de usuarios con la página {int}")
    public void queSeObtieneLaListaDeUsuariosConLaPáginaPagina(int pagina) {
        reqresAPI.getListUsers(pagina);
    }

    @When("se envía la solicitud para obtener la lista de usuarios")
    public void seEnvíaLaSolicitudParaObtenerLaListaDeUsuarios() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USER);
    }

    @And("el cuerpo de la respuesta debería tener la página {int}")
    public void elCuerpoDeLaRespuestaDeberíaTenerLaPáginaPagina(int pagina) {
        SerenityRest.then()
                .body(ReqresResponses.PAGE, equalTo(pagina));
    }

    @Then("validar el esquema JSON de la lista de usuarios")
    public void validarElEsquemaJSONDeLaListaDeUsuarios() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/ListUserSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("que se actualiza un usuario con JSON válido con el ID {int}")
    public void queSeActualizaUnUsuarioConJSONVálidoConElID(int id) {
        File json = new File(Constant.JSON_REQUEST + "/RequestUser.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("se envía la solicitud para actualizar el usuario")
    public void seEnvíaLaSolicitudParaActualizarElUsuario() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @Then("validar el esquema JSON de actualización de usuario")
    public void validarElEsquemaJSONDeActualizaciónDeUsuario() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/UpdateUserSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

}

