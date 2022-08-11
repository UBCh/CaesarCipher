package endgin;

import exception.SymbolNotFoundException;

import java.util.Locale;

public class BruteForse {


    private static String codeWord;

    public BruteForse() {
    }

    public static String hakker(String string, String test) throws SymbolNotFoundException {
       String result="";
       char [] tmp=null;
       string=string.toUpperCase(Locale.ROOT);
       test=test.toUpperCase(Locale.ROOT);
       char[] testChar=test.toCharArray();
       String[] text=string.split(" ");
       int delta=0;
       for (int i=0; i<text.length; i++){
           if (text[i].length()==test.length()){
               tmp=text[i].toCharArray(); break;            // получаем врееменный массив , заполненый символами слова, предположительно соответсвующего кодовому
           }
       }
        // ищем ключ, которым было зашифровано, для этого сравниваем индексы в мапе символов кодового слова и tmp
        for (int j=0; j<tmp.length; j++){
        // для начала ищем инднекс в мапе символа раскодируемого слова
         int indexTmp=Encoder.getIndex(tmp[j]);
            //  ищем инднекс в мапе символа тестового слова
            int indexTest=Encoder.getIndex(testChar[j]);
            //  сравниваем индексы если индекс расшифруемого символа больше (т.е. ближе к концу)-все хорошо, нужна просто разница между индексами для определения сдвига
            if (indexTmp>indexTest){ delta=indexTmp-indexTest; Key.setKey(delta);}
            //  если индекс расшифруемого символа меньше нужно вычислить количество символов между - для этого узнаем количество символов до конца и плюсуем количество символов от начала
            else {
             switch (Encoder.findSymbol(tmp[j]))  {
                 case 1:
                     int indexDistanceEnd1=(Encoder.getAlfabet().length-1)-Encoder.getIndex(tmp[j]);
                     delta=indexDistanceEnd1+indexTest;
                     Key.setKey(delta);
                 case 2:
                    int z=(Encoder.getAlfabetTwo().length-1)-Encoder.getIndex(testChar[j]); // расстояние до конца алфавита от символа кодовго слова
                     delta =z+Encoder.getIndex(tmp[j]);
                     Key.setKey(delta);
             }
            }
// после того как установили предположительно ключ декодируем по символьно первое слово
        tmp[j]=Encoder.deCodingCesar(tmp[j]);

        }
        result= String.valueOf(tmp);
        if (result.equals(test)){
            // если удалось
            result=Analisator.analisatorCript(string);

        }

            return result;
    }

    public static String cryptographer(String string) throws SymbolNotFoundException {

        // создадим  для хранения зашифрованного
        String result = "";
        // сначала порежем на части по пробелом, т.е. разобьем на слова
        String[] segmentText = string.split(String.valueOf(' '));
        // найдем кодове слово -по длине самое длинное
        int index = 0;    // ишем индекс самого длинного отрезка
        int w = 0;
        for (int q = 0; q < segmentText.length; q++) {
            if (segmentText[q].length( ) > w) {
                w = segmentText[q].length( );
                index = q;
            }
            continue;
        }
        setCodeWord(segmentText[index]);  // задаем кодовое слово

        Key.setKey((int) (Math.random( ) * 9));  // задаем случайный ключ

        return Analisator.analisatorText(string);   // кодируем
    }


    public static void setCodeWord(String code) {
        codeWord = code;
    }

    public static String getCodeWord() {
        return codeWord;
    }


}
