import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFile {
	// this checks to see if the cell type is numbers or strings
	public static Object ReadCell(Cell cell) {
		if (cell.getCellType() == CellType.NUMERIC) {
			return (int) cell.getNumericCellValue();
		} else {
			return cell.getStringCellValue();
		}
	}
	public static void ReadCells(Row row, Card card) {
		Iterator<Cell> cellIterator = row.cellIterator();
		int idx = 0;
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			if (idx == 0) {
				String name = (String) ReadCell(cell);
				card.setName(name);
			}
			if (idx == 1) {
				int cost = (int) ReadCell(cell);
				card.setCost(cost);
			}
			if (idx == 2) {
				int Power = (int) ReadCell(cell);
				card.setPower(Power);
			}
			if (idx == 3) {
				int Counter = (int) ReadCell(cell);
				card.setCounter(Counter);
			}
			if (idx == 4) {
				String type = (String) ReadCell(cell);
				card.setType(type);
			}
			if (idx == 5) {
				String effect = (String) ReadCell(cell);
				card.setEffect(effect);
			}
			idx += 1;
		}
		
	}
	
	public static void Readfile(String filename, ArrayList<Card> Deck) {
		try {
			FileInputStream file = new FileInputStream( new File(filename));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			if (!rowIterator.hasNext()) {
				workbook.close();
				return;
			} else {
				rowIterator.next();
			}
			
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Card card = new Card();
				ReadCells(row ,card);
				Deck.add(card);
			}
			workbook.close();
			
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
