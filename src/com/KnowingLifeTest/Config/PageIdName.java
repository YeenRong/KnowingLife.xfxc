package com.KnowingLifeTest.Config;


public class PageIdName {
	
	/**
	 * 不同产品线的，不同模块的id
	 */
	
	
	/**
	 * 商会帮主页
	 */
    //商会帮主页标题
	public static final String SHB_HOME_Title="main_fragement_app_findorba_title_text";
	public static final String XFXC_HOME_Title="main_fragement_app_findorbusiness_title_text";
	
	/**
	 * 项目撮合
	 */
	/*
	 * 项目撮合首页
	 * 
	 * 项目管理--button
	 * 排序－－textview
	 * 发布项目－－button
	 * 全部项目－－textview
	 * 企业招商－－textview
	 * 政府招商－－textview
	 * 推荐项目－－textview
	 * 
	 */
	
	public static final String ProjectManager_id="project_manager";
	public static final String ProjectMangger_string="项目管理";
	public static final String Sort_id="project_matching_sort_menu";
	public static final String Sort_string="排序";
	public static final String Publish_id="publish_project";
	public static final String PUBLISH_STRING="发布项目";
	public static final String All_Project_id="main_fragment_all_project";
	public static final String All_Project_string="全部项目";
	public static final String Business_investment_id="main_fragment_qiye_project";
	public static final String Business_investment_string="企业招商";
	public static final String Government_investment_id="main_fragment_zhengfu_project";
	public static final String Government_investment_string="政府招商";
	public static final String Recommended_Project_id="main_fragment_tuijian_project";
	public static final String Recommended_Project_string="推荐项目";
	
	/*
	 * 项目列表的元素
	 * 
	 * 项目撮合－－标题－－main_fragement_app_findorbusiness_title_text－－textview
	 * 返回按钮--project_matching_back--imagebutton
	 * 项目标题--project_matching_title--textview
	 * 企业还是政府--project_matching_icon--imageview
	 * 地区--project_matching_ReRName--textview
	 * 发布时间--project_matching_PubTime--textview
	 * 关注数--project_matching_AttentionCount--textview
	 * 没有更多数据--xlistview_footer_hint_textview
	 */	
	public static final String Project_title_id="main_fragement_app_findorbusiness_title_text";
	public static final String Project_back="project_matching_back";
	
	/*
	 * 发布项目页面-
	 * 
	 * 返回按钮-publish_project_back
	 * 发布项目标题--publish_project_title--textview
	 * 返回按钮－－publish_project_back－－imagebutton
	 * 项目名称--project_publish_FTitle--请输入项目名称，必填项--edittext
	 * 投资金额--project_publish_FMoney--请输入投资金额，必填项
	 * 选择区域--project_publish_FRID--edittext--请选择区域，必填项
	 * 地区－－省市县--view
	 * 选择行业--project_publish_FDDID--请选择行业，必填项--edittext
	 * 
	 * 项目类型--
	 * 企业招商－－project_publish_FType_QiYe_RB－－android.widget.RadioButton；；
	 * 政府招商－－project_publish_FType_ZF_RB－－android.widget.RadioButton
	 * 
	 */

	public static final String Publish_title_id="publish_project_title";
	public static final String PublishPage_back="publish_project_back";
	public static final String PublishPage_ProjectName_id="project_publish_FTitle";
	public static final String PublishPage_ProjectName_string="请输入项目名称，必填项";
	public static final String PublishPage_spendMoney_id="project_publish_FMoney";
	public static final String PublishPage_spendMoney_string="请输入投资金额，必填项";
	public static final String PublishPage_chooseArea_id="project_publish_FRID";
	public static final String PublishPage_chooseArea_string="请选择区域，必填项";
	public static final String PublishPage_Area_province_id="province";
	public static final String PublishPage_Area_city_id="month";
	public static final String PublishPage_Area_town_id="month2";
	public static final String Confirm="btOK";
	public static final String PublishPage_chooseIndustry_id="project_publish_FDDID";
	public static final String PublishPage_chooseIndustry_string="请选择行业，必填项";
	/*
	 * 项目类型--
	 * 企业招商－－project_publish_FType_QiYe_RB－－android.widget.RadioButton；；
	 * 政府招商－－project_publish_FType_ZF_RB－－android.widget.RadioButton
	 */
	public static final String PublishPage_Ftype_qiye_id="project_publish_FType_QiYe_RB";
	public static final String PublishPage_Ftype_qiye_string="企业招商";
	public static final String PublishPage_Ftype_goverment_id="project_publish_FType_QiYe_RB";
	public static final String PublishPage_Ftype_goverment_string="企业招商";	
	
	/*
	 * 有效期－－
	 * 一个月－－index－－0-－project_publish_FValidTime_YiGeYue_RB－－android.widget.RadioButton
	 * 三个月--index--1－－project_publish_FValidTime_SanGeYue_RB－－android.widget.RadioButton
	 * 半年--index－－2--project_publish_FValidTime_BanNian_RB－－android.widget.RadioButton
	 */
	public static final String PublishPage_FValidTime_onemonth_id="project_publish_FValidTime_YiGeYue_RB";
	public static final String PublishPage_FValidTime_onemonth_string="一个月";
	public static final String PublishPage_FValidTime_threemonth_string_id="project_publish_FValidTime_SanGeYue_RB";
	public static final String PublishPage_FValidTime_threemonth_string="三个月";
	public static final String PublishPage_FValidTime_sixmonth_string_id="project_publish_FValidTime_BanNian_RB";
	public static final String PublishPage_FValidTime_sixmonth_string="半年";
	
	/*
	 * 项目详情---project_publish_FContent--请输入项目详情，必填项--index--6--android.widget.EditText
	 */
	public static final String PublishPage_Projectinfo_id="project_publish_FContent";
	public static final String PublishPage_Projectinfo_string="请输入项目详情，必填项";
	
	/*
	 * 联系方式--project_publish_FContact--请输入联系方式，必填项--index－－7-－android.widget.EditText
	 */
	public static final String PublishPage_Fcontact_id="project_publish_FContact";
	public static final String PublishPage_Fcontact_string="请输入联系方式，必填项";	
	/*
	 * 添加图片按钮--b:id/item_grida_image－－上一层是gridview
	 */
	
	/*
	 * 存为草稿--project_publish_save_caogao_Btn--android.widget.Button
	 */
	public static final String PublishPage_savecaogao_id="project_publish_save_caogao_Btn";
	public static final String PublishPage_savecaogao_string="存为草稿";
	/*
	 *发布项目--project_publish_Btn --android.widget.Button
	 */
	public static final String PublishPage_publish_id="project_publish_Btn";
	public static final String PublishPage_publish_string="发布项目";
	/*
	 * 提示框－－
	 * 标题－－提示－－title－－TextView
	 * 内容－－你还没有完成，确认要退出么－－content－－textview
	 * 取消按钮－－取消－－btCancel－－button
	 * 确定按钮－－确定－－/btOK－－button
	 */
	
	/*
	 * 项目管理页面
	 * 
	 * 返回按钮--project_manager_back--imagebutton
	 * 标题－－我的项目－－project_manager_my--textview
	 * 我的关注--project_manager_concerned--textview
	 * 发布项目－－按钮--/project_manager_publish--android.widget.Button
	 * 项目标题--my_project_list_item_title－－android.widget.TextView
	 * 项目状态－－my_project_list_item_Status－－android.widget.TextView
	 * 项目发布日期--android.widget.TextView
	 * 项目操作菜单－－my_project_list_item_menu－－android.widget.ImageView
	 * 没有更多数据--xlistview_footer_hint_textview--twxtview
	 * 
	 */		
	public static final String ProjectManger_back="project_manager_back";
	public static final String Project_My_id="project_manager_my";
	public static final String Project_My_string="我的项目";
	public static final String Concerned_My_id="project_manager_concerned";
	public static final String Concerned_My_string="我的关注";
	public static final String ProjectManager_Publish_id="project_manager_publish";
	public static final String ProjectManager_Publish_string="发布项目";
	public static final String Project_title="my_project_list_item_title";
	public static final String Project_status_id="my_project_list_item_Status";
	public static final String Project_status_publish="发布";
	public static final String Project_publish_time="my_project_list_item_PubTime";
	public static final String Project_menu="my_project_list_item_menu";
	public static final String NotMoreInfo_id="xlistview_footer_hint_textview";
	public static final String NotMoreInfo_string="没有更多数据";
	
	/*
	 * menu菜单--com.android.KnowingLife.shb:id/my_project_list_item_menu--android.widget.ImageView
	 * 暂停－－com.android.KnowingLife.shb:id/manager_list_item_pause－－android.widget.ImageView
	 * 修改--com.android.KnowingLife.shb:id/manager_list_item_modify--android.widget.ImageView
	 * 删除－－com.android.KnowingLife.shb:id/manager_list_item_delete
	 * 发布--com.android.KnowingLife.shb:id/manager_list_item_pause－－android.widget.ImageView--位置一样
	 */
	public static final String status_menu="my_project_list_item_menu";
	public static final String status_Pause_id="manager_list_item_pause";
	public static final String status_Pause_string="暂停";
	public static final String status_modify_id="manager_list_item_modify";
	public static final String status_modify_string="修改";
	public static final String status_delete_id="manager_list_item_delete";
	public static final String status_delete_string="删除";
	/*
	 * 删除保护提示框--标题，内容，确定，取消
	 */
	public static final String Dialog_delete_title_id="title";
	public static final String Dialog_delete_title_string="提示";
	public static final String Dialog_content_id="content";
	public static final String Dialog_content_string="确认删除？！";
	public static final String Delete_success="项目已删除";
	
	/*
	 * 项目详情页面－－webview
	 */
	/*
	//上面按钮


	//返回－－project_detail_back－－android.widget.ImageButton－－index－－0
	//标题－－
	//更多菜单－－project_detail_menu－－android.widget.ImageView
	
	
	//下侧按钮
	//返回－－/projectdetail_tool_bar_back－－android.widget.ImageView－－index--0
	//评论--projectdetail_tool_bar_comment－－android.widget.ImageView－－index--1
	//评论列表--projectdetail_tool_bar_go_comment－－android.widget.ImageView－－index--2
	//关注－－d/projectdetail_tool_bar_mark－－android.widget.ImageView－－index--3
	//更多菜单--/projectdetail_tool_bar_more－－android.widget.ImageView－－index--4
	 * 
	 */
	
	
	
	
	/***
	 * 数字村谱主页的id及文字
	 */
	/*
	 * 数字村谱模块标题
	 */
	public static final String Digital_Village_id="site_title";
    public static final String Digital_Village_STRING="数字村谱";
    public String bangdingVillage_id="xfxc_addfsecod";
    public String bangdingVillage_string="绑定村庄";
    public String myvillage_id="tv_title";
    public String myvillage_str="我的村谱";
    public String PU="site_main_list_item_image_iv";
  
 
}

