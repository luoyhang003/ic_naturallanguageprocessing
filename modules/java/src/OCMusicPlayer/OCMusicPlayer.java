package OCMusicPlayer;

import java.io.File;

import OCDirector.OCDirector;
import OCDirector.OCView;
import OCTools.OCFileWorker;
import OCTools.OCHtmlWorker;

import OCValue.OCStaticValue;

public class OCMusicPlayer extends OCView {

	public OCMusicPlayer() {
		super();

		this.height = 200;
		this.width = 300;

		/*
		 * ���ļ�����
		 */
		File srcFile1 = new File(OCStaticValue.LibraryURl
				+ "/component/OCMusicPlayer.html");
		File destDir = new File(OCDirector.RootPath + "/component");
		OCFileWorker.copyFile(srcFile1, destDir, "No" + OCStaticValue.OCid
				+ "OCMusicPlayer.html");

		Path = OCDirector.RootPath + "/component/No" + OCStaticValue.OCid
				+ "OCMusicPlayer.html";

		Html = "No" + OCStaticValue.OCid + "OCMusicPlayer.html";
		OCStaticValue.OCid++;

	}

	/**
	 * ��ؼ��м������ֵķ���
	 * 
	 * @param musicName
	 * @param musicURL
	 */
	public void addmusic(String musicName, String musicURL) {

		String innerHtml = "<option value=\"" + musicURL + "\">" + musicName
				+ "</option>";

		OCHtmlWorker.innerHtml(Path, "#playList", innerHtml);

	}

}
