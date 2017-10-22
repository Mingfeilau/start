package mydb;

import java.util.regex.Pattern;

public class UsefulMethod {
	private QueryFile queryFile;
	private WriteFile writeFile;

	
	protected void feedBack(String s) {
		System.out.println("< "+s+" successfully.>");
		System.out.println();
	}
	
	protected boolean isNumberic(String str){
	    Pattern pattern = Pattern.compile("[0-9]*");
	    return pattern.matcher(str).matches();   
	}
	
	/**
	 * @param strs
	 * @return
	 */
	protected boolean isLegalNum(String[] strs) {
		boolean legal = true;
		for(int j = 1; j < 6; j += 2)
			if(Integer.parseInt(strs[3]) < 120) {
				if( ! isNumberic(strs[j]) || Integer.parseInt(strs[j]) < 0 || Integer.parseInt(strs[j]) == 0){
					legal = false;
				}
			}else {
				legal = false;
			}
		return legal;
	}
	
	protected boolean isRepeat(String[] strs) {				
		queryFile = new QueryFile();
		boolean repeatReturn = true;
		if(queryFile.query(0, 2 ,strs[1]) == null && queryFile.query(1, 2, strs[2]) == null) 
			repeatReturn = false;
		return repeatReturn;
	}

	protected void sortData() {
		writeFile = new WriteFile();
		queryFile = new QueryFile();
		int[] dataNum = new int[100];
		String[] tempStrs;
		String[] dataStrs = queryFile.showAll();
		for(int j = 0; j == 0 || dataStrs[j] != null; j++) {
//			System.out.println(dataStrs[j]);
			tempStrs = dataStrs[j].split(" ");
			dataNum[j] = Integer.parseInt(tempStrs[0]);
//			System.out.println(dataNum[j]);			
		}
		int min;
		int minIndex;
		for(int j = 0; dataStrs[j] != null; j++) {
			min = Integer.MAX_VALUE;
			minIndex = Integer.MAX_VALUE;
			for(int k = 0; dataStrs[k] != null; k++)
				if(dataNum[k] < min && dataNum[k] != 0) {
					min = dataNum[k];
					minIndex = k;
			}
			dataNum[minIndex] = 0;
//			System.out.println(dataStrs[minIndex]);
			if(j == 0) {
				writeFile.write(dataStrs[minIndex], false);				
			}else {
				writeFile.write(dataStrs[minIndex], true);
			}
		}
	}
	
	protected String[] cutStringArrays(String[] resultStrs){
		int strsLen;
		for(strsLen = 0; resultStrs[strsLen] != null; strsLen++);
//		System.out.println("< "+strsLen+" result(s).>");					///except
		String[] cutStrs = new String[strsLen];
		for(int j = 0; j < strsLen; j++)
			cutStrs[j] = resultStrs[j];
		return cutStrs;
	}
}
