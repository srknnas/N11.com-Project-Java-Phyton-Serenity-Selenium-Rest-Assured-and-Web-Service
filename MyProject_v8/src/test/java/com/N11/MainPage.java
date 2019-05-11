package com.N11;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends PageObject {

    WebDriver driver;

    public MainPage(WebDriver driver) {

        //Initialize my objects in the page
        PageFactory.initElements(driver, this);
    }

    //Web Elements
    @FindBy(how = How.CLASS_NAME, using = "btnSignUp")
    public WebElement btnSingUp;

    @FindBy(how = How.XPATH, using = ".//*[@class='myAccount']/a[2]")
    public WebElement myAccount;





}
