

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
        RuntimeEngine checkMonth=new RuntimeEngine();


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
                checkMonth.check(monthData, yearData, monthCheck, yearCheck);


            } else if (command == 4) {
                checkMonth.infoMonth(monthData, monthCheck);


            } else if (command == 5) {
                checkMonth.infoYear(yearData, yearCheck);
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