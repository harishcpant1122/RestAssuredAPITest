$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/API_F1_place.feature");
formatter.feature({
  "name": "Place Validation API Test",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Verify that place is added successfully using add place post api",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@APITest"
    },
    {
      "name": "@APITestPost"
    }
  ]
});
formatter.step({
  "name": "Add a place with \"\u003crequest\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "User calls \"AddPlaceAPI\" with \"POST\" http request",
  "keyword": "When "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "request",
        "responseStatusCode"
      ]
    },
    {
      "cells": [
        "Req_AddPlace_Scenario1",
        "200"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify that place is added successfully using add place post api",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@APITest"
    },
    {
      "name": "@APITestPost"
    }
  ]
});
formatter.step({
  "name": "Add a place with \"Req_AddPlace_Scenario1\"",
  "keyword": "Given "
});
formatter.match({
  "location": "PlaceSteps.add_a_place_with(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User calls \"AddPlaceAPI\" with \"POST\" http request",
  "keyword": "When "
});
formatter.match({
  "location": "PlaceSteps.user_calls_with_http_request(String,String)"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat stepDefinitions.api.apiCommon.callAPI(apiCommon.java:85)\r\n\tat stepDefinitions.api.PlaceSteps.user_calls_with_http_request(PlaceSteps.java:72)\r\n\tat ✽.User calls \"AddPlaceAPI\" with \"POST\" http request(file:src/test/resources/features/API_F1_place.feature:7)\r\n",
  "status": "failed"
});
});