package mydb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author liumingfei 
 *2017-10-11
 */
public class QueryFile extends UsefulMethod{
  
	  private FileReader fileReader=null;
	  private BufferedReader bufferedReader=null;
	  public String[] showAll() {							//SHOW command
			int resultCount = 0;
			String[] strs = new String[100];		//size: 100 members
			try {
				fileReader = new FileReader("./resources/Data.txt");
				bufferedReader = new BufferedReader(fileReader);	// /home/hadoop/eclipse-workspace/MyDatabase
															
				String tempStr;
				for(resultCount = 0; (resultCount == 0 || strs[resultCount-1] != null);) {	//short cut
					try {
						if( ! "".equals((tempStr = bufferedReader.readLine()))) { 
							strs[resultCount] = tempStr;
							resultCount++;
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}finally {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(resultCount == 1 && strs[0] == null) {
				System.out.println("< 0 result(s).>");	
				return null;
			}else {
				String[] resultStrs = cutStringArrays(strs);
				System.out.println("< "+resultStrs.length+" result(s).>");
				return resultStrs;
			}
		}
	  
	  public String[] query(int typeIndex, int operIndex, String args) {				//QUERY command
			String[] resultStrs = new String[100];
			String tempStr;
			String[] tempStrs = new String[5];
			int queryIndex = typeIndex;
			
			try {
				fileReader = new FileReader("./resources/Data.txt");
				bufferedReader = new BufferedReader(fileReader);	// /home/hadoop/eclipse-workspace/MyDatabase
				
				for(int j = 0;;) {
					try {
						tempStr = bufferedReader.readLine();
						if(tempStr == null) {
							if(j == 0)
								resultStrs = null;
							break;
						}
						if(!"".equals(tempStr)) {
							tempStrs = tempStr.split(" ");//分割读取到的数据bufferedReader.readLine()
							if(queryIndex == 1 || queryIndex == 3) {
								if(args.equals(tempStrs[queryIndex])) {
									resultStrs[j] = tempStr;//一行数据赋值给字符串数组resultStrs[j]
									j++;
								}
							}else {
								int argsNum = Integer.parseInt(args);
								int dataNum = Integer.parseInt(tempStrs[queryIndex]);
								switch(operIndex) {
								case 1:
									if(dataNum < argsNum) {
										resultStrs[j] = tempStr;
										j++;
									}break;

								case 2:
									if(dataNum == argsNum) {
										resultStrs[j] = tempStr;
										j++;
									}break;
									
								case 3:
									if(dataNum > argsNum) {
										resultStrs[j] = tempStr;
										j++;
									}break;
								}
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}finally {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			String[] lastResultStrs;
			if(resultStrs != null) {
				lastResultStrs = cutStringArrays(resultStrs);
				System.out.println("< "+lastResultStrs.length+" result(s).>");
			}else {
				System.out.println("< 0 result(s).>");	
				lastResultStrs = resultStrs;
			}
			return lastResultStrs;
		}

	  
}
