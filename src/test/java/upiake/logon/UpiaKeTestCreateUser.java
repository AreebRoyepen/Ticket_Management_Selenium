package upiake.logon;

import org.testng.annotations.Test;
import selenium.config.ETarget;
import selenium.core.BaseTest;
import selenium.core.TestUtil;
import selenium.mappings.AssertExpectedMappings;
import selenium.mappings.CommonMappings;
import selenium.mappings.ObjectMappingsRepository;

public class UpiaKeTestCreateUser extends BaseTest {

    @Test
    public void loadCreateUserForm() {
    
        logOn(CommonMappings.URL_UPIA_KE, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);
        waitFor(3000);
        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_USER_IMG);
        click(LINK_TEXT, CommonMappings.LINK_ADD_NEW_USER);
  
        String actualHeading = getText(XPATH, ObjectMappingsRepository.CREATE_USER_FORM_HEADING);
        waitFor(3000);
        assertTest(AssertExpectedMappings.CREATE_USER_FORM, actualHeading);
        
    }

    @Test
    public void submitBlankUserDetails() {
    	    	
    	//logOn(CommonMappings.URL_UPIA_KE, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);
     
        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_USER_IMG);
        click(LINK_TEXT, CommonMappings.LINK_ADD_NEW_USER);

        waitFor(3000);

        ///select the 1st element in the Title dropdown
        selectOneByIndex(NAME,ObjectMappingsRepository.NAME_TITLE, 1);

        //Select the 1st element in the Station dropdown
        selectOneByIndex(ID, ObjectMappingsRepository.NAME_STATIONS, 1);
  
        String actualHeading = getText(XPATH, ObjectMappingsRepository.CREATE_USER_FORM_HEADING);
         
        click(TAG_NAME, ObjectMappingsRepository.TAG_BUTTON);

        String alertMessage = getAlertText();
        //waitFor(3000);
        assertTest(AssertExpectedMappings.ENTER_VALID_NEW_USER.substring(0, 30), alertMessage.substring(0, 30));

    }

}
