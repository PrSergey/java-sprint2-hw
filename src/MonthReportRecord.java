import java.util.HashMap;

public class MonthReportRecord {
    public int numberOfMonth;
    public HashMap<String, Integer> catToSpending = new HashMap<>();

    public MonthReportRecord(int numberOfMonth) {
        this.numberOfMonth = numberOfMonth;
    }

    public void addSpending(String category, int money) {
        if (catToSpending.containsKey(category)) {
            catToSpending.put(category, catToSpending.get(category) + money);
        } else {
            catToSpending.put(category, money);
        }
    }
}