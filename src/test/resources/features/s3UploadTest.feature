Feature: S3 upload Test

#@S3Upload @Regression @Sanity
#Scenario Outline: Verify the row count between source and target file
#Given Place a test file with "<RequestFile>"
#When I call batch processing request
#Then Response File "<ResponseFile>" should get generated
#And Row count in "<RequestFile>" and "<ResponseFile>" should match
#And Perform the cleanup
#
#Examples:
#
#|RequestFile		  | ResponseFile	  |
#|S3_Req_2.xlsx 		|	S3_Res_2.xlsx |


#@S3Upload @Regression @Sanity
#Scenario Outline: Verify the column count between source and target file
#Given Place a test file with "<RequestFile>"
#When I call batch processing request
#Then Response File "<ResponseFile>" should get generated
#And Column count in "<RequestFile>" and "<ResponseFile>" should match
#And Perform the cleanup
#
#Examples:
#
#|RequestFile		  | ResponseFile	  |
#|S3_Req_2.xlsx 		|	S3_Res_2.xlsx    |

@S3Upload @Regression @Sanity
Scenario Outline: Verify the column count between source and target file
Given Place a test file with "<RequestFile>"
When I call batch processing request
Then Response File "<ResponseFile>" should get generated
And Row count in "<RequestFile>" and "<ResponseFile>" should match
And Column count in "<RequestFile>" and "<ResponseFile>" should match
And Compare the data between "<RequestFile>" and "<ResponseFile>" should match
And Perform the cleanup

Examples:

|RequestFile		  | ResponseFile	  |
|S3_Req_2.xlsx 		|	S3_Res_2.xlsx    |







