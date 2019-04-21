package org.web3j;

import org.junit.Test;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthTraceTransaction;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

public class TestInternalTransaction {
    @Test
    public void testFindInternalTransaction() throws IOException {
//        Web3j web3j = Web3j.build(new HttpService("https://ropsten.infura.io/8EerjdeY73CYqLZXiNVB "));
        Web3j                    web3j                    = Web3j.build(new HttpService("http://172.19.10.23:8545"));
        String                   txInternal               = "0xcf1da181beeba2d162872464a096dc08be67d912d31a37e977c24e1e3dbb77c3";
        String                   txNormal                 = "0x32c13c27ba510753c2bef7468a33269a13548f3597095a38a68efd1633d917aa";

        EthGetTransactionReceipt receiptInternal = web3j.ethGetTransactionReceipt(txInternal).send();
        EthTraceTransaction traceInternal = web3j.debugTraceTransaction(txInternal).send();
        EthGetTransactionReceipt receiptNormal = web3j.ethGetTransactionReceipt(txNormal).send();
        EthTraceTransaction traceNormal = web3j.debugTraceTransaction(txNormal).send();

        System.out.println(receiptInternal.getTransactionReceipt());
        System.out.println(traceInternal.getTraceTransaction());
        System.out.println(receiptNormal.getTransactionReceipt());
        System.out.println(traceNormal.getTraceTransaction());

    }
}

