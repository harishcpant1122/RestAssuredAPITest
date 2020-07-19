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
  "name": "Create an add place request with \"\u003caddPlaceRequest\u003e\"",
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
        "addPlaceRequest",
        "responseStatusCode"
      ]
    },
    {
      "cells": [
        "Req_AddPlace_Scenario1",
        "200"
      ]
    },
    {
      "cells": [
        "Req_AddPlace_Scenario2",
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
  "name": "Create an add place request with \"Req_AddPlace_Scenario1\"",
  "keyword": "Given "
});
formatter.match({
  "location": "PlaceSteps.create_an_add_place_request_with(String)"
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
  "name": "Create an add place request with \"Req_AddPlace_Scenario2\"",
  "keyword": "Given "
});
formatter.match({
  "location": "PlaceSteps.create_an_add_place_request_with(String)"
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
formatter.scenarioOutline({
  "name": "Verify that GET API is successfully getting the places",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@APITest"
    },
    {
      "name": "@APITestGet"
    }
  ]
});
formatter.step({
  "name": "Create an add place request with \"\u003caddPlaceRequest\u003e\"",
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
  "name": "Verify the \"name\" field value as \"\u003cResponseName\u003e\" when user calls the \"GetPlaceAPI\" for \"\u003caddPlaceRequest\u003e\"",
  "keyword": "When "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "addPlaceRequest",
        "responseStatusCode",
        "ResponseName"
      ]
    },
    {
      "cells": [
        "Req_GetPlace_Scenario1",
        "responseStatusCode",
        "Frontline house"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verify that GET API is successfully getting the places",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@APITest"
    },
    {
      "name": "@APITestGet"
    }
  ]
});
formatter.step({
  "name": "Create an add place request with \"Req_GetPlace_Scenario1\"",
  "keyword": "Given "
});
formatter.match({
  "location": "PlaceSteps.create_an_add_place_request_with(String)"
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
  "name": "Verify the \"name\" field value as \"Frontline house\" when user calls the \"GetPlaceAPI\" for \"Req_GetPlace_Scenario1\"",
  "keyword": "When "
});
formatter.match({
  "location": "PlaceSteps.verify_the_field_value_as_when_user_calls_the_for(String,String,String,String)"
});
formatter.result({
  "status": "passed"
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
  "name": "Create an add place request with \"\u003caddPlaceRequest\u003e\"",
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
  "name": "Create an update place request with \"\u003cupdatePlaceRequest\u003e\"",
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
        "addPlaceRequest",
        "responseStatusCode",
        "updatePlaceRequest"
      ]
    },
    {
      "cells": [
        "Req_AddPlace_Scenario1",
        "200",
        "Req_updatePlace_Scenario1"
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
  "name": "Create an add place request with \"Req_AddPlace_Scenario1\"",
  "keyword": "Given "
});
formatter.match({
  "location": "PlaceSteps.create_an_add_place_request_with(String)"
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
  "name": "Create an update place request with \"Req_updatePlace_Scenario1\"",
  "keyword": "When "
});
formatter.match({
  "location": "PlaceSteps.create_an_update_place_request_with(String)"
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