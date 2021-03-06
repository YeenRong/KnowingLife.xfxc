package com.KnowingLifeTest.test.XFXC;

import android.R.integer;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.KnowingLifeTest.Config.Config;
import com.KnowingLifeTest.Config.PageIdName;
import com.KnowingLifeTest.MethodGroup.CommonMethod;
import com.KnowingLifeTest.MethodGroup.MethodGroup;
import com.KnowingLifeTest.MethodGroup.OpenMethod;
import com.robotium.solo.Solo;

import junit.framework.TestCase;

public class XfxcHome extends ActivityInstrumentationTestCase2 {
	private Solo solo;
	//要测试的apk的包名
	private static final String TARGET_PACKAGE_ID=Config.PackageName;
	//classname是要测试的apk的主类名，也就是进入 apk第一个activity的类名，在签名的时候，可以看到
	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME=Config.MainActivity;
	private static Class launcherActivityClass;
	MethodGroup op=null;
	OpenMethod om=null;
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
	public XfxcHome() {
		super(TARGET_PACKAGE_ID,launcherActivityClass);
	}
	protected void setUp() throws Exception {	
    	super.setUp(); 
		solo = new Solo(getInstrumentation(), getActivity());
		op=new MethodGroup(solo);
		om=new OpenMethod(solo);
		cm=new CommonMethod(solo);
	}	
	
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();			
		super.tearDown();
	} 
	/*
	 * 测试幸福乡村首页各模块
	 * 
	 */
	public void testhomeswitch() throws Exception{
		op.takeScreenshot();
		op.into_module_back(Config.CulturalHall);
		op.into_module_back(Config.FarmHelp);
		op.into_module_back(Config.Rich_Experience);
		op.into_module_back(Config.beautifulScenes);
		op.into_module_back(Config.OneVillageOneProdect);
		op.into_module_back(Config.TravelRecommendation);
		op.into_module_back(Config.ContactUs);
	}

	
}
