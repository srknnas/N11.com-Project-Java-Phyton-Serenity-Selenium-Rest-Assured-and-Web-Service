package com.N11;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WebServiceJson {

    //Variables
    private static String ID;
    private static String firstName;
    private static String lastName;
    private static String email;
    private static String password;
    private static String passwordAgain;
    private static String phoneNumber;
    private static String gender;
    private static String birthDay;
    private static String birthMonth;
    private static String birthYear;

    //Functions for using data getting from web service
    public String getID()
    {
        return ID;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getEmail()
    {
        return email;
    }
    public String getPassword()
    {
        return password;
    }
    public String getPasswordAgain()
    {
        return passwordAgain;
    }
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public String getGender()
    {
        return gender;
    }
    public String getBirthDay()
    {
        return birthDay;
    }
    public String getBirthMonth()
    {
        return birthMonth;
    }
    public String getBirthYear()
    {
        return birthYear;
    }

    //Main functions of reading web service to getting data
    public void ReadWebService() throws IOException, JSONException {
        JSONObject json1 = readJsonFromUrl("http://127.0.0.1:5000/get/signUpData/members/randomGet");
        //JSONObject json2 = json1.getJSONObject("member");
        JSONArray json2 = json1.getJSONArray("member");
        ID = json2.getJSONObject(0).getString("id");
        firstName = json2.getJSONObject(0).getString("Name");
        lastName = json2.getJSONObject(0).getString("Surname");
        email = json2.getJSONObject(0).getString("mail");
        password = json2.getJSONObject(0).getString("password");
        passwordAgain = json2.getJSONObject(0).getString("verifyPassword");
        phoneNumber = json2.getJSONObject(0).getString("phoneNumber");
        gender = json2.getJSONObject(0).getString("gender");
        birthDay = json2.getJSONObject(0).getString("birthdateDay");
        birthMonth = json2.getJSONObject(0).getString("birthdateMonth");
        birthYear = json2.getJSONObject(0).getString("birthdateYear");
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    private static String readAll(Reader rd) throws IOException
    {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}
