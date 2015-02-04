package com.KnowingLifeTest.MethodGroup;

import java.util.ArrayList;

import android.R.integer;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.KnowingLifeTest.Config.Config;
import com.KnowingLifeTest.Config.PageIdName;
import com.robotium.solo.Solo;
import com.robotium.solo.Timeout;

import junit.framework.Assert;
import junit.framework.TestCase;
public class CommonMethod extends Assert{

	private Solo solo;
	private MethodGroup op;
	private OpenMethod om;
	final String TAG = "TestLog_kascend";
	private ArrayList<String> _name = new ArrayList<String>();	
	private ArrayList<View> viewList = new ArrayList<View>();	
	private ArrayList<Integer> _size = new ArrayList<Integer>();
	private int currentTab = 0;

	public CommonMethod(Solo so) {
		solo = so;
		op = new MethodGroup(solo);
		om=new OpenMethod(solo);
	}
	
	/**
	 * 切换模块的方法，0--动态,1--智媒体,2--通讯录,3--商会帮,4--更多
	 */
	/*
	//动态模块
	public void DynamicMode(){
		op.clickById(PageIdName.TabText, 0);	
		solo.sleep(Config.timeout);
		solo.takeScreenshot(Config.Dynamic);
	}
	//智媒体模块
	public void Chilean_mediaMode(){
		op.clickById(PageIdName.TabText, 1);
		solo.sleep(Config.timeout);
		solo.takeScreenshot(Config.Chilean_media);

	}
	//通讯录模块
	public void ContactsMode(){
		op.clickById(PageIdName.TabText, 2);
		solo.sleep(Config.timeout);
		solo.takeScreenshot(Config.Contacts);

	}
	//商会帮模块
	public void SHBhomeMode(){
		op.clickById(PageIdName.TabText, 3);
		solo.sleep(Config.timeout);
		solo.takeScreenshot(Config.SHBhome);

	}
	//更多模块
	public void MoreMode(){
		op.clickById(PageIdName.TabText, 4);
		solo.sleep(Config.timeout);
		solo.takeScreenshot(Config.More);

	}
	*/
	/**
	 * 封装模块名称,点击动态
	 */	
	public void clickonDynamic(){
		View view=solo.getView("tabText", 0);
		solo.clickOnView(view);
		op.waitForPageFlush(Config.Dynamic);
	}
	/**
	 * 封装模块名称,点击智媒体
	 */
	public void clickonChilean_media(){
		View view=solo.getView("tabText", 1);
		solo.clickOnView(view);
		op.waitForPageFlush();
	}
	/**
	 * 封装模块名称,点击幸福乡村
	 */
	public void clickonXFXChome(){
		View view=solo.getView("tabText", 3);
		solo.clickOnView(view);
		op.waitForPageFlush(Config.xfxchome);

	}
	/**
	 * 封装模块名称,点击数字村谱
	 */
	public void clickonContacts(){
		View view=solo.getView("tabText", 2);
		solo.clickOnView(view);
		op.waitForPageFlush(Config.DigitalVillage);
	}
	/**
	 * 封装模块名称,点击更多
	 */
	public void clickonMore(){
		View view=solo.getView("tabText", 4);
		solo.clickOnView(view);
		op.waitForPageFlush(Config.More);
	}
	/**
	 * 获取当前各模块的坐标点
	 */
	public void TabHostCoordinates() throws Exception{
		op.takeScreenshot();
		op.waitForPageFlush(PageIdName.SHB_HOME_Title);
		for(int i=0;i<5;i++){
		om.getClickCoordinates(solo.getView("tabText", i));
		}
	}
	/**
	 * 输入项目名称
	 */
	public void EnterProjectName(){
		EditText editText=(EditText)solo.getView(PageIdName.PublishPage_ProjectName_id);
		solo.enterText(editText, "中国高铁");
	}
	public void EnterMoneyNum(){
		EditText editText=(EditText)solo.getView(PageIdName.PublishPage_spendMoney_id);
		solo.enterText(editText, "30");
	}
	/*
	public void EnterchooseArea(){
		EditText editText=(EditText)solo.getView(PageIdName.PublishPage_chooseArea_id);
		solo.clickOnView(editText);
		solo.sleep(1000);
		View province=om.idToView(PageIdName.PublishPage_Area_province_id);
		solo.sleep(1000);
		View city=om.idToView(PageIdName.PublishPage_Area_city_id);
		solo.sleep(1000);
		View town=om.idToView(PageIdName.PublishPage_Area_town_id);
		solo.sleep(1000);
		Log.d(TAG, "获取id成功");
		solo.clickOnView(province);
		solo.sleep(1000);
		om.dragViewTopToDown(province);
		solo.sleep(2000);
		om.dragViewTopToDown(city);
		solo.sleep(2000);
		om.dragViewTopToDown(town);
		solo.sleep(2000);
		op.clickById(PageIdName.Confirm);
	}*/
	/*
	 * 通用的方法：只要输入一个关键字编辑框的id名称，其他选择地区框，三个id都一样，都是province,month,month2
	 */
	public void EnterchooseArea(String id){
		//id 代表的是选择区域进入时的编辑框ID
		EditText editText=(EditText)solo.getView(id);
		solo.clickOnView(editText);
		solo.sleep(1000);
		View province=solo.getView(PageIdName.PublishPage_Area_province_id);
		solo.sleep(1000);
		View city=solo.getView(PageIdName.PublishPage_Area_city_id);
		solo.sleep(1000);
		View town=solo.getView(PageIdName.PublishPage_Area_town_id);
		solo.sleep(1000);
		Log.d(TAG, "获取id成功");
		//solo.clickOnView(province);
		solo.sleep(1000);
		om.dragPage(province);
		solo.sleep(1000);
		om.dragPage(city);
		solo.sleep(1000);
		om.dragPage(town);
		solo.sleep(1000);
		op.clickById(PageIdName.Confirm);
	}
	/*
	 * 选择行业，可以做for循环
	 */
	public void Enterchooseindusty(){
		EditText editText=(EditText)solo.getView(PageIdName.PublishPage_chooseIndustry_id);
		solo.clickOnView(editText);
		solo.sleep(1000);
		//View view1=solo.getView(PageIdName.PublishPage_Area_province_id);
		ArrayList<ListView> listView=solo.getCurrentViews(ListView.class);
		View view=solo.getView("text1", 3);
		solo.clickOnView(view);
	}
	public void EnterProjectinfo(){
		EditText editText=(EditText)solo.getView(PageIdName.PublishPage_Projectinfo_id);
		solo.enterText(editText, "中国高铁");
	}
	public void EnterProjectcontact(){
		EditText editText=(EditText)solo.getView(PageIdName.PublishPage_Fcontact_id);
		solo.enterText(editText, "13067905358");
	}
	/**
	 * 项目管理页面方法
	 */
	//暂停或者发布项目
	public void PauseclickOn(String pausename,String toast) throws Exception{
	op.clickById(PageIdName.ProjectManager_id);
	op.waitForPageFlush();
	ArrayList<ListView> listView=solo.getCurrentViews(ListView.class);
	if(listView.size()==0){
		Log.d(Config.TAG, "嗯呃，暂时没内容。");
	}else{
		for(int i=0;i<listView.size();i++){
			
			TextView view=(TextView) solo.getView(PageIdName.Project_status_id, i);
			if(view.getText().toString().equals(pausename)){
			//if(view.getText().toString().equals("发布")){
				op.clickById(PageIdName.status_menu);
				solo.sleep(1000);
				op.clickById(PageIdName.status_Pause_id, i);
				solo.takeScreenshot(pausename);
				assertTrue("获取信息失败", op.ToastFindLike(new String[]{"正在获取数据",toast}));
			//	solo.takeScreenshot("发布");
			//	assertTrue("暂停项目不成功", op.ToastFindLike(new String[]{"正在获取数据","项目已暂停"}));
			}
		}
	}
	}
	
	

	/*
	 * 通讯录模块方法集合
	 */
	
	/*
	 * 进入到搜索站点页面
	 */
	
	
	/*
	 * 供应信息的功能模块
	 */
	/*
	 * 发布供应
	 */
	public void createSupply() throws Exception{
		op.clickById("supplydemand_supply_publish");
		op.takeScreenshot();
	}
	/*
	 * 发布需求
	 */
	public void createDemand() throws Exception{
		op.clickById("supplydemand_demand_publish");
		op.takeScreenshot();
	}
	/*
	 * 供求管理
	 */
	public void supplydemand_manager() throws Exception{
		op.clickById("supplydemand_manager");
		op.takeScreenshot();
	}
	
	
	/*
	 * 商帮互助
	 */
	/*
	 * 发布互助
	 */
	public void createBunisessHelp() throws Exception{
		op.clickById("business_mainlist_item_new_consult");
		op.takeScreenshot();
	}
	
	
	
	/*
	 * 发布页面共有的方法，输入名称，地区，详情，联系方式，添加图片
	 */
	
}