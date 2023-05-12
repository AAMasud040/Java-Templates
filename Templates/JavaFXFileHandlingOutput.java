package sample;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileHandlingOutput {
    FileOutputStream fos;
    PrintWriter pw;
    public FileHandlingOutput(String path) {
        try{
            fos = new FileOutputStream(path);
            pw = new PrintWriter(fos);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    void WriteLine(String line)
    {
        pw.write(line);
        pw.flush();
    }
    void WriteChar(char c)
    {
        pw.print(c);
        pw.flush();
    }

    void CloseAll()
    {
        try {

            pw.close();
            fos.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
