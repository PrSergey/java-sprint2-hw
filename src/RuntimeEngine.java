
public class RuntimeEngine {
    MonthReport monthData = new MonthReport();
    YearlyReport yearData=new YearlyReport();

    public void check() {
        int inCome=0;
        int expense=0;
        for (int i = 0; i < 3; i++) {
            int expensesMonthOfYear=yearData.sumExpensesMonth(i+1);
            int expensesMonth=monthData.sumExpensesMonth(i);
            if(expensesMonthOfYear!=expensesMonth){
                System.out.println("В "+(i+1)+" месяце расходы внесены с ошибкой");
            }
            expense+=expensesMonthOfYear-expensesMonth;
        }
        for (int i = 0; i < 3; i++) {
            int inComeMonthOfYear=yearData.sumInComeMonth(i+1);
            int inComeMonth=monthData.sumInComeMonth(i);
            if(inComeMonthOfYear!=inComeMonth){
                System.out.println("В "+(i+1)+" месяце доходы внесены с ошибкой");
            }
            inCome+=inComeMonthOfYear-inComeMonth;
        }
        if (expense==0 && inCome==0){
            System.out.println("Проверка выполнена. Расхождение в отчетах не выявлено");
        }
    }
}
