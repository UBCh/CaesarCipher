package endgin;

import exception.SymbolNotFoundException;

public class Analisator {
    // кодируем
    public static String analisatorText(String string) throws SymbolNotFoundException {

        char[] text = string.toCharArray( ); // превращаем в массив
        char[] tmp = new char[text.length];   // создаем временный массив, такой же длины
        char whitespace = ' ';
        for (int i = 0; i < text.length; i++) {
            if (whitespace == text[i]) {
                tmp[i] = ' ';                    // пропускаем пробел
                continue;
            }
            tmp[i] = Encoder.encodingCesar(text[i]);    // сдвигаем буквы по алфавиту в право
        }
        return String.valueOf(tmp);
    }


    // декодируем , тот же принцип
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
