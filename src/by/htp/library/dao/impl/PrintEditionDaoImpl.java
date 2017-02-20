package by.htp.library.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import by.htp.library.bean.Book;
import by.htp.library.bean.Journal;
import by.htp.library.bean.Newspaper;
import by.htp.library.bean.PrintEdition;
import by.htp.library.dao.DaoException;
import by.htp.library.dao.IPrintEditionDao;

public class PrintEditionDaoImpl implements IPrintEditionDao {

	private static final String PATH = "resources\\res.txt";

	@Override
	public PrintEdition[] findPrintEdition() throws DaoException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(PATH)));
			PrintEdition[] printEditionArray = new PrintEdition[this.countIndexArray(br)];
			String tmpLine = "";
			int countArray = 0;
			while ((tmpLine = br.readLine()) != null) {
				String[] strWord = tmpLine.split(",");
				if (this.readPrintEditionCase(strWord) != null) {
					printEditionArray[countArray] = this.readPrintEditionCase(strWord);
					countArray++;
				} else {
					System.err.println("Read line error");
				}
			}
			return printEditionArray;
		} catch (IOException e) {
			throw new DaoException("something wrong with file", e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					throw new DaoException("close file error", e);
				}
			}
		}
	}

	private int countIndexArray(BufferedReader reader) throws DaoException {
		int indexArray = 0;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(PATH)));
			while (br.readLine() != null) {
				indexArray++;
			}
			return indexArray;
		} catch (IOException e) {
			throw new DaoException("something wrong with file", e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					throw new DaoException("close file error", e);
				}
			}
		}
	}

	private PrintEdition readPrintEditionCase(String[] strArrayLine) {
		PrintEdition printEdition = null;
		switch (strArrayLine[0]) {
		case "Book":
			Book book = new Book(strArrayLine[1], strArrayLine[2], strArrayLine[3], Integer.parseInt(strArrayLine[4]),
					Integer.parseInt(strArrayLine[5]));
			printEdition = book;
			break;
		case "Journal":
			Journal journal = new Journal(strArrayLine[1], Integer.parseInt(strArrayLine[2]),
					Integer.parseInt(strArrayLine[3]), Integer.parseInt(strArrayLine[4]));
			printEdition = journal;
			break;
		case "Newspaper":
			Newspaper newspaper = new Newspaper(strArrayLine[1], Integer.parseInt(strArrayLine[2]),
					Integer.parseInt(strArrayLine[3]), Integer.parseInt(strArrayLine[4]),
					Integer.parseInt(strArrayLine[5]));
			printEdition = newspaper;
			break;
		default:
			break;
		}
		return printEdition;
	}

	public void addToFilePrintEdition(String strPrintedition) throws DaoException {
		if (strPrintedition != null) {
			File f = new File(PATH);
			PrintWriter pw = null;
			try {
				pw = new PrintWriter(new BufferedWriter(new FileWriter(f, true)));
				pw.println(strPrintedition);
			} catch (IOException e) {
				throw new DaoException("something wrong with file", e);
			} finally {
				if (pw != null) {
					pw.close();
				}
			}
		} else {
			System.err.println("String is null");
		}
	}
}
