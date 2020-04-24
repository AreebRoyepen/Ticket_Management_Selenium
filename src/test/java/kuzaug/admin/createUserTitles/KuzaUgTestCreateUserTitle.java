package kuzaug.admin.createUserTitles;

import org.testng.annotations.Test;
import selenium.mappings.AssertExpectedMappings;
import selenium.mappings.CommonMappings;
import selenium.mappings.MessageRepositoryMappings;
import selenium.mappings.ObjectMappingsRepository;
import selenium.core.BaseTest;

public class KuzaUgTestCreateUserTitle extends BaseTest {

    @Test
    public void loadCreateTitleForm() {

        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);

        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_TITLE_IMG);
        click(LINK_TEXT, CommonMappings.LINK_ADD_NEW_TITLE);
        waitFor(3000);
        String actualHeading = getText(XPATH, ObjectMappingsRepository.CREATE_USER_TITLE_FORM_HEADING);
        assertTest(AssertExpectedMappings.CREATE_TITLE_FORM, actualHeading);

    }

    @Test
    public void submitBlankTitleDetails() {

        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);

        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_TITLE_IMG);
        click(LINK_TEXT, CommonMappings.LINK_ADD_NEW_TITLE);
        click(TAG_NAME, ObjectMappingsRepository.TAG_BUTTON);

        String alertMessage = getAlertText();
        waitFor(1000);
        assertTest(AssertExpectedMappings.ENTER_VALID_NEW_USER_TITLE.substring(0, 27), alertMessage.substring(0, 27));

    }

    @Test
    public void addTitleLoanOfficer() {

        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);

        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_TITLE_IMG);
        click(LINK_TEXT, CommonMappings.LINK_ADD_NEW_TITLE);
        waitFor(1000);

        //Add title name
        enterText(NAME, ObjectMappingsRepository.NAME_TITLE, CommonMappings.VALUE_TITLE_LOANOFFICER);
        //Set Active to Yes
        selectOneByVisibleText(ID, ObjectMappingsRepository.ID_ACTIVE, "Yes");

        //Click the Save button
        click(TAG_NAME, ObjectMappingsRepository.TAG_BUTTON);

        //To assert, get page title text
        waitFor(1000);
        String actualHeading = getText(XPATH, ObjectMappingsRepository.CREATE_USER_TITLE_FORM_HEADING);
        assertTest(AssertExpectedMappings.LIST_USER_TITLES_PAGE_HEADING, actualHeading);
    }


    @Test
    public void checkDuplicateTitle() {
        //Attempt to add an existing Title
        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);

        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_TITLE_IMG);
        click(LINK_TEXT, CommonMappings.LINK_ADD_NEW_TITLE);

        waitFor(3000);
        //Add title name
        enterText(NAME, ObjectMappingsRepository.NAME_TITLE, CommonMappings.VALUE_TITLE_LOANOFFICER);
        //Set Active to Yes
        selectOneByVisibleText(ID, ObjectMappingsRepository.ID_ACTIVE, "Yes");

        //Click the Save button
        click(TAG_NAME, ObjectMappingsRepository.TAG_BUTTON);

        //Check that duplicate message is displayed
        waitFor(1000);
        assertTest(MessageRepositoryMappings.DUPLICATE_TITLE_MESSAGE, getText(XPATH, ObjectMappingsRepository.XPATH_DUPLICATE_TITLE_TEXT));

    }

    @Test
    public void searchTitle() {
        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);

        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_TITLE_IMG);

        //Search to see if the new title is in the list
        enterText(XPATH, ObjectMappingsRepository.XPATH_TITLE_SEARCH_INPUT, CommonMappings.VALUE_TITLE_LOANOFFICER);

        String searchResultsInfo = getText(XPATH, ObjectMappingsRepository.XPATH_TITLE_SEARCH_RESULTS);
        assertTest(AssertExpectedMappings.TITLE_SEARCH_RESULTS_TEXT, searchResultsInfo);
    }

    @Test
    public void inactivateUserTitle() {
        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);
        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_TITLE_IMG);

        //search for title
        enterText(XPATH, ObjectMappingsRepository.XPATH_TITLE_SEARCH_INPUT, CommonMappings.VALUE_TITLE_LOANOFFICER);

        //click the edit image in the row
        click(XPATH, ObjectMappingsRepository.XPATH_EDIT_TITLE_IMG);

        //set active to yes first and save
        selectOneByVisibleText(ID, ObjectMappingsRepository.ID_ACTIVE, "Yes");
        click(TAG_NAME, ObjectMappingsRepository.TAG_BUTTON);

        //Search for title and click edit
        enterText(XPATH, ObjectMappingsRepository.XPATH_TITLE_SEARCH_INPUT, CommonMappings.VALUE_TITLE_LOANOFFICER);
        click(XPATH, ObjectMappingsRepository.XPATH_EDIT_TITLE_IMG);

        //select no from 'active' dropdown and save
        selectOneByVisibleText(ID, ObjectMappingsRepository.ID_ACTIVE, "No");
        click(TAG_NAME, ObjectMappingsRepository.TAG_BUTTON);
        waitFor(1000);

        //Search for the user title again
        enterText(XPATH, ObjectMappingsRepository.XPATH_TITLE_SEARCH_INPUT, CommonMappings.VALUE_TITLE_LOANOFFICER);

        //To assert, check the user title is inactive (active=no)
        click(XPATH, ObjectMappingsRepository.XPATH_EDIT_TITLE_IMG);
        String actualValue = getText(XPATH, ObjectMappingsRepository.XPATH_TITLE_INACTIVE);
        assertTest(AssertExpectedMappings.VALUE_NO, actualValue);
    }

}