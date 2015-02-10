package com.KnowingLifeTest.Config;

import android.R.string;

public class PageIdName {
	/*
	 * 公共的提示语句
	 */
	public static final String GetFaild="获取失败";
	/**
	 * 网络状态
	 */
	//无网络的提示
	public static final String BadNetwork="无网络信息，请检查你的网络";
	//无网络的贴图--com.android.KnowingLife.shb:id/errorIV－－网络环境较差，请重新加载
	//public String 
	/*
	 * 主页
	 */
	//底部的模块切换--tabtext
	public static final String TabText="tabText";
	
	/*
	 * 登陆页面
	 */
	//忘记密码?---textview
	public static final String Forgetpasswd_id="main_fragment_app_center_login_tv_forget_password";
	public static final String Forgetpasswd_string="忘记密码？";
	//登陆按钮--button
	public static final String LoginInButton_id="main_fragment_app_center_login_btn_submit";
	public static final String LoginInButton_string="登陆";
	//新用户注册--textview
	public static final String NewUserRegister_id="main_fragment_app_center_login_tv_register";
	public static final String NewUserRegister_string="新用户注册";
	//输入框－－手机/用户名--edittext
	public static final String UserName_id="main_fragment_app_center_edt_login_username";
	//输入框－－密码---edittext
	public static final String Password_id="main_fragment_app_center_edt_login_password";
	//随便看看－－textview
	public static final String HaveALook_id="main_fragment_app_center_login_tv_have_a_look";
	public static final String HaveALook_string="随便看看";
	//图标－－logo
	
	
	
	/*
	 * 商会帮主页
	 */
    //商会帮主页标题
	public static final String SHB_HOME_Title="main_fragement_app_findorba_title_text";
	public static final String XFXC_HOME_Title="main_fragement_app_findorbusiness_title_text";

	/*public static final String
	public static final String
	public static final String
	*/
	
	/*
	 * 项目撮合
	 */
	//项目管理--button
	public static final String ProjectManager_id="project_manager";
	public static final String ProjectMangger_string="项目管理";
	//排序－－textview
	public static final String Sort_id="project_matching_sort_menu";
	public static final String Sort_string="排序";
	//发布项目－－button
	public static final String Publish_id="publish_project";
	public static final String PUBLISH_STRING="发布项目";
	//全部项目－－textview
	public static final String All_Project_id="main_fragment_all_project";
	public static final String All_Project_string="全部项目";
	//企业招商－－textview
	public static final String Business_investment_id="main_fragment_qiye_project";
	public static final String Business_investment_string="企业招商";
	//政府招商－－textview
	public static final String Government_investment_id="main_fragment_zhengfu_project";
	public static final String Government_investment_string="政府招商";
	//推荐项目－－textview
	public static final String Recommended_Project_id="main_fragment_tuijian_project";
	public static final String Recommended_Project_string="推荐项目";
	/*
	 * 项目列表的元素
	 */
	//项目撮合－－标题－－main_fragement_app_findorbusiness_title_text－－textview
	public static final String Project_title_id="main_fragement_app_findorbusiness_title_text";
	//返回按钮--project_matching_back--imagebutton
	public static final String Project_back="project_matching_back";
	//项目标题--project_matching_title--textview
	
	//企业还是政府--project_matching_icon--imageview
	
	//地区--project_matching_ReRName--textview
	
	//发布时间--project_matching_PubTime--textview
	
	//关注数--project_matching_AttentionCount--textview
	
	//没有更多数据--xlistview_footer_hint_textview
	/**
	 * 发布项目页面--publish_project_back
	 */
	//发布项目标题--publish_project_title--textview
	public static final String Publish_title_id="publish_project_title";
	//返回按钮－－publish_project_back－－imagebutton
	public static final String PublishPage_back="publish_project_back";
	//项目名称--project_publish_FTitle--请输入项目名称，必填项--edittext
	public static final String PublishPage_ProjectName_id="project_publish_FTitle";
	public static final String PublishPage_ProjectName_string="请输入项目名称，必填项";
	//投资金额--project_publish_FMoney--请输入投资金额，必填项
	public static final String PublishPage_spendMoney_id="project_publish_FMoney";
	public static final String PublishPage_spendMoney_string="请输入投资金额，必填项";
	//选择区域--project_publish_FRID--edittext--请选择区域，必填项
	//地区－－省市县--view
	public static final String PublishPage_chooseArea_id="project_publish_FRID";
	public static final String PublishPage_chooseArea_string="请选择区域，必填项";
	public static final String PublishPage_Area_province_id="province";
	public static final String PublishPage_Area_city_id="month";
	public static final String PublishPage_Area_town_id="month2";
	public static final String Confirm="btOK";
	//选择行业--project_publish_FDDID--请选择行业，必填项--edittext
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
	
	/**
	 * 项目管理页面
	 */
	//返回按钮--project_manager_back--imagebutton
	public static final String ProjectManger_back="project_manager_back";
	//标题－－我的项目－－project_manager_my--textview
	public static final String Project_My_id="project_manager_my";
	public static final String Project_My_string="我的项目";
	//我的关注--project_manager_concerned--textview
	public static final String Concerned_My_id="project_manager_concerned";
	public static final String Concerned_My_string="我的关注";
	//发布项目－－按钮--/project_manager_publish--android.widget.Button
	public static final String ProjectManager_Publish_id="project_manager_publish";
	public static final String ProjectManager_Publish_string="发布项目";
	//项目标题--my_project_list_item_title－－android.widget.TextView
	public static final String Project_title="my_project_list_item_title";
	//项目状态－－my_project_list_item_Status－－android.widget.TextView
	public static final String Project_status_id="my_project_list_item_Status";
	public static final String Project_status_publish="发布";
	//项目发布日期--android.widget.TextView
	public static final String Project_publish_time="my_project_list_item_PubTime";
	//项目操作菜单－－my_project_list_item_menu－－android.widget.ImageView
	public static final String Project_menu="my_project_list_item_menu";
	//没有更多数据--xlistview_footer_hint_textview--twxtview
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
	/**
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
    /*
     * 组织查找页面
     */
    public static final String CheckSeniorSearch_id="site_finding_expand_ll";
    public static final String CheckSeniorSearch_str="查看高级搜索";
    public static final String RegionChoose="site_finding_area_ll";
    //区域--index--2，行业--index--3
    //site_finding_trade_ll
    public static final String Textview_5="温馨提示：";
    public static final String Textview_6="没有找到您想要的组织？可点击“查看高级搜索”按区域或行业来查找。";
    public static final String Textview_0="你还可以创建你自己的通讯录，";
    public static final String AddSite_ID="site_finding_site_create_tv";
    public static final String AddSite_str="点击申请创建";
    /*
     * 搜索结果页面
     */
    public static final String SearchIsNull_id="tv_nodata_or_err";
    public static final String SearchIsNull_str="没有相应的搜索结果，请更换搜索条件再试试。";
    /*
     * 加入组织验证页面
     */
    public static final String Dialog_content="申请提交成功！返回组织列表。";
    public static final String BackFresh_id="btOK";
    public static final String BackFresh_String="返回刷新";
    
    /**
     * 更多页面的id及文字
     */
    public static final String LoginIn_id="main_fragement_app_center_roundimage_user_image";    
    public static final String LoginIn_str="立即登陆";
    /*
     * 随便看看，登陆保护
     * 弹出提示框--登陆后才能使用该功能,请登陆--取消、确定
     */
    public static final String LoginOnDialog_content_id="content";
    public static final String LoginOnDialog_content="登录后才能使用该功能，请登陆";
    public static final String btCancel_id="btCancel";
    public static final String btCancel_str="取消";
    public static final String btOK_id="btOK";
    public static final String btOK_str="确定";
    /*
     * 更多--头像(ImageView)，昵称(TextView)、
     */
    public static final String PersonHeadicon="main_fragement_app_center_roundimage_user_image";
    public static final String Personusername="main_fragement_app_center_tv_user_name";
    /*
     * 个人中心--返回按钮(ImageView),我的头像、用户名、绑定手机、姓名、性别、区域、单位、我的等级、我的金币、今日任务、修改密码、退出登陆
     */
    public static final String PersonInfo_Back="main_fragement_app_user_center_back";
    public static final String PersonInfo_Title_str="个人中心";
    public static final String PersonInfo_Headicon_layout="user_center_my_photo";
    public static final String PersonInfo_Headicon="user_center_photo";		
    public static final String PersonInfo_Username_layout="user_center_ll_user_name";	
    public static final String PersonInfo_Username="user_center_tv_user_name";	
    public static final String PersonInfo_FPhone_layout="user_center_ll_bind_phone_number";	
    public static final String PersonInfo_FPhone="user_center_tv_bind_phone_number";	
    public static final String PersonInfo_FName_layout="user_center_ll_true_name";	
    public static final String PersonInfo_FName="user_center_tv_true_name";	
    public static final String PersonInfo_FSex_layout="user_center_ll_gender";  
    public static final String PersonInfo_FSex="user_center_tv_gender";  
    public static final String PersonInfo_FRegion_layout="user_center_ll_area";    
    public static final String PersonInfo_FRegion="user_center_tv_area";   
    public static final String PersonInfo_FCompany_layout="user_center_ll_company";   
    public static final String PersonInfo_FCompany="user_center_tv_company";  
    public static final String PersonInfo_MyLevel_layout="user_center_ll_my_grade";  
    public static final String PersonInfo_MyLevel="main_fragment_app_center_my_grade";	
    public static final String PersonInfo_MyCoin_layout="user_center_coin";	
    public static final String PersonInfo_MyCoin="main_fragment_app_center_my_coin";	
    public static final String PersonInfo_MyScore_layout="user_center_ll_my_integral";	
    public static final String PersonInfo_MyScore="main_fragment_app_center_my_integral";	
    public static final String PersonInfo_TodayTask_layout="user_center_ll_task";	
    //public static final String PersonInfo_TodayTask="";	
    //public static final String PersonInfo_ChangePasswd_layout="";	
    public static final String PersonInfo_ChangePasswd="tv_modifypassword";	
    public static final String PersonInfo_LoginOut="main_fragment_app_center_log_out";
    /*
     * 个人中心--名称及修改项
     */
    public static final String PersonInfo_Headicon_str="我的头像";
    public static final String PersonInfo_Username_str="我的用户名";	
    public static final String PersonInfo_FPhone_str="绑定手机";	
    public static final String PersonInfo_FName_str="姓名";	
    public static final String PersonInfo_FSex_str="性别";  
    public static final String PersonInfo_FRegion_str="区域";   
    public static final String PersonInfo_FCompany_str="单位";  
    public static final String PersonInfo_MyLevel_str="我的等级";	
    public static final String PersonInfo_MyCoin_str="我的金币";	
    public static final String PersonInfo_MyScore_str="我的积分";	
    public static final String PersonInfo_TodayTask="今日任务";	
    public static final String PersonInfo_ChangePasswd_str="修改密码";	
    public static final String PersonInfo_LoginOut_str="退出登陆";
    
    public static final String ChoosePhote_way_Photo="拍照";
    public static final String ChoosePhote_way_PhotoAlbum="从相册中获取";
    public static final String ChoosePhote_way_Cachel="取消";
    
    /*
     * 更多页面--主页
     */
    public static final String JoinSiteCheck_ImageView="widget_word_image_button_iv_image";
    public static final String JoinSiteCheck_id="widget_word_image_button_tv_word";
    public static final String JoinSiteCheck_str="入站审核";
    public static final String MyMedia="我的智媒体";   
    public static final String ContactFav="收藏联系人";
    public static final String ContactCover="通讯录备份";
    public static final String InterstIcon="兴趣标签";  
    public static final String PaiHangBang="排行榜";
    public static final String Share="分享";
    public static final String More="更多";
    public static final String Page_Title="智慧乡村";
    public static final String Setting="main_fragement_app_center_btn_title_bar_setting";
    
    /*
     * 我的消息，特别感谢
     */
    public static final String MyMessage_layout="main_fragement_app_center_rl_my_message";
    public static final String MyMessage_icon="main_fragement_app_center_img_my_message_icon";
    public static final String MyMessage_Name="main_fragement_app_center_tv_my_messag";
    public static final String MyMessage_count="main_fragment_app_center_tv_my_message_count";
    public static final String MyMessage_title="main_fragement_app_centert_tv_my_message_last";

}
