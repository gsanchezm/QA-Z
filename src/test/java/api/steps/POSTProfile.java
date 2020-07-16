package api.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import java.util.HashMap;
import java.util.List;

import static com.titanium.framework.api.utils.RestAssuredUtils.postWithBodyAndPathParams;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class POSTProfile {

    private ResponseOptions<Response> response;

    @Given("I perform POST operation for {string} with body")
    public void i_perform_post_operation_for_with_body(String endpoint, DataTable table) {
        List<List<String>> data = table.cells();

        //Set Body
        HashMap<String,String> body = new HashMap<>();
        body.put("name", data.get(1).get(0));

        //Path Params
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("profileNo",data.get(1).get(1));

        //Perform POST operation
        response = postWithBodyAndPathParams(endpoint,pathParams,body);
    }

    @Then("I should see the body has name as {string}")
    public void i_should_see_the_body_has_name_as(String name) {
        assertThat(response.getBody().jsonPath().get("name"), equalTo(name));
    }
}
