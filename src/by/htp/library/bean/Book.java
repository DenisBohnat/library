package by.htp.library.bean;

public class Book extends PrintEdition {

	private String author;
	private String publishingHouse;

	public Book(String name, String publishingHouse, String author, int year, int page) {
		super(name, year, page);
		this.author = author;
		this.publishingHouse = publishingHouse;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((publishingHouse == null) ? 0 : publishingHouse.hashCode());
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (publishingHouse == null) {
			if (other.publishingHouse != null)
				return false;
		} else if (!publishingHouse.equals(other.publishingHouse))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "name: " + super.getName() + " author: " + author + " publishingHouse: " + publishingHouse + " year: "
				+ super.getYear() + " pages: " + super.getPage();
	}

}
