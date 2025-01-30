package com.qa.testcases;

import org.testng.annotations.Test;

import com.pageObjects.ProductCataloguePage;
import com.qa.base.BaseClass;

public class ProductPageTest extends BaseClass {
	
	ProductCataloguePage productPage =  new ProductCataloguePage();
	
	
	@Test
	public void verifyproductPageScrollingtoElement() {
		
		productPage.profoamTitleDisplayed();
		productPage.assertsearchButton();
		productPage.assertcategoryList();
		productPage.swipeProductList();
		productPage.assertFlashSaleText();
		productPage.clickFlashSale();
		productPage.assertFlashSaleTextMatch();
		productPage.productDetailsList();
		productPage.swipeCanFoamProductList();
		productPage.assertProductFirstList();
		productPage.backArrowButton();
		
		
	}
	
	@Test
	public void verifyproductPageSearchtoElement() {
		
		productPage.profoamTitleDisplayed();
		productPage.assertsearchButton();
		productPage.clickSearchButton();
		productPage.assertSearchField();
		productPage.entersearchValue();
		productPage.clickSearch();
		//productPage.assertSearchResult();
		productPage.assertSearchResultProductList();
		productPage.clickClearBtn();
		productPage.backArrowButton();
		
		
		
	}
		
		
    		

//		productPage.assertCanFoamText();
//		productPage.assertproductDetailLists();
//		productPage.clickProductListOptionByIndex(3);
//		productPage.assertproductDetailsImage();
//		productPage.clickProductDescription();
//	    productPage.clickProductDocument();
//		productPage.clickbuyNow();
//		productPage.assertcartLayoutdisplay();
//		productPage.clickViewCartBtn();
//		productPage.myBagDisplayed();
//		//productPage.clickContinueShopping();
//		productPage.clickProceedToBuy();
		
		
	
	
	
	

}
