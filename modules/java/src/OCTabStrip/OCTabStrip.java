package OCTabStrip;

import java.io.File;
import java.util.Map;

import OCDirector.OCDirector;
import OCDirector.OCView;
import OCTools.OCFileWorker;
import OCTools.OCHtmlWorker;
import OCValue.OCStaticValue;

public class OCTabStrip extends OCView {

	private String mode;

	/**
	 * 
	 * @param height
	 * @param width
	 * @param mode
	 *            (Left right top bottom)
	 * @param Pages
	 * 
	 */
	public OCTabStrip(int height,String name, String mode,
			Map<String, String>... Pages) {
		super();

		this.width = width;
		this.height = height;

		this.mode = mode;

		/*
		 * 库文件复制
		 */
		File srcFile1 = new File(OCStaticValue.LibraryURl
				+ "/component/TabHost1.html");
		File destDir = new File(OCDirector.RootPath);
		OCFileWorker.copyFile(srcFile1, destDir, name+".html");

		Path = OCDirector.RootPath +"/"+ name+".html";

		


		setMode("bottom");

		addPages(Pages);

	}

	/**
	 * 设置tab高度
	 * @param Height
	 */
	public void setHeight(int Height){
		
		String innerHtml = "html {font-size: 12px;font-family: Arial, Helvetica, sans-serif;}.demo-section .k-tabstrip .k-content {height: "+Height+"px;}";
		
		OCHtmlWorker.changeHtml(Path, "#css", innerHtml);

	}
	
	/**
	 * 设置tab的方位 left right top bottom
	 * 
	 * @param Mode
	 */
	public void setMode(String Mode) {

		String innerHtml = "$(document).ready(function() {$(\"#tabstrip\").kendoTabStrip({tabPosition: \""
				+ Mode
				+ "\",animation: {open: {effects: \"fadein\"}}});});var app = new kendo.mobile.Application(document.body);";

		OCHtmlWorker.changeHtml(Path, "#mode", innerHtml);

	}

	private void addPages(Map<String, String>[] pages) {

		for(int i = 0 ; i < pages.length ; i++){
			if(i == 0){
				String LabelinnerHtml = "<li class=\"k-state-active\">"+pages[i].get("TabName")+"</li>";

				OCHtmlWorker.innerHtml(Path, "#label", LabelinnerHtml);
			}else{
				String LabelinnerHtml = "<li>"+pages[i].get("TabName")+"</li>";

				OCHtmlWorker.innerHtml(Path, "#label", LabelinnerHtml);
			}
			
			
			String PageinnerHtml = "<div data-role=\"view\"><iframe  scrolling=\"no\" frameborder=\"0\" width=\"100%\" height=\"100%\" allowtransparency=\"true\" src=\""+pages[i].get("PageURL")+"\"></iframe></div>";
			
			OCHtmlWorker.innerHtml(Path, "#tabstrip", PageinnerHtml);
			
		}
		
		

	}

}