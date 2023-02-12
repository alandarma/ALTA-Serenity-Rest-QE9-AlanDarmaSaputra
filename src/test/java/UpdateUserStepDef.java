import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateUserStepDef {
    @Given("Put update user with id <id> and with valid json file")
    public void putUpdateUserWithIdIdAndWithValidJsonFile() {
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int arg0) {
    }

    @And("Response body should contain name {string} and job {string}")
    public void responseBodyShouldContainNameAndJob(String arg0, String arg1) {
    }
}
