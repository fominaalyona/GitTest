package by.epam.training.ht2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DeleteUserPage extends AbstractPage {
	
	@FindBy(xpath = "//body")
	private WebElement confirmation;
	
	@FindBy(id = "yui-gen2-button")
	private WebElement acceptDeleting;
	
	public DeleteUserPage(WebDriver driver) {
		super(driver);
}
	@Override
	public void openPage() {	
	}
	
	public boolean findConfirmationMessage() {
		String message = "Are you sure about deleting the user from Jenkins?";
		if(confirmation.getText().contains(message)) {
			return true;
		}
		return false;
	}
	
	public void acceptDeletingUser() {
		if(findConfirmationMessage() == true) {
		acceptDeleting.click();}
	}
	
}
