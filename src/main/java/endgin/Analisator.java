package endgin;

import exception.SymbolNotFoundException;

public class Analisator {

    public static String analisatorText(String string) throws SymbolNotFoundException {

        char[] text = string.toCharArray( );
        char[] tmp = new char[text.length];
        char whitespace = ' ';
        for (int i = 0; i < text.length; i++) {
            if (whitespace == text[i]) {
                tmp[i] = ' ';
                continue;
            }
            tmp[i] = Encoder.encodingCesar(text[i]);
        }
        return String.valueOf(tmp);
    }

    public static String analisatorCript(String string) throws SymbolNotFoundException {
        char[] text = string.toCharArray( );
        char[] tmp = new char[text.length];
        char whitespace = ' ';
        for (int i = 0; i < text.length; i++) {
            if (whitespace == text[i]) {
                tmp[i] = ' ';
                continue;
            }
            tmp[i] = Encoder.deCodingCesar(text[i]);
        }
        return String.valueOf(tmp);
    }
}
