package endgin;

public class Key {
    public Key(int key) {
        this.key = key;
    }

    private static int key;

    public static int getKey() {
        return key;
    }

    public static void setKey(int key) {
        Key.key = key;
    }
}
