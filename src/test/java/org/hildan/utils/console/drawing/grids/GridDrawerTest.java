package org.hildan.utils.console.drawing.grids;

import static org.junit.Assert.fail;

import org.hildan.utils.console.drawing.grids.GridDrawer.BorderType;
import org.junit.Test;

public class GridDrawerTest {

    public static class MyGrid implements Grid {

        @Override
        public int getCellWidth() {
            return 2;
        }

        @Override
        public int getWidth() {
            return 10;
        }

        @Override
        public int getHeight() {
            return 7;
        }

        @Override
        public String getValueAt(int row, int col) {
            return String.format("%02d", 2 * row + col);
        }
    }

    public static void main(String[] args) {
        final MyGrid g = new MyGrid();
        final GridDrawer gd = new GridDrawer();
        System.out.println("Default borders");
        System.out.println(gd.drawGrid(g));
        for (final BorderType bt : BorderType.values()) {
            gd.setBorderType(bt);
            System.out.println("Borders: " + bt);
            System.out.println(gd.drawGrid(g));
            for (final BorderType bt2 : BorderType.values()) {
                try {
                    gd.setBorderType(bt, bt2);
                    System.out.println("Borders: " + bt + "/" + bt2);
                    System.out.println(gd.drawGrid(g));
                } catch (final Exception e) {
                    System.err.println("Exception: " + e.getMessage());
                }
            }
        }
    }

    private static String LIGHT_LIGHT_GRID = "\u250C\u2500\u2500\u252C\u2500\u2500\u252C\u2500\u2500\u252C\u2500\u2500\u252C\u2500\u2500\u252C\u2500\u2500\u252C\u2500\u2500\u252C\u2500\u2500\u252C\u2500\u2500\u252C\u2500\u2500\u2510\n\u250200\u250201\u250202\u250203\u250204\u250205\u250206\u250207\u250208\u250209\u2502\n\u251C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u2524\n\u250202\u250203\u250204\u250205\u250206\u250207\u250208\u250209\u250210\u250211\u2502\n\u251C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u2524\n\u250204\u250205\u250206\u250207\u250208\u250209\u250210\u250211\u250212\u250213\u2502\n\u251C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u2524\n\u250206\u250207\u250208\u250209\u250210\u250211\u250212\u250213\u250214\u250215\u2502\n\u251C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u2524\n\u250208\u250209\u250210\u250211\u250212\u250213\u250214\u250215\u250216\u250217\u2502\n\u251C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u2524\n\u250210\u250211\u250212\u250213\u250214\u250215\u250216\u250217\u250218\u250219\u2502\n\u251C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u253C\u2500\u2500\u2524\n\u250212\u250213\u250214\u250215\u250216\u250217\u250218\u250219\u250220\u250221\u2502\n\u2514\u2500\u2500\u2534\u2500\u2500\u2534\u2500\u2500\u2534\u2500\u2500\u2534\u2500\u2500\u2534\u2500\u2500\u2534\u2500\u2500\u2534\u2500\u2500\u2534\u2500\u2500\u2534\u2500\u2500\u2518\n";

    private static String HEAVY_HEAVY_GRID = "\u250F\u2501\u2501\u2533\u2501\u2501\u2533\u2501\u2501\u2533\u2501\u2501\u2533\u2501\u2501\u2533\u2501\u2501\u2533\u2501\u2501\u2533\u2501\u2501\u2533\u2501\u2501\u2533\u2501\u2501\u2513\n\u250300\u250301\u250302\u250303\u250304\u250305\u250306\u250307\u250308\u250309\u2503\n\u2523\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u252B\n\u250302\u250303\u250304\u250305\u250306\u250307\u250308\u250309\u250310\u250311\u2503\n\u2523\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u252B\n\u250304\u250305\u250306\u250307\u250308\u250309\u250310\u250311\u250312\u250313\u2503\n\u2523\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u252B\n\u250306\u250307\u250308\u250309\u250310\u250311\u250312\u250313\u250314\u250315\u2503\n\u2523\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u252B\n\u250308\u250309\u250310\u250311\u250312\u250313\u250314\u250315\u250316\u250317\u2503\n\u2523\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u252B\n\u250310\u250311\u250312\u250313\u250314\u250315\u250316\u250317\u250318\u250319\u2503\n\u2523\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u254B\u2501\u2501\u252B\n\u250312\u250313\u250314\u250315\u250316\u250317\u250318\u250319\u250320\u250321\u2503\n\u2517\u2501\u2501\u253B\u2501\u2501\u253B\u2501\u2501\u253B\u2501\u2501\u253B\u2501\u2501\u253B\u2501\u2501\u253B\u2501\u2501\u253B\u2501\u2501\u253B\u2501\u2501\u253B\u2501\u2501\u251B\n";

    private static String DOUBLE_DOUBLE_GRID = "\u2554\u2550\u2550\u2566\u2550\u2550\u2566\u2550\u2550\u2566\u2550\u2550\u2566\u2550\u2550\u2566\u2550\u2550\u2566\u2550\u2550\u2566\u2550\u2550\u2566\u2550\u2550\u2566\u2550\u2550\u2557\n\u255100\u255101\u255102\u255103\u255104\u255105\u255106\u255107\u255108\u255109\u2551\n\u2560\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u2563\n\u255102\u255103\u255104\u255105\u255106\u255107\u255108\u255109\u255110\u255111\u2551\n\u2560\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u2563\n\u255104\u255105\u255106\u255107\u255108\u255109\u255110\u255111\u255112\u255113\u2551\n\u2560\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u2563\n\u255106\u255107\u255108\u255109\u255110\u255111\u255112\u255113\u255114\u255115\u2551\n\u2560\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u2563\n\u255108\u255109\u255110\u255111\u255112\u255113\u255114\u255115\u255116\u255117\u2551\n\u2560\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u2563\n\u255110\u255111\u255112\u255113\u255114\u255115\u255116\u255117\u255118\u255119\u2551\n\u2560\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u256C\u2550\u2550\u2563\n\u255112\u255113\u255114\u255115\u255116\u255117\u255118\u255119\u255120\u255121\u2551\n\u255A\u2550\u2550\u2569\u2550\u2550\u2569\u2550\u2550\u2569\u2550\u2550\u2569\u2550\u2550\u2569\u2550\u2550\u2569\u2550\u2550\u2569\u2550\u2550\u2569\u2550\u2550\u2569\u2550\u2550\u255D\n";
    static {
        LIGHT_LIGHT_GRID = LIGHT_LIGHT_GRID.replace("\n", System.getProperty("line.separator"));
        HEAVY_HEAVY_GRID = HEAVY_HEAVY_GRID.replace("\n", System.getProperty("line.separator"));
        DOUBLE_DOUBLE_GRID = DOUBLE_DOUBLE_GRID.replace("\n", System.getProperty("line.separator"));
    }

    private static void assertCorrectGrid(String expected, String actual) {
        if (expected.length() < actual.length()) {
            fail("result too short by " + (actual.length() - expected.length()) + " chars:\n\nEXPECTED:\n'" + expected
                    + "'\n\nACTUAL:\n'" + actual + "'");
        }
        if (expected.length() > actual.length()) {
            fail("result too long by " + (expected.length() - actual.length()) + " chars:\n\nEXPECTED:\n'" + expected
                    + "'\n\nACTUAL:\n'" + actual + "'");
        }
        for (int i = 0; i < expected.length(); i++) {
            if (actual.charAt(i) != expected.charAt(i)) {
                fail("different character at position " + i);
            }
        }
    }

    @Test
    public void testDefaultBordersConstructor() {
        final MyGrid g = new MyGrid();
        final GridDrawer gd = new GridDrawer();
        final String result = gd.drawGrid(g);
        assertCorrectGrid(LIGHT_LIGHT_GRID, result);
    }

    @Test
    public void testLightBordersConstructor() {
        final MyGrid g = new MyGrid();
        final GridDrawer gd = new GridDrawer(BorderType.LIGHT);
        assertCorrectGrid(LIGHT_LIGHT_GRID, gd.drawGrid(g));
    }

    @Test
    public void testLightBordersSetterSimple() {
        final MyGrid g = new MyGrid();
        final GridDrawer gd = new GridDrawer();
        gd.setBorderType(BorderType.LIGHT);
        assertCorrectGrid(LIGHT_LIGHT_GRID, gd.drawGrid(g));
    }

    @Test
    public void testLightBordersSetterIntExt() {
        final MyGrid g = new MyGrid();
        final GridDrawer gd = new GridDrawer();
        gd.setBorderType(BorderType.LIGHT, BorderType.LIGHT);
        assertCorrectGrid(LIGHT_LIGHT_GRID, gd.drawGrid(g));
    }

    @Test
    public void testHeavyBordersConstructor() {
        final MyGrid g = new MyGrid();
        final GridDrawer gd = new GridDrawer(BorderType.HEAVY);
        assertCorrectGrid(HEAVY_HEAVY_GRID, gd.drawGrid(g));
    }

    @Test
    public void testHeavyBordersSetterSimple() {
        final MyGrid g = new MyGrid();
        final GridDrawer gd = new GridDrawer();
        gd.setBorderType(BorderType.HEAVY);
        assertCorrectGrid(HEAVY_HEAVY_GRID, gd.drawGrid(g));
    }

    @Test
    public void testHeavyBordersSetterIntExt() {
        final MyGrid g = new MyGrid();
        final GridDrawer gd = new GridDrawer();
        gd.setBorderType(BorderType.HEAVY, BorderType.HEAVY);
        assertCorrectGrid(HEAVY_HEAVY_GRID, gd.drawGrid(g));
    }

    @Test
    public void testDoubleBordersConstructor() {
        final MyGrid g = new MyGrid();
        final GridDrawer gd = new GridDrawer(BorderType.DOUBLE);
        assertCorrectGrid(DOUBLE_DOUBLE_GRID, gd.drawGrid(g));
    }

    @Test
    public void testDoubleBordersSetterSimple() {
        final MyGrid g = new MyGrid();
        final GridDrawer gd = new GridDrawer();
        gd.setBorderType(BorderType.DOUBLE);
        assertCorrectGrid(DOUBLE_DOUBLE_GRID, gd.drawGrid(g));
    }

    @Test
    public void testDoubleBordersSetterIntExt() {
        final MyGrid g = new MyGrid();
        final GridDrawer gd = new GridDrawer();
        gd.setBorderType(BorderType.DOUBLE, BorderType.DOUBLE);
        assertCorrectGrid(DOUBLE_DOUBLE_GRID, gd.drawGrid(g));
    }
}
