package creational.singleton;

class DoubleCheckSingleton {
    // Volatile object declaration
    private static volatile DoubleCheckSingleton instance;

    private DoubleCheckSingleton() {}

    // Thread-safe method using double-checked locking
    public static DoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}

public class DoubleCheckedLocking {
    public static void main(String[] args) {

    }
}
