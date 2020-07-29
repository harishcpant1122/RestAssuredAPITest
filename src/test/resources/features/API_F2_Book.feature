Feature: Book Validation API Test

# -------POST API Test---------------------
@BookAPI @BookAPIPost @Regression @Sanity
Scenario Outline: Verify that Book is added successfully using add Book post api 
Given Create an add book request with "<addBookRequest>"
When I call Book "AddBookAPI" with "POST" http request
Then Book API call got success with status code "<responseStatusCode>"
And Book API "Msg" in response body is "successfully added"

Examples:

|addBookRequest 					 | responseStatusCode	  |
|Req_AddBook_Scenario1     |	200     		        |




