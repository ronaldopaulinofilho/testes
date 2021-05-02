package Tasks;

import FrameWork.Report.Report;
import FrameWork.Report.ScreenShot;
import PageObjects.EscolherProdutoPage;
import PageObjects.LoginPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoginTask {

    private static WebDriver driver;
    private static LoginPage login;
    private static EscolherProdutoPage escolherProduto;

    public LoginTask(WebDriver driver) {

        this.driver = driver;
        login = new LoginPage(this.driver);
        escolherProduto = new EscolherProdutoPage(this.driver);
    }

    public void realizarLogin(){

        login.getUsernameTextField().sendKeys("standard_user");
        login.getPasswordTextField().sendKeys("secret_sauce");
        login.getLoginButton().click();
        validaLogin();

    }

    public void realizarLoginParametrizado(String usuario, String senha){

        login.getUsernameTextField().sendKeys(usuario);
        login.getPasswordTextField().sendKeys(senha);
        login.getLoginButton().click();
        validaLogin();

    }

    private void validaLogin() {
        try {
            String label = escolherProduto.getHomeLabelText().getText();
            Assertions.assertEquals(label, "Products");
            Report.extentTest.log(Status.PASS, "Login Realizado : " + label, ScreenShot.base64(driver));
        } catch (Exception e) {

            Report.extentTest.log(Status.FAIL, "Login Falhou", ScreenShot.base64(driver));
        }
    }
}
