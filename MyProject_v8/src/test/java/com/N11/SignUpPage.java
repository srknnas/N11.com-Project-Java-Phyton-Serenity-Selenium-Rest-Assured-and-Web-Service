package com.N11;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class SignUpPage extends PageObject{

    WebServiceJson WebServiceJson;

    public SignUpPage(WebDriver driver)
    {
        //Initialize my objects in the page
        PageFactory.initElements(driver, this);
    }

    //Web Elements
    @FindBy(how = How.ID, using = "firstName")
    public WebElement firstName;

    @FindBy(how = How.ID, using = "lastName")
    public WebElement lastName;

    @FindBy(how = How.ID, using = "registrationEmail")
    public WebElement registrationEmail;

    @FindBy(how = How.ID, using = "registrationPassword")
    public WebElement registrationPassword;

    @FindBy(how = How.ID, using = "passwordAgain")
    public WebElement passwordAgain;

    @FindBy(how = How.XPATH, using = "//label[text()='Erkek']")
    public WebElement genderMale;

    @FindBy(how = How.XPATH, using = "//label[text()='Kadın']")
    public WebElement genderFemale;

    @FindBy(how = How.ID, using = "phoneNumber")
    public WebElement phoneNumber;

    @FindBy(how = How.ID, using = "birthDay")
    public WebElement birthDay;

    @FindBy(how = How.ID, using = "birthMonth")
    public WebElement birthMonth;

    @FindBy(how = How.ID, using = "birthYear")
    public WebElement birthYear;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[3]/div[2]/div[2]/form/div[9]/div[1]/label")
    public WebElement acceptContract;

    @FindBy(how = How.ID, using = "sendPromotionalMailAndSms")
    public WebElement sendPromotionalMailAndSms;

    @FindBy(how = How.ID, using = "submitButton")
    public WebElement submitButton;
}

