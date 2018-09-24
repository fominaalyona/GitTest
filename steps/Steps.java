package by.epam.training.ht2.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import by.epam.training.ht2.driver.DriverSingleton;
import by.epam.training.ht2.pages.CreateUserPage;
import by.epam.training.ht2.pages.DeleteUserPage;
import by.epam.training.ht2.pages.LoginPage;
import by.epam.training.ht2.pages.MainPage;
import by.epam.training.ht2.pages.ManageJenkinsPage;
import by.epam.training.ht2.pages.UsersPage;

public class Steps {

	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void logInJenkins(String username, String password) {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.openPage();
		loginPage.logInToJenkins(username, password);
	}

	public void openManageJenkinsPage() {
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.clickOnManageJenkinsButton();
	}

	public void clickManageUsers() {
		ManageJenkinsPage manageJenkinsPage = PageFactory.initElements(driver, ManageJenkinsPage.class);
		manageJenkinsPage.clickManageUsers();

	}

	public void checkUserInput() {
		CreateUserPage createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
		createUserPage.checkTextElementsType();
		createUserPage.checkPasswordElementsType();
		createUserPage.isElementsEmpty();
	}

	public void createNewUser(String userName, String password, String passwordAgain, String fullName, String email) {
		CreateUserPage createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
		ManageJenkinsPage manageJenkinsPage = PageFactory.initElements(driver, ManageJenkinsPage.class);
		manageJenkinsPage.clickCreateUserPage();
		checkUserInput();
		createUserPage.createNewUser(userName, password, passwordAgain, fullName, email);
	}

	public void createUserButtonClick() {
		CreateUserPage createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
		createUserPage.createNewUserClick();
	}

	public void deleteUserClick() {
		UsersPage usersPage = PageFactory.initElements(driver, UsersPage.class);
		usersPage.clickDeleteUserButton();
	}

	public void confirmationOfDeletingUser() {
		DeleteUserPage deleteUserPage = PageFactory.initElements(driver, DeleteUserPage.class);
		deleteUserPage.acceptDeletingUser();
	}
	
	public void checkDeletedUser() {
		UsersPage usersPage = PageFactory.initElements(driver, UsersPage.class);
		usersPage.checkDeletedUser();
	}

	public void checkDeletingAdminUser() {	
		UsersPage usersPage = PageFactory.initElements(driver, UsersPage.class);
		usersPage.checkAdminDeleteHref();
}

}
