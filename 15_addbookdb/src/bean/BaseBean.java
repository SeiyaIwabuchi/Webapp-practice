package bean;

/**
 * Bean���N���X
 * 
 * @author t.kawana
 *
 */
public class BaseBean {

	// �G���[���b�Z�[�W
	String errorMsg;
	
	//���،���
	private boolean ValidateResult;

	/**
	 * �G���[���b�Z�[�W�擾
	 * 
	 * @return �G���[���b�Z�[�W
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * �G���[���b�Z�[�W�ݒ�
	 * 
	 * @param errorMsg�@�G���[���b�Z�[�W
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
