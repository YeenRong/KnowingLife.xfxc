
package com.KnowingLifeTest.test.TongXinLu;
import java.util.ArrayList;

import com.KnowingLifeTest.Config.Config;
import com.KnowingLifeTest.MethodGroup.CommonMethod;
import com.KnowingLifeTest.MethodGroup.MethodGroup;
import com.robotium.solo.Solo;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
public class SearchSite extends ActivityInstrumentationTestCase2 {
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
	public SearchSite() {
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
	 * 点击添加／查找组织，输入“四海通”,点击搜索，搜索到结果的第一个，点击加入，然后返回到通讯录页面
	 * "组织代码/名称/描述关键字"
	 */
	public void testSearchSite_name() throws Exception{
		cm.clickonContacts();
		
		LinearLayout linearLayout=(LinearLayout) solo.getView("site_main_add_more");
		solo.clickOnView(linearLayout);
		solo.sleep(5000);
		solo.takeScreenshot();
		EditText editText=(EditText)solo.getView("et_site_finding_search");
		solo.enterText(editText, "四海通");
		op.takeScreenshot();
		solo.sleep(1000);
		op.clickById("site_finding_search_btn");
		solo.waitForText("组织搜索", 3, Config.timeout, false, true);
		solo.sleep(1000);
		op.takeScreenshot();
		//Button join_button=(Button) solo.getView("site_main_list_item_join_btn", 2);
		solo.clickOnButton("加入");
		solo.waitForText("加入组织验证", 3, Config.timeout, false, true);
		solo.sleep(1000);
		op.clickById("site_join_postJoinSite_btn");
		solo.sleep(1000);
		op.takeScreenshot();
		assertTrue("弹出提示框成功", solo.waitForDialogToOpen());
		op.clickById("btOK");
		//assertTrue("返回到通讯录主页成功", solo.waitForActivity("com.android.KnowingLife/.component.ContactGroup.JoinSiteActivity"));
		op.takeScreenshot();
				
	}
	/*
	 * 输入搜索词"8888",能找到四海通官方站点
	 */
	public void testSearchSite_code() throws Exception{
		cm.clickonContacts();
		LinearLayout linearLayout=(LinearLayout) solo.getView("site_main_add_more");
		solo.clickOnView(linearLayout);
		solo.sleep(5000);
		solo.takeScreenshot();
		EditText editText=(EditText)solo.getView("et_site_finding_search");
		solo.enterText(editText, "8888");
		op.takeScreenshot();
		solo.sleep(1000);
		op.clickById("site_finding_search_btn");
		solo.waitForText("组织搜索", 3, Config.timeout, false, true);
		solo.sleep(1000);
		op.takeScreenshot();
		ArrayList<ListView> listView=solo.getCurrentViews(ListView.class);
		for(int i=0;i<listView.size();i++){
			TextView textView=(TextView) solo.getView("site_main_list_name_tv", i);
			String tString=textView.getText().toString();
			TextView codetext=(TextView) solo.getView("site_main_list_item_fscode_tv", i);
			String codestrString=codetext.getText().toString();
			if(tString.endsWith("四海通官方站")&&codestrString.endsWith("8888"))//如果搜索到结果，站点名称是四海通官方站且组织代码为8888,截屏且返回到主页
			{
				op.takeScreenshot();
				break;
			}
		}
		solo.goBack();
		solo.sleep(1000);
		solo.goBack();
		//assertTrue("返回到通讯录主页成功", solo.waitForActivity("com.android.KnowingLife/.component.ContactGroup.JoinSiteActivity"));
		op.takeScreenshot();
	}
	/*
	 * 输入搜索词"8888",能找到四海通官方站点
	 */
	public void testSearchSite_desc() throws Exception{
		cm.clickonContacts();
		
		LinearLayout linearLayout=(LinearLayout) solo.getView("site_main_add_more");
		solo.clickOnView(linearLayout);
		solo.sleep(5000);
		solo.takeScreenshot();
		EditText editText=(EditText)solo.getView("et_site_finding_search");
		solo.enterText(editText, "tvb");
		op.takeScreenshot();
		solo.sleep(1000);
		op.clickById("site_finding_search_btn");
		solo.waitForText("组织搜索", 3, Config.timeout, false, true);
		solo.sleep(1000);
		op.takeScreenshot();
		ArrayList<ListView> listView=solo.getCurrentViews(ListView.class);
		for(int i=0;i<listView.size();i++){
			TextView textView=(TextView) solo.getView("site_main_list_name_tv", i);
			String tString=textView.getText().toString();
			TextView codetext=(TextView) solo.getView("site_main_list_item_fscode_tv", i);
			String codestrString=codetext.getText().toString();
			if(tString.endsWith("电视剧精华")&&codestrString.endsWith("109313"))//如果搜索到结果，站点名称是四海通官方站且组织代码为8888,截屏且返回到主页
			{
				op.takeScreenshot();
				break;
			}
		}
		solo.goBack();
		solo.sleep(1000);
		solo.goBack();
		//assertTrue("返回到通讯录主页成功", solo.waitForActivity("com.android.KnowingLife/.component.ContactGroup.JoinSiteActivity"));
		op.takeScreenshot();
	}
}