package Tasks;

import FrameWork.Browser.Waits;
import FrameWork.Report.Report;
import FrameWork.Report.ScreenShot;
import PageObjects.FinishPage;
import PageObjects.LoginPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class FinishTask {

    private static WebDriver driver;
    private static FinishPage finishPage;
    private static LoginPage loginPage;
    private static Waits wait;

    public FinishTask(WebDriver driver) {

        this.driver = driver;
        finishPage = new FinishPage(this.driver);
        loginPage = new LoginPage(this.driver);
        wait = new Waits(this.driver);
    }

    public void finalizarCompra(){

        validaCompra();
        finishPage.getMenuLogoutButton().click();
        wait.loadElement(finishPage.getLogoutButton());
        finishPage.getLogoutButton().click();
        validaLogout();


    }

    private void validaCompra() {
        try {
            Assertions.assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!",finishPage.getFinishtextLabel().getText());
            Report.extentTest.log(Status.PASS, "Compra finalizada com sucesso", ScreenShot.base64(driver));
        } catch (Exception e) {
            Report.extentTest.log(Status.FAIL, "Compra não realizada com sucesso", ScreenShot.base64(driver));
        }

    }

    private void validaLogout(){
        try {
            wait.loadElement(loginPage.getLogoImage());
            Assertions.assertTrue(loginPage.getLogoImage().isDisplayed());
            Report.extentTest.log(Status.PASS,"Logout realizado com suscesso", ScreenShot.base64(driver));
        }catch (Exception e ){
            Report.extentTest.log(Status.FAIL, "Logout não foi realizado", ScreenShot.base64(driver));
        }
    }

}
