package dataClasses;

public class BookInformation {
	public String title,writer,publisher,remarks;
	public int price;
	public boolean[] genre = new boolean[5];
	public boolean stock,validateResult;
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
