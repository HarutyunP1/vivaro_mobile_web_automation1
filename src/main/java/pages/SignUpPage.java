package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignUpPage extends BasePage {
    /**
     * Constructor
     *
     * @param driver
     */
    public static final String url = "https:/www.vivarobet.am/";

    public SignUpPage(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public void openUrl(String url) {
        driver.get(url);
    }

    @FindBy(css = "label.right-top-nav-new-h")
    private List<WebElement> joinAndLoginButtons;
    @FindBy(css = "button[class='button-view-normal-m']")
    private WebElement nextButton;
    @FindBy(css = "button[class='button-view-normal-m trans-m-s-i']")
    private WebElement signInButton;
    @FindBy(css = "input[name='email']")
    private WebElement mailField;
    @FindBy(css = "input[type='password']")
    private WebElement passwordField;
    @FindBy(css = "input[name='first_name']")
    private WebElement firstNameField;
    @FindBy(css = "input[name='last_name']")
    private WebElement lastNameField;
    @FindBy(css = "input[name='doc_number']")
    private WebElement docNumberField;
    @FindBy(css = "input[name='phone']")
    private WebElement phoneNumberField;
    @FindBy(css = "input[name='phone_code']")
    private WebElement phoneCodeField;
    @FindBy(css = "label.checkbox-wrapper-m span")
    private WebElement agreeButton;
    @FindBy(css = "button[class='button-view-normal-m']")
    private List<WebElement> backAndRegisterButton;
    @FindBy(css = "div[class='title-popup-page-m']")
    private WebElement successPopUp;
    @FindBy(css = "button[class='popup-closed-b']")
    private WebElement successPopUpCloseButton;
    @FindBy(css = "div[class='home-wrapper-login-block'")
    private WebElement userSettingsButton;


    public void clickOnJoinButton() {
        joinAndLoginButtons.get(0).click();
    }

    public void fillInEmailField(String mail) {
        mailField.sendKeys(mail);
        hideKeyboard();
    }

    public void fillInPassword(String password) {
        passwordField.sendKeys(password);
        hideKeyboard();
    }

    public void clickOnNextButton() {
        nextButton.click();
    }

    public void fillInName(String name) {
        firstNameField.sendKeys(name);
    }

    public void fillInLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void fillInDocNumber(String docnumber) {
        docNumberField.sendKeys(docnumber);
    }

    public void fillInPhoneNumber(String phoneNumber) {
        phoneNumberField.sendKeys(phoneNumber);
        hideKeyboard();
    }

    public void clickOnAgreeButton() {
        agreeButton.click();
    }

    public void clickOnRegisterButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", backAndRegisterButton.get(1));
        backAndRegisterButton.get(1).click();

    }

    public void clearPhoneCode() {
        phoneCodeField.clear();
    }

    public boolean isRegistrationSecondViewPresent() {
        return phoneNumberField.isDisplayed();
    }

    public boolean isRegistrationFirstViewPresent() {
        return mailField.isDisplayed();
    }

    public boolean isSuccessPopUpPresent() {
        return successPopUp.isDisplayed();
    }

    public void clickOnClosePopUpButton() {
        successPopUpCloseButton.click();
    }


}
