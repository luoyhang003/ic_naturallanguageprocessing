package OCTest;

import java.util.HashMap;
import java.util.Map;

import OCAnimation.OCAnimation_LoveMusic;
import OCButton.OCButton_3D_1;
import OCButton.OCButton_Cancel;
import OCButton.OCButton_DOWN;
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
import OCDirector.OCDirector;
import OCImageSwitch.OCImageSwitch1;
import OCImageSwitch.OCImageSwitch3;
import OCImageView.OCImageView;
import OCLine.OCLine;
import OCMusicPlayer.OCMusicPlayer;
import OCPage.OCPage;
import OCSwitch.OCSwitch1;
import OCSwitch.OCSwitch2;
import OCSwitch.OCSwitch3;
import OCTabStrip.OCTabStrip;
import OCTextAndImageView.OCTextAndImageView;
import OCTextView.OCTextView1;
import OCTextView.OCTextView2;
import OCTools.OCCreater;

/**
 * ≤‚ ‘¿‡ main
 * 
 * @author MingChao Sun
 *
 */
public class Test {
	/**
	 * OCDirector ∂‘œÛ
	 */
	public static OCDirector director;

	public static void main(String[] args) {

		/**
		 * director∂‘œÛ
		 */
		director = OCDirector.getInstance();

		/*
		 * …Ë÷√π§≥Ã√˚“‘º∞π§≥ÃŒƒº˛º–√˚≥∆
		 */
		director.setAppname("≤‚ ‘∂˛∫≈");

		/*
		 * …Ë÷√π§≥Ã∏˘ƒø¬ºµÿ÷∑
		 */
		director.setProjectPath("/E:/HTML5 CSS3 javascript/OC/π§≥Ã≤‚ ‘");

		/*
		 * –¬Ω®π§≥Ã
		 */
		OCCreater.creatNewProject();

		/*
		 * –¬Ω®≤‚ ‘“≥√Ê
		 */

		/**
		 * ≤‚ ‘“≥√Ê“ª
		 */
		OCPage testpage1 = new OCPage(OCPage.OCPageType_LOCAL, "HelloWorld");

		/**
		 * ≤‚ ‘“≥√Ê∂˛
		 */
		testpage1.setbackground(OCPage.OCPageBgType_Color, "#aabbcc");

		/**
		 * ≤‚ ‘“≥√Ê∂˛
		 */
		OCPage testpage2 = new OCPage(OCPage.OCPageType_LOCAL, "duang");

		testpage2.setbackground(OCPage.OCPageBgType_Img,
				"E:/HTML5 CSS3 javascript/OC/≤‚ ‘Àÿ≤ƒ/img/duang.gif");

		OCPage testpage3 = new OCPage(OCPage.OCPageType_LOCAL, "index3");

		testpage3.setbackground(OCPage.OCPageBgType_Color, "#008eff");

		OCPage testpage4 = new OCPage(OCPage.OCPageType_LOCAL, "index4");

		testpage4.setbackground(OCPage.OCPageBgType_Color, "#008eff");

		OCPage testpage5 = new OCPage(OCPage.OCPageType_LOCAL, "index5");

		testpage5.setbackground(OCPage.OCPageBgType_Color, "#ae58ee");

		OCPage testpage6 = new OCPage(OCPage.OCPageType_LOCAL, "index6");

		testpage6.setbackground(OCPage.OCPageBgType_Color, "#ae58ee");
		
		OCPage testpage7 = new OCPage(OCPage.OCPageType_LOCAL, "index7");

		testpage7.setbackground(OCPage.OCPageBgType_Color, "#ffffff");

		/*
		 * ÃÌº”“≥√Ê
		 */
		director.addPage(testpage1);
		director.addPage(testpage2);
		director.addPage(testpage3);
		director.addPage(testpage4);
		director.addPage(testpage5);
		director.addPage(testpage6);
		director.addPage(testpage7);

		/*
		 * …Ë÷√ ◊“≥
		 */
		director.setIndex(testpage1);

		/*
		 * ≤‚ ‘“≥√Ê“ª
		 */
		OCButton_3D_1 testbutton1 = new OCButton_3D_1("Push me!", 100, 160);

		testbutton1.attr.setTextcolor("#aa8905");
		testbutton1.setAttr();

		OCSwitch1 testswitch1 = new OCSwitch1(50, 180);
		OCSwitch2 testswitch2 = new OCSwitch2(100, 100);
		OCSwitch3 testswitch3 = new OCSwitch3(100, 50);

		String img1 = "E:/HTML5 CSS3 javascript/OC/≤‚ ‘Àÿ≤ƒ/img/1.jpg";
		String img2 = "E:/HTML5 CSS3 javascript/OC/≤‚ ‘Àÿ≤ƒ/img/2.jpg";
		String img3 = "E:/HTML5 CSS3 javascript/OC/≤‚ ‘Àÿ≤ƒ/img/3.jpg";
		String img4 = "E:/HTML5 CSS3 javascript/OC/≤‚ ‘Àÿ≤ƒ/img/4.jpg";

		OCImageSwitch1 testImageSwitch = new OCImageSwitch1(400, 600, img1,
				img2, img3, img4);

		testImageSwitch.attr.setText1("HAHA");
		testImageSwitch.setAttr();

		testpage1.add(testbutton1, 50, 0);
		testpage1.add(testswitch2, 150, 200);
		testpage1.add(testswitch1, 350, 100);
		testpage1.add(testswitch3, 450, 200, 20);
		testpage1.add(testImageSwitch, 550, 200, 20, 20);

		/*
		 * ≤‚ ‘“≥√Ê∂˛
		 */
		OCMusicPlayer testMusicPlauer = new OCMusicPlayer();

		testMusicPlauer.addmusic("testMusic1",
				"E:/HTML5 CSS3 javascript/OC/≤‚ ‘Àÿ≤ƒ/MP3/test1.mp3");
		testMusicPlauer.addmusic("testMusic2",
				"E:/HTML5 CSS3 javascript/OC/≤‚ ‘Àÿ≤ƒ/MP3/test2.mp3");
		testMusicPlauer.addmusic("testMusic3",
				"E:/HTML5 CSS3 javascript/OC/≤‚ ‘Àÿ≤ƒ/MP3/test3.mp3");

		testpage3.add(testMusicPlauer, 50, 0, 40, 80);

		OCAnimation_LoveMusic testmusicanmi = new OCAnimation_LoveMusic();

		testpage3.add(testmusicanmi, 250, 500, 0, 0);

		/*
		 * ≤‚ ‘“≥√Ê»˝
		 */
		OCImageSwitch3 testimgswitch3 = new OCImageSwitch3();

		testimgswitch3
				.addimg("Sea Turtle",
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam ut urna. Mauris nulla. Donec nec mauris. Proin nulla dolor, bibendum et, dapibus in, euismod ut, felis.",
						"E:/HTML5 CSS3 javascript/OC/≤‚ ‘Àÿ≤ƒ/img/1.jpg");

		testimgswitch3
				.addimg("Red Coral",
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam ut urna. Mauris nulla. Donec nec mauris. Proin nulla dolor, bibendum et, dapibus in, euismod ut, felis.",
						"E:/HTML5 CSS3 javascript/OC/≤‚ ‘Àÿ≤ƒ/img/2.jpg");

		testimgswitch3
				.addimg("Coral Reef",
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam ut urna. Mauris nulla. Donec nec mauris. Proin nulla dolor, bibendum et, dapibus in, euismod ut, felis.",
						"E:/HTML5 CSS3 javascript/OC/≤‚ ‘Àÿ≤ƒ/img/3.jpg");

		testimgswitch3
				.addimg("Blue Fish",
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam ut urna. Mauris nulla. Donec nec mauris. Proin nulla dolor, bibendum et, dapibus in, euismod ut, felis.",
						"E:/HTML5 CSS3 javascript/OC/≤‚ ‘Àÿ≤ƒ/img/4.jpg");

		OCImageView testimageview = new OCImageView(
				"E:/HTML5 CSS3 javascript/OC/≤‚ ‘Àÿ≤ƒ/img/4.jpg", 300, 400);
		
		testimageview.attr.setRadius("10px");
		testimageview.setAttr();

		testpage4.add(testimgswitch3, 50, 0, 40, 80);
		testpage4.add(testimageview, 450, 100, 40, 80);

		/*
		 * ≤‚ ‘“≥√ÊŒÂ
		 */

		OCButton_Cancel testbutton_cancel = new OCButton_Cancel(200, 300);
		testbutton_cancel.setMode(3);
		testbutton_cancel.setAttr();

		testpage5.add(testbutton_cancel, 0, 50,
				testbutton_cancel.attr.getMargin(),
				testbutton_cancel.attr.getMargin());

		OCButton_Grid testbutton_grid = new OCButton_Grid(200, 300);
		testbutton_grid.setMode(3);
		testbutton_grid.setAttr();

		testpage5.add(testbutton_grid, 300, 50,
				testbutton_grid.attr.getMargin(),
				testbutton_grid.attr.getMargin());

		OCButton_DOWN testbutton_DOWN = new OCButton_DOWN(200, 300);
		testbutton_DOWN.setMode(3);
		testbutton_DOWN.setAttr();

		testpage5.add(testbutton_DOWN, 600, 50,
				testbutton_DOWN.attr.getMargin(),
				testbutton_DOWN.attr.getMargin());

		OCButton_Heart testbutton_Heart = new OCButton_Heart(200, 300);
		testbutton_Heart.setMode(3);
		testbutton_Heart.setAttr();

		testpage5.add(testbutton_Heart, 900, 50,
				testbutton_Heart.attr.getMargin(),
				testbutton_Heart.attr.getMargin());

		OCButton_Idea testbutton_Idea = new OCButton_Idea(200, 300);
		testbutton_Idea.setMode(3);
		testbutton_Idea.setAttr();

		testpage5.add(testbutton_Idea, 1200, 50,
				testbutton_Idea.attr.getMargin(),
				testbutton_Idea.attr.getMargin());

		OCButton_Modify testbutton_Modify = new OCButton_Modify(200, 300);
		testbutton_Modify.setMode(3);
		testbutton_Modify.setAttr();

		testpage5.add(testbutton_Modify, 1500, 50,
				testbutton_Modify.attr.getMargin(),
				testbutton_Modify.attr.getMargin());

		OCButton_Music testbutton_Music = new OCButton_Music(200, 300);
		testbutton_Music.setMode(3);
		testbutton_Music.setAttr();

		testpage5.add(testbutton_Music, 0, 350,
				testbutton_Music.attr.getMargin(),
				testbutton_Music.attr.getMargin());

		OCButton_OK testbutton_OK = new OCButton_OK(200, 300);
		testbutton_OK.setMode(3);
		testbutton_OK.setAttr();

		testpage5.add(testbutton_OK, 300, 350, testbutton_OK.attr.getMargin(),
				testbutton_OK.attr.getMargin());

		OCButton_Paint testbutton_Paint = new OCButton_Paint(200, 300);
		testbutton_Paint.setMode(3);
		testbutton_Paint.setAttr();

		testpage5.add(testbutton_Paint, 600, 350,
				testbutton_Paint.attr.getMargin(),
				testbutton_Paint.attr.getMargin());

		OCButton_Picture testbutton_Picture = new OCButton_Picture(200, 300);
		testbutton_Picture.setMode(3);
		testbutton_Picture.setAttr();

		testpage5.add(testbutton_Picture, 900, 350,
				testbutton_Picture.attr.getMargin(),
				testbutton_Picture.attr.getMargin());

		OCButton_Plugins testbutton_Plugins = new OCButton_Plugins(200, 300);
		testbutton_Plugins.setMode(3);
		testbutton_Plugins.setAttr();

		testpage5.add(testbutton_Plugins, 1200, 350,
				testbutton_Plugins.attr.getMargin(),
				testbutton_Plugins.attr.getMargin());

		OCButton_Star testbutton_Star = new OCButton_Star(200, 300);
		testbutton_Star.setMode(3);
		testbutton_Star.setAttr();

		testpage5.add(testbutton_Star, 1500, 350,
				testbutton_Star.attr.getMargin(),
				testbutton_Star.attr.getMargin());

		OCButton_UP testbutton_UP = new OCButton_UP(200, 300);
		testbutton_UP.setMode(3);
		testbutton_UP.setAttr();

		testpage5.add(testbutton_UP, 0, 650, testbutton_UP.attr.getMargin(),
				testbutton_UP.attr.getMargin());

		OCButton_Video testbutton_Video = new OCButton_Video(200, 300);
		testbutton_Video.setMode(3);
		testbutton_Video.setAttr();

		testpage5.add(testbutton_Video, 300, 650,
				testbutton_Video.attr.getMargin(),
				testbutton_Video.attr.getMargin());

		OCButton_Music_Play_Pause testbutton_Music_Play_Pause = new OCButton_Music_Play_Pause(
				"E:/HTML5 CSS3 javascript/OC/≤‚ ‘Àÿ≤ƒ/MP3/test1.mp3", 200, 300);
		testbutton_Music_Play_Pause.setMode(3);
		testbutton_Music_Play_Pause.setAttr();

		testpage5.add(testbutton_Music_Play_Pause, 600, 650,
				testbutton_Music_Play_Pause.attr.getMargin(),
				testbutton_Music_Play_Pause.attr.getMargin());

		/*
		 * ≤‚ ‘“≥√Ê¡˘
		 */

		OCTextAndImageView testview_textandimg = new OCTextAndImageView(
				"E:/HTML5 CSS3 javascript/OC/≤‚ ‘Àÿ≤ƒ/img/1.jpg",
				"≤‚ ‘Œƒ±æLorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam ut urna. Mauris nulla. Donec nec mauris. Proin nulla dolor, bibendum et, dapibus in, euismod ut, felis.",
				230, 100, 360);
		testview_textandimg.attr.setBackgroundcolor("#f16512");
		testview_textandimg.attr.setTextcolor("#0044ea");

		testview_textandimg.setAttr();

		testpage6.add(testview_textandimg, 100, 150, 0, 0);

		OCTextView1 testTextView1 = new OCTextView1(
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
				100, 800);

		testpage6.add(testTextView1, 400, 150, 0, 0);

		OCTextView2 testTextView2 = new OCTextView2(
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
				200, 300);

		testpage6.add(testTextView2, 600,350, 0,0);
		
		OCLine testline  = new OCLine(2, 800, "#000000");
		
		testpage6.add(testline, 0, 600);
		
		Map<String,String> tab1 = new HashMap<String, String>();
		tab1.put("TabName", "page1");
		tab1.put("PageURL", "http://www.baidu.com");
		
		Map<String,String> tab2 = new HashMap<String, String>();
		tab2.put("TabName", "page2");
		tab2.put("PageURL", "http://www.bilibili.com/");
		
		Map<String,String> tab3 = new HashMap<String, String>();
		tab3.put("TabName", "page3");
		tab3.put("PageURL", "http://www.csdn.net/");
		
		
		OCTabStrip testTab = new OCTabStrip(800,"testtab", "bottom",tab1,tab2,tab3);
		
		
	}
	
	

}
