package cucumberTag;


import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;




@CucumberOptions(
        format = {"pretty", "html:target/cucumber"},
        features = {"classpath:features/cucumberTag.feature"},
        glue = "cucumberTag.steps")
@RunWith(Cucumber.class)
public class runTest {
    //

}
