package creational.singleton;

// This is the simplest way to ensure thread safety with memory safety.
// But this approach can lead to performance issues due to the overhead of synchronization.
class Singleton {
    private static Singleton instance;

    private Singleton() {
        System.out.println("Object created");
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

public class SynchronizedMethod {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        Singleton instance3 = Singleton.getInstance();

    }
}
