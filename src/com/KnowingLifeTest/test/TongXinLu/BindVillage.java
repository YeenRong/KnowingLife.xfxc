package com.KnowingLifeTest.test.TongXinLu;

import com.KnowingLifeTest.Config.CommonPageIdName;
import com.KnowingLifeTest.Config.Config;
import com.KnowingLifeTest.MethodGroup.CommonMethod;
import com.KnowingLifeTest.MethodGroup.MethodGroup;
import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

public class BindVillage extends ActivityInstrumentationTestCase2 {
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
	public BindVillage() {
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
	/**
	 * 验证绑定村庄：搜索到该站点，然后点击绑定按钮，返回到通讯录主页，页面刷新，我的村谱中有该站点
	 */
	public void testBindVillage() throws Exception{
		cm.clickonContacts();
		op.waitForPageFlush(CommonPageIdName.LocalContact_str);
		if(solo.searchText(CommonPageIdName.BindVillage_string, 2, false, true)){
			cm.SearchVillageAndBind();			
		}else{
			cm.UnBundVillage();
			cm.SearchVillageAndBind();
		}
		
		
	}
}