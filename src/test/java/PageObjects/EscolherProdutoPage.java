package PageObjects;

import FrameWork.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EscolherProdutoPage {

    private WebDriver driver;
    private Waits wait;

    public EscolherProdutoPage(WebDriver driver) {
        wait = new Waits(driver);
        this.driver = driver;
    }

    public WebElement getHomeLabelText(){

        return driver.findElement(By.xpath("//div[@id='inventory_filter_container']/div[@class='product_label']"));
    }

    public WebElement getProdutoLinkImage(){

        return  driver.findElement(By.id("item_4_title_link"));
    }
}
