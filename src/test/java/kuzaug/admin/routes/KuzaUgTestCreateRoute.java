package kuzaug.admin.routes;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import selenium.mappings.AssertExpectedMappings;
import selenium.mappings.CommonMappings;
import selenium.mappings.ObjectMappingsRepository;
import selenium.core.BaseTest;

public class KuzaUgTestCreateRoute extends BaseTest {

    @Test
    public void loadPartnersPage() {

        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);

        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        //Click on partners
        click(XPATH, ObjectMappingsRepository.XPATH_PARTNERS_IMG);
        waitFor(3000);
        String actualHeading = getText(XPATH, ObjectMappingsRepository.PARTNERS_FORM_HEADING);
        assertTest(AssertExpectedMappings.PARTNERS_FORM, actualHeading);

    }

    @Test
    public void loadAddRoutePage() {

        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);

        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        //Click on partners
        click(XPATH, ObjectMappingsRepository.XPATH_PARTNERS_IMG);
        waitFor(3000);
        //select Nile breweries
        click(LINK_TEXT, CommonMappings.LINK_PARTNER);
        //click on customers button
        click(XPATH, ObjectMappingsRepository.XPATH_CUSTOMERS_BUTTON_LINK);
        waitFor(3000);
        //select distributor
        selectOneByValue(ID, ObjectMappingsRepository.ID_DISTRIBUTORS, CommonMappings.VALUE_ID_DISTRIBUTORS);
        //click on add route
        click(LINK_TEXT, CommonMappings.LINK_ADD_ROUTE);
        waitFor(3000);
        String actualHeading = getText(XPATH, ObjectMappingsRepository.ADD_ROUTE_FORM_HEADING);
        assertTest(AssertExpectedMappings.ADD_ROUTE_FORM.substring(0, 35), actualHeading.substring(0, 35));

    }

    @Test
    public void addRoute() {
        logOn(CommonMappings.URL_KUZA_UG, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);

        click(LINK_TEXT, CommonMappings.LINK_ADMIN);
        //Click on partners
        click(XPATH, ObjectMappingsRepository.XPATH_PARTNERS_IMG);
        waitFor(3000);
        //select Nile breweries
        click(LINK_TEXT, CommonMappings.LINK_PARTNER);
        //click on customers button
        click(XPATH, ObjectMappingsRepository.XPATH_CUSTOMERS_BUTTON_LINK);
        waitFor(3000);
        //select distributor
        selectOneByValue(ID, ObjectMappingsRepository.ID_DISTRIBUTORS, CommonMappings.VALUE_ID_DISTRIBUTORS);
        //click on add route
        click(LINK_TEXT, CommonMappings.LINK_ADD_ROUTE);
        waitFor(3000);
        //enter route name
        enterText(ID, ObjectMappingsRepository.ID_ROUTE_NAME, CommonMappings.VALUE_ROUTE_NAME);
        //click create new
        click(CLASS, ObjectMappingsRepository.CLASS_SUBMIT_ROUTE);
        waitFor(3000);
        selectOneByVisibleText(ID, ObjectMappingsRepository.ID_SELECT_ROUTE, CommonMappings.VALUE_ROUTE_NAME);

    }

}








