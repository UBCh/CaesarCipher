package endgin;

import exception.SymbolNotFoundException;

import java.util.HashMap;
import java.util.Map;


public class Encoder {
// алфавит вынесен в переменную- для возможности параметризации проекта, с той же целью 2 алфавита, что позволяет при желании добавлять любой алфавит ,
//    переменные можно передавать из контроллера или добавить еще одну панель управления

    private static  char[] alfabet = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ы', 'Ъ', 'Э', 'Ю', 'Я', '.', ',', '"', ':', '-', '!', '?', ' '};
     private static  char[] alfabetTwo = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ы', 'ъ', 'э', 'ю', 'я', '.', ',', '"', ':', '-', '!', '?', ' '};
    private static final Map<Integer, Character> alfabetMap = setMapsAlfabet(alfabet);
    private static final Map<Integer, Character> alfabetMapTwo = setMapsAlfabet(alfabetTwo);


//   конструктор с параметрами, для передачи переменных
//    public Encoder(char[] x,char[] y) {
//        this.alfabet=x;
//        this.alfabetTwo =y;
//    }
    public Encoder(){}
    // определяем какой из алфавитов используется
    private static Map<Integer, Character> setMapsAlfabet(char[] chars) {
//        BidiMap map = new DualHashBidiMap<>();
        Map<Integer, Character> map = new HashMap<>( );
        for (int c = 0; c < chars.length; c++) {
            map.put(c, chars[c]);
        }
        return map;
    }



    // определяем какой из алфавитов используется
    public static int findSymbol(char cha) throws SymbolNotFoundException {
        boolean index = alfabetMap.containsValue(cha);

        boolean indexTwo = alfabetMapTwo.containsValue(cha);
        if (index) {
            return 1;
        } else if (indexTwo) {
            return 2;
        }
       if (!index && !indexTwo)
           return 0;
//       throw new SymbolNotFoundException(" символ не найден в алфавите, попробуйте другой текст");


        return -1;
    }


    // получаем  инднекс символа в мапе

    public static int getIndex(char ch) throws SymbolNotFoundException {
        switch (findSymbol(ch)) {
            case 1:
                for (int i = 0; i < alfabetMap.size( ); i++) {
                    if (alfabetMap.get(i).equals(ch)) {
                        return i;
                    }
                }

            case 2:
                for (int i = 0; i < alfabetMapTwo.size( ); i++) {
                    if (alfabetMapTwo.get(i).equals(ch)) {

                        return i;
                    }
                }
                   }
       return -1;
    }

    // сдвигаем символ по алфавиту вправо
    public static char encodingCesar(char simbol) throws SymbolNotFoundException {
        switch (findSymbol(simbol)) {            // определяем какой из алфавитов используется
            case 1:
                int indexMap = getIndex(simbol) + Key.getKey( );      // определяем новый индекс символа в мапе
               while (indexMap >= alfabetMap.size( )-1) {                  // если новый индекс больше, чем размер мапы
                    indexMap = indexMap - (alfabetMap.size( )-1);
                }
                return alfabetMap.get(indexMap);

            case 2:
                int indexMapMini = getIndex(simbol)+ Key.getKey( );
                  while (indexMapMini >= alfabetMapTwo.size( )-1) {
                   indexMapMini = indexMapMini - (alfabetMapTwo.size( )-1);
                    indexMapMini=indexMapMini;
                }
               var q= alfabetMapTwo.get(indexMapMini);
                return q;
            case -1:
                return simbol;
        }

        return 0;
    }


    static public char deCodingCesar(char simbol) throws SymbolNotFoundException {
        switch (findSymbol(simbol)) {
            case 1:
                int indexMap1 = getIndex(simbol) - Key.getKey( );
                while (indexMap1 < 0) {
                    indexMap1 = (alfabetMap.size( )-1) + indexMap1;
                }
                return alfabetMap.get(indexMap1);

            case 2:
                int indexMap2 = getIndex(simbol) - Key.getKey( );
                while (indexMap2 < 0) {
                    indexMap2 = (alfabetMapTwo.size( )-1) + indexMap2;

                }
                return alfabetMapTwo.get(indexMap2);
            case -1:
                return simbol;

        }
        return 0;
    }
}
