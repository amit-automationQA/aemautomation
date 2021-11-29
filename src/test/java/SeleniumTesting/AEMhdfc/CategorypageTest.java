package SeleniumTesting.AEMhdfc;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObjects.Categorypage;
import PageObjects.Homepage;
import base.BaseClass;

public class CategorypageTest extends BaseClass{
	Homepage hp;
	Categorypage cp;
	HomepageTest ht;
	JavascriptExecutor js;
	//String path = System.getProperty("user.dir") +"\\MC062124237-V01-HDFC-Life-Click-2-Protect-Life-Retail-Brochure.pdf";
	public CategorypageTest() {
		super();
	}

	@BeforeClass(alwaysRun = true)
	public void setUp() throws IOException {
		initializeDriver();
		hp = new Homepage(driver);
		cp = new Categorypage(driver);
		PageFactory.initElements(driver, cp);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		this.js=js;
		ts = (TakesScreenshot) driver;
		//this.ts=ts;
		System.out.println("Category page test cases started");
		folder.mkdir();
		//softAssertion = new SoftAssert();
	}

	@Test(priority=1, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void navigateToPage() throws InterruptedException
	{	
		cp.navigateToTermCategoryPage();
	}

	@Test(priority=2, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyCalculatePremiumBtn() throws InterruptedException
	{
		cp.verifyCalculatePremiumbtn();
		hp.verifyLinkOpenedInNewWindow("https://onlineinsurance.hdfclife.com/buy-online-term-insurance-plans/click-2-protect-life/basic-details?source=NW_CalcP_termcategory&agentcode=00399206&language=en", 
				"https://www.hdfclife.com/term-insurance-plans");
	}

	@Test(priority=3,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyTalkToAdvisor() throws InterruptedException
	{
		cp.clickTalkToAdvisorBtn();
		hp.closeScheduleCallPopup();
	}

	@Test(priority=4, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyTalkToAdvisorPopup() throws InterruptedException
	{
		cp.clickTalkToAdvisorBtn();
		hp.inputForNameAndNumberField("Am", "976846205");
		hp.invalidDataValidationErrorForNameAndNumber();
		hp.closeScheduleCallPopup();
	}

	@Test(priority=5, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyHomeIconInBreadCrumb() throws InterruptedException
	{
		cp.clickHomeIconInBreadcrumb();
	}

	@Test(priority=6, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void verifyC2PLProduct() throws InterruptedException
	{
		js.executeScript("window.scrollBy(0,2700)");
		cp.clickC2plLearnMoreBtn();
		hp.verifyLink("https://www.hdfclife.com/term-insurance-plans/click-2-protect-life");
		cp.downloadBrochure();
		Categorypage.isFileDownloaded("MC062124237-V01-HDFC-Life-Click-2-Protect-Life-Retail-Brochure.pdf");
		cp.clickC2plBuyNowBtn();
		hp.verifyLinkOpenedInNewWindow("https://onlineinsurance.hdfclife.com/buy-online-term-insurance-plans/click-2-protect-life/basic-details?source=NW_C2PL_Bestseller_BuyOl&agentcode=00399206&language=en"
				, "https://www.hdfclife.com/term-insurance-plans");
	}

	@Test(priority=7, dependsOnMethods = { "verifyC2PLProduct" })
	public void verifySJBProduct() throws InterruptedException
	{
		js.executeScript("window.scrollBy(0,800)");
		cp.clickSJBLearnMorebtn();
		hp.verifyLink("https://www.hdfclife.com/term-insurance-plans/saral-jeevan-bima");
		Categorypage.isFileDownloaded("saral-jeevan-brochure.pdf");
		cp.clickSJBBuyOnlineBtn();
		hp.verifyLinkOpenedInNewWindow("https://onlineinsurance.hdfclife.com/buy-online-term-insurance-plans/saral-jeevan-bima/basic-details?source=NW_SJB_BuyOl&agentcode=00399206&language=en"
				,"https://www.hdfclife.com/term-insurance-plans");
	}

	@Test(priority=8, dependsOnMethods = { "verifyC2PLProduct", "verifySJBProduct" })
	public void verifyLetsCalculateWithValidData() throws InterruptedException
	{
		js.executeScript("window.scrollBy(0,-500)");
		cp.clickLetsCalculateBtn();
		hp.verifyLink("https://www.hdfclife.com/financial-tools-calculators/human-life-value-calculator");		
	}
	
	@Test(priority=9, dependsOnMethods = { "verifyC2PLProduct", "verifySJBProduct", "verifyLetsCalculateWithValidData" })
	public void verifyVideoOnCategoryPage() throws InterruptedException
	{
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,900)");
		//cp.verifyVideoOnPage();
	}

	@AfterClass(alwaysRun=true)
	public void tear()
	{
		driver.quit();
		System.out.println("Category page test cases executed");
		cp.deleteFolder();
		System.out.println("Folder deleted for Category downloads");
	}
}
