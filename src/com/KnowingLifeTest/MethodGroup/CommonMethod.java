package com.KnowingLifeTest.MethodGroup;

import java.util.ArrayList;

import android.R.integer;
import android.R.layout;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.TextView;

import com.KnowingLifeTest.R.string;
import com.KnowingLifeTest.Config.CommonPageIdName;
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
	/**
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
	public void EnterchooseArea(String id,int index){
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
	
	

	/**
	 * 通讯录模块方法集合
	 */
	
	/*
	 * 进入到搜索站点页面
	 */
	
	
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
	
	
	
	/**
	 * @author liuliang
	 * @date 2015-02-10
	 * 发布页面共有的方法，输入名称，地区，详情，联系方式，添加图片
	 */
	
	
	
	
	
	
	/**
	 * 数字村谱相关的功能
	 */
	/*
	 * 村庄查找
	 */
	/**
	 * 选择组织，当站点数大于10个或者站点成员数大于20000时，会弹出选择组织页面
	 */
	public void ChooseSite() throws Exception{
		Activity activity=solo.getCurrentActivity();
		op.takeScreenshot();
		ArrayList<ExpandableListView> expandableListView_1st=solo.getCurrentViews(ExpandableListView.class);
		solo.clickInList(1);
		solo.waitForDialogToOpen();
		if(op.checkViewExitsInScreen("progress")!=-1){
			ProgressBar progressBar=(ProgressBar) solo.getView("progress");
			TextView textView=(TextView) solo.getView("progress_percen");
			String perString=textView.getText().toString();
			solo.waitForText("100%", 3, Config.timeout, false, true);
			op.takeScreenshot();
		}
		solo.clickInList(2);
		solo.sleep(1000);
		op.takeScreenshot();
		solo.clickInList(1);
		solo.sleep(1000);
		op.takeScreenshot();
		solo.clickInList(0);
		solo.waitForDialogToOpen();
		solo.clickOnText("详情");
		op.takeScreenshot();	
	}
	/*
	 * 组织查找
	 */
	/**
	 * 点击添加／查找组织，输入搜索词，点击立即搜索，得到搜索结果，判断搜索结果是否包含搜索词，
	 * 然后点击加入按钮，开始填写验证信息，点击提交申请，申请成功后，返回站点主页面
	 *搜索词-- "组织代码/名称/描述关键字"
	 */
	public void SearchSite_Name(String str) throws Exception{
		SearchSite_enterSearchName(str);
		solo.sleep(Config.less_timeout);
		if(JudgeSearchResultIsNotNull()){
			SearchResultCompare(str);
			solo.sleep(Config.less_timeout);
			ClickOnJoin();			
		}				
	}
	public void SearchSite_Region(String str) throws Exception{
		ClickOnAddOrSearchSite();
		SearchSite_enterSearchName(str);
		solo.sleep(Config.less_timeout);
		if(JudgeSearchResultIsNotNull()){
			SearchResultCompare(str);
			solo.sleep(Config.less_timeout);
			ClickOnJoin();			
		}				
	}
	/**
	 * 点击添加添加/创建组织，进入组织查找页
	 */
	public void ClickOnAddOrSearchSite(){
		clickonContacts();
		LinearLayout linearLayout=(LinearLayout) solo.getView("site_main_add_more");
		solo.clickOnView(linearLayout);
		solo.sleep(2000);
		solo.takeScreenshot();
	}
	/**
	 *可以输入文本查找（文本包括  组织代码、名称、描述关键字)
	 *点击立即搜索，进入组织搜索页
	 *
	 */
	public void SearchSite_enterSearchName(String str) throws Exception{
		/*clickonContacts();
		LinearLayout linearLayout=(LinearLayout) solo.getView("site_main_add_more");
		solo.clickOnView(linearLayout);
		solo.sleep(5000);
		solo.takeScreenshot();*/
		EditText editText=(EditText)solo.getView("et_site_finding_search");
		solo.enterText(editText, str);
		op.takeScreenshot();
		solo.sleep(1000);
		op.clickById("site_finding_search_btn");
		solo.waitForText("组织搜索", 3, Config.timeout, false, true);
		solo.sleep(1000);
		op.takeScreenshot();	
	}
	/**
	 * 通过高级搜索来查找搜索结果
	 */
	public void SearchSite_enterSearchRegion(String str) throws Exception{
		op.clickById(CommonPageIdName.CheckSeniorSearch_id);
		solo.sleep(Config.less_timeout);
		//op.clickById(PageIdName.RegionChoose, 2);
		EnterchooseArea(CommonPageIdName.RegionChoose, 2);
		solo.sleep(Config.less_timeout);

	}
	/**
	 * 判断搜索结果是否不为空
	 */
	public boolean JudgeSearchResultIsNotNull() throws Exception{
		if(op.checkViewExitsInScreen(CommonPageIdName.SearchIsNull_id)>0&&
				op.ReturnName(CommonPageIdName.SearchIsNull_id).endsWith(CommonPageIdName.SearchIsNull_str)){
			return false;
			
		}else{
			return true;
		}
	}
	/**
	 * 进入搜索结果页面，判断当前是否有搜索结果
	 * 同时对比站点名称、描述、组织代码、是否已加入
	 * 如果站点已加入，就不执行下一步操作了
	 * 如果未加入，就执行加入站点操作
	 * 
	 */
	public void SearchResultCompare(String sitename,String sitecode) throws Exception{
		Activity act1=solo.getCurrentActivity();
		solo.sleep(Config.timeout);
		ArrayList<ListView> listView=solo.getCurrentViews(ListView.class);
		for(int i=0;i<listView.size();i++){
			/*
			 * 站点名称，站点代码，站点状态--是否加入
			 */
			TextView siteNameText=(TextView) solo.getView("site_main_list_name_tv", i);
			String SiteNameString=siteNameText.getText().toString();
			TextView codetext=(TextView) solo.getView("site_main_list_item_fscode_tv", i);
			String codestrString=codetext.getText().toString();
			TextView JoinText=(TextView) solo.getView("site_main_list_item_hasjoin_tv", i);
			String JoinstrString=JoinText.getText().toString();
			boolean siteStatus;
			siteStatus=(JoinstrString.endsWith("已加入"));
			//搜索结果列表，如果站点名称包含搜索词，则认为True；或者搜索结果包含搜索词，则认为True
			if(SiteNameString.contains(sitename)||codestrString.contains(sitecode))
			{
				if(siteStatus){
					LogPrintDebug("该站点已加入");
				}
				else{
					op.takeScreenshot();
					op.clickById("site_main_list_item_hasjoin_tv", i);
					solo.sleep(Config.less_timeout);
					ClickOnJoin();
					break;
				}
			}
		}
	}
	public void SearchResultCompare(String sitename) throws Exception{
		Activity act1=solo.getCurrentActivity();
		solo.sleep(Config.timeout);
		ArrayList<ListView> listView=solo.getCurrentViews(ListView.class);
		for(int i=0;i<listView.size();i++){
			/*
			 * 站点名称，站点代码，站点状态--是否加入
			 */
			TextView siteNameText=(TextView) solo.getView("site_main_list_name_tv", i);
			String SiteNameString=siteNameText.getText().toString();
			TextView codetext=(TextView) solo.getView("site_main_list_item_fscode_tv", i);
			String codestrString=codetext.getText().toString();
			TextView JoinText=(TextView) solo.getView("site_main_list_item_hasjoin_tv", i);
			String JoinstrString=JoinText.getText().toString();
			boolean siteStatus;
			siteStatus=(JoinstrString.endsWith("已加入"));
			//搜索结果列表，如果站点名称包含搜索词，则认为True；或者搜索结果包含搜索词，则认为True
			if(SiteNameString.contains(sitename))
			{
				if(siteStatus){
					LogPrintDebug("该站点已加入");
				}
				else{
					op.takeScreenshot();
					op.clickById("site_main_list_item_hasjoin_tv", i);
					solo.sleep(Config.less_timeout);
					ClickOnJoin();
					break;
				}
			}
		}
	}
	/**
	 * 根据不同的搜索词来比对当前值
	 */
	public void getsiteCode() throws Exception{
	
	}
	/**
	 * 进入加入组织验证页面
	 * 检验当前的输入--是否姓名、手机号码、单位是否为空
	 * 输入验证信息后，点击提交申请
	 * 
	 */
	public void ClickOnJoin() throws Exception{
		Activity activity=solo.getCurrentActivity();
		op.checkViewExitsInScreen("join_site__title");
		solo.waitForText("加入组织验证", 3, Config.timeout, false, true);
		assertTrue("没有进入到加入组织验证页面", op.ReturnName("join_site__title").endsWith("加入组织验证"));
		if(op.checkViewExitsInScreen("join_site_et_name")>0){
			Verify_name_notnull();
		}
		if(op.checkViewExitsInScreen("join_site_et_mobile")>0){
			Verify_mobile_notnull();
		}
		if(op.checkViewExitsInScreen("join_site_et_company")>0){
			Verify_company_notnull();
		}
		assertTrue("没有提交申请按钮", op.checkViewExitsInScreen("site_join_postJoinSite_btn")>0);
		View joinbutton=solo.getView("site_join_postJoinSite_btn");
		solo.clickOnView(joinbutton, false);
		assertTrue("弹出提示框成功", solo.waitForDialogToOpen());
		solo.sleep(Config.less_timeout);
		assertTrue(solo.searchText(CommonPageIdName.Dialog_content,6,false, true));
		assertTrue(CommonPageIdName.BackFresh_String.equals("返回刷新"));
		op.clickById("btOK");		
	}
	/**
	 * 加入组织验证页面，如果姓名、单位、手机号码为空时，输入默认的姓名、手机号码、单位名称
	 */
	public void Verify_name_notnull(){		
			EditText name_edit=(EditText) solo.getView("join_site_et_name");
			if(name_edit.getText().toString().equals(null)){
				solo.enterText(name_edit, "李像");
			}
	}
	public void Verify_mobile_notnull(){		
		EditText mobile_edit=(EditText) solo.getView("join_site_et_mobile");
		if(mobile_edit.getText().toString().equals(null)){
			solo.enterText(mobile_edit, "13067905358");
		}
	}
	public void Verify_company_notnull(){		
		EditText company_edit=(EditText) solo.getView("join_site_et_company");
		if(company_edit.getText().toString().equals(null)){
			solo.enterText(company_edit, "思言技术");
		}		
	}
	
	/**
	 * @创建站点
	 * step1:点击组织查找页面的-->点击申请创建，进入创建组织页面
	 * 
	 * 组织名称(必选)---提示语--组织名称不能为空、组织名称必须在2-10字范围内
	 * 最简洁模式--依次输入组织名称、所在位置、联系人、手机号,点击创建组织，开始申请组织
	 * 
	 */
	public void CreateSite_simple(){
		ClickOnAddOrSearchSite();
		ClickOnCreateText();
		op.LogPrintDebug("站点验证成功");
		/*
		 * 该方法当前有问题，需要修改下
		EnterSiteInfo(CommonPageIdName.site_create_site_name,CommonPageIdName.site_name_edit_title,Config.site_name,CommonPageIdName.site_create_tv_set_sitename);		
		EnterSiteInfo(CommonPageIdName.site_create_site_mobile ,CommonPageIdName.site_name_edit_title, Config.site_mobile,CommonPageIdName.site_create_tv_set_mobile);
		EnterSiteInfo(CommonPageIdName.site_create_site_contact ,CommonPageIdName.site_name_edit_title, Config.site_contact_name,CommonPageIdName.site_create_tv_set_contact);
		*/
		EnterSiteInfo(CommonPageIdName.site_create_site_name,Config.site_name,CommonPageIdName.site_create_tv_set_sitename);		
		EnterSiteInfo(CommonPageIdName.site_create_site_mobile , Config.site_mobile,CommonPageIdName.site_create_tv_set_mobile);
		EnterSiteInfo(CommonPageIdName.site_create_site_contact ,Config.site_contact_name,CommonPageIdName.site_create_tv_set_contact);
		op.clickById(CommonPageIdName.site_create_btn);		
		solo.waitForDialogToClose(Config.timeout);
		//assertTrue("没有弹出操作提示", ReturnSonTextViewName(CommonPageIdName.operate_tag_id, 0).contains(CommonPageIdName.operate_tag_str));
		//assertTrue("没有弹出操作提示", op.ReturnName(CommonPageIdName.operate_tag_id).contains(CommonPageIdName.operate_tag_str));
		solo.sleep(Config.less_timeout);
		op.clickById(CommonPageIdName.operate_complete);
		op.waitForPageFlush();				
	}
	
	/**
	 * @创建站点
	 * step1:点击组织查找页面的-->点击申请创建，进入创建组织页面
	 * step2：依次输入组织头像(默认不填写)、组织名称、所属行业、组织描述、所在位置、联系人、手机号码
	 * step3:点击开始创建组织，弹出提示"申请成功"
	 * 
	 */
	
	/**
	 * 输入信息
	 */
	/**
	 * 通过id和默认的文字进行对比，来输入组织信息
	 * 比如组织名称--首先判断组织信息项--组织名称是否正确
	 * compare(message，auctal,except）--将id对应的文字与预置的文字对比，看是否一致
	 * 第一个参数为layout的控件id，第2个参数为编辑文字时对应的提示框标题，第3个参数为输入的文字，第4个参数为待填写项的默认文字对应的id
	 * 如果第4个参数的文字为默认参数，则输入预设置的文字，否则不输入文字
	 */
	public void EnterSiteInfo(String Layout_id,String content_title,String enter_text,String id)
	{	
		String infoIsNullString=op.ReturnName(id);
		String except=ReturnSonTextViewName(Layout_id,0);
		String actual;
		op.LogPrintDebug(infoIsNullString+"      "+except);
		if(op.isHave(Config.Createsiteinfo, infoIsNullString))
		{
			
			op.clickById(Layout_id);
			solo.sleep(2000);
			/**
			 * DEBUG
			 */
			Activity activity=solo.getCurrentActivity();
			assertTrue("没有找到该id",op.checkViewExitsInScreen(content_title)>0);
			
			actual=ReturnSonTextViewName(content_title,0);
			op.LogPrintDebug("目标为空"+actual);
			assertTrue("弹出组织名称输入框失败", CompareTextIsSame(except, actual));
			enterString(enter_text);
			solo.sleep(1000);			
		}else{
			
		}		
	}
	/**
	 * 输入站点信息，
	 * 判断当前输入框是否为空，如果为空，则输入文字，否则不输入
	 * 第一个参数为layout的控件id，第2个参数为输入的文字，第3个参数为待填写项的默认文字对应的id
	 * @param Layout_id
	 * @param enter_text
	 * @param id
	 */
	public void EnterSiteInfo(String Layout_id,String enter_text,String id)
	{	
		String infoIsNullString=op.ReturnName(id);
		if(op.isHave(Config.Createsiteinfo, infoIsNullString))
		{
			
			op.clickById(Layout_id);
			solo.sleep(2000);
			/**
			 * DEBUG
			 */
			Activity activity=solo.getCurrentActivity();
			enterString(enter_text);
			solo.sleep(1000);			
		}else{
			
		}		
	}
	/**
	 * 
	 * @param view
	 * @param id
	 * @param content
	 */
	public void EnterSiteName(View view,String id,String content)
	{
		op.clickById(CommonPageIdName.site_create_tv_set_sitename);
		assertTrue("弹出组织名称输入框失败", CompareTextIsSame(CommonPageIdName.site_create_site_name, CommonPageIdName.site_name_edit_title));
		enterString(content);
		//entersitename();		
	}
	/**
	 * 针对组织名称、联系人、手机号码的输入
	 * @param name
	 */
	public void enterString(String name){		
		solo.enterText(0, name);	
		solo.sleep(Config.less_timeout);
		op.clickById(CommonPageIdName.btn_sure_id);
	}
	/**
	 * 对比文字是否一致，boolean类型
	 * 第一个参数代表
	 */
	public boolean CompareTextIsSame(String id,String except){
		String actual;
		boolean result;
		actual=op.ReturnName(id);
		if(actual.equals(null)){
			op.LogPrintDebug("该控件的id返回的文字为空");
			return false;
		}else{
		result=actual.equals(except);		
		return result;
		}
	}
	/**
	 * 方法--有3个参数，第一个参数--view（一般是layout）,第2个参数是想查找的控件类别（eg:TextView）,第三个是控件的index
	 */
	public String ReturnSonTextViewName(String layout_id,int index){
		
		String Layout_str=null;
		View view1;
		View view=op.ReturnViewFromID(layout_id);
		//ArrayList<View> viewList = new ArrayList<View>();
		if(view != null) {				
			ViewGroup viewGroup= (ViewGroup) view;			
			for(int i=0;i< viewGroup.getChildCount();i++) {
				Log.d(Config.TAG,String.valueOf(viewGroup.getChildCount()));
				if(i==index){
					final View child=viewGroup.getChildAt(i);
					view1=child;
					Layout_str=op.ReturnNameFromView(view1);
					break;
				}
			}
		}
		return Layout_str;
     }
	/*
	 * 错误的方法
	 
	public String ReturnSonTextViewName(String layout_id){
					
		String Layout_str=null;
		View view1;
		View view=op.ReturnViewFromID(layout_id);
		TextView textvView;
		ArrayList<View> viewList = new ArrayList<View>();
		if(view != null) {				
			ViewGroup viewGroup= (ViewGroup) view;			
			for(int i=0;i< viewGroup.getChildCount();i++) {
				Log.d(TAG,String.valueOf(viewGroup.getChildCount()));
				
				final View child=viewGroup.getChildAt(i);
				if(child.equals(TextView)){
					view1=child;
					Layout_str=op.ReturnNameFromView(view1);
					break;
					
				}
			}
		}
		return Layout_str;
	}*/
	/**
	 * 点击--点击申请创建 按钮
	 */
	public void ClickOnCreateText(){
		op.clickById(CommonPageIdName.AddSite_ID);
		solo.sleep(Config.less_timeout);
	}
	
	
    /**
     * 进入组织搜索页面（搜索结果），判断当前页面是否有搜索结果
     * @param str
     * @throws Exception
     */
	

		//assertTrue("返回到通讯录主页成功", solo.waitForActivity("com.android.KnowingLife/.component.ContactGroup.JoinSiteActivity"));
	
	/**
	 * 打印出调试日志
	 */
	private void LogPrintDebug(String str){
		Log.d(Config.TAG, str);
	}
	private void LogPrintError(String str){
		Log.e(Config.Error_TAG, str);
	}
	
	/**
	 * 切换模块名称
	 */
	public void FindTabHost() throws Exception{
	Activity act=solo.getCurrentActivity();
	String id="tabs";
			//"tabhost";
	assertTrue(Config.TAG, op.checkViewExitsInScreen(id)>0);
	int id1 = act.getResources().getIdentifier(id, "id",
			solo.getCurrentActivity().getPackageName());
	TabHost tabHost=(TabHost) act.findViewById(id1);
	int TabHostXY[]=new int[2];
	tabHost.getLocationOnScreen(TabHostXY);
	int tabhost_width=TabHostXY[0];
	int tabhost_heigth=TabHostXY[1];
	Log.d(Config.TAG, String.valueOf(tabhost_heigth)+"："+String.valueOf(tabhost_width));
	}
}