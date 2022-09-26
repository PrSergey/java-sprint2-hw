
public class RuntimeEngine {


    public void check(MonthReport monthData, YearlyReport yearData, boolean monthCheck, boolean yearCheck) {
        if (monthCheck&&yearCheck){
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
        }else if (monthCheck){
            System.out.println("Не считан годовой отчет");
        }else if (yearCheck){
            System.out.println("Не считан месячный отчет");
        }else {
            System.out.println("Не считаны отчеты");
    }
}

    public void infoMonth (MonthReport monthData, boolean monthCheck){
        if (monthCheck) {
            for (int i = 0; i < 3; i++) {
                monthData.infoMonth(i);
            }
        }else{
            System.out.println("Не считан месячный отчет" );
        }
    }

    public void infoYear (YearlyReport yearData, boolean yearCheck){
        if (yearCheck) {
            int profit=0;
            int sumExpenses=0;
            int sumInCome=0;
            for (int i = 1; i <4; i++) {
                int expenses=yearData.data.get(i).expenses;
                int inCome=yearData.data.get(i).income;
                profit=inCome-expenses;
                System.out.println("Прибыль за " +i+" месяц составила "+profit);
                sumExpenses+=expenses;
                sumInCome+=inCome;
            }
            System.out.println("Средний расход за месяц составил " +(sumExpenses/3));
            System.out.println("Средний доход за месяц составил " +(sumInCome/3));
        }else{
            System.out.println("Не считан годовой отчет" );
        }

    }



    }
