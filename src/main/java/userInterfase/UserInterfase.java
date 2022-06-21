package userInterfase;

import endgin.Analisator;
import endgin.BruteForse;
import endgin.Encoder;
import endgin.Key;

import java.util.Scanner;

import static endgin.Encoder.*;
import static java.lang.System.in;
import static java.lang.System.out;

public class UserInterfase {
    static Scanner scanner = new Scanner(in);
    static String text;

    public static void main(String[] args) {
        System.out.println("введите текст");
            String[] menu = { "Выбери что нужно сделать с  текстом",
                "1-хотите задать ключ и выполнить шифрование",
                "2-знаете ключ?-выполнить дешифровку",
                "3-знаете кодовое слово-выполнить дешифровку",
                "4-зашиифровать случайным ключем",
                "100-остановить программу"};
        for (String s : menu) {
            System.out.println(s);
        }
        while (true) {
            System.out.println("введите текст");
            text = scanner.nextLine( );
            System.out.println("выберите, что вы хотите сделать с этим текстом");
                switch (scanner.nextInt( )) {
                case 1:
                    System.out.println("введите ключ");
                    int key = scanner.nextInt( );
                    Key.setKey(key);
                    System.out.println(Analisator.analisatorText(text));
                    break;
                case 2:
                    System.out.println("введите ключ");
                    key = scanner.nextInt( );
                    Key.setKey(key);
                    System.out.println(Analisator.analisatorCript(text));
                    break;
                case 3:
                    System.out.println("введите проверочное слово");
                    String test = scanner.next( );
                    System.out.println(BruteForse.hakker(text,test));
                    break;
                case 4:
                    System.out.println(BruteForse.cryptographer(text));
                    System.out.println("Запомните кодовое слово  - "+ BruteForse.getСodeWord());
                    break;
                case 100:

                    System.exit(1);

            }
        }

    }


}
