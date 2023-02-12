package starter.reqres.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class DeleteUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Delete users with valid id {int}")
    public void deleteUser(int id) {
        SerenityRest.given();
        reqresAPI.deleteUserValidid(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @Then("Status code should be {int} No content")
    public void statusCodeShouldBeNoContent(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("Delete users with invalid id {string}")
    public void deleteUsersWithValidId(String id) {
        SerenityRest.given();
        reqresAPI.deleteUserInvalid(id);
    }
}