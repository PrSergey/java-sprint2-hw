import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        MonthReport monthData = new MonthReport();
        YearlyReport yearData=new YearlyReport();

           /* MonthReport mReportSecond = new MonthReport();
            MonthReport mReportThird = new MonthReport();*/
        /*YearlyReport yReport = new YearlyReport("resources/y.2021.csv");*/

        while (true) {
            printMenu();
            int command= scanner.nextInt();
            if (command == 1) {
                for (int i = 1; i < 4; i++) {
                    int month=i;
                    monthData.addMonth(i, "resources/m.20210"+i+".csv");

            }
                System.out.println("Что вы хотиете сделать?");


            } else if (command == 2) {
                yearData.addYear("resources/y.2021.csv");

            } else if (command == 3) {
               /* int expenses=mReportFirst.sumExpensesMonth()+mReportSecond.sumExpensesMonth()+mReportThird.sumExpensesMonth();
                int inCome=mReportFirst.sumInComeMonth()+mReportSecond.sumInComeMonth()+mReportThird.sumInComeMonth();
                int expensesYears=
                int inComeYears=mReportFirst.sumInComeMonth()+mReportSecond.sumInComeMonth()+mReportThird.sumInComeMonth();
*/
                System.out.println("Что вы хотиете сделать?");

            } else if (command == 4) {

            } else if (command == 5) {

            }else if (command==0){

                break;
            } else {


            }
        }



    }

    public static void month(){

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