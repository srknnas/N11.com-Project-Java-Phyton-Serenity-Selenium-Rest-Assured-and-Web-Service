package com.N11;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class WebServiceRestAssured {

    private static String[] elementArray = new String[12];

    public String[] getElementArray()
    {
        return elementArray;
    }

    //Getting data from web service
    public int readWebService()
    {
        //Get data from web service
        try {
            RestAssured.baseURI = "http://127.0.0.1:5000/";
            RequestSpecification request = RestAssured

                    .given();

            Response response = request

                    .when()
                    .get("get/signUpData/members/randomGet")
                    .then()
                    .statusCode(200)
                    .extract().response();

            //If web service is working and status code is 200, read data from web service
            //and carry them to array called elementArray
            int responseCode = response.getStatusCode();
            if(responseCode == 200)
            {
                elementArray[0] = response.jsonPath().getString("member.Name");
                elementArray[1] = response.jsonPath().getString("member.Surname");
                elementArray[2] = response.jsonPath().getString("member.birthdateDay");
                elementArray[3] = response.jsonPath().getString("member.birthdateMonth");
                elementArray[4] = response.jsonPath().getString("member.birthdateYear");
                elementArray[5] = response.jsonPath().getString("member.gender");
                elementArray[6] = response.jsonPath().getString("member.id");
                elementArray[7] = response.jsonPath().getString("member.mail");
                elementArray[8] = response.jsonPath().getString("member.password");
                elementArray[9] = response.jsonPath().getString("member.phoneNumber");
                elementArray[10] = response.jsonPath().getString("member.status");
                elementArray[11] = response.jsonPath().getString("member.verifyPassword");
                return 0;
            }
            else
                return -1;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return -1;
        }

    }
}

