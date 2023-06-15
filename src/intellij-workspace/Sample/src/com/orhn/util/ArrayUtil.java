package com.orhn.util;

import java.util.Random;

public class ArrayUtil {

    private ArrayUtil()
    {

    }
    public static void swap(int [] a, int i, int k)
    {
        int temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }

    public static void swap(char [] a, int i, int k)
    {
        char temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }

    public static void fillRandomArray(Random r, int [] a, int min, int bound)
    {
        for(int i = 0; i < a.length; ++i)
            a[i] = r.nextInt(min, bound);
    }

    public static int [] join(int [] a, int [] b)
    {
        int [] result = new int[a.length + b.length];

        int idx = 0;

        for (int val : a)
            result[idx++] = val;

        for (int val : b)
            result[idx++] = val;

        return result;
    }

    public static int [] getRandomArray(Random r, int count, int min, int bound)
    {
        int [] a = new int[count];
        fillRandomArray(r, a, min, bound);
        return a;
    }

    public static int [][] getRandomMatrix(Random r, int m, int n, int min, int max)
    {
        int [][] a = new int[m][];

        for (int i = 0; i < m; ++i)
            a[i] = getRandomArray(r, n, min, max);

        return a;
    }

    public static int[][] getRandomSquareMatrix(Random r, int n, int min, int max)
    {
        return getRandomMatrix(r, n, n, min, max);
    }

    public static void addBy(int [] a, int val)
    {
        for (int i = 0; i < a.length; ++i)
            a[i] += val;
    }

    public  static int sumDiagonal(int [][] a)
    {
        int total = 0;

        for (int i = 0; i < a.length; i++) {
            total += a[i][i];
        }

        return total;
    }

    public static int sum(int [] a)
    {
        int total = 0;

        for (int val : a)
            total += val;

        return total;
    }

    public static int sum(int [][] a)
    {
        int total = 0;

        for (int i = 0; i < a.length; i++) {
            total += sum(a[i]);
        }

        return total;
    }

    public  static int [][] transpose(int [][] a)
    {
        int [][] result = new int[a[0].length][a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                result[j][i] = a[i][j];
            }
        }

        return result;
    }

    private static void bubbleSortAscending(int [] a)
    {
        for (int i = 0; i < a.length -1; ++i)
            for (int k = 0; k < a.length -1 -i; ++k)
                if(a[k] > a[k + 1])
                    swap(a, k, k+1);
    }

    private static void bubbleSortDescending(int [] a)
    {
        for (int i = 0; i < a.length -1; ++i)
            for (int k = 0; k < a.length -1 -i; ++k)
                if(a[k] < a[k + 1])
                    swap(a, k, k+1);
    }

    public static void bubbleSort(int [] a)
    {
        bubbleSort(a, false);
    }
    public static void bubbleSort(int [] a, boolean descending)
    {
        if(descending)
            bubbleSortDescending(a);
        else
            bubbleSortAscending(a);
    }

    private  static void selectionSortAscending(int [] a)
    {
        int min, minIndex;

        for (int i = 0; i < a.length - 1; ++i){
            min = a[i];
            minIndex = i;

            for (int k = i + 1; k < a.length; ++k)
                if(min > a[k]) {
                    min = a[k];
                    minIndex = k;
                }

            a[minIndex] = a[i];
            a[i] = min;
        }
    }

    private  static void selectionSortDescending(int [] a)
    {
        int max, maxIndex;

        for (int i = 0; i < a.length - 1; ++i){
            max = a[i];
            maxIndex = i;

            for (int k = i + 1; k < a.length; ++k)
                if(max < a[k]) {
                    max = a[k];
                    maxIndex = k;
                }

            a[maxIndex] = a[i];
            a[i] = max;
        }
    }
    public static void selectionSort(int [] a)
    {
        selectionSort(a, false);
    }

    public static void selectionSort(int [] a, boolean descending)
    {
        if(descending)
            selectionSortDescending(a);
        else
            selectionSortAscending(a);
    }

    public static int partition(int [] a, int threshold)
    {
        int partitionIndex = 0;

        while (partitionIndex != a.length && a[partitionIndex] < threshold)
            ++partitionIndex;

        if(partitionIndex == a.length)
            return partitionIndex;

        for (int i = partitionIndex + 1; i < a.length; ++i)
            if(a[i] < threshold)
                swap(a, i, partitionIndex++);

        return partitionIndex;
    }

    public static int [] getHistogramData(int [] a, int n)
    {
        int []counts = new int[n+1];

        for(int val : a)
            ++counts[val];

        return counts;
    }

    public static void drawHistogram(int [] counts, int n, char ch)
    {
        int maxVal = max(counts);

        for (int i = 0; i < counts.length; ++i) {
            int nChar = (int)Math.floor(counts[i] * (double)n / maxVal);

            while (nChar-- > 0)
                System.out.print(ch);

            System.out.println();
        }
    }

    public static int max(int [] a)
    {
        int result = a[0];

        for (int i = 1; i < a.length; i++) {
            result = Math.max(result, a[i]);
        }

        return result;
    }

    public static int min(int [] a)
    {
        int result = a[0];

        for (int i = 1; i < a.length; i++) {
            result = Math.min(result, a[i]);
        }

        return result;
    }

    public static boolean isMatrix(int [][]a)
    {
        for (int i = 1; i < a.length; ++i)
            if(a[i].length != a[0].length)
                return false;

        return true;
    }

    public static boolean isSquareMatrix(int [][]a)
    {
        return isMatrix(a) && a.length == a[0].length;
    }

    public static void reverse(char [] a)
    {
        for (int i = 0; i < a.length / 2; ++i)
            swap(a, i, a.length - i - 1);
    }
    public static void reverse(int [] a)
    {
        for (int i = 0; i < a.length / 2; ++i)
            swap(a, i, a.length - i - 1);
    }

    public static void print(int [] a)
    {
        for (int i = 0; i < a.length; ++i)
            System.out.printf("%d ", a[i]);

        System.out.printf("%n---------------------------------------%n");
    }

    public static void print(int n, int [] a)
    {
        String fmt = String.format("%%0%dd ", n);

        for ( int ival : a)
            System.out.printf(fmt, ival);

        System.out.println();
    }

    public static void print(String [] s)
    {
        for(String str : s)
            System.out.println(str);
    }

    public static void print(int [][]a)
    {
        print(1, a);
    }

    public static void print(int n, int [][]a)
    {
        for (int[] array : a)
            print(n, array);
    }
}

