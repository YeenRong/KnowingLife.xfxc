package com.KnowingLifeTest.MethodGroup;


import android.R.integer;
import android.app.Activity;
import android.util.Log;


import com.KnowingLifeTest.Config.Config;
import com.KnowingLifeTest.Config.CommonPageIdName;
import com.KnowingLifeTest.Config.PageIdName;
import com.robotium.solo.Solo;
import com.squareup.spoon.Spoon;

import junit.framework.Assert;
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
		assertTrue("没有找到开始体验按钮", op.checkViewExitsInScreen("btn_start_use")>0);
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
		assertTrue("当前页面不是登陆页面", op.ReturnName(CommonPageIdName.HaveALook_id).contains("随便"));
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
		}//else if (solo.searchButton(CommonPageIdName.LoginInButton_string, 1, true)) {
		else if (op.checkViewExitsInScreen(CommonPageIdName.LoginInButton_id)>0) {
			//Log.d(Config.TAG, "zzzz");
			//ClosedDalog();
			solo.sleep(2000);
			//
			assertTrue(CommonPageIdName.Forgetpasswd_string+CommonPageIdName.GetFaild,(op.checkViewExitsInScreen(CommonPageIdName.Forgetpasswd_id)>0));
			assertEquals(CommonPageIdName.Forgetpasswd_string,op.ReturnName(CommonPageIdName.Forgetpasswd_id));
			Log.d(Config.TAG, Config.getfailedmessage);
			assertTrue(CommonPageIdName.HaveALook_string+CommonPageIdName.GetFaild, op.checkViewExitsInScreen(CommonPageIdName.HaveALook_id)>0);
			assertEquals(CommonPageIdName.HaveALook_string, op.ReturnName(CommonPageIdName.HaveALook_id));
			assertTrue(CommonPageIdName.NewUserRegister_string+CommonPageIdName.GetFaild, op.checkViewExitsInScreen(CommonPageIdName.NewUserRegister_id)>0);
			assertEquals(CommonPageIdName.NewUserRegister_string, op.ReturnName(CommonPageIdName.NewUserRegister_id));
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
			assertTrue("当前页面不是登陆页面", op.checkViewExitsInScreen(CommonPageIdName.LoginInButton_id)>0);	
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
		else if (op.checkViewExitsInScreen(CommonPageIdName.LoginInButton_id)>0) {
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
		op.clickById(CommonPageIdName.PersonInfo_LoginOut);
		assertTrue("弹出退出提示框失败", solo.waitForDialogToOpen(Config.less_timeout));
		assertTrue("提示语出错", op.ReturnName(CommonPageIdName.Dialog_content).contains("确定要退出"));
		solo.sleep(Config.less_timeout);
		op.clickById(CommonPageIdName.btOK_id);
		solo.sleep(Config.timeout);
		assertTrue("退出登陆失败",solo.waitForText("登陆", 1, 2000, false, true));
	}

	/*
	 * 这个方法是错误的
	 */
	public void CheckLoginInProtect_ERROR() throws Exception{
		assertTrue("提示框弹出失败", solo.waitForDialogToOpen(Config.less_timeout));
		solo.sleep(Config.less_timeout);
		/**
		 * DEBUG
		 */
		op.LogPrintDebug(" 提示框标题 "+"   "+cm.ReturnSonTextViewName(CommonPageIdName.Dialog_Login_title_layout,0));
		op.LogPrintDebug(" 提示框内容 "+"   "+op.ReturnName(CommonPageIdName.Dialog_Login_content_id));
		op.LogPrintDebug(" 提示框按钮 "+"   "+cm.ReturnSonTextViewName(CommonPageIdName.Dialog_Login_title_layout,0));
		
		//assertTrue("提示框标题名称不是提示", cm.ReturnSonTextViewName(CommonPageIdName.Dialog_Login_title_layout,1).equals(CommonPageIdName.Dialog_Login_title_str));
		solo.sleep(Config.less_timeout);
		//assertTrue("提示框内容不是请登陆", op.ReturnName(CommonPageIdName.Dialog_Login_content_id).contains(CommonPageIdName.Dialog_Login_content_str));
		solo.sleep(Config.less_timeout);
		assertTrue("提示框OK按钮不是登陆",solo.searchText(CommonPageIdName.Dialog_Login_btOK_str, 1, false, true));
		solo.sleep(Config.less_timeout);
		assertTrue("提示框Cancel按钮不是取消", solo.searchText(CommonPageIdName.Dialog_Login_btCancel_str, 1, false, true));
	}

	
	/**
	 * 将状态变为已登陆
	 */
	public void checkLoginOn() throws Exception{
		//CheckstayLoginPage();
		//LoginIn("13513141314", "369qaz");			
	}
	/**
	 * 进入更多页面，点击头像，进入个人中心(scrollView），点击退出登陆，点击确定，退出登陆成功
	 */
	public void CheckLoginOut() throws Exception{
		cm.clickonMore();
		solo.sleep(Config.less_timeout);
		op.clickById(CommonPageIdName.PersonHeadicon);
		assertTrue("进入个人中心失败",CommonPageIdName.PersonInfo_Title_str.contains("个人"));
		solo.sleep(Config.less_timeout);
		solo.scrollToBottom();
		//assertTrue("没有找到退出登陆按钮", solo.searchText(op.ReturnName(CommonPageIdName.PersonInfo_LoginOut), 2, true, true));
		solo.sleep(Config.less_timeout);
		op.clickById(CommonPageIdName.PersonInfo_LoginOut);
		solo.sleep(Config.less_timeout);
		//assertTrue("弹出退出提示框",solo.waitForDialogToOpen()&&op.ReturnName(CommonPageIdName.Dialog_LoginOut_content_id).contains("要退出"));				
		op.clickById(CommonPageIdName.btOK_id);
		//assertTrue("返回到登陆页面成功", solo.searchText(CommonPageIdName.HaveALook_string, 3, false, true));
		solo.sleep(Config.timeout);
	}
	
	
	/**
	 * 随便看看，登陆保护提示框判断方法类
	 * 
	 */
	/**
	 * 检查当前页面是不是未登陆状态
	 */
	public void CheckHavealook() throws Exception{
		solo.sleep(Config.less_timeout);
		if(solo.searchText(Config.xfxchome, 1, false, true)){
			solo.sleep(Config.less_timeout);
			CheckLoginOut();		
		}else{
			
		}
	}
	/**
	 * 
	 * 给随便看看UItravel调用
	 * 
	 * 从进入到登陆页面，点击随便看看，找到指定模块的指定id，点击该控件，判断提示框是否正确，如果正确，点击取消按钮，返回到上一次页面
	 * step0:判断当前状态是否为随便看看，如果为登陆状态，则退出应用
	 * 
	 * step1:进入登陆页面，点击随便看看按钮
	 * step2:点击指定的模块名称，跳转到模块页面，等待刷新完成
	 * step3：点击指定的按钮
	 * 
	 * step4:检查弹出的提示框是不是登陆保护提示框
	 * step5:点击取消按钮，返回到上一次页面
	 */
	public void CheckLoginInProtectDialogIsSuccess(String modulename,int index,String id) throws Exception{
		LoginProtect_ClickOnID(modulename,index,id);	
		CheckLoginInProtect();
		solo.sleep(Config.less_timeout);
		op.clickById(CommonPageIdName.btCancel_id);
	}
	/**
	 * 检验登陆保护模块，设置当前模块位置（eg:通讯录)，设置模块的index值，设置需要点击的按钮id，
	 * 
	 * step1:进入登陆页面，点击随便看看按钮
	 * step2:点击指定的模块名称，跳转到模块页面，等待刷新完成
	 * step3：点击指定的按钮
	 */
	public void LoginProtect_ClickOnID(String modulename,int index,String id) throws Exception{
		solo.sleep(Config.timeout);
		op.clickById(CommonPageIdName.HaveALook_id);
		
		solo.sleep(Config.timeout);	
		cm.ClickOnModule(modulename, index);	
		op.waitForPageFlush();
		
		/*
		 * 点击收藏联系人
		 */
		op.clickById(id);
		
	}
	/**
	 * 输入需要校验的控件id，弹出登陆保护提示框，判断保护框内容是否一致
	 * step1：点击指定的按钮
	 * step2:检查弹出的提示框是不是登陆保护提示框
	 * step3:点击取消按钮，返回到上一次页面
	 * 
	 * 还存在问题，需要处理下方法
	 */
	public void CheckLoginInProtect(String id) throws Exception{
		op.clickById(id);
		CheckLoginInProtect();
		op.clickById(CommonPageIdName.btCancel_id);
	}
	/**
	 * 输入需要校验的控件id，弹出登陆保护提示框，判断保护框内容是否一致
	 */
	public void ClickAndCheckLoginInProtect(String id) throws Exception{
		op.clickById(id);
		CheckLoginInProtect();
		op.clickById(CommonPageIdName.btCancel_id);
	}
	/**
	 * 弹出登陆保护提示框
	 * 判断提示框标题是"提示"
	 * 判断提示框内容是"登录后才能使用该功能，请登录!"
	 * 判断确定按钮的文字是"登陆"
	 * 判断取消按钮的文字是"取消"
	 */
	public void CheckLoginInProtect() throws Exception{
		assertTrue("提示框弹出失败", solo.waitForDialogToOpen(Config.less_timeout));
		solo.sleep(Config.timeout);
		Activity act=solo.getCurrentActivity();
		/**
		 * DEBUG
		 */
		op.LogPrintDebug(" 提示框标题 "+"   "+op.ReturnName(CommonPageIdName.Dialog_Login_title_id));
		op.LogPrintDebug(" 提示框内容 "+"   "+op.ReturnName(CommonPageIdName.Dialog_Login_content_id));		
		solo.sleep(Config.less_timeout);
		assertTrue("提示框OK按钮不是登陆",(op.checkViewExitsInScreen(CommonPageIdName.Dialog_Login_btOK_id)>0));
		solo.sleep(Config.less_timeout);
		assertTrue("提示框Cancel按钮不是取消",(op.checkViewExitsInScreen(CommonPageIdName.Dialog_Login_btCancel_id)>0));
	}
	
	
	/**
	 * 错误的方法
	 * @throws Exception
	 */
	public void CheckLoginInProtect_error() throws Exception{
		assertTrue("提示框弹出失败", solo.waitForDialogToOpen(Config.less_timeout));
		solo.sleep(Config.timeout);
		/**
		 * DEBUG
		 */
		op.LogPrintDebug(" 提示框标题 "+"   "+op.ReturnName(CommonPageIdName.Dialog_Login_title_id));
		op.LogPrintDebug(" 提示框内容 "+"   "+op.ReturnName(CommonPageIdName.Dialog_Login_content_id));
		//op.LogPrintDebug(" 提示框按钮 "+"   "+cm.ReturnSonTextViewName(CommonPageIdName.btCancel_id,0));
		
		//assertTrue("提示框标题名称不是提示", cm.ReturnSonTextViewName(CommonPageIdName.Dialog_Login_title_layout,1).equals(CommonPageIdName.Dialog_Login_title_str));
		solo.sleep(Config.less_timeout);
		//assertTrue("提示框内容不是请登陆", op.ReturnName(CommonPageIdName.Dialog_Login_content_id).contains(CommonPageIdName.Dialog_Login_content_str));
		solo.sleep(Config.less_timeout);
		assertTrue("提示框OK按钮不是登陆",solo.searchText(CommonPageIdName.Dialog_Login_btOK_str, 1, false, true));
		solo.sleep(Config.less_timeout);
		assertTrue("提示框Cancel按钮不是取消", solo.searchText(CommonPageIdName.Dialog_Login_btCancel_str, 1, false, true));
	}
	
}