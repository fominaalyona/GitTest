package by.epam.training.ht2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CreateUserPage extends AbstractPage {

	// private final String BASE_URL = "http://localhost:8080/securityRealm/";

	@FindBy(name = "username")
	private WebElement userName;

	@FindBy(name = "fullname")
	private WebElement fullName;

	@FindBy(name = "email")
	private WebElement email;

	@FindBy(name = "password1")
	private WebElement password;

	@FindBy(name = "password2")
	private WebElement passwordAgain;

	@FindBy(id = "yui-gen2-button")
	private WebElement createUserButton;

	public CreateUserPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
		// driver.navigate().to(BASE_URL);
	}

	public void checkTextElementsType() {
		int countText = 0;
		if (userName.getAttribute("type").equals("text") && fullName.getAttribute("type").equals("text") && email.getAttribute("type").equals("text")) {
			countText = 3;
		}
		Assert.assertEquals(countText, 3);
	}

	public void checkPasswordElementsType() {
		int countPassword = 0;
		if (password.getAttribute("type").equals("password") && passwordAgain.getAttribute("type").equals("password")) {
			countPassword = 2;
		}
		Assert.assertEquals(countPassword, 2);
	}

	public void isElementsEmpty() {
		Assert.assertTrue(userName.getText().isEmpty());
		Assert.assertTrue(fullName.getText().isEmpty());
		Assert.assertTrue(email.getText().isEmpty());
		Assert.assertTrue(password.getText().isEmpty());
		Assert.assertTrue(passwordAgain.getText().isEmpty());
	}

	public void createNewUser(String userName, String password, String passwordAgain, String fullName, String email) {
		this.userName.sendKeys(userName);
		this.password.sendKeys(password);
		this.passwordAgain.sendKeys(passwordAgain);
		this.fullName.sendKeys(fullName);
		this.email.sendKeys(email);
	}

	public void createNewUserClick() {
		createUserButton.click();
	}

}
