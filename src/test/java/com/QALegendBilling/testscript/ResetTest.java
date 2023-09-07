package com.QALegendBilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QALegendBilling.automationcore.Base;
import com.QALegendBilling.constants.ErrorMessages;
import com.QALegendBilling.pages.LoginPage;
import com.QALegendBilling.pages.ResetPage;
import com.QALegendBilling.utilities.ExcelUtility;

public class ResetTest extends Base {
	ResetPage reset;
	LoginPage login;

	@Test(priority=1,description="TC_003_verify_Reset_passwordWith_InavlidemailID",groups={"Smoke"})
	public void TC_003_verify_Reset_passwordWith_InavlidemailID() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("ResetPage");
		String email = data.get(0).get(1);
		String act_ErrorMsg = data.get(1).get(1);
		login = new LoginPage(driver);
		reset = login.clickforgot();
		reset.getEmail(email);
		reset.clickResetLinkButton();
		String expEmailMsg = reset.EmailMessage();
		Assert.assertEquals(expEmailMsg, act_ErrorMsg, ErrorMessages.RESET_PASSWORD_ERROR_MESSAGE);

	}

}
