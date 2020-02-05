package ru.gb.jtwo.lfive.online.threads;

public class MainClass {
    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];
    static float[] arr1 = new float[h];
    static float[] arr2 = new float[h];

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        singleThreadedCalc();

        long MultiThreadStartTime = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        Runnable r0 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr1.length; i++) {
                    arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        };

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr2.length; i++) {
                    arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        };

        Thread t1 = new Thread(r0, "Thread #1");
        t1.start();
        Thread t2 = new Thread(r1, "Thread #2");
        t2.start();

        t1.join();
        t2.join();

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        long MultiThreadEndTime = System.currentTimeMillis();

        System.out.println("Время, затраченное на обработку в 2 потока: " + (MultiThreadEndTime - MultiThreadStartTime));
    }

    static private void singleThreadedCalc() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Время, затраченное на обработку в 1 поток: " + (endTime - startTime));
    }
}

