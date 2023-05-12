package com.company;

import java.io.*;

public class FileHandlingInput {
    FileInputStream fis;
    BufferedInputStream bis;

    FileReader fr;
    BufferedReader br;

    public FileHandlingInput(String path) {
        try {
            //initializing file input objects

            fis = new FileInputStream(new File(path));
            bis = new BufferedInputStream(fis);

            fr = new FileReader(new File(path));
            br = new BufferedReader(fr);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    void readFileCharSOUT()//Prints Char
    {
        try {
            int i=0;
            while((i=fis.read())!=-1){
                System.out.print((char)i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void readLineSOUT()//Prints Line
    {
        try{

            System.out.println(br.readLine());

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    int readFileChar()//Returns Char
    {
        int ch = -1;
        try{
            ch = fis.read();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return  ch;
    }

    String readLine()//Returns Line
    {
        String s = null;
        try{

            s = br.readLine();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return  s;
    }

    int size() // returns File size in bytes
    {
        int Size = -1;
        try {
            fis.available();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Size;
    }



    void CloseAll()
    {
        try {
            fis.close();
            bis.close();
            fr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
