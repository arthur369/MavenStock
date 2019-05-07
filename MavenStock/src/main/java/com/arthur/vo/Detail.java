package com.arthur.vo;

import java.util.ArrayList;

public class Detail {
	private String Id;
	private String name;
	//PER=���q��
	private String PER;
	private String YearProfit;
	private String YearProfitPercent;
	//ROE=�ѪF�v�q���S�v
	private String YearROE;
	private String YearROEadd;
	//EPS=�C�Ѭվl
	private String YearEPS;
	private String YearEPSadd;
	private String YearEPSpercent;
	private String Asset;
	private String Debt;
	private String CapitalStock;
	private String BossHave;
	private String Dividend;
	private String Price;
	//GPM=��Q�v
	private String GPMadd;
	private String GPM;
	//Yield=�ާQ�v
	private String Yield;
	
	//預估最新一年稅後盈餘
	private String estimateProfit;

// Yahoo開頭的都是從yahoo查來的資料
//	最近四年每股盈餘
	private ArrayList<Double> YahooYearEPS;
//	最新四季每股盈餘
	private ArrayList<Double> YahooQuarterEps;
//	營業毛利率
	private Double YahooGPM;
// 現金股利	
	private Double YahooMoneyDividend;
// 股票股利
	private Double YahooStockDividend;	
	
	
	public String getGPMadd() {
		return GPMadd;
	}
	public void setGPMadd(String gPMadd) {
		GPMadd = gPMadd;
	}
	public String getGPM() {
		return GPM;
	}
	public void setGPM(String gPM) {
		GPM = gPM;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPER() {
		return PER;
	}
	public void setPER(String pER) {
		PER = pER;
	}
	public String getYearProfit() {
		return YearProfit;
	}
	public void setYearProfit(String yearProfit) {
		YearProfit = yearProfit;
	}
	public String getYearProfitPercent() {
		return YearProfitPercent;
	}
	public void setYearProfitPercent(String yearProfitPercent) {
		YearProfitPercent = yearProfitPercent;
	}
	public String getYearROE() {
		return YearROE;
	}
	public void setYearROE(String yearROE) {
		YearROE = yearROE;
	}
	public String getYearROEadd() {
		return YearROEadd;
	}
	public void setYearROEadd(String yearROEadd) {
		YearROEadd = yearROEadd;
	}
	public String getYearEPS() {
		return YearEPS;
	}
	public void setYearEPS(String yearEPS) {
		YearEPS = yearEPS;
	}
	public String getYearEPSadd() {
		return YearEPSadd;
	}
	public void setYearEPSadd(String yearEPSadd) {
		YearEPSadd = yearEPSadd;
	}
	public String getYearEPSpercent() {
		return YearEPSpercent;
	}
	public void setYearEPSpercent(String yearEPSpercent) {
		YearEPSpercent = yearEPSpercent;
	}
	public String getAsset() {
		return Asset;
	}
	public void setAsset(String asset) {
		Asset = asset;
	}
	public String getDebt() {
		return Debt;
	}
	public void setDebt(String debt) {
		Debt = debt;
	}
	public String getCapitalStock() {
		return CapitalStock;
	}
	public void setCapitalStock(String capitalStock) {
		CapitalStock = capitalStock;
	}
	public String getBossHave() {
		return BossHave;
	}
	public void setBossHave(String bossHave) {
		BossHave = bossHave;
	}
	public String getDividend() {
		return Dividend;
	}
	public void setDividend(String dividend) {
		Dividend = dividend;
	}
	public String getYield() {
		return Yield;
	}
	public void setYield(String yield) {
		Yield = yield;
	}
	
	
	
	public String getEstimateProfit() {
		return estimateProfit;
	}
	public void setEstimateProfit(String estimateProfit) {
		this.estimateProfit = estimateProfit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Double> getYahooYearEPS() {
		return YahooYearEPS;
	}
	public void setYahooYearEPS(ArrayList<Double> yahooYearEPS) {
		YahooYearEPS = yahooYearEPS;
	}
	public ArrayList<Double> getYahooQuarterEps() {
		return YahooQuarterEps;
	}
	public void setYahooQuarterEps(ArrayList<Double> yahooQuarterEps) {
		YahooQuarterEps = yahooQuarterEps;
	}
	public Double getYahooGPM() {
		return YahooGPM;
	}
	public void setYahooGPM(Double yahooGPM) {
		YahooGPM = yahooGPM;
	}
	public Double getYahooMoneyDividend() {
		return YahooMoneyDividend;
	}
	public void setYahooMoneyDividend(Double yahooMoneyDividend) {
		YahooMoneyDividend = yahooMoneyDividend;
	}
	public Double getYahooStockDividend() {
		return YahooStockDividend;
	}
	public void setYahooStockDividend(Double yahooStockDividend) {
		YahooStockDividend = yahooStockDividend;
	}
	@Override
	public String toString() {
		return "Detail [Id=" + Id + ", name=" + name + ", PER=" + PER + ", YearProfit=" + YearProfit
				+ ", YearProfitPercent=" + YearProfitPercent + ", YearROE=" + YearROE + ", YearROEadd=" + YearROEadd
				+ ", YearEPS=" + YearEPS + ", YearEPSadd=" + YearEPSadd + ", YearEPSpercent=" + YearEPSpercent
				+ ", Asset=" + Asset + ", Debt=" + Debt + ", CapitalStock=" + CapitalStock + ", BossHave=" + BossHave
				+ ", Dividend=" + Dividend + ", Price=" + Price + ", GPMadd=" + GPMadd + ", GPM=" + GPM + ", Yield="
				+ Yield + ", estimateProfit=" + estimateProfit + ", YahooYearEPS=" + YahooYearEPS + ", YahooQuarterEps="
				+ YahooQuarterEps + ", YahooGPM=" + YahooGPM + ", YahooMoneyDividend=" + YahooMoneyDividend
				+ ", YahooStockDividend=" + YahooStockDividend + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
