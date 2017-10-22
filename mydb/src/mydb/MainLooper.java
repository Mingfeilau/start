package mydb;

public class MainLooper {
  private boolean flag=true;
  private Input ip=null;
  private CheckCmd checkCmd =null;
  
  public MainLooper(){
	  super();
	  ip=new Input();
  }
  
  public void loop(){
	  ip=new Input();
	  checkCmd=new CheckCmd();
	  int checkReturn;
	  String ipStream;
	  while(flag){
		  ipStream=ip.getInputLine();//读取一个文本行给ipstream
		  checkReturn=checkCmd.check(ipStream);
		  if(checkReturn==-1){
			  flag=false;
		  }
	  }
  }
}
