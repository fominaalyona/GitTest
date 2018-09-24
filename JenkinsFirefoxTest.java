package by.epam.training.ht2;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.epam.training.ht2.steps.Steps;

public class JenkinsFirefoxTest {

	private Steps steps;

	private final String LOGIN = "hereisyourname";
	private final String PASSWORD = "hereisyourpassword";

	private final String USER_NAME = "someuser";
	private final String USER_PASSWORD = "somepassword";
	private final String USER_PASSWORD_AGAIN = "somepassword";
	private final String USER_FULL_NAME = "Some Full Name";
	private final String USER_EMAIL = "some@addr.dom";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test
	public void jenkinsTest() {
		steps.logInJenkins(LOGIN, PASSWORD);
		steps.openManageJenkinsPage();
		steps.clickManageUsers();
		steps.createNewUser(USER_NAME, USER_PASSWORD, USER_PASSWORD_AGAIN, USER_FULL_NAME, USER_EMAIL);
		steps.createUserButtonClick();
		steps.deleteUserClick();
		steps.confirmationOfDeletingUser();
		steps.checkDeletedUser();
		steps.checkDeletingAdminUser();
	}

	@AfterMethod(description = "Stop Browser")
	public void closeDriver() {
		steps.closeDriver();
	}

}
