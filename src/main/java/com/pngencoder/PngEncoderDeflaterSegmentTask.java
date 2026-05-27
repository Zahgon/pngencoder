package com.pngencoder;

import java.util.Objects;
import java.util.function.Supplier;
import java.util.zip.Deflater;

class PngEncoderDeflaterSegmentTask implements Supplier<PngEncoderDeflaterSegmentResult> {

    private final PngEncoderDeflaterBuffer originalSegment;

    private final PngEncoderDeflaterBuffer deflatedSegment;

    private final int compressionLevel;

    private final boolean lastSegment;

    public PngEncoderDeflaterSegmentTask(PngEncoderDeflaterBuffer originalSegment, PngEncoderDeflaterBuffer deflatedSegment, int compressionLevel, boolean lastSegment) {
        this.originalSegment = Objects.requireNonNull(originalSegment, "originalSegment");
        this.deflatedSegment = Objects.requireNonNull(deflatedSegment, "deflatedSegment");
        this.compressionLevel = compressionLevel;
        this.lastSegment = lastSegment;
    }

    @Override
    public PngEncoderDeflaterSegmentResult get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void deflate(PngEncoderDeflaterBuffer originalSegment, PngEncoderDeflaterBuffer deflatedSegment, int compressionLevel, boolean lastSegment) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
