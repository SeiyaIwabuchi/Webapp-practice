package bean;

import java.util.List;

/**
 * 書籍Beanクラス
 * 
 * @author t.kawana
 *
 */
public class BookBean extends BaseBean {
	
	// タイトル
	String title;
	// 著者
	String writter;
	// 出版社
	String publisher;
	// 価格
	String price;
	// ジャンル
	List<String> genreList;
	// 在庫
	boolean stock;
	// 備考
	String remarks;
	
	/**
	 * タイトル取得
	 * 
	 * @return タイトル
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * タイトル設定
	 * 
	 * @param title タイトル
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * 著者取得
	 * 
	 * @return 著者
	 */
	public String getWritter() {
		return writter;
	}
	
	/**
	 * 著者設定
	 * 
	 * @param writter 著者
	 */
	public void setWritter(String writter) {
		this.writter = writter;
	}
	
	/**
	 * 出版社取得
	 * 
	 * @return 出版社
	 */
	public String getPublisher() {
		return publisher;
	}
	
	/**
	 * 出版社設定
	 * 
	 * @param publisher 出版社
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	/**
	 * 価格取得
	 * 
	 * @return 価格
	 */
	public String getPrice() {
		return price;
	}
	
	/**
	 * 価格設定
	 * 
	 * @param price 価格
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	
	/**
	 * ジャンル取得
	 * 
	 * @return ジャンル
	 */
	public List<String> getGenreList() {
		return genreList;
	}
	
	/**
	 * ジャンル設定
	 * 
	 * @param genreList ジャンル
	 */
	public void setGenreList(List<String> genreList) {
		this.genreList = genreList;
	}
	
	/**
	 * 在庫有無判別
	 * 
	 * @return 在庫有無（false：なし、true：あり）
	 */
	public boolean isStock() {
		return stock;
	}
	
	/**
	 * 在庫有無設定
	 * 
	 * @param stock 在庫有無（false：なし、true：あり）
	 */
	public void setStock(boolean stock) {
		this.stock = stock;
	}
	
	/**
	 * 備考取得
	 * 
	 * @return 備考
	 */
	public String getRemarks() {
		return remarks;
	}
	
	/**
	 * 備考設定
	 * 
	 * @param remarks 備考
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
