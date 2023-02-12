package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.reqres.StepDef.Utils.Constant;

import java.io.File;

public class ReqresAPI {
    //    public static String BASE_URL="https://reqres.in" ;
//
//    public static final String DIR = System.getProperty("user.dir");
//    public static String JSON_REQUEST = DIR+"/src/test/resources/JSON/Request";
//
//    public static String JSON_SCHEMA = DIR+"/src/test/resources/JSON/JsonSchema";
    public static String GET_LIST_USER = Constant.BASE_URL + "/api/users?page={page}";
    public static String POST_CREATE_USER = Constant.BASE_URL + "/api/users";
    public static String GET_SINGLE_USER = Constant.BASE_URL + "/api/users/{id}";
    public static String POST_LOGIN_USER = Constant.BASE_URL + "/api/login";
    public static String DELETE_USER = Constant.BASE_URL + "/api/users/{id}";
    public static String REGISTER_USER = Constant.BASE_URL + "/api/register";
    public static String PATCH_UPDATE_USER = Constant.BASE_URL + "/api/users/{id}";
    public static String PUT_UPDATE_USER = Constant.BASE_URL + "/api/users/{id}";

    @Step("Get list users")
    public void getListUsers(int page) {
        SerenityRest.given().pathParams("page", page);
    }

    @Step("Get list users with string")
    public void getListUsersWithString(String page) {
        SerenityRest.given().pathParams("page", page);
    }

    @Step("Post create user")
    public void postCreateUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void deleteUserValidid(int id) {
        SerenityRest.given().pathParams("id", id);
    }

    @Step("Delete user invalid id")
    public void deleteUserInvalid(String id) {
        SerenityRest.given().pathParams("id", id);
    }

    @Step("Post Unsuccess Login")
    public void postUnsuccessLoginUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get single user")
    public void getSingleUser(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get single user with string")
    public void getSingleUserWithString(String id) {
        SerenityRest.given()
                .pathParam("id", id);

    }

    @Step("Register user with valid json")
    public void registerUserWithValidJson(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Register user with invalid json")
    public void registerUserWithInvalidJson(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Patch update user")
    public void patchUpdateUser(File json, int id) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Patch update user with string")
    public void PatchUpdateUserInvalid(String id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);

    }

    @Step("Put update user")
    public void putUpdateUser(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public void putInvalidUpdateUser(String id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
}