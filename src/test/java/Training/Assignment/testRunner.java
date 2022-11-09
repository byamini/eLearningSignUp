package Training.Assignment;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import stepDefinition.signupAndRegisterStepDefinition;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/feature/signupAndRegisterStepDefinition.feature"},
		glue={"stepDefinition"})

public class testRunner {

}
