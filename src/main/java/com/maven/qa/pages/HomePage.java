package com.maven.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;


public class HomePage extends TestBase {

	@FindBy(id="twotabsearchtextbox")
	WebElement searchBar;
	
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	WebElement signinText;
	
	public HomePage()
	{
		PageFactory.initElements(TestBase.driver,this);
	}
	
	public boolean isSearchbarExists()
	{
	   boolean bool= searchBar.isDisplayed();
	   return bool;
	}
	public String getSigninButtonText()
	{
		String text= signinText.getText();
		return text;
	}

}
