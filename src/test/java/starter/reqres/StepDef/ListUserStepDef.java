package starter.reqres.StepDef;

import static org.hamcrest.Matchers.equalTo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.StepDef.Utils.Constant;
import starter.reqres.StepDef.Utils.ReqresResponses;

import java.io.File;

public class ListUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list user with valid page {int}")
    public void getListUserWithValidPagePage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("Send request get list user")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USER);
    }

    @Then("Should return status code {int}")
    public void shouldReturnStatusCode(int statuscode) {
        SerenityRest.then().statusCode(statuscode);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBePage(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }

    @Given("Get list user with invalid page {string}")
    public void getListUserWithInvalidPage(String page) {
        reqresAPI.getListUsersWithString(page);
    }

    @And("Response body page should be {string}")
    public void responseBodyPageShouldBe(String page) {
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }

    @Given("Get list user with invalid page {int}")
    public void getListUserWithInvalidIntPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @And("Validate json schema get list user")
    public void validateJsonSchemaGetListUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/ListUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
