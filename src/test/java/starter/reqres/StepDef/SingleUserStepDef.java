package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.StepDef.Utils.Constant;

import java.io.File;


public class SingleUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Get single user with id {int}")
        public void getSingleUserWithId(int id) {
            reqresAPI.getSingleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
            SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @And("Validate json schema single user")
    public void validateJsonSchemaSingleUser() {
            File json = new File (Constant.JSON_SCHEMA + "/SingleUserSchema.json");
    }

    @Given("Get single user with invalid id {string}")
    public void getSingleUserWithInvalidId(String id){
                reqresAPI.getSingleUserWithString(id);
            }
}
