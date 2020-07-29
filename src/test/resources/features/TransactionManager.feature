Feature: Transaction Manager API Test

@TMAPI @TMAPIPost @Regression @Sanity
Scenario Outline: Verify that Transaction is added successfully using add transaction post api 
Given Create an add transaction request with "<addTransactionRequest>"
When I call transaction "AddTransactionManagerAPI" with "POST" http request
Then Transaction API call got success with status code "<responseStatusCode>"
#And Transaction API "status" in response body is "SUCCESS"
And Transaction API "status" in response body is matching with database

Examples:

|addTransactionRequest		  		| responseStatusCode	  |
|Req_AddTransaction_Success 		|	200     		          |

#@TMAPI @TMAPIPost @Regression
#Scenario Outline: Verify that Transaction is added successfully using add transaction post api 
#Given Create an add transaction request with "<addTransactionRequest>"
#When I call transaction "AddTransactionManagerAPI" with "POST" http request
#Then Transaction API call got success with status code "<responseStatusCode>"
#
#
#Examples:
#
#|addTransactionRequest		  		| responseStatusCode	  |
#|Req_AddTransaction_NullPayload |	500     		          |

