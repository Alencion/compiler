package hw01;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by eschough on 2019-09-02.
 */
public class NooToCTest {
    public static void main(String[] args) {
        String s = "";
        NooToC ntc = null;

//        String filePath = "C:/Users/user/Desktop/PLASLAB/test1.noo";
        String filePath = "test1.noo";
        try (FileInputStream fstream = new FileInputStream(filePath);) {
            byte[] rb = new byte[fstream.available()];
            while (fstream.read(rb) != -1) {}
            s = new String(rb);

            System.out.println("input : " + s);
        } catch (Exception e) {
            e.getStackTrace();
        }

        try (FileWriter fw = new FileWriter("test.c");) {
            ntc = new NooToC(fw, s);
            ntc.translate(ntc.next());
            fw.append("return 1;\n}\n");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
