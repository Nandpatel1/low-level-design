package creational.singleton;


// This is a thread-safe approach, but it will be in the memory even if it is not used.
class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    // private constructor
    private EagerSingleton() {
        System.out.println("Object is created");
        // Declaring it private prevents creation of its object using the new keyword
    }

    // Method to get the instance of class
    public static EagerSingleton getInstance() {
        return instance; // Always returns the same instance
    }
}

public class EagerLoading {
    public static void main(String[] args) {
        EagerSingleton instance = EagerSingleton.getInstance();

    }
}
