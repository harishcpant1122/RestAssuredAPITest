//package stepDefinitions.fileupload;
//
//
//import static org.testng.Assert.assertEquals;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//
//import org.apache.commons.io.FileUtils;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class S3FileUpload {
//	
//	String requestFileName;
//	String tdFilePath;
//	String srcFilePath;
//	String desFilePath;
//	@Given("Place a test file with {string}")
//	public void place_a_test_file_with(String fileName) throws IOException {
//		requestFileName=fileName;
//		tdFilePath="src\\test\\resources\\TestData\\GSFiles\\QA\\Request\\";
//		srcFilePath="C:\\WorkingFolder\\GS\\PSGSCode\\S3_Request\\";
//		desFilePath="C:\\WorkingFolder\\GS\\PSGSCode\\S3_Response\\";
//		File tdFile = new File(tdFilePath+requestFileName);		
//		File srcFile = new File(srcFilePath);
//		FileUtils.copyFileToDirectory(tdFile, srcFile);
//		
//		System.out.println("File Copied successfully..  ");		
//		
//	}
//
//	@When("I call batch processing request")
//	public void i_call_batch_processing_request() throws InterruptedException {
//		System.out.println("Batch processing called and waiting for 5 seconds");
//		Thread.sleep(5000);
//	}
//	
//	@Then("Response File {string} should get generated")
//	public void response_File_should_get_generated(String responseFileName) {
//		System.out.println("Response File name : "+responseFileName);
//	}
//
//	@Then("Count in both file should match")
//	public void count_in_both_file_should_match() throws IOException {
//		 BufferedReader srcBufferedReader = new BufferedReader(new FileReader(tdFilePath+requestFileName));
//	     String srcInput;
//	     int srcCount = 0;
//	     while((srcInput = srcBufferedReader.readLine()) != null)
//	     {
//	    	 srcCount++;
//	     }
//
//	     System.out.println("Source Count : "+srcCount);
//	     
//		 BufferedReader desBufferedReader = new BufferedReader(new FileReader(desFilePath+requestFileName));
//		 String desInput;
//	     int desCount = 0;
//	     while((desInput = desBufferedReader.readLine()) != null)
//	     {
//	    	 desCount++;
//	     }
//
//	     System.out.println("Destination Count : "+desCount);
//		
//	}
//	
//	@Then("Count in {string} and {string} should match")
//	public void count_in_and_should_match(String srcFile, String desFile) throws IOException {
//		 BufferedReader srcBufferedReader = new BufferedReader(new FileReader(tdFilePath+srcFile));
//	     String srcInput;
//	     int srcCount = 0;
//	     while((srcInput = srcBufferedReader.readLine()) != null)
//	     {
//	    	 srcCount++;
//	     }
//
//	     System.out.println("Source Count : "+srcCount);
//	     
//		 BufferedReader desBufferedReader = new BufferedReader(new FileReader(desFilePath+desFile));
//		 String desInput;
//	     int desCount = 0;
//	     while((desInput = desBufferedReader.readLine()) != null)
//	     {
//	    	 desCount++;
//	     }
//
//	     System.out.println("Destination Count : "+desCount);
//	     
//	     assertEquals(srcCount,desCount);	
//	}
//
//	@Then("Perform the cleanup")
//	public void perform_the_cleanup() {
//		System.out.println("file needs deletion : "+srcFilePath+requestFileName);
//		File f=new File(srcFilePath+requestFileName);
//		f.delete();
//		System.out.println("file deleted sucessfully : ");
//	}
//}
