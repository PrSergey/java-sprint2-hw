import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class YearlyReport {
    public HashMap<Integer, YearlyReportRecord> data = new HashMap<>();
    String path;
    public YearlyReport(){
        this.path=path;
    }

    public void addYear(String path) {
        String text = readFileContentsOrNull(path);
        String[] lines = text.split("\r?\n");
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i]; // "02,810000,false"
            String[] parts = line.split(","); // ["02", "810000", "false"]
            int month = Integer.parseInt(parts[0]); // 2
            int amount = Integer.parseInt(parts[1]); // 810000
            boolean isExpense = Boolean.parseBoolean(parts[2]); // false
            if (!data.containsKey(month)) {
                data.put(month, new YearlyReportRecord(month));
            }
            YearlyReportRecord mRecord = data.get(month);
            if (isExpense) {
                mRecord.expenses += amount;
            } else {
                mRecord.income += amount;
            }
        }
    }
    public int sumExpensesMonth() {
        int expenses=0;
        for(Integer year: data.keySet()){
            YearlyReportRecord stat=data.get(year);
            expenses+=stat.expenses;
        }
        return expenses;
    }



    public int calcSomeStatistics() {
        //....
        return 0;
    }

    private String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

}