package org.web3j;

import org.junit.Test;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthTraceTransaction;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

public class TestInternalTransaction {
    @Test
    public void testFindInternalTransaction() throws IOException {
//        Web3j web3j = Web3j.build(new HttpService("https://ropsten.infura.io/8EerjdeY73CYqLZXiNVB "));
        Web3j               web3j = Web3j.build(new HttpService("http://localhost:8545"));
        EthTraceTransaction ethTraceTransaction = web3j.debugTraceTransaction("0x97674a850b2eb62e04f4f164e583b6fcc2481c8529e9b95a725fce6a457b9493").send();
        System.out.println(ethTraceTransaction);
    }
}

