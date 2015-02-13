package com.KnowingLifeTest.MethodGroup;

import java.util.ArrayList;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.KnowingLifeTest.Config.Config;
import com.KnowingLifeTest.Config.PageIdName;
import com.robotium.solo.Solo;

import junit.framework.Assert;

/**
 * 将商会帮模块相关的的操作独立出来
 * @author Administrator
 *
 */
public class ShbPageOperate extends Assert{
	private Solo solo;
	private MethodGroup op;
	private OpenMethod om;
	private CommonMethod cm;
	
	public ShbPageOperate(Solo so) {
		solo = so;
		op = new MethodGroup(solo);
		om=new OpenMethod(solo);
		cm=new CommonMethod(solo);
	}
	
	
	/*
	 * 项目撮合
	 * 
	 */
	
	/**
	 * 创建项目并保存为草稿
	 */
	public void CreateProgramSaveCaogao() throws Exception{
		op.waitForPageFlush("项目撮合");
		solo.clickOnText("项目撮合", 1, false);
		op.waitForPageFlush();
		op.takeScreenshot();
		solo.sleep(2000);
		op.clickById("publish_project");
		solo.sleep(2000);
		op.takeScreenshot();
		PublishPageEnterInfo();
		op.clickById(PageIdName.PublishPage_savecaogao_id);
		assertTrue("", op.ToastFindLike(new String[] {"项目已存为草稿"}));
	}
	/**
	 * 创建项目并发布项目
	 */
	public void CreateProgramSave() throws Exception{
		op.waitForPageFlush("项目撮合");
		solo.clickOnText("项目撮合", 1, false);
		op.waitForPageFlush();
		op.takeScreenshot();
		solo.sleep(2000);
		op.clickById("publish_project");
		solo.sleep(2000);
		op.takeScreenshot();
		PublishPageEnterInfo();
		op.clickById(PageIdName.PublishPage_publish_id);
		assertTrue("", op.ToastFindLike(new String[] {"项目已发布"}));
		
	}
	/**
	 * @author liuliang
	 * @date 2015-02-10
	 * 发布页面共有的方法，输入名称，地区，详情，联系方式，添加图片
	 * 
	 * 发布页面，输入各项信息
	 * 目前为项目发布页面
	 * @throws Exception
	 */
	public void PublishPageEnterInfo() throws Exception{
		EnterProjectName();
		EnterMoneyNum();
		EnterchooseArea(PageIdName.PublishPage_chooseArea_id);
		Enterchooseindusty();
		EnterProjectinfo();
		EnterProjectcontact();
	}
	/**
	 * 
	 */
	
	/**
	 * 将已发布的项目暂停
	 */
	public void PublishToCaoGao() throws Exception{
		op.waitForPageFlush("项目撮合");
		solo.clickOnText("项目撮合", 1, false);
		op.waitForPageFlush();
		op.takeScreenshot();
		PauseclickOn("发布", "项目已暂停");				
	}
	/**
	 *  将已暂停的项目变为发布
	 * @throws Exception
	 */	 
	public void CaogaoToPublish() throws Exception{
		op.waitForPageFlush("项目撮合");
		solo.clickOnText("项目撮合", 1, false);
		op.waitForPageFlush();
		op.takeScreenshot();
		PauseclickOn("暂停", "项目已发布");	
	}
	/**
	 * @deprecated
	 * @throws Exception
	 */
	public void testchangerow() throws Exception{
		op.waitForPageFlush("项目撮合");
		//solo.goBackToActivity("SiteSearchActivity");
	}
	
	/**
	 * 进入项目详情页面
	 */
	public void EnterProgramInfo() throws Exception{
		solo.clickOnText("项目撮合", 1, false);
		op.waitForPageFlush();
		op.takeScreenshot();
		solo.sleep(2000);
		ArrayList<ListView> listView=solo.getCurrentViews(ListView.class);
		solo.clickInList(0,0);
		solo.sleep(2000);
		op.takeScreenshot();
	}
	
	
	/**
	 * 项目撮合发布项目
	 */
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
	/**
	 * @deprecated
	 * 该方法目前存在问题，不使用该方法
	 */
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
		Log.d(Config.TAG, "获取id成功");
		solo.clickOnView(province);
		solo.sleep(1000);
		//om.dragViewTopToDown(province);
		solo.sleep(2000);
		//om.dragViewTopToDown(city);
		solo.sleep(2000);
		//om.dragViewTopToDown(town);
		solo.sleep(2000);
		op.clickById(PageIdName.Confirm);
	}
	/**
	 * 通用的方法：只要输入一个关键字编辑框的id名称，其他选择地区框，三个id都一样，都是province,month,month2
	 * 
	 * 专门用于商会帮的选择区域专用，所以方法是私有的
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
		Log.d(Config.TAG, "获取id成功");
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
	private void EnterchooseArea(String id,int index){
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
		Log.d(Config.TAG, "获取id成功");
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
	/**
	 * 选择行业
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
	/**
	 * 输入项目详情
	 */
	public void EnterProjectinfo(){
		EditText editText=(EditText)solo.getView(PageIdName.PublishPage_Projectinfo_id);
		solo.enterText(editText, "中国高铁");
	}
	/**
	 * 输入联系方式
	 */
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
	
	
	/**
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
	
	
	/**
	 * 商帮互助
	 */
	/*
	 * 发布互助
	 */
	public void createBunisessHelp() throws Exception{
		op.clickById("business_mainlist_item_new_consult");
		op.takeScreenshot();
	}
	

}
