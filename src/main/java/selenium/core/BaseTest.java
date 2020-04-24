package selenium.core;

import selenium.mappings.ObjectMappingsRepository;

public class BaseTest extends TestUtil{

    public void logOn(String url, String username, String password) {
        loadLink(url);
        waitFor(3000);
        enterText(XPATH, ObjectMappingsRepository.XPATH_LOGIN_USERNAME, username);
        enterText(XPATH, ObjectMappingsRepository.XPATH_LOGIN_PASSWORD, password);
        click(XPATH, ObjectMappingsRepository.XPATH_LOGIN_BUTTON);
        
    }
}
