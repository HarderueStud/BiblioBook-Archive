package blibliobook;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

// Peut generer des mots de passe / references de maniere aleatoire

public class RandomStringGenerator {
    public String nextString() {
        for (int idx = 0; idx < buffer.length; ++idx)
            buffer[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buffer);
    }

    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String lower = upper.toLowerCase(Locale.ROOT);
    public static final String digits = "0123456789";
    public static final String alphanum = upper + lower + digits;
    
    private final Random random;
    private final char[] symbols;
    private final char[] buffer;

    public RandomStringGenerator(int length, Random random, String symbols) {
        if (length < 1) throw new IllegalArgumentException();
        if (symbols.length() < 2) throw new IllegalArgumentException();
        this.random = Objects.requireNonNull(random);
        this.symbols = symbols.toCharArray();
        this.buffer = new char[length];
    }

    public RandomStringGenerator(int length, Random random) {
        this(length, random, alphanum);
    }

    public RandomStringGenerator(int length) {
        this(length, new SecureRandom());
    }

    public RandomStringGenerator() {
        this(21);
    }
}
