package org.web3j.protocol.core;

import io.reactivex.Flowable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.protocol.Web3jService;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;


public class Request<S, T extends Response> {
    private static AtomicLong nextId         = new AtomicLong(0);
    private        String     jsonrpc        = "2.0";
    private        String     method;
    private        List<S>    params;
    private        long       id;
    public static Integer     retryTimes     = 300;
    public static Integer     retrySleepTime = 1000;

    private static Logger       logger = LoggerFactory.getLogger(Request.class);
    private        Web3jService web3jService;

    // Unfortunately require an instance of the type too, see
    // http://stackoverflow.com/a/3437930/3211687
    private Class<T> responseType;

    public Request() {
    }

    public Request(String method, List<S> params,
                   Web3jService web3jService, Class<T> type) {
        this.method = method;
        this.params = params;
        this.id = nextId.getAndIncrement();
        this.web3jService = web3jService;
        this.responseType = type;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<S> getParams() {
        return params;
    }

    public void setParams(List<S> params) {
        this.params = params;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    synchronized public T send() throws IOException {
        int        retry        = 1;
        String     errorMessage = "";
        while (retry <= retryTimes) {
            try {
                return web3jService.send(this, responseType);
            } catch (Throwable e) {
                //throw new CallApiCryptoCurrencyRpcException(e.getMessage());
                logger.info("error happened when " + retry + " times call api: " + getMethod() + " will retry after " + retrySleepTime + " milliseconds, error:" + e);
                errorMessage = e.getMessage();
                retry++;
                try {
                    Thread.sleep(retrySleepTime);
                } catch (InterruptedException e1) {
                    logger.info("error happened when sleep in Request.send. program will continue running. error:" + e1);
                }
                continue;
            }
        }
        return null;
    }

    public CompletableFuture<T> sendAsync() {
        return web3jService.sendAsync(this, responseType);
    }

    public Flowable<T> flowable() {
        return new RemoteCall<>(this::send).flowable();
    }
}