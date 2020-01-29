package es.uc3m.bc.g0.web.model;

import com.fasterxml.jackson.annotation.JsonView;
import es.uc3m.bc.g0.web.view.Views;

public class AjaxResponseBodyTotalDonado {
	@JsonView(Views.Public.class)
	String code;
  @JsonView(Views.Public.class)
  String totalDonado;
  @JsonView(Views.Public.class)
  String idDonacion;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

  public String getTotalDonado() {
    return totalDonado;
  }

  public void setTotalDonado(String totalDonado) {
    this.totalDonado = totalDonado;
  }

  public String getIdDonacion() {
    return idDonacion;
  }

  public void setIdDonacion(String idDonacion) {
    this.idDonacion = idDonacion;
  }

}
