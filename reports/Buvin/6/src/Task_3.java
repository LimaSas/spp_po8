import java.util.ArrayList;
import java.util.List;
interface Command {
    void execute();
    void undo();
}

class AddPizzaCommand implements Command {
    private Pizza pizza;
    private Order order;

    public AddPizzaCommand(Pizza pizza, Order order) {
        this.pizza = pizza;
        this.order = order;
    }

    @Override
    public void execute() {
        order.addPizza(pizza);
    }

    @Override
    public void undo() {
        order.removePizza(pizza);
    }
}

class CancelOrderCommand implements Command {
    private Order order;

    public CancelOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.cancel();
    }

    @Override
    public void undo() {
        order.restore();
    }
}

class Order {
    private List<Pizza> pizzas = new ArrayList<>();
    private boolean canceled = false;

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
    }

    public void cancel() {
        pizzas.clear();
        canceled = true;
    }

    public void restore() {
        canceled = false;
    }

    public void print() {
        if (canceled) {
            System.out.println("Заказ отменен");
        } else {
            System.out.println("Заказ:");
            for (Pizza pizza : pizzas) {
                System.out.println("- " + pizza);
            }
        }
    }
}

class Pizza {
    private String name;

    public Pizza(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Task_3 {
    public static void main(String[] args) {
        Order order = new Order();
        Pizza pizza1 = new Pizza("Пепперони");
        Pizza pizza2 = new Pizza("Маргарита");

        Command addPizza1Command = new AddPizzaCommand(pizza1, order);
        Command addPizza2Command = new AddPizzaCommand(pizza2, order);

        addPizza1Command.execute();
        addPizza2Command.execute();

        order.print();

        Command cancelOrderCommand = new CancelOrderCommand(order);
        cancelOrderCommand.execute();

        order.print();

        cancelOrderCommand.undo();

        order.print();
    }
}