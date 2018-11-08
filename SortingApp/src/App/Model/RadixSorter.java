package App.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class RadixSorter
{
    private long time = 0;
    public long getTime() { return time; }

    private long exchanges = 0;
    public long getExchanges() { return exchanges; }

    private long comparison = 0;
    public long getComparison() { return comparison; }

    private long put = 0;

    public RadixSorter() { }

    public void sort(int[] input) throws Exception {

        time = 0;
        comparison = 0;
        exchanges = 0;

        long startTime = System.currentTimeMillis();

        final int RADIX = 10;
// Создаём пустые списки, число которых равно
// Количеству возможных значений одного разряда(RADIX)
        List<Integer>[] bucket = new ArrayList[RADIX];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<Integer>();
        }
//
        boolean maxLength = false;
        int tmp = -1, placement = 1;
        while (!maxLength) {
            maxLength = true;
// split input between lists
            for (Integer i : input) {
                tmp = i / placement;
                bucket[tmp % RADIX].add(i);
                exchanges++;
                if (maxLength && tmp > 0) {
                    maxLength = false;
                }
            }
// empty lists into input array
            int a = 0;
            for (int b = 0; b < RADIX; b++) {


                for (Integer i : bucket[b]) {

                    input[a++] = i;
                    exchanges++;

                }
                bucket[b].clear();
            }
// move to next digit
            placement *= RADIX;
        }

        long stopTime = System.currentTimeMillis();
        time = stopTime - startTime;
        exchanges-=input.length*2;
    }
}


