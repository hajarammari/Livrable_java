package ma.emsi.livrable_java.tasks;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CreateSpreadsheetAndWriteToFile {
    public static void main(String[] args) throws Exception {

        //Création d'un objet de type fichier Excel
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Création d'un objet de type feuille Excel
        XSSFSheet spreadsheet = workbook.createSheet(" Games ");

        //Création d'un objet row (ligne)
        XSSFRow row;

        //Les données à inserer;
        Map<String, Object[]> gameInfo = new TreeMap<>();

        gameInfo.put("1", new Object[] { "Game Title", "Genre", "Release Year", "Price", "Rating" });
        gameInfo.put("2", new Object[] { "The Legend of Zelda: Breath of the Wild", "Action-adventure", 2017, 59.99, 10 });
        gameInfo.put("3", new Object[] { "Super Mario Odyssey", "Platformer", 2017, 49.99, 9});
        gameInfo.put("4", new Object[] { "Red Dead Redemption 2", "Action-adventure", 2018, 59.99, 10});
        gameInfo.put("5", new Object[] { "The Last of Us Part II", "Action-adventure", 2020, 59.99, 9});


        //parcourir les données pour les écrire dans le fichier Excel
        Set< String > keyid = gameInfo.keySet();
        int rowid = 0;

        for (String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object [] objectArr = gameInfo.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue(obj.toString());
            }

        }

        //Excrire les données dans un FileOutputStream
        FileOutputStream out = new FileOutputStream(new File("src/main/resources/gamesExcel.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("Travail bien fait!!!");
    }

}
