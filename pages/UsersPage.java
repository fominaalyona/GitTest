package by.epam.training.ht2.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class UsersPage extends AbstractPage {

	@FindBy(xpath = "/html/body/div[4]/div[2]/table/tbody/tr[3]/td[4]/a[2]/img")
	private WebElement deleteUserButton;

	@FindBy(xpath = "/html/body/div[4]/div[2]/table/tbody/tr[3]/td[4]")
	private WebElement usersTable;

	public UsersPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openPage() {
	}

	public void clickDeleteUserButton() {
		deleteUserButton.click();
	}

	public boolean isThereThisUser() {
		try {
			deleteUserButton.getAttribute("href").equals("user/someuser/delete");
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void checkDeletedUser() {
		Assert.assertFalse(isThereThisUser());
	}

	public boolean isThereAdminDeleting() {
		try {
			usersTable.getAttribute("href").equals("user/alenaafomina/delete");
			return true;
		} catch (NoSuchElementException e) {
			e.getMessage();
			return false;
		}
	}

	public void checkAdminDeleteHref() {
		Assert.assertFalse(isThereAdminDeleting());
	}

}
