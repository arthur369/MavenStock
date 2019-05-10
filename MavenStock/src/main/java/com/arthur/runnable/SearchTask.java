package com.arthur.runnable;

import java.util.ArrayList;

import com.arthur.tool.CommonMethod;
import com.arthur.vo.Detail;

import edu.emory.mathcs.backport.java.util.concurrent.Callable;

public class SearchTask implements Callable{

	int start;
	int end;
	
	
	
	
	public SearchTask(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}










	public Object call() throws Exception {
		ArrayList<Detail> detailList=new ArrayList<Detail>();
		 for(int i=start;i<end;i++) {
			 try {
			 detailList.add(CommonMethod.getDetail(i));
			 }catch(Exception e) {
				 System.out.println(i+"Data not found");
			 }
		 }
		
		
		
		return detailList;
	}

}
