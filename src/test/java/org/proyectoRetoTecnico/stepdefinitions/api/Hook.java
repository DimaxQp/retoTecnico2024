package org.proyectoRetoTecnico.stepdefinitions.api;


import io.cucumber.java.Before;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class Hook {
    private EnvironmentVariables environmentVariables;

    @Before
    public void configureBaseUrl(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Reqres");
        String theRestApiBaseUrl = String.valueOf(environmentVariables.optionalProperty("environments.global.base.url"));
        OnStage.theActorInTheSpotlight().whoCan(CallAnApi.at(theRestApiBaseUrl));
    }
}
