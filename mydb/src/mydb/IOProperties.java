package mydb;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取一个读取properties文件projectpath\resource\Eng.properties
 * 
 * @author liuming-fei
 * @date 2017-9-18
 */
public class IOProperties {
	public IOProperties() {
		super(); // super关键字继承父类里的成员
	}

	public void getProperties(String Key) {
		Properties properties = new Properties(); // 创建一个新的Properties对象
		String projectPath = System.getProperty("user.dir");// 得到当前文件的绝对路径D:\workspace-sop\mydb\src\mydb\

		String propertiesPath = projectPath + File.separator + "resources" + File.separator + "Eng.properties";// 与系统有关的默认名称分隔符(windows中相当于projectpath\resource\Eng.properties)
		try {
			InputStream in = new FileInputStream(propertiesPath);// FileInputStream是实现类，用于读取诸如图像数据之类的原始字节流；InputSrteam是一个ABstract的类根本不可能实例化，是所有输入流的基类。读取一个字节并以证书的形式返回（0~255）
																	// 如果返回-1已到输入流的结尾。int
																	// read（）throws
																	// IoException
			properties.load(in);
			System.out.println(properties.get(Key)); // 输出获得的字符串
		} catch (Exception e) {
			e.printStackTrace();/*
								 * 在抛出异常的情况下，有很多方法，System.out.println(e);
								 * 这个方法打印出异常，并且输出在哪里出现的异常；e.printStackTrace()
								 * 也是打印出异常，但是它还将显示出更深的调用信息。比如说：
								 * 
								 * A extends ---> B extends---> C
								 * 
								 * 当在创建A的过程中出现问题了，我们抛出异常。<
								 * 
								 * System.out.println(e)，除了标准异常外，只打印at A
								 * 然后再向外层层输出。
								 * 
								 * e.printStackTrace()，除了标准异常外，打印
								 * 
								 * at C
								 * 
								 * at B
								 * 
								 * at A
								 * 
								 * .......再向外层调查。
								 * 
								 * 在向外层调查的情况下，都一样。最后都会回到com.sun.midp.main.Main.
								 * main
								 */
		}

	}
}
