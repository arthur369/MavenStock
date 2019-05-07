package com.arthur.tool;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.arthur.vo.Detail;;



public class ReadFile {
//	 static String path=".\\src\\text\\vars.ini";
	static String path="D:\\Stock\\StockList.csv";
	 
	 public static String getPath() {
		return path;
	}



	public static void setPath(String path) {
		ReadFile.path = path;
	}


public static String read(String readPath) {
		path=readPath;
		ArrayList<Detail>list=new ArrayList<Detail>();
		 String result="";
        try {
       	 String str;
       	 
       	  FileReader fr = new FileReader(path);  
            BufferedReader  br  =   new  BufferedReader(fr);
            
            StringBuffer buffer=new StringBuffer();
            while ((str = br.readLine()) != null) {
            	
            	buffer.append(str);
            	
            	
            }
            br.close();   
            fr.close();
            return buffer.toString();
        } catch(IOException e){
       	 return null;
       	 
        }
		
		
		
	}
	
	public static ArrayList<Detail> readFile() {
		
		ArrayList<Detail>list=new ArrayList<Detail>();
		 String result="";
        try {
       	 String str;
       	 
       	  FileReader fr = new FileReader(path);  
            BufferedReader  br  =   new  BufferedReader(fr);
            
            
            while ((str = br.readLine()) != null) {
            	 Detail detail=new Detail();
           	 if(str.substring(0, 1).equals("=")){
//           	 System.out.println(str);
           		for(int j=1;j<10;j++){
       			
       			 
       			 
       			 
       			 str=str.replaceAll(j+",", j+"");
       			 
       			
       			 
       		 }
           		 
           	String array[]=  str.split(",");
           	
           	
           	
           	
           	 for(int i=0;i<array.length;i++){
           		
           		 
//           		 
//           		 for(int j=1;j<10;j++){
//           			
//           			 
//           			 
//           			 
//           			 array[i]=array[i].replaceAll(j+",", j+"");
//           			 
//           			
//           			 
//           		 }
           		 
           		 
           		 array[i]=array[i].replace("=", "").replace("\"\"", "\"0\"").replace("\"", "");
           		 
           		 
           		 
//           		 System.out.print(array[i].replace("=", "").replace("\"", "")+" | ");
           	 }
           	 
//           	 System.out.println(array.toString());
           	 
           	 detail.setId(array[0]);
           	 detail.setPER(array[2]);
           	 detail.setYearProfit(array[3]);
           	 detail.setYearProfitPercent(array[4]);
           	 detail.setYearROE(array[5]);
           	 detail.setYearROEadd(array[6]);
           	 detail.setYearEPS(array[7]);
           	 detail.setYearEPSadd(array[8]);
           	 detail.setYearEPSpercent(array[9]);
           	 detail.setAsset(array[10]);
           	 detail.setDebt(array[11]);
           	 detail.setCapitalStock(array[12]);
           	 
           	 detail.setBossHave(array[13]);
           	 detail.setDividend(array[14]);
           	 detail.setPrice(array[15]);
           	 detail.setGPMadd(array[16]);
           	 detail.setGPM(array[17]);
           	 detail.setYield(array[18]);
//           	 System.out.println(detail.toString());
           	 list.add(detail);
           	
//           	 System.out.println();
           	 
           	 }
            }
            br.close();   
            fr.close();
            return list;
        } catch(IOException e){
       	 return null;
       	 
        }
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	//�閰Ｗ��銝�蝯�蝙�
	public static String readVar() {
		
		
		 String result="";
         try {
        	 String str;
        	 //debug
//        	 File tefile=new File(path);
//        	 System.out.println(tefile.getAbsolutePath());
        	 
        	 
//             FileReader fr = new FileReader("D:\\嚙諍南嚙衛抬蕭嚙褓佗蕭M嚙踝蕭\\conf\\vars.ini");
        	 
        	  FileReader fr = new FileReader(path);  
             BufferedReader  br  =   new  BufferedReader(fr);
//        	 InputStream fr = new ClassPathResource(path).getInputStream();	
//        	 BufferedReader br = new BufferedReader(new InputStreamReader(fr));
             
             
             
             while ((str = br.readLine()) != null) {
            	 
//            	 System.out.println(str);
//            	 System.out.println("str.indexOf(\"#\")<0 ="+ (str.indexOf("#")<0));
//            	 System.out.println("str.indexOf(text)>0 ="+(str.indexOf(text)>0));
//                 if(str.indexOf("#")<0 && str.indexOf(text)>=0) {
//                	 
////                	 System.out.println("-------------------true--------");
//               result= 	str.substring(str.indexOf("=")+1);
//                	 
//                	 
//                 }
            	 
            	 System.out.println(str);
            	 
             }
             br.close();   
             fr.close();
             return result;
         } catch(IOException e){
        	 return "";
        	 
         }
		
		
		
	}
	
	
	
	//�vars.ini瑼�閰Ｙ����������rrayList��
	public static ArrayList<String> readVarArrayList(String text){
		ArrayList<String> resultList=new ArrayList<String>();
//		 String result="";
         try {
        	 String str;
        	 
//             FileReader fr = new FileReader("D:\\嚙諍南嚙衛抬蕭嚙褓佗蕭M嚙踝蕭\\conf\\vars.ini");
        	 FileReader fr = new FileReader(path);
             BufferedReader  br  =   new  BufferedReader(fr) ;
             
        	 //閮剖�ath��resource鞈�冗摨��楝敺����resource�隞亥◤���ar瑼�蝙�甇斗瘜隞亥��jar瑼������
//        	 InputStream fr = new ClassPathResource(path).getInputStream();	
//        	 BufferedReader br = new BufferedReader(new InputStreamReader(fr));
             
             
             while ((str = br.readLine()) != null) {
            	 
//            	 System.out.println(str);
//            	 System.out.println("str.indexOf(\"#\")<0 ="+ (str.indexOf("#")<0));
//            	 System.out.println("str.indexOf(text)>0 ="+(str.indexOf(text)>0));
                 if(str.indexOf("#")<0 && str.indexOf(text)>=0) {
                	 
//                	 System.out.println("-------------------true--------");
           String    result= 	str.substring(str.indexOf("=")+1);
                	 String [] array=result.split(",");
                	 for(int i=1;i<array.length;i++) {
                		 resultList.add(array[i]);
                	 }
                	 
                 }
             }
             br.close();   
             fr.close();
             return resultList;
         } catch(IOException e){
        	 return null;
        	 
         }
		
		
	}
	
	
	
	
	//branch.ini撠嚗�branch.ini�,�����
	public static ArrayList<String> readVarArrayListBranch(String text){
		ArrayList<String> resultList=new ArrayList<String>();
//		 String result="";
         try {
        	 String str;
        	 
//             FileReader fr = new FileReader("D:\\���偶���銵��\conf\\vars.ini");
        	 FileReader fr = new FileReader(path);
             BufferedReader  br  =   new  BufferedReader(fr) ;
             while ((str = br.readLine()) != null) {
            	 
//            	 System.out.println(str);
//            	 System.out.println("str.indexOf(\"#\")<0 ="+ (str.indexOf("#")<0));
//            	 System.out.println("str.indexOf(text)>0 ="+(str.indexOf(text)>0));
                 if(str.indexOf("#")<0 && str.indexOf(text)>=0) {
                	 
//                	 System.out.println("-------------------true--------");
           String    result= 	str.substring(str.indexOf("=")+1);
                	 String [] array=result.split(",");
                	 for(int i=0;i<array.length;i++) {
                		 resultList.add(array[i]);
                	 }
                	 
                 }
             }
             br.close();   
             fr.close();
             return resultList;
         } catch(IOException e){
        	 return null;
        	 
         }
		
		
	}
	
	
	
	
	//憭���銝�蝯��閰Ｖ�韏瑟閰ｇ�誑map��耦撘�
	public static Map<String,String> multiReadVar(Map<String,String>listMap){
		
		Map<String,String> result=new HashMap<String,String>();
		
//         for(int i=0;i<list.size();i++) {
//        	 resultList.add(ReadFile.readVar(list.get(i)));
//        	 
//         }
		
         
         for(String key : listMap.keySet()) {
//        	 result.put(key, ReadFile.readVar(listMap.get(key)));
         }
         
         
		return result;
		
		
		
	}
	
	
}
