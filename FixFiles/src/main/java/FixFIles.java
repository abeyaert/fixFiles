

public class FixFIles {
    public static void main(String args[]) {
        String[] paths = {"path1","path2","path3","path4"};

        Thread[] myThreads = new Thread[3];
        for (int i = 0; i < myThreads.length; i++)
        {
            Thread myThread = new Thread(new ThreadFix(paths[i]));
            myThread.start();
        }

    }
}
