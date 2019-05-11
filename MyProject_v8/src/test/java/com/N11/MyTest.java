package com.N11;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class MyTest {

    @Steps
    User mark;
    
    @Test
    public void WebServiceTest()
    {
        mark.WebServiceStatusControl();
    }

    @Test
    public void SignUpPageTest()
    {
        mark.openWebBrowser();
        mark.openN11MainPage();
        mark.verifyN11MainPage();
        mark.clickSignUpLinkOnMainPage();        
        mark.FillFormOnSignUpPage();
        mark.ClickSignUpButton();
        mark.verifyN11MainPage();
        mark.controlNewMemberOnMainPage();
        mark.close();
    }
}
