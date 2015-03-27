package OCTools;

import java.util.List;

import com.osbcp.cssparser.CSSParser;
import com.osbcp.cssparser.Rule;


/**
 * 
 * @author MingChao Sun
 *
 *	 该类用于CSS的解析与设置
 *
 */
public class OCCSSWorker {

	
	@SuppressWarnings("unused")
	public static String getCSSBySeletor(String CSSSource,String seletor){
		String result = "";
		
		String CSSSource1 = OCStringUtils.replaceBlank(CSSSource);
		System.out.println(CSSSource);
		List<Rule> rules = null;
		try {
			rules = CSSParser.parse(CSSSource);
		} catch (Exception e) {
			System.out.println("CSS非法");
			e.printStackTrace();
		}
			
		return result;
	}
}
