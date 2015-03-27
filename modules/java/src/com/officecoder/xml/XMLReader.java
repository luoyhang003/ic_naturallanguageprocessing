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
 * ����xml�ļ���װ��HTML
 * 
 * @author xing
 * 
 */
public class XMLReader {
	/**
	 * OCDirector ����
	 */
	private OCDirector director;

	/**
	 * ����Ĭ�ϵĹ��췽��
	 */
	public XMLReader() {
		director = OCDirector.getInstance();
		director.setRootPath("C:/OfficeCoder/5c933fabed1a469c85fe70f93546ccdb/test1");
	}

	/**
	 * ������װ�õ�xml�ļ������ݲ�ͬ�Ŀؼ����ò�ͬ�ķ���
	 * 
	 * @param filePath
	 */
	@SuppressWarnings("rawtypes")
	public void XMLToHTML(String filePath) {
		try {
			/*
			 * ����SAXReader��ȡ����ר�����ڶ�ȡxml
			 */
			SAXReader saxReader = new SAXReader();
			/*
			 * ��ȡDocument���� ����ָ���ļ��ľ���·��
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
			 * ��ȡ���ڵ�
			 */
			Element root = document.getRootElement();
			/*
			 * ���ݸ�����ȡ���е�Page���
			 */
			List pageList = root.elements("Page");

			/*
			 * ����Page�����Եõ����е���ҳ�еĿؼ�
			 */
			for (Object obj : pageList) {
				Element page = (Element) obj;
				OCPage currentPage = addPage(page);
				/*
				 * ��ȡPage�е����еĿؼ���㣬����һ��List��
				 */
				@SuppressWarnings("unchecked")
				List<Element> widgetList = page.elements();
				/*
				 * ���ñ������������еĿؼ����
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
	 * ����xml�ļ���װ���page
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
			System.out.println("page���ʹ���");
		}

		if (Boolean.getBoolean(pageIndex)) {
			director.setIndex(testpage);
		}

		if (pageBackgroundType.equals("color")) {
			testpage.setbackground(OCPage.OCPageBgType_Color, pageBackground);
		} else if (pageBackgroundType.equals("image")) {
			testpage.setbackground(OCPage.OCPageBgType_Img, pageBackground);
		} else {
			System.out.println("page�������ʹ���");
		}

		director.addPage(testpage);

		return testpage;
	}

	/**
	 * ���ݲ�ͬ��Element������ѡ��ͬ����ӷ���
	 */
	private void addWidget(OCPage page, Element widget) {
		String name = widget.getName();
		/*
		 * ���ݲ�ͬ������ѡ���Ӧ�ķ���
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
	 * ȡ����ť�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Cancel(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * ������ť
		 */
		OCButton_Cancel cancel = new OCButton_Cancel(height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		cancel.attr.setBgcolor(bgcolor);
		cancel.setMode(shapemode);
		cancel.attr.setFunction(function);
		cancel.setAttr();

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(cancel, left, top, cancel.attr.getMargin(),
				cancel.attr.getMargin());
	}

	/**
	 * �ұ߿���ɫ��ť�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_ColorBorder(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
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
		 * ������ť
		 */
		OCButton_ColorBorder colorBorder = new OCButton_ColorBorder(text,
				height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		colorBorder.attr.setTextcolor(textcolor);
		colorBorder.attr.setFontsize(fontsize);
		colorBorder.attr.setBordercolor(bordercolor);
		colorBorder.attr.setDowncolor(downcolor);
		colorBorder.attr.setFunction(function);
		colorBorder.setAttr();

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(colorBorder, left, top);
	}

	/**
	 * ���¼�ͷ��ť�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Down(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * ������ť
		 */
		OCButton_DOWN down = new OCButton_DOWN(height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		down.attr.setBgcolor(bgcolor);
		down.setMode(shapemode);
		down.attr.setFunction(function);
		down.setAttr();

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(down, left, top, down.attr.getMargin(), down.attr.getMargin());
	}

	/**
	 * ���Ը������ֵı�ƽ����ť
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Flat(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
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
		 * ������ť
		 */
		OCButton_Flat flat = new OCButton_Flat(text, height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		flat.attr.setTextcolor(textcolor);
		flat.attr.setFontSize(fontsize);
		flat.attr.setBackgroundcolor(backgroundcolor);
		flat.attr.setFunction(function);
		flat.setAttr();

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(flat, left, top);
	}

	/**
	 * ��ɫ��ť
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Green(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
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
		 * ������ť
		 */
		OCButton_Green flat = new OCButton_Green(text, height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		flat.attr.setTextcolor(textcolor);
		flat.attr.setFontsize(fontsize);
		flat.attr.setFunction(function);
		flat.setAttr();

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(flat, left, top);
	}

	/**
	 * ��������
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Grid(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * ������ť
		 */
		OCButton_Grid grid = new OCButton_Grid(height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		grid.attr.setBgcolor(bgcolor);
		grid.setMode(shapemode);
		grid.attr.setFunction(function);
		grid.setAttr();

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(grid, left, top, grid.attr.getMargin(), grid.attr.getMargin());
	}

	/**
	 * ���ΰ�ť�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Heart(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * ������ť
		 */
		OCButton_Heart heart = new OCButton_Heart(height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		heart.attr.setBgcolor(bgcolor);
		heart.setMode(shapemode);
		heart.attr.setFunction(function);
		heart.setAttr();

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(heart, left, top, heart.attr.getMargin(),
				heart.attr.getMargin());
	}

	/**
	 * �д���ͼ���İ�ť�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Idea(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * ������ť
		 */
		OCButton_Idea idea = new OCButton_Idea(height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		idea.attr.setBgcolor(bgcolor);
		idea.setMode(shapemode);
		idea.attr.setFunction(function);
		idea.setAttr();

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(idea, left, top, idea.attr.getMargin(), idea.attr.getMargin());
	}

	/**
	 * �޸ĵİ�ť�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Modify(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * ������ť
		 */
		OCButton_Modify modify = new OCButton_Modify(height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		modify.attr.setBgcolor(bgcolor);
		modify.setMode(shapemode);
		modify.attr.setFunction(function);
		modify.setAttr();

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(modify, left, top, modify.attr.getMargin(),
				modify.attr.getMargin());
	}

	/**
	 * ���ֵİ�ť�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Music(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * ������ť
		 */
		OCButton_Music music = new OCButton_Music(height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		music.attr.setBgcolor(bgcolor);
		music.setMode(shapemode);
		music.attr.setFunction(function);
		music.setAttr();

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(music, left, top, music.attr.getMargin(),
				music.attr.getMargin());
	}

	/**
	 * ���ֲ��ź���ͣ��ť�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Music_Play_Pause(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
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
		 * ������ť
		 */
		OCButton_Music_Play_Pause music = new OCButton_Music_Play_Pause(
				musicname, height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		music.attr.setBgcolor(bgcolor);
		music.setMode(shapemode);
		music.attr.setFlag(Boolean.getBoolean(flag));
		music.setAttr();

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(music, left, top, music.attr.getMargin(),
				music.attr.getMargin());
	}

	/**
	 * ȷ���İ�ť�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_OK(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * ������ť
		 */
		OCButton_OK ok = new OCButton_OK(height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		ok.attr.setBgcolor(bgcolor);
		ok.setMode(shapemode);
		ok.attr.setFunction(function);
		ok.setAttr();

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(ok, left, top, ok.attr.getMargin(), ok.attr.getMargin());
	}

	/**
	 * �滭�İ�ť�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Paint(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * ������ť
		 */
		OCButton_Paint paint = new OCButton_Paint(height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		paint.attr.setBgcolor(bgcolor);
		paint.setMode(shapemode);
		paint.attr.setFunction(function);
		paint.setAttr();

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(paint, left, top, paint.attr.getMargin(),
				paint.attr.getMargin());
	}

	/**
	 * �滭�İ�ť�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Picture(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * ������ť
		 */
		OCButton_Picture picture = new OCButton_Picture(height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		picture.attr.setBgcolor(bgcolor);
		picture.setMode(shapemode);
		picture.attr.setFunction(function);
		picture.setAttr();

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(picture, left, top, picture.attr.getMargin(),
				picture.attr.getMargin());
	}

	/**
	 * ����İ�ť�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Plugins(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * ������ť
		 */
		OCButton_Plugins plugins = new OCButton_Plugins(height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		plugins.attr.setBgcolor(bgcolor);
		plugins.setMode(shapemode);
		plugins.attr.setFunction(function);
		plugins.setAttr();

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(plugins, left, top, plugins.attr.getMargin(),
				plugins.attr.getMargin());
	}

	/**
	 * ���͵İ�ť�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Star(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * ������ť
		 */
		OCButton_Star star = new OCButton_Star(height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		star.attr.setBgcolor(bgcolor);
		star.setMode(shapemode);
		star.attr.setFunction(function);
		star.setAttr();

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(star, left, top, star.attr.getMargin(), star.attr.getMargin());
	}

	/**
	 * ���ϵİ�ť�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_UP(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * ������ť
		 */
		OCButton_UP up = new OCButton_UP(height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		up.attr.setBgcolor(bgcolor);
		up.setMode(shapemode);
		up.attr.setFunction(function);
		up.setAttr();

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(up, left, top, up.attr.getMargin(), up.attr.getMargin());
	}

	/**
	 * ���ϵİ�ť�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCButton_Video(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		int shapemode = Integer.parseInt(attrList.get(4).getText());
		String bgcolor = attrList.get(5).getText();
		String function = attrList.get(6).getText();

		/*
		 * ������ť
		 */
		OCButton_Video video = new OCButton_Video(height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		video.attr.setBgcolor(bgcolor);
		video.setMode(shapemode);
		video.attr.setFunction(function);
		video.setAttr();

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(video, left, top, video.attr.getMargin(),
				video.attr.getMargin());
	}

	/**
	 * ����İ�ť�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCShineButton(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
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
		 * ������ť
		 */
		OCShineButton shine = new OCShineButton(text, height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		shine.attr.setTextcolor(textcolor);
		shine.attr.setFontsize(fontsize);
		shine.attr.setBackgroundcolor(backgroundcolor);
		shine.attr.setFunction(function);
		shine.setAttr();

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(shine, left, top);
	}

	/**
	 * ����1�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCSwitch1(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		String radius = attrList.get(4).getText();
		String function = attrList.get(5).getText();

		/*
		 * ������ť
		 */
		OCSwitch1 switch1 = new OCSwitch1(height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		switch1.attr.setRadius(radius);
		switch1.attr.setFunction(function);

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(switch1, left, top);
	}

	/**
	 * ����2�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCSwitch2(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		String function = attrList.get(4).getText();

		/*
		 * ������ť
		 */
		OCSwitch1 switch2 = new OCSwitch1(height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		switch2.attr.setFunction(function);

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(switch2, left, top);
	}

	/**
	 * ����3�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCSwitch3(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		int height = Integer.parseInt(attrList.get(2).getText());
		int width = Integer.parseInt(attrList.get(3).getText());
		String function = attrList.get(4).getText();

		/*
		 * ������ť
		 */
		OCSwitch1 switch3 = new OCSwitch1(height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		switch3.attr.setFunction(function);

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(switch3, left, top);
	}

	/**
	 * TextView�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCTextView1(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
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
		 * ������ť
		 */
		OCTextView1 textview = new OCTextView1(text, height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		textview.attr.setTextcolor(textcolor);
		textview.attr.setFontsize(fontsize);
		textview.attr.setStartcolor(startcolor);
		textview.attr.setEndcolor(endcolor);
		textview.attr.setIsradius(isradius);
		textview.setAttr();

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(textview, left, top);
	}

	/**
	 * ҡͷ���������
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCAnimation_LoveMusic(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		/*
		 * ������ť
		 */
		OCAnimation_LoveMusic animation = new OCAnimation_LoveMusic();
		/*
		 * ��ҳ������Ӷ���
		 */
		page.add(animation, left, top);
	}

	/**
	 * ֱ�ߵ����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCLine(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
		 */
		int left = Integer.parseInt(attrList.get(0).getText());
		int top = Integer.parseInt(attrList.get(1).getText());
		String color = attrList.get(2).getText();
		int size = Integer.parseInt(attrList.get(3).getText());
		int width = Integer.parseInt(attrList.get(4).getText());
		/*
		 * ������ť
		 */
		OCLine line = new OCLine(size, width, color);
		/*
		 * ��ҳ������Ӷ���
		 */
		page.add(line, left, top);
	}

	/**
	 * �������
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
		 * ��ҳ������ӿؼ�
		 */
		page.add(testimgswitch3, left, top);
	}

	/**
	 * ImageView�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCimageView(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
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
		 * ������ť
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
		 * ��ҳ������Ӷ���
		 */
		page.add(imageview, left, top);
	}

	/**
	 * ���ֲ����������
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
		 * ��ҳ������ӿؼ�
		 */
		page.add(MusicPlauer, left, top);
	}

	/**
	 * ImageView�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCTextImageView(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
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
		 * ������ť
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
		 * ��ҳ������Ӷ���
		 */
		page.add(imageAndText, left, top);
	}

	/**
	 * TextView�����
	 * 
	 * @param page
	 * @param widget
	 */
	private void addOCTextView2(OCPage page, Element widget) {
		/*
		 * ��ȡ�ؼ������е�����
		 */
		@SuppressWarnings("unchecked")
		List<Element> attrList = widget.elements();
		/*
		 * ��ȡ��ť�ĸ�������
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
		 * ������ť
		 */
		OCTextView2 textview = new OCTextView2(text, height, width);
		/*
		 * ���ð�ť�ĸ�������
		 */
		textview.attr.setTextcolor(textcolor);
		textview.attr.setFontsize(fontsize);
		textview.attr.setBackgroundcolor(backgroundcolor);
		textview.attr.setHorizentalmode(horizentalmode);
		textview.attr.setVerticalmode(verticalmode);
		textview.setAttr();

		/*
		 * ��ҳ������Ӱ�ť
		 */
		page.add(textview, left, top);
	}

	/**
	 * Tabhost�����
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
