package com.N11;

import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SignUpForm {

    WebDriver driver;
    SignUpPage SignUpPage;
    WebServiceJson WebServiceJson;

    public SignUpForm(WebDriver driver){

        //Initialize my objects in the page
        this.driver = driver;
        PageFactory.initElements(driver, this);

        SignUpPage = new SignUpPage(driver);
    }

    //Read from web service
    public void ReadWebService()
    {
        try
        {
            WebServiceJson = new WebServiceJson();
            WebServiceJson.ReadWebService();
        }
        catch (JSONException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}
    }

    //Fill Sign Up form with data getting from web service
    public void writeFirstName()
    {
        SignUpPage.firstName.sendKeys(WebServiceJson.getFirstName());
    }

    public void writeLastName()
    {
        SignUpPage.lastName.sendKeys(WebServiceJson.getLastName());
    }

    public void writeEmail()
    {
        SignUpPage.registrationEmail.sendKeys(WebServiceJson.getEmail());
    }

    public void writePassword()
    {
        SignUpPage.registrationPassword.sendKeys(WebServiceJson.getPassword());
    }

    public void writePasswordAgain()
    {
        SignUpPage.passwordAgain.sendKeys(WebServiceJson.getPasswordAgain());
    }

    public void selectGender()
    {
        String gender = WebServiceJson.getGender();
        if(gender.contains("Male"))
            SignUpPage.genderMale.click();
        else
            SignUpPage.genderFemale.click();
    }

    public void writePhoneNumber()
    {
        SignUpPage.phoneNumber.sendKeys(WebServiceJson.getPhoneNumber());
    }

    public void writeBirthDay()
    {
        SignUpPage.birthDay.sendKeys(WebServiceJson.getBirthDay());
    }

    public void writeBirthMonth()
    {
        SignUpPage.birthMonth.sendKeys(WebServiceJson.getBirthMonth());
    }

    public void writeBirthYear()
    {
        SignUpPage.birthYear.sendKeys(WebServiceJson.getBirthYear());
    }

    public void acceptContract()
    {
        SignUpPage.acceptContract.click();
    }
}
