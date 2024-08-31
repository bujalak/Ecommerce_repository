package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import Abstarct_components.Retry_analyzer;
import Com_qa_pages.Cart_pages;
import Com_qa_pages.product_pages;

public class Error_validations extends Testbase{
	@Test(groups = {"error"})
	public void login_test() throws InterruptedException {
	  page.getlogin("bujala123@gmail.com", "hbh");
	 //Thread.sleep(3000);
	  System.out.println(page.errormessage());
	  Assert.assertTrue(page.errormessage().contains("Incorrect"));
}
	
	
	@Test
	
	public void product_error_validations() throws InterruptedException {
		String productname ="ZARA COAT 3";

		product_pages prod =page.getlogin("bujala123@gmail.com", "Kiran@123");
		 prod.Addtocart(productname);;
		 
		    Thread.sleep(12000);
			Cart_pages cart = prod.getcartbtn();

			   prod.getcartbtn();
			   Boolean ismatch = cart.verifyporductmatch("fh");
			   Assert.assertTrue(ismatch);
	}

}
