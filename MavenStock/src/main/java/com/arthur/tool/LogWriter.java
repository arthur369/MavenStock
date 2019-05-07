package com.arthur.tool;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 嚙誕用歹蕭class: java.io.PrintWriter; java.io.BufferedWriter; java.io.FileWriter;
 */
// 撖勁og�嚗��tibco��hareProcess/LogWriter
public class LogWriter {

	// ����
	// public static void main(String args[]){
	// try{
	// FileWriter fw = new FileWriter("c:\\javawork\\hello2.txt");
	//
	// BufferedWriter bw = new BufferedWriter(fw);
	//
	// PrintWriter pw = new PrintWriter(bw);
	//
	// pw.println("Hello World 嚙瑾嚙褕你嚙緯2 !");
	// // pw.write("Hello World 嚙瑾嚙褕你嚙緯2 !"); //嚙稽嚙箠嚙誕伐蕭
	// pw.close();
	// bw.close();
	// fw.close();
	// }catch( IOException e){
	// System.err.println(e);
	// }
	// }

	public static void write(String code, String msg, String path, String InputData, String desc, String LogLevel,
			String LogConsole) {
		StringBuffer fileName;
		StringBuffer textContent;
		int addLineSeparator;
		String encoding;
		StringBuffer message;
		String msgCode;

		if (code.substring(0, 1).equals("1") && Integer.parseInt(LogLevel) >= 3) {

			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String myday = sdf.format(today);

			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S XXX");
			String day = sdf2.format(today);

			// fileName="C:\\Users\\Arthur\\Desktop\\newFolder"+"\\log\\"+"HNS_PortService10104"+myday+"log";
			fileName = new StringBuffer();
			// fileName.append("C:\\Users\\Arthur\\Desktop\\newFolder");
			fileName.append("C:\\usr\\local\\tibco\\eai");
			fileName.append("\\log\\");
			fileName.append("HNS_PortService10001");
			fileName.append("_audit_");
			fileName.append(myday);
			fileName.append(".log");

			textContent = new StringBuffer();
			textContent.append("<Evt>");
			textContent.append(day);
			textContent.append("~");
			textContent.append(code);
			textContent.append("~");
			textContent.append(msg);
			textContent.append("~");
			textContent.append(path);
			textContent.append("~");
			textContent.append(InputData);
			textContent.append("~");
			textContent.append(desc);
			textContent.append("</Evt>");
			addLineSeparator = 1;
			encoding = "MS950";
			message = new StringBuffer();
			message.append("message:");
			message.append(msg);
			message.append("<BR>\r\n");
			message.append("path:");
			message.append(path);
			message.append("<BR>\r\n");
			message.append("Input Data:");
			message.append(InputData);
			message.append("<BR>\r\n");
			message.append("Description:");
			message.append(desc);
			message.append("<BR>\r\n");
			msgCode = code;

			if (LogConsole.equals("2")) {
				//撖急���
//				writeAudit(fileName.toString(), textContent.toString(), addLineSeparator, encoding);
				
				//撖勁og
				
				
			} else if (LogConsole.equals("1")) {
			} else {

			}
		}

		if (!code.substring(0, 1).equals("1") && !code.substring(0, 1).equals("0") && Integer.parseInt(LogLevel) >= 2) {

			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String myday = sdf.format(today);

			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S XXX");
			String day = sdf2.format(today);
			System.out.println("print textContent day= " + day);

			// fileName="C:\\Users\\Arthur\\Desktop\\newFolder"+"\\log\\"+"HNS_PortService10104"+myday+"log";
			fileName = new StringBuffer();
			fileName.append("C:\\usr\\local\\tibco\\eai");
			fileName.append("\\log\\");
			fileName.append("HNS_PortService10001");
			fileName.append("_err_");
			fileName.append(myday);
			fileName.append(".log");

			textContent = new StringBuffer();
			textContent.append("<Evt>");
			textContent.append(day);
			textContent.append("~");
			textContent.append(code);
			textContent.append("~");
			textContent.append(msg);
			textContent.append("~");
			textContent.append(path);
			textContent.append("~");
			textContent.append(InputData);
			textContent.append("~");
			textContent.append(desc);
			textContent.append("</Evt>");
			addLineSeparator = 1;
			encoding = "MS950";
			message = new StringBuffer();
			message.append("message:");
			message.append(msg);
			message.append("<BR>\r\n");
			message.append("path:");
			message.append(path);
			message.append("<BR>\r\n");
			message.append("Input Data:");
			message.append(InputData);
			message.append("<BR>\r\n");
			message.append("Description:");
			message.append(desc);
			message.append("<BR>\r\n");
			msgCode = code;

			if (LogConsole.equals("2")) {
				//撖急���
//				writeAudit(fileName.toString(), textContent.toString(), addLineSeparator, encoding);
				
				//撖勁og
				
			} else if (LogLevel.equals("1")) {
			} else {

			}
		}

		if (code.substring(0, 1).equals("0") && Integer.parseInt(LogLevel) >= 5) {

			Date today = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String myday = sdf.format(today);

			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S XXX");
			String day = sdf2.format(today);

			// fileName="C:\\Users\\Arthur\\Desktop\\newFolder"+"\\log\\"+"HNS_PortService10104"+myday+"log";
			fileName = new StringBuffer();
			fileName.append("C:\\usr\\local\\tibco\\eai");
			fileName.append("\\log\\");
			fileName.append("HNS_PortService10001");
			fileName.append("_hb_");
			fileName.append(myday);
			fileName.append(".log");

			textContent = new StringBuffer();
			textContent.append("<Evt>");
			textContent.append(day);
			textContent.append("~");
			textContent.append(code);
			textContent.append("~");
			textContent.append(msg);
			textContent.append("~");
			textContent.append(path);
			textContent.append("~");
			textContent.append(InputData);
			textContent.append("~");
			textContent.append(desc);
			textContent.append("</Evt>");
			addLineSeparator = 1;
			encoding = "MS950";
			message = new StringBuffer();
			message.append("message:");
			message.append(msg);
			message.append("<BR>\r\n");
			message.append("path:");
			message.append(path);
			message.append("<BR>\r\n");
			message.append("Input Data:");
			message.append(InputData);
			message.append("<BR>\r\n");
			message.append("Description:");
			message.append(desc);
			message.append("<BR>\r\n");
			msgCode = code;

			//撖急���
//			writeAudit(fileName.toString(), textContent.toString(), addLineSeparator, encoding);

			//撖勁og
			
			
		}

	}

	public static void writeAudit(String fileName, String textContent, int addLineSeparator, String encoding,boolean append) {
		try {

			String DirectoryPath = fileName.substring(0, fileName.lastIndexOf("\\"));

//			System.out.println("DirectoryPath= " + DirectoryPath);
			File file = new File(DirectoryPath);
			if (!file.exists()) {
				file.mkdir();
			}
			FileWriter fw = new FileWriter(fileName, append);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			System.out.println( textContent);

			pw.println(textContent);

			for (int i = 0; i < addLineSeparator - 1; i++) {
				pw.println();
			}

			pw.flush();
			pw.close();
			bw.close();
			fw.close();

		} catch (IOException e) {
			System.err.println(e);
		}

	}

	
	


}
