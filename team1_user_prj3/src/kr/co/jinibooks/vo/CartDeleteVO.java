package kr.co.jinibooks.vo;

import java.util.Arrays;

public class CartDeleteVO {
	private String id;
	private String[] code;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String[] getCode() {
		return code;
	}
	public void setCode(String[] code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "CartDeleteVO [id=" + id + ", code=" + Arrays.toString(code) + "]";
	}

}
