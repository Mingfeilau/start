package mydb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
	private BufferedReader bufferedReader = null;
/**
 * ��ȡ�����ַ�����װ��һ���ֽ�����ȡ���ࣩ
 */
	public Input() {
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));// System.in��ԭʼ������������
	}
/**
 * �õ�һ���ı���
 * @return
 */
	public String getInputLine() {
		String inputLine = null;
		try {
			inputLine = bufferedReader.readLine();// ��ȡһ���ı��С�ͨ�������ַ�֮һ������Ϊĳ������ֹ������
													// ('\n')���س� ('\r')
													// ��س���ֱ�Ӹ��Ż��С�
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputLine;
	}
}
