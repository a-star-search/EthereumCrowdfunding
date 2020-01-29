package es.uc3m.bc.g0;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.3.0.
 */
public class Crowdfunding extends Contract {
    private static final String BINARY = "0x608060405260405160208061060d8339810180604052602081101561002357600080fd5b5051336000908152602081905260409020556105c9806100446000396000f3fe608060405260043610610066577c01000000000000000000000000000000000000000000000000000000006000350463234fa7ec811461006b57806327e235e31461012b578063538a942a14610170578063b0862bd214610232578063c1ce56eb14610264575b600080fd5b34801561007757600080fd5b506101296004803603604081101561008e57600080fd5b8101906020810181356401000000008111156100a957600080fd5b8201836020820111156100bb57600080fd5b803590602001918460018302840111640100000000831117156100dd57600080fd5b91908080601f01602080910402602001604051908101604052809392919081815260200183838082843760009201919091525092955050509035600160a060020a0316915061029d9050565b005b34801561013757600080fd5b5061015e6004803603602081101561014e57600080fd5b5035600160a060020a0316610353565b60408051918252519081900360200190f35b34801561017c57600080fd5b5061019a6004803603602081101561019357600080fd5b5035610365565b604051808060200184600160a060020a0316600160a060020a03168152602001838152602001828103825285818151815260200191508051906020019080838360005b838110156101f55781810151838201526020016101dd565b50505050905090810190601f1680156102225780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b6101296004803603606081101561024857600080fd5b5080359060208101359060400135600160a060020a031661042c565b34801561027057600080fd5b506101296004803603604081101561028757600080fd5b50600160a060020a0381351690602001356104e6565b60408051606081018252838152600160a060020a038316602080830191909152600092820183905260018054808201808355919094528251805191946003027fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf6019261030e92849290910190610502565b50602082015160018201805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03909216919091179055604090910151600290910155505050565b60006020819052908152604090205481565b600180548290811061037357fe5b60009182526020918290206003919091020180546040805160026001841615610100026000190190931692909204601f81018590048502830185019091528082529193509183919083018282801561040c5780601f106103e15761010080835404028352916020019161040c565b820191906000526020600020905b8154815290600101906020018083116103ef57829003601f168201915b5050505060018301546002909301549192600160a060020a031691905083565b600160a060020a03811660009081526020819052604090205482111561045157600080fd5b600160a060020a0381166000908152602081905260408120805484900390556001805484929182918790811061048357fe5b600091825260208083206001600390930201820154600160a060020a031684528301939093526040909101902080549092019091558054839190859081106104c757fe5b6000918252602090912060026003909202010180549091019055505050565b600160a060020a03909116600090815260208190526040902055565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061054357805160ff1916838001178555610570565b82800160010185558215610570579182015b82811115610570578251825591602001919060010190610555565b5061057c929150610580565b5090565b61059a91905b8082111561057c5760008155600101610586565b9056fea165627a7a723058207b3a0a311adf971f56addffdd7310c540f4203ca4de03c944cedbde2548cfa4d0029";

    public static final String FUNC_BALANCES = "balances";

    public static final String FUNC_CAUSES = "causes";

    public static final String FUNC_CREATECAUSE = "createCause";

    public static final String FUNC_ADDACCOUNT = "addAccount";

    public static final String FUNC_DONATE = "donate";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("5777", "0xa60A7ae9931E59Acf9A54208919280F21Ea01C7E");
    }

    @Deprecated
    protected Crowdfunding(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Crowdfunding(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Crowdfunding(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Crowdfunding(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<BigInteger> balances(String param0) {
        final Function function = new Function(FUNC_BALANCES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple3<String, String, BigInteger>> causes(BigInteger param0) {
        final Function function = new Function(FUNC_CAUSES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple3<String, String, BigInteger>>(
                new Callable<Tuple3<String, String, BigInteger>>() {
                    @Override
                    public Tuple3<String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> createCause(String causeName, String causeAccount) {
        final Function function = new Function(
                FUNC_CREATECAUSE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(causeName), 
                new org.web3j.abi.datatypes.Address(causeAccount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addAccount(String cuenta, BigInteger initialSupply) {
        final Function function = new Function(
                FUNC_ADDACCOUNT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(cuenta), 
                new org.web3j.abi.datatypes.generated.Uint256(initialSupply)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> donate(BigInteger cause, BigInteger amount, String donor, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_DONATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(cause), 
                new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.Address(donor)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    @Deprecated
    public static Crowdfunding load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Crowdfunding(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Crowdfunding load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Crowdfunding(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Crowdfunding load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Crowdfunding(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Crowdfunding load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Crowdfunding(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Crowdfunding> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger initialWeiValue, BigInteger initialSupply) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(initialSupply)));
        return deployRemoteCall(Crowdfunding.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor, initialWeiValue);
    }

    public static RemoteCall<Crowdfunding> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger initialWeiValue, BigInteger initialSupply) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(initialSupply)));
        return deployRemoteCall(Crowdfunding.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor, initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<Crowdfunding> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, BigInteger initialSupply) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(initialSupply)));
        return deployRemoteCall(Crowdfunding.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    @Deprecated
    public static RemoteCall<Crowdfunding> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, BigInteger initialSupply) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(initialSupply)));
        return deployRemoteCall(Crowdfunding.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
