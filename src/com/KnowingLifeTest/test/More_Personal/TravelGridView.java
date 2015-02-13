package com.KnowingLifeTest.test.More_Personal;

import java.util.ArrayList;

import com.KnowingLifeTest.Config.CommonPageIdName;
import com.KnowingLifeTest.Config.Config;
import com.KnowingLifeTest.MethodGroup.CommonMethod;
import com.KnowingLifeTest.MethodGroup.MethodGroup;
import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.GridView;
import android.widget.ImageView;
import junit.framework.TestCase;

public class TravelGridView extends ActivityInstrumentationTestCase2 {

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
	public TravelGridView() {
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
	public void testTravelGrid() throws Exception{
		cm.clickonMore();
		ArrayList<GridView> gds=solo.getCurrentViews(GridView.class);
		GridView gd=gds.get(0);
        for (int i = 0; i < gd.getCount(); i++) {
        	ImageView imageView=(ImageView) solo.getView(CommonPageIdName.JoinSiteCheck_ImageView, i);
			solo.clickOnView(imageView);
			solo.sleep(Config.less_timeout);
			op.takeScreenshot();
			solo.sleep(Config.less_timeout);
			solo.goBack();		
		}
	}
}
