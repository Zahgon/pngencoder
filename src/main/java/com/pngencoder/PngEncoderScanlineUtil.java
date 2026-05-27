package com.pngencoder;

import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.DataBufferUShort;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;
import java.io.IOException;

class PngEncoderScanlineUtil {

    private PngEncoderScanlineUtil() {
    }

    /**
     * Consumer for the image rows as bytes. Every row has the predictor marker as
     * first byte (with 0 for no predictor encoding), after that all image bytes
     * follow.
     * <p>
     * This is a class and not an interface for performance reasons. So that the JVM can
     * fall back to simple vtable call in the polymorphic call site. As you can read on
     * <a href="https://wiki.openjdk.java.net/display/HotSpot/InterfaceCalls">https://wiki.openjdk.java.net/display/HotSpot/InterfaceCalls</a>
     * interface calls are very expensive and not suitable for performance critical sites, which can
     * be polymorphic.
     */
    static abstract class AbstractPNGLineConsumer {

        /**
         * Consume and encode a row bytes consisting of image bytes.
         *
         * @param currRow the current row which should be encoded in the image stream
         * @param prevRow the previous row, which is required for predictor encoding.
         *                Is complete filled with 0 when encoding the first row.
         * @throws IOException if some IO error happens
         */
        abstract void consume(byte[] currRow, byte[] prevRow) throws IOException;
    }

    /**
     * Consumer getting everything as big byte array. Only used to implement get().
     * <p>
     * This thrashes the CPU cache, as with bigger images the whole image data will
     * not fit into the cache and has to be fetched again from main memory when future
     * processing the data.
     */
    static class ByteBufferPNGLineConsumer extends AbstractPNGLineConsumer {

        byte[] bytes;

        int currentOffset;

        ByteBufferPNGLineConsumer(int byteCount) {
            bytes = new byte[byteCount];
        }

        void consume(byte[] currRow, byte[] prevRow) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Metadata about how the image has to be encoded.
     */
    static class EncodingMetaInfo {

        /**
         * Count of color channels. Can either be 1 (for gray), 2 (gray with alpha), 3 (rgb), 4 (rgb with alpha)
         */
        int channels;

        /**
         * Of how many bytes does a pixel have? This is needed for the predictor.
         */
        int bytesPerPixel;

        /**
         * Bits per channel, can be 8 or 16
         */
        int bitsPerChannel = 8;

        /**
         * Size of a row consumed by AbstractPNGLineConsumer::consume() including a
         * 1 byte marker for the predictor.
         */
        int rowByteSize;

        /**
         * Do we have a alpha channel?
         */
        boolean hasAlpha;

        /**
         * If not null we must embed this color profile in the PNG file.
         * It can only be null for sRGB images.
         */
        ICC_Profile colorProfile;

        enum ColorSpaceType {

            Rgb, Gray, Indexed
        }

        /**
         * The kind of color space used in the image
         */
        ColorSpaceType colorSpaceType;
    }

    /*
     * Get the encoding metadata
     */
    static EncodingMetaInfo getEncodingMetaInfo(BufferedImage bufferedImage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static byte[] get(BufferedImage bufferedImage) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Stream image rows to a consumer, row by row.
     */
    static void stream(BufferedImage bufferedImage, int yStart, int heightToStream, AbstractPNGLineConsumer consumer) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Fallback for unsupported types. We use getRGB, which will convert the image.
     */
    private static void getFallback(BufferedImage bufferedImage, int yStart, int width, int heightToStream, AbstractPNGLineConsumer consumer) throws IOException {
        final int[] elements = bufferedImage.getRGB(0, yStart, width, heightToStream, null, 0, width);
        if (bufferedImage.getTransparency() == Transparency.OPAQUE) {
            getIntRgb(elements, yStart, width, heightToStream, consumer);
        } else {
            getIntArgb(elements, yStart, width, heightToStream, consumer);
        }
    }

    static void getIntRgb(int[] elements, int yStart, int width, int height, AbstractPNGLineConsumer consumer) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void getIntArgb(int[] elements, int yStart, int width, int height, AbstractPNGLineConsumer consumer) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void getIntRgb(WritableRaster imageRaster, int yStart, int width, int heightToStream, AbstractPNGLineConsumer consumer) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void getIntArgb(WritableRaster imageRaster, int yStart, int width, int heightToStream, boolean preMultipliedAlpha, AbstractPNGLineConsumer consumer) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void getIntBgr(WritableRaster imageRaster, int yStart, int width, int heightToStream, AbstractPNGLineConsumer consumer) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void get3ByteBgr(WritableRaster imageRaster, int yStart, int width, int heightToStream, AbstractPNGLineConsumer consumer) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void get4ByteAbgr(WritableRaster imageRaster, int yStart, int width, int heightToStream, boolean preMultipliedAlpha, AbstractPNGLineConsumer consumer) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void getByteGray(BufferedImage image, int yStart, int width, int heightToStream, AbstractPNGLineConsumer consumer) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void getUshortGray(BufferedImage image, int yStart, int width, int heightToStream, AbstractPNGLineConsumer consumer) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static boolean getUshortGenericDataBufferUShort(BufferedImage image, int yStart, int width, int heightToStream, AbstractPNGLineConsumer consumer) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static boolean getUshortGeneric(BufferedImage image, int yStart, int width, int heightToStream, AbstractPNGLineConsumer consumer) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static boolean getByteGeneric(BufferedImage image, int yStart, int width, int heightToStream, AbstractPNGLineConsumer consumer) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static boolean getIntGeneric(BufferedImage image, int yStart, int width, int heightToStream, AbstractPNGLineConsumer consumer) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
