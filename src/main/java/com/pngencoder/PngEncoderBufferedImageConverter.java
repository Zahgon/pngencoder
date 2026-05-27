package com.pngencoder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.DataBufferUShort;
import java.awt.image.DirectColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class PngEncoderBufferedImageConverter {

    private static final int[] BAND_MASKS_INT_ARGB = { 0x00ff0000, 0x0000ff00, 0x000000ff, 0xff000000 };

    private static final ColorModel COLOR_MODEL_INT_ARGB = ColorModel.getRGBdefault();

    private static final int[] BAND_MASKS_INT_RGB = { 0x00ff0000, 0x0000ff00, 0x000000ff };

    private static final ColorModel COLOR_MODEL_INT_RGB = new DirectColorModel(24, 0x00ff0000, 0x0000ff00, 0x000000ff, 0x0);

    private static final int[] BAND_MASKS_INT_ARGB_PRE = { 0x00ff0000, 0x0000ff00, 0x000000ff, 0xff000000 };

    private static final ColorModel COLOR_MODEL_INT_ARGB_PRE = new DirectColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), 32, 0x00ff0000, 0x0000ff00, 0x000000ff, 0xff000000, true, DataBuffer.TYPE_INT);

    private static final int[] BAND_MASKS_INT_BGR = { 0x000000ff, 0x0000ff00, 0x00ff0000 };

    private static final ColorModel COLOR_MODEL_INT_BGR = new DirectColorModel(24, 0x000000ff, 0x0000ff00, 0x00ff0000);

    private static final int[] BAND_MASKS_USHORT_565_RGB = { 0xf800, 0x07E0, 0x001F };

    private static final int[] BAND_MASKS_USHORT_555_RGB = { 0x7C00, 0x03E0, 0x001F };

    private PngEncoderBufferedImageConverter() {
    }

    public static BufferedImage createFromIntArgb(int[] data, int width, int height) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static BufferedImage createFromIntRgb(int[] data, int width, int height) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static BufferedImage createFromIntArgbPre(int[] data, int width, int height) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static BufferedImage createFromIntBgr(int[] data, int width, int height) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static BufferedImage createFrom3ByteBgr(byte[] data, int width, int height) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static BufferedImage createFrom4ByteAbgr(byte[] data, int width, int height) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static BufferedImage createFrom4ByteAbgrPre(byte[] data, int width, int height) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static BufferedImage createFromUshort565Rgb(short[] data, int width, int height) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static BufferedImage createFromUshort555Rgb(short[] data, int width, int height) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static BufferedImage createFromByteGray(byte[] data, int width, int height) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static BufferedImage createFromUshortGray(short[] data, int width, int height) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static BufferedImage createFromByteBinary(byte[] data, int width, int height) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static DataBuffer getDataBuffer(BufferedImage bufferedImage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static DataBufferInt getDataBufferInt(BufferedImage bufferedImage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static DataBufferUShort getDataBufferUShort(BufferedImage bufferedImage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static DataBufferByte getDataBufferByte(BufferedImage bufferedImage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static BufferedImage copyType(BufferedImage bufferedImage, PngEncoderBufferedImageType type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static BufferedImage ensureType(BufferedImage bufferedImage, PngEncoderBufferedImageType type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
