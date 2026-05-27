package com.pngencoder;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;

// https://tools.ietf.org/html/rfc1950
// https://stackoverflow.com/questions/9050260/what-does-a-zlib-header-look-like
// https://www.euccas.me/zlib/
// https://stackoverflow.com/questions/13132136/java-multithreaded-compression-with-deflater
class PngEncoderDeflaterOutputStream extends FilterOutputStream {

    // The maximum amount of queued tasks.
    // Multiplied because some segments compress faster than others.
    // A value of 3 seems to keep all threads busy.
    static final int COUNT_MAX_QUEUED_TASKS = PngEncoderDeflaterExecutorService.NUM_THREADS_IS_AVAILABLE_PROCESSORS * 3;

    // Enforces writing to underlying stream in main thread.
    // Multiplied so that not all work is finished before flush to underlying stream.
    static final int COUNT_MAX_TOTAL_SEGMENTS = COUNT_MAX_QUEUED_TASKS * 3;

    // The maximum dictionary size according to the deflate specification.
    // A segment max length lower than this would not allow for future use of dictionary.
    // Used for unit test sanity checking.
    static final int SEGMENT_MAX_LENGTH_DICTIONARY = 32 * 1024;

    // Our minimum segment length.
    // Corresponds to about 2% size overhead.
    // A lower value would better parallelize images but increase the size overhead.
    static final int SEGMENT_MAX_LENGTH_ORIGINAL_MIN = 128 * 1024;

    public static int getSegmentMaxLengthOriginal(int totalOriginalBytesLength) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static int getSegmentMaxLengthDeflated(int segmentMaxLengthOriginal) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private final PngEncoderDeflaterBufferPool pool;

    private final byte[] singleByte;

    private final int compressionLevel;

    private final int segmentMaxLengthOriginal;

    private final ConcurrentLinkedQueue<CompletableFuture<PngEncoderDeflaterSegmentResult>> resultQueue;

    private PngEncoderDeflaterBuffer originalSegment;

    private long adler32;

    private boolean finished;

    private boolean closed;

    PngEncoderDeflaterOutputStream(OutputStream out, int compressionLevel, int segmentMaxLengthOriginal, PngEncoderDeflaterBufferPool pool) throws IOException {
        super(Objects.requireNonNull(out, "out"));
        this.pool = Objects.requireNonNull(pool, "pool");
        this.singleByte = new byte[1];
        this.compressionLevel = compressionLevel;
        this.segmentMaxLengthOriginal = segmentMaxLengthOriginal;
        this.resultQueue = new ConcurrentLinkedQueue<>();
        this.originalSegment = pool.borrow();
        this.adler32 = 1;
        this.finished = false;
        this.closed = false;
        if (pool.getBufferMaxLength() != getSegmentMaxLengthDeflated(segmentMaxLengthOriginal)) {
            throw new IllegalArgumentException("Mismatch between segmentMaxLengthOriginal and pool.");
        }
        writeDeflateHeader(out, compressionLevel);
    }

    PngEncoderDeflaterOutputStream(OutputStream out, int compressionLevel, int segmentMaxLengthOriginal) throws IOException {
        this(out, compressionLevel, segmentMaxLengthOriginal, new PngEncoderDeflaterBufferPool(getSegmentMaxLengthDeflated(segmentMaxLengthOriginal)));
    }

    @Override
    public void write(int b) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void write(byte[] b) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void finish() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void close() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void submitTask(boolean lastSegment) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void submitTask(PngEncoderDeflaterSegmentTask task) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void joinOne() throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void joinUntilMaximumQueueSize(int maximumResultQueueSize) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void writeDeflateHeader(OutputStream outputStream, int compressionLevel) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static byte getFlg(int compressionLevel) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
