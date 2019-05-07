package com.arthur.Start;

import java.util.ArrayList;

import com.arthur.tool.ReadFile;
import com.arthur.vo.Detail;
import com.arthur.vo.Result;

public class Start {
	public static ArrayList<Detail> result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 result=ReadFile.readFile();
//		System.out.println("Got:"+result);
		
		ArrayList<Result> outputList=new ArrayList<Result>();
		
		
		
		for(int i=0;i<result.size();i++){
			int count=0;
			Detail detail=result.get(i);
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
			Double BossHave=Double.parseDouble(detail.getBossHave());
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
			
			if(output.getID().equals("8049")){
				System.out.println("---------------8049------------------");
				System.out.println(detail.toString());
				System.out.println("1."+" ���q������= "+PER+"/"+YearEPSpercent+"="+PER/YearEPSpercent+" �C��0.75");
				System.out.println("2."+" �w�����q��= "+Price+"/"+YearEPS+"="+Price/YearEPS+" �C��15��");
				System.out.println("3."+" �����|��b�Q= "+(YearProfitPercent)+" ������");
				System.out.println("4."+" �ѪF�v�q���S�v= "+(YearROE)+" 15%�H�W");
				System.out.println("5."+" ��Q�v= "+(GPM)+" 15%�H�W, "+" ��Q�v�W��= "+(GPMadd)+" ����V�W ");
				System.out.println("6."+" �t�Ť�v= "+"("+debt+"*100%"+")/"+asset+"="+((debt*100)/asset)+" �C��50%");
				System.out.println("7."+" �ѥ�= "+(CapitalStock)+" �C��30��");
				System.out.println("8."+" ���ʫ���= "+(BossHave)+" ���Ѧh(�j��50%)");
				System.out.println("�ѻ�= "+Price);
				System.out.println("---------------/8049------------------");
				
			}
			
			
			
			
			
			if(output.getID().equals("3071")){
				System.out.println("---------------3071------------------");
				System.out.println(detail.toString());
				System.out.println("1."+" ���q������= "+PER+"/"+YearEPSpercent+"="+PER/YearEPSpercent+" �C��0.75");
				System.out.println("2."+" �w�����q��= "+Price+"/"+YearEPS+"="+Price/YearEPS+" �C��15��");
				System.out.println("3."+" �����|��b�Q= "+(YearProfitPercent)+" ������");
				System.out.println("4."+" �ѪF�v�q���S�v= "+(YearROE)+" 15%�H�W");
				System.out.println("5."+" ��Q�v= "+(GPM)+" 15%�H�W, "+" ��Q�v�W��= "+(GPMadd)+" ����V�W ");
				System.out.println("6."+" �t�Ť�v= "+"("+debt+"*100%"+")/"+asset+"="+((debt*100)/asset)+" �C��50%");
				System.out.println("7."+" �ѥ�= "+(CapitalStock)+" �C��30��");
				System.out.println("8."+" ���ʫ���= "+(BossHave)+" ���Ѧh(�j��50%)");
				System.out.println("�ѻ�= "+Price);
				System.out.println("---------------/3071------------------");
				
			}
			
			
			if(output.getID().equals("8279")){
				System.out.println("---------------8279------------------");
				System.out.println(detail.toString());
				System.out.println("1."+" ���q������= "+PER+"/"+YearEPSpercent+"="+PER/YearEPSpercent+" �C��0.75");
				System.out.println("2."+" �w�����q��= "+Price+"/"+YearEPS+"="+Price/YearEPS+" �C��15��");
				System.out.println("3."+" �����|��b�Q= "+(YearProfitPercent)+" ������");
				System.out.println("4."+" �ѪF�v�q���S�v= "+(YearROE)+" 15%�H�W");
				System.out.println("5."+" ��Q�v= "+(GPM)+" 15%�H�W, "+" ��Q�v�W��= "+(GPMadd)+" ����V�W ");
				System.out.println("6."+" �t�Ť�v= "+"("+debt+"*100%"+")/"+asset+"="+((debt*100)/asset)+" �C��50%");
				System.out.println("7."+" �ѥ�= "+(CapitalStock)+" �C��30��");
				System.out.println("8."+" ���ʫ���= "+(BossHave)+" ���Ѧh(�j��50%)");
				System.out.println("�ѻ�= "+Price);
				System.out.println("---------------/8279------------------");
				
			}
			
			if(output.getID().equals("8424")){
				System.out.println("---------------8424------------------");
				System.out.println(detail.toString());
				System.out.println("1."+" ���q������= "+PER+"/"+YearEPSpercent+"="+PER/YearEPSpercent+" �C��0.75");
				System.out.println("2."+" �w�����q��= "+Price+"/"+YearEPS+"="+Price/YearEPS+" �C��15��");
				System.out.println("3."+" �����|��b�Q= "+(YearProfitPercent)+" ������");
				System.out.println("4."+" �ѪF�v�q���S�v= "+(YearROE)+" 15%�H�W");
				System.out.println("5."+" ��Q�v= "+(GPM)+" 15%�H�W, "+" ��Q�v�W��= "+(GPMadd)+" ����V�W ");
				System.out.println("6."+" �t�Ť�v= "+"("+debt+"*100%"+")/"+asset+"="+((debt*100)/asset)+" �C��50%");
				System.out.println("7."+" �ѥ�= "+(CapitalStock)+" �C��30��");
				System.out.println("8."+" ���ʫ���= "+(BossHave)+" ���Ѧh(�j��50%)");
				System.out.println("�ѻ�= "+Price);
				System.out.println("---------------/8424------------------");
				
			}
			if(output.getID().equals("6441")){
				System.out.println("---------------6441------------------");
				System.out.println(detail.toString());
				System.out.println("1."+" ���q������= "+PER+"/"+YearEPSpercent+"="+PER/YearEPSpercent+" �C��0.75");
				System.out.println("2."+" �w�����q��= "+Price+"/"+YearEPS+"="+Price/YearEPS+" �C��15��");
				System.out.println("3."+" �����|��b�Q= "+(YearProfitPercent)+" ������");
				System.out.println("4."+" �ѪF�v�q���S�v= "+(YearROE)+" 15%�H�W");
				System.out.println("5."+" ��Q�v= "+(GPM)+" 15%�H�W, "+" ��Q�v�W��= "+(GPMadd)+" ����V�W ");
				System.out.println("6."+" �t�Ť�v= "+"("+debt+"*100%"+")/"+asset+"="+((debt*100)/asset)+" �C��50%");
				System.out.println("7."+" �ѥ�= "+(CapitalStock)+" �C��30��");
				System.out.println("8."+" ���ʫ���= "+(BossHave)+" ���Ѧh(�j��50%)");
				System.out.println("�ѻ�= "+Price);
				System.out.println("---------------/6441------------------");
				
			}
			
			
			
			
			
			if((PER/YearEPSpercent)<0.75 && (PER/YearEPSpercent)>0 ){
//				System.out.println(ID+" ���q������= "+(PER/YearEPSpercent)+" �C��0.75");
				
				
				
				output.setFirst("V");
				count++;
			}else{
				output.setFirst("X");
			}
			
			//------
		if(Price/YearEPS<=15  ){
//			System.out.println(ID+" �w�����q��= "+(Price/YearEPS)+" �C��15��");
			output.setSecond("V");
			count++;
		}else{
			output.setSecond("X");
		}
		if(YearProfitPercent>0){
//			System.out.println(ID+" �����|��b�Q= "+(YearProfitPercent)+" ������");
			output.setThird("V");
			count++;
		}else{
			output.setThird("X");
		}
		if(YearROE>15){
//			System.out.println(ID+" �ѪF�v�q���S�v= "+(YearROE)+" 15%�H�W");
			output.setFour("V");
			count++;
		}else{
			output.setFour("X");
		}
		
		if(((debt*100)/asset)<50 && ((debt*100)/asset)>0 ){
//			System.out.println(ID+" �t�Ť�v= "+((debt*100)/asset)+" �C��50%");
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
//			System.out.println(ID+" ��Q�v= "+(GPM)+" 15%�H�W, "+" ��Q�v�W��= "+(GPMadd)+" ����V�W ");
			output.setFive("V");
			count++;
		}else{
			output.setFive("X");
		}
		
		if(CapitalStock<=30 && CapitalStock>0){
//			System.out.println(ID+" �ѥ�= "+(CapitalStock)+" �C��30��");
			if(ID.equals("2809")){
//				System.out.println("2809�ѥ�= "+CapitalStock);
			}
			output.setSeven("V");
			count++;
		}else{
			output.setSeven("X");
		}
		if(BossHave>=40){
//			System.out.println(ID+" ���ʫ���= "+(BossHave)+" ���Ѧh(�j��20%)");
			output.setEight("V");
			count++;
		}else{
			output.setEight("X");
		}
		
		
		output.setTotal(count);
		outputList.add(output);
		}
		
		
		
		System.out.println("---------------------------------------------------");
		System.out.println("ID,���q������C��0.75,�w�����q��C��15��,�����|��b�Q������,�ѪF�v�q���S�v15%�H�W,��Q�v15%�H�W�B��Q�v�W�����V�W,�t�Ť�v�C��50%,�ѥ��C��30��,���ʫ��ѫ��Ѧh(�j��20%),�ŦX���󵧼�");
		
		for(int i=0;i<outputList.size();i++){
			Result output=outputList.get(i);
			
//			if(output.getID().equals("2809")){
////				System.out.println("�L��2809�ѥ�= "+output.getSeven());
////				System.out.println(output.toString());
//			}
			
			if( output.getFirst().equals("V") && output.getSecond().equals("V")&& output.getTotal() >5 ){
			
			System.out.println(output.getID()+","+output.getFirst()+","+output.getSecond()+","+output.getThird()+","+output.getFour()+","+output.getFive()+","+output.getSix()+","+output.getSeven()+","+output.getEight()+","+output.getTotal());
			showData(output);
			}
			
//			if(output.getID().equals("8049")) {
//				System.out.println(output.toString());
//				showData(output);
//			}
			
			
		}
		
		
		
	}
	
	public static void showData(Result output) {
		String id=output.getID();
		Detail detail = null;
		for(int i=0;i<result.size();i++) {
			if(id.equals(result.get(i).getId())){
				detail=result.get(i);
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
		if(!detail.getCapitalStock().trim().equals("")){
			 CapitalStock=Double.parseDouble(detail.getCapitalStock().trim());
			}
			
			if(!detail.getPER().trim().equals("")){
			 PER=Double.parseDouble(detail.getPER().trim());
			}else{
				PER=0.0;
			}
		
		System.out.println("---------------"+detail.getId()+"------------------");
		System.out.println(detail.toString());
		System.out.println("1."+" ���q������= "+PER+"/"+YearEPSpercent+"="+PER/YearEPSpercent+" �C��0.75");
		System.out.println("2."+" �w�����q��= "+Price+"/"+YearEPS+"="+Price/YearEPS+" �C��15��");
		System.out.println("3."+" �����|��b�Q= "+(YearProfitPercent)+" ������");
		System.out.println("4."+" �ѪF�v�q���S�v= "+(YearROE)+" 15%�H�W");
		System.out.println("5."+" ��Q�v= "+(GPM)+" 15%�H�W, "+" ��Q�v�W��= "+(GPMadd)+" ����V�W ");
		System.out.println("6."+" �t�Ť�v= "+"("+debt+"*100%"+")/"+asset+"="+((debt*100)/asset)+" �C��50%");
		System.out.println("7."+" �ѥ�= "+(CapitalStock)+" �C��30��");
		System.out.println("8."+" ���ʫ���= "+(BossHave)+" ���Ѧh(�j��50%)");
		System.out.println("�ѻ�= "+Price);
		
		
		
		String Yield=detail.getYield();
		//�`���S�vTROR
		Double TROR=((Double.parseDouble(Yield))+(Double.parseDouble(detail.getYearEPSadd())/100.0))/PER;
		System.out.println("�`���S�v= "+TROR);
		if(TROR >1.2) {
			System.out.println("�ѻ��Q�C��");
		}else if(TROR>0.8 && TROR < 1.2) {
			System.out.println("�ѻ��X�z");
		}else {
			System.out.println("�ѻ��Q����");
		}
		System.out.println("---------------/"+detail.getId()+"------------------");
	}
}
