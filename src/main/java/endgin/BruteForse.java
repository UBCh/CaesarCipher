package endgin;

import exception.SymbolNotFoundException;

import java.util.Arrays;

public class BruteForse {


    private static String codeWord;

    public BruteForse() {
    }

    public static String hakker(String string, String test) throws SymbolNotFoundException {
        // создадим  для хранения расшифрованного
        String result = "";
        //         сначала порежем на части по пробелом, т.е. разобьем на слова
        String[] segmentText = string.split(String.valueOf(' '));
        // проверим какой отрезок совпадает по длинне с тестовым словом
        for (int i = 0; i < segmentText.length; i++) {
            if (segmentText[i].length( ) != test.length( )) {
                continue;
            } else {
                char[] segmentTextChar = segmentText[i].toCharArray( );           // нашли какой отрезок совпадает по длинне с тестовым словом, перегоняем его в массив char
               char[] testChar = test.toCharArray( );

              //  перегоняем тестовую строку в массив char
                char[] tmp2 = new char[segmentTextChar.length];                         //временный пустой массив
                for (int t = 0; t < segmentTextChar.length; t++) {
                    if (Encoder.findSymbol(testChar[t]) > 0) {                     // проверяем есть ли символы в алфавите
                        int indexTestChar = Encoder.getIndex(testChar[t]);         // находим индекс символа в алфавите
                        int indexSegment = Encoder.getIndex(segmentTextChar[t]);       // получаем шаг
                        if (indexTestChar != indexSegment) {
                            int delta = indexSegment - indexTestChar;
                            Key.setKey(delta);
                            tmp2[t] = Encoder.deCodingCesar(segmentTextChar[t]);
                        }
                    }
                }
                if (Arrays.equals(tmp2, testChar)) {
                    break;
                }                       // проверяем, что полученный расшифрованный участок совпадает с тестовым словом
            }
        }
        for (int j = 0; j < segmentText.length; j++) {
            result = result + " " + Analisator.analisatorCript(segmentText[j]);           // дешифруем по чатсям
        }
        return result;


    }

    public static String cryptographer(String string) throws SymbolNotFoundException {
        String text = string;
        // создадим  для хранения зашифрованного
        String result = "";
        // сначала порежем на части по пробелом, т.е. разобьем на слова
        String[] segmentText = string.split(String.valueOf(' '));
        // найдем кодове слово -по длине самое длинное
        int index = 0;    // ишем индект самого длинного отрезка
        int w = 0;
        for (int q = 0; q < segmentText.length; q++) {
            if (segmentText[q].length( ) > w) {
                w = segmentText[q].length( );
                index = q;
            }
            continue;
        }
        setCodeWord(segmentText[index]);

        Key.setKey((int) (Math.random( ) * 9));

        return Analisator.analisatorText(string);
    }


    public static void setCodeWord(String code) {
        codeWord = code;
    }

    public static String getCodeWord() {
        return codeWord;
    }


}
