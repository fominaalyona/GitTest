package by.epam.training.ht2.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

	private final Logger logger = LogManager.getRootLogger();

	private static final String BASE_URL = "http://localhost:8080/login?from=%2F";

	@FindBy(name = "j_username")
	private WebElement userName;

	@FindBy(name = "j_password")
	private WebElement password;

	@FindBy(name = "Submit")
	private WebElement submitButton;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
	
	public void logInToJenkins(String userName, String password) {
		this.userName.sendKeys(userName);
		this.password.sendKeys(password);
		submitButton.click();
	}
}
