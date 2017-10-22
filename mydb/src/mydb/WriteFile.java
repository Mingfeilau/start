package mydb;

import java.io.*;

/**将数据存储进/resources/Dat.txt里
 * @author liumingfei
 *@date  2017-10-4
 */
public class WriteFile {
   private FileWriter fileWriter= null;
   public void write(String buffer,boolean append){
	   try{
		   fileWriter=new FileWriter("./resources/Dat.txt",append);
		   fileWriter.append(buffer+"\n");
	   }catch(Exception e){
		   e.printStackTrace();
	   }finally{
		   try{
			   fileWriter.close();
		   }catch(IOException e){
			   e.printStackTrace();
		   }
	   }
   }
}