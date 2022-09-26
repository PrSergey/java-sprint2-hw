import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class MonthReport {
    public List<MonthReportRecord> monthsStat = new ArrayList<>();



    public void  addMonth(Integer month, String path) {
        String text = readFileContentsOrNull(path);
        if(text.equals(null)){
            System.out.println("Нет данных за "+month+" месяц");
            return;
        }
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


   public void infoMonth(int month) {
        int expenses=0;
        int inCome=0;
        String categoryExp="";
        String categoryInCome="";
        for (String cat: monthsStat.get(month).catToSpending.keySet()){
            int money=monthsStat.get(month).catToSpending.get(cat);
            if (money<expenses){
                expenses=money;
                categoryExp=cat;
            } else if (money>inCome) {
                inCome=money;
                categoryInCome=cat;
            }
        }
       System.out.println("В " +(month+1)+" месяце самая большая трата "+categoryExp+" составила "+Math.abs(expenses));
       System.out.println("В " +(month+1)+" месяце самый прибыльный товар был в категории "+categoryInCome+" и прибыль составила "+Math.abs(inCome));
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