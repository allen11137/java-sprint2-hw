import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        printMenu();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine().trim();
            Service service = new Service();
            if ("1".equals(command)) {
                service.getAllMonthReport();
            } else if ("2".equals(command)) {
                service.getYearlyReport();
            } else if ("3".equals(command)) {
                service.compareReports();
            } else if ("4".equals(command)) {
                service.printAllMonthlyReport();
            } else if ("5".equals(command)) {
                service.printYearlyReport();
            } else if ("6".equals(command)) {
                System.out.println("Вы вышли из программы");
                return;
            } else {
                System.out.println("Введена неверная команда");
            }
        }

    }

    private static void printMenu() {
        System.out.println("1 - Считать все месячные отчёты\n" +
                "2 - Считать годовой отчёт\n" +
                "3 - Сверить отчёты\n" +
                "4 - Вывести информацию о всех месячных отчётах\n" +
                "5 - Вывести информацию о годовом отчёте\n" +
                "6 - exit\n" +
                "Введите число соответсвующее требуемому действию:");
    }
}