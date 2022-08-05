package endgin;

import exception.SymbolNotFoundException;

import java.util.HashMap;
import java.util.Map;


public class Encoder {
// алфавит вынесен в переменную- для возможности параметризации проекта

    private static final char[] a = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ы', 'Ъ', 'Э', 'Ю', 'Я', '.', ',', '"', ':', '-', '!', '?', ' '};
    private static final char[] aM = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ы', 'ъ', 'э', 'ю', 'я', '.', ',', '"', ':', '-', '!', '?', ' '};
    private static final Map<Integer, Character> alfabet = setMapsAlfabet(a);
    private static final Map<Integer, Character> alfabetMini = setMapsAlfabetMini(aM);

    public Encoder() {
    }

    private static Map<Integer, Character> setMapsAlfabet(char[] chars) {
//        BidiMap map = new DualHashBidiMap<>();
        Map<Integer, Character> map = new HashMap<>( );
        for (int c = 0; c < chars.length; c++) {
            map.put(c, chars[c]);
        }
        return map;
    }

    private static Map<Integer, Character> setMapsAlfabetMini(char[] chars) {
        Map<Integer, Character> map = new HashMap<>( );
        for (int c = 0; c < chars.length; c++) {
            map.put(c, chars[c]);
        }
        return map;
    }

    // определяем какой из алфавитов используется
    public static int findSymbol(char cha) throws SymbolNotFoundException {
        boolean index = alfabet.containsValue(cha);

        boolean indexMini = alfabetMini.containsValue(cha);
        if (index) {
            return 1;
        } else if (indexMini) {
            return 2;
        }
       if (!index && !indexMini)
        throw new SymbolNotFoundException(" символ не является кириллицей, попробуйте другой текст");
        return 0;
    }


    // получаем  инднекс символа в мапе

    public static int getIndex(char ch) throws SymbolNotFoundException {
        switch (findSymbol(ch)) {
            case 1:
                for (int i = 0; i < alfabet.size( ); i++) {
                    if (alfabet.get(i).equals(ch)) {
                        return i;
                    }
                }

            case 2:
                for (int i = 0; i < alfabetMini.size( ); i++) {
                    if (alfabetMini.get(i).equals(ch)) {

                        return i;
                    }
                }
        }
        return 0;
    }


    public static char encodingCesar(char simbol) throws SymbolNotFoundException {
        switch (findSymbol(simbol)) {
            case 1:
                int indexMap = getIndex(simbol) + Key.getKey( );
                if (indexMap >= alfabet.size( )-1) {
                    indexMap = indexMap - alfabet.size( );
                }
                return alfabet.get(indexMap);

            case 2:
                int indexMapMini = getIndex(simbol)+ Key.getKey( );
                   if (indexMapMini >= alfabetMini.size( )-1) {
                    indexMapMini = indexMapMini - alfabetMini.size( );
                    indexMapMini=indexMapMini;
                }
               var q=alfabetMini.get(indexMapMini);
                return q;

        }
        return simbol;
    }


    static public char deCodingCesar(char simbol) throws SymbolNotFoundException {
        switch (findSymbol(simbol)) {
            case 1:
                int indexMap1 = getIndex(simbol) - Key.getKey( );
                if (indexMap1 < 0) {
                    indexMap1 = alfabet.size( ) + indexMap1;
                }
                return alfabet.get(indexMap1);

            case 2:
                int indexMap2 = getIndex(simbol) - Key.getKey( );
                if (indexMap2 < 0) {
                    indexMap2 = alfabetMini.size( ) + indexMap2;

                }
                return alfabetMini.get(indexMap2);


        }
        return simbol;
    }
}
