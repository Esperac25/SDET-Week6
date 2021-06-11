package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUser {
	
	@FindBy(name = "username")
	private WebElement user;
	@FindBy(name = "password")
	private WebElement password;
	
	public void signUp(String uName, String uPass) {
		user.sendKeys(uName);
		password.sendKeys(uPass);
		password.submit();
	}
}
