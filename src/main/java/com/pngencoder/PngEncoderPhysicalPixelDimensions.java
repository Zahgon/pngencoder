package com.pngencoder;

/**
 * Represents PNG physical pixel dimensions
 *
 * Use one of the static methods to create physical pixel dimensions based
 * on pixels per meter, dots per inch or a unit-less aspect ratio.
 *
 * @see <a href="https://www.w3.org/TR/PNG/#11pHYs">https://www.w3.org/TR/PNG/#11pHYs</a>
 */
public class PngEncoderPhysicalPixelDimensions {

    public enum Unit {

        UNKNOWN((byte) 0), METER((byte) 1);

        private final byte value;

        Unit(byte value) {
            this.value = value;
        }

        public byte getValue() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final float INCHES_PER_METER = 100 / 2.54f;

    private final int pixelsPerUnitX;

    private final int pixelsPerUnitY;

    private final Unit unit;

    private PngEncoderPhysicalPixelDimensions(int pixelsPerUnitX, int pixelsPerUnitY, Unit unit) {
        this.pixelsPerUnitX = pixelsPerUnitX;
        this.pixelsPerUnitY = pixelsPerUnitY;
        this.unit = unit;
    }

    /**
     * Creates a PngEncoderPhysicalPixelDimensions with possibly non-square pixels
     * with a size specified in pixels per meter
     *
     * @param pixelsPerMeterX the pixels per meter value for the horizontal dimension
     * @param pixelsPerMeterY the pixels per meter value for the vertical dimension
     */
    public static PngEncoderPhysicalPixelDimensions pixelsPerMeter(int pixelsPerMeterX, int pixelsPerMeterY) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a PngEncoderPhysicalPixelDimensions with square pixels
     * with a size specified in pixels per meter
     *
     * @param pixelsPerMeter the pixels per meter value for both dimensions
     */
    public static PngEncoderPhysicalPixelDimensions pixelsPerMeter(int pixelsPerMeter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a PngEncoderPhysicalPixelDimensions with possibly non-square pixels
     * with a size specified in dots per inch
     *
     * Note that dots per inch (DPI) cannot be exactly represented by the PNG format's
     * integer value for pixels per meter. There will be a slight rounding error.
     *
     * @param dotsPerInchX the DPI value for the horizontal dimension
     * @param dotsPerInchY the DPI value for the vertical dimension
     */
    public static PngEncoderPhysicalPixelDimensions dotsPerInch(int dotsPerInchX, int dotsPerInchY) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a PngEncoderPhysicalPixelDimensions with square pixels
     * with a size specified in dots per inch
     *
     * Note that dots per inch (DPI) cannot be exactly represented by the PNG format's
     * integer value for pixels per meter. There will be a slight rounding error.
     *
     * @param dotsPerInch the DPI value for both dimensions
     */
    public static PngEncoderPhysicalPixelDimensions dotsPerInch(int dotsPerInch) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates a PngEncoderPhysicalPixelDimensions that only specifies the aspect ratio,
     * but not the size, of the pixels
     *
     * @param pixelsPerUnitX the number of pixels per unit in the horizontal dimension
     * @param pixelsPerUnitY the number of pixels per unit in the vertical dimension
     */
    public static PngEncoderPhysicalPixelDimensions aspectRatio(int pixelsPerUnitX, int pixelsPerUnitY) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the number of pixels per unit in the horizontal dimension
     */
    public int getPixelsPerUnitX() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the number of pixels per unit in the vertical dimension
     */
    public int getPixelsPerUnitY() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the unit of the pixel size (either {@link Unit#METER} or {@link Unit#UNKNOWN})
     */
    public Unit getUnit() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
