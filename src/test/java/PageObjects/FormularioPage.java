package PageObjects;

import FrameWork.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormularioPage {

    private WebDriver driver;
    private Waits waits;

    public FormularioPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getNomeTextField() {

        return this.driver.findElement(By.id("user_name"));
    }

    public WebElement getUltimoNomeTextField() {

        return this.driver.findElement(By.id("user_lastname"));
    }

    public WebElement getpostalCode() {

        return this.driver.findElement(By.id("postal-code"));
    }


}
