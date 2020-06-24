$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/features/placeValidation.feature");
formatter.feature({
  "name": "Place Validation",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify that place is added successfully using add place api",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Add a place payload",
  "keyword": "Given "
});
formatter.match({
  "location": "apiStepdef.add_a_place_payload()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user calls AddPlaceAPI with post http request",
  "keyword": "When "
});
formatter.match({
  "location": "apiStepdef.user_calls_AddPlaceAPI_with_post_http_request()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The Post API call got success with status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "apiStepdef.the_API_call_got_success_with_status_code(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Status in response body is OK",
  "keyword": "And "
});
formatter.match({
  "location": "apiStepdef.status_in_response_body_is_OK()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify that place is updated successfully using put place api",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Add a place payload",
  "keyword": "Given "
});
formatter.match({
  "location": "apiStepdef.add_a_place_payload()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user calls AddPlaceAPI with post http request",
  "keyword": "When "
});
formatter.match({
  "location": "apiStepdef.user_calls_AddPlaceAPI_with_post_http_request()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The Post API call got success with status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "apiStepdef.the_API_call_got_success_with_status_code(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Status in response body is OK",
  "keyword": "And "
});
formatter.match({
  "location": "apiStepdef.status_in_response_body_is_OK()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user calls updatePlaceAPI with put http request",
  "keyword": "When "
});
formatter.match({
  "location": "apiStepdef.user_calls_updatePlaceAPI_with_put_http_request()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The API put call got success with status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "apiStepdef.the_API_put_call_got_success_with_status_code(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Status in response body is Address successfully updated",
  "keyword": "And "
});
formatter.match({
  "location": "apiStepdef.status_in_response_body_is_Address_successfully_updated()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify that user can get the place successfully using get place api",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Add a place payload",
  "keyword": "Given "
});
formatter.match({
  "location": "apiStepdef.add_a_place_payload()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user calls AddPlaceAPI with post http request",
  "keyword": "When "
});
formatter.match({
  "location": "apiStepdef.user_calls_AddPlaceAPI_with_post_http_request()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The Post API call got success with status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "apiStepdef.the_API_call_got_success_with_status_code(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Status in response body is OK",
  "keyword": "And "
});
formatter.match({
  "location": "apiStepdef.status_in_response_body_is_OK()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user calls getPlaceAPI with get http request",
  "keyword": "When "
});
formatter.match({
  "location": "apiStepdef.user_calls_getPlaceAPI_with_get_http_request()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The API get call got success with status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "apiStepdef.the_API_get_call_got_success_with_status_code(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Status in get response body should be correct",
  "keyword": "And "
});
formatter.match({
  "location": "apiStepdef.status_in_get_response_body_should_be_correct()"
});
formatter.result({
  "status": "passed"
});
});