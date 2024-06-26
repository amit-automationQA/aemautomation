package PageObjects;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import base.BaseClass;

public class Categorypage extends BaseClass{
	
	//static SoftAssert softAssertion = new SoftAssert();
	//https://stackoverflow.com/questions/59083170/single-soft-assertion-error-is-failing-subsequent-passed-scenarios
	//Reason why the above code was commented and softAssert is not declared globally
/*Your dataprovider powered @Test method is basically using one SoftAssert instance and then invoking an assertAll() for all data provider data set iterations using the same instance.
SoftAssert is designed to remember all assertions that have been recorded so far via calls to assertXXX.
To fix this problem you should be instantiating the SoftAssert object inside the @Test method*/
	
	public static Logger log=LogManager.getLogger(Categorypage.class.getName());
	
	//Constructor for avoiding null pointer exception on driver
	public Categorypage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(xpath="//a[@class='megaMenuLink']")
	WebElement headeralllink;

	@FindBy(xpath="(//a[@class='moreMenuLink gtm-moreMenuLink'])[1]")
	WebElement termpagelink;

	@FindBy(xpath="//a[@class='siteButton dataLayerBtnClick']")
	WebElement calculatepremiumbtn;

	@FindBy (xpath="(//a[@class='siteButton outlinedBtn'])[4]")
	WebElement talktoadvisorbtn;

	@FindBy(xpath="//img[@class='homeIconImg']")
	WebElement breadcrumbhomeicon;

	@FindBy(xpath="(//a[@class='siteButton outlinedBtn learMoreBtn dataLayerBtnClick'])[1]")
	WebElement c2pllearnmorebtn;

	@FindBy(xpath="(//a[@class='dwnldLink dataLayerBtnClick'])[1]")
	WebElement c2pldowbloadbrochure;

	@FindBy(xpath="(//a[@class='dwnldLink dataLayerBtnClick'])[2]")
	WebElement sjbdownloadbrochure;

	@FindBy(xpath="(//a[@class='siteButton buyOnlineBtn dataLayerBtnClick'])[1]")
	WebElement c2plbuyonlinebtn;

	@FindBy(xpath="(//a[@class='siteButton outlinedBtn learMoreBtn dataLayerBtnClick'])[2]")
	WebElement sjblearnmorebtn;

	@FindBy(xpath="(//a[@class='siteButton buyOnlineBtn dataLayerBtnClick'])[2]")
	WebElement sjbbuyonlinebtn;

	@FindBy(xpath="(//a[@class='bannerAdBtn siteButton'])[1]")
	WebElement letscalculate;

	@FindBy(xpath="(//a[@class='viewMoreBtn'])[1]")
	WebElement whysectionviewmorebtn;

	@FindBy(xpath="(//a[@class='viewMoreBtn viewLessBtn'])[1]")
	WebElement whysectionviewlessbtn;

	@FindBy(xpath="//h2[@class='tabAccordMenu opened']")
	WebElement openedfaqaccordion;

	@FindBy(xpath="(//h2[@class='tabAccordMenu'])[2]")
	WebElement closedsecondfaqaccordion;

	@FindBy(xpath="(//a[@class='viewMoreBtn'])[2]")
	WebElement buyingguideviewmorebtn;

	@FindBy(xpath="(//a[@class='viewMoreBtn'])[2]")
	WebElement termguideviewmorebtn;

	@FindBy(xpath="//a[@class='viewMoreBtn viewLessBtn']")
	WebElement termguideviewlessbtn;

	@FindBy(xpath="(//a[@class='viewMoreBtn'])[5]")
	WebElement ridersectionviewmorebtn;

	@FindBy(how=How.CSS,using=".siteButton.outlinedBtn")
	List<WebElement> allbuttons;

	@FindBy(xpath="(//a[@class='bannerAdBtn siteButton'])[2]")
	WebElement contactusbtn;

	@FindBy(xpath="//button[normalize-space()='VIEW MORE']")
	WebElement articlesviewmorebtn;

	@FindBy(xpath="//a[@href='/content/dam/hdfclifeinsurancecompany/products-page/brochure-links/HDFC-Life-Protect-Plus-Rider.pdf']")
	WebElement thirdrider;

	@FindBy(xpath="(//ul[@class='insuranceBenList'])[1]")
	WebElement firstrowriderdownloadbuttons;

	@FindBy(xpath="(//ul[@class='insuranceBenList'])[2]")
	WebElement secondrowriderdownloadbuttons;
	
	@FindBy(xpath="//div[@class='container aboutus-sec']")
	WebElement articleblocks;
	
	@FindBy(xpath="//iframe[@src='https://www.youtube.com/embed/rVtiZXQhugM?rel=0&showinfo=0&enablejsapi=1&origin=https%3A%2F%2Fwww.hdfclife.com']")
	WebElement frameElement;

	@FindBy(xpath="//button[@aria-label='Play (k)']")
	WebElement playbutton;
	
	@FindBy(xpath="//button[@Class='ytp-mute-button ytp-button']")
	WebElement mutebutton;
	
	
	
	//Initialized objects
	public void clickheaderAllLink()
	{
		headeralllink.click();
	}

	public void navigateToTermCategoryPage() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		headeralllink.click();
		Thread.sleep(3000);
		termpagelink.click();
		Thread.sleep(3000);
		softAssertion.assertEquals(driver.getCurrentUrl(), "https://www.hdfclife.com/term-insurance-plans");
		softAssertion.assertAll();
		Thread.sleep(3000);
	}


	public void verifyCalculatePremiumbtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertTrue(calculatepremiumbtn.isDisplayed());
		calculatepremiumbtn.click();
		Thread.sleep(3000);
	}

	public void clickTalkToAdvisorBtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(talktoadvisorbtn.isDisplayed());
		softAssertion.assertTrue(talktoadvisorbtn.isEnabled());
		talktoadvisorbtn.click();
		softAssertion.assertAll();
		Thread.sleep(3000);
	}

	public void clickHomeIconInBreadcrumb() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		breadcrumbhomeicon.isDisplayed();
		breadcrumbhomeicon.click();
		Thread.sleep(3000);
		softAssertion.assertEquals(driver.getCurrentUrl(), "https://www.hdfclife.com/");
		Thread.sleep(3000);
	}

	public WebElement c2plLearnMoreBtn()
	{
		return c2pllearnmorebtn;
	}

	public void clickC2plLearnMoreBtn() throws InterruptedException
	{
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(c2pllearnmorebtn));
		c2pllearnmorebtn.isDisplayed();
		c2pllearnmorebtn.click();
		Thread.sleep(3000);
	}

	public void downloadBrochure()
	{
		c2pldowbloadbrochure.click();
	}

	public void sjbDownloadBrochure()
	{
		sjbdownloadbrochure.click();
	}

	public Boolean isFileDownloaded(String fileName) throws InterruptedException {
		Thread.sleep(3000);
		boolean flag = false;
		//paste your directory path below
		//eg: C:\\Users\\username\\Downloads
		File []listOfFiles= folder.listFiles();
		if (listOfFiles.length == 0 || listOfFiles == null) {
			System.out.println("The directory is empty");
			flag = false;
		} else {
			for (File listFile : listOfFiles) {
				if (listFile.getName().contains(fileName)) {
					log.info(fileName + " is present");
				}
				else {
					log.error(fileName + " is incorrect");	
				}
				flag = true;
			}
		}
		return flag;
	}


	public void deleteFolder()
	{
		for(File file : folder.listFiles())
		{
			file.delete();
		}
		folder.delete();
	}

	public void clickC2plBuyNowBtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertTrue(c2plbuyonlinebtn.isDisplayed());
		c2plbuyonlinebtn.click();
	}

	public void clickSJBLearnMorebtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertTrue(sjblearnmorebtn.isDisplayed());
		sjblearnmorebtn.click();
	}

	public void clickSJBBuyOnlineBtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertTrue(sjbbuyonlinebtn.isDisplayed());
		sjbbuyonlinebtn.click();
	}

	public void clickLetsCalculateBtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertTrue(letscalculate.isDisplayed());
		letscalculate.click();
	}

	public void verifyWhyViewMoreAndViewLess() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertTrue(whysectionviewmorebtn.isDisplayed()); // verify on page load
		whysectionviewmorebtn.click();
		Thread.sleep(3000);
		if(whysectionviewlessbtn.isDisplayed()) {
			whysectionviewlessbtn.click();
			Thread.sleep(3000);
			softAssertion.assertTrue(whysectionviewmorebtn.isDisplayed());
		}
		else {
			log.error("View Less button is not getting displayed in Why section after clicking on view more");

		}
	}

	public void verifyFirstOpenFAQ() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		String openaccordionclassname = openedfaqaccordion.getAttribute("class");
		if(openaccordionclassname.contains("tabAccordMenu opened"))
		{
			softAssertion.assertTrue(true, "First FAQ accordion is open on page load");
			log.info("First FAQ accordion is open on page load");
			openedfaqaccordion.click();
		}
		else {
			softAssertion.assertTrue(false, "First FAQ accordion is not open bydefault");
			log.error("First FAQ accordion is not open bydefault");
		}
		//softAssertion.assertAll();
	}

	public void verifysecondFAQ() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertTrue(closedsecondfaqaccordion.isDisplayed());
		closedsecondfaqaccordion.click();
		Thread.sleep(3000);
		String openaccordionclassname1 = openedfaqaccordion.getAttribute("class");
		if(openaccordionclassname1.contains("tabAccordMenu opened"))
		{
			softAssertion.assertTrue(true, "Second FAQ accordion is opened on click");
			log.info("Second FAQ accordion is opened on click");
			openedfaqaccordion.click();
		}
		else {
			softAssertion.assertTrue(false, "Second FAQ accordion is not opened on click");
			log.error("Second FAQ accordion is not opened on click");
		}
		//softAssertion.assertAll();
	}

	public void verifyTermGuideViewMoreBtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		if(termguideviewmorebtn.isDisplayed())
		{
			termguideviewmorebtn.click();
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,900)");
			Thread.sleep(3000);
			termguideviewlessbtn.click();
			Thread.sleep(3000);
			softAssertion.assertTrue(termguideviewmorebtn.isDisplayed());
		}
		else {
			//softAssertion.assertTrue(false, "View more button for term insurance buying guide is not visible on page load");
			log.error("View more button for term insurance buying guide is not visible on page load");
		}
		//softAssertion.assertAll();
	}

	public void verifyViewMoreOnLoad() throws InterruptedException
	{
		Thread.sleep(3000);
		if(ridersectionviewmorebtn.isDisplayed())
		{
			ridersectionviewmorebtn.click();
			Thread.sleep(3000);
		}	
	}

	public void firstRowClickDownloadBtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
log.info("Verification for download button in rider section started");
		List<WebElement> lin = firstrowriderdownloadbuttons.findElements(By.tagName("a"));
		int nooflinksinfirstrow = lin.size();
		log.info(" the number of buttons in download riders section : " +nooflinksinfirstrow);;
		for(int i=0; i<nooflinksinfirstrow; i++) {
			//List<WebElement> linNew = firstrowriderdownloadbuttons.findElements(By.tagName("a"));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			WebElement firstrowdowloadbutton = lin.get(i);
			js.executeScript("arguments[0].scrollIntoView(true);",firstrowdowloadbutton);
			Thread.sleep(3000);		
			//String pageName = linkss.getAttribute("innerText");
			//String href = linkss.getAttribute("href");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", firstrowdowloadbutton);
			Thread.sleep(3000);
			Set<String> windows = driver.getWindowHandles();
			Iterator<String>it2=windows.iterator();
			String parentId= it2.next();
			String childId=it2.next();
			driver.switchTo().window(childId);
			Thread.sleep(3000);
			//softAssertion.assertEquals(driver.getCurrentUrl(),childurl);
			driver.close();
			driver.switchTo().window(parentId);
			softAssertion.assertEquals(driver.getCurrentUrl(), "https://www.hdfclife.com/term-insurance-plans");
			Thread.sleep(3000);
		}
	}
	public void secondRowClickDownloadBtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		List<WebElement> linnew1= secondrowriderdownloadbuttons.findElements(By.tagName("a"));
		int nooflinksinsecondrow=linnew1.size();
		log.info(" the number of buttons in second row in download riders section : " +nooflinksinsecondrow);
		for(int j=0; j<nooflinksinsecondrow; j++) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			WebElement secondrowdownloadbutton = linnew1.get(j);
			js.executeScript("arguments[0].scrollIntoView(true);",secondrowdownloadbutton);
			Thread.sleep(3000);		
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", secondrowdownloadbutton);
			Thread.sleep(3000);
			Set<String> windows1 = driver.getWindowHandles();
			Iterator<String>it3=windows1.iterator();
			String parentId1= it3.next();
			String childId1=it3.next();
			driver.switchTo().window(childId1);
			Thread.sleep(3000);
			driver.close();
			driver.switchTo().window(parentId1);
			softAssertion.assertEquals(driver.getCurrentUrl(), "https://www.hdfclife.com/term-insurance-plans");
			Thread.sleep(3000);
		}
	}



	public void clickContactUsBtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertTrue(contactusbtn.isDisplayed());
		contactusbtn.click();
		Thread.sleep(3000);
	}

	public void verifyArticles() throws InterruptedException
	{
		Thread.sleep(3000);
		log.info("Article section verification started");
		//WebElement article = driver.findElement(By.xpath("//div[@class='container aboutus-sec']"));
		List<WebElement> articletileswithlinks = articleblocks.findElements(By.tagName("a"));
		
		int noofarticlelinks = articletileswithlinks.size();
		log.info(" the number of link in article section : " +noofarticlelinks);
		
		int count=0;
		for(int i=0; i<noofarticlelinks; i++) {
			//WebElement articleNew = driver.findElement(By.xpath("//div[@class='container aboutus-sec']"));
			List<WebElement> articletileswithlinks1 = articleblocks.findElements(By.tagName("a"));
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			WebElement articletile = articletileswithlinks1.get(i);

			js.executeScript("arguments[0].scrollIntoView(true);",articletile);
			Thread.sleep(3000);		
			String pageName = articletile.getAttribute("innerText");
			String href = articletile.getAttribute("href");
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", articletile);
			Thread.sleep(3000);
			String title =driver.getTitle();
			
			log.info(pageName+" and URL is: "+href);
			 if(title.contains("404")) 
			 { 
				 log.error("Broken link found"); count++;
			 }
			 
			String originalWindow = driver.getWindowHandle();
			driver.switchTo().window(originalWindow);
			Actions action= new Actions(driver);
			action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();
			driver.navigate().forward();	
			driver.navigate().back();	
			driver.navigate().refresh();
			 
			Thread.sleep(3000);	
		}	
		if(count==0) {
			log.info("No Broken link found");
		}
		
		log.info("Article section test case ended");
		Thread.sleep(3000);
	}

	public void clickViewMoreBtn() throws InterruptedException
	{
		SoftAssert softAssertion = new SoftAssert();
		Thread.sleep(3000);
		softAssertion.assertTrue(articlesviewmorebtn.isDisplayed());
		articlesviewmorebtn.click();
	}
	
	public void closeAdvPopup() throws InterruptedException
	{
		WebElement adclose= driver.findElement(By.id("nv_js-box-close-button_17168"));
		if(adclose.isDisplayed())
		{
			Thread.sleep(3000);
			adclose.click();
			Thread.sleep(2000);
		}
	}
	
	public void youtubeVideoVerification() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.switchTo().frame(frameElement);
		Thread.sleep(5000);
		js.executeScript("arguments[0].click();", playbutton);
		System.out.println("video is playing");
		js.executeScript("arguments[0].click();", mutebutton);
		System.out.println("video is muted now");
		Thread.sleep(10000);
		driver. switchTo(). defaultContent();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebElement pausebutton =driver.findElement(By.xpath("//button[@aria-label='Pause (k)']"));
		//js.executeScript("arguments[0].click();", pausebutton);
		//System.out.println("pause");
	}
	

}




