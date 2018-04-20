package org.web3j.protocol.core;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

import rx.Observable;

import org.web3j.utils.Async;

/**
 * A common type for wrapping remote requests.
 *
 * @param <T> Our return type.
 */
public class RemoteCall<T> {

    private Callable<T>      callable;
    private Callable<String> offline;

    public RemoteCall(Callable<T> callable, Callable<String> offline) {
        this.callable = callable;
        this.offline = offline;
    }
    public RemoteCall(Callable<T> callable) {
        this.callable = callable;
        this.offline = () -> {
            throw new UnsupportedOperationException("not supported.");};
    }

    /**
     * Perform request synchronously.
     *
     * @return result of enclosed function
     * @throws Exception if the function throws an exception
     */
    public T send() throws Exception {
        return callable.call();
    }

    /**
     * Perform request asynchronously with a future.
     *
     * @return a future containing our function
     */
    public CompletableFuture<T> sendAsync() {
        return Async.run(this::send);
    }

    /**
     * Perform meke raw transaction binary
     *
     * @return result of enclosed function
     * @throws Exception if the function throws an exception
     */
    public String make() throws Exception {
        return offline.call();
    }

    /**
     * Provide an observable to emit result from our function.
     *
     * @return an observable
     */
    public Observable<T> observable() {
        return Observable.create(
                subscriber -> {
                    try {
                        subscriber.onNext(send());
                        subscriber.onCompleted();
                    } catch (Exception e) {
                        subscriber.onError(e);
                    }
                }
        );
    }
}
