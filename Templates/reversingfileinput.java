package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class reversingfileinput {
    public static void main(String[] args) {

        try{
            //creating a buffered reader that will read each line for a file
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(
                                    new File(
                                            "input3.txt"
                                    )
                            )
                    )
            );
            //loading the line read by buffered reader in a string to check for end condition
            String str = br.readLine();
            //buffered reader returns null at the end of a file
            while(str != null)
            {
                String x ="";

                ArrayList<String> s = new ArrayList<>();
                // for seperating token from the line read.
                Scanner sc = new Scanner(str);
                //seperating token from the line read.
                while(sc.hasNext())
                {
                    //adding each token to arraylist
                    s.add(sc.next());
                }
                //reading the arraylist in reverse Order
                for(int i= s.size()-1;i>=0;i--)
                {
                    // adding the last most inserted token to string x until
                    //the list is fully traversed
                    x += s.get(i)+" ";

                }
                System.out.println(x);
                //writing the string x to a file
                PrintWriter pw = new PrintWriter(
                  new BufferedWriter(
                          new FileWriter(
                                  //appending set to true
                                  new File("output3.txt"),
                                  true
                          )
                  )
                );

                pw.println(x);
                pw.close();

                str = br.readLine();//moving to nextline
            }
            br.close();


        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
