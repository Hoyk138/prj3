package kr.co.jinibooks.vo;

public class LoginVO {
	
	private String inputID, inputPW;

	public String getInputID() {
		return inputID;
	}

	public void setInputID(String inputID) {
		this.inputID = inputID;
	}

	public String getInputPW() {
		return inputPW;
	}

	public void setInputPW(String inputPW) {
		this.inputPW = inputPW;
	}

	@Override
	public String toString() {
		return "LoginVO [inputID=" + inputID + ", inputPW=" + inputPW + "]";
	}
	
}
