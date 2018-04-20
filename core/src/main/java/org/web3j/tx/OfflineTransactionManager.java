package org.web3j.tx;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.tx.response.TransactionReceiptProcessor;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigInteger;

/**
 * TransactionManager implementation using Ethereum wallet file to create and sign transactions
 * locally.
 *
 * <p>This transaction manager provides support for specifying the chain id for transactions as per
 * <a href="https://github.com/ethereum/EIPs/issues/155">EIP155</a>.
 */
public class OfflineTransactionManager extends TransactionManager {

    private final byte chainId;

    public OfflineTransactionManager(byte chainId) {
        super(null, 0, 0, null);
        this.chainId = chainId;
    }

    public OfflineTransactionManager() {
        super(null, 0, 0, null);
        this.chainId = ChainId.NONE;
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
        // TODO implement
        return null;
    }

    @Override
    @Deprecated
    public EthSendTransaction sendTransaction(String txHex) throws IOException {
        throw new UnsupportedOperationException("not supported.");
    }

    public String signTx(RawTransaction rawTransaction, Credentials credentials)
            throws IOException {

        byte[] signedMessage;

        if (chainId > ChainId.NONE) {
            signedMessage = TransactionEncoder.signMessage(rawTransaction, chainId, credentials);
        } else {
            signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
        }

        String hexValue = Numeric.toHexString(signedMessage);

        return hexValue;
    }
}
