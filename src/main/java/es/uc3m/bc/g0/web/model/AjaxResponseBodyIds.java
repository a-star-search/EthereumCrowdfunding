package es.uc3m.bc.g0.web.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import es.uc3m.bc.g0.web.view.Views;

public class AjaxResponseBodyIds {

	@JsonView(Views.Public.class)
	String msg;
	@JsonView(Views.Public.class)
	String code;
	@JsonView(Views.Public.class)
	List<String> ids;

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

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

}
