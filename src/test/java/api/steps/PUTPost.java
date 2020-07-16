package api.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.titanium.framework.api.utils.RestAssuredUtils.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PUTPost {
    private ResponseOptions<Response> response;

    @And("I perform PUT operation for {string}")
    public void i_perform_put_operation_for(String endpoint, DataTable table) {
        List<List<String>> data = table.cells();

        Map<String, String> body = new HashMap<>();
        body.put("id", data.get(1).get(0));
        body.put("title",data.get(1).get(1));
        body.put("author",data.get(1).get(2));

        //Perform PUT operation
        putWithBody(endpoint, body);
    }

    @And("I perform GET operation with path parameter for {string}")
    public void i_perform_get_operation_with_path_parameter_for(String endpoint, DataTable table) {
        List<List<String>> data = table.cells();

        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("postid", data.get(1).get(0));

        response = getWithPathParameters(endpoint,pathParams);
    }

    @Then("I {string} not see the body with title {string}")
    public void i_should_not_see_the_body_wWith_title(String condition, String title) {
        if(condition.equalsIgnoreCase("should not"))
            assertThat(response.getBody().jsonPath().get("title"), IsNot.not(title));
        else
            assertThat(response.getBody().jsonPath().get("title"), Is.is(title));
    }
}
