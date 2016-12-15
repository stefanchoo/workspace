package com.africa.guava.study;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuhusheng
 * @date 2016/6/3
 */
public class GuavaListenerFuture {
    public static void main(String[] args) {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
        final ListenableFuture<Integer> listenableFuture = executorService.submit(() -> {
                System.out.println("call execute..");
                TimeUnit.SECONDS.sleep(1);
                return 7;
        });
        Futures.addCallback(listenableFuture, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(Integer result) {
                System.out.println("get listenable future's result with callback " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
