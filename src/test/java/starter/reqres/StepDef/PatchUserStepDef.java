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

public class PatchUserStepDef {

    @Steps
    ReqresAPI reqresAPI;
    @Given("Patch update user with id {int} and with valid json")
    public void patchUpdateUserWithIdIdAndWithValidJson(int id) {
        File json = new File(Constant.JSON_REQUEST+"/PatchUser/PatchUpdateUser.json");
        reqresAPI.patchUpdateUser(json,id);
    }

    @When("Send request patch update user")
    public void sendRequestPatchUpdateUser() {
        SerenityRest.when().patch(ReqresAPI.PATCH_UPDATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int statuscode) {
        SerenityRest.then().statusCode(statuscode);
    }

    @And("Validate json schema patch user")
    public void patchUpdateUserAssertJsonValidation() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/PatchUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
            SerenityRest.then().statusCode(statusCode);
    }

    @Given("Patch update user with valid json with invalid {string}")
    public void patchUpdateUserWithValidJsonWithInvalid(String id) {
        File json = new File(Constant.JSON_REQUEST+"/PatchUser/PatchUpdateUser.json");
        reqresAPI.PatchUpdateUserInvalid(id, json);
    }

    @Given("Patch update user with id {int} and with invalid json")
    public void patchUpdateUserWithIdIdAndWithInvalidJson(int id) {
        File json = new File(Constant.JSON_REQUEST+"/PatchUser/PatchInvalid.json");
        reqresAPI.patchUpdateUser(json, id);
    }

}
