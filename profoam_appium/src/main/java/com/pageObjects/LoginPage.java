package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;
import com.qa.utils.GenericActions;
import com.qa.utils.KeyboardActions;
import com.qa.utils.MouseActions;
import com.waits.waits;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends BaseClass {
	
	AndroidDriver driver;
	
	
	private static final By skipButton=By.xpath("//android.widget.TextView[@text='SKIP']");
	
	private static final By loginButton=By.xpath("//android.view.ViewGroup[@content-desc='Login']");
	
	private static final By emailAddress=By.xpath("//android.widget.EditText[@text='Enter email address']");
	
	private static final By password=By.xpath("//android.widget.EditText[@text='Enter password']");
	
    private static final By login=By.xpath("//android.view.ViewGroup[@content-desc='Login']");
    
    private static final By title = By.xpath("com.horcrux.svg.d0");
	
	
	
    public static void verifyTitle() {
    	GenericActions.verifyElementDisplayed(title, "Profoam title is diplayed");
    }
	
	public static void clickSkip() {	
		MouseActions.click(skipButton, "Skip Button is clicked");
	}
	
	public static void loginBtn() {	
		MouseActions.click(loginButton, "Login Button is clicked");
	}
	
	public static void setEmailAddress(String name) {
		waits.waitUntilElementIsVisible(emailAddress, 1000);
		MouseActions.click(emailAddress, "Email Address text area is clicked");
		KeyboardActions.enterValue(emailAddress, "Email Address", name);
		KeyboardActions.hideKeyboard();
		
	}
	
	public static void setPassword(String pass) {
		waits.waitUntilElementIsVisible(password, 100);
		MouseActions.click(password, "Password Text area is clicked");
		KeyboardActions.enterValue(password, "Password", pass);
		KeyboardActions.hideKeyboard();
	}
	
	public static void login() {	
		MouseActions.click(login, "Login button is clicked");
		
	}
	
	
}
