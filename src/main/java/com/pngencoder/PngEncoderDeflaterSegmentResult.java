package com.pngencoder;

import java.util.Objects;

class PngEncoderDeflaterSegmentResult {

    private final PngEncoderDeflaterBuffer originalSegment;

    private final PngEncoderDeflaterBuffer deflatedSegment;

    private final long originalSegmentAdler32;

    private final int originalSegmentLength;

    PngEncoderDeflaterSegmentResult(PngEncoderDeflaterBuffer originalSegment, PngEncoderDeflaterBuffer deflatedSegment, long originalSegmentAdler32, int originalSegmentLength) {
        this.originalSegment = Objects.requireNonNull(originalSegment, "originalSegment");
        this.deflatedSegment = Objects.requireNonNull(deflatedSegment, "deflatedSegment");
        this.originalSegmentAdler32 = originalSegmentAdler32;
        this.originalSegmentLength = originalSegmentLength;
    }

    public PngEncoderDeflaterBuffer getOriginalSegment() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public PngEncoderDeflaterBuffer getDeflatedSegment() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    long getUpdatedAdler32(long originalAdler32) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // https://github.com/madler/zlib/blob/master/adler32.c#L143
    static long combine(long adler1, long adler2, long len2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
