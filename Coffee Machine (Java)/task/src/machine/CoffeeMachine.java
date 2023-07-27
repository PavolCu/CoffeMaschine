package machine;
import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;

    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.disposableCups = 9;
        this.money = 550;
    }

    public boolean processInput(String input) {
        switch (input) {
            case "buy":
                buyCoffee();
                break;
            case "fill":
                fillMachine();
                break;
            case "take":
                takeMoney();
                break;
            case "remaining":
                printState();
                break;
            case "exit":
                return false;
            default:
                System.out.println("Invalid action. Please try again.");
                break;
        }
        return true;
    }

    private void printState() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println();
    }

    private void buyCoffee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        System.out.print("> ");
        String coffeeType = scanner.next();

        if (coffeeType.equals("back")) {
            return;
        }

        int requiredWater, requiredMilk = 0, requiredBeans, cost;

        switch (coffeeType) {
            case "1": // espresso
                requiredWater = 250;
                requiredBeans = 16;
                cost = 4;
                break;
            case "2": // latte
                requiredWater = 350;
                requiredMilk = 75;
                requiredBeans = 20;
                cost = 7;
                break;
            case "3": // cappuccino
                requiredWater = 200;
                requiredMilk = 100;
                requiredBeans = 12;
                cost = 6;
                break;
            default:
                System.out.println("Invalid coffee type. Please try again.");
                return;
        }

        if (water < requiredWater) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (milk < requiredMilk) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (coffeeBeans < requiredBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }
        if (disposableCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return;
        }

        System.out.println("I have enough resources, making you a coffee!");

        water -= requiredWater;
        milk -= requiredMilk;
        coffeeBeans -= requiredBeans;
        money += cost;
        disposableCups--;
    }

    private void fillMachine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        System.out.print("> ");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        System.out.print("> ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        System.out.print("> ");
        coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        System.out.print("> ");
        disposableCups += scanner.nextInt();
    }

    private void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        String action;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            System.out.print("> ");
            action = scanner.next();
        } while (coffeeMachine.processInput(action));
    }
}
