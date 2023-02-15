package io.textformatter.formatter.filter;

import io.textformatter.formatter.FilterFormatter;
import io.textformatter.formatter.TextFormatter;
import io.textformatter.util.XORUtil;

public class XORFormatter extends FilterFormatter {
    public static final String ENCODING_FLAG = "§";

    public XORFormatter(TextFormatter innerFormatter) {
        super(innerFormatter);
    }

    @Override
    public String format(String text, String key) {
        text = xor(text, extractKeyHead(key));
        return innerFormatter().format(text, removeKeyHead(key));
    }

    public String xor(String s, String key) {
        if (isEncoded(s)) {
            return XORUtil.decode(removeEncodingFlag(s), key);
        } else {
            return ENCODING_FLAG + XORUtil.encode(s, key);
        }
    }

    private boolean isEncoded(String text) {
        return text.startsWith(ENCODING_FLAG);
    }

    private String removeEncodingFlag(String text) {
        return text.substring(ENCODING_FLAG.length());
    }

    @Override
    public String name() {
        return "x";
    }
}

