
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.Matchers.is;

public class Test_CRUD {
    private static String token = "7ff3c564ff09a3d1107477de5937a61e50a45429f5735e48fe528d1f20969a9d";

    @Test
    public void testCRUD(){
        String endpointPostUser = "public-api/users";
        String endpointPostTodos = "public-api/users/{user_id}/todos";
        String endpointGetTodos = "public-api/todos/{todosId}";


        String userEmail = "ITakadem_user_" + new Random().nextInt() + "@mymail.com";
        String userName = "TestName";

        RequestSpecification reqSpec = new RequestSpecBuilder().
                setBaseUri("https://gorest.co.in/").
                setContentType(ContentType.JSON).
                addHeader("Authorization", "Bearer " + token).
                addFilters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter())).
                build();

        ResponseSpecification respSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();



        Map<String, String> user = new HashMap<>();
        user.put("name", userName);
        user.put("email", userEmail);
        user.put("gender", "Female");
        user.put("status", "Active");

        // CREATE USER
        int userID = given().
                spec(reqSpec).
                body(user).
                when().
                post(endpointPostUser).
                then().
                assertThat().
                body("code", is(201)).
                extract().
                path("data.id");

        //CREATE TODOS

        String todosTitle = "Subseco alveus bibo virga alioqui sordeo sit vulnero et vilis.";
        String todosStatus = "completed";


        Map<String, Object> todos = new HashMap<>();
        todos.put("user_id", userID);
        todos.put("title", todosTitle);
        todos.put("status", todosStatus);

        int todosID = given().
                spec(reqSpec).
                pathParam("user_id", userID).
                body(todos).
                when().
                post(endpointPostTodos).
                then().
                assertThat().
                spec(respSpec).
                extract().
                path("data.id");


        //CHECK CREATED TODOS
        given().
                pathParam("todosId", todosID).
                spec(reqSpec).
                when().
                get(endpointGetTodos).
                then().
                assertThat().
                spec(respSpec).
                body("data.body", is(todosTitle));


        //DELETE TODOS

        given().
                spec(reqSpec).
                pathParam("todosId", todosID).
                when().
                delete(endpointGetTodos).
                then().
                assertThat().
                body("code", is(204));

        //CHECK THAT TODOS IS DELETED
        given().
                pathParam("todosId", todosID).
                spec(reqSpec).
                when().
                get(endpointGetTodos).
                then().
                assertThat().
                body("code", is(404)).
                body("data.message", is("Resource not found"));













    }

}
