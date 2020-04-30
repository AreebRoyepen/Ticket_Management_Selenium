package ticketmanagementsystem;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.core.BaseTest;
import selenium.mappings.AssertExpectedMappings;
import selenium.mappings.CommonMappings;
import selenium.mappings.ObjectMappingsRepository;

public class EventsTest extends BaseTest{

	@Test
	public void gotoEventPage(){
		
		logOn(CommonMappings.URL_GIS_TICKET_SYTEM, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);
		
		waitUntilElementIsDisplayed(XPATH, ObjectMappingsRepository.XPATH_APPBAR);
	    
		String expectedLink = AssertExpectedMappings.URL_DASHBOARD;
	    String newLink = getCurrentUrl();

	    assertTest(expectedLink,newLink);   //////////Check if user was directed to dashboard
	    
	    click(XPATH, ObjectMappingsRepository.XPATH_MENU);
	    click(XPATH, ObjectMappingsRepository.XPATH_MENU_EVENT);
	    
	    String expectedButton = AssertExpectedMappings.EVENT_PAGE_CREATE_BUTTON;
	    
	    WebElement button = waitUntilElementIsDisplayed(XPATH, ObjectMappingsRepository.XPATH_EVENT_CREATE_BUTTON);
	    
	    assertTest(expectedButton, button.getText());
		
	}
    
	@Test
	public void gotoCreateEventPage(){
		
		logOn(CommonMappings.URL_GIS_TICKET_SYTEM, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);
		
		waitUntilElementIsDisplayed(XPATH, ObjectMappingsRepository.XPATH_APPBAR);
	    
	    click(XPATH, ObjectMappingsRepository.XPATH_MENU);
	    click(XPATH, ObjectMappingsRepository.XPATH_MENU_EVENT);
	    
	    
	    
	    WebElement button = waitUntilElementIsDisplayed(XPATH, ObjectMappingsRepository.XPATH_EVENT_CREATE_BUTTON);
	    button.click();
	    
	    WebElement button2 = waitUntilElementIsDisplayed(XPATH, ObjectMappingsRepository.XPATH_CREATE_EVENT_CANCEL_BUTTON);
	    
	    String expectedButton = AssertExpectedMappings.CREATE_EVENT_PAGE_CANCEL_BUTTON;
	    
	    assertTest(expectedButton, button2.getText());
		
	}
}
