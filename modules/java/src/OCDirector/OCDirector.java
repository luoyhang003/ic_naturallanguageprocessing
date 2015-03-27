package OCDirector;

import java.util.Vector;


import OCPage.OCPage;



/**
 * OfficeCoder 的总体导演类
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
	 * 生成的app的名称
	 */
	private static String appname;

	/**
	 * html工程保存的路径
	 */
	private static String ProjectPath;
	
	/**
	 * 根目录路径
	 */
	public static String RootPath;
	
	/**
	 * 
	 * index路径
	 */
	public static String IndexPath;
	
	/**
	 * 存放页面的向量
	 */
	public static Vector<OCPage> OCpages = new Vector<OCPage>();

	/**
	 * 设置第一个页面 （index）
	 * @param page
	 */
	public void setIndex(OCPage page){
		page.setIndex(true);
		IndexPath = page.getPath();
	}
	
	/**
	 * 将页面添加进工程便于统一管理
	 * @param page
	 */
	public void addPage(OCPage page){
		OCpages.add(page);
		page.setId(OCpages.size()-1);
	}
	
	/**
	 * 通过添加顺序序号获取页面 如果不存在则返回null
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
	 * 通过页面名称获取 如果没有该页面则返回null
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
