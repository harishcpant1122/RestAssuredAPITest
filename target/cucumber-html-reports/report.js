$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/API_F1_place.feature");
formatter.feature({
  "name": "Place Validation API Test",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Verify that PUT API is successfully updating the places",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@APITest"
    },
    {
      "name": "@APITestPut"
    }
  ]
});
formatter.step({
  "name": "Add a place payload with \"\u003cname\u003e\" \"\u003clanguage\u003e\" and \"\u003caddress\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "User calls \"AddPlaceAPI\" with \"POST\" http request",
  "keyword": "When "
});
formatter.step({
  "name": "API call got success with status code 200",
  "keyword": "Then "
});
formatter.step({
  "name": "\"status\" in response body is \"OK\"",
  "keyword": "And "
});
formatter.step({
  "name": "Update a place payload with \"\u003cupdatedAddress\u003e\" and \"\u003ckey\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "User calls \"UpdatePlaceAPI\" with \"PUT\" http request",
  "keyword": "And "
});
formatter.step({
  "name": "\"msg\" in response body is \"Address successfully updated\"",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "name",
        "language",
        "address",
        "updatedAddress",
        "key"
      ]
    },
    {
      "cells": [
        "Scenario1_AddPlace_name",
        "Scenario1_AddPlace_language",
        "Scenario1_AddPlace_address",
        "Scenario1_UpdatePlace_address",
        "Scenario1_UpdatePlace_key"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify that PUT API is successfully updating the places",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@APITest"
    },
    {
      "name": "@APITestPut"
    }
  ]
});
formatter.step({
  "name": "Add a place payload with \"Scenario1_AddPlace_name\" \"Scenario1_AddPlace_language\" and \"Scenario1_AddPlace_address\"",
  "keyword": "Given "
});
formatter.match({
  "location": "PlaceSteps.add_a_place_payload_with_and(String,String,String)"
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
  "status": "passed"
});
formatter.step({
  "name": "API call got success with status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "PlaceSteps.api_call_got_success_with_status_code(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"status\" in response body is \"OK\"",
  "keyword": "And "
});
formatter.match({
  "location": "PlaceSteps.in_response_body_is(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Update a place payload with \"Scenario1_UpdatePlace_address\" and \"Scenario1_UpdatePlace_key\"",
  "keyword": "When "
});
formatter.match({
  "location": "PlaceSteps.update_a_place_payload_with_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User calls \"UpdatePlaceAPI\" with \"PUT\" http request",
  "keyword": "And "
});
formatter.match({
  "location": "PlaceSteps.user_calls_with_http_request(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"msg\" in response body is \"Address successfully updated\"",
  "keyword": "Then "
});
formatter.match({
  "location": "PlaceSteps.in_response_body_is(String,String)"
});
formatter.result({
  "status": "passed"
});
});