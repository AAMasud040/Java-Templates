package com.company;

import java.io.*;
import java.net.Socket;

public class Client_V1 {
    static int fromByteArray(byte[] bytes) {//(copied fromByteArray from -> )https://javadeveloperzone.com/java-basic/java-convert-int-to-byte-array/
        return ((bytes[0] & 0xFF) << 24) |
                ((bytes[1] & 0xFF) << 16) |
                ((bytes[2] & 0xFF) << 8 ) |
                ((bytes[3] & 0xFF) << 0 );
    }

    public static void FileReceiver()
    {
        try{
            Socket s=new Socket("localhost",6666);
            InputStream is = s.getInputStream();
            FileOutputStream fos = new FileOutputStream("E:\\Netbeans Codes\\FileraccepterClient\\Client accepted folder\\RLbook.pdf");
            BufferedInputStream bis=new BufferedInputStream(is);
            byte[] b = new byte[306759426]; // array dynamic after using file size sender
            //ArrayList<Byte> by = new ArrayList<Byte>();
            //fs.read(b, 0, b.length);
            int ch;
            int i=0;
            while((ch=bis.read())!=-1){
                b[i]=(byte)ch;
                i++;
            }
            fos.write(b, 0, i);
            fos.close();
            is.close();

        }catch(Exception e){System.out.println(e);}
    }

    public static int FileSizeReceiver()
    {
        try {
            Socket s=new Socket("localhost",6666);
            InputStream is = s.getInputStream();
            byte[] b = is.readAllBytes();
            int x = fromByteArray(b);
            return x;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String args[])
    {
        FileReceiver();
        /*int size = FileSizeReceiver();
        System.out.println("File size: "+size);*/
    }
}
