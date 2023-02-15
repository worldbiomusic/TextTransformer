package io.textformatter.formatter.filter;

import io.textformatter.formatter.FilterFormatter;
import io.textformatter.formatter.TextFormatter;
import io.textformatter.util.Utils;
import redempt.crunch.Crunch;

;

/**
 * Evaluate expressions in the key<br>
 * Using <a href="https://github.com/Redempt/Crunch">Crunch</a> library
 */
public class ExpressionFormatter extends FilterFormatter {
    public ExpressionFormatter(TextFormatter innerFormatter) {
        super(innerFormatter);
    }

    @Override
    public String format(String text, String key) {
        // (1+2)
        while (true) {
            int start = key.indexOf("[");
            int end = key.indexOf("]");
            if (start == -1 || end == -1) {
                break;
            }

            double value = evaluate(key.substring(start, end + 1));
            String valueString = Utils.isDecimal(value) ? "" + value : "" + (int) value;

            key = key.substring(0, start) + valueString + key.substring(end + 1, key.length());
        }
        return innerFormatter().format(text, key);
    }

    public double evaluate(String expr) {
        expr = expr.replace("[", "").replace("]", "");
        return Crunch.compileExpression(expr).evaluate();
    }

    @Override
    public String name() {
        return "e";
    }
}
