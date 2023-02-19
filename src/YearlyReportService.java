import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class YearlyReportService {

    public void getReport(Map<String, List<YearlyReport>> report) {
        List<YearlyReport> reports = new ArrayList<>();
        List<String> strings = readFileContents("resources/y.2021.csv");
        for (int i = 1; i < strings.size(); i++) {
            String[] split = strings.get(i).split(",");
            YearlyReport yearlyReport = new YearlyReport();
            yearlyReport.setMonth(Integer.parseInt(split[0]));
            yearlyReport.setAmount(Integer.parseInt(split[1]));
            yearlyReport.setIs_expense(split[2].equalsIgnoreCase("true"));
            reports.add(yearlyReport);
        }
        report.put("y.2021.csv", reports);
        System.out.println(report);
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
