import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class KeepFile {
    public HashMap<Integer, String> allMonth = new HashMap<>();
    public List<String> year = new ArrayList<>();


    public void  saveFileMonth() {


        String path = "resources";
        File dir = new File(path);
        List<File> lst = new ArrayList<>();
        for (File file : dir.listFiles()) {
            if (file.isFile())
                lst.add(file);
        }


        for (int i = 0; i < lst.size(); i++) {
            int month=0;
            File name=lst.get(i);
            String element =name.getName();
            String[] parts = element.split("/");
            String fileMonth = "resources/"+element;
            String [] partWithName = parts[0].split("\\.");
            String monthOrYear = partWithName[0];
            String numberMonth=partWithName[1];
            if (monthOrYear.equals("m")) {
                String[] partName = numberMonth.split("2021");
                month = Integer.parseInt(partName[1]);
            allMonth.put(month, fileMonth);
            }



        }


    }
    public void  saveFileYears() {

        String path = "resources";
        File dir = new File(path);
        List<File> lst = new ArrayList<>();
        for (File file : dir.listFiles()) {
            if (file.isFile())
                lst.add(file);
        }

        for (int i = 0; i < lst.size(); i++) {
            File name=lst.get(i);
            String element =name.getName();
            String[] parts = element.split("/");
            String fileMonth = "resources/"+element;
            String [] partWithName = parts[0].split("\\.");
            String monthOrYear = partWithName[0];
            if (monthOrYear.equals("y")) {
                year.add(fileMonth);
            }



        }


    }
}
