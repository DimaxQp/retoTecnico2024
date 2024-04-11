package tasks.web;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static usertinterfaces.web.DocumentationPage.elementoMenuSidebar;

public class UseSidebarMenu implements Task {
    private final String busqueda;
    public UseSidebarMenu(String busqueda){
        this.busqueda = busqueda;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(elementoMenuSidebar(busqueda))
        );
    }
    public static UseSidebarMenu clickLink(String busqueda) {
        return instrumented(UseSidebarMenu.class, busqueda);
    }
}
