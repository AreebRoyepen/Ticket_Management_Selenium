package selenium.mappings;

public class ObjectMappingsRepository {

    /**
     * ############ Attribute id={}
     * put all the id here
     */
    public static final String ID_USERNAME = "username";
    public static final String ID_PASSWORD = "password";


    /**
     * ############## attribute class={}
     */
    //public static final String CLASS_ID_USERNAME = "username";


    /**
     *  ATTRIBUTE name = ""
     */
    public static final String NAME_EMAIL = "email";
    public static final String NAME_PASSWORD = "password";

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
    public static String XPATH_MENU_PEOPLE = "/html/body/div[3]/div[3]/div/ul/li[3]/a";
    
    public static String XPATH_EVENT_CREATE_BUTTON = "//*[@id=\"root\"]/div/div/div/div[2]/div[1]/button";
  
    public static String XPATH_EVENT_CARD = "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[1]/div"; 
    
    public static String XPATH_CREATE_EVENT_CANCEL_BUTTON = "//*[@id=\"root\"]/div/div/div/body/div/button[2]";
    
    public static String XPATH_ADD_PERSON_BUTTON = "//*[@id=\"root\"]/div/div/div/div[2]/button";
    
    public static String XPATH_ADD_PERSON_CANCEL_BUTTON = "//*[@id=\"root\"]/div/div/div/body/div/button[2]";
    public static String XPATH_EDIT_PERSON_SUBMIT_BUTTON = "//*[@id=\"trueValid\"]";
    
    public static String XPATH_PERSON_CARD = "//*[@id=\"root\"]/div/div/div/div[2]/div/div/div[1]/div/div";
    public static String XPATH_PERSON_CARD_EDIT_BUTTON = "//*[@id=\"root\"]/div/div/div/div[2]/div/div/div[1]/div/div/div/div[2]/input";
    
  
    
}
