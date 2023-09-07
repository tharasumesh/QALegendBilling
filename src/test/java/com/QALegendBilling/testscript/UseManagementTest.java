package com.QALegendBilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QALegendBilling.automationcore.Base;
import com.QALegendBilling.constants.ErrorMessages;
import com.QALegendBilling.pages.HomePage;
import com.QALegendBilling.pages.LoginPage;
import com.QALegendBilling.utilities.ExcelUtility;

public class UseManagementTest extends Base {
	
	LoginPage login;
	HomePage home;
	@Test(priority=1,description="Tc_005_verify_UserManagenetTabsAndDisplay",groups={"Smoke"})
	public void Tc_005_verify_UserManagenetTabsAndDisplay()
	{
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String username = data.get(0).get(1);
		String password = data.get(1).get(1);
		String expUserName = data.get(2).get(1);
		login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		home = login.clickSubmit();
		home.clickOnUserManagementTab();
		boolean userMenuStatus = home.userMenuIsDisplayed();
		boolean roleMenuStatus = home.rolesMenuIsDisplayed();
		boolean salesMenuStatus = home.salesMenuIsDisplayed();
		Assert.assertTrue(userMenuStatus, ErrorMessages.USERSUBMENU_NOTFOUND);
		Assert.assertTrue(roleMenuStatus, ErrorMessages.ROLESUBMENU_NOTFOUND);
		Assert.assertTrue(salesMenuStatus, ErrorMessages.SALESSUBMENU_NOTFOUND);
		
	}

}
