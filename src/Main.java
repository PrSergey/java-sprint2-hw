
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        MonthReport monthData = new MonthReport();
        YearlyReport yearData=new YearlyReport();
        KeepFile dataSave=new KeepFile();
        HashMap<Integer, String> allMonth;
        List<String> year;
        boolean monthCheck=false;
        boolean yearCheck=false;


        while (true) {
            printMenu();
            int command= scanner.nextInt();
            if (command == 1) {
                dataSave.saveFileMonth();
               allMonth=dataSave.allMonth;
                for (Integer month: allMonth.keySet()) {
                    monthData.addMonth(month, allMonth.get(month));
                }
                monthCheck=true;
                System.out.println("Данные из месячного отчета считаны.");
            } else if (command == 2) {
                dataSave.saveFileYears();
                year=dataSave.year;
                for (int i=0; i<year.size(); i++) {
                    yearData.addYear(year.get(i));
                }
                yearCheck=true;
                System.out.println("Данные из годового отчета считаны.");

            } else if (command == 3) {
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

            } else if (command == 4) {
                if (monthCheck) {
                    for (int i = 0; i < 3; i++) {
                        monthData.infoMonthExpenses(i);
                        monthData.infoMonthInCome(i);
                    }
                }else{
                    System.out.println("Не считан месячный отчет" );
                }

            } else if (command == 5) {
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
            }else if (command==0){

                break;
            } else {
                System.out.println("Данной команды нет.");

            }
        }
    }
    public static void printMenu(){
        System.out.println("Что вы хотиете сделать?");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }



}