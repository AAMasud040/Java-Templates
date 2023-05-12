package sample;

public class Controller implements Runnable{
    String filename;
    Controller(String filename)
    {
        this.filename = filename;
    }

    @Override
    public void run() {
        FileHandlingInput fi = new FileHandlingInput(filename);
        boolean flag = true;
        String Str = "";
        while(flag)
        {
            Str = fi.readLine();
            if(Str == null)
            {
                flag = false;
                System.out.println("closing");
            }
            else
            {
                String name = Thread.currentThread().getName();
                System.out.println(name+"-> "+Str);
            }
        }
        fi.closeAll();
    }


    public static void main(String[] args) {
        /*Thread t = new Thread(new Controller("in.txt"));
        t.start();
        Thread t1 = new Thread(new Controller("in.txt"));
        t1.start();
        Thread t2 = new Thread(new Controller("in.txt"));
        t2.start();*/

        /*FileHandlingInput fi = new FileHandlingInput("in.txt");

        fi.closeAll();*/
        Thread t1 = new Thread(new Controller("in.txt"));
        Thread t2 = new Thread(new controller2("in.txt"));

        t1.start();
        t2.start();
        while (t2.isAlive())
        {
            try {
                t1.wait();
            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        System.out.println("Done");
    }

}

class controller2 implements Runnable{
    String filename;
    controller2(String filename)
    {
        this.filename = filename;
    }

    @Override
    public void run() {
        FileHandlingOutput fo = new FileHandlingOutput("out.txt");
        for(int i=0;i<100;i++)
        {
            fo.WriteLine(String.valueOf(i));
        }
        fo.closeAll();
    }
}
