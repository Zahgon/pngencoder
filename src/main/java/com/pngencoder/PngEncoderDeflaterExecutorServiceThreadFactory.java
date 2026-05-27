package com.pngencoder;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

class PngEncoderDeflaterExecutorServiceThreadFactory implements ThreadFactory {

    private static class Holder {

        private static final PngEncoderDeflaterExecutorServiceThreadFactory INSTANCE = new PngEncoderDeflaterExecutorServiceThreadFactory();
    }

    static PngEncoderDeflaterExecutorServiceThreadFactory getInstance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final ThreadFactory defaultThreadFactory;

    private final AtomicLong counter;

    PngEncoderDeflaterExecutorServiceThreadFactory() {
        this.defaultThreadFactory = Executors.defaultThreadFactory();
        this.counter = new AtomicLong(0);
    }

    @Override
    public Thread newThread(Runnable runnable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
