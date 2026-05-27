package com.pngencoder;

import java.util.LinkedList;
import java.util.Queue;

class PngEncoderDeflaterBufferPool {

    private final int bufferMaxLength;

    protected final Queue<PngEncoderDeflaterBuffer> buffers;

    PngEncoderDeflaterBufferPool(int bufferMaxLength) {
        this.bufferMaxLength = bufferMaxLength;
        this.buffers = new LinkedList<>();
    }

    public int getBufferMaxLength() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    PngEncoderDeflaterBuffer borrow() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void giveBack(PngEncoderDeflaterBuffer buffer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    int size() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
