package api.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"src/test/java/api/features/"},
        glue = {"api/steps"},
        plugin = {"pretty"})
public class TestRunner extends AbstractTestNGCucumberTests {
    /*private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Override
    @DataProvider(parallel=false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterTest(alwaysRun = true)
    public void afterClass() {
        testNGCucumberRunner.finish();
    }*/
}
