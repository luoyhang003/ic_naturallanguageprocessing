package OCTools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * javaȥ���ַ����еĿո񡢻س������з����Ʊ��
 * 
 * @author lMingChao Sun
 *
 */
public class OCStringUtils {

	public static String replaceBlank(String str) {
		String dest = "";
		if (str != null) {
			// Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Pattern p = Pattern.compile("\\s*|\t|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}

	public static int dropPX(String str) {

		if (str == null || str.length() <= 2) {
			System.out.println("�ַ�����ʽ����");
			return -1;
		}

		String str2 = str.substring(0, str.length() - 2);
		int num = Integer.parseInt(str2);
		return num;
	}

}
