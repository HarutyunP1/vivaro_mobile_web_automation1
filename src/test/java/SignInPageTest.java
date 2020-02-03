import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignInPage;

public class SignInPageTest extends TestBase {
    private SignInPage signInPage;

    private final String username = "harut0808";
    private final String password = "Joker008";
    private final String invalidUsername = "invalidUsername";
    private final String invalidPassword = "invalidPassword";

    @BeforeClass
    public void settingsUp() {
        signInPage = new SignInPage(driver);
        signInPage.openUrl(SignInPage.url);
        if (signInPage.isPopUpPresent()) {
            signInPage.clickOnClosePopUpButton();

        }
    }

    @BeforeMethod
    public void openPage() {
        signInPage.clickOnMainPageLogInButton();
    }

    @Test
    public void signInWithValidCredentials() {
        fillInSignPage(username, password);
        Assert.assertTrue(signInPage.isDisplayUserIcon(), "UserName not Present with valid Credentials...");
        signInPage.clickOnUserIcon();
        signInPage.clickOnLogOutButton();
    }
    @Test
    public void signInWithInValidCredentials() {
        fillInSignPage(invalidUsername, invalidPassword);
        Assert.assertTrue(signInPage.isPresentErrorMessage(), "Error message is not Present with invalid Credentials...");
    }

    @Test
    public void isPresentForgotPasswordPopUp() {
        signInPage.clickOnForgotPasswordButton();
        Assert.assertTrue(signInPage.isPresentForgotPasswordPopUp(), "Forgot password popUp is not present");
    }
    @Test
    public void isPresentRememberMeButton(){
        Assert.assertTrue(signInPage.isPresentRememberMeButton(),"Remember me button is not present");
    }
    @Test
    public void redirectionJoinNowButton(){
      signInPage.clickOnJoinNowButton();
      Assert.assertTrue(signInPage.isPresentSignUpPagePopUp(),"SignInPagePopUp not present");

    }
    @Test
    public void isPresentRecaptchaInfoTest(){
        Assert.assertTrue(signInPage.isPresentRecaptchaInfoText(),"Recaptcha Info Text not present");
    }


    private void fillInSignPage(String username, String password) {
        if (!username.isBlank())
            signInPage.fillInUsernameField(username);
        if (!password.isBlank())
            signInPage.fillInPasswordField(password);
        signInPage.clickOnLoginButton();

    }
}
