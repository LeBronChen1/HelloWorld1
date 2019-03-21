package main.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HelloJython {
    public static float duliangjuzhen_t(float[] s1 ,float[] s2){
        float [][] matrix_t=new float[1][1];
        String s="";
        String t="";
        for(int i=0;i<s1.length;i++) {
            if (i < s1.length - 1) {
                s = s + s1[i] + ",";
            } else if (i == s1.length - 1) {
                s += s1[i];
            }
        }
        for(int i=0;i<s2.length;i++) {
            if (i < s2.length - 1) {
                t = t + s2[i] + ",";
            } else if (i == s2.length - 1) {
                t += s2[i];
            }
        }
        try{
            System.out.println(s);
            System.out.println(t);
            Process pr = Runtime.getRuntime().exec("python H:/Python/web/DTW1.py "+s+" "+t);
            System.out.println("python H:/Python/web/DTW1.py "+s1[0]+" "+s2[0]);
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(pr.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                float k=Float.parseFloat(line);
                matrix_t[0][0]=k;
            }
            in.close();
            pr.waitFor();
            System.out.println("end");
        } catch (Exception e){
            e.printStackTrace();
        }
        return matrix_t[0][0];
    }
    /*public static void simubtn_Click_1(int WT1, int WT2, int W1P, int W2P, String filename, int[] SY, int num) {
        *//*float WT1P=(float)W1P/100;
        float WT2P=(float)W2P/100;*//*
        String s="";
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
            while((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            pr.waitFor();
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    public static void main(String[] args){
        /*float[] s1={1,2,3,4,5};
        float[] s2={9,8,7,6};
        System.out.print(duliangjuzhen_t(s1,s2));*/
        int WT1=1,WT2=3,W1P=70,W2P=30;
        String filename="H:/Python/web/weather.xls";
        int[] SY={1991,1992,1993};
        int num=3;
        int[] year;
        year= DistanceMatrix.simubtn_Click_1(WT1,WT2,W1P,W2P,filename,SY,num);
        for(int i=0;i<num;i++){
            System.out.println(year[i]);
        }
    }
}
