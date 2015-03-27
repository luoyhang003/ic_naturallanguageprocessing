package com.officecoder.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import OCAnimation.OCAnimation_LoveMusic;
import OCButton.OCButton_Cancel;
import OCButton.OCButton_ColorBorder;
import OCButton.OCButton_DOWN;
import OCButton.OCButton_Flat;
import OCButton.OCButton_Green;
import OCButton.OCButton_Grid;
import OCButton.OCButton_Heart;
import OCButton.OCButton_Idea;
import OCButton.OCButton_Modify;
import OCButton.OCButton_Music;
import OCButton.OCButton_Music_Play_Pause;
import OCButton.OCButton_OK;
import OCButton.OCButton_Paint;
import OCButton.OCButton_Picture;
import OCButton.OCButton_Plugins;
import OCButton.OCButton_Star;
import OCButton.OCButton_UP;
import OCButton.OCButton_Video;
import OCButton.OCShineButton;
import OCDirector.OCDirector;
import OCImageSwitch.OCImageSwitch3;
import OCImageView.OCImageView;
import OCLine.OCLine;
import OCMusicPlayer.OCMusicPlayer;
import OCPage.OCPage;
import OCSwitch.OCSwitch1;
import OCTabStrip.OCTabStrip;
import OCTextAndImageView.OCTextAndImageView;
import OCTextView.OCTextView1;
import OCTextView.OCTextView2;

/**
 * 解析xml文件组装成HTML
 * 
 * @author xing
 * 
 */
public class XMLReader {
	/**
	 * OCDirector 对象
	 */
	private OCDirector director;

	/**
	 * 保留默认的构造方法
	 */
	public XMLReader() {
		director = OCDirector.getInstance();
		director.setRootPath("C:/OfficeCoder/5c933fabed1a469c85fe70f93546ccdb/test1");
	}

	/**
	 * 遍历组装好的xml文件，根据不同的控件调用不同的方法
	 * 
	 * @param filePath
	 */
	@SuppressWarnings("rawtypes")
	public void XMLToHTML(String filePath) {
		try {
			/*
			 * 创建SAXReader读取器，专门用于读取xml
			 */
			SAXReader saxReader = new SAXReader();
			/*
			 * 获取Document对象 必须指定文件的绝对路径
			 */
			File file = new File(filePath);
			if (!file.exists()) {
				System.out.println("not exits!!!!!");
				return;
			}

			file.setExecutable(true);
			file.setReadable(true);
			file.setWritable(true);

			Document document = saxReader.read(file);
			/*
			 * 获取根节点
			 */
			Element root = document.getRootElement();
			/*
			 * 根据根结点获取所有的Page结点
			 */
			List pageList = root.elements("Page");

			/*
			 * 遍历Page结点可以得到所有的这页中的控件
			 */
			for (Object obj : pageList) {
				Element page = (Element) obj;
				OCPage currentPage = addPage(page);
				/*
				 * 获取Page中的所有的控件结点，放在一个List中
				 */
				@SuppressWarnings("unchecked")
				List<Element> widgetList = page.elements();
				/*
				 * 利用便利器遍历所有的控件结点
				 */
				Iterator<Element> widgetIt = widgetList.iterator();
				Element widget = null;
				while (widgetIt.hasNext()) {
					widget = widgetIt.next();
					addWidget(currentPage, widget);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据xml文件组装添加page
	 * 
	 * @param page
	 * @return
	 */
	private OCPage addPage(Element page) {
		String pageName = page.attributeValue("name");
		String pageIndex = page.attributeValue("index");
		String pageType = page.attributeValue("type");
		String url = page.attributeValue("url");
		String pageBackground = page.attributeValue("background");
		String pageBackgroundType = page.attributeValue("backgroundtype");

		System.out.println(pageName + "  " + pageIndex + " " + pageType + "  "
				+ pageBackground + "  " + pageBackgroundType + "  " + url);
		// /System.exit(0);
		OCPage testpage = null;
		if (pageType.equals("local")) {
			testpage = new OCPage(OCPage.OCPageType_LOCAL, pageName);
		} else if (pageType.equals("web")) {
			testpage = new OCPage(OCPage.OCPageType_Web, url);
		} else if (pageType.equals("full")) {
			testpage = new OCPage(OCPage.OCPageType_Web, url);
		} else {
			System.out.println("page类型错误");
		}

		if (Boolean.getBoolean(pageIndex)) {
			director.setIndex(testpage);
		}

		if (pageBackgroundType.equals("color")) {
			testpage.setbackground(OCPage.OCPageBgType_Color, pageBackground);
		} else if (pageBackgroundType.equals("image")) {
			testpage.setbackground(OCPage.OCPageBgType_Img, pageBackground);
		} else {
			System.out.println("page背景类型错误");
		}

		director.addPage(testpage);

		return testpage;
	}

	/**
	 * 根据不同的Element的名称选择不同的添加方法
	 */
	private void addWidget(OCPage page, Element widget) {
		String name = widget.getName();
		/*
		 * 根据不同的名称选择对应的方法
		 */
		switch (name) {
		case "OCButton_Cancel":
			addOCButton_Cancel(page, widget);
			break;
		case "OCButton_ColorBorder":
			addOCButton_ColorBorder(page, widget);
			break;
		case "OCButton_Down":
			addOCButton_Down(page, widget);
			break;
		case "OCButton_Flat":
			addOCButton_Flat(page, widget);
			break;
		case "OCButton_Green":
			addOCButton_Green(page, widget);
			break;
		case "OCButton_Grid":
			addOCButton_Grid(page, widget);
			break;
		case "OCButton_Heart":
			addOCButton_Heart(page, widget);
			break;
		case "OCButton_Idea":
			addOCButton_Idea(page, widget);
			break;
		case "OCButton_Modify":
			addOCButton_Modify(page, widget);
			break;
		case "OCButton_Music":
			addOCButton_Music(page, widget);
			break;
		case "OCButton_Music_Play_Pause":
			addOCButton_Music_Play_Pause(page, widget);
			break;
		case "OCButton_OK":
			addOCButton_OK(page, widget);
			break;
		case "OCButton_Paint":
			addOCButton_Paint(page, widget);
			break;
		case "OCButton_Picture":
			addOCButton_Picture(page, widget);
			break;
		case "OCButton_Plugins":
			addOCButton_Plugins(page, widget);
			break;
		case "OCButton_Star":
			addOCButton_Star(page, widget);
			break;
		case "OCButton_UP":
			addOCButton_UP(page, widget);
			break;
		case "OCButton_Video":
			addOCButton_Video(page, widget);
			break;
		case "OCShineButton":
			addOCShineButton(page, widget);
			break;
		case "OCSwitch1":
			addOCSwitch1(page, widget);
			break;
		case "OCSwitch2":
			addOCSwitch2(page, widget);
			break;
		case "OCSwitch3":
			addOCSwitch3(page, widget);
			break;
		case "OCTextView1":
			addOCTextView1(page, widget);
			break;
		case "OCAnimation_LoveMusic":
			addOCAnimation_LoveMusic(page, widget);
			break;
		case "OCLine":
			addOCLine(page, widget);
			break;
		case "OCImageSwitch3":
			addOCImageSwitch3(page, widget);
			break;
		case "OCimageView":
			addOCimageView(page, widget);
			break;
		case "OCMusicPlayer":
			addOCMusicPlayer(page, widget);
			break;
		case "OCTextImageView":
			addOCTextImageView(page, widget);
			break;
		case "OCTextView2":
			addOCTextView2(page, widget);
		case "TabHost1":
			addTabHost1(page, widget);
			break;
		}
	}

	/**
	 * 取消按钮的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Cancel(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * 创建按钮
		 */
		OCButton_Cancel cancel = new OCButton_Cancel(height, width);
		/*
		 * 设置按钮的各种属性
		 */
		cancel.attr.setBgcolor(bgcolor);
		cancel.setMode(shapemode);
		cancel.attr.setFunction(function);
		cancel.setAttr();

		/*
		 * 在页面中添加按钮
		 */
		page.add(cancel, left, top, cancel.attr.getMargin(),
				cancel.attr.getMargin());
	}

	/**
	 * 右边框颜色按钮的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_ColorBorder(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());

		String text = attrList.get(4).getText();
		String textcolor = attrList.get(5).getText();
		String fontsize = attrList.get(6).getText();
		String bordercolor = attrList.get(7).getText();
		String downcolor = attrList.get(8).getText();
		String function = attrList.get(9).getText();

		/*
		 * 创建按钮
		 */
		OCButton_ColorBorder colorBorder = new OCButton_ColorBorder(text,
				height, width);
		/*
		 * 设置按钮的各种属性
		 */
		colorBorder.attr.setTextcolor(textcolor);
		colorBorder.attr.setFontsize(fontsize);
		colorBorder.attr.setBordercolor(bordercolor);
		colorBorder.attr.setDowncolor(downcolor);
		colorBorder.attr.setFunction(function);
		colorBorder.setAttr();

		/*
		 * 在页面中添加按钮
		 */
		page.add(colorBorder, left, top);
	}

	/**
	 * 向下箭头按钮的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Down(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * 创建按钮
		 */
		OCButton_DOWN down = new OCButton_DOWN(height, width);
		/*
		 * 设置按钮的各种属性
		 */
		down.attr.setBgcolor(bgcolor);
		down.setMode(shapemode);
		down.attr.setFunction(function);
		down.setAttr();

		/*
		 * 在页面中添加按钮
		 */
		page.add(down, left, top, down.attr.getMargin(), down.attr.getMargin());
	}

	/**
	 * 可以更改文字的扁平化按钮
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Flat(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());

		String text = attrList.get(4).getText();
		String textcolor = attrList.get(5).getText();
		String fontsize = attrList.get(6).getText();
		String backgroundcolor = attrList.get(7).getText();
		String function = attrList.get(8).getText();

		/*
		 * 创建按钮
		 */
		OCButton_Flat flat = new OCButton_Flat(text, height, width);
		/*
		 * 设置按钮的各种属性
		 */
		flat.attr.setTextcolor(textcolor);
		flat.attr.setFontSize(fontsize);
		flat.attr.setBackgroundcolor(backgroundcolor);
		flat.attr.setFunction(function);
		flat.setAttr();

		/*
		 * 在页面中添加按钮
		 */
		page.add(flat, left, top);
	}

	/**
	 * 绿色按钮
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Green(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());

		String text = attrList.get(4).getText();
		String textcolor = attrList.get(5).getText();
		String fontsize = attrList.get(6).getText();
		String function = attrList.get(7).getText();

		/*
		 * 创建按钮
		 */
		OCButton_Green flat = new OCButton_Green(text, height, width);
		/*
		 * 设置按钮的各种属性
		 */
		flat.attr.setTextcolor(textcolor);
		flat.attr.setFontsize(fontsize);
		flat.attr.setFunction(function);
		flat.setAttr();

		/*
		 * 在页面中添加按钮
		 */
		page.add(flat, left, top);
	}

	/**
	 * 方格的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Grid(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * 创建按钮
		 */
		OCButton_Grid grid = new OCButton_Grid(height, width);
		/*
		 * 设置按钮的各种属性
		 */
		grid.attr.setBgcolor(bgcolor);
		grid.setMode(shapemode);
		grid.attr.setFunction(function);
		grid.setAttr();

		/*
		 * 在页面中添加按钮
		 */
		page.add(grid, left, top, grid.attr.getMargin(), grid.attr.getMargin());
	}

	/**
	 * 心形按钮的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Heart(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * 创建按钮
		 */
		OCButton_Heart heart = new OCButton_Heart(height, width);
		/*
		 * 设置按钮的各种属性
		 */
		heart.attr.setBgcolor(bgcolor);
		heart.setMode(shapemode);
		heart.attr.setFunction(function);
		heart.setAttr();

		/*
		 * 在页面中添加按钮
		 */
		page.add(heart, left, top, heart.attr.getMargin(),
				heart.attr.getMargin());
	}

	/**
	 * 有创意图案的按钮的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Idea(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * 创建按钮
		 */
		OCButton_Idea idea = new OCButton_Idea(height, width);
		/*
		 * 设置按钮的各种属性
		 */
		idea.attr.setBgcolor(bgcolor);
		idea.setMode(shapemode);
		idea.attr.setFunction(function);
		idea.setAttr();

		/*
		 * 在页面中添加按钮
		 */
		page.add(idea, left, top, idea.attr.getMargin(), idea.attr.getMargin());
	}

	/**
	 * 修改的按钮的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Modify(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * 创建按钮
		 */
		OCButton_Modify modify = new OCButton_Modify(height, width);
		/*
		 * 设置按钮的各种属性
		 */
		modify.attr.setBgcolor(bgcolor);
		modify.setMode(shapemode);
		modify.attr.setFunction(function);
		modify.setAttr();

		/*
		 * 在页面中添加按钮
		 */
		page.add(modify, left, top, modify.attr.getMargin(),
				modify.attr.getMargin());
	}

	/**
	 * 音乐的按钮的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Music(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * 创建按钮
		 */
		OCButton_Music music = new OCButton_Music(height, width);
		/*
		 * 设置按钮的各种属性
		 */
		music.attr.setBgcolor(bgcolor);
		music.setMode(shapemode);
		music.attr.setFunction(function);
		music.setAttr();

		/*
		 * 在页面中添加按钮
		 */
		page.add(music, left, top, music.attr.getMargin(),
				music.attr.getMargin());
	}

	/**
	 * 音乐播放和暂停按钮的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Music_Play_Pause(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String flag = attrList.get(6).getText();
		String musicname = attrList.get(7).getText();

		/*
		 * 创建按钮
		 */
		OCButton_Music_Play_Pause music = new OCButton_Music_Play_Pause(
				musicname, height, width);
		/*
		 * 设置按钮的各种属性
		 */
		music.attr.setBgcolor(bgcolor);
		music.setMode(shapemode);
		music.attr.setFlag(Boolean.getBoolean(flag));
		music.setAttr();

		/*
		 * 在页面中添加按钮
		 */
		page.add(music, left, top, music.attr.getMargin(),
				music.attr.getMargin());
	}

	/**
	 * 确定的按钮的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_OK(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * 创建按钮
		 */
		OCButton_OK ok = new OCButton_OK(height, width);
		/*
		 * 设置按钮的各种属性
		 */
		ok.attr.setBgcolor(bgcolor);
		ok.setMode(shapemode);
		ok.attr.setFunction(function);
		ok.setAttr();

		/*
		 * 在页面中添加按钮
		 */
		page.add(ok, left, top, ok.attr.getMargin(), ok.attr.getMargin());
	}

	/**
	 * 绘画的按钮的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Paint(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * 创建按钮
		 */
		OCButton_Paint paint = new OCButton_Paint(height, width);
		/*
		 * 设置按钮的各种属性
		 */
		paint.attr.setBgcolor(bgcolor);
		paint.setMode(shapemode);
		paint.attr.setFunction(function);
		paint.setAttr();

		/*
		 * 在页面中添加按钮
		 */
		page.add(paint, left, top, paint.attr.getMargin(),
				paint.attr.getMargin());
	}

	/**
	 * 绘画的按钮的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Picture(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * 创建按钮
		 */
		OCButton_Picture picture = new OCButton_Picture(height, width);
		/*
		 * 设置按钮的各种属性
		 */
		picture.attr.setBgcolor(bgcolor);
		picture.setMode(shapemode);
		picture.attr.setFunction(function);
		picture.setAttr();

		/*
		 * 在页面中添加按钮
		 */
		page.add(picture, left, top, picture.attr.getMargin(),
				picture.attr.getMargin());
	}

	/**
	 * 插件的按钮的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Plugins(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * 创建按钮
		 */
		OCButton_Plugins plugins = new OCButton_Plugins(height, width);
		/*
		 * 设置按钮的各种属性
		 */
		plugins.attr.setBgcolor(bgcolor);
		plugins.setMode(shapemode);
		plugins.attr.setFunction(function);
		plugins.setAttr();

		/*
		 * 在页面中添加按钮
		 */
		page.add(plugins, left, top, plugins.attr.getMargin(),
				plugins.attr.getMargin());
	}

	/**
	 * 星型的按钮的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Star(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * 创建按钮
		 */
		OCButton_Star star = new OCButton_Star(height, width);
		/*
		 * 设置按钮的各种属性
		 */
		star.attr.setBgcolor(bgcolor);
		star.setMode(shapemode);
		star.attr.setFunction(function);
		star.setAttr();

		/*
		 * 在页面中添加按钮
		 */
		page.add(star, left, top, star.attr.getMargin(), star.attr.getMargin());
	}

	/**
	 * 向上的按钮的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_UP(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * 创建按钮
		 */
		OCButton_UP up = new OCButton_UP(height, width);
		/*
		 * 设置按钮的各种属性
		 */
		up.attr.setBgcolor(bgcolor);
		up.setMode(shapemode);
		up.attr.setFunction(function);
		up.setAttr();

		/*
		 * 在页面中添加按钮
		 */
		page.add(up, left, top, up.attr.getMargin(), up.attr.getMargin());
	}

	/**
	 * 向上的按钮的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Video(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * 创建按钮
		 */
		OCButton_Video video = new OCButton_Video(height, width);
		/*
		 * 设置按钮的各种属性
		 */
		video.attr.setBgcolor(bgcolor);
		video.setMode(shapemode);
		video.attr.setFunction(function);
		video.setAttr();

		/*
		 * 在页面中添加按钮
		 */
		page.add(video, left, top, video.attr.getMargin(),
				video.attr.getMargin());
	}

	/**
	 * 闪光的按钮的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCShineButton(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		String text = attrList.get(4).getText();
		String textcolor = attrList.get(5).getText();
		String fontsize = attrList.get(6).getText();
		String backgroundcolor = attrList.get(7).getText();
		String function = attrList.get(8).getText();

		/*
		 * 创建按钮
		 */
		OCShineButton shine = new OCShineButton(text, height, width);
		/*
		 * 设置按钮的各种属性
		 */
		shine.attr.setTextcolor(textcolor);
		shine.attr.setFontsize(fontsize);
		shine.attr.setBackgroundcolor(backgroundcolor);
		shine.attr.setFunction(function);
		shine.setAttr();

		/*
		 * 在页面中添加按钮
		 */
		page.add(shine, left, top);
	}

	/**
	 * 开关1的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCSwitch1(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		String radius = attrList.get(4).getText();
		String function = attrList.get(5).getText();

		/*
		 * 创建按钮
		 */
		OCSwitch1 switch1 = new OCSwitch1(height, width);
		/*
		 * 设置按钮的各种属性
		 */
		switch1.attr.setRadius(radius);
		switch1.attr.setFunction(function);

		/*
		 * 在页面中添加按钮
		 */
		page.add(switch1, left, top);
	}

	/**
	 * 开关2的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCSwitch2(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		String function = attrList.get(4).getText();

		/*
		 * 创建按钮
		 */
		OCSwitch1 switch2 = new OCSwitch1(height, width);
		/*
		 * 设置按钮的各种属性
		 */
		switch2.attr.setFunction(function);

		/*
		 * 在页面中添加按钮
		 */
		page.add(switch2, left, top);
	}

	/**
	 * 开关3的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCSwitch3(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		String function = attrList.get(4).getText();

		/*
		 * 创建按钮
		 */
		OCSwitch1 switch3 = new OCSwitch1(height, width);
		/*
		 * 设置按钮的各种属性
		 */
		switch3.attr.setFunction(function);

		/*
		 * 在页面中添加按钮
		 */
		page.add(switch3, left, top);
	}

	/**
	 * TextView的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCTextView1(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		String text = attrList.get(4).getText();
		String textcolor = attrList.get(5).getText();
		String fontsize = attrList.get(6).getText();
		String startcolor = attrList.get(7).getText();
		String endcolor = attrList.get(8).getText();
		String isradius = attrList.get(9).getText();

		/*
		 * 创建按钮
		 */
		OCTextView1 textview = new OCTextView1(text, height, width);
		/*
		 * 设置按钮的各种属性
		 */
		textview.attr.setTextcolor(textcolor);
		textview.attr.setFontsize(fontsize);
		textview.attr.setStartcolor(startcolor);
		textview.attr.setEndcolor(endcolor);
		textview.attr.setIsradius(isradius);
		textview.setAttr();

		/*
		 * 在页面中添加按钮
		 */
		page.add(textview, left, top);
	}

	/**
	 * 摇头动画的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCAnimation_LoveMusic(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		/*
		 * 创建按钮
		 */
		OCAnimation_LoveMusic animation = new OCAnimation_LoveMusic();
		/*
		 * 在页面中添加动画
		 */
		page.add(animation, left, top);
	}

	/**
	 * 直线的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCLine(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		String color = attrList.get(2).getText();
		int size = Integer.parseInt(attrList.get(3).getText());
		int width = Integer.parseInt(attrList.get(4).getText());
		/*
		 * 创建按钮
		 */
		OCLine line = new OCLine(size, width, color);
		/*
		 * 在页面中添加动画
		 */
		page.add(line, left, top);
	}

	/**
	 * 相册的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCImageSwitch3(OCPage page, Element widget) {

		OCImageSwitch3 testimgswitch3 = new OCImageSwitch3();

		@SuppressWarnings("rawtypes")
		List photoList = widget.elements("photo");
		int left = Integer.parseInt(((Element) widget.elements("left").get(0))
				.getText());
		int top = Integer.parseInt(((Element) widget.elements("top").get(0))
				.getText());
		for (Object obj : photoList) {
			Element photo = (Element) obj;

			@SuppressWarnings("unchecked")
			List<Element> attrList = photo.elements();
			String title = attrList.get(0).getText();
			String text = attrList.get(1).getText();
			String url = attrList.get(2).getText();

			testimgswitch3.addimg(title, text, "../img/" + url);
		}

		/*
		 * 在页面中添加控件
		 */
		page.add(testimgswitch3, left, top);
	}

	/**
	 * ImageView的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCimageView(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		String text = attrList.get(4).getText();
		String srcURL = attrList.get(5).getText();
		String musicURL = attrList.get(6).getText();
		String borderstyle = attrList.get(7).getText();
		String borderwidth = attrList.get(8).getText();
		String bordercolor = attrList.get(9).getText();
		String radius = attrList.get(10).getText();
		String function = attrList.get(11).getText();
		/*
		 * 创建按钮
		 */
		OCImageView imageview = new OCImageView("../img/" + srcURL, height,
				width);

		imageview.attr.setText(text);
		imageview.attr.setMusicURL("../music/" + musicURL);
		imageview.attr.setBorderColor(bordercolor);
		imageview.attr.setBorderStyle(borderstyle);
		imageview.attr.setBorderWidth(borderwidth);
		imageview.attr.setRadius(radius);
		imageview.attr.setFunction(function);
		imageview.setAttr();
		/*
		 * 在页面中添加动画
		 */
		page.add(imageview, left, top);
	}

	/**
	 * 音乐播放器的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCMusicPlayer(OCPage page, Element widget) {

		OCMusicPlayer MusicPlauer = new OCMusicPlayer();

		@SuppressWarnings("rawtypes")
		List musicList = widget.elements("music");
		int left = Integer.parseInt(((Element) widget.elements("left").get(0))
				.getText());
		int top = Integer.parseInt(((Element) widget.elements("top").get(0))
				.getText());
		for (Object obj : musicList) {
			Element music = (Element) obj;

			@SuppressWarnings("unchecked")
			List<Element> attrList = music.elements();
			String title = attrList.get(0).getText();
			String url = attrList.get(2).getText();

			MusicPlauer.addmusic(title, "../music/" + url);
		}

		/*
		 * 在页面中添加控件
		 */
		page.add(MusicPlauer, left, top);
	}

	/**
	 * ImageView的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCTextImageView(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int width = Integer.parseInt(attrList.get(2).getText());
		String text = attrList.get(3).getText();
		String imagesrc = attrList.get(4).getText();
		String imagetext = attrList.get(5).getText();
		int imageheight = Integer.parseInt(attrList.get(6).getText());
		String musicURL = attrList.get(7).getText();
		String borderstyle = attrList.get(8).getText();
		String borderwidth = attrList.get(9).getText();
		String bordercolor = attrList.get(10).getText();
		int textheight = Integer.parseInt(attrList.get(11).getText());
		String textcolor = attrList.get(12).getText();
		String backgroundcolor = attrList.get(13).getText();
		String fontsize = attrList.get(14).getText();
		String horizentalmode = attrList.get(15).getText();
		String verticalmode = attrList.get(16).getText();
		String paddingleft = attrList.get(17).getText();
		String paddingright = attrList.get(18).getText();
		String paddingtop = attrList.get(19).getText();
		String paddingbottom = attrList.get(20).getText();
		String function = attrList.get(21).getText();
		/*
		 * 创建按钮
		 */
		OCTextAndImageView imageAndText = new OCTextAndImageView(imagesrc,
				textcolor, imageheight, textheight, width);

		imageAndText.attr.setText(text);
		imageAndText.attr.setImagetext(imagetext);
		imageAndText.attr.setMusicURL("../music/" + musicURL);
		imageAndText.attr.setBorderStyle(borderstyle);
		imageAndText.attr.setBorderColor(bordercolor);
		imageAndText.attr.setBorderWidth(borderwidth);
		imageAndText.attr.setBackgroundcolor(backgroundcolor);
		imageAndText.attr.setFontSize(fontsize);
		imageAndText.attr.setHorizentalmode(horizentalmode);
		imageAndText.attr.setVerticalmode(verticalmode);
		imageAndText.attr.setPaddingleft(paddingleft);
		imageAndText.attr.setPaddingright(paddingright);
		imageAndText.attr.setPaddingtop(paddingtop);
		imageAndText.attr.setPaddingbottom(paddingbottom);
		imageAndText.attr.setFunction(function);
		imageAndText.setAttr();
		/*
		 * 在页面中添加动画
		 */
		page.add(imageAndText, left, top);
	}

	/**
	 * TextView的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCTextView2(OCPage page, Element widget) {
		/*
		 * 获取控件下所有的属性
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * 获取按钮的各种属性
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		String text = attrList.get(4).getText();
		String textcolor = attrList.get(5).getText();
		String fontsize = attrList.get(6).getText();
		String backgroundcolor = attrList.get(7).getText();
		String horizentalmode = attrList.get(8).getText();
		String verticalmode = attrList.get(9).getText();

		/*
		 * 创建按钮
		 */
		OCTextView2 textview = new OCTextView2(text, height, width);
		/*
		 * 设置按钮的各种属性
		 */
		textview.attr.setTextcolor(textcolor);
		textview.attr.setFontsize(fontsize);
		textview.attr.setBackgroundcolor(backgroundcolor);
		textview.attr.setHorizentalmode(horizentalmode);
		textview.attr.setVerticalmode(verticalmode);
		textview.setAttr();

		/*
		 * 在页面中添加按钮
		 */
		page.add(textview, left, top);
	}

	/**
	 * Tabhost的添加
	 * 
	 * @param page
	 * @param widget
	 */
	private void addTabHost1(OCPage page, Element widget) {

		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();

		@SuppressWarnings("rawtypes")
		List tabList = widget.elements("tab");
		int left = Integer.parseInt(((Element) widget.elements("left").get(0))
				.getText());
		int top = Integer.parseInt(((Element) widget.elements("top").get(0))
				.getText());
		int height = Integer.parseInt(((Element) widget.elements("height").get(
				0)).getText());
		String name = ((Element) widget.elements("name").get(0)).getText();
		String mode = ((Element) widget.elements("mode").get(0)).getText();

		for (Object obj : tabList) {
			Element tab = (Element) obj;

			@SuppressWarnings("unchecked")
			List<Element> attrList = tab.elements();
			String title = attrList.get(0).getText();
			String url = attrList.get(2).getText();
			Map<String, String> tab1 = new HashMap<String, String>();
			tab1.put("TabName", title);
			tab1.put("PageURL", url);
			list.add(tab1);
		}

		@SuppressWarnings("unchecked")
		Map<String, String>[] pages = new Map[list.size()];
		for (int i = 0; i < list.size(); i++) {
			pages[i] = list.get(i);
		}

		OCTabStrip testTab = new OCTabStrip(height, name, mode, pages);
	}

}
