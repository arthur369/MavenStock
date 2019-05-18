package com.arthur.tess4jDemo;

import java.io.File;

import net.sourceforge.tess4j.Tesseract1;
import net.sourceforge.tess4j.TesseractException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws TesseractException
    {
    	Tesseract1 instance;
    	  instance = new Tesseract1();
    	  instance.setDatapath("D:\\tesseract\\Tesseract-OCR\\tessdata");
//    	  instance.setTessVariable("tessedit_char_whitelist", "0123456789abcdefghijklmnopqrstuvwxyz");
    	  instance.setLanguage("eng");
    	  System.out.println("doOCR on a PNG image");
          File imageFile = new File("d:/1024.jpg");
          String result = instance.doOCR(imageFile);
          System.out.println(result);
    }
}
