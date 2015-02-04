package com.KnowingLifeTest.test.XFXC;

import java.util.ArrayList;

import android.R.integer;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.KnowingLifeTest.Config.Config;
import com.KnowingLifeTest.Config.PageIdName;
import com.KnowingLifeTest.MethodGroup.CommonMethod;
import com.KnowingLifeTest.MethodGroup.MethodGroup;
import com.KnowingLifeTest.MethodGroup.OpenMethod;
import com.robotium.solo.Solo;

import junit.framework.TestCase;

public class ProgramMatch extends ActivityInstrumentationTestCase2 {
	private Solo solo;
	//要测试的apk的包名
	private static final String TARGET_PACKAGE_ID=Config.PackageName;
	//classname是要测试的apk的主类名，也就是进入 apk第一个activity的类名，在签名的时候，可以看到
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME=Config.MainActivity;
	private static Class launcherActivityClass;
	MethodGroup op=null;
	CommonMethod cm=null;
	OpenMethod om=null;
	static{
		try {
			launcherActivityClass = Class.
					forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public ProgramMatch() {
		super(TARGET_PACKAGE_ID,launcherActivityClass);
	}
	protected void setUp() throws Exception {	
    	super.setUp(); 
		solo = new Solo(getInstrumentation(), getActivity());
		op=new MethodGroup(solo);
		cm=new CommonMethod(solo);
		om=new OpenMethod(solo);
	}	
	
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();			
		super.tearDown();
	}
	/*
	 * 测试商会帮项目撮合
	 * 
	 */
	/*
	 * 测试发布项目
	 */
	public void testcreateprogramSaveCaogao() throws Exception{
		op.waitForPageFlush("项目撮合");
		solo.clickOnText("项目撮合", 1, false);
		op.waitForPageFlush();
		op.takeScreenshot();
		solo.sleep(2000);
		op.clickById("publish_project");
		solo.sleep(2000);
		op.takeScreenshot();
		cm.EnterProjectName();
		cm.EnterMoneyNum();
		cm.EnterchooseArea(PageIdName.PublishPage_chooseArea_id);
		cm.Enterchooseindusty();
		cm.EnterProjectinfo();
		cm.EnterProjectcontact();
		op.clickById(PageIdName.PublishPage_savecaogao_id);
		assertTrue("", op.ToastFindLike(new String[] {"项目已存为草稿"}));
	}
	public void testcreateprogramSave() throws Exception{
		op.waitForPageFlush("项目撮合");
		solo.clickOnText("项目撮合", 1, false);
		op.waitForPageFlush();
		op.takeScreenshot();
		solo.sleep(2000);
		op.clickById("publish_project");
		solo.sleep(2000);
		op.takeScreenshot();
		cm.EnterProjectName();
		cm.EnterMoneyNum();
		cm.EnterchooseArea(PageIdName.PublishPage_chooseArea_id);
		cm.Enterchooseindusty();
		cm.EnterProjectinfo();
		cm.EnterProjectcontact();
		op.clickById(PageIdName.PublishPage_publish_id);
		assertTrue("", op.ToastFindLike(new String[] {"项目已发布"}));
		
	}
	/*
	 * 验证已发布的项目可以暂停
	 */
	public void testPublishToCaoGao() throws Exception{
		op.waitForPageFlush("项目撮合");
		solo.clickOnText("项目撮合", 1, false);
		op.waitForPageFlush();
		op.takeScreenshot();
		cm.PauseclickOn("发布", "项目已暂停");				
	}
	/*
	 * 验证已暂停的项目可以发布
	 */
	public void testmCaogaoToPublish() throws Exception{
		op.waitForPageFlush("项目撮合");
		solo.clickOnText("项目撮合", 1, false);
		op.waitForPageFlush();
		op.takeScreenshot();
		cm.PauseclickOn("暂停", "项目已发布");	
	}
	
	public void testchangerow() throws Exception{
		op.waitForPageFlush("项目撮合");
		//solo.goBackToActivity("SiteSearchActivity");
	}
	
	/*
	 * 测试项目详情页面
	 */
	/*public void testprograminfo() throws Exception{
		solo.clickOnText("项目撮合", 1, false);
		op.waitForPageFlush();
		op.takeScreenshot();
		solo.sleep(2000);
		ArrayList<ListView> listView=solo.getCurrentViews(ListView.class);
		solo.clickInList(0,0);
		solo.sleep(2000);
		op.takeScreenshot();
	}*/
}