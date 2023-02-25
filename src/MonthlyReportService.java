import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MonthlyReportService {


    public void getReports(Map<String, List<MonthlyReport>> reports) {
        for (int i = 1; i < 4; i++) {
            List<String> content = readFileContents("resources/m.20210" + i + ".csv");
            List<MonthlyReport> monthlyReports = new ArrayList<>();
            for (int y = 1; y < content.size(); y++) {
                String[] split = content.get(y).split(",");
                MonthlyReport monthlyReport = new MonthlyReport();
                monthlyReport.setItemName(split[0]);
                monthlyReport.setExpense(split[1].equalsIgnoreCase("true"));
                monthlyReport.setQuantity(Integer.parseInt(split[2]));
                monthlyReport.setSumOfOne(Integer.parseInt(split[3]));
                monthlyReports.add(monthlyReport);
            }
            reports.put("m.20210" + i + ".csv", monthlyReports);
        }
        System.out.println(reports);
    }

    List<String> readFileContents(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }
}
