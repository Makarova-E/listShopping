import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> products = Arrays.asList("Молоко", "Хлеб", "Сыр", "Сырные палочки",
                "Колбаса", "Сырки");
        List<String> orderProducts = new ArrayList<>();

        while (true) {
            int operationNumber = 0;
            int numberOfProduct = 0;

            printOperation();
            String input = scanner.nextLine();
            operationNumber = Integer.parseInt(input);

            switch (operationNumber) {
                case 1:
                    System.out.println("Какую покупку хотите добавить?");
                    input = scanner.nextLine();
                    numberOfProduct = Integer.parseInt(input);
                    orderProducts.add(products.get(numberOfProduct));
                    System.out.println("Итого в списке покупок: " + orderProducts.size());
                    break;
                case 2:
                    listShopping(orderProducts);
                    break;
                case 3:
                    listShopping(orderProducts);
                    System.out.println("Какую хотите удалить? Введите номер или название");
                    input = scanner.nextLine();
                    try {
                        numberOfProduct = Integer.parseInt(input);
                        String removeProduct = orderProducts.get(numberOfProduct - 1);
                        orderProducts.remove(numberOfProduct - 1);
                        System.out.println("Покупка \"" + removeProduct + "\" удалена");
                        listShopping(orderProducts);

                    } catch (Exception e) {
                        if (orderProducts.contains(input)) {
                            orderProducts.remove(input);
                            System.out.println("Покупка \"" + input + "\" удалена");
                            listShopping(orderProducts);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Введите текст для поиска:");
                    input = scanner.nextLine();
                    System.out.println("Найдено:");
                    for (int i = 0; i < orderProducts.size(); i++) {
                        if (orderProducts.get(i).toLowerCase().contains(input.toLowerCase())) {
                            System.out.println(i + 1 + ". " + orderProducts.get(i));
                        }
                    }
            }
        }
    }

    public static void printOperation() {
        System.out.println("Выберите операцию:");
        System.out.println("1. Добавить");
        System.out.println("2. Показать");
        System.out.println("3. Удалить");
        System.out.println("4. Поиск покупок");
        System.out.println("");
    }

    public static void listShopping(List<String> list) {
        System.out.println("Список покупок:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ". " + list.get(i));
        }
        System.out.println("");
    }
}
