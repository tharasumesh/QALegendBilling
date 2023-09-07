package com.QALegendBilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QALegendBilling.automationcore.Base;
import com.QALegendBilling.constants.ErrorMessages;
import com.QALegendBilling.pages.AddUserPage;
import com.QALegendBilling.pages.HomePage;
import com.QALegendBilling.pages.LoginPage;
import com.QALegendBilling.pages.UserPage;
import com.QALegendBilling.utilities.ExcelUtility;
import com.QALegendBilling.utilities.RandomUtility;

public class EditTest extends Base {
	LoginPage login;
	HomePage home;
	UserPage user;
	AddUserPage adduser;
	@Test
	public void Tc_008_verify_EditUser()
	{
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String username = data.get(0).get(1);
		String password = data.get(1).get(1);
		String expUserName = data.get(2).get(1);
		List<ArrayList<String>> data_user = ExcelUtility.excelDataReader("ADDUSER");
		String prefix = data_user.get(0).get(1);
		String First_Name = RandomUtility.getfName();
		String Last_Name = RandomUtility.getlName();
		String Email = RandomUtility.getRandomEmail();
		String updateEmail=Email;
		String Uname = First_Name + Last_Name;
		String pwd = First_Name + "@123";
		String confirm_pwd = pwd;
		String salesCommissionPercentage = data_user.get(7).get(1);
		String expEmptyMsg = data_user.get(8).get(1);
		login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		home = login.clickSubmit();
		home.clickOnUserManagementTab();
		user=home.UserLink();
		adduser = home.User_AddButton();
		adduser.enterUserDetails(prefix,First_Name,Last_Name,Email,Uname,pwd,confirm_pwd, salesCommissionPercentage);
		adduser.clickOnIsActive();
		user=adduser.clickOnSaveButton();
		user.setValidEmail(Email);
		adduser=user.clickOnEditButton();
		adduser.editUserDetails(updateEmail);
		user=adduser.ClickUpdateButton();
		user.setValidEmail(Email);
		String actEmail=user.getValidEmail();
		Assert.assertEquals(Email,actEmail,ErrorMessages.INVALID_UPDATE_MESSAGE);
			
	}

}
