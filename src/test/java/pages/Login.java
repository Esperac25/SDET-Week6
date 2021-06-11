package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	
	@FindBy(name = "username")
	private WebElement user;
	@FindBy(name = "password")
	private WebElement password;
	
	public void signIn(String uName, String uPass) {
		user.sendKeys(uName);
		password.sendKeys(uPass);
		password.submit();
	}
}
