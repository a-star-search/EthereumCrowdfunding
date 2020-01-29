package es.uc3m.bc.g0;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.utils.Convert;

import es.uc3m.bc.g0.web.model.Causa;

public enum Dapp {
  INSTANCE;
  
  public List<String> accountList = new ArrayList<>();
  private Web3j web3;
  private String crowdfundingContractAddress;

  private TransactionManager transactionManager = null;
  private Crowdfunding crowdfunding = null;
  
  private Dapp() {
    web3 = Web3j.build(new HttpService("http://127.0.0.1:9545"));
    
    EthAccounts accounts;
    try {
      accounts = web3.ethAccounts().send();
    } catch (IOException e1) {
      e1.printStackTrace();
      return;
    }
    //1 ether = 1000000000000000000 wei
    transactionManager = new ClientTransactionManager(web3, accounts.getAccounts().get(0));
    try {
      crowdfunding = Crowdfunding.deploy(web3, transactionManager, Constants.GAS_PRICE, Constants.GAS_LIMIT, 
          new BigInteger("10000000"), 
          new BigInteger("100")).send();
    } catch (Exception e) {
      e.printStackTrace();
    }
    for(String acc : accounts.getAccounts()) {
      accountList.add(acc);
      crowdfunding.addAccount(acc, new BigInteger("100"));
    }
    
    crowdfundingContractAddress = Crowdfunding._addresses.get(Constants.NETWORK);
    
  }
  public String getBalance(String accountAddress) throws IOException {
    EthGetBalance ethGetBalance =
        web3.ethGetBalance(accountAddress, DefaultBlockParameterName.LATEST).send();
    BigInteger wei = ethGetBalance.getBalance();
    BigDecimal tokenValue = Convert.fromWei(String.valueOf(wei), Convert.Unit.ETHER);
    return String.valueOf(tokenValue);
  }
  /** devuelve el total de donaciones hechas a la causa */
  public int realizarDonacion(String idDonacion, String addressDonante, Causa c) {
    //TODO cuando el usuario pueda configurar la cantidad a donar, esto debe venir por parametro
    int amount = 1;
    try {
      crowdfunding.donate(new BigInteger(idDonacion), new BigInteger("1"), addressDonante, new BigInteger("10000000")).send();
    } catch (Exception e) {
      e.printStackTrace();
    }
    Tuple3<String, String, BigInteger> result;
    try {
      result = crowdfunding.causes(new BigInteger(idDonacion)).send();
      return result.getValue3().intValue();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return 0;
  }
  public void nuevaCausa(Causa o) {
    String address = o.getUsuario();
    try {
      TransactionReceipt result = crowdfunding.createCause(o.getCausa(), address).send();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
