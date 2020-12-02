package bean;

/**
 * Bean基底クラス
 * 
 * @author t.kawana
 *
 */
public class BaseBean {

	// エラーメッセージ
	String errorMsg;
	
	//検証結果
	private boolean ValidateResult;

	/**
	 * エラーメッセージ取得
	 * 
	 * @return エラーメッセージ
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * エラーメッセージ設定
	 * 
	 * @param errorMsg　エラーメッセージ
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public boolean isValidateResult() {
		return ValidateResult;
	}

	public void setValidateResult(boolean validateResult) {
		ValidateResult = validateResult;
	}

	
}
