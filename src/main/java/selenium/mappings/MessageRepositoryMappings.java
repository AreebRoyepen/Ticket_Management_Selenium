package selenium.mappings;

/**
 * here add messages that you want to see when a test fails
 */
public class MessageRepositoryMappings {
    public static final String INCORRECT_LOGIN = "Failed to login using username and password";
    public static final String INCORRECT_NAVIGATION = "Failed to login using username and password";
    public static final String ERROR_LOAD_PAGE = "Failed to load page";
    public static final String INCORRECT_PASSWORD = "The username or password don't match the records in the database, or your login has been disabled from the system.";
    public static final String DUPLICATE_STATION_MESSAGE = "The stations specified already exists, enter another one.";
    public static final String DUPLICATE_TITLE_MESSAGE = "The title specified already exists, enter another one.";
    public static final String USER_PROFILE_PASSWORD_REQ_NOT_MET = "* The password is not strong enough\n" +
            "(It should have a special character, a number, a capital letter and a lower letter)";

}
