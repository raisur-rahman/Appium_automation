package tests;

import base.BaseTest;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
public class OpenToHomeTest extends BaseTest {

    @Test
    public void testOpenAppToHome() {
        verifySplashPage();
        goToGetStarted();
        acceptTerms();
        selectCountry("India");
        selectClinic("Goa");
        enterPhoneNumber("9873243");
        enterName("Dr. Raisur");
        createPin("1234");
        confirmPin("1234");
        skipLocationAccess();
        enterFacility();
        skipVideo();
        verifyMainPage();
    }

    @Step("Verify Splash Page opened")
    private void verifySplashPage() {
        SplashPage splashPage = new SplashPage(driver);
        Assert.assertTrue(splashPage.isLogoVisible(), "❌ Splash Page did not open.");
        splashPage.tapOnNext();
    }

    @Step("Tap on Get Started")
    private void goToGetStarted() {
        GetStartedPage getStartedPage = new GetStartedPage(driver);
        Assert.assertTrue(getStartedPage.isPageOpened(), "❌ Get Started Page did not open.");
        getStartedPage.tapOnGetStarted();
    }

    @Step("Accept Terms and Conditions")
    private void acceptTerms() {
        TnCPage tncPage = new TnCPage(driver);
        Assert.assertTrue(tncPage.isPageOpened(), "❌ T&C Page did not open.");
        tncPage.acceptTnC();
    }

    @Step("Select Country: {country}")
    private void selectCountry(String country) {
        CountryPage countryPage = new CountryPage(driver);
        Assert.assertTrue(countryPage.isPageOpened(), "❌ Country Page did not open.");
        countryPage.selectCountry(country);
    }

    @Step("Select Clinic: {clinic}")
    private void selectClinic(String clinic) {
        ClinicPage clinicPage = new ClinicPage(driver);
        Assert.assertTrue(clinicPage.isPageOpened(), "❌ Clinic Page did not open.");
        clinicPage.selectClinicLocation(clinic);
    }

    @Step("Enter Phone Number: {phone}")
    private void enterPhoneNumber(String phone) {
        PhonePage phonePage = new PhonePage(driver);
        Assert.assertTrue(phonePage.isPageOpened(), "❌ Phone Page did not open.");
        phonePage.enterNumber(phone);
        phonePage.tapOnNext();
    }

    @Step("Enter Full Name: {name}")
    private void enterName(String name) {
        NamePage namePage = new NamePage(driver);
        Assert.assertTrue(namePage.isPageOpened(), "❌ Name Page did not open.");
        namePage.enterName(name);
        namePage.tapOnNext();
    }

    @Step("Create PIN: {pin}")
    private void createPin(String pin) {
        CreatePinPage createPinPage = new CreatePinPage(driver);
        Assert.assertTrue(createPinPage.isPageOpened(), "❌ Create PIN Page did not open.");
        createPinPage.createPIN(pin);
    }

    @Step("Confirm PIN: {pin}")
    private void confirmPin(String pin) {
        ConfirmPinPage confirmPinPage = new ConfirmPinPage(driver);
        Assert.assertTrue(confirmPinPage.isPageOpened(), "❌ Confirm PIN Page did not open.");
        confirmPinPage.confirmPIN(pin);
    }

    @Step("Skip Location Access")
    private void skipLocationAccess() {
        LocationAccessPage locationAccessPage = new LocationAccessPage(driver);
        Assert.assertTrue(locationAccessPage.isPageOpened(), "❌ Location Access Page did not open.");
        locationAccessPage.tapOnSkip();
    }

    @Step("Enter Facility:")
    private void enterFacility() {
        FacilityNamePage facilityNamePage = new FacilityNamePage(driver);
        Assert.assertTrue(facilityNamePage.isPageOpened(), "❌ Facility Name Page did not open.");
        facilityNamePage.enterFacilityName();
        facilityNamePage.tapYes();
    }

    @Step("Skip Video Page")
    private void skipVideo() {
        VideoPage videoPage = new VideoPage(driver);
        Assert.assertTrue(videoPage.isPageOpened(), "❌ Video Page did not open.");
        videoPage.tapOnSkip();
    }

    @Step("Verify Main (Home) Page is opened")
    private void verifyMainPage() {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isPageOpened(), "❌ Main Page did not open.");
    }
}
