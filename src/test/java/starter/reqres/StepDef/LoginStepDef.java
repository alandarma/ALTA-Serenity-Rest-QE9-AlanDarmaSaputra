package starter.reqres.StepDef;

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
import static org.hamcrest.Matchers.equalTo;


public class LoginStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Post login unsuccess user with valid json file")
    public void postLoginUnsuccessUserWithValidJsonFile() {
        File json = new File(Constant.JSON_REQUEST + "/LoginFailed/LoginFailedUser.json");
        reqresAPI.postUnsuccessLoginUser(json);
    }

    @When("Send request post login user unsuccess")
    public void sendRequestPostLoginUserUnsuccess() {
            SerenityRest.when().post(ReqresAPI.POST_LOGIN_USER);
    }

    @Then("Should return status code {int} error")
    public void statusCodeShouldBeError(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body should contain error {string}")
    public void responseBodyShouldContainError(String error) {
        SerenityRest.then()
                .body(ReqresResponses.ERROR, equalTo(error));
    }

    @And("Validate json schema post login unsuccess")
    public void postLoginUnsuccessAssertJsonValidation() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/UnsuccsessLoginUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
