package uk.co.bithatch.macrolib;


/**
 * The Class RGB.
 */
public class RGB {

	/**
	 * Rgb to string.
	 *
	 * @param col the col
	 * @return the string
	 */
	public static String rgbToString(int[] col) {
		return col == null ? null : String.format("%d,%d,%d", col[0], col[1], col[2]);
	}

	/**
	 * To RGB.
	 *
	 * @param rgbString the rgb string
	 * @return the int[]
	 */
	public static int[] toRGB(String rgbString) {
		return toRGB(rgbString, new int[3]);
	}

	/**
	 * To RGB.
	 *
	 * @param rgbString the rgb string
	 * @param defaultValue the default value
	 * @return the int[]
	 */
	public static int[] toRGB(String rgbString, int[] defaultValue) {
		if (rgbString == null || rgbString.equals(""))
			return defaultValue;
		String[] rgbs = rgbString.split(",");
		return new int[] { Integer.parseInt(rgbs[0]), Integer.parseInt(rgbs[1]), Integer.parseInt(rgbs[2]) };
	}
}
