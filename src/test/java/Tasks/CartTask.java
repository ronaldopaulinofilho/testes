package Tasks;

import FrameWork.Report.Report;
import FrameWork.Report.ScreenShot;
import PageObjects.CartPage;
import PageObjects.InformationPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class CartTask {

    private static WebDriver driver;
    private static InformationPage informationPage;
    private static CartPage cartPage;

    public CartTask(WebDriver driver) {

        this.driver = driver;
        informationPage = new InformationPage(this.driver);
        cartPage = new CartPage(this.driver);
    }

    public void realizarChekout() throws IOException {

        validaItemCarrinho();
        cartPage.getCheckoutButton().click();
        validaPageInformacoes();
    }

    private void validaItemCarrinho() throws IOException {
        try{
            Assertions.assertTrue(cartPage.getProductLabel().isEnabled());
            Assertions.assertEquals(cartPage.getProductLabel().getText(), "Sauce Labs Backpack");
            Report.extentTest.log(Status.PASS, "Produto adicionado ao carrinho com sucesso", ScreenShot.base64(driver));

        }catch (Exception e){

            Report.extentTest.log(Status.FAIL, "Produto nao foi adicionado com sucesso", ScreenShot.base64(driver));
        }
    }

    private void validaPageInformacoes() {

        try {
            Assertions.assertEquals(cartPage.getPageLabel().getText(), "Checkout: Your Information");
            Report.extentTest.log(Status.PASS, "Pagina Informacoes Carregada", ScreenShot.base64(driver));

        } catch (Exception e) {

            Report.extentTest.log(Status.FAIL, "Pagina Informacoes nao Carregada", ScreenShot.base64(driver));
        }
    }


    }
