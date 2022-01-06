//package bus;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.io.*;
//
//
//
//public class ReadData {
//	public static void main(String[] args) {
//		try {
//	        BufferedReader readTxt=new BufferedReader(new FileReader(new File("d:/text.txt")));
//	        String textLine ="";
//	        String str="";
//	        ArrayList<String[]> txtList =new ArrayList<String[]>(); 
//	        while((textLine=readTxt.readLine())!=null){
//	        	String[] numberArray=textLine.split(",");
//	        	txtList.add(numberArray);
//	  //zifu      	str+=" "+ textLine;
//	        }
//	 //       String[] numberArray=str.split(",");
//	//        System.out.println(Arrays.deepToString(txtList.toArray()));
//	        for(int i = 0;i<txtList.size();i++)
//	        	System.out.println(txtList.get(i)[1]);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//
//     }
//}
