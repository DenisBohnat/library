package by.htp.library;

import by.htp.library.bean.Book;
import by.htp.library.bean.Journal;
import by.htp.library.bean.Newspaper;
import by.htp.library.bean.PrintEdition;
import by.htp.library.service.impl.PrintEditionServiceImpl;

public class Main {

	public static void main(String[] args) {

		PrintEdition book = new Book("Book", "Publishing", "Author book", 1999, 455);
		PrintEdition journal = new Journal("Journal", 12, 2010, 120);
		PrintEdition newspaper = new Newspaper("Newspaper", 1, 10, 2017, 45);

		PrintEditionServiceImpl service = new PrintEditionServiceImpl();
		service.listPrintEdition();

		System.out.println("----------------------------------------");

		service.addPrintEdition(book);
		service.addPrintEdition(journal);
		service.addPrintEdition(newspaper);
	}
}
