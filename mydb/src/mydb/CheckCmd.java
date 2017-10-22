package mydb;

public class CheckCmd extends UsefulMethod{
	private Action action;
	private UserInterFace ui;
	
	public CheckCmd() {
		super();
	}
	
	public int check(String ipStream) /*throws Exception*/ {
		action = new Action();
		ui = new UserInterFace();
		String[] strs = ipStream.split(" ");
		
		switch(strs[0]) {
		case "ADD":
			if(strs.length != 6) {
				ui.displayAdd();
				return 0;
			}
			checkAdd(strs);
			break;
		case "DELETE":
			if(strs.length != 2) {
				ui.displayDelete();
				return 0;
			}
			checkDelete(strs);
			break;
		case "UPDATE":
			if(strs.length != 4 || !"salary".equals(strs[2])) {
				ui.displayUpdate();
				return 0;
			}
			checkUpdate(strs);
			break;
		case "QUERY":
			if(strs.length != 4) {				
				ui.displayQuery();			
				return 0;						
			}
			checkQuery(strs);
			break;
		case "SHOW":
			if(strs.length != 1) {
				ui.displayShow();
				return 0;
			}
			checkShow();
			break;
		case "QUIT":
			if(strs.length != 1) {
				ui.displayQuit();
				return 0;
			}
			checkQuit();
			return -1;
		default :
			ui.displayError();
		}
		
		return 0;
	}
	
	private int checkAdd(String[] strs) {
		if(isLegalNum(strs) && (strs[4].equals("M") || strs[4].equals("F"))) {
			if( ! isRepeat(strs)) {
				action.actAdd(strs);
			}else {
				ui.displayMembExist();
				ui.displayAdd();
			}
		}else{
			ui.displayError();
			ui.displayAdd();
		}
		return 0;
	}

	private int checkDelete(String[] strs) {
		int deleteReturn;
		boolean isId = isNumberic(strs[1]);
		deleteReturn = action.actDelete(strs, isId);
		
		if(deleteReturn == -1) {
			ui.displayQueryFail();
			ui.displayDelete();
		}
		return 0;
	}
	
	private int checkUpdate(String[] strs) {
		int updateReturn;
		boolean isId = isNumberic(strs[1]);
		updateReturn = action.actUpdate(strs, isId);
		
		if(updateReturn == -1) {
			ui.displayQueryFail();
			ui.displayUpdate();
		}
		return 0;
	}

	private int checkQuery(String[] strs) {		/// <id> <name> <age> <gender> <salary>	type index
		int queryReturn;					//	 0      1	  2      3        4 
		int typeIndex;					/// QUERY <type> <operator> <argument>	operator index
		int operIndex;					/// operator  1.<  2.=  3.>	
		
		switch(strs[1]) {
		case "id":
			typeIndex = 0;
			break;
		case "name":
			typeIndex = 1;
			break;
		case "age":
			typeIndex = 2;
			break;
		case "gender":
			typeIndex = 3;
			break;
		case "salary":
			typeIndex = 4;
			break;
		default :
			ui.displayQuery();	
			return 0;
		}
		if(typeIndex == 1 || typeIndex == 3) {
			if("=".equals(strs[2])) {
				if(!isNumberic(strs[3])) {
					if(typeIndex == 3 && (!"M".equals(strs[3]) && !"F".equals(strs[3]))) {
							ui.displayQuery();
							ui.displayQuery();
							return 0;
					}
					operIndex = 2;
				}else {
					ui.displayQuery();
					return 0;
				}
			}else {
				ui.displayQuery();
				return 0;
			}
		}else {
			switch(strs[2]) {
			case "<":
				operIndex = 1;
				break;
			case "=":
				operIndex = 2;
				break;
			case ">":
				operIndex = 3;
				break;
			default :
				ui.displayQuery();
				return 0;
			}
			if( ! isNumberic(strs[3])){
				ui.displayQuery();
				return 0;
			}
		}
		queryReturn = action.actQuery(typeIndex, operIndex, strs[3]);
		if(queryReturn == -1) {
			ui.displayQueryFail();
			ui.displayQuery();
		}
		return 0;
	}

	private int checkShow() {
		if(action.actShow() == -1) {
			ui.displayQueryFail();
			ui.displayShow();
		}
		return 0;
	}

	private int checkQuit() {
		System.out.println("Áº³¯Î°ÌáÐÑÄú£º»¶Ó­Ê¹ÓÃ£¬ÒÑÍË³ö.");
		return 0;
	}
}
