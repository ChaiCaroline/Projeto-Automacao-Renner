package teste.acceptance;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", tags = "@login", plugin = {
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
})
public class LoginCucumberRunner {

}
