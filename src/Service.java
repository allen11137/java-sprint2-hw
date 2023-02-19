import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {
    private MonthlyReportService monthlyReportService = new MonthlyReportService();
    private YearlyReportService yearlyReportService = new YearlyReportService();
    private ReportsCompareService reportsCompareService = new ReportsCompareService();

    private static Map<String, List<MonthlyReport>> monthlyReports = new HashMap<>();
    private static Map<String, List<YearlyReport>> yearlyReport = new HashMap<>();

    public void getAllMonthReport() {
        monthlyReportService.getReports(monthlyReports);
    }

    public void getYearlyReport() {
        yearlyReportService.getReport(yearlyReport);
    }

    public void compareReports() {
        reportsCompareService.compareReports(monthlyReports, yearlyReport);
    }

    public void printAllMonthlyReport() {
        for (int i = 1; i < 4; i++) {
            List<MonthlyReport> monthlyReports = Service.monthlyReports.get("m.20210" + i + ".csv");
            System.out.println("Месяц: " + i);
            int maxIncome = 0;
            int maxExpense = 0;
            String itemIncome = "";
            String itemExpenses = "";
            for (MonthlyReport mR : monthlyReports) {
                int summ = mR.getQuantity() * mR.getSum_of_one();
                if (!mR.isIs_expense() && maxIncome < summ) {
                    maxIncome = summ;
                    itemIncome = mR.getItem_name();
                }
                if (mR.isIs_expense() && maxExpense < summ) {
                    maxExpense = summ;
                    itemExpenses = mR.getItem_name();
                }
            }
            System.out.println("Самый прибыльный товар: " + itemIncome + ". Суммарный заработок: " + maxIncome);
            System.out.println("Самая большая трата: " + maxExpense + ". За " + itemExpenses);
        }
    }

    public void printYearlyReport() {
        System.out.println("Рассматриваемый год : 2021");
        List<YearlyReport> reports = yearlyReport.get("y.2021.csv");
        everyMonthProfit(reports);
        middleExpenses(reports);
        middleIncome(reports);
    }

    private void middleIncome(List<YearlyReport> reports) {
        int income = 0;
        for (YearlyReport y : reports) {
            if (!y.isIs_expense()) {
                income += y.getAmount();
            }
        }
        int middleExpense = income / reports.size();
        System.out.println("Средний доход за все месяцы в году: " + middleExpense);
    }

    private void middleExpenses(List<YearlyReport> reports) {
        int expenses = 0;
        for (YearlyReport y : reports) {
            if (y.isIs_expense()) {
                expenses += y.getAmount();
            }
        }
        int middleExpense = expenses / reports.size();
        System.out.println("Средний расход за все месяцы в году: " + middleExpense);
    }

    private void everyMonthProfit(List<YearlyReport> reports) {
        System.out.println("Прибыль по каждому месяцу.");
        int month = 0;
        int profit = 0;
        for (int i = 0; i < reports.size(); i++) {
            int m = reports.get(i).getMonth() - 1;
            if ((month != reports.get(i).getMonth() && month != 0)) {
                System.out.println("Месяц: " + m + ". Доход: " + profit);
                profit = 0;
            }
            month = reports.get(i).getMonth();
            if (!reports.get(i).isIs_expense()) {
                profit = reports.get(i).getAmount();
            } else {
                profit -= reports.get(i).getAmount();
            }
            if (i == reports.size() - 1) {
                System.out.println("Месяц: " + m + ". Доход: " + profit);
            }
        }
    }
}
