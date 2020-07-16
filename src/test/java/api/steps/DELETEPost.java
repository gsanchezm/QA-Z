package api.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.hamcrest.core.IsNot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.titanium.framework.api.utils.RestAssuredUtils.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class DELETEPost {
    private ResponseOptions<Response> response;

    @Given("I ensure to perform POST operation for {string} with body as")
    public void i_ensure_to_perform_post_operation_for_with_body_as(String endpoint, DataTable table) {
        List<List<String>> data = table.cells();

        Map<String, String> body = new HashMap<>();
        body.put("id", data.get(1).get(0));
        body.put("title",data.get(1).get(1));
        body.put("author",data.get(1).get(2));

        //Perform POST operation
        postWithBody(endpoint, body);
    }

    @And("I perform DELETE operation for {string}")
    public void i_perform_delete_operation_for(String endpoint, DataTable table) {
        List<List<String>> data = table.cells();

        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("postsid", data.get(1).get(0));

        //Perform DELETE operation
        deleteWithPathParams(endpoint,pathParams);
    }

    @And("I perform GET operation with path parameters for {string}")
    public void i_perform_get_operation_with_path_parameters_for(String endpoint, DataTable table) {
        List<List<String>> data = table.cells();

        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("postsid", data.get(1).get(0));

        response = getWithPathParameters(endpoint,pathParams);
    }

    @Then("I should not see the body with title {string}")
    public void i_should_not_see_the_body_wWith_title(String title) {
        assertThat(response.getBody().jsonPath().get("title"), IsNot.not(title));
    }
}
