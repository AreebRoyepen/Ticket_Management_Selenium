package kuzaug.admin.userProfiles;

import org.testng.annotations.Test;
import selenium.mappings.AssertExpectedMappings;
import selenium.mappings.CommonMappings;
import selenium.mappings.MessageRepositoryMappings;
import selenium.mappings.ObjectMappingsRepository;
import selenium.core.BaseTest;

public class KuzaUgTestCreateUserProfile extends BaseTest {

    @Test
    public void loadCreateUserForm() {
    
        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);
     
        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_USER_IMG);
        click(LINK_TEXT, CommonMappings.LINK_ADD_NEW_USER);
        waitFor(3000);
        String actualHeading = getText(XPATH, ObjectMappingsRepository.CREATE_USER_FORM_HEADING);
        assertTest(AssertExpectedMappings.CREATE_USER_FORM, actualHeading);
        
    }

    @Test
    public void submitBlankUserDetails() {

        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);

        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_USER_IMG);
        click(LINK_TEXT, CommonMappings.LINK_ADD_NEW_USER);

        waitFor(3000);

        ///select the 1st element in the Title dropdown
        selectOneByIndex(NAME,ObjectMappingsRepository.NAME_TITLE, 1);

        //Select the 1st element in the Station dropdown
        selectOneByIndex(ID,  ObjectMappingsRepository.ID_STATION, 1);

        String actualHeading = getText(XPATH, ObjectMappingsRepository.CREATE_USER_FORM_HEADING);
        click(TAG_NAME, ObjectMappingsRepository.TAG_BUTTON);

        String alertMessage = getAlertText();
        //Mandatory field check
        assertTest(AssertExpectedMappings.ENTER_VALID_NEW_USER.substring(0, 30), alertMessage.substring(0, 30));

    }

    @Test
    public void addAdminUser() {

        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);

        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_USER_IMG);
        click(LINK_TEXT, CommonMappings.LINK_ADD_NEW_USER);

        waitFor(3000);
        //Add a First name and Last name
        enterText(ID, ObjectMappingsRepository.ID_FIRST_NAME, CommonMappings.VALUE_NAME);
        enterText(ID, ObjectMappingsRepository.ID_LAST_NAME, CommonMappings.VALUE_NAME);
        //Add a username and email address
        enterText(ID, ObjectMappingsRepository.ID_USERNAME, CommonMappings.VALUE_ADMIN_USERNAME);
        enterText(ID, ObjectMappingsRepository.ID_EMAIL, CommonMappings.VALUE_ADMIN_EMAIL);

        //Select Station and Title
        selectOneByVisibleText(NAME,ObjectMappingsRepository.NAME_TITLE, CommonMappings.VALUE_TITLE_ADMINISTRATOR);
        selectOneByVisibleText(ID,  ObjectMappingsRepository.ID_STATION, CommonMappings.VALUE_STATION_KARENHQ);

        //Enter a temporary password for the user and retype the password
        enterText(ID, ObjectMappingsRepository.ID_PASSWORD_MAIN, CommonMappings.VALUE_ADMIN_PASSWORD);
        enterText(ID, ObjectMappingsRepository.ID_PASSWORD_CONFIRM, CommonMappings.VALUE_ADMIN_PASSWORD);
        enterText(ID, ObjectMappingsRepository.ID_ADMIN_STATUS, CommonMappings.VALUE_TITLE_ADMINISTRATOR);

        String actualHeading = getText(XPATH, ObjectMappingsRepository.CREATE_USER_FORM_HEADING);

        click(TAG_NAME, ObjectMappingsRepository.TAG_BUTTON);
        //To assert, get page title text
        waitFor(1000);
        assertTest(AssertExpectedMappings.CREATE_USER_FORM, actualHeading);

    }

    @Test
    public void addUserPasswordRequirementsNotMet() {

        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);

        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_USER_IMG);
        click(LINK_TEXT, CommonMappings.LINK_ADD_NEW_USER);

        waitFor(3000);
        //Add a First name and Last name
        enterText(ID, ObjectMappingsRepository.ID_FIRST_NAME, CommonMappings.VALUE_NAME);
        enterText(ID, ObjectMappingsRepository.ID_LAST_NAME, CommonMappings.VALUE_NAME);
        //Add a username and email address
        enterText(ID, ObjectMappingsRepository.ID_USERNAME, CommonMappings.VALUE_USERNAME);
        enterText(ID, ObjectMappingsRepository.ID_EMAIL, CommonMappings.VALUE_EMAIL);

        //Enter a temporary password for the user and retype the password
        enterText(ID, ObjectMappingsRepository.ID_PASSWORD_MAIN, "test");
        enterText(ID, ObjectMappingsRepository.ID_PASSWORD_CONFIRM, "test");

        //Click save
        click(TAG_NAME, ObjectMappingsRepository.TAG_BUTTON);

        //Check that error message is displayed
        waitFor(1000);
        String errorMessage = getText(XPATH, ObjectMappingsRepository.XPATH_PASSWORD_REQ_NOT_MET);
        assertTest(MessageRepositoryMappings.USER_PROFILE_PASSWORD_REQ_NOT_MET, errorMessage);

    }

    @Test
    public void searchUserProfile() {
        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);

        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_USER_IMG);

        //Search to see if the user is in the list
        enterText(XPATH, ObjectMappingsRepository.XPATH_USER_SEARCH_INPUT, CommonMappings.VALUE_USERNAME);

        String searchResultsInfo = getText(XPATH, ObjectMappingsRepository.XPATH_USER_SEARCH_RESULTS);
        assertTest(CommonMappings.VALUE_USERNAME, searchResultsInfo);
    }

    @Test
    public void logInWithIncorrectTempPassword() {
        //log in with incorrect/old password
        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_ADMIN_USERNAME, CommonMappings.VALUE_ADMIN_PASSWORD);
        waitFor(1000);
        //Enter username
        enterText(ID, ObjectMappingsRepository.ID_USERNAME, CommonMappings.VALUE_ADMIN_USERNAME);

        //Enter the incorrect temp password in old password field
        enterText(ID, ObjectMappingsRepository.ID_OLD_PASSWORD, "test");
        enterText(ID, ObjectMappingsRepository.ID_NEW_PASSWORD, CommonMappings.VALUE_ADMIN_PASSWORD);
        enterText(ID, ObjectMappingsRepository.ID_CONFIRM_PASSWORD, CommonMappings.VALUE_ADMIN_PASSWORD);

        //click submit button
        click(CLASS, ObjectMappingsRepository.CLASS_SUBMIT_AT_LOGIN);
        //Check that error message is displayed
        waitFor(1000);
        String errormessage = getText(XPATH, ObjectMappingsRepository.XPATH_INCORRECT_TEMP_PASSWORD);
        assertTest(MessageRepositoryMappings.INCORRECT_PASSWORD, errormessage);
    }

    @Test
    public void logInWithCorrectTempPassword() {
        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);

        //Add a new user
        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_USER_IMG);
        click(LINK_TEXT, CommonMappings.LINK_ADD_NEW_USER);

        waitFor(1000);
        //Add a First name and Last name
        enterText(ID, ObjectMappingsRepository.ID_FIRST_NAME, CommonMappings.VALUE_USER_NAME);
        enterText(ID, ObjectMappingsRepository.ID_LAST_NAME, CommonMappings.VALUE_USER_NAME);
        //Add a username and email address
        enterText(ID, ObjectMappingsRepository.ID_USERNAME, CommonMappings.VALUE_USER_USERNAME);
        enterText(ID, ObjectMappingsRepository.ID_EMAIL, CommonMappings.VALUE_USER_EMAIL);

        //Select Station and Title
        selectOneByVisibleText(NAME,ObjectMappingsRepository.NAME_TITLE, CommonMappings.VALUE_TITLE_ADMINISTRATOR);
        selectOneByVisibleText(ID,  ObjectMappingsRepository.ID_STATION, CommonMappings.VALUE_STATION_KARENHQ);

        //Enter a temporary password for the user and retype the password
        enterText(ID, ObjectMappingsRepository.ID_PASSWORD_MAIN, CommonMappings.VALUE_USER_PASSWORD);
        enterText(ID, ObjectMappingsRepository.ID_PASSWORD_CONFIRM, CommonMappings.VALUE_USER_PASSWORD);
        enterText(ID, ObjectMappingsRepository.ID_ADMIN_STATUS, CommonMappings.VALUE_TITLE_ADMINISTRATOR);
        click(TAG_NAME, ObjectMappingsRepository.TAG_BUTTON);
        /////////////////////////////////////////////////////////
        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USER_USERNAME, CommonMappings.VALUE_USER_PASSWORD);
        waitFor(1000);
        //Enter username and old password
        enterText(ID, ObjectMappingsRepository.ID_USERNAME, CommonMappings.VALUE_USER_USERNAME);
        enterText(ID, ObjectMappingsRepository.ID_OLD_PASSWORD, CommonMappings.VALUE_USER_PASSWORD);

        //Enter new password and confirm password
        enterText(ID, ObjectMappingsRepository.ID_NEW_PASSWORD, CommonMappings.VALUE_USER_NEW_PASSWORD);
        enterText(ID, ObjectMappingsRepository.ID_CONFIRM_PASSWORD, CommonMappings.VALUE_USER_NEW_PASSWORD);

        //click submit button
        click(CLASS, ObjectMappingsRepository.CLASS_SUBMIT_AT_LOGIN);
        //To assert, get page title text
        waitFor(1000);
        String actualHeading = getText(XPATH, ObjectMappingsRepository.KUZA_LANDING_PAGE_HEADING);
        assertTest(AssertExpectedMappings.KUZA_LANDING_PAGE_HEADING, actualHeading);
    }

    @Test
    public void disableUser() {
        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);
        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_USER_IMG);

        //first do a search for the username
        enterText(XPATH, ObjectMappingsRepository.XPATH_USER_SEARCH_INPUT, CommonMappings.VALUE_ADMIN_USERNAME);

        //Then click the disable image for that username
        click(XPATH, ObjectMappingsRepository.XPATH_DISABLE_ENABLE_USER_IMG);
        waitFor(1000);

        //do a search for the username again
        enterText(XPATH, ObjectMappingsRepository.XPATH_USER_SEARCH_INPUT, CommonMappings.VALUE_ADMIN_USERNAME);

        //To assert, check that the 'Status' column displays Disabled
        String actualValue = getText(XPATH, ObjectMappingsRepository.XPATH_USER_STATUS);
        assertTest(AssertExpectedMappings.VALUE_DISABLED, actualValue);
    }

    @Test
    public void activateUser() {
        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);
        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_USER_IMG);

        //first do a search for the username
        enterText(XPATH, ObjectMappingsRepository.XPATH_USER_SEARCH_INPUT, CommonMappings.VALUE_ADMIN_USERNAME);

        //Then click the activate image for that username
        click(XPATH, ObjectMappingsRepository.XPATH_DISABLE_ENABLE_USER_IMG);

        //do a search for the username again
        enterText(XPATH, ObjectMappingsRepository.XPATH_USER_SEARCH_INPUT, CommonMappings.VALUE_ADMIN_USERNAME);
        waitFor(1000);

        //To assert, check that the 'Status' column displays Active
        String actualValue = getText(XPATH, ObjectMappingsRepository.XPATH_USER_STATUS);
        assertTest(AssertExpectedMappings.VALUE_ACTIVE, actualValue);
    }

    @Test
    public void addCallCentreUser() {
        //TODO: to be completed
        //Adam to define (awaiting document)

    }


}
