package org.example.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.example.app.Stock;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StockStepDefinations {

    @Given("I have the following stocks in the company")
    public void givenStoresIs(DataTable dataTable) {

        List<Stock> stocks = new ArrayList<>();
        RestAssured.baseURI = "http://localhost:8080";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            Stock stock = new Stock(columns.get("companyName"),Integer.parseInt(columns.get("currentPrice")),
                    Integer.parseInt(columns.get("totalShares")), columns.get("userName"));
            Response response = request.body(stock)
                    .post("/api/v1/stock/create");
            Assertions.assertEquals(200,response.getStatusCode());
        }
    }

    @Given("Get all stocks from the company")
    public void getAllStocks(){

        RestAssured.baseURI = "http://localhost:8080";
        RequestSpecification request = RestAssured.given();
        Response response = request.get("/api/v1/stock/getAllStocks");
        String jsonString = response.asString();
        List<Stock> stocks = JsonPath.from(jsonString).get();
        Assertions.assertEquals(7, stocks.size());
    }

}