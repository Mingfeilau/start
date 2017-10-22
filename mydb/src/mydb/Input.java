package mydb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
	private BufferedReader bufferedReader = null;
/**
 * 读取缓冲字符（包装了一个字节流读取的类）
 */
	public Input() {
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));// System.in是原始的输入流对象
	}
/**
 * 得到一个文本行
 * @return
 */
	public String getInputLine() {
		String inputLine = null;
		try {
			inputLine = bufferedReader.readLine();// 读取一个文本行。通过下列字符之一即可认为某行已终止：换行
													// ('\n')、回车 ('\r')
													// 或回车后直接跟着换行。
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputLine;
	}
}
