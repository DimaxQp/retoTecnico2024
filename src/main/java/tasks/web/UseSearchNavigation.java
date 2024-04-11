package tasks.web;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static usertinterfaces.web.DocumentationPage.campo_search;
import static usertinterfaces.web.DocumentationPage.campo_searchModal;

public class UseSearchNavigation implements Task {
    private String pagina;
    public UseSearchNavigation(String pagina){
        this.pagina = pagina;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(campo_search),
                Enter.theValue(pagina).into(campo_searchModal),
                Hit.the(Keys.ENTER).into(campo_searchModal)
        );
    }
    public static UseSearchNavigation realizarBusqueda(String pagina){
        return instrumented(UseSearchNavigation.class, pagina);
    }
}
