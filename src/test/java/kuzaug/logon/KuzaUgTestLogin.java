package kuzaug.logon;

import org.testng.annotations.Test;
import selenium.core.BaseTest;
import selenium.mappings.AssertExpectedMappings;
import selenium.mappings.CommonMappings;
import selenium.mappings.ObjectMappingsRepository;
import selenium.core.TestUtil;

public class KuzaUgTestLogin extends BaseTest {

    @Test
    public void testLogin() {

        loadLink(CommonMappings.URL_KUZA_UG);

        //find input by id="username" and enter value="selenium"
        enterText(ID, ObjectMappingsRepository.ID_USERNAME, CommonMappings.VALUE_USERNAME);

        //find input by id="password" and enter value="Selenium@19"
        enterText(ID, ObjectMappingsRepository.ID_PASSWORD, CommonMappings.VALUE_PASSWORD);

        //find element by class ="input2"
        click(CLASS, ObjectMappingsRepository.CLASS_SUBMIT_AT_LOGIN);

        //get page title text
        String loadedUrl = getCurrentUrl();

        waitFor(1000);
    
        assertTest(AssertExpectedMappings.LANDING_PAGE_URL_KUZA_UG, loadedUrl);
    }


    @Test
    public void testNavigationToResetPasswordPage() {

        loadLink(CommonMappings.URL_KUZA_UG);

        //click a link with text `Forgot your password`
        click(LINK_TEXT, CommonMappings.LINK_RESET_PASSWORD);

        //get current url
        String loadedUrl = getCurrentUrl();
        String expectedUrl = CommonMappings.URL_KUZA_UG_RESET_PASSWORD;

        waitFor(10000);
        
        //report the test
        assertTest(loadedUrl, expectedUrl);
    }

    @Test
    public void testResetPasswordWithInvalidEmail() {
        loadLink(CommonMappings.URL_KUZA_UG);

        //click a link with text `Forgot your password`
        click(LINK_TEXT,  CommonMappings.LINK_RESET_PASSWORD);

        //enter invalid email address
        enterText(NAME, ObjectMappingsRepository.NAME_EMAIL, CommonMappings.VALUE_EMAIL);

        click(TAG_NAME, ObjectMappingsRepository.TAG_BUTTON);

        String alertMessage = getAlertText();

        assertTest(AssertExpectedMappings.INVALID_EMAIL_MODAL, alertMessage);
    }

}
