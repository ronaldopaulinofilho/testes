package TestCases;

import FrameWork.BaseTest;
import FrameWork.Report.Report;
import FrameWork.Report.ScreenShot;
import Tasks.*;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class BuyWithSuccessTest extends BaseTest {

    private WebDriver driver = this.getDriver();

    LoginTask login = new LoginTask(driver);
    EscolherProdutoTask produto = new EscolherProdutoTask(driver);
    DetailsTask  detailsProduto= new DetailsTask(driver);
    CartTask cart = new CartTask(driver);
    InformationTask information = new InformationTask(driver);
    FinishTask finish = new FinishTask(driver);


    @Test
    public void BuyWithSuccessTest(){

        try {

            Report.startReport("Buy with Sucess");

            login.realizarLogin();
            produto.escolherProduto();
            detailsProduto.addToCart();
            cart.realizarChekout();
            information.preencherInformacoes();
            finish.finalizarCompra();


        }catch (Exception e){

            Report.extentTest.log(Status.ERROR, e.getMessage(), ScreenShot.base64(driver));

        }


    }

}
