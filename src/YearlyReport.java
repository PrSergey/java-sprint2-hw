import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class YearlyReport {
    public Map<Integer, YearlyReportRecord> data = new HashMap<>();



    public void addYear(String path) {
        String text = readFileContentsOrNull(path);
        if(text.equals(null)){
            System.out.println("Нет данных в годовом отчете");
            return;
        }
        String[] lines = text.split("\r?\n");
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(",");
            int month = Integer.parseInt(parts[0]);
            int amount = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);
            if (!data.containsKey(month)) {
                data.put(month, new YearlyReportRecord(month));
            }
            YearlyReportRecord mRecord = data.get(month);
            if (isExpense) {
                if (mRecord.expenses==0) {
                    mRecord.expenses += amount;
                }
            } else {
                if (mRecord.income==0) {
                    mRecord.income += amount;
                }
            }
        }
    }


    public int sumExpensesMonth(int month) {
        int expenses=0;
        expenses+=data.get(month).expenses;
        return expenses;
    }

    public int sumInComeMonth(int month) {
        int income=0;
        income+=data.get(month).income;
        return income;
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