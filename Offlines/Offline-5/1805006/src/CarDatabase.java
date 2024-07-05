import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
public class CarDatabase{
    public static void readFile(List<Car> l, String FileName)
    {
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(FileName));
            String temp[];
            while (true) {
                line = br.readLine();
                if (line == null) break;

                //System.out.println(line);

                temp =line.split(",");
                Car c = new Car (temp[0], Integer.parseInt(temp[1]),temp[2],temp[3],temp[4],temp[5],temp[6], Integer.parseInt(temp[7]) );

//                System.out.println(c);
//                for(String s: temp){
//                    System.out.print(s+", ");
//                }
//                System.out.println();

                l.add(c);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void writeFile(List<Car> l, String FileName){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FileName));
            for(Car c: l){
                String temp = c.toString();
                bw.write(temp);
                bw.write("\n");
            }

            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
