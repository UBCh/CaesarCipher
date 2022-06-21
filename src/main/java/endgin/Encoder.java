package endgin;

import java.lang.reflect.Array;
import java.util.Arrays;

public  class Encoder {

       private static final char [] alfabet= {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ы', 'Ъ', 'Э', 'Ю', 'Я','.', ',', '"', ':', '-', '!', '?', ' '};
    private static final char [] alfabetMini= {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ы', 'ъ', 'э', 'ю', 'я','.', ',', '"', ':', '-', '!', '?', ' '};

       public Encoder() {
       }







   public static char encodingCesar(char simbol){
       int index= Arrays.binarySearch(alfabet,simbol);
       int indexMini=Arrays.binarySearch(alfabetMini,simbol);
       if (index>0){return alfabet[index+Key.getKey()];}
       else if (indexMini>0){return alfabetMini[indexMini+Key.getKey()];}
       return simbol ;
         }


    static public char deCodingCesar(char simbol){
        int index= Arrays.binarySearch(alfabet,simbol);
        int indexMini=Arrays.binarySearch(alfabetMini,simbol);
        if (index>0){return alfabet[index-Key.getKey()];}
        else if (indexMini>0){return alfabetMini[indexMini-Key.getKey()];}
        return simbol ;

    }



}
