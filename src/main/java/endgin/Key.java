package endgin;

public class Key {
    private static int key;

    public Key(int key) {
        Key.key = key;
    }

    public static int getKey() {
        return key;
    }

    public static void setKey(int key) {
        Key.key = key;
    }
}
