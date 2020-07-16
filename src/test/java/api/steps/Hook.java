package api.steps;

import com.titanium.framework.api.utils.RestAssuredUtils;
import cucumber.api.Result;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hook {
    @Before
    public void initialize(Scenario scenario){
        RestAssuredUtils restAssuredUtils = new RestAssuredUtils();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.getStatus().equals(Result.Type.FAILED)) {
        }
    }
}
