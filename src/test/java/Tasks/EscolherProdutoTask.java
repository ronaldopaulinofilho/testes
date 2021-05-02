package Tasks;

import FrameWork.Report.Report;
import FrameWork.Report.ScreenShot;
import PageObjects.DetailsPage;
import PageObjects.EscolherProdutoPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class EscolherProdutoTask {

    private static WebDriver driver;
    private static EscolherProdutoPage escolherProduto;
    private static DetailsPage detailsPage;

    public EscolherProdutoTask(WebDriver driver) {

        this.driver = driver;
        escolherProduto = new EscolherProdutoPage(this.driver);
       detailsPage = new DetailsPage(this.driver);
    }

    public void escolherProduto(){

        escolherProduto.getProdutoLinkImage().click();
        validaSelecaoProduto();

    }

    private void validaSelecaoProduto(){
        try{
            Assertions.assertTrue(detailsPage.getProductCarLabel().isDisplayed());
            Report.extentTest.log(Status.PASS, "Item selecionado com sucesso", ScreenShot.base64(driver));

        } catch (Exception e){
            Report.extentTest.log(Status.FAIL, "Não foi selecionado nenhum Produto", ScreenShot.base64(driver));
        }
    }

}
