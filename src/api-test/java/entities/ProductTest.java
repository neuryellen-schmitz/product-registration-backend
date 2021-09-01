package entities;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    private String urlBase = "http://localhost:8080/entities/product";

    @Test
    public void listProducts() {
        Response response = RestAssured.given().contentType("application/json").get(urlBase);

        assertEquals(200, response.getStatusCode());
        System.out.println(response.getBody().prettyPrint());
    }

}
