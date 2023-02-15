package io.textformatter.formatter.filter;

import io.textformatter.formatter.FilterFormatter;
import io.textformatter.formatter.TextFormatter;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HashFormatter extends FilterFormatter {
    public HashFormatter(TextFormatter innerFormatter) {
        super(innerFormatter);
    }

    @Override
    public String format(String text, String key) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] bytes = digest.digest(text.getBytes(StandardCharsets.UTF_8));
        String hash = Base64.getEncoder().encodeToString(bytes);
        return innerFormatter().format(hash, key);
    }

    @Override
    public String name() {
        return "h";
    }
}
