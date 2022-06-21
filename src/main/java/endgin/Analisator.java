package endgin;

public class Analisator {

    public static String analisatorText(String string) {

        char[] text = string.toCharArray( );
        char[] tmp = new char[text.length];
        for (int i = 0; i < text.length; i++) {
            tmp[i] = Encoder.encodingCesar(text[i]);
        }
        return String.valueOf(tmp);
    }

    public static String analisatorCript(String string) {


        char[] text = string.toCharArray( );
        char[] tmp = new char[text.length];
        for (int i = 0; i < text.length; i++) {
            tmp[i] = Encoder.deCodingCesar(text[i]);
        }
        return String.valueOf(tmp);
    }
}
