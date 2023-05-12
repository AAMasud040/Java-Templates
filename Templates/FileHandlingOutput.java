package sample;

import java.io.FileInputStream;
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
        pw.write(line+'\n');
        pw.flush();
    }

    void WriteChar(char c)
    {
        pw.print(c);
        pw.flush();
    }

    void closeAll()
    {
        try {

            pw.close();
            fos.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    void fileCopy(String src,String dest)
    {
        String source = src;//"exe_src/qbittorrent_4.3.3_x64_setup.exe";
        String destination = dest;//"exe_dest/qbit.exe";
        try{
            FileInputStream in = new FileInputStream(source);
            FileOutputStream out = new FileOutputStream(destination);
            while (true) {
                int c = in.read();
                if (c == -1) break;
                out.write(c);
            }
            in.close();
            out.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
