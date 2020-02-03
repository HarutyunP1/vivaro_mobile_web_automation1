package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignInPage extends BasePage {

    /**
     * Constructor
     *
     * @param driver
     */
    public SignInPage(AppiumDriver driver) {
        super(driver);
    }

    public static final String url = "https:/m.vivarobet.am/";

    @Override
    public void openUrl(String url) {
        driver.navigate().to(url);
    }

    @FindBy(css = "label.right-top-nav-new-h")
    private List<WebElement> joinAndLoginButtons;
    @FindBy(css = "div[class='download-links'] button[class='button-view-normal-m trans-m']")
    private WebElement popUpCloseButton;
    @FindBy(css = "button.popup-closed-b")
    private WebElement popUpContainer;
    @FindBy(css = "input[name='login-name']")
    private WebElement usernameField;
    @FindBy(css = "input[name='password']")
    private WebElement passwordField;
    @FindBy(css = "div.login-error")
    private WebElement loginError;
    @FindBy(css = "span.home-user-icon")
    private WebElement userIcon;
    @FindBy(css = "div.log-out-b-m")
    private WebElement logOutButton;
    @FindBy(css = "div.forgot-password-m")
    private WebElement forgotPasswordButton;
    @FindBy(css = "div.ver-center-view-b")
    private WebElement forgotPasswordPopUp;
    @FindBy(css = "label[for='remember']")
    private WebElement rememberMeButton;
    @FindBy(css = "button[class='button-view-normal-m trans-m']")
    private WebElement joinNowButton;
    @FindBy(css = "button[class='button-view-normal-m']")
    private WebElement logInButton;
    @FindBy(css = "div[class='popup-contain-table-m login-form-m registration-form-b multistep-form first']")
    private WebElement signInPagePopUp;
    @FindBy(css = "button[class='button-view-normal-m trans-m']")
    private WebElement recaptchaInfo;

    public void clickOnClosePopUpButton() {
        popUpCloseButton.click();
    }

    public boolean isPopUpPresent() {
        try {
            return popUpContainer.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickOnForgotPasswordButton() {
        forgotPasswordButton.click();
    }

    public void clickOnMainPageLogInButton() {
        joinAndLoginButtons.get(1).click();
    }

    public void clickOnLoginButton() {
     logInButton.click();

    }

    public void fillInUsernameField(String mail) {
        usernameField.sendKeys(mail);
        hideKeyboard();
    }

    public void fillInPasswordField(String password) {
        passwordField.sendKeys(password);
        hideKeyboard();
    }

    public void clickOnUserIcon() {
        userIcon.click();
    }


    public boolean isDisplayUserIcon() {
        return userIcon.isDisplayed();

    }

    public boolean isPresentErrorMessage() {
        return loginError.isDisplayed();
    }

    public void clickOnLogOutButton() {
        logOutButton.click();
    }

    public boolean isPresentForgotPasswordPopUp() {
        return forgotPasswordPopUp.isDisplayed();
    }
    public boolean isPresentRememberMeButton(){
        return rememberMeButton.isDisplayed();
    }
    public void clickOnJoinNowButton(){
        joinNowButton.click();
    }
    public boolean isPresentSignUpPagePopUp(){
        return signInPagePopUp.isDisplayed();

    }
    public boolean isPresentRecaptchaInfoText(){
        return recaptchaInfo.isDisplayed();
    }

}
