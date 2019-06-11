package stepDefinition;

import appium.BaseTest;
import cucumber.api.java.en.Given;

public class StepDefinition extends BaseTest{




	/*@Given("^I open the www\\.google\\.com$")
	public void i_open_the_www_google_com(String url) throws Throwable {

		driver.get(url);

	    //throw new PendingException();

	}*/



	@Given("^I open the url$")
	public void i_open_the_url() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://www.google.com");

	    //throw new PendingException();
	}


	/*@When("^I check for the title in step$")
	public void i_check_for_the_in_step(String  title) throws Throwable {
		b=driver.getTitle().contains(title);

	    //throw new PendingException();
	}

	@Then("^I verify the success in step$")
	public void i_verify_the_success_in_step(String status) throws Throwable {
		Assert.assertEquals(b, status);
	    //throw new PendingException();
	}
*/

	@Override
	public void setUpPage() {
		// TODO Auto-generated method stub

	}

}
