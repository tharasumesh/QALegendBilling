package com.QALegendBilling.testscript;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.QALegendBilling.automationcore.Base;
import com.QALegendBilling.constants.ErrorMessages;
import com.QALegendBilling.dataprovider.DataProviders;
import com.QALegendBilling.pages.HomePage;
import com.QALegendBilling.pages.LoginPage;
import com.QALegendBilling.utilities.ExcelUtility;

public class LoginTest extends Base {
	LoginPage login;
	HomePage home;

	@Test(priority=1,description="Tc_001verify_Valid_Login",groups={"Regression"})
	public void Tc_001verify_Valid_Login() {

		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String username = data.get(0).get(1);
		String password = data.get(1).get(1);
		String expUserName = data.get(2).get(1);
		login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		home = login.clickSubmit();
		String actualUserName = home.getUserAccountName();
		Assert.assertEquals(expUserName, actualUserName, ErrorMessages.USERNAME_FAILURE_MESSAGE);

	}

	@Test(priority=1,description="Tc_002verifyInValidLogin",groups={"Regression"},dataProvider = "InvalidUserCredentials", dataProviderClass = DataProviders.class)
	public void Tc_002verifyInValidLogin(String Uname, String password) {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String expErrorMsg = data.get(3).get(1);
		login = new LoginPage(driver);
		login.enterUserName(Uname);
		login.enterPassword(password);
		home = login.ClickSubmitbtn();
		String actualmsg = login.ErrorMessage();
		Assert.assertEquals(actualmsg, expErrorMsg, ErrorMessages.LOGIN_FAILURE_MESSAGE);
	}
}
