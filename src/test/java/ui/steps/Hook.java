package ui.steps;

import com.titanium.framework.general.PropertyManager;
import com.titanium.framework.ui.base.DriverFactory;
import com.titanium.framework.ui.base.RemoteDriverFactory;
import com.titanium.framework.ui.utils.WaitUtil;
import cucumber.api.Result;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hook extends DriverFactory {
    @Before
    public void initialize(Scenario scenario){
    if(Boolean.parseBoolean(PropertyManager.getInstance().getProperty("Remote_Driver"))){
        RemoteDriverFactory.getInstance().getDriver().navigate().to(PropertyManager.getInstance().getProperty("Ui_Url"));
    }else{
        DriverFactory.getInstance().getDriver().navigate().to(PropertyManager.getInstance().getProperty("Ui_Url"));
    }
    WaitUtil.sync();
}

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.getStatus().equals(Result.Type.FAILED)) {
        }
    }
}
