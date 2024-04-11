package usertinterfaces.web;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DocumentationPage extends PageObject {

    public static final Target elementoMenuSidebar(String busqueda){
        String xpathElementoMenuSidebar = String.format("//ul/li/ul/li[not(contains(@id,'m-documentationte'))]/a/span[text()='%s']",busqueda);
        return Target.the("Menu del navegador sidebar de la pagina documentacion")
                .located(By.xpath(xpathElementoMenuSidebar));
    }
    public static final Target tituloSeccion(String pagina){
        String xpathtituloSeccion = String.format("//h1[contains(text(),'%s')]",pagina);
        return Target.the("Titulo de seccion: "+pagina+" de la documentacion")
                .located(By.xpath(xpathtituloSeccion));
    }

    public static final Target campo_search = Target.the("Campo busqueda de la seccion documentacion")
            .located(By.xpath("//div[@id='docsearch-1']/button/span/span[text()='Search']"));
    public static final Target campo_searchModal = Target.the("Campo busqueda de la seccion documentacion tipo modal")
            .located(By.xpath("//input[@placeholder='Search docs']"));




}
