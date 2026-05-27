package com.pngencoder;

import com.pngencoder.PngEncoderScanlineUtil.AbstractPNGLineConsumer;
import com.pngencoder.PngEncoderScanlineUtil.EncodingMetaInfo;
import com.pngencoder.PngEncoderScanlineUtil.EncodingMetaInfo.ColorSpaceType;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.IndexColorModel;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.Raster;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PngEncoderIndexed {

    static class IndexedEncoderResult {

        byte[] colorTable;

        byte[] transparencyTable;

        byte[] rawIDAT;
    }

    /**
     * Encode the image as indexed image. This can fail if the image has more than 256 colors. But we only know this if
     * we try to encode it. In case this image has more than 256 colors null is returned and everything written
     * into out has to disposed.
     *
     * @param image    the Image to encode
     * @param metaInfo the metaInfos of the image
     * @return null if this image can not be encoded as indexed image or the additional chunk data needed for the indexed image.
     * @throws IOException propagated IO Exception. Should not occur.
     */
    static IndexedEncoderResult encodeImage(BufferedImage image, EncodingMetaInfo metaInfo) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static IndexedEncoderResult makeIndexedEncoderResult(EncodingMetaInfo metaInfo, ByteArrayOutputStream out, int rowByteSize, ColorTable table) {
        IndexedEncoderResult result = new IndexedEncoderResult();
        result.rawIDAT = out.toByteArray();
        result.colorTable = table.makeColorTable();
        if (metaInfo.hasAlpha) {
            result.transparencyTable = table.makeTransparencyTable();
        }
        metaInfo.colorSpaceType = ColorSpaceType.Indexed;
        metaInfo.rowByteSize = rowByteSize;
        return result;
    }

    private static class ColorTable {

        int[] colorTable = new int[256];

        int usedColors = 0;

        int lastColor;

        int lastColorIndex = 0;

        byte findColor(int color) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private int findColorLookup(int color) {
            for (int i = 0; i < usedColors; i++) {
                if (colorTable[i] == color) {
                    lastColor = color;
                    lastColorIndex = i;
                    return i;
                }
            }
            int colorIndex = usedColors++;
            colorTable[colorIndex] = color;
            lastColor = color;
            lastColorIndex = colorIndex;
            return colorIndex;
        }

        public byte[] makeColorTable() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public byte[] makeTransparencyTable() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void copyFromIndexedColorModel(IndexColorModel colorModel) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /*
     * We convert an already indexed image directly into an indexed png.
     */
    static IndexedEncoderResult encodeImageFromIndexed(BufferedImage image, EncodingMetaInfo metaInfo) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
