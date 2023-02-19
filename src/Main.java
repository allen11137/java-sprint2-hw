import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        printMenu();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int command = scanner.nextInt();
            Service service = new Service();
            switch (command) {
                case 1:
                    service.getAllMonthReport();
                    break;
                case 2:
                    service.getYearlyReport();
                    break;
                case 3:
                    service.compareReports();
                    break;
                case 4:
                    service.printAllMonthlyReport();
                    break;
                case 5:
                    service.printYearlyReport();
                    break;
                default:
                    System.out.println("Введена неверная команда");
                    break;
            }
        }

    }

    private static void printMenu() {
        System.out.println("1 - Считать все месячные отчёты\n" +
                "2 - Считать годовой отчёт\n" +
                "3 - Сверить отчёты\n" +
                "4 - Вывести информацию о всех месячных отчётах\n" +
                "5 - Вывести информацию о годовом отчёте\n" +
                "Введите число соответсвующее требуемому действию:");
    }
}