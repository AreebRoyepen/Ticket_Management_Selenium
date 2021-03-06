package ticketmanagementsystem;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import selenium.core.BaseTest;
import selenium.mappings.AssertExpectedMappings;
import selenium.mappings.CommonMappings;
import selenium.mappings.ObjectMappingsRepository;

public class LoginTest extends BaseTest {
	
	@Test
	public void login() {
		
		logOn(CommonMappings.URL_GIS_TICKET_SYTEM, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);
	
		waitUntilElementIsDisplayed(XPATH, ObjectMappingsRepository.XPATH_APPBAR);
		
        String expectedLink = AssertExpectedMappings.URL_DASHBOARD;
        String newLink = getCurrentUrl();

        assertTest(expectedLink,newLink);   //////////Check if user was directed to dashboard
        
        WebElement heading = waitUntilElementIsDisplayed(XPATH, ObjectMappingsRepository.XPATH_DASH_HEADING);
        
        assertTest(AssertExpectedMappings.DASHBOARD_HEADING, heading.getText());
		
	}
	
	
	@Test
	public void login_fail() {
		
		logOn(CommonMappings.URL_GIS_TICKET_SYTEM, "", "");
 
        WebElement userFeedback = waitUntilElementIsDisplayed(XPATH, ObjectMappingsRepository.XPATH_LOGIN_INVALID_CREDS);
        
        assertTest(AssertExpectedMappings.LOGIN_INVALID_CREDS, userFeedback.getText());
		
	}
	
	

}
