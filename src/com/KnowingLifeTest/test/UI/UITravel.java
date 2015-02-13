package com.KnowingLifeTest.test.UI;

import android.test.ActivityInstrumentationTestCase2;

import com.KnowingLifeTest.Config.CommonPageIdName;
import com.KnowingLifeTest.Config.Config;
import com.KnowingLifeTest.MethodGroup.CommonMethod;
import com.KnowingLifeTest.MethodGroup.LoginPage;
import com.KnowingLifeTest.MethodGroup.MethodGroup;
import com.KnowingLifeTest.MethodGroup.OpenMethod;
import com.robotium.solo.Solo;

import junit.framework.TestCase;

public class UITravel extends ActivityInstrumentationTestCase2{
	private Solo solo;
	//要测试的apk的包名
	private static final String TARGET_PACKAGE_ID=Config.PackageName;
	//classname是要测试的apk的主类名，也就是进入 apk第一个activity的类名，在签名的时候，可以看到
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME=Config.MainActivity;
	private static Class launcherActivityClass;
	MethodGroup op=null;
	CommonMethod cm=null;
	OpenMethod om=null;
	LoginPage lPage=null;
	static{
		try {
			launcherActivityClass = Class.
					forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public UITravel() {
		super(TARGET_PACKAGE_ID,launcherActivityClass);
	}
	protected void setUp() throws Exception {	
    	super.setUp(); 
		solo = new Solo(getInstrumentation(), getActivity());
		op=new MethodGroup(solo);
		cm=new CommonMethod(solo);
		om=new OpenMethod(solo);
		lPage=new LoginPage(solo);
	}	
	
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();			
		super.tearDown();
	}
	/**
	 * 数字村谱模块
	 * @throws Exception
	 */
	/*
	 * 点击收藏联系人
	 */
	public void testHavealook_CollectContact() throws Exception{
		lPage.CheckHavealook();
		lPage.CheckLoginInProtectDialogIsSuccess(Config.Contacts, 2, CommonPageIdName.CollectContact_layout);	
	}
	/*
	 * 点击绑定村庄
	 */
	public void testHavealook_BindVillage() throws Exception{
		lPage.CheckHavealook();
		lPage.CheckLoginInProtectDialogIsSuccess(Config.Contacts, 2, CommonPageIdName.BindVillage_id);	
	}
	/*
	 * 点击我感兴趣的组织
	 */
	public void testHavealook_MyInterestSite() throws Exception{
		lPage.CheckHavealook();
		lPage.CheckLoginInProtectDialogIsSuccess(Config.Contacts, 2, CommonPageIdName.MyInterestSite_layout);	
	}
	/*
	 * 点击添加/创建组织
	 */
	public void testHavealook_AddOrCreateSite() throws Exception{
		lPage.CheckHavealook();
		lPage.CheckLoginInProtectDialogIsSuccess(Config.Contacts, 2, CommonPageIdName.Add_Or_CreateSite_layout);	
	}
	/*
	 * 点击menu--添加组织
	 * failed
	 */
	public void testHavealook_Menu_AddSite() throws Exception{
		lPage.CheckHavealook();
		op.clickById(CommonPageIdName.menu_id);
		solo.clickOnText(CommonPageIdName.menu_AddSite);
	}
	/*
	 * 点击menu--组织排序
	 * failed
	 */
	public void testHavealook_Menu_SiteOrder() throws Exception{
		lPage.CheckHavealook();
		op.clickById(CommonPageIdName.menu_id);
		solo.clickOnText(CommonPageIdName.menu_SiteOrder);	
	}


}
