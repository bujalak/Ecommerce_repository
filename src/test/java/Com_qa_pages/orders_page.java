package Com_qa_pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstarct_components.abtsract_components;

public class orders_page  extends abtsract_components{

	public orders_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = " //button[@class=\"btn btn-danger\"]")
	WebElement delbtn;
	
   @FindBy(xpath = "//div[@class=\"mt-4 ng-star-inserted\"]")
  WebElement inform_text;	
	
	@FindBy(css="table td:nth-child(3)")
	List<WebElement> orderlist;
	
	public Boolean verify_orders(String productname) {
		
		boolean isfound = orderlist.stream().anyMatch(item->item.getText().equalsIgnoreCase(productname));
		return isfound;
		
	}
	
	public boolean verify_order_removed() {
		delbtn.click();
		boolean isfound = inform_text.isDisplayed();
		System.out.println(inform_text.getText());
		
		return isfound;
		
	}
	

	
	
	

}
