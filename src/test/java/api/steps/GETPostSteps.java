package api.steps;

import api.pojo.Posts;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import static com.titanium.framework.api.utils.RestAssuredUtils.getOptions;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class GETPostSteps {
    private ResponseOptions<Response> response;

    @Given("I perform GET operation for {string}")
    public void i_perform_get_operation_for(String endpoint) {
        response = getOptions(endpoint);
    }

    @Then("I should see the author name as {string}")
    public void i_should_see_the_author_name_as(String authorName) {
//        var posts = response.getBody().as(Posts.class);
//        assertThat(posts.getAuthor(), equalTo(authorName));
        assertThat(response.getBody().jsonPath().get("author"), hasItem(authorName));
    }

    @Then("I should see the author names")
    public void i_shold_see_the_author_names() {

    }

    @Then("I should see the path parameter")
    public void i_shold_see_the_path_parameter() {
    }


    @Then("I should see verify GET Parameter")
    public void iShouldSeeVerifyGETParameter() {
    }

    @Given("I perform authentication operation for {string} with body")
    public void iPerformAuthenticationOperationForWithBody(String arg0, DataTable table) {
    }

    @Then("I should see the author name as {string} with json validation")
    public void iShouldSeeTheAuthorNameAsWithJsonValidation(String arg0) {
    }
}
