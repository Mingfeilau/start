package mydb;



public class Action extends UsefulMethod {
	private User user=null;
	private WriteFile writeFile=null;
	private QueryFile queryFile=null;
	private UserInterFace ui=null;
	
	public Action(){
		super();
	}
  public int actAdd(String[] strs){
	  user=new User();
	  writeFile=new WriteFile();
	  int id =Integer.parseInt(strs[1]);
	  int age=Integer.parseInt(strs[3]);
	  int salary=Integer.parseInt(strs[5]);
	  user.getAll(id, strs[2], age, strs[4], salary);
	  writeFile.write(user.toString(),true);
	  sortData();
	  
	  feedBack("ADD");
	  return 0;
		  
	  }
  
  public int actDelete(String[] strs, boolean isId) {
		queryFile = new QueryFile();
		writeFile = new WriteFile();
		String[] ramStrs = new String[100];		//size100
		int resultDelete;
		String[] tempDelete;
		ramStrs = queryFile.showAll();
		if(isId) {
			int j = 0;
			while(true) {
				if(ramStrs[j] == null) {
					resultDelete = -1;
					break;
				}
				tempDelete = ramStrs[j].split(" ");
				if(strs[1].equals(tempDelete[0])) {
					resultDelete = j;
					break;
				}
				j++;
			}
		}else {
			int j = 0;
			while(true) {
				if(ramStrs[j] == null) {
					resultDelete = -1;
					break;
				}
				tempDelete = ramStrs[j].split(" ");
				if(strs[1].equals(tempDelete[1])) {
					resultDelete = j;
					break;
				}
				j++;
			}
		}
		if(resultDelete != -1) {
			ramStrs[resultDelete] = "";
			for(int j = 0; ramStrs[j] != null && j < 100; j++) {
				if( ! "".equals(ramStrs[j])) {
					if(j == 0 || (j == 1 && "".equals(ramStrs[0]))) {	/// BUG DELETE the first line
						writeFile.write(ramStrs[j], false);
					}else {
						writeFile.write(ramStrs[j], true);
					}
				}
			}
		}else {
			return -1;
		}
		feedBack("DELETE");
		return 0;						//temporary
	}
	
	public int actUpdate(String[] strs, boolean isId) {					//Reduce repeat code
		queryFile = new QueryFile();
		writeFile = new WriteFile();
		user = new User();
		ui = new UserInterFace();
		String[] ramStrs = new String[100];		//size100
		int resultUpdate;
		String[] tempUpdate;
		ramStrs = queryFile.showAll();
		if(isId) {
			int j = 0;
			while(true) {
				if(ramStrs[j] == null) {
					resultUpdate = -1;
					break;
				}
				tempUpdate = ramStrs[j].split(" ");
				if(strs[1].equals(tempUpdate[0])) {
					resultUpdate = j;
					break;
				}
				j++;
			}
		}else {
			int j = 0;
			while(true) {
				if(ramStrs[j] == null) {
					resultUpdate = -1;
					break;
				}
				tempUpdate = ramStrs[j].split(" ");
				if(strs[1].equals(tempUpdate[1])) {
					resultUpdate = j;
					break;
				}
				j++;
			}
		}
		if(resultUpdate != -1) {
			tempUpdate = ramStrs[resultUpdate].split(" ");
			int id = Integer.parseInt(tempUpdate[0]);
			int age = Integer.parseInt(tempUpdate[2]);
			int salary = Integer.parseInt(strs[3]);
			user.getAll(id, tempUpdate[1], age, tempUpdate[3], salary);
			ui.displayTablehead();
			System.out.println(user.toString());
			
			ramStrs[resultUpdate] = user.toString();
			for(int j = 0; ramStrs[j] != null && j < 100; j++) {
				if( ! "".equals(ramStrs[j])) {
					if(j != 0) {
						writeFile.write(ramStrs[j], true);
					}else {
						writeFile.write(ramStrs[j], false);
					}
				}
			}
		}else {
			return -1;
		}
		feedBack("UPDATE");
		return 0;
	}
	
	public int actQuery(int typeIndex, int operIndex, String args) {
//		user = new User();
		queryFile = new QueryFile();
		ui = new UserInterFace();
		
		String[] queryStrs = queryFile.query(typeIndex, operIndex, args);
		
		if(queryStrs == null) {
			return -1;
		}else {
			for(int j = 0; j < queryStrs.length; j++)
				System.out.println(queryStrs[j]);
			feedBack("QUERY");
			return 0;
		}
	}
	
	public int actShow() {
		queryFile = new QueryFile();
		ui = new UserInterFace();
		String[] showStrs = queryFile.showAll();
		if(showStrs == null) {
			return -1;
		}
		ui.displayTablehead();
		for(int j = 0; j < showStrs.length; j++)
			if(/* !"".equals(showStrs[j]) &&*/ showStrs[j] != null)
				System.out.println(showStrs[j]);
		feedBack("SHOW");
		return 0;
	}
	
}


