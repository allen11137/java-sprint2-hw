import java.util.List;
import java.util.Map;

public class ReportsCompareService {

    public void compareReports(Map<String, List<MonthlyReport>> monthlyReports, Map<String, List<YearlyReport>> yearlyReport) {
        List<YearlyReport> reports = yearlyReport.get("y.2021.csv");
        for (YearlyReport yR : reports) {
            List<MonthlyReport> monthlyReport = monthlyReports.get("m.20210" + yR.getMonth() + ".csv");
            int expenses = 0;
            int income = 0;
            for (MonthlyReport mR : monthlyReport) {
                if (mR.isIs_expense()) {
                    expenses += mR.getSum_of_one() * mR.getQuantity();
                } else {
                    income += mR.getSum_of_one() * mR.getQuantity();
                }
            }

            if (!yR.isIs_expense() && yR.getAmount() == income) {
                System.out.println("Месяц " + yR.getMonth() + " сверка по доходам успешно пройдена");
            } else {
                System.out.println("Месяц " + yR.getMonth() + " сверка по доходам не пройдена");
            }

            if (yR.isIs_expense() && yR.getAmount() == expenses) {
                System.out.println("Месяц " + yR.getMonth() + " сверка по расходам успешно пройдена");
            } else {
                System.out.println("Месяц " + yR.getMonth() + " сверка по расходам не пройдена");
            }
        }
    }
}
