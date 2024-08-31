package Com_qa_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstarct_components.abtsract_components;

public class Checkout_pages extends abtsract_components{

	public Checkout_pages(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[placeholder='Select Country']")
	WebElement countrybox;
	
	@FindBy(xpath = "//button[@class=\"ta-item list-group-item ng-star-inserted\"]")
	List<WebElement> countrylist;
	@FindBy(xpath = "//div[@class=\"actions\"]/a[@class=\"btnn action__submit ng-star-inserted\"]")
	WebElement placeorder;
	
	By countrydrop = By.xpath("//button[@class=\"ta-item list-group-item ng-star-inserted\"]");
	
	public void get_country(String countryname) {
		Actions action = new Actions(driver);
 	action.sendKeys(countrybox, "india").build().perform();
	waitelementtoAppear(countrydrop);
	List<WebElement> list = countrylist;
  WebElement dropele = list.stream().filter(drop->drop.getText().equalsIgnoreCase(countryname)).findFirst().orElse(null);
  dropele.click();

	}
	
	public Confirmation_pages get_place_order() {
		placeorder.click();
		Confirmation_pages confirm = new Confirmation_pages(driver);
		return confirm;
	}
	

	
	
	

}
