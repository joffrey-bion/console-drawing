package org.hildan.utils.console.drawing.progress;

import org.hildan.utils.console.drawing.grids.BoxChars;

/**
 * A HeaderStyle defines the characters to use in order to draw the header of an
 * {@link AbstractProgressBar}.
 * <p>
 * The header is important for the user to know the length of bar, if it is not fully displayed.
 * This situation happens when the console can't print {@code \b} or {@code \r} characters to remove
 * the older bar, and the end of the bar is therefore not printed until the end is reached.
 */
public class HeaderStyle {

    /**
     * No header.
     */
    public static final HeaderStyle NONE = new HeaderStyle(' ', ' ', ' ');

    /**
     * A thin ASCII line made out of underscore characters.
     */
    public static final HeaderStyle LINE = new HeaderStyle(' ', '_', ' ');

    /**
     * A line with angles using box drawing characters. The header looks like the upper half of a
     * thin and long rectangle.
     */
    public static final HeaderStyle ANGLES = new HeaderStyle(BoxChars.BOX_DRAWINGS_LIGHT_DOWN_AND_RIGHT,
            BoxChars.BOX_DRAWINGS_LIGHT_HORIZONTAL, BoxChars.BOX_DRAWINGS_LIGHT_DOWN_AND_LEFT);

    public final char left;

    public final char mid;

    public final char right;

    /**
     * Creates a new {@code HeaderStyle}.
     *
     * @param left
     *            the {@code char} for the header's left bound. It is located right above
     *            {@link BarStyle#left}.
     * @param mid
     *            The {@code char} repeated in the header's middle part.
     * @param right
     *            The {@code char} for the header's right bound. It is located right above
     *            {@link BarStyle#right}.
     */
    public HeaderStyle(char left, char mid, char right) {
        this.left = left;
        this.mid = mid;
        this.right = right;
    }
}
