package endgin;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Encoder {

    private static final char[] alfabet = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ы', 'Ъ', 'Э', 'Ю', 'Я', '.', ',', '"', ':', '-', '!', '?', ' '};
    private static final char[] alfabetMini = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ы', 'ъ', 'э', 'ю', 'я', '.', ',', '"', ':', '-', '!', '?', ' '};

    public Encoder() {
    }

    public static int findSymbol(char cha) {
        int index = Arrays.binarySearch(alfabet, cha);
        int indexMini = Arrays.binarySearch(alfabetMini, cha);
        if (index > 0) {
            return 1;
        } else if (indexMini > 0) {
            return 2;
        }
        return 0;
    }

    public static int getIndex(char ch) {
        switch (findSymbol(ch)) {
            case 1:
                return Arrays.binarySearch(alfabet, ch);
            case 2:
                return Arrays.binarySearch(alfabetMini, ch);
        }
        return 0;
    }


    public static char encodingCesar(char simbol) {
        switch (findSymbol(simbol)) {
            case 1:
                return alfabet[Arrays.binarySearch(alfabet, simbol) + Key.getKey( )];
            case 2:
                return alfabetMini[Arrays.binarySearch(alfabetMini, simbol) + Key.getKey( )];
        }
        return simbol;
    }


    static public char deCodingCesar(char simbol) {
        switch (findSymbol(simbol)) {
            case 1:
                return alfabet[Arrays.binarySearch(alfabet, simbol) - Key.getKey( )];
            case 2:
                return alfabetMini[Arrays.binarySearch(alfabetMini, simbol) - Key.getKey( )];
        }
        return simbol;

    }


}
