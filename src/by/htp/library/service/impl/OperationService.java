package by.htp.library.service.impl;

import by.htp.library.service.PrintEditionServiceException;

public class OperationService {

	public boolean nameCheck(String namePrintEdition) throws PrintEditionServiceException {
		boolean flag = false;
		char[] chararray = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', '.' };
		char[] charName = namePrintEdition.toLowerCase().toCharArray();
		int count = 0;
		for (int k = 0; k < charName.length; k++) {
			for (int l = 0; l < chararray.length; l++) {
				if (charName[k] == chararray[l]) {
					count++;
				}
			}
		}
		if (namePrintEdition.length() != count) {
			throw new PrintEditionServiceException("Incorrect name " + namePrintEdition);
		} else {
			flag = true;
		}
		return flag;
	}

}
