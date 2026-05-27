package com.pngencoder;

import com.pngencoder.PngEncoderScanlineUtil.AbstractPNGLineConsumer;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class PngEncoderPredictor {

    private PngEncoderPredictor() {
    }

    static void encodeImageMultiThreaded(BufferedImage image, PngEncoderScanlineUtil.EncodingMetaInfo metaInfo, OutputStream out) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void encodeImageSingleThreaded(BufferedImage image, PngEncoderScanlineUtil.EncodingMetaInfo metaInfo, OutputStream outputStream) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private byte[] dataRawRowSub;

    private byte[] dataRawRowUp;

    private byte[] dataRawRowAverage;

    private byte[] dataRawRowPaeth;

    private void encodeImage(BufferedImage image, int yStart, int height, PngEncoderScanlineUtil.EncodingMetaInfo metaInfo, OutputStream outputStream) throws IOException {
        dataRawRowSub = new byte[metaInfo.rowByteSize];
        dataRawRowUp = new byte[metaInfo.rowByteSize];
        dataRawRowAverage = new byte[metaInfo.rowByteSize];
        dataRawRowPaeth = new byte[metaInfo.rowByteSize];
        dataRawRowSub[0] = 1;
        dataRawRowUp[0] = 2;
        dataRawRowAverage[0] = 3;
        dataRawRowPaeth[0] = 4;
        boolean redoFirstRow = yStart > 0;
        PngEncoderScanlineUtil.stream(image, redoFirstRow ? (yStart - 1) : yStart, height + (redoFirstRow ? 1 : 0), new AbstractPNGLineConsumer() {

            boolean skipFirstRow = redoFirstRow;

            @Override
            void consume(byte[] currRow, byte[] prevRow) throws IOException {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        });
    }
}
