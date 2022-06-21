package endgin;

import java.util.Arrays;

public class BruteForse {


    public static String hakker(String string, String test) {
        // создадим  для хранения расшифрованного

         // сначала порежем на части по пробелом, т.е. разобьем на слова
        String [] segmentText=string.split(" ");
       // проверим какой отрезок совпадает по длинне с тестовым словом
      for (int i=0; i< segmentText.length; i++){
          if (segmentText[i].length()!=test.length()){
              continue;}
          else {
              char[] segmentTextChar =segmentText[i].toCharArray();
              char [] testChar=test.toCharArray();
              char[] tmp=new char[segmentText.length];
              for (int t = 0; t < segmentTextChar.length; t++) {
                  if (Encoder.findSymbol(testChar[t])>0) {
                      int indexTestChar=Encoder.getIndex(testChar[t]);
                      int indexSegment =Encoder.getIndex(segmentTextChar[t]);
                      if( indexTestChar!=indexSegment){ int delta=indexSegment-indexTestChar; Key.setKey(delta);tmp[t]=Encoder.deCodingCesar(segmentTextChar[t]);}
                  }
              }
              if (Arrays.equals(tmp, testChar)){ break; }


          }

      }return Analisator.analisatorCript(string);


    }






}
