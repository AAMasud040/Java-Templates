package sample;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class assignment1javatheory {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(//reading file
                    new InputStreamReader(
                            new FileInputStream(
                                    new File(
                                            "input6.txt"
                                    )
                            )
                    )
            );
            String str = br.readLine();
            while(str != null)//buffered reader returns null at the end of a file
            {
                Scanner sc = new Scanner(str);// for seperating token from the line read.
                PrintWriter pw = new PrintWriter(
                        new BufferedWriter(
                                new FileWriter(
                                        new File("output6.txt"),//appending set to true
                                        true
                                )
                        )
                );
                while(sc.hasNext())//seperating token from the line read.
                {
                    String token = sc.next();//token of  a whole string


                    int floatflag =0;
                    String regexfloat="([0-9]+[.][0-9]+)";//float pattern
                    Pattern pattern=Pattern.compile(regexfloat);
                    Matcher matcher=pattern.matcher(token);


                    while(matcher.find())//checks if float match is found using builtin function
                    {
                        floatflag = 1;//sets flag to 1
                        String floatnum = matcher.group();
                        System.out.println(floatnum);
                        float num = Float.parseFloat(floatnum);
                        pw.print(num);
                        pw.flush();
                        pw.print("\t");
                        pw.flush();
                    }
                    if(floatflag != 1) {//checks if a float match is found if not then checks integer
                        // I defined float flag
                        String regexint="([0-9]+)";//Integer pattern

                        Pattern pattern1=Pattern.compile(regexint);
                        Matcher matcher1=pattern1.matcher(token);

                        while(matcher1.find())//checks if match for integer is found
                        {
                            String intnum = matcher1.group();
                            System.out.println(intnum);//printing the whole group matching pattern
                            int num = Integer.parseInt(intnum);
                            pw.print(num);
                            pw.flush();
                            pw.print("\t");
                            pw.flush();
                        }
                    }

                }
                pw.println("");
                pw.close();
                str = br.readLine();//reading next line
            }
            br.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}