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

public class PutUpdateUser {

    @Steps
    ReqresAPI reqresAPI;
    @Given("Put update user with id {int} and with valid json file")
    public void putUpdateUserWithIdAndWithValidJsonFile(int id) {
        File json = new File(Constant.JSON_REQUEST+"/UpdateUser/UpdateUser.json");
        reqresAPI.putUpdateUser(id,json);
    }

    @Given("Put update user with id {string} and with invalid json file")
    public void putUpdateUserWithIdAndWithInvalidJsonFile(String id) {
        File json = new File(Constant.JSON_REQUEST+"/UpdateUser/UpdateInvalid.json");
        reqresAPI.putInvalidUpdateUser(id, json);
    }

    @And("Validate json schema update user")
    public void validateJsonSchemaUpdateUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/UpdateUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
    @When("Send request put update user")
    public void sendRequestPutUpdateUser () {
            SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
}

}