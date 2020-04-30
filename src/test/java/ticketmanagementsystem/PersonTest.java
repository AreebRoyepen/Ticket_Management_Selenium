package ticketmanagementsystem;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.core.BaseTest;
import selenium.mappings.AssertExpectedMappings;
import selenium.mappings.CommonMappings;
import selenium.mappings.ObjectMappingsRepository;

public class PersonTest extends BaseTest{

	@Test
	public void gotoPersonPage(){
		
		logOn(CommonMappings.URL_GIS_TICKET_SYTEM, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);
		
		waitUntilElementIsDisplayed(XPATH, ObjectMappingsRepository.XPATH_APPBAR);
	    
		String expectedLink = AssertExpectedMappings.URL_DASHBOARD;
	    String newLink = getCurrentUrl();

	    assertTest(expectedLink,newLink);   //////////Check if user was directed to dashboard
	    
	    click(XPATH, ObjectMappingsRepository.XPATH_MENU);
	    click(XPATH, ObjectMappingsRepository.XPATH_MENU_PEOPLE);
	    
	    String expectedButton = AssertExpectedMappings.PEOPLE_PAGE_ADD_BUTTON;
	    
	    WebElement button = waitUntilElementIsDisplayed(XPATH, ObjectMappingsRepository.XPATH_ADD_PERSON_BUTTON);
	    
	    assertTest(expectedButton, button.getText());
		
	}
    
	@Test
	public void gotoAddPersonPage(){
		
		logOn(CommonMappings.URL_GIS_TICKET_SYTEM, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);
		
		waitUntilElementIsDisplayed(XPATH, ObjectMappingsRepository.XPATH_APPBAR);
	    
	    click(XPATH, ObjectMappingsRepository.XPATH_MENU);
	    click(XPATH, ObjectMappingsRepository.XPATH_MENU_PEOPLE);
	    
	    WebElement button = waitUntilElementIsDisplayed(XPATH, ObjectMappingsRepository.XPATH_ADD_PERSON_BUTTON);
	    button.click();
	    
	    WebElement button2 = waitUntilElementIsDisplayed(XPATH, ObjectMappingsRepository.XPATH_ADD_PERSON_CANCEL_BUTTON);
	    
	    String expectedButton = AssertExpectedMappings.ADD_PERSON_PAGE_CANCEL_BUTTON;
	    
	    assertTest(expectedButton, button2.getText());
		
	}
	
	@Test
	public void gotoEditPersonPage(){
		
		logOn(CommonMappings.URL_GIS_TICKET_SYTEM, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);
		
		waitUntilElementIsDisplayed(XPATH, ObjectMappingsRepository.XPATH_APPBAR);
	    	    
	    click(XPATH, ObjectMappingsRepository.XPATH_MENU);
	    click(XPATH, ObjectMappingsRepository.XPATH_MENU_PEOPLE);    
	    
	    WebElement button = waitUntilElementIsDisplayed(XPATH, ObjectMappingsRepository.XPATH_PERSON_CARD_EDIT_BUTTON);
	    
	    button.click();
	    WebElement button2 = waitUntilElementIsDisplayed(XPATH, ObjectMappingsRepository.XPATH_EDIT_PERSON_SUBMIT_BUTTON);

	    String expectedButton = AssertExpectedMappings.EDIT_PERSON_PAGE_SUBMIT_BUTTON;
	    
	    assertTest(expectedButton, button2.getText());
		
	}
	
}
