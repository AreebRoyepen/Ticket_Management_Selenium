package selenium.mappings;

public class ObjectMappingsRepository {

    /**
     * ############ Attribute id={}
     * put all the id here
     */
    public static final String ID_USERNAME = "username";
    public static final String ID_PASSWORD = "password";
    public static final String ID_FREEZE_BRANCH = "freeze";
    public static final String ID_ACTIVE = "active";
    public static final String ID_FIRST_NAME = "first_name";
    public static final String ID_LAST_NAME = "last_name";
    public static final String ID_PASSWORD_MAIN = "password_main";
    public static final String ID_PASSWORD_CONFIRM = "password_confirm";
    public static final String ID_ADMIN_STATUS = "admin_status";
    public static final String ID_STATION = "station";
    public static final String ID_OLD_PASSWORD = "old_password";
    public static final String ID_NEW_PASSWORD = "new_password";
    public static final String ID_CONFIRM_PASSWORD = "confirm_password";
    public static final String ID_EMAIL = "email_address";
    public static final String ID_DISTRIBUTORS = "dists_";
    public static final String ID_ROUTE_NAME = "route_name_new";
    public static final String ID_SELECT_ROUTE ="route_change";

    /**
     * ############## attribute class={}
     */
    public static final String CLASS_SUBMIT_AT_LOGIN = "input2";
    public static final String CLASS_SUBMIT_ROUTE = "stdsubmit";


    /**
     *  ATTRIBUTE name = ""
     */
    public static final String NAME_EMAIL = "email";
    public static final String NAME_PASSWORD = "password";
    public static final String NAME_TITLE = "title";
    public static final String NAME_STATIONS = "stations";
    public static final String NAME_DAILY_TARGET = "daily_target";
    public static final String NAME_WEEKLY_TARGET = "weekly_target";
    public static final String NAME_MONTHLY_TARGET = "monthly_target";
    public static final String NAME_TARGET_CUSTOMERS = "target_customers";
    public static final String NAME_PAYBILL = "paybill";

    /**
     * ######### TAG_NAME
     * Place all the tags here
     */
    public static final String TAG_BUTTON = "button";
    public static final String TAG_INPUT = "input";
    public static final String TAG_P = "p";

    //headings
    public static final String TAG_H1 = "h1";
    public static final String TAG_H2 = "h2";
    public static final String TAG_H3 = "h3";

    
    //ALL XPATHS here
    public static String XPATH_LOGIN_USERNAME = "//*[@id=\"root\"]/div/aside/div/form/input[1]";
    public static String XPATH_LOGIN_PASSWORD  ="//*[@id=\"root\"]/div/aside/div/form/input[2]";
    public static String XPATH_LOGIN_BUTTON = "//*[@id=\"root\"]/div/aside/div/div[2]/button";
    public static String XPATH_LOGIN_INVALID_CREDS = "//*[@id=\"validate-password-true\"]";
    
    public static String XPATH_APPBAR = "//*[@id=\"appBarColor\"]/div";
    public static String XPATH_DASH_HEADING = "//*[@id=\"root\"]/div/div/div/div/header/h1";	
    
    public static String XPATH_MENU = "//*[@id=\"appBarColor\"]/div/button[1]";
    public static String XPATH_MENU_EVENT = "/html/body/div[3]/div[3]/div/ul/li[2]/a";
    
    public static String XPATH_EVENT_CREATE_BUTTON = "//*[@id=\"root\"]/div/div/div/div[2]/div[1]/button";
  
    public static String XPATH_EVENT_CREATE_CARD = "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[1]/div"; 
    ///////////////////////////////////////
    
    public static String XPATH_USER_IMG = "/html/body/div[1]/div[2]/div/div/table/tbody/tr/td/table[1]/tbody/tr[4]/td[1]/a/img";

    public static String XPATH_STATION_IMG = "//*[@id=\"content\"]/div/table/tbody/tr/td[1]/table/tbody/tr[1]/td[1]/a/img";
    public static String XPATH_EDIT_STATION_IMG = "/html/body/div[1]/div[2]/div/div/div/table/tbody/tr/td[9]/a/img";

    public static String XPATH_PARTNERS_IMG = "//*[@id='content']/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]/a/img";
    public static String XPATH_TITLE_IMG ="//*[@id=\"content\"]/div/table/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/a/img";
    public static String XPATH_EDIT_TITLE_IMG ="/html/body/div[1]/div[2]/div/div/div/table/tbody/tr/td[5]/a/img";

    public static String XPATH_LOGOUT_LINK = "//*[@id=\"menu\"]/ul/li[11]/a";
    public static String XPATH_DUPLICATE_STATION_TEXT = "/html/body/div[1]/div[2]/div/div/form/table[1]/tbody/tr[10]/td/font";
    public static String XPATH_DUPLICATE_TITLE_TEXT = "/html/body/div[1]/div[2]/div/div/form/table[1]/tbody/tr[3]/td/font";
    public static String XPATH_STATION_SEARCH_INPUT = "/html/body/div[1]/div[2]/div/div/div/div[2]/label/input";
    public static String XPATH_TITLE_SEARCH_INPUT = "/html/body/div[1]/div[2]/div/div/div/div[2]/label/input";
    public static String XPATH_USER_SEARCH_INPUT = "/html/body/div[1]/div[2]/div/div/div/div[2]/label/input";
    public static String XPATH_PASSWORD_REQ_NOT_MET = "/html/body/div[1]/div[2]/div/div/form/font";
    public static String XPATH_INCORRECT_TEMP_PASSWORD = "/html/body/div[1]/div[2]/div/div/table/tbody/tr/td[2]/form/table/tbody/tr[6]/td/font";

    public static String CREATE_USER_FORM_HEADING = "/html/body/div[1]/div[2]/div/div/h2";
    public static String CREATE_STATION_FORM_HEADING = "/html/body/div[1]/div[2]/div/div/h2";
    public static String CREATE_USER_TITLE_FORM_HEADING = "/html/body/div[1]/div[2]/div/div/h2";
    public static String KUZA_LANDING_PAGE_HEADING = "/html/body/div[1]/div[2]/div/div/h2";
    public static String PARTNERS_FORM_HEADING = "//*[@id='content']/div/h2";
    public static String ADD_ROUTE_FORM_HEADING = "//*[@id='wrapper']/div[2]/div/h3";

    public static String XPATH_USER_SEARCH_RESULTS = "/html/body/div[1]/div[2]/div/div/div/table/tbody/tr/td[2]";
    public static String XPATH_STATION_SEARCH_RESULTS = "/html/body/div[1]/div[2]/div/div/div/table/tbody/tr/td[2]";
    public static String XPATH_TITLE_SEARCH_RESULTS = "/html/body/div[1]/div[2]/div/div/div/table/tbody/tr/td[2]";

    public static String XPATH_DISABLE_ENABLE_USER_IMG = "/html/body/div[1]/div[2]/div/div/div/table/tbody/tr[1]/td[10]/a/img";
    public static String XPATH_USER_STATUS = "/html/body/div[1]/div[2]/div/div/div/table/tbody/tr/td[9]";
    public static String XPATH_STATION_INACTIVE = "/html/body/div[1]/div[2]/div/div/form/table[1]/tbody/tr[8]/td[2]/select/option[4]";
    public static String XPATH_TITLE_INACTIVE = "//*[@id=\"active\"]/option[1]";

    public static String XPATH_CUSTOMERS_BUTTON_LINK = "//*[@id='content']/a[1]";


}
