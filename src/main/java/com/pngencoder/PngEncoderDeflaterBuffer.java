package com.pngencoder;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.zip.Adler32;

class PngEncoderDeflaterBuffer {

    final PngEncoderDeflaterBufferPool pool;

    final byte[] bytes;

    int length;

    PngEncoderDeflaterBuffer(PngEncoderDeflaterBufferPool pool, int maxLength) {
        this.pool = Objects.requireNonNull(pool, "pool");
        this.bytes = new byte[maxLength];
        this.length = 0;
    }

    void giveBack() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    long calculateAdler32() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void write(OutputStream outputStream) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
