package com.arthur.tool;

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

import com.arthur.runnable.SearchTask;
import com.arthur.vo.Detail;
import com.arthur.vo.Result;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import edu.emory.mathcs.backport.java.util.concurrent.ExecutionException;
import edu.emory.mathcs.backport.java.util.concurrent.FutureTask;

public class CommonMethod {

	public static void getStockDetail() throws IOException, InterruptedException, ExecutionException {
		ArrayList<Detail> detailList=new ArrayList<Detail>();
		
		
//		ArrayList<FutureTask>taskList= createThread(600,10000);
//		
//		
//		
//		for(int i=0;i<taskList.size();i++) {
//			ArrayList<Detail> sectionDetail=(ArrayList<Detail>) taskList.get(i).get();
//			
//			for(int j=0;j<sectionDetail.size();j++) {
//				System.out.println(sectionDetail.get(j).toString());
//			}
//			
//			detailList=loadList(detailList,sectionDetail);
//		}
		
		
		
		
//		 for(int i=1000;i<=9999;i++) {
//			 try {
//			 detailList.add(getDetail(i));
//			 }catch(Exception e) {
//				 System.out.println(i+"Data not found");
//			 }
//		 }
		 
//1108 	1222	1225 
		 
		 ArrayList<Integer> stockList=new ArrayList<Integer>();
		 stockList.add(2812);
		 stockList.add(6581);
		 stockList.add(2886);
		 stockList.add(1617);
		 stockList.add(3402);
		 stockList.add(5403);
		 stockList.add(8049);
		 stockList.add(1737);
		 stockList.add(2423);
		 stockList.add(3071);
		 stockList.add(3537);
		 stockList.add(6593);
		 stockList.add(9924);
		 stockList.add(2327);
		 stockList.add(6441);
		 for(int i=0;i<stockList.size();i++) {
			 try {
				 detailList.add(getDetail(stockList.get(i)));
			 System.out.println("----------------------");
			 }catch(Error e) {
				 System.out.println(stockList.get(i)+"Data not found");
				 System.out.println("----------------------");
			 }
		 }
		 
		 
		 
		 //debug list
//		 ArrayList<Integer> stockList=new ArrayList<Integer>();
//		 stockList.add(1446);
//		 stockList.add(1447);
//		 stockList.add(1449);
//		 stockList.add(1451);
//		 for(int i=0;i<stockList.size();i++) {
//			 try {
//				 detailList.add(getDetail(stockList.get(i)));
//			 System.out.println("----------------------");
//			 }catch(Error e) {
//				 System.out.println(stockList.get(i)+"Data not found");
//				 System.out.println("----------------------");
//			 }
//		 }
		 
		 
		 
		 
		Gson gson=new Gson(); 
		String json=gson.toJson(detailList);
		LogWriter.writeAudit("D:\\Stock\\detailList"+getDay(), json, 0, "utf-8",false);
		
		
		 System.out.println("json= "+json);
	}
	
	
	
	
	
	public static ArrayList<Result> growStockCondition(ArrayList<Detail> detailList){
		 ArrayList<Result> resultList=new ArrayList<Result>();
			
			
			
			for(int i=0;i<detailList.size();i++){
				int count=0;
				Detail detail=detailList.get(i);
				String ID=detail.getId().trim();
				Double Price=Double.parseDouble(detail.getPrice().trim());
				Double YearEPS=Double.parseDouble(detail.getYearEPS().trim());
				Double PER;
				Double YearROE=Double.parseDouble(detail.getYearROE());
				Double YearProfitPercent=Double.parseDouble(detail.getYearProfitPercent());
				Double GPM=Double.parseDouble(detail.getGPM());
				Double GPMadd=Double.parseDouble(detail.getGPMadd());
				Double asset=Double.parseDouble(detail.getAsset());
				Double debt=Double.parseDouble(detail.getDebt());
				Double BossHave=Double.parseDouble(detail.getBossHave().equals("")?"0":detail.getBossHave());
				Double CapitalStock=0.0;
				Double YearEPSpercent=Double.parseDouble(detail.getYearEPSpercent());
				Result output=new Result();
				output.setID(ID);
				if(!detail.getCapitalStock().trim().equals("")){
				 CapitalStock=Double.parseDouble(detail.getCapitalStock().trim());
				}
				
				if(!detail.getPER().trim().equals("")){
				 PER=Double.parseDouble(detail.getPER().trim());
				}else{
					PER=0.0;
				}
				
				
				Double EstimateProfit=Double.parseDouble(detail.getEstimateProfit());
				Double YearProfit=Double.parseDouble(detail.getYearProfit());
				Double EstimateProfitGrow=(EstimateProfit-YearProfit)*100.0/(YearProfit > 0?YearProfit:YearProfit*-1);
				
				
				
				if((PER/EstimateProfitGrow)<0.75 && (PER/EstimateProfitGrow)>0 ){
//					System.out.println(ID+" 本益成長比= "+(PER/YearEPSpercent)+" 低於0.75");
					
					
					
					output.setFirst("V");
					count++;
				}else{
					output.setFirst("X");
				}
				
				//------
			if(Price/YearEPS<=15  ){
//				System.out.println(ID+" 預估本益比= "+(Price/YearEPS)+" 低於15倍");
				output.setSecond("V");
				count++;
			}else{
				output.setSecond("X");
			}
			if(YearProfitPercent>0){
//				System.out.println(ID+" 平均稅後淨利= "+(YearProfitPercent)+" 正成長");
				output.setThird("V");
				count++;
			}else{
				output.setThird("X");
			}
			if(YearROE>15){
//				System.out.println(ID+" 股東權益報酬率= "+(YearROE)+" 15%以上");
				output.setFour("V");
				count++;
			}else{
				output.setFour("X");
			}
			
			if(((debt*100)/asset)<50 && ((debt*100)/asset)>0 ){
//				System.out.println(ID+" 負債比率= "+((debt*100)/asset)+" 低於50%");
				output.setSix("V");
				count++;
			}else{
				output.setSix("X");
			}
			
			if(output.getFour().equals("V") && output.getSix().equals("V")){
				output.setFour("O");
				output.setSix("O");
			}
			
			
			if(GPM>15 && GPMadd>0){
//				System.out.println(ID+" 毛利率= "+(GPM)+" 15%以上, "+" 毛利率增減= "+(GPMadd)+" 持續向上 ");
				output.setFive("V");
				count++;
			}else{
				output.setFive("X");
			}
			
			if(CapitalStock<=30 && CapitalStock>0){
//				System.out.println(ID+" 股本= "+(CapitalStock)+" 低於30億");
				if(ID.equals("2809")){
//					System.out.println("2809股本= "+CapitalStock);
				}
				output.setSeven("V");
				count++;
			}else{
				output.setSeven("X");
			}
			if(BossHave>=40){
//				System.out.println(ID+" 董監持股= "+(BossHave)+" 持股多(大於20%)");
				output.setEight("V");
				count++;
			}else{
				output.setEight("X");
			}
			
			
			output.setTotal(count);
			resultList.add(output);
			}
			
			return resultList;
			
	}
	
public static Detail getDetail(int id) throws IOException {
		
		Detail detail=new Detail();
		
		String ID;
		if(id<1000) {
			ID="0"+id;
		}else {
			ID=id+"";
		}
		
//		System.out.println("ID= "+ID);
		
		 Document doc= Jsoup.connect("https://www.wantgoo.com/stock/astock/basic?stockno="+ID).timeout(5000).get();
//	   	 System.out.println(doc.title());
//	   	System.out.println(doc.head());
		 String price=doc.select("span.price").text();
		 String CapitalStock=getValue(doc,"實收資本額","th").nextElementSibling().text().replace(",", "");
//	   	System.out.println("CapitalStock= "+CapitalStock);
//	   	System.out.println("-----------------------");
		detail.setName(doc.title().substring(0,doc.title().indexOf("(")));
	   	detail.setId(id+"");
	   	detail.setPrice(price);
	   	detail.setCapitalStock(CapitalStock);
		
		
//		 doc=Jsoup.connect("https://www.wantgoo.com/stock/report/basic_eps?stockno="+id).get();
//		 String YearEPSadd;
		 int now=Integer.parseInt(getDay());
		int year=Integer.parseInt(getDay().substring(0,4));
		int quarter = 0;
		
		if(now>=Integer.parseInt(year+"0215") && now < Integer.parseInt(year+"0515")) {
			year=year-1;
			quarter=4;
		}else if(now>=Integer.parseInt(year+"0515") && now < Integer.parseInt(year+"0815")) {
			quarter=1;
		}else if(now>=Integer.parseInt(year+"0815") && now < Integer.parseInt(year+"1115")) {
			quarter=2;
		}else if(now>=Integer.parseInt(year+"1115") || now<Integer.parseInt(year+"0215")) {
			quarter=3;
		}
		
//		List<Double> epsList=new ArrayList<Double>();
		String newestQuarter=year+"Q"+quarter;
//		
		System.out.println("newestQuarter= "+newestQuarter);
//		for(int i=0;i<8;i++) {
//			String query=year+" Q"+quarter;
//			System.out.println("query= "+query);
//			epsList.add(Double.parseDouble(getValue(doc,query,"td").nextElementSibling().text()));
//			
//			quarter=quarter-1;
//			if(quarter<1) {
//				year=year-1;
//				quarter=4;
//			}
//		}
//		String thisYearEps=(epsList.get(0)+epsList.get(1)+epsList.get(2)+epsList.get(3))+"";
//		String lastYearEps=(epsList.get(4)+epsList.get(5)+epsList.get(6)+epsList.get(7))+"";
//		 String YearEPSpersent=((Double.parseDouble(thisYearEps)-Double.parseDouble(lastYearEps))*100/Double.parseDouble(thisYearEps))+"";
//		 YearEPSadd=(Double.parseDouble(thisYearEps)-Double.parseDouble(lastYearEps))+"";
//		detail.setYearEPS(thisYearEps);
//		detail.setYearEPSadd(YearEPSadd);
//		detail.setYearEPSpercent(YearEPSpersent);
		
		doc=Jsoup.connect("https://histock.tw/stock/financial.aspx?no="+ID+"&st=2").timeout(10000).get();
		String first=getValue(doc,"季別/年度","th").nextElementSibling().text();
		int count=year-Integer.parseInt(first)+1;
		List<Double> epsList=new ArrayList<Double>();
		for(int i=0;i<8;i++) {
			String query="Q"+quarter;
//			System.out.println("query= "+query);
			Element target=getValue(doc,query,"th");
//			System.out.println("count= "+count);
			for(int j=0;j<count;j++) {
				target=target.nextElementSibling();
//				System.out.println("target.text= "+target.text());
			}
			epsList.add(Double.parseDouble(target.text().equals("-")?"0":target.text()));
//			epsList.add(Double.parseDouble(getValue(doc,query,"td").nextElementSibling().text()));
			
			quarter=quarter-1;
			if(quarter<1) {
				count=count-1;
				quarter=4;
			}
		}
		
//		System.out.println("epsList contains ");
		for(int i=0;i<epsList.size();i++) {
//			System.out.println(epsList.get(i));
		}
		
		String thisYearEps=(epsList.get(0)+epsList.get(1)+epsList.get(2)+epsList.get(3))+"";
		String lastYearEps=(epsList.get(4)+epsList.get(5)+epsList.get(6)+epsList.get(7))+"";
		 String YearEPSpersent=((Double.parseDouble(thisYearEps)-Double.parseDouble(lastYearEps))*100/Double.parseDouble(lastYearEps))+"";
		String YearEPSadd=(Double.parseDouble(thisYearEps)-Double.parseDouble(lastYearEps))+"";
		detail.setYearEPS(thisYearEps);
		detail.setYearEPSadd(YearEPSadd);
		detail.setYearEPSpercent(YearEPSpersent);
		
		 doc=Jsoup.connect("https://www.wantgoo.com/stock/report/basic_dse?stockno="+ID).timeout(5000).get();
		  String Asset;
		 String Debt;
		Debt=getValue(doc, newestQuarter, "td").nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling().text().replace(",", "");
		Asset=getValue(doc, newestQuarter, "td").nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling().text().replace(",", "");
		detail.setDebt(Debt);
		detail.setAsset(Asset);
		
		
//		 doc=Jsoup.connect("https://www.wantgoo.com/stock/report/profit_roeq?StockNo="+id).get();
		 
//		  String YearROE;
//		  String YearROEadd;
//		  
//		
//		String lastYearQuarter=Integer.parseInt(newestQuarter.substring(0,4))-1+newestQuarter.substring(4);
//		System.out.println("newestQuarter= "+newestQuarter);
//		YearROE=getValue(doc,newestQuarter,"td").nextElementSibling().text();
//		String lastYearROE=getValue(doc,lastYearQuarter,"td").nextElementSibling().text();
//		YearROEadd=((Double.parseDouble(YearROE)-Double.parseDouble(lastYearROE))*100/Double.parseDouble(YearROE))+"";
//		detail.setYearROE(YearROE);
//		detail.setYearROEadd(YearROEadd);
		doc=Jsoup.connect("https://www.cnyes.com/twstock/finratio/"+ID+".htm").timeout(10000).get();
		
		String YearROE=getValue(doc,"股東權益報酬率","td").nextElementSibling().text();
		String lastYearROE=getValue(doc,"股東權益報酬率","td").nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling().text();
		
//		System.out.println("YearROE= "+YearROE);
//		System.out.println("lastYearROE= "+lastYearROE);
		
		String YearROEadd=((Double.parseDouble(YearROE.equals("")?"0":YearROE)-Double.parseDouble(lastYearROE.equals("")?"0":lastYearROE))*100/Double.parseDouble(YearROE.equals("")?"0":YearROE))+"";
		detail.setYearROE(YearROE.equals("")?"0":YearROE);
		detail.setYearROEadd(YearROEadd);
		
		
		
		
		doc=Jsoup.connect("https://www.wantgoo.com/stock/report/value?types=1&stockno="+ID).timeout(10000).get();
		
		
		int month=Integer.parseInt(getDay().substring(4,6));
		int Day=Integer.parseInt(getDay().substring(6,8));
		if(Day<=10) {
			month=month-1;
		}
		
		
		String PER=getValue(doc,getDay().substring(0,4)+"/"+month,"td").nextElementSibling().text();
		PER=Double.parseDouble(PER.equals("-")?"0":PER)+"";
		
		detail.setPER(PER);
		
//		doc=Jsoup.connect("https://histock.tw/stock/financial.aspx?no="+id+"&t=3").get();
//		 String GPMadd;
//		 String GPM;
//		GPM=getValue(doc,newestQuarter,"td").nextElementSibling().text();
//		GPM=GPM.substring(0,GPM.length()-1);
//		String lastGPM;
//		String lastQuarter;
//		
//		System.out.println("newestQuarter= "+newestQuarter);
//		if(Integer.parseInt(newestQuarter.substring(5))-1<1) {
//			lastQuarter=(Integer.parseInt(newestQuarter.substring(0,4))-1)+"Q4";
//		}else {
//			lastQuarter=newestQuarter.substring(0,5)+(Integer.parseInt(newestQuarter.substring(5))-1);
//		}
//		lastGPM=getValue(doc,lastQuarter,"td").nextElementSibling().text();
//		lastGPM=lastGPM.substring(0,lastGPM.length()-1);
//		GPMadd=((Double.parseDouble(GPM)-Double.parseDouble(lastGPM))*100/Double.parseDouble(GPM))+"";
//		
//		detail.setGPM(GPM);
//		detail.setGPMadd(GPMadd);
		
		
		
		doc=Jsoup.connect("https://stock.wearn.com/income.asp?kind="+ID).timeout(5000).get();
//		System.out.println("newestQuarter= "+newestQuarter);
		String taiwanQuarter=(Integer.parseInt(newestQuarter.substring(0,4))-1911)+"年0"+newestQuarter.substring(5)+"季";
		
//		System.out.println("taiwanQuarter= "+taiwanQuarter);
		String GPM=getValue(doc,taiwanQuarter,"td")==null?"0":getValue(doc,taiwanQuarter,"td").nextElementSibling().nextElementSibling().text().substring(0,5).replace("%", "");
		String lastQuarter;
		
//		if(Integer.parseInt(newestQuarter.substring(5))-1<1) {
//		lastQuarter=(Integer.parseInt(newestQuarter.substring(0,4))-1)+"Q4";
//	}else {
//		lastQuarter=newestQuarter.substring(0,5)+(Integer.parseInt(newestQuarter.substring(5))-1);
//	}
		lastQuarter=(Integer.parseInt(newestQuarter.substring(0,4))-1)+"Q"+Integer.parseInt(newestQuarter.substring(5));
		
		
		String taiwanLastQuarter=(Integer.parseInt(lastQuarter.substring(0,4))-1911)+"年0"+lastQuarter.substring(5)+"季";
		
//		System.out.println("taiwanLastQuarter= "+taiwanLastQuarter);
		
		String lastGPM=getValue(doc,taiwanLastQuarter,"td")==null?"0":getValue(doc,taiwanLastQuarter,"td").nextElementSibling().nextElementSibling().text();
		
		 lastGPM=lastGPM.equals("0")?"0":lastGPM.substring(0,5).replace("%", "");
		System.out.println("GPM= "+GPM);
		System.out.println("lastGPM= "+lastGPM);
		
		String GPMadd=((Double.parseDouble(GPM)-Double.parseDouble(lastGPM))*100/Double.parseDouble(GPM))+"";
		
		detail.setGPM(GPM);
		detail.setGPMadd(GPMadd);
		
		
		
		
		doc=Jsoup.connect("https://www.wantgoo.com/stock/astock/chips?stockno="+ID).timeout(5000).get();
		
		detail.setBossHave(getValue(doc,"董監持股","th").parent().parent().nextElementSibling().child(0).child(4).text());
		
//		doc=Jsoup.connect("https://www.wantgoo.com/stock/report/basic_is?stockno="+id).get();
//		String YearProfitPercent;
//		year=Integer.parseInt(newestQuarter.substring(0,4));
//		quarter=Integer.parseInt(newestQuarter.substring(5));
//		List<Double> profitList=new ArrayList<Double>();
//		for(int i=0;i<8;i++) {
//			String query=year+"Q"+quarter;
//			System.out.println("query= "+query);
//			profitList.add(Double.parseDouble(getValue(doc,query,"td").nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling().text().replace(",", "")));
//			
//			quarter=quarter-1;
//			if(quarter<1) {
//				year=year-1;
//				quarter=4;
//			}
//		}
//		
//		Double thisYearProfit=profitList.get(0)+profitList.get(1)+profitList.get(2)+profitList.get(3);
//		Double lastYearProfit=profitList.get(4)+profitList.get(5)+profitList.get(6)+profitList.get(7);
//		YearProfitPercent=((thisYearProfit-lastYearProfit)*100/thisYearProfit)+"";
//		detail.setYearProfit(thisYearProfit+"");
//		detail.setYearProfitPercent(YearProfitPercent);
		
		
		doc=Jsoup.connect("https://histock.tw/stock/financial.aspx?no="+ID+"&st=4").timeout(5000).get();
		year=Integer.parseInt(newestQuarter.substring(0,4));
		quarter=Integer.parseInt(newestQuarter.substring(5));
		List<Double> profitList=new ArrayList<Double>();
		for(int i=0;i<8;i++) {
			String query=year+"Q"+quarter;
//			System.out.println("query= "+query);
			Element profitListElement=getValue(doc,query,"td");
			profitList.add(Double.parseDouble(profitListElement == null?"0":profitListElement.nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling().text().replace(",", "")));
			
			quarter=quarter-1;
			if(quarter<1) {
				year=year-1;
				quarter=4;
			}
		}
//		System.out.println("profitList contains");
//		for(int i=0;i<profitList.size();i++) {
//			System.out.println(profitList.get(i));
//		}
		
		
		Double thisYearProfit=profitList.get(0)+profitList.get(1)+profitList.get(2)+profitList.get(3);
		Double lastYearProfit=profitList.get(4)+profitList.get(5)+profitList.get(6)+profitList.get(7);
		String YearProfitPercent=((thisYearProfit-lastYearProfit)*100/thisYearProfit)+"";
		detail.setYearProfit(thisYearProfit+"");
		detail.setYearProfitPercent(YearProfitPercent);
		
		
		
		
		doc=Jsoup.connect("https://histock.tw/stock/financial.aspx?no="+ID+"&t=6&st=3").timeout(5000).get();
		
		String YearMonth=month<10?getDay().substring(0,4)+"/0"+month:getDay().substring(0,4)+"/"+month;
		String Yield=getValue(doc,YearMonth,"td").nextElementSibling().text();
		Yield=Yield.substring(0,Yield.length()-1);
		detail.setYield(Yield);
		
		
		
		
		doc=Jsoup.connect("http://estock.marbo.com.tw/html/stock_info_"+ID+".asp").timeout(5000).get();
		String keyWord=getDay().substring(0,4)+"年 預估稅後盈餘";
		String estimateProfit=getValue(doc,keyWord,"td").parent().nextElementSibling().child(3).text();
		estimateProfit=Double.parseDouble(estimateProfit.substring(0,estimateProfit.length()-1))*100000+"";
		detail.setEstimateProfit(estimateProfit);
		
		
		
		
		
		doc=Jsoup.connect("https://tw.stock.yahoo.com/d/s/company_"+ID+".html").timeout(5000).get();
		Element epsTarget=getValue(doc,"最近四年每股盈餘","td").parent();
		
		ArrayList<Double> yahooQuarterEps=new ArrayList<Double>();
		yahooQuarterEps.add(Double.parseDouble(epsTarget.nextElementSibling().child(3).text().replace("元", "")));
		yahooQuarterEps.add(Double.parseDouble(epsTarget.nextElementSibling().nextElementSibling().child(3).text().replace("元", "")));
		yahooQuarterEps.add(Double.parseDouble(epsTarget.nextElementSibling().nextElementSibling().nextElementSibling().child(3).text().replace("元", "")));
		yahooQuarterEps.add(Double.parseDouble(epsTarget.nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling().child(3).text().replace("元", "")));
		
		detail.setYahooQuarterEps(yahooQuarterEps);
		
		Double newestYearEps=0.0;
		for(int i=0;i<yahooQuarterEps.size();i++) {
			newestYearEps=newestYearEps+yahooQuarterEps.get(i);
		}
		
		
		
		ArrayList<Double> yahooYearEPS=new ArrayList<Double>();
		yahooYearEPS.add(newestYearEps);
		yahooYearEPS.add(Double.parseDouble(epsTarget.nextElementSibling().child(5).text().replace("元", "")));
		yahooYearEPS.add(Double.parseDouble(epsTarget.nextElementSibling().nextElementSibling().child(5).text().replace("元", "")));
		yahooYearEPS.add(Double.parseDouble(epsTarget.nextElementSibling().nextElementSibling().nextElementSibling().child(5).text().replace("元", "")));
		yahooYearEPS.add(Double.parseDouble(epsTarget.nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling().child(5).text().replace("元", "").equals("-")?"0":epsTarget.nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling().child(5).text().replace("元", "")));
		
		
		detail.setYahooYearEPS(yahooYearEPS);
		
		detail.setYahooGPM(Double.parseDouble(getValue(doc,"營業毛利率","td").nextElementSibling().text().replace("%", "")));
		
		String MoneyDividend=getValue(doc,"現金股利","td").nextElementSibling().text().replace("元", "");
		detail.setYahooMoneyDividend(Double.parseDouble(MoneyDividend.equals("-")?"0":MoneyDividend));
		
		String StockDividend=getValue(doc,"股票股利","td").nextElementSibling().text().replace("元", "");
		detail.setYahooStockDividend(Double.parseDouble(StockDividend.equals("-")?"0":StockDividend));
		
		System.out.println(detail.toString());
		
		return detail;
	}


//嚙緬嚙褓改蕭X嚙瘢嚙瘢
	public static Element getValue(Document doc,String value,String selector) {
		Elements elements= doc.select(selector);
		Element result = null;
		for(Element element:elements) {
			if(element.text().equals(value)) {
				result= element;
			}
		}
		
		return result;
		
	}

	
	public static String getDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date today = new Date();
		String day = sdf.format(today);
		return day;
	}
	
	public static void showData(Result output,ArrayList<Detail> detailList) {
		String id=output.getID();
		Detail detail = null;
		for(int i=0;i<detailList.size();i++) {
			if(id.equals(detailList.get(i).getId())){
				detail=detailList.get(i);
			}
		}
		
		String ID=detail.getId().trim();
		Double Price=Double.parseDouble(detail.getPrice().trim());
		Double YearEPS=Double.parseDouble(detail.getYearEPS().trim());
		Double PER = null;
		Double YearROE=Double.parseDouble(detail.getYearROE());
		Double YearProfitPercent=Double.parseDouble(detail.getYearProfitPercent());
		Double GPM=Double.parseDouble(detail.getGPM());
		Double GPMadd=Double.parseDouble(detail.getGPMadd());
		Double asset=Double.parseDouble(detail.getAsset());
		Double debt=Double.parseDouble(detail.getDebt());
		Double BossHave=Double.parseDouble(detail.getBossHave());
		Double CapitalStock=0.0;
		Double YearEPSpercent=Double.parseDouble(detail.getYearEPSpercent());
		Double EstimateProfit=Double.parseDouble(detail.getEstimateProfit());
		Double YearProfit=Double.parseDouble(detail.getYearProfit());
		Double EstimateProfitGrow=(EstimateProfit-YearProfit)*100.0/(YearProfit > 0?YearProfit:YearProfit*-1);
		System.out.println("EstimateProfitGrow = ");
		System.out.println("("+EstimateProfit+"-"+YearProfit+")*100.0/(abs:"+YearProfit+")");
		if(!detail.getCapitalStock().trim().equals("")){
			 CapitalStock=Double.parseDouble(detail.getCapitalStock().trim());
			}
			
			if(!detail.getPER().trim().equals("")){
			 PER=Double.parseDouble(detail.getPER().trim());
			}else{
				PER=0.0;
			}
		
			
		StringBuffer fileData=new StringBuffer();
			
//		System.out.println("---------------"+detail.getId()+"------------------");
//		System.out.println(detail.toString());
//		System.out.println("1."+" 本益成長比= "+PER+"/"+EstimateProfitGrow+"="+PER/EstimateProfitGrow+" 低於0.75");
//		System.out.println("2."+" 預估本益比= "+Price+"/"+YearEPS+"="+Price/YearEPS+" 低於15倍");
//		System.out.println("3."+" 平均稅後淨利= "+(YearProfitPercent)+" 正成長");
//		System.out.println("4."+" 股東權益報酬率= "+(YearROE)+" 15%以上");
//		System.out.println("5."+" 毛利率= "+(GPM)+" 15%以上, "+" 毛利率增減= "+(GPMadd)+" 持續向上 ");
//		System.out.println("6."+" 負債比率= "+"("+debt+"*100%"+")/"+asset+"="+((debt*100)/asset)+" 低於50%");
//		System.out.println("7."+" 股本= "+(CapitalStock)+" 低於30億");
//		System.out.println("8."+" 董監持股= "+(BossHave)+" 持股多(大於50%)");
//		System.out.println("股價= "+Price);
		
		fileData.append("---------------"+detail.getId()+"------------------").append("\r\n");
		fileData.append(detail.toString()).append("\r\n");
		fileData.append("股名= "+detail.getName()).append("\r\n");
		fileData.append("1."+" 本益成長比= "+PER+"/"+EstimateProfitGrow+"="+PER/EstimateProfitGrow+" 低於0.75").append("\r\n");
		fileData.append("2."+" 預估本益比= "+Price+"/"+YearEPS+"="+Price/YearEPS+" 低於15倍").append("\r\n");
		fileData.append("3."+" 平均稅後淨利= "+(YearProfitPercent)+" 正成長").append("\r\n");
		fileData.append("4."+" 股東權益報酬率= "+(YearROE)+" 15%以上").append("\r\n");
		fileData.append("5."+" 毛利率= "+(GPM)+" 15%以上, "+" 毛利率增減= "+(GPMadd)+" 持續向上 ").append("\r\n");
		fileData.append("6."+" 負債比率= "+"("+debt+"*100%"+")/"+asset+"="+((debt*100)/asset)+" 低於50%").append("\r\n");
		fileData.append("7."+" 股本= "+(CapitalStock)+" 低於30億").append("\r\n");
		fileData.append("8."+" 董監持股= "+(BossHave)+" 持股多(大於50%)").append("\r\n");
		fileData.append("股價= "+Price).append("\r\n");
		
		
		
		
		String Yield=detail.getYield();
		//總報酬率TROR
//		Double TROR=((Double.parseDouble(Yield))+(Double.parseDouble(detail.getYearEPSadd())/100.0))/PER;
		Double TROR=((Double.parseDouble(Yield))+Double.parseDouble(detail.getYearEPSpercent()))/PER;
//		System.out.println("總報酬率= "+TROR);
//		System.out.println(TROR+"="+"("+Double.parseDouble(Yield)+"+("+Double.parseDouble(detail.getYearEPSadd())+"/100.0))/"+PER);
//		System.out.println(TROR+"="+"("+Double.parseDouble(Yield)+"+("+Double.parseDouble(detail.getYearEPSpercent())+"))/"+PER);
		
		fileData.append("總報酬率= "+TROR).append("\r\n");
		fileData.append(TROR+"="+"("+Double.parseDouble(Yield)+"+("+Double.parseDouble(detail.getYearEPSpercent())+"))/"+PER).append("\r\n");
		
		if(TROR >1.2) {
//			System.out.println("股價被低估");
			fileData.append("股價被低估").append("\r\n");
		}else if(TROR>0.8 && TROR < 1.2) {
//			System.out.println("股價合理");
			fileData.append("股價合理").append("\r\n");
		}else {
//			System.out.println("股價被高估");
			fileData.append("股價被高估").append("\r\n");
		}
//		System.out.println("---------------/"+detail.getId()+"------------------");
		
		fileData.append("---------------/"+detail.getId()+"------------------").append("\r\n");
		
		
		LogWriter.writeAudit("D:\\Stock\\SelectResult"+getDay(),fileData.toString() , 1, "utf-8", true);
		
		
		
	}
	
	
	
	public  static ArrayList<Detail> getDetailListFromFile() {
		ArrayList<Detail> detailList;
		 Type detailType=new TypeToken<ArrayList<Detail>>(){}.getType();
		 Gson gson=new Gson();
		 detailList=gson.fromJson(ReadFile.read("D:\\Stock\\detailList"+CommonMethod.getDay()), detailType);
		 return detailList;
	}
	
	
	public static void showSelectTitle() {
//		System.out.println("---------------------------------------------------");
//		System.out.println("ID,本益成長比低於0.75,預估本益比低於15倍,平均稅後淨利正成長,股東權益報酬率15%以上,毛利率15%以上且毛利率增減持續向上,負債比率低於50%,股本低於30億,董監持股持股多(大於20%),符合條件筆數");
		
	}
	
	
	public static void showSelectTitleToFile() {
		
		LogWriter.writeAudit("D:\\Stock\\SelectResult"+getDay(),"" , 1, "utf-8", false);
		
		LogWriter.writeAudit("D:\\Stock\\SelectResult"+getDay(),"---------------------------------------------------" , 1, "utf-8", true);
		LogWriter.writeAudit("D:\\Stock\\SelectResult"+getDay(),"ID,本益成長比低於0.75,預估本益比低於15倍,平均稅後淨利正成長,股東權益報酬率15%以上,毛利率15%以上且毛利率增減持續向上,負債比率低於50%,股本低於30億,董監持股持股多(大於20%),符合條件筆數" , 1, "utf-8", true);
		
		
	}
	
//	自定議選股條件，使用yahoo的資料
	public static ArrayList<Result> yahooStockCondition(ArrayList<Detail> detailList){
		ArrayList<Result> resultList=new ArrayList<Result>();
		for(int i=0;i<detailList.size();i++) {
			Detail detail=detailList.get(i);
			Result result=new Result();
			int total=0;
			ArrayList<Double> yahooYearEPS=detail.getYahooYearEPS();
			
			result.setID(detail.getId());
			
			if(yahooYearEPS.get(0)>yahooYearEPS.get(1) && yahooYearEPS.get(1) > yahooYearEPS.get(2) && yahooYearEPS.get(2) > yahooYearEPS.get(3) && yahooYearEPS.get(3)> yahooYearEPS.get(4)) {
				for(int j=0;j<yahooYearEPS.size();j++) {
					if(yahooYearEPS.get(j)<0) {
						result.setFirst("x");
					}
				}
				
				if(result.getFirst() == null || !result.getFirst().equals("x")) {
				result.setFirst("v");
				total++;
				}
			}else {
				result.setFirst("x");
			}
			
			if(detail.getYahooGPM() > 15) {
				result.setSecond("v");
				total++;
			}else {
				result.setSecond("x");
			}
			
			Double Dividend=detail.getYahooMoneyDividend()+detail.getYahooStockDividend();
			if(Dividend*100/Double.parseDouble(detail.getPrice()) >=7){
				result.setThird("v");
				total++;
			}else {
				result.setThird("x");
			}
			
			
			if(Double.parseDouble(detail.getPrice()) < 35) {
				result.setFour("v");
				total++;
			}else {
				result.setFour("x");
				
			}
			
			if(countYearAdd(yahooYearEPS.get(0),yahooYearEPS.get(1))>=10 && countYearAdd(yahooYearEPS.get(1),yahooYearEPS.get(2))>=10 &&countYearAdd(yahooYearEPS.get(2),yahooYearEPS.get(3))>=10 &&countYearAdd(yahooYearEPS.get(3),yahooYearEPS.get(4))>=10 ) {
				result.setFive("v");
			}else {
				result.setFive("x");
			}
			
			
			
			
			
			result.setTotal(total);
			
//			System.out.println(result.toString());
			resultList.add(result);
			
		}
		
		return resultList;
	}
	
	
	public static void showYahooStock(ArrayList<Result> resultList,ArrayList<Detail>detailList) {
		
		StringBuffer buffer=new StringBuffer();
		buffer.append("-------------------------------\r\n");
		buffer.append("yahoo 選股結果\r\n");
		for(int i=0;i<resultList.size();i++) {
			if(resultList.get(i).getTotal() == 4) {
				String id=resultList.get(i).getID();
				for(int j=0;j<detailList.size();j++) {
					Detail detail=detailList.get(j);
					if(detail.getId().equals(id)) {
						
						
						buffer.append("股名:"+detail.getName()+"\r\n");
						buffer.append("ID:"+detail.getId()+"\r\n");
						buffer.append("股價:"+detail.getPrice()+"\r\n");
						buffer.append("現金股利:"+detail.getYahooMoneyDividend()+"\r\n");
						buffer.append("股票股利:"+detail.getYahooStockDividend()+"\r\n");
						buffer.append("毛利率:"+detail.getYahooGPM()+"\r\n");
						buffer.append("-------------------------------"+"\r\n");
						
					}
				}
				
				
				
			}
			
			
		}
		
		LogWriter.writeAudit("D:\\Stock\\SelectResult"+getDay(),buffer.toString(), 1, "utf-8", true);
//		System.out.println(buffer.toString());
	}
	
	
	public static Double countYearAdd(Double newYearData,Double lastYearData) {
		return (newYearData-lastYearData)*100/lastYearData;
		
	}
	
	
	public static boolean checkYearAddMoreThenCount(ArrayList<Double> list,int count) {
		boolean result=true;
		for(int i=0;i<list.size()-1;i++) {
			Double first=list.get(i);
			Double second=list.get(i+1);
			if(countYearAdd(first,second)<count) {
				result=false;
			}
			
		}
		
		
		
		
		return result;
		
	}
	
	
	
	public static <E> ArrayList<E> loadList(ArrayList<E>parentList , ArrayList<E> childList){
		
		for(int i=0;i<childList.size();i++) {
			parentList.add(childList.get(i));
		}
		
		
		return parentList;
		
	}
	
	
	//建立多執行緒來跑 參數threadNumber:要開幾個執行緒  endNumber:要查到第幾號(不包含這一號)
	public static ArrayList<FutureTask> createThread(int threadNumber,int endNumber){
		System.out.println("endNumber= "+endNumber+" ,threadNumber= "+threadNumber);
		int start;
		int end=1000;
		int size=(int) Math.ceil((endNumber*1.0-end*1.0)/threadNumber*1.0);
		
		System.out.println("size= "+size);
		ArrayList<FutureTask> futureList=new ArrayList<FutureTask>();
		for(int i=0;i<threadNumber;i++) {
			start=end;
			end=start+size;
			end=end>endNumber?endNumber:end;
			System.out.println("start= "+start+" ,end= "+end );
		FutureTask furtureTask=new FutureTask(new SearchTask(start, end));
		new Thread(furtureTask).start();
		futureList.add(furtureTask);
		}
		
		
		return futureList;
	}
	
	
	
}
