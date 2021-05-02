package Tasks;

import FrameWork.Report.Report;
import FrameWork.Report.ScreenShot;
import PageObjects.CartPage;
import PageObjects.DetailsPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class DetailsTask {

    private static WebDriver driver;
    private static DetailsPage detailsPage;
    private static CartPage carrinhoPage;

    public DetailsTask(WebDriver driver) {

        this.driver = driver;
        detailsPage = new DetailsPage(this.driver);
        carrinhoPage = new CartPage(this.driver);
    }

    public void addToCart(){

        detailsPage.getAddCartButton().click();
        detailsPage.getCartButton().click();
        validaCarrinho();


    }

    private void validaCarrinho(){

        try{
            String label = carrinhoPage.getPageLabel().getText();
            Assertions.assertEquals(label, "Your Cart");
            Report.extentTest.log(Status.INFO,"Pagina Carrinho Carregada", ScreenShot.base64(driver));
        }catch (Exception e){

            Report.extentTest.log(Status.FAIL,"Produto não foi adicionado no carrinho", ScreenShot.base64(driver));

        }


    }

}
