package com.KnowingLifeTest.test.More_Personal;

import android.test.ActivityInstrumentationTestCase2;

import com.KnowingLifeTest.Config.CommonPageIdName;
import com.KnowingLifeTest.Config.Config;
import com.KnowingLifeTest.Config.PageIdName;
import com.KnowingLifeTest.MethodGroup.CommonMethod;
import com.KnowingLifeTest.MethodGroup.LoginPage;
import com.KnowingLifeTest.MethodGroup.MethodGroup;
import com.KnowingLifeTest.MethodGroup.OpenMethod;
import com.robotium.solo.Solo;

import junit.framework.TestCase;

public class LoginIn extends ActivityInstrumentationTestCase2 {
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
	public LoginIn() {
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
	 * 测试登陆
	 */
	
	//检查引导页面是否关闭
	public void testAHelpPageIsClosed() throws Exception{		
		lPage.CheckDialogClosedSuccess();
	}
	//检查随便看看，注册新用户，忘记密码文字是否存在
	public void testBTextIsExist() throws Exception{
        lPage.CheckPageIsLoginPage();
	}
	//检查登陆是否成功
	public void testLoginInSuccess() throws Exception{
		lPage.CheckLoginInSuccess(Config.usernammString, Config.passwordString);
	}
}