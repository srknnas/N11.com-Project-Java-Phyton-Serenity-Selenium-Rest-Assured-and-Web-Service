package com.N11;


import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class User {

    WebDriver driver;
    MainPage MainPage;
    SignUpPage SignUpPage;
    WebServiceRestAssured WebServiceRestAssured;
    WebServiceJson WebServiceJson;

    public User() {
    }

    //Open Chrome Browser
    @Step
    public void openWebBrowser()
    {
        System.setProperty("webdriver.chrome.driver","C:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //Open N11 Main Page
    @Step
    public void openN11MainPage() {
        try {
            String url = "https://www.n11.com/";
            driver.navigate().to(url);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    //Control N11 Main Page Title
    @Step
    public void verifyN11MainPage() {
        try {
            String expectedTitle = "n11.com - Alışverişin Uğurlu Adresi";
            String title = driver.getTitle();

            Assert.assertEquals(title, expectedTitle);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    //Click Sign Up link on N11 Main Page
    @Step
    public void clickSignUpLinkOnMainPage() {
        try {
            MainPage = new MainPage(driver);
            MainPage.btnSingUp.click();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            Assert.assertTrue(false);
        }

    }

    //Fill all necessary place on Sign Up page
    @Step
    public void FillFormOnSignUpPage() {
        try {
            SignUpForm SignUpForm = new SignUpForm(driver);

            SignUpForm.ReadWebService();

            SignUpForm.writeFirstName();
            SignUpForm.writeLastName();
            SignUpForm.writeEmail();
            SignUpForm.writePassword();
            SignUpForm.writePasswordAgain();
            SignUpForm.writePhoneNumber();
            SignUpForm.selectGender();
            SignUpForm.writeBirthDay();
            SignUpForm.writeBirthMonth();
            SignUpForm.writeBirthYear();
            SignUpForm.acceptContract();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    //click sign up link on Sign Up page to finish becoming member procedure
    @Step
    public void ClickSignUpButton() {
        try {
            SignUpPage = new SignUpPage(driver);
            SignUpPage.submitButton.click();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    //Control web service is working or not and control status value in web service
    @Step
    public void WebServiceStatusControl() {
        try {
            WebServiceRestAssured = new WebServiceRestAssured();
            int control;
            String[] webServiceElementsArray = new String[12];
            control = WebServiceRestAssured.readWebService();

            if(control == 0)
                webServiceElementsArray = WebServiceRestAssured.getElementArray();

            if(webServiceElementsArray[10].contains("OK"))
                Assert.assertTrue(true);
            else
                Assert.assertTrue(false);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    //Control new member name and surname on main page
    @Step
    public void controlNewMemberOnMainPage() {
        try {
            MainPage = new MainPage(driver);
            WebServiceJson = new WebServiceJson();
            String myAccountName = MainPage.myAccount.getText();
            String firstName = WebServiceJson.getFirstName();
            String lastName = WebServiceJson.getLastName();
            Assert.assertTrue(myAccountName.equals(firstName + " " + lastName));
        }
        catch (Exception ex) {
            ex.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    //Close Browser
    @Step
    public void close() {
        driver.close();
    }
}
