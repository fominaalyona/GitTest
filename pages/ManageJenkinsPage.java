package by.epam.training.ht2.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ManageJenkinsPage extends AbstractPage {

	private final Logger logger = LogManager.getRootLogger();

	private final String BASE_URL = "http://localhost:8080/manage";

	@FindBy(xpath = "//div/a[@title=\"Manage Users\"]/dl/dt[1]")
	private WebElement manageUsers;

	@FindBy(xpath = "//div/a[@title=\"Manage Users\"]/dl/dd[1]")
	private WebElement modifyUsers;

	@FindBy(xpath = "/html/body/div[4]/div[1]/div/div[3]/a[2]")
	private WebElement createUser;

	public ManageJenkinsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

	public void clickManageUsers() {
		Assert.assertTrue(manageUsers.getText().contains("Manage Users"));
		Assert.assertTrue(modifyUsers.getText().contains("Create/delete/modify users that can log in to this Jenkins"));
		manageUsers.click();
		logger.info("The Manage Users page was successfully opened.");
	}

	public void clickCreateUserPage() {
		createUser.click();
		logger.info("The Create User page was successfully opened.");
	}
}
