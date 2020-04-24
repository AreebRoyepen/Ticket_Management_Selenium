package kuzaug.admin.createStations;

import org.testng.annotations.Test;
import selenium.mappings.AssertExpectedMappings;
import selenium.mappings.CommonMappings;
import selenium.mappings.MessageRepositoryMappings;
import selenium.mappings.ObjectMappingsRepository;
import selenium.core.BaseTest;

public class KuzaUgTestCreateStation extends BaseTest {

    @Test
    public void loadCreateStationForm() {

        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);

        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_STATION_IMG);
        click(LINK_TEXT, CommonMappings.LINK_ADD_NEW_STATION);
        waitFor(3000);
        String actualHeading = getText(XPATH, ObjectMappingsRepository.CREATE_STATION_FORM_HEADING);
        assertTest(AssertExpectedMappings.CREATE_STATION_FORM, actualHeading);

    }

    @Test
    public void submitBlankStationDetails() {

        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);

        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_STATION_IMG);
        click(LINK_TEXT, CommonMappings.LINK_ADD_NEW_STATION);

        waitFor(3000);

        String actualHeading = getText(XPATH, ObjectMappingsRepository.CREATE_STATION_FORM_HEADING);

        click(TAG_NAME, ObjectMappingsRepository.TAG_BUTTON);

        String alertMessage = getAlertText();
        //waitFor(3000);
        assertTest(AssertExpectedMappings.ENTER_VALID_NEW_STATION.substring(0, 30), alertMessage.substring(0, 30));

    }

    @Test
    public void addStationKarenHQ() {

        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);

        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_STATION_IMG);
        click(LINK_TEXT, CommonMappings.LINK_ADD_NEW_STATION);

        waitFor(3000);
        //Add station name - id="stations" and enter value="KarenHQ"
        enterText(NAME, ObjectMappingsRepository.NAME_STATIONS, CommonMappings.VALUE_STATION_KARENHQ);

        //Set DailyTarget, WeeklyTarget, MonthlyTarget, MonthlyCustomerTarget and PaybillNumber to 0
        enterText(NAME, ObjectMappingsRepository.NAME_DAILY_TARGET, "0");
        enterText(NAME, ObjectMappingsRepository.NAME_WEEKLY_TARGET, "0");
        enterText(NAME, ObjectMappingsRepository.NAME_MONTHLY_TARGET, "0");
        enterText(NAME, ObjectMappingsRepository.NAME_TARGET_CUSTOMERS, "0");
        enterText(NAME, ObjectMappingsRepository.NAME_PAYBILL, "0");

        //Set FreezeBranch to No
        selectOneByVisibleText(ID, ObjectMappingsRepository.ID_FREEZE_BRANCH, "No");
        //Set Active to Yes
        selectOneByVisibleText(ID, ObjectMappingsRepository.ID_ACTIVE, "Yes");

        //Click the Save button
        click(TAG_NAME, ObjectMappingsRepository.TAG_BUTTON);

        //To assert, get page title text
        waitFor(1000);
        String actualHeading = getText(XPATH, ObjectMappingsRepository.CREATE_STATION_FORM_HEADING);
        assertTest(AssertExpectedMappings.LIST_STATIONS_PAGE_HEADING, actualHeading);

    }

    @Test
    public void addStationCollectionsCell() {

        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);

        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_STATION_IMG);
        click(LINK_TEXT, CommonMappings.LINK_ADD_NEW_STATION);

        waitFor(3000);
        //Add a Station name
        //find input by id="stations" and enter value="Collections Cell"
        enterText(NAME, ObjectMappingsRepository.NAME_STATIONS, CommonMappings.VALUE_STATION_COLLECTIONSCELL);

        //Set PaybillNumber
        enterText(NAME, ObjectMappingsRepository.NAME_PAYBILL, "992702");

        //Set FreezeBranch to No
        selectOneByVisibleText(NAME, ObjectMappingsRepository.ID_FREEZE_BRANCH, "No");
        //Set Active to Yes
        selectOneByVisibleText(NAME, ObjectMappingsRepository.ID_ACTIVE, "Yes");
        click(TAG_NAME, ObjectMappingsRepository.TAG_BUTTON);

        //To assert, get page title text
        waitFor(1000);
        String actualHeading = getText(XPATH, ObjectMappingsRepository.CREATE_STATION_FORM_HEADING);
        assertTest(AssertExpectedMappings.LIST_STATIONS_PAGE_HEADING, actualHeading);

    }

    @Test
    public void checkDuplicateStation() {
        //Attempt to add a station
        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);

        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_STATION_IMG);
        click(LINK_TEXT, CommonMappings.LINK_ADD_NEW_STATION);

        waitFor(3000);
        //Add station name - id="stations" and enter value="Fone Express"
        enterText(NAME, ObjectMappingsRepository.NAME_STATIONS, CommonMappings.VALUE_STATION_FONEEXPRESS);

        //Set DailyTarget, WeeklyTarget, MonthlyTarget, MonthlyCustomerTarget and PaybillNumber
        enterText(NAME, ObjectMappingsRepository.NAME_DAILY_TARGET, "10000");
        enterText(NAME, ObjectMappingsRepository.NAME_WEEKLY_TARGET, "70000");
        enterText(NAME, ObjectMappingsRepository.NAME_MONTHLY_TARGET, "1000000");
        enterText(NAME, ObjectMappingsRepository.NAME_TARGET_CUSTOMERS, "30");
        enterText(NAME, ObjectMappingsRepository.NAME_PAYBILL, "970320");

        //Set FreezeBranch to No
        selectOneByVisibleText(ID, ObjectMappingsRepository.ID_FREEZE_BRANCH, "No");
        //Set Active to Yes
        selectOneByVisibleText(ID, ObjectMappingsRepository.ID_ACTIVE, "Yes");
        //Click save button
        click(TAG_NAME, ObjectMappingsRepository.TAG_BUTTON);

        //Attempt to add the same station again
        click(LINK_TEXT, CommonMappings.LINK_ADD_NEW_STATION);

        waitFor(3000);
        //Add station name - id="stations" and enter value="Fone Express"
        enterText(NAME, ObjectMappingsRepository.NAME_STATIONS, CommonMappings.VALUE_STATION_FONEEXPRESS);

        //Set DailyTarget, WeeklyTarget, MonthlyTarget, MonthlyCustomerTarget and PaybillNumber
        enterText(NAME, ObjectMappingsRepository.NAME_DAILY_TARGET, "10000");
        enterText(NAME, ObjectMappingsRepository.NAME_WEEKLY_TARGET, "70000");
        enterText(NAME, ObjectMappingsRepository.NAME_MONTHLY_TARGET, "1000000");
        enterText(NAME, ObjectMappingsRepository.NAME_TARGET_CUSTOMERS, "30");
        enterText(NAME, ObjectMappingsRepository.NAME_PAYBILL, "970320");

        //Set FreezeBranch to No
        selectOneByVisibleText(ID, ObjectMappingsRepository.ID_FREEZE_BRANCH, "No");
        //Set Active to Yes
        selectOneByVisibleText(ID, ObjectMappingsRepository.ID_ACTIVE, "Yes");
        //Click save button
        click(TAG_NAME, ObjectMappingsRepository.TAG_BUTTON);

        //Check that duplicate message is displayed
        waitFor(1000);
        assertTest(MessageRepositoryMappings.DUPLICATE_STATION_MESSAGE, getText(XPATH, ObjectMappingsRepository.XPATH_DUPLICATE_STATION_TEXT));

    }

    @Test
    public void searchStation() {
        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);

        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_STATION_IMG);

        //Search to see if the new station is in the list
        enterText(XPATH, ObjectMappingsRepository.XPATH_STATION_SEARCH_INPUT, CommonMappings.VALUE_STATION_FONEEXPRESS);
        String searchResult = getText(XPATH, ObjectMappingsRepository.XPATH_STATION_SEARCH_RESULTS);
        assertTest(AssertExpectedMappings.STATION_SEARCH_RESULTS_TEXT, searchResult);
    }

    @Test
    public void inactivateStation() {
        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);
        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        click(XPATH, ObjectMappingsRepository.XPATH_STATION_IMG);

        //search for station
        enterText(XPATH, ObjectMappingsRepository.XPATH_STATION_SEARCH_INPUT, CommonMappings.VALUE_STATION_FONEEXPRESS);

        //click the edit image in the row
        click(XPATH, ObjectMappingsRepository.XPATH_EDIT_STATION_IMG);

        //set active to yes first and save
        selectOneByVisibleText(ID, ObjectMappingsRepository.ID_ACTIVE, "Yes");
        click(TAG_NAME, ObjectMappingsRepository.TAG_BUTTON);

        //Search for station and click edit
        enterText(XPATH, ObjectMappingsRepository.XPATH_STATION_SEARCH_INPUT, CommonMappings.VALUE_STATION_FONEEXPRESS);
        click(XPATH, ObjectMappingsRepository.XPATH_EDIT_STATION_IMG);

        //select no from 'active' dropdown and save
        selectOneByVisibleText(ID, ObjectMappingsRepository.ID_ACTIVE, "No");
        click(TAG_NAME, ObjectMappingsRepository.TAG_BUTTON);
        waitFor(1000);

        //Search for the user title again
        enterText(XPATH, ObjectMappingsRepository.XPATH_STATION_SEARCH_INPUT, CommonMappings.VALUE_STATION_FONEEXPRESS);

        //To assert, check the user station is inactive (active=no)
        click(XPATH, ObjectMappingsRepository.XPATH_EDIT_STATION_IMG);
        String actualValue = getText(XPATH, ObjectMappingsRepository.XPATH_STATION_INACTIVE);
        assertTest(AssertExpectedMappings.VALUE_NO, actualValue);

    }

}
