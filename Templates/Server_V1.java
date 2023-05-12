package com.company;


import javax.xml.crypto.Data;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;


public class Server_V1 {
    private static byte[] intToBytes(final int data) {
        return new byte[] {
                (byte)((data >> 24) & 0xff),
                (byte)((data >> 16) & 0xff),
                (byte)((data >> 8) & 0xff),
                (byte)((data >> 0) & 0xff),
        };
    }
    static int fromByteArray(byte[] bytes) {//(copied intToBytes from -> )https://javadeveloperzone.com/java-basic/java-convert-int-to-byte-array/
        return ((bytes[0] & 0xFF) << 24) |
                ((bytes[1] & 0xFF) << 16) |
                ((bytes[2] & 0xFF) << 8 ) |
                ((bytes[3] & 0xFF) << 0 );
    }

    public static void FileSender()
    {
        try{
            ServerSocket ss=new ServerSocket(6666);
            Socket s=ss.accept();//establishes connection
            FileInputStream fs = new FileInputStream("C:\\Users\\Razon\\Desktop\\RLbook2020_sutton_barto.pdf");
            int size = fs.available();
            //System.out.println("Size of file from FIS: "+size);
            BufferedInputStream bis=new BufferedInputStream(fs);
            //ArrayList<Byte> arrayList = new ArrayList<Byte>();
            byte[] b = new byte[size];//Arraylist
            //System.out.println("Size of Byte Array: "+b.length);
            int ch;
            int i=0;
            while((ch=bis.read())!=-1){
                //System.out.println("Reading");
                b[i]=(byte)ch;
                i++;
            }
            System.out.println(i);
            //System.out.println(arrayList.size());
            OutputStream os = s.getOutputStream();
            os.write(b,0,i);
            os.flush();
            os.close();
            s.close();
            ss.close();
        }catch(Exception e){System.out.println(e);}
    }

    public static void FileSizeSender(int size)
    {
        try {
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();
            byte [] b = intToBytes(size);
            OutputStream os = s.getOutputStream();
            os.write(b);
            os.flush();
            os.close();
            s.close();
            ss.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        FileSender();// receiver not dynamic yet need manually make the client_V1 FileReceiver byte size greater or equal to file size.
        /*try {
            FileInputStream fs = new FileInputStream("C:\\Users\\Razon\\Desktop\\RLbook2020_sutton_barto.pdf");
            int size = fs.available();
            System.out.println("size of file selected: "+ size);
            FileSizeSender(size);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}