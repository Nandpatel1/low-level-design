package creational.singleton;

class BillPugh {
    private BillPugh() {}

    // Static inner class to hold the BillPugh instance
    private static class Holder {
        private static final BillPugh INSTANCE = new BillPugh();
    }

    public static BillPugh getInstance() {
        return Holder.INSTANCE;
    }
}

public class BillPughSingleton {
    public static void main(String[] args) {

    }
}
