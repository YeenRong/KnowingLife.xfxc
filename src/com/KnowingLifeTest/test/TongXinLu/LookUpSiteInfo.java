package com.KnowingLifeTest.test.TongXinLu;

import com.KnowingLifeTest.Config.Config;
import com.KnowingLifeTest.MethodGroup.CommonMethod;
import com.KnowingLifeTest.MethodGroup.MethodGroup;
import com.robotium.solo.Solo;
import android.test.ActivityInstrumentationTestCase2;
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

}