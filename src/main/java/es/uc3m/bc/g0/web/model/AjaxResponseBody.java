package es.uc3m.bc.g0.web.model;

import com.fasterxml.jackson.annotation.JsonView;
import es.uc3m.bc.g0.web.view.Views;

public class AjaxResponseBody {

	@JsonView(Views.Public.class)
	String msg;
	@JsonView(Views.Public.class)
	String code;
	@JsonView(Views.Public.class)
	Causa result;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Causa getResult() {
		return result;
	}

	public void setResult(Causa result) {
		this.result = result;
	}

}
