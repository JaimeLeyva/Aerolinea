package aerolinea;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author Enriqueta
 */
public class LeerArchivosExcel {
    
    /*
    Creanos un constructor 
    dentro de los parentesis creamos un objeto de tipo File
    llamado fileName
    */
    public LeerArchivosExcel(File fileName){
        /*
        dentro del contrsctor se crea un metodo del tipo List
        
        */
        List cellData = new ArrayList();
        
        /*
        vamos a hacer un try, dentro de ahi vamos a crear un objeto 
        de la clase FileInputStream
        */
        try{
            //se creo el objeto fileInputStream
            //dentro del parentecis se coloco el objeto fileName
            FileInputStream fileInputStream = new FileInputStream (fileName);
            
            //creamos la siguiente clase para crear un objeto de esa clase
            //dentro de lo parentesis colocamos el Objeto de FileInputStream
            XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
            
            /*
            creamos el objeto de la libreria XSSFsheet
            le asignamos workBook donde llamamos un metodo 
            */
            XSSFSheet hssfSheet = workBook.getSheetAt(0);
            
            /*
            agregamos la siguiente libreria
            */
            //obtenemos las filas de la hoja de Excel 
            Iterator rowIterator = hssfSheet.rowIterator();
            
            /*
            creamos un While para movernos por las filas 
            metimos el objeto rowIterator para con el while recorrer la filas
            */
            while(rowIterator.hasNext()){
            //obtenemos los datos de la fila 0
            XSSFRow hssfRow = (XSSFRow) rowIterator.next();
            
            /*
            los datos que esten almacenas en hssfRow se van al almacenar en el
            objeto iterator de cada dato que vamos obteniendo de cada fila 
            */
            Iterator iterator = hssfRow.cellIterator();
            
            /*
            creamos un objeto de tipo List
            */
            List cellTemp = new ArrayList(); 
            /*
            con este siglo nos moveremos por los datos que esten almacenados en 
            las celdas de cada fila 
            */
            while(iterator.hasNext()){
                /*
                los datos que esten almacenas en iterator
                se van almacenar en el objeto hssfCell de la liberia XSSFCell
                */
                XSSFCell hssfCell = (XSSFCell) iterator.next();
                /*
                colocamos el objeto de List llamamos el metodo agregar (add)
                y en los parentesis colocamos hssfCell lo cual los datos que estuvieron 
                almacenados en hssfCell se van a almacenar en cellTemp
                */
                cellTemp.add(hssfCell);
            }
            /*
            colocamos el Objeto cellDate llamamos el metodo agregar (add)
                y en los parentesis colocamos cellTemp lo cual los datos que estuvieron 
                almacenados en cellTemp se van a almacenar en callData
            */
            cellData.add(cellTemp);
        }
            
        }catch (Exception e){
            e.printStackTrace();
        }
         //los datos almacenados en cellData se pasaran a obtener
        obtener(cellData);
        
    }
    
    /*
    
    */
    private void obtener(List cellDataList){
        //size para obtener el tamaño de los datos de tipo List
        for(int i = 0; i < cellDataList.size(); i++){
            //obtenemos los datos cellDataList y los almacena en cellTempList
            List cellTempList = (List) cellDataList.get(i);
            for(int j = 0; j < cellTempList.size(); j++){
                /*
                get obtenemos los datos de j
                */
                XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);
                
                //se crea una variable de tipo String
                //con el toString convertimos los datos de hssfCell a String y se almacenan en stringCellValue
                String stringCellValue = hssfCell.toString();
                System.out.println(stringCellValue+" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args){
        //entre los parentecis ponemos la URL
        File f = new File("C://Users//Enriqueta//Desktop//Fernando//Unison//Tercer Semestre//Fundamentos de la Computación 3//Martes-AeropuertoDestino.xlsx");
        if(f.exists()){
           LeerArchivosExcel obj = new LeerArchivosExcel(f);
        }
    }
}