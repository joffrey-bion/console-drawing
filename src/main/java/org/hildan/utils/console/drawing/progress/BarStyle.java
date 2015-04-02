package org.hildan.utils.console.drawing.progress;

import org.hildan.utils.console.drawing.blocks.BlockChars;
import org.hildan.utils.console.drawing.grids.BoxChars;

/**
 * A BarStyle defines the characters to use in order to draw an {@link AbstractProgressBar}.
 */
public class BarStyle {

    /**
     * A progress bar made out of ASCII characters only. Not adapted for the use with a header.
     */
    public static final BarStyle ASCII = new BarStyle('[', '=', '>', ' ', ']');

    /**
     * A progress bar made out of ASCII characters only. Decent in combination with
     * {@link HeaderStyle#LINE}.
     */
    public static final BarStyle ASCII2 = new BarStyle('|', '=', '>', ' ', '|');

    /**
     * The progress bar is built with block characters. It looks like a full and growing rectangle.
     */
    public static final BarStyle BLOCK = new BarStyle(BlockChars.RIGHT_ONE_EIGHTH_BLOCK, BlockChars.FULL_BLOCK,
            BlockChars.LEFT_HALF_BLOCK, ' ', BlockChars.LEFT_ONE_EIGHTH_BLOCK);

    /**
     * A progress bar in the shape of a horizontal double line, using box drawing characters. Nice
     * in combination with {@link HeaderStyle#ANGLES}.
     */
    public static final BarStyle DOUBLE = new BarStyle(BoxChars.BOX_DRAWINGS_VERTICAL_SINGLE_AND_RIGHT_DOUBLE,
            BoxChars.BOX_DRAWINGS_DOUBLE_HORIZONTAL, BlockChars.BLACK_RIGHT_POINTING_SMALL_TRIANGLE, ' ',
            BoxChars.BOX_DRAWINGS_VERTICAL_SINGLE_AND_LEFT_DOUBLE);

    public final char left;

    public final char done;

    public final char curr;

    public final char todo;

    public final char right;

    /**
     * Creates a new BarStyle.
     *
     * @param leftBound
     *            the {@code char} for the bar's left bound. It is located right under
     *            {@link HeaderStyle#left} when a header is used.
     * @param done
     *            the {@code char} for the blocks representing the part that is done.
     * @param curr
     *            the {@code char} for the current last block of the progress.
     * @param todo
     *            the {@code char} for the blocks representing the part left to do.
     * @param rightBound
     *            the {@code char} for the bar's right bound.It is located right under
     *            {@link HeaderStyle#right}.
     */
    public BarStyle(char leftBound, char done, char curr, char todo, char rightBound) {
        this.left = leftBound;
        this.done = done;
        this.curr = curr;
        this.todo = todo;
        this.right = rightBound;
    }
}
