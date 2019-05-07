package com.arthur.Start;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.arthur.tool.CommonMethod;
import com.arthur.tool.LogWriter;
import com.arthur.tool.ReadFile;
import com.arthur.vo.Detail;
import com.arthur.vo.Result;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Crawler {
	public static ArrayList<Detail> detailList;
 public static void main(String []args) throws IOException {
	 CommonMethod.getStockDetail();
	
	 
	 detailList=CommonMethod.getDetailListFromFile();
	 
	 
	 
	ArrayList<Result> resultList=CommonMethod.growStockCondition(detailList);
		ArrayList<Result> resultList2=CommonMethod.yahooStockCondition(detailList);
		
		CommonMethod.showSelectTitle();
		CommonMethod.showSelectTitleToFile();
		
		for(int i=0;i<resultList.size();i++){
			Result result=resultList.get(i);
			
			
			if( result.getFirst().equals("V") && result.getSecond().equals("V")&& result.getTotal() >5 ){
			
			System.out.println(result.getID()+","+result.getFirst()+","+result.getSecond()+","+result.getThird()+","+result.getFour()+","+result.getFive()+","+result.getSix()+","+result.getSeven()+","+result.getEight()+","+result.getTotal());
			CommonMethod.showData(result,detailList);
			}
			
			
			
		}
		
		
		CommonMethod.showYahooStock(resultList2, detailList);
 }
 
 
 
 
	
	
	
	
	
	
}
