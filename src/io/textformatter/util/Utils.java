package io.textformatter.util;

import java.security.SecureRandom;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Random;

public class Utils {
    private static Random random = new SecureRandom();

    public static boolean isNumeric(String str) {
        ParsePosition pos = new ParsePosition(0);
        NumberFormat.getInstance().parse(str, pos);
        return str.length() == pos.getIndex();
    }

    public static boolean isDecimal(double d) {
        return !((d == Math.floor(d)) && !Double.isInfinite(d));
    }

    public static boolean isAlphabet(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public static int random(int r) {
        return random.nextInt(r);
    }
}
