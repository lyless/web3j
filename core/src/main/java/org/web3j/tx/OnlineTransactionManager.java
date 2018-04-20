package org.web3j.tx;

import jdk.jfr.events.ExceptionThrownEvent;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.tx.response.TransactionReceiptProcessor;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

/**
 * TransactionManager implementation using Ethereum wallet file to create and sign transactions
 * locally.
 *
 * <p>This transaction manager provides support for specifying the chain id for transactions as per
 * <a href="https://github.com/ethereum/EIPs/issues/155">EIP155</a>.
 */
public class OnlineTransactionManager extends TransactionManager {

    private final Web3j web3j;

    public OnlineTransactionManager(Web3j web3j) {
        super(web3j, null);

        this.web3j = web3j;

    }

    public OnlineTransactionManager(
            Web3j web3j,
            TransactionReceiptProcessor transactionReceiptProcessor) {
        super(transactionReceiptProcessor, null);

        this.web3j = web3j;

    }

    public OnlineTransactionManager(
            Web3j web3j, int attempts, long sleepDuration) {
        super(web3j, attempts, sleepDuration, null);

        this.web3j = web3j;

    }

    @Override
    @Deprecated
    public EthSendTransaction sendTransaction(
            BigInteger gasPrice, BigInteger gasLimit, String to,
            String data, BigInteger value) throws IOException {

        throw new UnsupportedOperationException("not supported.");
    }

    @Override
    public String make(BigInteger gasPrice, BigInteger gasLimit, String to, String data,
                       BigInteger value) throws IOException {
        throw new UnsupportedEncodingException("not supported.");
    }

    @Override
    public EthSendTransaction sendTransaction(String txHex) throws IOException {
        return web3j.ethSendRawTransaction(txHex).send();
    }
}
