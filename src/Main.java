
interface PII {
    void getPizza();
}
abstract class PizzaDecorator implements PII{

    public PizzaDecorator(){
        System.out.println("PizzaDecorator");
    }
}

class Pizza extends PizzaDecorator {
    Pizza() {
        super();
    }

    @Override
    public void getPizza() {
        System.out.println("Margherita");
    }
}

public class Main {
    public static void main(String[] args) {
        PizzaDecorator pz = new Pizza();
        pz.getPizza();
    }
}