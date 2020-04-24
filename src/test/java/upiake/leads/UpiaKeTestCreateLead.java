package upiake.leads;

import org.testng.annotations.Test;
import selenium.core.BaseTest;
import selenium.mappings.AssertExpectedMappings;
import selenium.mappings.CommonMappings;
import selenium.core.TestUtil;

import java.util.Random;

public class UpiaKeTestCreateLead extends BaseTest {

    @Test
    public void TestCreateLead(){
        logOn(CommonMappings.URL_GIS_TICKET_SYTEM, CommonMappings.VALUE_USERNAME, CommonMappings.VALUE_PASSWORD);

        String expectedLink = AssertExpectedMappings.LANDING_PAGE_URL_UPIA_KE;
        String newLink = getCurrentUrl();
        waitFor(1000);

        assertTest(expectedLink,newLink);   //////////Check if user was directed to dashboard

         ///click link Leads from the main menu
        click(LINK_TEXT, "Leads");

        //click link add a new link from the upiake.leads page
        click(LINK_TEXT, "Add a new Lead");


        enterText(NAME,"first_name", "Jonah");        ///////First Name
        enterText(NAME,"last_name", "Ngarama");        ///////Last Name
        enterText(NAME,"next_visit_date", "08/16/2019");        ///////Next Visit
        selectOneByValue(XPATH,"//select[@name='market']", "922");        ///////Select market
        selectOneByValue(XPATH,"//select[@id='loan_officer']","544");   //////Loan officer
        selectOneByValue(XPATH,"//select[@id='collections_officer']","247");   //////collections officer
        selectOneByValue(XPATH,"//select[@id='outcome']","4");   //////Outcome
        enterText(NAME,"lead_outcome","This is automated test text that was designed and theorized by Javo and proven by Jonah. And I need to make this text going to make it long enough");
        selectOneByValue(XPATH,"//select[@id='marketing_drive']","Fliers");   //////Marketing drive
        enterText(NAME,"other_sources","Another automated test text. Another automated test text. Another automated test text.  Another automated test text.  Another automated test text ");


        Random r = new Random();
        int low = 100000000;
        int high = 999999999;
        enterText(NAME,"mobile_no","2547"+(int) (Math.random() * low + 1));

        waitFor(2000);
        click(ID,"button");
        waitFor(2000);

        String redirected = getCurrentUrl();
        String expected = CommonMappings.URL_UPIA_KE+"/leads.php";
        assertTest(expected,redirected);

    }


    @Test
    public void testCreateLeadWithoutLoggingIn(){

        /**
         * hit url to load the form to create the form
         *
         */
        loadLink(CommonMappings.URL_UPIA_KE+"/lead_details.php");

        /**
         * assert its not possible to create lead as a guest.
         */

    }



    @Test
    public void testCreateLeadWithoutMandatoryFields(){

        //login
        loadLink(CommonMappings.URL_UPIA_KE+"/lead_details.php");

        /**
         *  here remove the mandatory fields
         */
        enterText(NAME,"first_name", "Jonah");        ///////First Name
        enterText(NAME,"last_name", "Ngarama");        ///////Last Name
        enterText(NAME,"next_visit_date", "07/16/2019");        ///////Next Visit
        selectOneByValue(XPATH,"//select[@name='market']", "922");        ///////Select market
        selectOneByValue(XPATH,"//select[@id='loan_officer']","544");   //////Loan officer
        selectOneByValue(XPATH,"//select[@id='collections_officer']","247");   //////collections officer
        selectOneByValue(XPATH,"//select[@id='outcome']","4");   //////Outcome
        enterText(NAME,"lead_outcome","This is automated test text that was designed by theorized by Javo and proven by Jonah. And I need to make this text going to make it long enough");
        selectOneByValue(XPATH,"//select[@id='marketing_drive']","Fliers");   //////Marketing drive
        enterText(NAME,"other_sources","Another automated test text. Another automated test text. Another automated test text.  Another automated test text.  Another automated test text ");


        Random r = new Random();
        int low = 100000000;
        int high = 999999999;
        enterText(NAME,"mobile_no","2547"+(int) (Math.random() * low + 1));

        waitFor(2000);
        click(ID,"button");
        waitFor(2000);

        /**
         * assert that its not possible to submit without mandatory fields....
         */

    }
}
