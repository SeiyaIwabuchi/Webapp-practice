package validate;

import java.util.List;

public class Validator {
	private StringBuffer errors;
	public Validator() {
		errors = new StringBuffer();
	}
	/**
	 * 必須チェック
	 */
	public boolean requiereCheck(String paramName, String[] params) {
		boolean result = true;
		if(paramName.equals("title")) {
			if(params[0].length() == 0) {
				result = false;
				errors.append(createErrorHtml("タイトルは必須⼊⼒です。"));
			}
		}
		if(paramName.equals("writer")) {
			if(params[0].length() > 10) {
				result = false;
				errors.append(createErrorHtml("著者は10文字以内です。"));
			}
		}
		if(paramName.equals("publisher")) {

		}
		if(paramName.equals("price")) {
			String _para = params[0];
			try {
				int price = Integer.parseInt(_para);
				if(price < 0) {
					result = false;
					errors.append(createErrorHtml("価格は0以上です。"));
				}
			}catch(NumberFormatException e) {
				if(_para.equals("") == false) {
					result = false;
					errors.append(createErrorHtml("価格は数値⼊⼒です。"));
				}
			}
		}
		if(paramName.equals("genre")) {
			if(params.length >= 4) {
				result = false;
				errors.append(createErrorHtml("ジャンルの選択は3つまでです。"));
			}
		}
		if(paramName.equals("stock")) {
			
		}
		if(paramName.equals("emarks")) {
			
		}
		return result;
	}
	public boolean requiereCheck(List<String> paramNames) {
		boolean result = true;
		for(String paramName : new String[] { "title","writer","publisher","price","genre","stock"}) {
			if(paramNames.indexOf(paramName) == -1) {
				result = false;
				if(paramName == "genre") {
					errors.append(createErrorHtml("ジャンルを選択してください。"));
				}
				break;
			}
		}
		return result;
	}
	public StringBuffer getErrors() {
		return errors;
	}
	public void clearErrors() {
		errors = new StringBuffer();
	}
	private String createErrorHtml(String msg) {
		return String.format("<h2><font color=\"red\">■%s</font></h2>", msg);
	}
}
