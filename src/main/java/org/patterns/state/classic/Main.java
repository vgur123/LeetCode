package org.patterns.state.classic;

public class Main {
    public static void main(String[] args) {
        // Create context
        VendingMachineContext vendingMachine = new VendingMachineContext();

        // Set initial state
        vendingMachine.setState(()->{
            System.out.println("Ready state: Please select a product.");
        });

        // Request state change
        vendingMachine.request();

        // Change state
        vendingMachine.setState(()->{
            System.out.println("Product selected state: Product selected!");
        });

        // Request state change
        vendingMachine.request();

        // Change state
        vendingMachine.setState(()->{
            System.out.println("Payment state: Give me your money!");
        });

        // Request state change
        vendingMachine.request();

        // Change state
        //vendingMachine.setState(new OutOfStockState());

        // Request state change
        //vendingMachine.request();
    }
}
