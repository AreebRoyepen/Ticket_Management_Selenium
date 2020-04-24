package ticketmanagementsystem;

import org.testng.annotations.Test;

import selenium.core.BaseTest;
import selenium.mappings.AssertExpectedMappings;
import selenium.mappings.CommonMappings;
import selenium.mappings.ObjectMappingsRepository;

public class EventsTest extends BaseTest{

	@Test
	public void gotoEventPage(){
		
		logOn(CommonMappings.URL_GIS_TICKET_SYTEM, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);
		
		isDisplayed(XPATH, ObjectMappingsRepository.XPATH_APPBAR);
		//String heading = waitUntil(XPATH, ObjectMappingsRepository.XPATH_DASH_HEADING);
	    
		String expectedLink = AssertExpectedMappings.URL_DASHBOARD;
	    String newLink = getCurrentUrl();

	    assertTest(expectedLink,newLink);   //////////Check if user was directed to dashboard
	    
	    click(XPATH, ObjectMappingsRepository.XPATH_MENU);
	    click(XPATH, ObjectMappingsRepository.XPATH_MENU_EVENT);
	    
	    String expectedButton = AssertExpectedMappings.EVENT_PAGE_CREATE_BUTTON;
	    
	    String button = waitUntil(XPATH, ObjectMappingsRepository.XPATH_EVENT_CREATE_BUTTON);
	    
	    assertTest(expectedButton, button);
		
	}
    
	
}
