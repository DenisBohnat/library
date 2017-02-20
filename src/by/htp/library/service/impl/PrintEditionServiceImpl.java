package by.htp.library.service.impl;

import by.htp.library.bean.Book;
import by.htp.library.bean.Journal;
import by.htp.library.bean.Newspaper;
import by.htp.library.bean.PrintEdition;
import by.htp.library.dao.DaoException;
import by.htp.library.dao.impl.PrintEditionDaoImpl;
import by.htp.library.service.IPrintEditionService;
import by.htp.library.service.PrintEditionServiceException;

public class PrintEditionServiceImpl implements IPrintEditionService {

	@Override
	public void listPrintEdition() {

		PrintEditionDaoImpl dao = new PrintEditionDaoImpl();
		PrintEdition[] printedition;
		try {
			printedition = dao.findPrintEdition();
			if (printedition != null) {
				for (int i = 0; i < printedition.length; i++) {
					OperationService operationService = new OperationService();
					boolean flag = operationService.nameCheck(printedition[i].getName());
					if (flag = true) {
						System.out.println(printedition[i].toString());
					}
				}
			} else {
				System.err.println("array is null");
			}
		} catch (DaoException | PrintEditionServiceException e) {
			System.err.println(e.getMessage() + e);
		}
	}

	@Override
	public void addPrintEdition(PrintEdition printEdition) {
		String tempPrintEdition = null;
		if (printEdition instanceof Book) {
			Book book = (Book) printEdition;
			tempPrintEdition = "Book," + book.getName() + "," + book.getPublishingHouse() + "," + book.getAuthor() + ","
					+ book.getYear() + "," + book.getPage();
		}
		if (printEdition instanceof Journal) {
			Journal journal = (Journal) printEdition;
			tempPrintEdition = "Journal," + journal.getName() + "," + journal.getIssue() + "," + journal.getYear() + ","
					+ journal.getPage();
		}
		if (printEdition instanceof Newspaper) {
			Newspaper newspaper = (Newspaper) printEdition;
			tempPrintEdition = "Newspaper," + newspaper.getName() + "," + newspaper.getIssueNumber() + ","
					+ newspaper.getNewspaperFiling() + "," + newspaper.getYear() + "," + newspaper.getPage();
		}
		PrintEditionDaoImpl dao = new PrintEditionDaoImpl();
		try {
			dao.addToFilePrintEdition(tempPrintEdition);
		} catch (DaoException e) {
			System.err.println(e.getMessage() + e);
		}
	}
}
