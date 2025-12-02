package creational.singleton;


// Saved memory if instance is never used.
// Lazy Loading is Not thread-safe by default. Thus, it requires synchronization in multi-threaded environments.
class LazySingleton {
    // Object declaration
    private static LazySingleton instance;

    // private constructor
    private LazySingleton() {
        System.out.println("Object is created...");
        // Declaring it private prevents creation of its object using the new keyword
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }

        return instance;
    }
}

public class LazyLoading {
    public static void main(String[] args) {
        LazySingleton instance = LazySingleton.getInstance();
        System.out.println(instance);
    }
}
