package utils;

import common.Constants;
import data.LoginData;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class ExcelUtil {

    public static LoginData getLoginData(String strKey){
        LoginData loginData = new LoginData();
        ArrayList<String> lstHeaders = new ArrayList<String>();
        FileInputStream inputStream ;
        Field[] fields ;
        String strFilePath = Constants.LOGIN_DATA_PATH;
        String strFileName = Constants.LOGIN_DATA_FILE_NAME;

        try {
            fields = loginData.getClass().getDeclaredFields();
            inputStream = new FileInputStream(new File(System.getProperty(Constants.HOME_DIRECTORY)+strFilePath+strFileName));
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet loginDataSheet = workbook.getSheetAt(0);

            int iRows = loginDataSheet.getPhysicalNumberOfRows();
            int iColumns = loginDataSheet.getRow(0).getPhysicalNumberOfCells();
            int iDataColumn = -1, iDataRow = -1;
            for (int i=0; i<iRows; i++){
                String cellData;
                Row headerRow = loginDataSheet.getRow(i);
                for (int j=0; j<iColumns; j++) {
                    if (i==0){
                        cellData = headerRow.getCell(j).getStringCellValue();
                        lstHeaders.add(cellData);
                        if(fields[0].getName().equals(cellData)){
                            iDataColumn = j;
                        }
                    }
                    else {
                        if(j==iDataColumn) {
                            cellData = headerRow.getCell(j).getStringCellValue();
                            if (strKey.equals(cellData)){
                                iDataRow = i;
                                break;
                            }
                        }
                    }
                }
            }
            for(int k=0; k<iColumns; k++){
                Row row = loginDataSheet.getRow(iDataRow);
                if(lstHeaders.get(k).toLowerCase().equals(fields[k].getName().toLowerCase())){
                    String fieldName = fields[k].getName();
                    String fieldValue = row.getCell(k).getStringCellValue();

                    loginData.getClass().getField(fieldName).set(loginData,fieldValue);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return loginData;
    }
}
