package stepDefinitions.fileupload;


import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S3FileUpload_POI {
	
	String requestFileName;
	String tdFilePath;
	String srcFilePath;
	String desFilePath;
	@Given("Place a test file with {string}")
	public void place_a_test_file_with(String fileName) throws IOException {
		requestFileName=fileName;
		tdFilePath="src\\test\\resources\\TestData\\GSFiles\\QA\\Request\\";
		srcFilePath="C:\\WorkingFolder\\GS\\PSGSCode\\S3_Request\\";
		desFilePath="C:\\WorkingFolder\\GS\\PSGSCode\\S3_Response\\";
		File tdFile = new File(tdFilePath+requestFileName);		
		File srcFile = new File(srcFilePath);
		FileUtils.copyFileToDirectory(tdFile, srcFile);
		
		System.out.println("File Copied successfully..  ");		
		
	}

	@When("I call batch processing request")
	public void i_call_batch_processing_request() throws InterruptedException {
		System.out.println("Batch processing called and waiting for 5 seconds");
		Thread.sleep(5000);
	}
	
	@Then("Response File {string} should get generated")
	public void response_File_should_get_generated(String responseFileName) {
		System.out.println("Response File name : "+responseFileName);
	}

	@Then("Row count in {string} and {string} should match")
	public void count_in_and_should_match(String srcFile, String desFile) throws IOException {
	     	FileInputStream srcFileIS = new FileInputStream(new File(tdFilePath+srcFile));
	     	XSSFWorkbook srcWorkbook = new XSSFWorkbook(srcFileIS);
	     	XSSFSheet srcSheet = srcWorkbook.getSheetAt(0);
	        System.out.println("Source File Row count -->"+srcSheet.getPhysicalNumberOfRows());
		
	     	FileInputStream desFileIS = new FileInputStream(new File(desFilePath+desFile));
	     	XSSFWorkbook desWorkbook = new XSSFWorkbook(desFileIS);
	     	XSSFSheet desSheet = desWorkbook.getSheetAt(0);
	        System.out.println("Destination File Row count -->"+desSheet.getPhysicalNumberOfRows());
	        assertEquals(srcSheet.getPhysicalNumberOfRows(),desSheet.getPhysicalNumberOfRows());	
	}
	
	@Then("Column count in {string} and {string} should match")
	public void column_count_in_and_should_match(String srcFile, String desFile) throws IOException {
     	FileInputStream srcFileIS = new FileInputStream(new File(tdFilePath+srcFile));
     	XSSFWorkbook srcWorkbook = new XSSFWorkbook(srcFileIS);
     	XSSFSheet srcSheet = srcWorkbook.getSheetAt(0);
        System.out.println("Source File Row count -->"+srcSheet.getLastRowNum());
	
     	FileInputStream desFileIS = new FileInputStream(new File(desFilePath+desFile));
     	XSSFWorkbook desWorkbook = new XSSFWorkbook(desFileIS);
     	XSSFSheet desSheet = desWorkbook.getSheetAt(0);
        System.out.println("Destination File Row count -->"+desSheet.getLastRowNum());
        assertEquals(srcSheet.getLastRowNum(),desSheet.getLastRowNum());
	}

	@Then("Perform the cleanup")
	public void perform_the_cleanup() {
		System.out.println("file needs deletion : "+srcFilePath+requestFileName);
		File f=new File(srcFilePath+requestFileName);
		f.delete();
		System.out.println("file deleted sucessfully : ");
	}
	
	@Then("Compare the data between {string} and {string} should match")
	public void compare_the_data_between_and_should_match(String srcFile, String desFile) {
		try {
			
		 // get input excel files
        FileInputStream excellFile1 = new FileInputStream(new File(tdFilePath+srcFile));
        FileInputStream excellFile2 = new FileInputStream(new File(desFilePath+desFile));

        // Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook1 = new XSSFWorkbook(excellFile1);
        XSSFWorkbook workbook2 = new XSSFWorkbook(excellFile2);

        // Get first/desired sheet from the workbook
        XSSFSheet sheet1 = workbook1.getSheetAt(0);
        XSSFSheet sheet2 = workbook2.getSheetAt(0);

        // Compare sheets
        if(compareTwoSheets(sheet1, sheet2)) {
            System.out.println("\n\nThe two excel sheets are Equal");
        } else {
            System.out.println("\n\nThe two excel sheets are Not Equal");
        }
        
        //close files
        excellFile1.close();
        excellFile2.close();

    	} catch (Exception e) {e.printStackTrace();}
	}
	
    public static boolean compareTwoSheets(XSSFSheet sheet1, XSSFSheet sheet2) {
        int firstRow1 = sheet1.getFirstRowNum();
        int lastRow1 = sheet1.getLastRowNum();
        boolean equalSheets = true;
        for(int i=firstRow1; i <= lastRow1; i++) {
            
            System.out.println("\n\nComparing Row "+i);
            
            XSSFRow row1 = sheet1.getRow(i);
            XSSFRow row2 = sheet2.getRow(i);
            if(!compareTwoRows(row1, row2)) {
                equalSheets = false;
                System.out.println("Row "+i+" - Not Equal");
                break;
            } else {
                System.out.println("Row "+i+" - Equal");
            }
        }
        return equalSheets;
    }
    
    public static boolean compareTwoRows(XSSFRow row1, XSSFRow row2) {
        if((row1 == null) && (row2 == null)) {
            return true;
        } else if((row1 == null) || (row2 == null)) {
            return false;
        }
        
        int firstCell1 = row1.getFirstCellNum();
        int lastCell1 = row1.getLastCellNum();
        boolean equalRows = true;
        
        // Compare all cells in a row
        for(int i=firstCell1; i <= lastCell1; i++) {
            XSSFCell cell1 = row1.getCell(i);
            XSSFCell cell2 = row2.getCell(i);
            if(!compareTwoCells(cell1, cell2)) {
                equalRows = false;
                System.err.println("       Cell "+i+" - NOt Equal");
                break;
            } else {
                System.out.println("       Cell "+i+" - Equal");
            }
        }
        return equalRows;
    }
    
    public static boolean compareTwoCells(XSSFCell cell1, XSSFCell cell2) {
        if((cell1 == null) && (cell2 == null)) {
            return true;
        } else if((cell1 == null) || (cell2 == null)) {
            return false;
        }
        
        boolean equalCells = false;
        CellType type1 = cell1.getCellType();
        CellType type2 = cell2.getCellType();
        if (type1 == type2) {
            if (cell1.getCellStyle().equals(cell2.getCellStyle())) {
                // Compare cells based on its type
                switch (cell1.getCellType()) {
//                case HSSFCell.CELL_TYPE_FORMULA:
//                    if (cell1.getCellFormula().equals(cell2.getCellFormula())) {
//                        equalCells = true;
//                    }
//                    break;
                case NUMERIC:
                    if (cell1.getNumericCellValue() == cell2
                            .getNumericCellValue()) {
                        equalCells = true;
                    }
                    break;
                case STRING:
                    if (cell1.getStringCellValue().equals(cell2
                            .getStringCellValue())) {
                        equalCells = true;
                    }
                    break;
//                case BLANK:
//                    if (cell2.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
//                        equalCells = true;
//                    }
//                    break;
                case BOOLEAN:
                    if (cell1.getBooleanCellValue() == cell2
                            .getBooleanCellValue()) {
                        equalCells = true;
                    }
                    break;
                case ERROR:
                    if (cell1.getErrorCellValue() == cell2.getErrorCellValue()) {
                        equalCells = true;
                    }
                    break;
                default:
                    if (cell1.getStringCellValue().equals(
                            cell2.getStringCellValue())) {
                        equalCells = true;
                    }
                    break;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
        return equalCells;
    }
    
}
