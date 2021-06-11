package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {
	
	private static final String url = "http://thedemosite.co.uk/";
	
	@FindBy(xpath = "//a[contains(text(), '3. Add a User')]")
			private WebElement addUser;
	@FindBy(xpath = "//a[contains(text(), '4. Login')]")
		private WebElement login;

	public static String getUrl() {
		return url;
	}
	
	public void navAddUser() {
		addUser.click();
	}
	
	public void navLogin() {
		login.click();
	}
}
