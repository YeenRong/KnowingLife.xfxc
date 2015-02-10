package com.KnowingLifeTest.MethodGroup;

import java.util.ArrayList;

import android.R.integer;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.KnowingLifeTest.Config.Config;
import com.KnowingLifeTest.Config.PageIdName;
import com.robotium.solo.Solo;
import com.robotium.solo.Timeout;
import com.squareup.spoon.Spoon;

import junit.framework.Assert;
import junit.framework.TestCase;
public class LoginPage extends Assert{
	
	private Solo solo;
	private MethodGroup op;
	private OpenMethod om;
	private CommonMethod cm;
	public LoginPage(Solo so) {
		solo = so;
		op = new MethodGroup(solo);
		om=new OpenMethod(solo);
		cm=new CommonMethod(solo);
	}
	
	/**
	 * 关闭引导界面，并将每个页面截屏
	 */
	public void ClosedDalog() throws Exception{
		solo.sleep(6000);		
		op.takeScreenshot("help_1");
		solo.sleep(1000);
		op.RightScrollToLeft();
		solo.sleep(2000);
		op.takeScreenshot("help_2");
		op.RightScrollToLeft();
		solo.sleep(2000);
		op.takeScreenshot("help_3");
		op.clickById("btn_start_use");
		solo.sleep(2000);
	}
	/**
	 * 登陆页面，清除数据输入账号，密码，点击登陆
	 */
	public void LoginIn(String s1, String s2) {
		
		solo.sleep(2000);
		Activity act = solo.getCurrentActivity();// 获取当前Activity
		Spoon.screenshot(act, "11");
		solo.clickOnEditText(0);
		solo.sleep(1000);
		solo.enterText( 0, s1);
		solo.clickOnEditText(1);
		solo.sleep(1000);
		solo.enterText(1, s2);
		solo.sleep(2000);
		op.clickById("main_fragment_app_center_login_btn_submit");
		solo.sleep(5000);
		try{
		solo.waitForText(Config.xfxchome);
		}catch(Exception exception){
			Log.d(Config.TAG, s2)	;	}
		
		//return true;
	}
	/**
	 * 如果检测到通讯录或者幸福乡村主页，不执行操作
	 * 如果检测到登陆页面(登陆按钮存在)，就检查是否有按钮：忘记密码，新用户注册，随便看看
	 */
	public void CheckPageIsLoginPage() throws Exception{
		if(solo.searchText(Config.xfxchome, 1, false, true)){
			//ClosedDalog();
		}else if (solo.searchText(Config.DigitalVillage, 1, false, true)) {
		//	
		}//else if (solo.searchButton(PageIdName.LoginInButton_string, 1, true)) {
		else if (op.checkViewExitsInScreen(PageIdName.LoginInButton_id)>0) {
			//Log.d(Config.TAG, "zzzz");
			//ClosedDalog();
			solo.sleep(2000);
			//
			assertTrue(PageIdName.Forgetpasswd_string+PageIdName.GetFaild,(op.checkViewExitsInScreen(PageIdName.Forgetpasswd_id)>0));
			assertEquals(PageIdName.Forgetpasswd_string,op.ReturnName(PageIdName.Forgetpasswd_id));
			Log.d(Config.TAG, Config.getfailedmessage);
			assertTrue(PageIdName.HaveALook_string+PageIdName.GetFaild, op.checkViewExitsInScreen(PageIdName.HaveALook_id)>0);
			assertEquals(PageIdName.HaveALook_string, op.ReturnName(PageIdName.HaveALook_id));
			assertTrue(PageIdName.NewUserRegister_string+PageIdName.GetFaild, op.checkViewExitsInScreen(PageIdName.NewUserRegister_id)>0);
			assertEquals(PageIdName.NewUserRegister_string, op.ReturnName(PageIdName.NewUserRegister_id));
			Log.d(Config.TAG, "zzzz");
		}
	}
	/**
	 * @pamager检查引导页面三滑页关闭成功，并检查当前页面是否在登陆页面
	 * 如果检测到通讯录页面，不执行
	 * 如果检测到登陆页面，不执行
	 * 如果未检测到以上页面，就关闭引导页面，并检查是否是登陆页面
	 */
	public void CheckDialogClosedSuccess() throws Exception{
		if(solo.searchText(Config.xfxchome, 1, false, true)){
			//ClosedDalog();
			
		}else if (solo.searchButton("登陆", 1, true)) {
			//
		}else {
			ClosedDalog();
			solo.sleep(2000);
			//Log.d(Config.TAG, "zzzz2");
			assertTrue("当前页面不是登陆页面", op.checkViewExitsInScreen(PageIdName.LoginInButton_id)>0);	
			Log.d(Config.TAG, "当前页面不是登陆页面");
		}
	}
	/**
	 * 检查是否登陆成功，则当前页面标题是商会帮
	 */
	public void CheckLoginInSuccess(String s1,String s2) throws Exception{
		if(solo.searchText(Config.xfxchome, 1, false, true)){
			//ClosedDalog();
			
		}//else if (solo.searchButton("登陆", 1, true)) {
		else if (op.checkViewExitsInScreen(PageIdName.LoginInButton_id)>0) {
			LoginIn(s1, s2);
			op.waitForPageFlush();
			//Log.d(Config.TAG, "zzzz1");
			assertTrue("当前页面不是幸福乡村", op.checkViewExitsInScreen(PageIdName.XFXC_HOME_Title)>0);
			Log.d(Config.TAG, "zzzz1");
		}		
	}
	/**
	 * 退出登陆
	 */
	public void LoginOut() throws Exception{
		cm.clickonMore();
		
	}
	
	/**
	 * 将状态变为已登陆
	 */
	public void checkLoginOn() throws Exception{
		//CheckstayLoginPage();
		//LoginIn("13513141314", "369qaz");
		
			
	}
	
}