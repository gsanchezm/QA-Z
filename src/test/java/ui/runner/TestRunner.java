package ui.runner;

import com.titanium.framework.general.PropertyManager;
import com.titanium.framework.ui.base.BrowserType;
import com.titanium.framework.ui.base.DriverFactory;
import com.titanium.framework.ui.base.RemoteDriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

@CucumberOptions(features = {"src/test/java/ui/features/"},
        glue = {"ui/steps"},
        plugin = {"pretty"})
public class TestRunner extends AbstractTestNGCucumberTests {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void setUpClass(String browser) throws MalformedURLException {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        if(Boolean.parseBoolean(PropertyManager.getInstance().getProperty("Remote_Driver"))){
            RemoteDriverFactory.getInstance().setDriver(BrowserType.valueOf(browser));
        }else{
            DriverFactory.getInstance().setDriver(BrowserType.valueOf(browser));
        }

    }

    @Override
    @DataProvider(parallel=false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterTest(alwaysRun = true)
    public void afterClass() {
        testNGCucumberRunner.finish();
        if(Boolean.parseBoolean(PropertyManager.getInstance().getProperty("Remote_Driver"))){
            RemoteDriverFactory.getInstance().removeDriver();
        }else{
            DriverFactory.getInstance().removeDriver();
        }
    }
}
