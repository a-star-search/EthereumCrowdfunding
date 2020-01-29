package es.uc3m.bc.g0.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import es.uc3m.bc.g0.Dapp;
import es.uc3m.bc.g0.web.model.AjaxResponseBody;
import es.uc3m.bc.g0.web.model.AjaxResponseBodyIds;
import es.uc3m.bc.g0.web.model.AjaxResponseBodyTotalDonado;
import es.uc3m.bc.g0.web.model.Causa;
import es.uc3m.bc.g0.web.model.CausaResultadoAjax;
import es.uc3m.bc.g0.web.model.DonacionResultadoAjax;
import es.uc3m.bc.g0.web.view.Views;

@RestController
public class AjaxController {
  int contadorCausa = 0;
  Map<String, Causa> donaciones = new HashMap<>();

  @JsonView(String.class)
  @RequestMapping(value = "/crowdfunding/api/obtenerFondos")
  public String obtenerFondos(@RequestBody String account) {
    String acc = account.replace("\"", "");
    try {
      String bal = Dapp.INSTANCE.getBalance(acc);
      return bal;
    } catch (IOException e) {
      e.printStackTrace();
      return "-1";
    }
  }
  
  @JsonView(Views.Public.class)
  @RequestMapping(value = "/crowdfunding/api/listaIds")
  public AjaxResponseBodyIds getListaIds() {
    List<String> ids = Dapp.INSTANCE.accountList;
    AjaxResponseBodyIds result = new AjaxResponseBodyIds();
    result.setCode("200");
    result.setMsg("");
    result.setIds(ids);
    return result;
  }
  
  @JsonView(Views.Public.class)
  @RequestMapping(value = "/crowdfunding/api/publicarCausa")
  public AjaxResponseBody publicarCausaViaAjax(@RequestBody CausaResultadoAjax causa) {
    AjaxResponseBody result = new AjaxResponseBody();
    if (isValid(causa)) {
      result.setCode("200");
      result.setMsg("");

      Causa o = new Causa();
      o.setId(contadorCausa);
      this.contadorCausa++;
      o.setCausa(causa.getCausa());
      o.setUsuario(causa.getUsuario());
      donaciones.put(contadorCausa + "", o);
      Dapp.INSTANCE.nuevaCausa(o);
      result.setResult(o);
      return result;
    }
    result.setCode("400");
    result.setMsg("Empty");
    return result;

  }

  @JsonView(Views.Public.class)
  @RequestMapping(value = "/crowdfunding/api/donar")
  public AjaxResponseBodyTotalDonado donarViaAjax(@RequestBody DonacionResultadoAjax donacion) {
    String addressDonante = donacion.getDonante();
    Causa causa = donaciones.get(donacion.getIdDonacion());
    int total = Dapp.INSTANCE.realizarDonacion(donacion.getIdDonacion(), addressDonante, causa);
    AjaxResponseBodyTotalDonado response = new AjaxResponseBodyTotalDonado();
    response.setCode("200");
    response.setIdDonacion(donacion.getIdDonacion());
    response.setTotalDonado("" + total);
    return response;
  }

  private boolean isValid(CausaResultadoAjax causa) {
    if (causa == null)
      return false;
    if (causa.getCausa().isEmpty())
      return false;
    return true;
  }
}
