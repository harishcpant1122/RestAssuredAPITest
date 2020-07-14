$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/placeValidationAPI.feature");
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
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "name",
        "language",
        "address"
      ]
    },
    {
      "cells": [
        "India",
        "Hindi",
        "Sector 74 noida"
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
  "name": "Add a place payload with \"India\" \"Hindi\" and \"Sector 74 noida\"",
  "keyword": "Given "
});
formatter.match({
  "location": "apiStepdef.add_a_place_payload_with_and(String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User calls \"AddPlaceAPI\" with \"POST\" http request",
  "keyword": "When "
});
formatter.match({
  "location": "apiStepdef.user_calls_with_http_request(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "API call got success with status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "apiStepdef.api_call_got_success_with_status_code(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"status\" in response body is \"OK\"",
  "keyword": "And "
});
formatter.match({
  "location": "apiStepdef.in_response_body_is(String,String)"
});
formatter.result({
  "status": "passed"
});
});