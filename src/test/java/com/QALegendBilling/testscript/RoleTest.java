package com.QALegendBilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QALegendBilling.automationcore.Base;
import com.QALegendBilling.constants.ErrorMessages;
import com.QALegendBilling.pages.HomePage;
import com.QALegendBilling.pages.LoginPage;
import com.QALegendBilling.pages.RolePage;
import com.QALegendBilling.utilities.ExcelUtility;

public class RoleTest extends Base{
		LoginPage login;
		HomePage home;
		RolePage role;

	@Test(priority=1,description="TC_007_verifyRoleSearch",groups={"Smoke"})
	public void TC_007_verifyRoleSearch() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String username = data.get(0).get(1);
		String password = data.get(1).get(1);
		String expUserName = data.get(2).get(1);
		login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		home = login.clickSubmit();
		home.clickOnUserManagementTab();
		List<ArrayList<String>>data1=ExcelUtility.excelDataReader("RoleSearch");
		String rname=data1.get(0).get(0);	
		role = home.clickRolesTab();//clickRolesTab
		role.enterRoleName(rname);		
		String td_Search=role.getSearchValue();
		Assert.assertEquals(rname,td_Search,ErrorMessages.INVALID_ROLE_NAME);
	}

}
