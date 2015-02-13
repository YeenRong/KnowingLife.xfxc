package com.KnowingLifeTest.Config;

public class CommonPageIdName {
	/*
	 * 公共方法的的提示语句
	 */
	public static final String GetFaild="获取失败";
	/**
	 * @category网络状态
	 * 无网络的提示
	 * 无网络的贴图--com.android.KnowingLife.shb:id/errorIV－－网络环境较差，请重新加载
	 */
	public static final String BadNetwork="无网络信息，请检查你的网络";
	
	/**
	 * 主页
	 * 底部的模块切换--tabtext
	 */
	public static final String TabText="tabText";
	
	/**
	 * 登陆页面
	 * 忘记密码?---textview,登陆按钮--button,新用户注册--textview,输入框－－手机/用户名--edittext
	 * 输入框－－密码---edittext,随便看看－－textview,图标－－logo
	 */
	public static final String Forgetpasswd_id="main_fragment_app_center_login_tv_forget_password";
	public static final String Forgetpasswd_string="忘记密码？";
	public static final String LoginInButton_id="main_fragment_app_center_login_btn_submit";
	public static final String LoginInButton_string="登陆";
	public static final String NewUserRegister_id="main_fragment_app_center_login_tv_register";
	public static final String NewUserRegister_string="新用户注册";
	public static final String UserName_id="main_fragment_app_center_edt_login_username";
	public static final String Password_id="main_fragment_app_center_edt_login_password";
	public static final String HaveALook_id="main_fragment_app_center_login_tv_have_a_look";
	public static final String HaveALook_string="随便看看";
	
	/*
	 *登陆保护提示框
	 *
	 *标题--layout--dialog_normal_title--android.widget.LinearLayout
	 * 标题--提示--title--textview--index--0
	 * 登录后才能使用该功能，请登录!-- content-textview--index--1
	 * btCancel--取消--android.widget.Button
	 * btOK--登陆----android.widget.Button
	 */
	public static final String Dialog_Login_title_layout="dialog_normal_title";
	public static final String Dialog_Login_title_id="title";
	public static final String Dialog_Login_title_str="提示";
	public static final String Dialog_Login_content_id="content";
	public static final String Dialog_Login_content_str="登录后才能使用该功能，请登录!";
	public static final String Dialog_Login_btCancel_str="取消";
	public static final String Dialog_Login_btOK_str="登录";
	public static final String Dialog_Login_btCancel_id="btCancel";
	public static final String Dialog_Login_btOK_id="btOK";
	
	/**
	 * @category 通讯录
	 * 数字村谱主页的id及文字
	 */

	/*
	 * 数字村谱模块标题
	 * 
	 * 模块标题--数字村谱--site_title--TextView
	 * 我的村谱+我的组织+推荐组织组成的列表--list--ExpandableListView
	 * 每个分类的标题--tv_title--TextView
	 * 绑定村庄--xfxc_addfsecod--LinearLayout
	 *   绑定村庄--TextView--index--1
	 * 
	 * 搜索联系人--layout--site_main_search--LinearLayout
	 *   搜索图标--site_main_iv_search--ImageView
	 *   搜索文字（水印)--搜索联系人--site_main_tv_search--TextView
	 * 本地通讯录--site_main_local_contact_slideview--LinearLayout--最上层的layout
	 *   本地通讯录--view_content--LinearLayout--第2层的layout
	 *   头像--site_main_local_iv_icon--ImageView
	 *   文字--本地通讯录--TextView
	 * 收藏联系人--site_main_local_contact_slideview2--LinearLayout
	 *   文字--收藏联系人--TextView--index-1
	 */
	public static final String Digital_Village_id="site_title";
    public static final String Digital_Village_STRING="数字村谱";
    public static final String BindVillage_id="xfxc_addfsecod";
    public static final String BindVillage_string="绑定村庄";
    public static final String myvillage_id="tv_title";
    public static final String myvillage_str="我的村谱";
    
    public static final String SearchContact_layout_id="site_main_search";
    public static final String SearchContact_headicon="site_main_iv_search";
    public static final String SearchContact_id="site_main_tv_search";
    public static final String SearchContact_str="搜索联系人";
    public static final String LocalContact_layout="view_content";
    public static final String LocalContact_str="本地通讯录";
    
    public static final String CollectContact_layout="site_main_local_contact_slideview2";
    public static final String CollectContact_str="收藏联系人";
    
    /*
     * 组织(站点)布局--
     * 头像、站点名称、站点描述、站点代码
     */
    public static final String Site_headicon="site_main_list_item_image_iv";
    public static final String SiteText_layout="site_main_list_content";
    
    /*
     * 组织主页布局
     * 组织主页
     * 
     * 右上角菜单按钮--获取到该MENU控件的坐标--site_detail_menu--ImageButton
	 * 背景图片的id--site_detail_image_bg--imageview
     */
    public static final String SiteMainPage_menu="site_detail_menu";
    public static final String SiteBackGroundImage="site_detail_image_bg";
    
	/*
	 * 推荐组织及我感兴趣的组织、添加/创建组织、menu--添加组织、组织排序
	 * 
	 * 我感兴趣的组织
	 *   头像--imageview--site_main_list_item_image_iv；
	 *   layout--site_main_list_content--LinearLayout
	 *     名称--我感兴趣的组织--TextView--site_main_list_name_tv--index--0
	 *     描述--您感兴趣的组织就在您身边，一键轻松找，快来看看吧--TextView--site_main_list_memo_tv--index--1
	 * 添加/创建组织--layout--.LinearLayout--site_main_add_more
	 *   文字--添加/创建组织--TextView
	 * menu--ImageButton--site_main_menu
	 * menu-添加组织
	 * menu--组织排序
	 */
    public static final String MyInterestSite_headicon="site_main_list_item_image_iv";
    public static final String MyInterestSite_layout="site_main_list_content";
    public static final String MyInterestSite_name_id="site_main_list_name_tv";
    public static final String MyInterestSite_name_str="我感兴趣的组织";
    public static final String MyInterestSite_desc_id="site_main_list_memo_tv";
    public static final String MyInterestSite_desc_str="您感兴趣的组织就在您身边，一键轻松找，快来看看吧";
    public static final String Add_Or_CreateSite_layout="site_main_add_more";   
    public static final String Add_Or_CreateSite_str="添加/创建组织";
    public static final String menu_id="site_main_menu";
    public static final String menu_AddSite="添加组织";
    public static final String menu_SiteOrder="组织排序";

    
	/*
	 * 名称--文字--id--view的类别
	 * 组织创建页面
	 * 
	 * 标题--创建组织--site_create_title--textview
	 * 组织基本信息--textview
	 *  组织图像--site_create_site_head--RelativeLayout；
	 *   头像--site_create_head_img--imageview
	 *  组织名称--site_create_site_name--RelativeLayout；
	 *   必填--site_create_tv_set_sitename--textview
	 *  所属行业--site_create_site_business--RelativeLayout；
	 *   未选择(可选)--site_create_tv_set_sitebusiniess--textview
	 *  组织描述--site_create_site_descript--RelativeLayout；
	 *   未填写--site_create_tv_set_sitedescript--textview
	 * 联系信息--site_create_site_contactinfo--RelativeLayout
	 *  所在位置--site_create_site_areainfo--RelativeLayout；
	 *    地址--site_create_tv_set_areainfo--textview
	 *  联系人--site_create_site_contact--RelativeLayout；
	 *    姓名--site_create_tv_set_contact--textview
	 *  手机号--site_create_site_mobile--RelativeLayout；
	 *    手机号码site_create_tv_set_mobile--textview
	 * 开始创建组织--site_create_btn--button
	 * 
	 */
	public static final String site_create_title="site_create_title";
	public static final String site_create_site_head="site_create_site_head";
	public static final String site_create_head_img="site_create_head_img";
	public static final String site_create_site_name="site_create_site_name";
	public static final String site_create_tv_set_sitename="site_create_tv_set_sitename";
	
	public static final String site_create_site_business="site_create_site_business";
	public static final String site_create_tv_set_sitebusiniess="site_create_tv_set_sitebusiniess";
	public static final String site_create_site_descript="site_create_site_descript";
	public static final String site_create_tv_set_sitedescript="site_create_tv_set_sitedescript";
	
	public static final String site_create_site_contactinfo="site_create_site_contactinfo";
	public static final String site_create_site_areainfo="site_create_site_areainfo";
	public static final String site_create_tv_set_areainfo="site_create_tv_set_areainfo";
	
	public static final String site_create_site_contact="site_create_site_contact";
	public static final String site_create_tv_set_contact="site_create_tv_set_contact";
	public static final String site_create_site_mobile="site_create_site_mobile";
	public static final String site_create_tv_set_mobile="site_create_tv_set_mobile";
	public static final String site_create_btn="site_create_btn";
	/*
	 * 创建组织时的各子模块的文字及id
	 * 
	 * 组织名称--ed_title--textview
	 * 请输入组织名称:--please_ed_update_value--textview
	 * 输入框--et_text--EditText
	 * 确定--btn_sure
	 * 取消--btn_cancel
	 * 
	 * 
	 * 您好，您的组织注册申请已经提交，请耐心等待审核，若有必要请主动联系代理商。联系电话：13858020520
	 * site_create_site_completed_kindly_reminder_tv
	 * 确定--site_create_site_completed_btn
	 */
	public static final String site_name_edit_title="ed_title";	
	public static final String site_name_edit_desc="please_ed_update_value";
	public static final String site_name_edit_enter="et_text";
	public static final String btn_sure_id="btn_sure";
	public static final String operate_tag_id="site_create_site_completed_kindly_reminder_tv";
	public static final String operate_tag_str="您好，您的组织注册申请已经提交，请耐心等待审核，若有必要请主动联系代理商。";
	public static final String operate_complete="site_create_site_completed_btn";
	
	public static final String site_name_not_null="组织名称不能为空!";
	public static final String site_name_not_more="组织名称不能超过10字!";
	public static final String site_contact_not_null="联系人不能为空!";
	public static final String site_mobile_not_null="手机号不能为空!";
	public static final String string_name_not_null="姓名不能为空!";
	
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
    /**
     * 个人中心各模块子功能的id
     */
    public static final String Dialog_LoginOut_content="确定要退出组织";
    public static final String Dialog_LoginOut_content_id="content";
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
