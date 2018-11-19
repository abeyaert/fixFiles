import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ThreadFix implements Runnable {
    String file;
    List<String> lines = new ArrayList<String>();
    String line = null;

    public ThreadFix(String file) {
        this.file = file;
    }


    private synchronized void doIt(String file) {
        try {
            File f1 = new File(file);
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if (!line.contains("CPU usage"))
                    lines.add(line);
            }
            fr.close();
            br.close();

            FileWriter fw = new FileWriter(f1);
            BufferedWriter out = new BufferedWriter(fw);
            for(String s : lines)
                out.write(s);
            out.flush();
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        doIt(file);
    }
}
