package CodeClouds.PracticeFrameWork;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseTest;

public class ValidationTest extends BaseTest{
	
	@Test(groups = {"groupTest"})
	public void validationTest() throws InterruptedException {
		
		landingPage.proceedToLogin("hablu@test.com", "jhjhjahs");
		Assert.assertEquals(landingPage.loginvalidate(), "Incorrect email or password."); 
	}

}
