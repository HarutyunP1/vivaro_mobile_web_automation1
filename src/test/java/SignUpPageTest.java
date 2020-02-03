import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignInPage;
import pages.SignUpPage;

public class SignUpPageTest extends TestBase {
    private SignUpPage signUpPage;
    private SignInPage signInPage;
    private String validMail = RandomStringUtils.randomAlphabetic(7) + "@bet.com";
    private String validPassword = RandomStringUtils.randomAlphabetic(2).toUpperCase() +
            RandomStringUtils.randomAlphabetic(2).toLowerCase() + RandomStringUtils.randomNumeric(5);
    private String validName = RandomStringUtils.randomAlphabetic(5);
    private String validLastName = RandomStringUtils.randomAlphabetic(5);
    private String validDocNumber = RandomStringUtils.randomNumeric(10, 11);
    private String validPhoneNumber = RandomStringUtils.randomNumeric(8);

    private String invalidMail = "@bet";
    private String invalidPassword = "1111";
    private String invalidName = "0";
    private String invalidLastName = "0";
    private String invalidDocNumber = RandomStringUtils.randomNumeric(26, 27);
    private String invalidPhoneNumber = "0000";

    @BeforeClass
    public void settingsUp() {
        signUpPage = new SignUpPage(driver);
        signInPage = new SignInPage(driver);
        signUpPage.openUrl(SignUpPage.url);
        if (signInPage.isPopUpPresent()) {
            signInPage.clickOnClosePopUpButton();
        }

    }

    @BeforeMethod
    public void openPage() {
        signUpPage.clickOnJoinButton();
    }

    @Test
    public void validRegistrationFirstStep() {
        fillInFieldsLogin(validMail, validPassword);
        Assert.assertTrue(signUpPage.isRegistrationSecondViewPresent(), "Registration First View present with valid parameters...");
    }
    @Test
    public void validRegistrationSecondStep() {
        fillInFieldsRegistration(validName, validLastName, validDocNumber, validPhoneNumber, true, true,true);
        Assert.assertTrue(signUpPage.isSuccessPopUpPresent(),"Success PopUp is not Present");
        signUpPage.clickOnClosePopUpButton();
        signInPage.clickOnLogOutButton();
    }

    @Test
    public void inValidRegistrationFirstStep() {
        fillInFieldsLogin(invalidMail, invalidPassword);
        Assert.assertTrue(signUpPage.isRegistrationFirstViewPresent(), " Registration First View  not present with invalid parameters...");
    }
    @Test
    public void inValidRegistrationSecondStep() {
        fillInFieldsRegistration(invalidName, invalidLastName, invalidDocNumber, invalidPhoneNumber, true, true,true);
        Assert.assertTrue(signUpPage.isRegistrationSecondViewPresent(), "Registration First View present with valid parameters...");
    }



    private void fillInFieldsLogin(String mail, String password) {
        if (!mail.isBlank())
            signUpPage.fillInEmailField(mail);
        if (!password.isBlank())
            signUpPage.fillInPassword(password);
        signUpPage.clickOnNextButton();

    }

    private void fillInFieldsRegistration(String name, String lastName, String docNumber, String phoneNumber,boolean phoneCode, boolean agree, boolean clickOnRegistrationButton) {
        fillInFieldsLogin(validMail, validPassword);
        if (!name.isBlank())
            signUpPage.fillInName(name);
        if (!lastName.isBlank())
            signUpPage.fillInLastName(lastName);
        if (!docNumber.isBlank())
            signUpPage.fillInDocNumber(docNumber);
        if (!phoneCode)
            signUpPage.clearPhoneCode();
        if (!phoneNumber.isBlank())
            signUpPage.fillInPhoneNumber(phoneNumber);
        if (agree)
            signUpPage.clickOnAgreeButton();
        if (clickOnRegistrationButton)
            signUpPage.clickOnRegisterButton();
    }

}
