package by.htp.library.bean;

public class Newspaper extends PrintEdition {

	private int issueNumber;
	private int newspaperFiling;

	public Newspaper(String name, int issueNumber, int newspaperFiling, int year, int page) {
		super(name, year, page);
		this.issueNumber = issueNumber;
		this.newspaperFiling = newspaperFiling;

	}

	public int getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(int issueNumber) {
		this.issueNumber = issueNumber;
	}

	public int getNewspaperFiling() {
		return newspaperFiling;
	}

	public void setNewspaperFiling(int newspaperFiling) {
		this.newspaperFiling = newspaperFiling;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + issueNumber;
		result = prime * result + newspaperFiling;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Newspaper other = (Newspaper) obj;
		if (issueNumber != other.issueNumber)
			return false;
		if (newspaperFiling != other.newspaperFiling)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "name: " + super.getName() + " issueNumber: " + issueNumber + " newspaperFiling: " + newspaperFiling
				+ " year: " + super.getYear() + " pages: " + super.getPage();
	}

}
