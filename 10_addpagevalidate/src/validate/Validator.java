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
		System.out.println(String.format("paramName:%s,stringLength:%d", paramName,params[0].length()));
		boolean result = true;
		if(paramName.equals("title")) {
			if(params[0].length() == 0) {
				errors.append(createErrorHtml("タイトルは必須⼊⼒です。"));
				result = false;
			}
		}
		if(paramName.equals("writer")) {
			if(params[0].length() > 10) {
				errors.append(createErrorHtml("著者は10文字以内です。"));
				result = false;
			}
		}
		if(paramName.equals("publisher")) {

		}
		if(paramName.equals("price")) {
			try {
				int price = Integer.parseInt(params[0]);
				if(price < 0) {
					errors.append(createErrorHtml("価格は0以上です。"));
					result = false;
				}
			}catch(NumberFormatException e) {
				errors.append(createErrorHtml("価格は数値⼊⼒です。"));
				result = false;
			}
		}
		if(paramName.equals("genre")) {
			if(params.length >= 4) {
				errors.append(createErrorHtml("ジャンルの選択は3つまでです。"));
				result = false;
			}
			System.out.println(params.length);
		}
		if(paramName.equals("stock")) {
			
		}
		if(paramName.equals("emarks")) {
			
		}
		System.out.println(result);
		return result;
	}
	public boolean requiereCheck(List<String> paramNames) {
		boolean result = true;
		for(String paramName : new String[] { "title","writer","publisher","price","genre","stock"}) {
			if(paramNames.indexOf(paramName) == -1) {
				result = false;
				if(paramName.equals( "genre")) {
					errors.append(createErrorHtml("ジャンルを選択してください。"));
				}
				System.out.println(String.format("paramName:%s,result:%s", paramName,result));
				break;
			}
		}
		return result;
	}
	public StringBuffer getErrors() {
		return errors;
	}
	private String createErrorHtml(String msg) {
		return String.format("<h2><font color=\"red\">■%s</font></h2>", msg);
	}
}
