package main.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DistanceMatrix {
    public static int[] simubtn_Click_1(int WT1, int WT2, int W1P, int W2P, String filename, int[] SY, int num) {
        /*float WT1P=(float)W1P/100;
        float WT2P=(float)W2P/100;*/
        String s="";
        String t;
        int []year=new int[num];
        float[] ResultList=new float[num];
        for(int i=0;i<SY.length;i++) {
            if (i < SY.length - 1) {
                s = s + SY[i] + ",";
            } else if (i == SY.length - 1) {
                s += SY[i];
            }
        }
        try{
            System.out.println(s);
            Process pr = Runtime.getRuntime().exec("python H:/Python/web/DistanceMatrixFor.py "+WT1+" "+WT2+" "+W1P+" "+W2P+" "+filename+" "+s+" "+num);
            System.out.println("python H:/Python/web/DistanceMatrixFor.py "+WT1+" "+WT2+
                    " "+W1P+" "+W2P+" "+filename+" "+s+" "+num);
            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line;
            String[] line1;
            while((line = in.readLine()) != null) {
                line=(line.replace("[","")).replace("]","");
                line1=line.split(",");
                for(int i=0;i<line1.length;i++){
                    year[i]=(int)Float.parseFloat(line1[i]);
                }
            }
            in.close();
            pr.waitFor();
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return year;
    }
}