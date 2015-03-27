package OCTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import com.officecoder.android.CompilerUtil;

public class AndroidTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 CompilerUtil cu = new CompilerUtil("E:\\android\\OfficeCoder_Android","test1");
		 cu.setURL("http://211.87.226.143:8080/OfficeCoder/5c933fabed1a469c85fe70f93546ccdb/test1/page0.html");
		 cu.generateR();
		 cu.compileJava();
		 cu.generateClasses();
		 cu.compileRes();
		 cu.apkbuilder();
		 cu.generateKeytool();
		 cu.signJar();
		 cu.copyApk("5c933fabed1a469c85fe70f93546ccdb", "test1");
		 cu.deleteApk("test1");
		 cu.deleteKeyFile();

		System.out.println(getURL());
	}

	private static String getURL() {
		/*
		 * ¶ÁÈëTXTÎÄ¼þ
		 */
		File file = new File("E:\\android\\OfficeCoder_Android\\src\\Properties\\url.txt");
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));

			String content = "";
			StringBuilder sb = new StringBuilder();

			while (content != null) {
				content = bf.readLine();

				if (content == null) {
					break;
				}

				sb.append(content.trim());
			}

			bf.close();
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
