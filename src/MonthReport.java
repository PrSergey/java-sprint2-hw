import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class MonthReport {
    public List<MonthReportRecord> monthsStat = new ArrayList<>();
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
            String line = lines[i];
            String[] parts = line.split(",");
            String itemName = parts[0];
            boolean isExpense = Boolean.parseBoolean(parts[1]);
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


   public void infoMonthExpenses(int month) {
        int expenses=0;
        String category="";
        for (String cat: monthsStat.get(month).catToSpending.keySet()){
            int expense=monthsStat.get(month).catToSpending.get(cat);
            if (expense<expenses){
                expenses=expense;
                category=cat;
            }
        }
       System.out.println("В " +(month+1)+" месяце самая большая трата "+category+" составила "+Math.abs(expenses));
    }


    public void infoMonthInCome(int month) {
        int inCome=0;
        String category="";
        for (String cat: monthsStat.get(month).catToSpending.keySet()){
            int inComeCat=monthsStat.get(month).catToSpending.get(cat);
            if (inComeCat>inCome){
                inCome=inComeCat;
                category=cat;
            }
        }
        System.out.println("В " +(month+1)+" месяце самый прибыльный товар был в категории "+category+" и прибыль составила "+Math.abs(inCome));
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