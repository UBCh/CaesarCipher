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

        while (true) {
            System.out.println("введите текст");
            text = scanner.nextLine( );
            String[] menu = {"1-выполнить шифрование", "2-выполнить дешифровку", "100-остановить программу"};
            for (String s : menu) {
                System.out.println(s);
            }
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

                case 100:
                    System.exit(1);

            }
        }

    }


}
