package App.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class SequenceGenerator
{
    public static void generateSequence(String sequenceType, int elementsCount, int radCount){
        File folder = new File("sequences/");
        if (!folder.exists()) {
            folder.mkdir();
        }

        switch (sequenceType) {
            case "Up"     : _ups(elementsCount, radCount); break;
            case "Down"   : _dns(elementsCount, radCount); break;
            case "Random" : _rms(elementsCount, radCount); break;
            case "Repeatable" : _res(elementsCount, radCount); break;
        }
        System.out.println("Generation done");
    }

    private static void _res (int elementsCount, int radCount) {
        String fileName = ("sequences/"+elementsCount+"-"+radCount+".res");

        PrintWriter writer = null;
        try {writer = new PrintWriter(fileName, "UTF-8"); }
        catch (FileNotFoundException | UnsupportedEncodingException e) { e.printStackTrace(); }
        int[] sequence = new int[elementsCount];
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < elementsCount; ++i) {
            writer.print(random.nextInt(Constants.MAX_ELEMENTS) % (elementsCount / 2 + 1) + " ");
            //writer.print(sequence[i] = (int) (i+Math.pow(10, radCount-1))% (elementsCount / 2 + 1));
        }

        writer.close();
    }

    private static void _ups(int elementsCount, int radCount) {
        String fileName = ("sequences/"+elementsCount+"-"+radCount+".ups");

        PrintWriter writer = null;
        try { writer = new PrintWriter(fileName, "UTF-8"); }
        catch (FileNotFoundException | UnsupportedEncodingException e) { e.printStackTrace(); }

        int[] sequence = new int[elementsCount];

        Random random = new Random(System.currentTimeMillis());
        int limit = Constants.MAX_ELEMENTS / elementsCount;

        sequence[0] =(int) Math.pow(10, radCount-1);
        sequence[elementsCount-1] =(int) Math.pow(10, radCount)-1;
       float d=(float)(sequence[elementsCount-1]-sequence[0])/(elementsCount-1);

        writer.print(sequence[0] + " ");
        for(int i = 1; i < elementsCount; ++i) {
           /* if (radCount == 1) {
                sequence[i] = i+1;
                writer.print(sequence[i] + " ");
            }else{
                sequence[0] =(int) Math.pow(10, radCount-1);
                sequence[i] = (int) (i+Math.pow(10, radCount-1));
                writer.print(sequence[i] + " ");
            }
            */
            sequence[i] =(int)(sequence[0] +d*(i-1));
            writer.print(sequence[i] + " ");
        }
        writer.close();
    }

    private static void _dns(int elementsCount, int radCount) {
        String fileName = ("sequences/"+elementsCount+"-"+radCount+".dns");

        PrintWriter writer = null;
        try { writer = new PrintWriter(fileName, "UTF-8"); }
        catch (FileNotFoundException | UnsupportedEncodingException e) { e.printStackTrace(); }

        int[] sequence = new int[elementsCount];

        Random random = new Random(System.currentTimeMillis());

        //sequence[0] = random.nextInt(Constants.MAX_ELEMENTS);
       // sequence[0] =(int) (9*Math.pow(10, radCount-1)-1);
        sequence[0] =(int) Math.pow(10, radCount)-1;
        sequence[elementsCount-1] =(int) Math.pow(10, radCount-1);
        float d=(float)(sequence[elementsCount-1]-sequence[0])/(elementsCount-1);

        writer.print(sequence[0] + " ");
        for(int i = 1; i < elementsCount; ++i) {

            //sequence[i] = sequence[0]-i;
            sequence[i] =(int)(sequence[0] +d*(i-1));
            writer.print(sequence[i] + " ");
        }

        writer.close();
    }

    private static void _rms(int elementsCount, int radCount) {
        String fileName = ("sequences/"+elementsCount+"-"+radCount+".rms");

        PrintWriter writer = null;
        try { writer = new PrintWriter(fileName, "UTF-8"); }
        catch (FileNotFoundException | UnsupportedEncodingException e) { e.printStackTrace(); }

        Random random = new Random(System.currentTimeMillis());
        int p=(int)Math.pow(10, radCount-1);
        int p1=(int)Math.pow(10, radCount);

        for(int i = 0; i < elementsCount; ++i) {

           writer.print(p+random.nextInt(p1-p) + " ");

           // writer.print(random.nextInt (9*Math.pow(10, radCount-1)-1) + " "));
            // writer.print(s + " ");
        }

        writer.close();
    }
}
