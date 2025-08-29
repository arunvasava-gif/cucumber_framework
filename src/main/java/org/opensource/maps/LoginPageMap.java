package org.opensource.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageMap {
    @FindBy(xpath = "//input[@placeholder=\"E-Mail Address\"]")
    public WebElement emailInputBox;

    @FindBy(css = "input[placeholder=\"Password\"]")
    public WebElement passwordInputBox;

    @FindBy(css = "input[value=\"Login\"]")
    public WebElement loginButton;

    @FindBy(xpath = "//h2[text()=\"My Account\"]")
    public WebElement myAccountHeader;

    @FindBy(xpath = "//div[text()=\" Warning: No match for E-Mail Address and/or Password.\"]")
    public WebElement noMatchFoundMSG;
}
