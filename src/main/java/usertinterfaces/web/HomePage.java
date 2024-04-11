package usertinterfaces.web;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;


@DefaultUrl("https://selenium.dev")
public class HomePage extends PageObject {
    public static final Target titulo_homepage = Target.the("Titulo de la pagina principal").located(By.xpath("//title[text()='Selenium']"));
    public static final Target documentacion_menuHeader = Target.the("Enlace a pagina de documentacion").located(By.xpath("//a[span[text()='Documentation']]"));

}
