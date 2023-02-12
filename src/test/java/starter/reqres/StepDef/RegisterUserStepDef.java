package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.StepDef.Utils.Constant;
import starter.reqres.StepDef.Utils.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class RegisterUserStepDef {

    @Steps
    ReqresAPI reqresAPI;
    @Given("Post register user with valid json")
    public void postRegisterUserWithValidJson() {
        File json = new File(Constant.JSON_REQUEST+ "/RegisterUser/Registervalid.json");
        reqresAPI.registerUserWithValidJson(json);
    }

    @When("Send request post register")
    public void sendRequestPostRegister() {
        SerenityRest.when().post(ReqresAPI.REGISTER_USER);
    }

    @And("Response body id should be {int} and token {string}")
    public void responseBodyEmailShouldBeAndPassword(int id, String token) {
        SerenityRest.then()
                .body(ReqresResponses.ID, equalTo(id))
                .body(ReqresResponses.TOKEN_USER, equalTo(token));
    }

    @And("Validate json schema register user")
    public void validateJsonSchemaRegisterUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/RegisterSuccesSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Validate json schema failed register user")
    public void validateJsonSchemaFailedRegisterUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/UnsuccessRegisterUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post register user with invalid json")
    public void postRegisterUserWithInvalidJson() {
        File json = new File(Constant.JSON_REQUEST + "/RegisterUser/RegisterInvalid.json");
        reqresAPI.registerUserWithInvalidJson(json);
    }
}
