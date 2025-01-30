package com.pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.assertions.mobileAssertion;
import com.qa.base.BaseClass;
import com.qa.utils.GenericActions;
import com.qa.utils.KeyboardActions;
import com.qa.utils.MouseActions;
import com.waits.waits;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCataloguePage extends BaseClass {
	
//    AndroidDriver driver;
    
    
    private static final By search=By.xpath("//android.view.ViewGroup[@content-desc='Search for Products | Events']");
    
    private static final By categories=By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView");
    
    
    private static final By product(int index) {
        return By.xpath("(//android.widget.ImageView)[" + index + "]");
    }
    
    private static final By productList=By.xpath("//android.widget.ScrollView/android.view.ViewGroup");
    
    private static final By productListOption(int index) {
        return By.xpath("(//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup)[" + index + "]");
    }
    
    private static final By productDetailImage = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView");
    
    private static final By productDescription = By.xpath("//android.widget.TextView[@text='Product description']");
    
    private static final By productDocument = By.xpath("//android.widget.TextView[@text='Documents']");
    
    private static final By canFoamText = By.xpath("//android.widget.TextView[@text='Can Foam']");
    
    private static final By canFoamHeader = By.xpath("//android.widget.TextView[@text='Can Foam']");
    
    private static final By buyNow = By.xpath("//android.view.ViewGroup[@content-desc='Buy now']");
    
    private static final By cartLayout = By.xpath("//android.widget.LinearLayout[@resource-id='android:id/parentPanel']");
    
    private static final By viewCartBtn = By.xpath("//android.widget.Button[@text='VIEW CART']");
    
    private static final By myBagHeader = By.xpath("//android.widget.TextView[@text='My Bag']");
    
    private static final By proceedToBuy = By.xpath("//android.view.ViewGroup[@content-desc='Proceed to buy']");
    
    private static final By continueShopping = By.xpath("//android.widget.TextView[@text='Continue shopping']");
    
    private static final By profoamTitle = By.xpath("(//com.horcrux.svg.d0)[2]");
    
    private static final By flashSale = By.xpath("//android.widget.TextView[@text=\"Flash Sale\"]");
    
    private static final By transferPump = By.xpath("//android.widget.TextView[@text=\"Transfer Pumps\"]");
    
    private static final By FlashSaleHeader = By.xpath("//android.widget.TextView[@text=\"Flash Sale\"]");
    
    private static final By backArrow = By.xpath("(//android.view.ViewGroup[1]/com.horcrux.svg.SvgView)[1]");
    
    private static final By firstProduct = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup");

    private static final By selectItemFromSearch = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]");
    
    private static final By searchBtn = By.xpath("(//android.widget.TextView[@text=\"Search\"])[2]");
    
    private static final By searchField = By.xpath("//android.widget.EditText[@text=\"Search for Products | Events\"]");
    
    private static final By searchResult =  By.xpath("/android.widget.TextView[@text=\"Search result - Can Foam\"]");
    
    private static final By searchResultProductList = By.xpath("//android.widget.ScrollView");
    
    private static final By clearBtn = By.xpath("//android.widget.TextView[@text=\"Clear\"]");
   

	
	
	public boolean searchFieldDisplayed() {
		return GenericActions.verifyElementDisplayed(search, "Search button is dipslayed");
	}
	
	public void assertsearchButton() {
		waits.waitForWhile(2000);
		mobileAssertion.assertTrue(searchFieldDisplayed(), "assert search button");		
	}
	
	public void assertcategoryList() {
		mobileAssertion.assertTrue(categoriesDisplayed(), " assert Categories");	
	}
	
	public boolean categoriesDisplayed() {
		return GenericActions.verifyElementDisplayed(categories, "Categories is dipslayed");
	}
		
	public void clickProductByIndex(int index) {
		waits.waitForWhile(3000);
		MouseActions.click(product(index), "Product Category item is clicked");
		System.out.println();
	}
	
	public boolean productDetailsList() {	
		waits.waitForWhile(3000);
		return GenericActions.verifyElementDisplayed(productList, "Product List is displayed");
	}
	
	public void clickProductListOptionByIndex(int index) {	
		MouseActions.click(productListOption(index), "Product Category item is clicked");		
	}
	
	public boolean productDetailImageDisplayed() {
		return GenericActions.verifyElementDisplayed(productDetailImage, "Product Details Image is displayed");
	}
	
	public void clickProductDescription() {
		MouseActions.scrollToElementUsingUIwithSwipe(productDescription,2);
		MouseActions.click(productDescription, "Product Description is clicked");
		waits.waitForWhile(2000);
		MouseActions.click(productDescription, "Product Description is clicked");
	}
	
	public void clickProductDocument() {
		waits.waitForWhile(2000);
		MouseActions.scrollToElementUsingUIwithSwipe(productDocument,2);
		MouseActions.click(productDocument, "Product Description is clicked");			
	}
	
	public boolean flashSaleText() {
		waits.waitForWhile(1000);
		return GenericActions.verifyElementDisplayed(flashSale, "Flash Sale Text is present");
	}
	
	public String canFoamHeadergetText() {
		waits.waitForWhile(1000);
		return GenericActions.retrieveText(canFoamHeader, "Can Foam Header is present");
	}
	
	public void clickbuyNow() {
		waits.waitForWhile(1000);
		MouseActions.click(buyNow, "Product Category is clicked");		
	}
	
	public boolean cartLayoutDisplayed() {
		return GenericActions.verifyElementDisplayed(cartLayout, "cart Layout button is displayed");
	}
	
	public void clickViewCartBtn() {
		waits.waitForWhile(1000);
		MouseActions.click(viewCartBtn, "Product Category is clicked");		
	}
	
	public boolean myBagDisplayed() {
		return GenericActions.verifyElementDisplayed(myBagHeader, "My Bag Header is displayed");
	}
	
	public void clickProceedToBuy() {
		waits.waitForWhile(1000);
		MouseActions.click(proceedToBuy, "Proceed To But button is clicked");		
	}
	
	public void clickContinueShopping() {
		waits.waitForWhile(1000);
		MouseActions.click(continueShopping, "Continue Shopping button is clicked");		
	}
		
	public void assertproductDetailsImage() {
		mobileAssertion.assertTrue(productDetailImageDisplayed(), "Product Details Image is dipslayed");
	}
	
	public void assertcartLayoutdisplay() {
		mobileAssertion.assertTrue(cartLayoutDisplayed(), "Cart Layout is dipslayed");
	}
	
	public boolean profoamTitleDisplayed() {
		return GenericActions.verifyElementDisplayed(profoamTitle, "Profoam Title is dipslayed");
	}
	
	public void swipeProductList() {
		MouseActions.scrollToElementUsingUIwithSwipe(flashSale,3);
		waits.waitForWhile(1000);	
	}
	
	public void assertFlashSaleText() {
		mobileAssertion.assertTrue(flashSaleText(), "Flash Sale text is displayed");
	}
	
	public void clickFlashSale() {
		MouseActions.click(flashSale, "Flash Sale is clicked");		
	}
	
	public boolean flashSaleHeaderText() {
		waits.waitForWhile(2000);
		return GenericActions.verifyElementDisplayed(FlashSaleHeader, "Flash Sale Text is present");
	}
	
	public void assertFlashSaleTextMatch() {
		mobileAssertion.assertEquals(flashSaleText(), flashSaleHeaderText(), " assert CanFoam Text is matched");			
	}
	
	public void swipeCanFoamProductList() {
		MouseActions.scrollDownUsingUiScrollable();
		waits.waitForWhile(1000);
		MouseActions.scrollTopUsingUiScrollable();
		waits.waitForWhile(1000);
	}
	
	public void backArrowButton() {
		MouseActions.click(backArrow, "Back Arrow is clicked");	
	}
	
	public boolean productFirstIndexDisplayed() {
		return GenericActions.verifyElementDisplayed(firstProduct, "Product First List is displayed");
	}
	
	public void assertProductFirstList() {
		mobileAssertion.assertTrue(productFirstIndexDisplayed(), "Product First List is present");
	}
	
	public boolean searchFieldBtnDisplayed() {
		return GenericActions.verifyElementDisplayed(searchField, "Search Field is displayed");
	}
	
	public void assertSearchField() {
		mobileAssertion.assertTrue(searchFieldBtnDisplayed(), "Search Field is present");
	}	
	
	public void clickSearchButton() {
		MouseActions.click(search, "Search Field Button is clicked");
		waits.waitForWhile(1000);
	}
	
	public void entersearchValue() {
		KeyboardActions.enterValue(searchField, "Can Foam Text entered", "Can Foam");
		waits.waitForWhile(1000);
		MouseActions.click(selectItemFromSearch, "First Item fom search Bar List is clicked");
	}
	
	public void clickSearch() {
		MouseActions.click(searchBtn, "Click Search button");
		waits.waitForWhile(2000);
	}
	
	public boolean searchResultDisplayed() {
		return GenericActions.verifyElementDisplayed(searchResult, "Search Result is displayed");
	}
	
	public void assertSearchResult() {
		mobileAssertion.assertTrue(searchResultDisplayed(), "Search Result is present");
	}
	
	public boolean searchResultProductListDisplayed() {
		return GenericActions.verifyElementDisplayed(searchResultProductList, "Search Product List is displayed");
	}
	
	public void assertSearchResultProductList() {
		mobileAssertion.assertTrue(searchResultProductListDisplayed(), "Search Product List is present");
	}
	
	public void clickClearBtn() {
		MouseActions.click(clearBtn, "Click Clear Search button");
		waits.waitForWhile(2000);
	}
	

}
