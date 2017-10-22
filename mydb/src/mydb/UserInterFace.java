/**
 * 
 */
package mydb;

/**
 * @author liumingfei
 *
 */
public class UserInterFace {
	private IOProperties io = new IOProperties();

	public void displayWelcom() {
		io.getProperties("welcome");
	}

	public void displayAdd() {
		io.getProperties("add");
	}

	public void displayDelete() {
		io.getProperties("delete");
	}

	public void displayUpdate() {
		io.getProperties("update");
	}

	public void displayQuery() {
		io.getProperties("query");
	}

	public void displayShow() {
		io.getProperties("show");
	}

	public void displayQuit() {
		io.getProperties("quit");
	}

	public void displayError() {
		io.getProperties("error");
	}

	public void displayTablehead() {
		io.getProperties("tablehead");

	}

	public void displayQueryFail() {
		io.getProperties("queryfail");
	}

	public void displayMembExist() {
		io.getProperties("membexist");
	}

	public void displayUserInfo(User user) {
		System.out.println("id:" + user.getId() + " name:" + user.getName() + "  age:" + user.getAge() + " gender:"
				+ user.getGender() + "  salary:" + user.getSalary());
	}
}
