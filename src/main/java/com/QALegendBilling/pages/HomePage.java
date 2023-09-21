package com.QALegendBilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.QALegendBilling.utilities.TestHelperUtility;

public class HomePage extends TestHelperUtility {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private final String _userAccount = "//a[@class='dropdown-toggle']//span";
	@FindBy(xpath = _userAccount)
	WebElement userAccount;
	private final String _signoutField = "//a[text()='Sign Out']";
	@FindBy(xpath = _signoutField)
	WebElement signoutField;

	private final String _loginLink = "//button[@class='btn btn-primary']";
	@FindBy(xpath = _loginLink)
	private WebElement loginLink;

	private final String _userMgtTab = "//span[text()='User Management']";
	@FindBy(xpath = _userMgtTab)
	private WebElement userMgtTab;

	private final String _userTab = "//i[@class='fa fa-user']//following-sibling::span";
	@FindBy(xpath = _userTab)
	private WebElement userTab;
	private final String _rolesTab = "//i[@class='fa fa-briefcase']//following-sibling::span";
	@FindBy(xpath = _rolesTab)
	private WebElement rolesTab;
	private final String _salesCommissionTab = "//i[@class='fa fa-handshake-o']//following-sibling::span";
	@FindBy(xpath = _salesCommissionTab)
	private WebElement salesCommissionTab;
	private final String _addTab = "//a[@class='btn btn-block btn-primary']";
	@FindBy(xpath = _addTab)
	private WebElement addTab;
	private final String _deleteTab = "//button[@class='btn btn-xs btn-danger delete_user_button']";
	@FindBy(xpath = _deleteTab)
	private WebElement deleteTab;

	private final String _homeTab = "//a[@href='https://qalegend.com/billing/public/home']//span";
	@FindBy(xpath = _homeTab)
	private WebElement homeTab;

	public String getUserAccountName() {
		String accountName = page.getElementText(userAccount);
		return accountName;
	}

	public LoginPage clickSignoutButton() {
		page.clickOnElement(userAccount);
		page.clickOnElement(signoutField);
		return new LoginPage(driver);
	}

	public boolean userMenuIsDisplayed() {
		boolean status = page.isDisplayed(userTab);
		return status;
	}

	public boolean rolesMenuIsDisplayed() {
		boolean status = page.isDisplayed(rolesTab);
		return status;
	}

	public boolean salesMenuIsDisplayed() {
		boolean status = page.isDisplayed(salesCommissionTab);
		return status;
	}

	public String getUserAccountName1() {
		String accountName = page.getElementText(userAccount);
		return accountName;
	}

	public void clickOnUserManagementTab() {
		page.clickOnElement(userMgtTab);
		wait.waitForElementToBeVisible(driver, salesCommissionTab); // explicit wait is used. wait till sales commission
																	// tab gets displayed
	}

	public void clickOnHomeTab() {
		page.clickOnElement(homeTab);
		// wait.waitForElementToBeVisible(driver, salesCommissionTab); // explicit wait
		// is used. wait till sales commission tab gets displayed
	}

	public void UserManagementLink() {
		page.clickOnElement(userMgtTab);

	}

	public UserPage UserLink() {
		page.clickOnElement(userTab);
		return new UserPage(driver);

	}

	public DeletePage UserLinkDelete() {
		page.clickOnElement(userTab);
		return new DeletePage(driver);
	}

	public AddUserPage User_AddButton() {
		page.clickOnElement(addTab);
		return new AddUserPage(driver);
	}

	public RolePage clickRolesTab() {
		page.clickOnElement(rolesTab);
		return new RolePage(driver);
	}

	public DeletePage click_DeleteTab() {
		page.clickOnElement(deleteTab);
		return new DeletePage(driver);

	}

}
