package com.KnowingLifeTest.test.TongXinLu;

import java.util.ArrayList;

import com.KnowingLifeTest.Config.Config;
import com.KnowingLifeTest.MethodGroup.CommonMethod;
import com.KnowingLifeTest.MethodGroup.MethodGroup;
import com.robotium.solo.Solo;
import android.app.Activity;
import android.graphics.Path.Op;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
public class LookUpSiteInfo extends ActivityInstrumentationTestCase2 {
	private Solo solo;
	//要测试的apk的包名
	private static final String TARGET_PACKAGE_ID=Config.PackageName;
	//classname是要测试的apk的主类名，也就是进入 apk第一个activity的类名，在签名的时候，可以看到
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME=Config.MainActivity;
	private static Class launcherActivityClass;
	MethodGroup op=null;
	CommonMethod cm=null;
	static{
		try {
			launcherActivityClass = Class.
					forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public LookUpSiteInfo() {
		super(TARGET_PACKAGE_ID,launcherActivityClass);
	}
	protected void setUp() throws Exception {	
    	super.setUp(); 
		solo = new Solo(getInstrumentation(), getActivity());
		op=new MethodGroup(solo);
		cm=new CommonMethod(solo);

	}	
	
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();			
		super.tearDown();
	}
	/*
	 * 进入站点层级，查看用户信息
	 */
	public void testSiteEnter() throws Exception{
		/*
		 * 首先检查是否有站点“思言教育”，没有的话，添加站点
		 */
		cm.clickonContacts();
		ArrayList<ExpandableListView> expandableListView0=solo.getCurrentViews(ExpandableListView.class);
		for(int i=0;i<expandableListView0.size();i++)
		{
			TextView textView=(TextView) solo.getView("site_main_list_name_tv", i);
			String tString=textView.getText().toString();
			TextView codetext=(TextView) solo.getView("site_main_list_item_fscode_tv", i);
			String codestrString=codetext.getText().toString();
			if(tString.endsWith("思言教育")&&codestrString.endsWith("8822"))//如果搜索到结果，站点名称是四海通官方站且组织代码为8888,截屏且返回到主页
			{
				op.takeScreenshot();
				op.clickById("site_main_list_item_more_iv",i);
				break;
			}else{
				op.addSite();
				solo.sleep(2000);
				i=0;
			}
		}

		Activity activity=solo.getCurrentActivity();
		op.takeScreenshot();
		ArrayList<ExpandableListView> expandableListView_1st=solo.getCurrentViews(ExpandableListView.class);
		solo.clickInList(1);
		solo.waitForDialogToOpen();
		if(op.checkViewExitsInScreen("progress")!=-1){
			ProgressBar progressBar=(ProgressBar) solo.getView("progress");
			TextView textView=(TextView) solo.getView("progress_percen");
			String perString=textView.getText().toString();
			solo.waitForText("100%", 3, Config.timeout, false, true);
			op.takeScreenshot();
		}
		solo.clickInList(2);
		solo.sleep(1000);
		op.takeScreenshot();
		solo.clickInList(1);
		solo.sleep(1000);
		op.takeScreenshot();
		solo.clickInList(0);
		solo.waitForDialogToOpen();
		solo.clickOnText("详情");
		op.takeScreenshot();

		
		
		
	}
}