package Practice;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Abstarct_components.abtsract_components;
import Com_qa_pages.Cart_pages;
import Com_qa_pages.Checkout_pages;
import Com_qa_pages.Confirmation_pages;
import Com_qa_pages.Landing_page;
import Com_qa_pages.orders_page;
import Com_qa_pages.product_pages;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample_class extends Testbase{
  // String productname ="ZARA COAT 3";

@Test(dataProvider = "getdata",  groups ={"purchase"}, retryAnalyzer = Abstarct_components.Retry_analyzer.class)
	public void testmain(HashMap<String, String> input) throws IOException, InterruptedException{
		// TODO Auto-generated method stub
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//        options.addArguments("disable-infobars");
//
//		ChromeDriver driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("https://rahulshettyacademy.com/client");
//		Landing_page page = new Landing_page(driver);
		//product_pages prod = new product_pages(driver);
//      Cart_pages cart = new Cart_pages(driver);
//		page.getlogin("bujala123@gmail.com", "Kiran@123");
		
		//Landing_page page = launchapplication();
		//page.Goto();
		product_pages prod =page.getlogin(input.get("email"),input.get("password"));
		//List<WebElement> prodlist = driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']"));
//	  List<WebElement> prodlist =prod.getproductlist();

		
	 //WebElement product =	prodlist.stream().filter(prod2->prod2.findElement(By.xpath("//h5/b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
	 //prod.getproductbyname("ZARA COAT 3");
	 //String text = product.getText();
	//product.findElement(By.xpath("//button[@class=\"btn w-10 rounded\"]")).click();
//		product_pages prod = new product_pages(driver);
//		List<WebElement> prodlist = prod.getproductlist();
	 prod.Addtocart(input.get("product"));
	 
    Thread.sleep(12000);
	Cart_pages cart = prod.getcartbtn();

	   prod.getcartbtn();
	   Boolean ismatch = cart.verifyporductmatch(input.get("product"));
	   Assert.assertTrue(ismatch);
	   Checkout_pages check = cart.gotocheckoutbtn();
	   check.get_country("india");
	   Confirmation_pages confirm = check.get_place_order();
	   String message = confirm.get_confirm();
	   System.out.println(message);
	  
       boolean isvalid = message.contains("THANKYOU");
       Assert.assertTrue(isvalid);
       
    
	//driver.findElement(By.xpath("//button[@routerlink=\"/dashboard/cart\"]")).click();
    
//	

	
//	List<WebElement> cartlist = driver.findElements(By.xpath("//div[@class=\"cartSection\"]//h3"));
//		//List<WebElement> cartlist = prod.getproductlist();
//		for(WebElement b:cartlist) {
//			System.out.println(b.getText());
//		}
//		boolean istrue =cartlist.stream().anyMatch(card->text.contains(card.getText()));
//		System.out.println(text);
//		Assert.assertTrue(istrue, "Product is not matched");
//		driver.findElement(By.xpath("//button[text()=\"Checkout\"]")).click();
//		Actions action = new Actions(driver);
//		action.sendKeys(driver.findElement(By.cssSelector("input[placeholder=\"Select Country\"]")), "india").build().perform();
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//		List<WebElement> droplist =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@class=\"ta-item list-group-item ng-star-inserted\"]")));
//		
//		WebElement dropele = droplist.stream().filter(drop->drop.getText().equalsIgnoreCase("india")).findFirst().orElse(null);
//		dropele.click();
//		driver.findElement(By.xpath("//div[@class=\"actions\"]/a[@class=\"btnn action__submit ng-star-inserted\"]")).click();
//		String name = driver.findElement(By.tagName("h1")).getText();
//		System.out.println(name);
//		boolean verify = name.contains("THANKYOU");
//		Assert.assertTrue(verify, "Text not found");
	
		//driver.quit();

	}

@Test(dependsOnMethods = {"testmain"},enabled = false)

public void validate_orders() {
	   String productname ="ZARA COAT 3";

	
 product_pages product = page.getlogin("bujala123@gmail.com", "Kiran@123");
 orders_page page = product.getorders();
 
 boolean ismatch=page.verify_orders(productname);
 assertTrue(ismatch);
	
}

@Test(dependsOnMethods = {"testmain"} )
public void remove_orders() {
	product_pages product = page.getlogin("bujala123@gmail.com", "Kiran@123");
	 orders_page page = product.getorders();
	
	boolean isremove =page.verify_order_removed();
	Assert.assertTrue(isremove);

	 
	
	
	
	
	
}
@DataProvider
public Object[][] getdata(){
//	
//	Object[][] data = new Object[][]{
//			{"bujala123@gmail.com","Kiran@123","ZARA COAT 3"},
//			{"bhdhh@gmail.com","hdhd","g3d"}
//	};
	
	HashMap<String, String> map = new HashMap<>();
	map.put("email", "bujala123@gmail.com");
	map.put("password","Kiran@123");
	map.put("product", "ZARA COAT 3");
	
	HashMap<String, String> map2 = new HashMap<>();
	map2.put("email","bujala123@gmail.com");
	
	map2.put("password", "Kiran@123");
	map2.put("product", "fhbbd");
	
	return new Object[][] {{map},{map2}};
			
	
	
}



}
