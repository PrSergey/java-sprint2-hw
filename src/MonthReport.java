import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class MonthReport {
    public ArrayList<MonthReportRecord> monthsStat = new ArrayList<>();

    /*public HashMap<Integer, MonthReportRecord> data = new HashMap<>();*/
    String path;
    int month;
    public  MonthReport(){
        this.path=path;
        this.month=month;

    }

    public void  addMonth(Integer month, String path) {
        String text = readFileContentsOrNull(path);
        String[] lines = text.split("\r?\n");
        MonthReportRecord mdata = new MonthReportRecord(month);
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i]; // "Коньки,TRUE,50,2000"
            String[] parts = line.split(","); // ["Коньки", "TRUE", "50", "2000"]
            String itemName = parts[0]; // "Коньки"
            boolean isExpense = Boolean.parseBoolean(parts[1]); // false
            int quantity = Integer.parseInt(parts[2]);
            int sumOfOne = Integer.parseInt(parts[3]);
            int sumAll=quantity*sumOfOne;

             //180
            if (isExpense) {
               int expenses=-sumAll;
                mdata.addSpending(itemName, expenses);

            } else {
                mdata.addSpending(itemName, sumAll);

            }

        }
        monthsStat.add(mdata);
    }

    public int sumExpensesMonth(int month) {
        int expenses=0;
        for (Integer ex: monthsStat.get(month).catToSpending.values())
            if (ex<0)
        expenses+=Math.abs(ex);
        return expenses;
    }
    public int sumInComeMonth(int month) {
        int inCome=0;
        for (Integer ex: monthsStat.get(month).catToSpending.values())
            if (ex>0)
                inCome+=Math.abs(ex);
        return inCome;
    }
    /*ublic int sumInComeMonth() {
        int income=0;
        for(String category: data.keySet()){
            MonthReportRecord stat=data.get(category);
            income+=stat.income;
        }
        return income;
    }



    public int calcSomeStatistics() {
        //....
        return 0;
    }
*/
    private String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

}