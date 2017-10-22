package mydb;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * ��ȡһ����ȡproperties�ļ�projectpath\resource\Eng.properties
 * 
 * @author liuming-fei
 * @date 2017-9-18
 */
public class IOProperties {
	public IOProperties() {
		super(); // super�ؼ��ּ̳и�����ĳ�Ա
	}

	public void getProperties(String Key) {
		Properties properties = new Properties(); // ����һ���µ�Properties����
		String projectPath = System.getProperty("user.dir");// �õ���ǰ�ļ��ľ���·��D:\workspace-sop\mydb\src\mydb\

		String propertiesPath = projectPath + File.separator + "resources" + File.separator + "Eng.properties";// ��ϵͳ�йص�Ĭ�����Ʒָ���(windows���൱��projectpath\resource\Eng.properties)
		try {
			InputStream in = new FileInputStream(propertiesPath);// FileInputStream��ʵ���࣬���ڶ�ȡ����ͼ������֮���ԭʼ�ֽ�����InputSrteam��һ��ABstract�������������ʵ�������������������Ļ��ࡣ��ȡһ���ֽڲ���֤�����ʽ���أ�0~255��
																	// �������-1�ѵ��������Ľ�β��int
																	// read����throws
																	// IoException
			properties.load(in);
			System.out.println(properties.get(Key)); // �����õ��ַ���
		} catch (Exception e) {
			e.printStackTrace();/*
								 * ���׳��쳣������£��кܶ෽����System.out.println(e);
								 * ���������ӡ���쳣�����������������ֵ��쳣��e.printStackTrace()
								 * Ҳ�Ǵ�ӡ���쳣��������������ʾ������ĵ�����Ϣ������˵��
								 * 
								 * A extends ---> B extends---> C
								 * 
								 * ���ڴ���A�Ĺ����г��������ˣ������׳��쳣��<
								 * 
								 * System.out.println(e)�����˱�׼�쳣�⣬ֻ��ӡat A
								 * Ȼ���������������
								 * 
								 * e.printStackTrace()�����˱�׼�쳣�⣬��ӡ
								 * 
								 * at C
								 * 
								 * at B
								 * 
								 * at A
								 * 
								 * .......���������顣
								 * 
								 * ���������������£���һ������󶼻�ص�com.sun.midp.main.Main.
								 * main
								 */
		}

	}
}
