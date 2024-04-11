package starter;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.constants.Constant;

import java.io.File;

public class ReqresAPI {
    public static String GET_LIST_USER = Constant.BASE_URL + "/api/users?page={page}";
    public static String POST_CREATE_USER = Constant.BASE_URL + "/api/users";
    public static String PUT_UPDATE_USER = Constant.BASE_URL + "/api/user/{id}";
    public static String DELETE_USER = Constant.BASE_URL + "/api/user/{id}";
    public static String REGISTER = Constant.BASE_URL + "/api/register";
    public static String LOGIN = Constant.BASE_URL + "/api/login";

    @Step("Get list user")
    public void getListUsers(int page) {
        SerenityRest.given()
                .pathParam("page", page)
                .get(GET_LIST_USER);
    }

    @Step("Get list user")
    public void getListUsers(String page) {
        SerenityRest.given()
                .pathParam("page", page)
                .get(GET_LIST_USER);
    }

    @Step("Post create user")
    public void postCreateUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user by ID")
    public void putUpdateUser(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void deleteUser(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Register user")
    public void registerUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Login user")
    public void loginUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
}
