package es.uc3m.bc.g0.web.model;

import com.fasterxml.jackson.annotation.JsonView;

import es.uc3m.bc.g0.web.view.Views;

public class Causa {
  @JsonView(Views.Public.class)
  int id;
  @JsonView(Views.Public.class)
  String causa;
  @JsonView(Views.Public.class)
	String usuario;
	//@JsonView(Views.Public.class)
	//String ...

	public Causa() {
	}
	public Causa(String causa) {
		super();
		this.causa = causa;
	}
  public String getUsuario() {
    return usuario;
  }
  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }
  public String getCausa() {
    return causa;
  }
  public void setCausa(String causa) {
    this.causa = causa;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }

}
