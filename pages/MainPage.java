package by.epam.training.ht2.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage{
	
	private static final String BASE_URL = "http://localhost:8080";

	@FindBy(xpath = "/html/body/div[4]/div[1]/div[1]/div[4]/a[2]")
	private WebElement manageJenkinsButton;
	
	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
	
	public void clickOnManageJenkinsButton() {
		manageJenkinsButton.click();
	}
}
