package io.textformatter.formatter.filter;

import io.textformatter.formatter.FilterFormatter;
import io.textformatter.formatter.TextFormatter;

public class TimesFormatter extends FilterFormatter {
    public TimesFormatter(TextFormatter innerFormatter) {
        super(innerFormatter);
    }

    @Override
    public String format(String text, String key) {
        double times = Double.parseDouble(extractKeyHead(key));
        return innerFormatter().format(times(text, times), removeKeyHead(key));
    }

    String times(String text, double times) {
        if (times < 0) {
            // do nothing
            return text;
        } else if (times < 1) {
            int length = (int) (text.length() * times);
            return text.substring(0, length);
        } else {
            String originText = text;
            text = originText.repeat((int) times);
            double remainDecimal = times - (int) times;
            // for remained decimal
            text += times(originText, remainDecimal);
            return text;
        }
    }

    @Override
    public String name() {
        return "t";
    }
}
