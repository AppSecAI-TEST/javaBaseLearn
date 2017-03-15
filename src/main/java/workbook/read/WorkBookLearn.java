package workbook.read;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xia_yu on 2017/3/15.
 */
public class WorkBookLearn {
    public static void main(String[] x){
        try{
            InputStream file=new FileInputStream("D:\\learnSpace\\javaBaseLearn\\src\\main\\resources\\data\\flights.xls");
             try {
                XSSFWorkbook wb=new XSSFWorkbook(file);
                 XSSFSheet sheet=wb.getSheetAt(0);//获取第一张表
                 XSSFRow row=sheet.getRow(0);//取第一行

                int rowNum=sheet.getLastRowNum();//取正文行数
                int colNum=row.getPhysicalNumberOfCells();//取总列数

                for(int i=1;i<=rowNum;i++){
                    row = sheet.getRow(i);
                    int j=0;
                    while (j<colNum){
                        XSSFCell cell=row.getCell(j);
                        if(cell.getCellType()==1){
                            System.out.println(cell.getStringCellValue());
                        }
                        else if(cell.getCellType()==0){
                            System.out.println(cell.getNumericCellValue());
                        }
                        j++;
                    }
                    System.out.println("====================================================");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
