package com.pngencoder;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

class PngEncoderCountingOutputStream extends FilterOutputStream {

    private int count;

    PngEncoderCountingOutputStream(OutputStream out) {
        super(Objects.requireNonNull(out, "out"));
    }

    public int getCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void write(int b) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
