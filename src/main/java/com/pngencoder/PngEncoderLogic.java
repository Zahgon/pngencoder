package com.pngencoder;

import com.pngencoder.PngEncoderIndexed.IndexedEncoderResult;
import com.pngencoder.PngEncoderScanlineUtil.AbstractPNGLineConsumer;
import java.awt.color.ICC_Profile;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

class PngEncoderLogic {

    // In hex: 89 50 4E 47 0D 0A 1A 0A
    // This is the "file beginning" aka "header" aka "signature" aka "magicnumber".
    // https://en.wikipedia.org/wiki/Portable_Network_Graphics#File_header
    // http://www.libpng.org/pub/png/book/chapter08.html#png.ch08.div.2
    // All PNGs start this way and it does not include any pixel format info.
    static final byte[] FILE_BEGINNING = { -119, 80, 78, 71, 13, 10, 26, 10 };

    // In hex: 00 00 00 00 49 45 4E 44 AE 42 60 82
    // This is the "file ending"
    static final byte[] FILE_ENDING = { 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126 };

    static final byte IHDR_COLOR_TYPE_GREY = 0;

    static final byte IHDR_COLOR_TYPE_RGB = 2;

    static final byte IHDR_COLOR_TYPE_INDEXED = 3;

    static final byte IHDR_COLOR_TYPE_GREY_ALPHA = 4;

    static final byte IHDR_COLOR_TYPE_RGBA = 6;

    static final byte IHDR_COMPRESSION_METHOD = 0;

    static final byte IHDR_FILTER_METHOD = 0;

    static final byte IHDR_INTERLACE_METHOD = 0;

    // Default values for the gAMA and cHRM chunks when an sRGB chunk is used,
    // as specified at http://www.libpng.org/pub/png/spec/1.2/PNG-Chunks.html#C.sRGB
    //   "An application that writes the sRGB chunk should also write a gAMA chunk (and perhaps a cHRM chunk)
    //    for compatibility with applications that do not use the sRGB chunk.
    //    In this situation, only the following values may be used:
    //    ..."
    public static final byte[] GAMA_SRGB_VALUE = ByteBuffer.allocate(4).putInt(45455).array();

    public static final byte[] CHRM_SRGB_VALUE = ByteBuffer.allocate(8 * 4).putInt(31270).putInt(32900).putInt(64000).putInt(33000).putInt(30000).putInt(60000).putInt(15000).putInt(6000).array();

    private PngEncoderLogic() {
    }

    @FunctionalInterface
    private interface IDoWithDeflaterStream {

        void encodeImageData(boolean isMultithreaded, OutputStream out) throws IOException;
    }

    private static void encodeWithCompressorStream(boolean multiThreadedCompressionEnabled, int compressionLevel, BufferedImage bufferedImage, PngEncoderScanlineUtil.EncodingMetaInfo metaInfo, OutputStream outputStream, IDoWithDeflaterStream action) throws IOException {
        int estimatedBytes = metaInfo.rowByteSize * bufferedImage.getHeight();
        final int segmentMaxLengthOriginal = PngEncoderDeflaterOutputStream.getSegmentMaxLengthOriginal(estimatedBytes);
        if (estimatedBytes <= segmentMaxLengthOriginal || !multiThreadedCompressionEnabled) {
            Deflater deflater = new Deflater(compressionLevel);
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(outputStream, deflater);
            action.encodeImageData(false, deflaterOutputStream);
            deflaterOutputStream.finish();
            deflaterOutputStream.flush();
            deflater.end();
        } else {
            PngEncoderDeflaterOutputStream deflaterOutputStream = new PngEncoderDeflaterOutputStream(outputStream, compressionLevel, segmentMaxLengthOriginal);
            action.encodeImageData(true, deflaterOutputStream);
            deflaterOutputStream.finish();
        }
    }

    static int encode(BufferedImage bufferedImage, OutputStream outputStream, int compressionLevel, boolean multiThreadedCompressionEnabled, PngEncoderSrgbRenderingIntent srgbRenderingIntent, PngEncoderPhysicalPixelDimensions physicalPixelDimensions, boolean usePredictor, boolean tryIndexedEncoding) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static byte[] getICCP(ICC_Profile colorProfile) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // Write the profile name
        String name = getProfileName(colorProfile);
        byte[] nameBytes = name.getBytes(StandardCharsets.ISO_8859_1);
        int nameByteWriteLen = Math.min(nameBytes.length, 79);
        out.write(nameBytes, 0, nameByteWriteLen);
        out.write(0);
        // ZLib Compression
        out.write(IHDR_COMPRESSION_METHOD);
        // ICC Profile Data
        try (DeflaterOutputStream compressStream = new DeflaterOutputStream(out)) {
            compressStream.write(colorProfile.getData());
        }
        return out.toByteArray();
    }

    private static String getProfileName(ICC_Profile profile) {
        byte[] data = profile.getData(ICC_Profile.icSigProfileDescriptionTag);
        if (data == null) {
            return "<noname>";
        }
        int startIdx = 12;
        int endIdx = startIdx;
        while (endIdx < data.length) {
            int c = data[endIdx];
            if (c == 0) {
                break;
            }
            endIdx++;
        }
        if (endIdx != startIdx) {
            return new String(data, startIdx, endIdx - startIdx, StandardCharsets.US_ASCII);
        }
        /*
         * Unicode Format ... this is special to parse...
         */
        endIdx = startIdx = 29;
        while (endIdx + 1 < data.length) {
            int c = (data[endIdx] & 0xff) + (data[endIdx] & 0xFF);
            if (c == 0) {
                break;
            }
            endIdx += 2;
        }
        if (endIdx != startIdx) {
            return new String(data, startIdx, endIdx - startIdx, StandardCharsets.UTF_16LE);
        }
        return "<unnamed>";
    }

    static byte[] getIhdrHeader(int width, int height, PngEncoderScanlineUtil.EncodingMetaInfo metaInfo) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static byte[] getPhysicalPixelDimensions(PngEncoderPhysicalPixelDimensions physicalPixelDimensions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static byte[] asChunk(String type, byte[] data) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static int getCrc32(ByteBuffer byteBuffer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
