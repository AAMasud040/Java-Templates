package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

class player{
    String date;
    String name;
    int ballsface;
    int score;

    public player(String date, String name, int ballsface, int score) {
        this.date = date;
        this.name = name;
        this.ballsface = ballsface;
        this.score = score;
    }

}
public class FileHandlingAssignment {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<player> p = new ArrayList<>();

        Scanner s = new Scanner(new FileInputStream(new File("input.txt")));

        System.out.println(s.next());
        System.out.println(s.next());
        System.out.println(s.next());
        System.out.println(s.next());

        while (s.hasNext()) {
            String date = s.next();
            String name = s.next();;
            String balls_faced = s.next();;
            String score = s.next();;
            //System.out.println("Name: "+ name +" Balls Face: "+balls_faced+" Score: "+score);
            p.add( new player(date,name,Integer.parseInt(balls_faced),Integer.parseInt(score)) );
        }
        Scanner sc = new Scanner(System.in);
        String n = sc.next();

        int len = p.size();
        System.out.println(p.size());
        String h_score_name =null;
        int matches = 0;
        int personalh = 0;
        int highest = 0;
        double average = 0.00;

        for (int i =0;i<len;i++)
        {
            if((p.get(i).score)>highest)
            {
                h_score_name = (p.get(i).name);
                highest = (p.get(i).score);
            }
            if((p.get(i).name).equals(n))
            {
                matches++;
                if(personalh<(p.get(i).score))
                {
                    personalh = (p.get(i).score);
                }
                average += (p.get(i).score);
            }
        }

        System.out.println(h_score_name+" "+highest);
        System.out.println(n+" "+personalh+" "+matches+" "+average/matches);

        FileHandlingOutput fo = new FileHandlingOutput("output_for_tom.txt");

        fo.WriteLine(n+" "+personalh+" "+matches+" "+average/matches);
        fo.WriteLine(h_score_name+" "+highest);
        fo.closeAll();
    }
}
