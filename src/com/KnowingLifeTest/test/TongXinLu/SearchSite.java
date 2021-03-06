
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
	/**
	 * 点击添加／查找组织，输入搜索词,点击搜索，搜索到结果的第一个，点击加入，然后返回到通讯录页面
	 * "组织代码/名称/描述关键字"
	 */
	/*
	 * 输入搜索词－－站点名称－－花园村
	 */
	public void testSearchSite_name() throws Exception{
		cm.SearchSite_Name("花园村");		
	}
	/*
	 * 输入搜索词－－站点代码－－109605
	 */
	public void testSearchSite_code() throws Exception{
		cm.SearchSite_Name("109605");
	}
	/*
	 *输入搜索词－－描述关键字－－贺村镇距
	 */
	public void testSearchSite_desc() throws Exception{
		cm.SearchSite_Name("贺村镇距");
	}
}