package com.amazon.mavenPOM;

import static org.junit.Assert.assertTrue;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.maven.qa.pages.HomePage;

/**
 * Unit test for simple App.
 */
public class HomePageTest extends TestBase
{
	HomePage home;
	public HomePageTest()
	{
		super();
	}

    @BeforeTest
    public void setUp() throws InterruptedException
    {
    	initialization();
    	home= new HomePage();
    }
    @Test(priority=1)
    public void checkSearchBar()
    {
    	if(home.isSearchbarExists())
    	{
    		System.out.println("SearchBar is present");
    	}
    }
    @Test(priority=2)
    public void checkSignIn()
    {
    	if(home.getSigninButtonText().equalsIgnoreCase("Hello, sign in"))
    	{
    		System.out.println(home.getSigninButtonText());
    	}
    }
    @AfterTest
    public void tearDown()
    {
    	close();
    }
}
