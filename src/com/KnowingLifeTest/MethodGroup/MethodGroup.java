package com.KnowingLifeTest.MethodGroup;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Path.Op;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug.IntToString;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.KnowingLifeTest.Config.Config;
import com.KnowingLifeTest.Config.PageIdName;
import com.robotium.solo.Solo;
import com.squareup.spoon.Spoon;

import junit.framework.Assert;
public class MethodGroup extends Assert {
	private Solo solo;
	private File file;
	private BufferedWriter bw = null;
	private OutputStreamWriter osw = null;
	private String time;
	private String TAG=Config.TAG;


	@SuppressWarnings("static-access")
	@SuppressLint({ "SdCardPath", "SimpleDateFormat" })
	public MethodGroup(Solo so) {
		solo = so;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
		time = dateFormat.format(new Date());
		try {
			file = new File(Config.Logfilesavapath + new Build().MODEL + time
					+ ".txt");                            //log保存在sd卡Kascend目录下。以Log_设备名+当前系统时间.txt命名
			if (!file.exists()) {
				file.createNewFile();
			}
			osw = new OutputStreamWriter(new FileOutputStream(file, true),
					"gb2312");
			bw = new BufferedWriter(osw);
		} catch (Exception e) {
			Log.d(Config.TAG, "error");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@SuppressWarnings("static-access")
	@SuppressLint({ "SdCardPath", "SimpleDateFormat" })
	/**
	 * 向sd写入log
	 */
	public void writeLog(String TAG, String s) throws IOException {  
		if (null == bw) {
			file = new File(Config.Logfilesavapath+ new Build().MODEL + time
					+ ".txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			osw = new OutputStreamWriter(new FileOutputStream(file, true),
					"gb2312");
			bw = new BufferedWriter(osw);
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");// 可以方便地修改日期格式
		bw.write(dateFormat.format(new Date()) + " " + TAG + "----" + s);   //日志格式：     日期+TAG----log信息
		bw.newLine();
		bw.flush();
		// osw.close();
		// bw.close();
	}

    /**
     * 
     * 等待数据加载出来再继续操作
     */
	public void waitForPageFlush() {
		solo.sleep(1000);
		while (solo.searchText("正在获取数据", 3, false, true)) // 只检测页面上显示的字符，不检测隐藏的
		{
			solo.sleep(6000);
			
		}
		while(solo.searchText("无网络信息，请检查你的网络", 3, false, true))
		{
			try {
				this.writeLog(TAG, "网络差");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			solo.clickOnScreen(500, 900);                       //这边尝试刷新页面重新加载，有待完善
			solo.clickOnScreen(500, 1100);
			solo.sleep(1000);
			while (solo.searchText("正在获取数据", 1, false, true)) // 只检测页面上显示的字符，不检测隐藏的
			{
				solo.sleep(6000);
			}
		}
	}
	/**
	 *等待数据加载出来，找到对应的文本，然后再继续操作	 * 
	 */
	public void waitForPageFlush(String args) {
		solo.sleep(1000);
		while (solo.searchText("正在获取数据...", 1, false, true)) // 只检测页面上显示的字符，不检测隐藏的
		{
			solo.sleep(6000);
			
		}
		if(solo.searchText(args, 1, false, true)) //检查页面上的字符，判定检查成功，否则再等待5s
		{
			//
		}else{
			solo.sleep(3000);
		}
		while(solo.searchText("无网络信息，请检查你的网络", 1, false, true))
		{
			try {
				this.writeLog(TAG, "网络差");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			solo.clickOnScreen(500, 900);                       //这边尝试刷新页面重新加载，有待完善
			solo.clickOnScreen(500, 1100);
			solo.sleep(1000);
			while (solo.searchText("正在获取数据", 1, false, true)) // 只检测页面上显示的字符，不检测隐藏的
			{
				solo.sleep(6000);
				
			}
		}
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
		clickById("main_fragment_app_center_login_btn_submit");
		solo.sleep(5000);
		try{
		solo.waitForText(Config.xfxchome);
		}catch(Exception exception){
			Log.d(TAG, s2)	;	}
		
		//return true;
	}
	//public Boolean ViewIsE
	/**
	 * 将找到模块名称，截图（名称使用模块名），进入模块页面，再截图，然后返回上一层页面
	 */
	public void into_module_back(String args){
		solo.clickOnText(args, 1, false);
		solo.sleep(2000);
		takeScreenshot(args);
		Log.d(Config.TAG, args+Config.getsuccessmessage);
		solo.goBack();
		
	}
	/**
	 * 将页面从右边滑倒左边
	 */
	public void RightScrollToLeft() throws Exception{
		@SuppressWarnings("deprecation")
		float width=solo.getCurrentActivity().getWindowManager().getDefaultDisplay().getWidth();
		@SuppressWarnings("deprecation")
		float height=solo.getCurrentActivity().getWindowManager().getDefaultDisplay().getHeight();
		solo.drag(width * 7 / 8, width / 8, height * 7 / 8, height * 7 / 8, 9);
	}
	/**
	 * 关闭引导界面，并将每个页面截屏
	 */
	public void ClosedDalog() throws Exception{
		solo.sleep(6000);		
		takeScreenshot("help_1");
		solo.sleep(1000);
		RightScrollToLeft();
		solo.sleep(2000);
		takeScreenshot("help_2");
		RightScrollToLeft();
		solo.sleep(2000);
		takeScreenshot("help_3");
		clickById("btn_start_use");
		solo.sleep(2000);
	}
	/**
	 * 添加站点
	 */
	public void addSite(){
		
			LinearLayout linearLayout=(LinearLayout) solo.getView("site_main_add_more");
			solo.clickOnView(linearLayout);
			solo.sleep(5000);
			solo.takeScreenshot();
			EditText editText=(EditText)solo.getView("et_site_finding_search");
			solo.enterText(editText, "8822");
			takeScreenshot();
			solo.sleep(1000);
			clickById("site_finding_search_btn");
			solo.waitForText("组织搜索", 3, Config.timeout, false, true);
			solo.sleep(1000);
			takeScreenshot();
			//Button join_button=(Button) solo.getView("site_main_list_item_join_btn", 2);
			solo.clickOnButton("加入");
			solo.waitForText("加入组织验证", 3, Config.timeout, false, true);
			solo.sleep(1000);
			clickById("site_join_postJoinSite_btn");
			solo.sleep(1000);
			takeScreenshot();
			assertTrue("弹出提示框成功", solo.waitForDialogToOpen());
			clickById("btOK");
			//assertTrue("返回到通讯录主页成功", solo.waitForActivity("com.android.KnowingLife/.component.ContactGroup.JoinSiteActivity"));
			solo.sleep(2000);
			takeScreenshot();
	}
	/**
	 * 如果检测到通讯录或者商会帮主页，不执行操作
	 * 如果检测到登陆页面(登陆按钮存在)，就检查是否有按钮：忘记密码，新用户注册，随便看看
	 */
	public void CheckPageIsLoginPage() throws Exception{
		if(solo.searchText(Config.xfxchome, 1, false, true)){
			//ClosedDalog();
		}else if (solo.searchText(Config.DigitalVillage, 1, false, true)) {
		//	
		}//else if (solo.searchButton(PageIdName.LoginInButton_string, 1, true)) {
		else if (checkViewExitsInScreen(PageIdName.LoginInButton_id)>0) {
			//Log.d(Config.TAG, "zzzz");
			//ClosedDalog();
			solo.sleep(2000);
			//
			assertTrue(PageIdName.Forgetpasswd_string+PageIdName.GetFaild,(checkViewExitsInScreen(PageIdName.Forgetpasswd_id)>0));
			assertEquals(PageIdName.Forgetpasswd_string,ReturnName(PageIdName.Forgetpasswd_id));
			Log.d(Config.TAG, Config.getfailedmessage);
			assertTrue(PageIdName.HaveALook_string+PageIdName.GetFaild, checkViewExitsInScreen(PageIdName.HaveALook_id)>0);
			assertEquals(PageIdName.HaveALook_string, ReturnName(PageIdName.HaveALook_id));
			assertTrue(PageIdName.NewUserRegister_string+PageIdName.GetFaild, checkViewExitsInScreen(PageIdName.NewUserRegister_id)>0);
			assertEquals(PageIdName.NewUserRegister_string, ReturnName(PageIdName.NewUserRegister_id));
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
			assertTrue("当前页面不是登陆页面", checkViewExitsInScreen(PageIdName.LoginInButton_id)>0);	
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
		else if (checkViewExitsInScreen(PageIdName.LoginInButton_id)>0) {
			LoginIn(s1, s2);
			waitForPageFlush();
			//Log.d(Config.TAG, "zzzz1");
			assertTrue("当前页面不是幸福乡村", checkViewExitsInScreen(PageIdName.XFXC_HOME_Title)>0);
			Log.d(Config.TAG, "zzzz1");
		}
		
	}
	/**
	 * 将状态变为已登陆
	 */
	public void checkLoginOn() throws Exception{
		//CheckstayLoginPage();
		//LoginIn("13513141314", "369qaz");
		
			
	}
	
	/**
	 * 如果查看到选择组织，就截图
	 */
	public void ChooseSite(){
		if(solo.waitForDialogToOpen(10000)&&solo.searchText("选择组织", 2, false, true)){
			//CheckNumberisEqual();//验证字符串中站点数及成员数是否正确
			ArrayList<ListView> listView=solo.getCurrentViews(ListView.class);
			solo.clickInList(0);
			solo.clickOnButton("确认");
			
		}
	}
	/**
	 * 切换模块名称
	 */
	public void FindTabHost() throws Exception{
	Activity act=solo.getCurrentActivity();
	String id="tabs";
			//"tabhost";
	assertTrue(TAG, checkViewExitsInScreen(id)>0);
	int id1 = act.getResources().getIdentifier(id, "id",
			solo.getCurrentActivity().getPackageName());
	TabHost tabHost=(TabHost) act.findViewById(id1);
	int TabHostXY[]=new int[2];
	tabHost.getLocationOnScreen(TabHostXY);
	int tabhost_width=TabHostXY[0];
	int tabhost_heigth=TabHostXY[1];
	Log.d(TAG, String.valueOf(tabhost_heigth)+"："+String.valueOf(tabhost_width));
	}
	/**
	 * 检测文本是否可以搜索到，封装		solo.searchText(text, minimumNumberOfMatches, scroll, onlyVisible)
	 */

	public void CheckNumberisEqual(){
		Activity activity=solo.getCurrentActivity();
		//TextView tx=(TextView)solo.getView("headtext1");
		String s1=clipstring("headtext1", "有","个");
		String s2=clipstring("headtext1", "共","条");
		int sitenumber=StringToInt(s1);
		int datanumber=StringToInt(s2);
		ArrayList<ListView> listView=solo.getCurrentViews(ListView.class);
		for(int i=0;i<listView.size();i++){
			
		}
	}
	/**
	 * 将textview转换成string
	 */
	public String TextViewToString(String id){
		Activity act1=solo.getCurrentActivity();
		int id1 = act1.getResources().getIdentifier(id, "id",
				solo.getCurrentActivity().getPackageName());
		TextView TX = (TextView) act1.findViewById(id1);
		String tx1 = TX.getText().toString();
		return tx1;
	}
	/**
	 * 将字符串的id变为int类型的id，用于findviewbyid
	 */
	public int ReturnId(String id){
		Activity act1=solo.getCurrentActivity();

		int id1 = act1.getResources().getIdentifier(id, "id",
				solo.getCurrentActivity().getPackageName());
		
		return id1;
	}
	/**
	 * 首先判断id对应控件存在，只有控件存在才会做点击操作
	 */
    public void clickById(String id) {
		try {
			int id1;
			if ((id1 = checkViewExitsInScreen(id)) > 0) {
				View view = solo.getView(id1);// 得到View
				solo.clickOnView(view);// 点击
				Log.e(TAG, "ClickById " + id);
			} 
			else
			{
				//writeLog(TAG, id + " is not exit.");
				Log.e(TAG, "Exception accur at ClickById");
			}
		} catch (Exception e) {
			Log.e(TAG, "Exception accur at ClickById");
		}
	}
    /**
     * 对第n个同名控件进行操作
     */
    public void clickById(String id,int index){
    	try {
			int id1;
			if ((id1 = checkViewExitsInScreen(id)) > 0) {
				View view = solo.getView(id1,index);// 得到View
				solo.clickOnView(view);// 点击
				Log.e(TAG, "ClickById " + id);
			} 
			else
			{
				//writeLog(TAG, id + " is not exit.");
				Log.e(TAG, "Exception accur at ClickById");
			}
		} catch (Exception e) {
			Log.e(TAG, "Exception accur at ClickById");
		}
    	
    }
    /**
     * 检测id对应控件是否存在于当前activity中，需要注意的是这里无法屏蔽被隐藏的控件
     * 0,-1代表无效的id,大于0代表id存在
     */
	public int checkViewExitsInScreen(String id)
	{
		Activity act = solo.getCurrentActivity();// 获取当前Activity
		int id1 = act.getResources().getIdentifier(id, "id",
				solo.getCurrentActivity().getPackageName());// 获取id
		if (id1 == 0) {
			Log.e(TAG, "Invalid id");
			return 0;
		}
		
		ArrayList<View> views = solo.getCurrentViews();
		ArrayList<Integer> ids = new ArrayList<Integer>();
		for (int i = 0; i < views.size(); i++) {
			ids.add(views.get(i).getId());
		}
		if (ids.contains(id1)) {
			views.clear();
			ids.clear();
			return id1;
		} else {
			views.clear();
			ids.clear();
			Log.e(TAG, id + "not exits in screen");
			return -1;
		}
	}
	/**
	 * 获取某个view下带ID的子view
	 */
		public View getChildView(View view,int id,String viewClass){
			View view1=null;
			ArrayList<View> viewList = new ArrayList<View>();
			if(view != null) {				
				ViewGroup viewGroup = (ViewGroup) view;
				for(int i=0;i< viewGroup.getChildCount();i++) {
					Log.d(TAG,String.valueOf(viewGroup.getChildCount()));
					
					final View child=viewGroup.getChildAt(i);
					String temp=child.getClass().getName().toString();							
					temp= temp.substring(temp.lastIndexOf(".")+1,temp.length());
					if(temp.equals(viewClass)){
						viewList.add(child);
					}
				}
				if(id>viewList.size()-1){
					return view1;
				}else {
					view1=viewList.get(id);				
				}	
			}
			return view1;
		}
	  
		
		
		/**
		 * 获取当前activity 查找到控件id 将id变为文本，输出字符串，打印出log--字符串
		 */		
		public void ResourceIdToName(String id) {

			try {
				Activity act = solo.getCurrentActivity();
				int id1 = act.getResources().getIdentifier(id, "id",
						solo.getCurrentActivity().getPackageName());
				TextView TX = (TextView) act.findViewById(id1);
				String tx1 = TX.getText().toString();
				Log.d(TAG, tx1);
				// return true;
			} catch (Exception e) {
				Log.e(TAG, "Exception accur at ClickById");
			}
		}

		public String ReturnName(String id) {
			/*
			 * 获取当前activity 查找到控件id 将id变为文本，输出字符串，返回字符串
			 */
			try {
				Activity act = solo.getCurrentActivity();
				int id1 = act.getResources().getIdentifier(id, "id",
						solo.getCurrentActivity().getPackageName());
				TextView TX = (TextView) act.findViewById(id1);
				String tx = TX.getText().toString();
				return tx;
			} catch (Exception e) {
				Log.e(TAG, "Exception accur at ClickById");
				return null;
			}
		}
	public void takeScreenshot(){
		solo.takeScreenshot();
	}
	/*
	 * 带模块名称的截图
	 */
	public void takeScreenshot(String args){
		solo.takeScreenshot(args);
	}
	public void takeshot_name(String id) {
		String name;
		name = ReturnName(id).substring(0, ((ReturnName(id).length())));
		//solo.takeScreenshot(name);
	}
	public Integer StringToInt(String id) {
		solo.sleep(2000);
		TextView tvcount = (TextView) solo.getView(id, 0);
		String str = tvcount.getText().toString();
		String str1 = "";
		int num;
		str = str.trim();
		if (str != null && !"".equals(str)) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
					str1 += str.charAt(i);
				}
			}
		}
		num = Integer.parseInt(str1);
		return num;
	}
	/*public Integer StringToInt() {
		String str=clipstring(channel_name, x, y)
		int num;
		str = str.trim();
		if (str != null && !"".equals(str)) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
					str1 += str.charAt(i);
				}
			}
		}
		num = Integer.parseInt(str1);
		return num;
	}*/
	public String clipstring(String channel_name, String x) {
		// 截取某个特殊字符前的字符串，比如"."
		String s = channel_name;
		Log.d(TAG, "channel_name" + s);
		if (s == null || s.equals("")) {
			return null;
		} else {
			String new1 = s.substring(0, s.indexOf(x));
			return new1;
		}
	}
	public String clipstring(String id, String x,String y) {
		// 截取某个特殊字符前的字符串，比如".
		Activity act = solo.getCurrentActivity();
		int id1 = act.getResources().getIdentifier(id, "id",
				solo.getCurrentActivity().getPackageName());
		TextView TX = (TextView) act.findViewById(id1);
		String s = TX.getText().toString();
		Log.d(TAG, "channel_name" + s);
		if (s == null || s.equals("")) {
			return null;
		} else {
			String new1 = s.substring(s.indexOf(x), s.indexOf(y));
			return new1;
		}
	}
	/**
	 * 判断toast中是否含有给定的字符串（包含关系就可以，不用全部相等）
	 */
	public boolean ToastFindLike(String[] str) {
		Boolean result = false;
		TextView toastTextView = solo.getText(0);
		String toastText;
		// try{
		if (toastTextView != null) {
			toastText = toastTextView.getText().toString();
		}else {
			return false;
		}
		int i = 0;
		for (; i < str.length; i++) {
			String str1 = str[i];
			Log.e(TAG, "toastText" + toastText + "___" + str1 + "___"
					+ toastText.indexOf(str1));
			// assertEquals(message, expected, actual);
			if (toastText.indexOf(str1) >= 0) {
				result = true;
				break;
			}
			// Log.d(TAG, toastText);
		}
		// }catch()
		solo.waitForDialogToClose(2000);
		// Log.d(TAG, str1);
		if(result){
			Log.e(TAG, "find toast " + str[i]);
		}
		else{
			Log.e(TAG, "can't find toast");
		}
		return result;
	}
	/**
	 * 登陆后，通过提示来判定登陆是否成功
	 */
	public int ToastFindLike1(String[] str) {
		Boolean result = false;
		TextView toastTextView = solo.getText(0);
		String toastText;
		// try{
		if (toastTextView != null) {
			toastText = toastTextView.getText().toString();
		} else {
			return -1;
		}
		int i = 0;
		for (; i < str.length; i++) {
			String str1 = str[i];
			Log.e(TAG, "toastText" + toastText + "___" + str1 + "___"
					+ toastText.indexOf(str1));
			// assertEquals(message, expected, actual);
			if (toastText.indexOf(str1) >= 0) {
				result = true;
				break;
			}
			// Log.d(TAG, toastText);
		}
		// }catch()
		solo.waitForDialogToClose(2000);
		// Log.d(TAG, str1);
		if (result) {
			Log.e(TAG, "find toast " + str[i]);
			return i + 1;
		} else {
			Log.e(TAG, "can't find toast");
			return -1;
		}
	}


}