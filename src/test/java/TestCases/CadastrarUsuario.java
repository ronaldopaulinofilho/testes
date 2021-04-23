package TestCases;

import FrameWork.BaseTest;
import FrameWork.Report.Report;
import FrameWork.Report.ScreenShot;
import Tasks.FormularioTask;
import Tasks.HomeTask;
import Tasks.MenuFormTask;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class CadastrarUsuario extends BaseTest {

    private WebDriver driver = this.getDriver();
    private HomeTask homeTask = new HomeTask(driver);
    private MenuFormTask menuFormTask = new MenuFormTask(driver);
    private FormularioTask formularioTask = new FormularioTask(driver);

    @Test
    public void realizarCadastro(){
        try {
            Report.startReport("Cadastrando novo usuário");
            homeTask.acessarPageAutomacaoWeb();
            menuFormTask.acessarFormulario();
            formularioTask.preencheFormulario();
        } catch (Exception e) {
            Report.extentTest.log(Status.ERROR, e.getMessage(), ScreenShot.base64(driver));
        }
    }
}
