package dataClasses;

public class BookBean {
	private String title="";
	private String writer="";
	private String publisher="";
	private String remarks="";
	private int price;
	private boolean[] genre = new boolean[5];
	private boolean stock;
	private boolean validateResult;
	
	public String getTitle() {
		return title == null?"":title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer==null?"":writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher==null?"":publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getRemarks() {
		return remarks==null?"":remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean[] getGenre() {
		return genre;
	}
	public void setGenre(boolean[] genre) {
		this.genre = genre;
	}
	public boolean isStock() {
		return stock;
	}
	public void setStock(boolean stock) {
		this.stock = stock;
	}
	public boolean isValidateResult() {
		return validateResult;
	}
	public void setValidateResult(boolean validateResult) {
		this.validateResult = validateResult;
	}
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("{");
		str.append("title:");
		str.append(title);
		str.append(",");
		str.append("writer:");
		str.append(writer);
		str.append(",");
		str.append("publisher:");
		str.append(publisher);
		str.append(",");
		str.append("remarks:");
		str.append(remarks);
		str.append(",");
		str.append("price:");
		str.append(price);
		str.append(",");
		str.append("{");
		for(boolean b : genre) str.append(b);
		str.append("}");
		str.append(",");
		str.append("stock:");
		str.append(stock);
		str.append("}");
		return str.toString();
	}
}
