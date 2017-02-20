package by.htp.library.dao;

import by.htp.library.bean.PrintEdition;

public interface IPrintEditionDao {

	PrintEdition[] findPrintEdition() throws DaoException;

	void addToFilePrintEdition(String strPrintedition) throws DaoException;
}
