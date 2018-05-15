package com.qa.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.*;
import org.junit.Test;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class APITest {
	
	RequestSpecification request;
	Response response;
	ValidatableResponse json;
	

	@Test
	public void exampleRestTestWhichShould200() {
	    given()
	    	.contentType(ContentType.JSON)
	    	.pathParam("apikey", "dbd34baf")
	    	.pathParam("t", "IT")
	    	.pathParam("y", "2017")
	    
	    .when()
	    	.get("http://www.omdbapi.com/?apikey={apikey}&t={t}&y={y}")
	    	
	    	
	    .then()
	    	.statusCode(200)
	    	.body("Rated", equalTo("R"));
	}
	
	
	@Given("^a film exits with the title of \"([^\"]*)\"$")
	public void a_film_exits_with_the_title_of(String title) throws Throwable {
	    request = given()
		    	.contentType(ContentType.JSON)
		    	.pathParam("apikey", "dbd34baf")
		    	.pathParam("t", title);
	}

	@Given("^the film has a given year of \"([^\"]*)\"$")
	public void the_film_has_a_given_year_of(String year) throws Throwable {
	    request = request.pathParam("y", year);
	}

	@When("^a user gets the film from this information$")
	public void a_user_gets_the_film_from_this_information() throws Throwable {
		response = request.when()
				.get("http://www.omdbapi.com/?apikey={apikey}&t={t}&y={y}");
	}

	@Then("^the status code reads \"([^\"]*)\"$")
	public void the_status_code_reads(String code) throws Throwable {
	    json = response.then()
		    	.statusCode(Integer.parseInt(code))
		    	.body("Rated", equalTo("R"));
	}
	
	/*
	@Test
	public void exampleRestTest() {
	    given()
	        .contentType(ContentType.JSON)
	        .pathParam("id", "AskJsd8Sd")
	    .when()
	        .get("/examplepath/{id}")
	    .then()
	        .statusCode(200)
	        .body("firstName", equalTo("Onur"))
	        .body("Surname", equalTo("Baskirt"));
	}*/

	
}
