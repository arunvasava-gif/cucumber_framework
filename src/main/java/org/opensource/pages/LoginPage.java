package org.opensource.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.opensource.base.BaseClass;
import org.opensource.maps.LoginPageMap;

import java.time.Duration;

public class LoginPage{
    private WebDriver driver;
    private LoginPageMap loginPageMap;
    WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(10));

    public LoginPage(){
        this.driver = BaseClass.getDriver();
        this.loginPageMap = new LoginPageMap();
        PageFactory.initElements(driver,loginPageMap);
    }
    public void enterUserEmail(String usrName)throws NullPointerException{
        loginPageMap.emailInputBox.sendKeys(usrName);
    }
    public void enterPassword(String pswd)throws NullPointerException{
        loginPageMap.passwordInputBox.sendKeys(pswd);
    }
    public void clickOnLoginButton(){
        loginPageMap.loginButton.click();
    }
    public void waitForMyAccHeader() {
        wait.until(ExpectedConditions.visibilityOf(loginPageMap.myAccountHeader));
    }
    public void checkInvalidUserWarning(){
        wait.until(ExpectedConditions.visibilityOf(loginPageMap.noMatchFoundMSG));
    }
}
