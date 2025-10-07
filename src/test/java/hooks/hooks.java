package hooks;

import io.cucumber.java.After;
import utilites.Driver;

public class hooks {

    @After()
    public void tearDown(){
        Driver.closeDriver();
    }
}
