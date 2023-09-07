package com.QALegendBilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QALegendBilling.automationcore.Base;
import com.QALegendBilling.constants.ErrorMessages;
import com.QALegendBilling.pages.HomePage;
import com.QALegendBilling.pages.LoginPage;
import com.QALegendBilling.pages.SignoutPage;
import com.QALegendBilling.utilities.ExcelUtility;

public class SignoutTest extends Base {
	SignoutPage signout;
	LoginPage login;
	HomePage home;

	@Test(priority=1,description="TC_004_verify_valid_UserSignout",groups={"Smoke"})
	public void TC_004_verify_valid_UserSignout() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String username = data.get(0).get(1);
		login = new LoginPage(driver);
		String actTitile = login.loginPageTitle();
		System.out.println(actTitile);
		login.enterUserName(username);
		String password = data.get(1).get(1);
		login.enterPassword(password);
		home = login.clickSubmit();
		login = home.clickSignoutButton();
		String expTitle = login.loginPageTitle();
		Assert.assertEquals(actTitile, expTitle, ErrorMessages.TITLE_FAILURE_MESSAGE);

}
}