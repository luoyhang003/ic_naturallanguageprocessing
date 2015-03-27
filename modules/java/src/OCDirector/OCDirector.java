package OCDirector;

import java.util.Vector;


import OCPage.OCPage;



/**
 * OfficeCoder �����嵼����
 * 
 * @author MingChao Sun
 *
 */

public class OCDirector {
	private static class OCDirectorHolder {
		private static final OCDirector INSTANCE = new OCDirector();
	}

	private OCDirector() {
		
	}

	public static final OCDirector getInstance() {
		return OCDirectorHolder.INSTANCE;
	}

	/**
	 * ���ɵ�app������
	 */
	private static String appname;

	/**
	 * html���̱����·��
	 */
	private static String ProjectPath;
	
	/**
	 * ��Ŀ¼·��
	 */
	public static String RootPath;
	
	/**
	 * 
	 * index·��
	 */
	public static String IndexPath;
	
	/**
	 * ���ҳ�������
	 */
	public static Vector<OCPage> OCpages = new Vector<OCPage>();

	/**
	 * ���õ�һ��ҳ�� ��index��
	 * @param page
	 */
	public void setIndex(OCPage page){
		page.setIndex(true);
		IndexPath = page.getPath();
	}
	
	/**
	 * ��ҳ����ӽ����̱���ͳһ����
	 * @param page
	 */
	public void addPage(OCPage page){
		OCpages.add(page);
		page.setId(OCpages.size()-1);
	}
	
	/**
	 * ͨ�����˳����Ż�ȡҳ�� ����������򷵻�null
	 * @param i
	 * @return
	 */
	public static OCPage getPagebyid(int i){
		if(i<OCpages.size()){
			return OCpages.get(i);
		}else {
			return null;
		}
		
	}
	
	/**
	 * ͨ��ҳ�����ƻ�ȡ ���û�и�ҳ���򷵻�null
	 * @param pagename
	 * @return
	 */
	public static OCPage getPagebyname(String pagename){
		
		for(int i = 0 ; i < OCpages.size();i++){
			if(OCpages.get(i).getName().equals(pagename)){
				return OCpages.get(i);
			}
		}
		return null;
		
	}
	
	public String getAppname() {
		return appname;
	}

	public void setAppname(String appname) {
		OCDirector.appname = appname;
	}

	public String getProjectPath() {
		return ProjectPath;
	}

	public void setProjectPath(String projectPath) {
		ProjectPath = projectPath;
	}

	public static String getRootPath() {
		return RootPath;
	}

	public static void setRootPath(String rootPath) {
		RootPath = rootPath;
	}

}
