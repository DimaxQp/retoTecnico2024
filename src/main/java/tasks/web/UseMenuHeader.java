package tasks.web;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static usertinterfaces.web.HomePage.documentacion_menuHeader;

public class UseMenuHeader implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(documentacion_menuHeader)
        );
    }
    public static UseMenuHeader irDocumentacion() {
        return instrumented(UseMenuHeader.class);
    }
}
