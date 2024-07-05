import java.util.Random;
import java.util.Scanner;

class ParallelMax implements Runnable {
    Thread t;
    private int begin;
    private int end;
    private int max;
    private int arr[];
    public int getMax(){
        return max;
    }
    ParallelMax(int a[], int begin, int end) {
        this.begin = begin;
        this.end = end;
        this.max = 0;
        this.arr = a;
        t = new Thread(this);
        t.start();
    }
    public void run()
    {
        System.out.println("Parallel Max Thread Start");
        max = arr[begin];
        for(int i = begin+1;i<end;i++)
        {
            if(max < arr[i])
            {
                max = arr[i];
            }
        }
        System.out.println("Parallel Max Thread End, Parallel Max = " + max);
    }
}

class Max implements Runnable
{
    int max;
    Thread t;
    ParallelMax [] P;
    public Max(ParallelMax a[]){
        max = 0;
        P=a;
        t = new Thread(this);

    }

    public void run(){
        max = P[0].getMax();
        System.out.println("Final Max Thread Start");
        for(int i=1;i<5;i++)
        {
            if(max<P[i].getMax())
            {
                max = P[i].getMax();
            }
        }
        System.out.println("Final Max Thread End: Max =" + max);
    }
    public int finalMax()
    {
        return max;
    }

}

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int n;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int [] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = random.nextInt();
            numbers[i]=in.nextInt();
        }

        ParallelMax [] parallelMax = new ParallelMax[5];
        parallelMax[0] = new ParallelMax(numbers, 0, n/5);
        parallelMax[1] = new ParallelMax(numbers, n/5, 2*(n/5));
        parallelMax[2] = new ParallelMax(numbers, 2*(n/5), 3*(n/5));
        parallelMax[3] = new ParallelMax(numbers, 3*(n/5), 4*(n/5));
        parallelMax[4] = new ParallelMax(numbers, 4*(n/5), n);

        try {
            for(int i = 0 ;i<parallelMax.length;i++)
            parallelMax[i].t.join();
        }catch(InterruptedException e)
        {
            System.out.println("Exception");
        }
        Max m = new Max (parallelMax);
        m.t.start();
//        int ans = parallelMax[0].getMax();
        //System.out.println(parallelMax[0].getMax());
//        for(int i = 1; i < 5; i++)
//        {
//            //System.out.println(parallelMax[i].getMax());
//            if(ans< parallelMax[i].getMax())
//            {
//                ans = parallelMax[i].getMax();
//            }
//        }
        try {
            m.t.join();
        }catch(InterruptedException e)
        {
            System.out.println("Exception");
        }
        System.out.println(m.finalMax());

        // your code here
    }
}