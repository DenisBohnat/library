package by.htp.library.bean;

public class Journal extends PrintEdition {

	private int issue;

	public Journal(String name, int issue, int year, int page) {
		super(name, year, page);
		this.issue = issue;

	}

	public int getIssue() {
		return issue;
	}

	public void setIssue(int issue) {
		this.issue = issue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + issue;
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
		Journal other = (Journal) obj;
		if (issue != other.issue)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "name: " + super.getName() + " issue: " + issue + " year: " + super.getYear() + " pages: "
				+ super.getPage();
	}

}
