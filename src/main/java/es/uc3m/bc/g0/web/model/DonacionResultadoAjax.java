package es.uc3m.bc.g0.web.model;

public class DonacionResultadoAjax {
  String idDonacion;
  //address del donante
	String donante;
	
  public String getDonante() {
    return donante;
  }
  public void setDonante(String donante) {
    this.donante = donante;
  }
  public String getIdDonacion() {
    return idDonacion;
  }
  public void setIdDonacion(String idDonacion) {
    this.idDonacion = idDonacion;
  }
}
