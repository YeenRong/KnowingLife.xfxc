package com.KnowingLifeTest.Config;


public class Config {
	public static String PackageName="com.android.KnowingLife.xfxc";
	public static String MainActivity="com.android.KnowingLife.ui.activity.WelcomeActivity";
	//com.android.KnowingLife.ui.activity.WelcomeActivity
	public static String usernammString="13067905358" ;
	public static String passwordString="a112233shb";
	public static int timeout=10000;
	public static int less_timeout=1000;
	public static int long_timeout=3000;
	public static int Loading_timeout=5000;
	/*public static String ProgramMatch="项目撮合";
	public static String PrivateLawer="私人律师";
	public static String SupplyandNeedinfo="供求信息";
	public static String FinancialServices="金融服务";
    public static String Businessgroup="商帮";
    */
	/*
	 * 幸福乡村主页
	 */
	public static String CulturalHall="文化礼堂";
	public static String FarmHelp="农忙互助";
	public static String Rich_Experience="致富经";
	public static String beautifulScenes="魅力风景";
    public static String OneVillageOneProdect="一村一品";
    public static String TravelRecommendation="乡游推荐";
    public static String PeopleFinance="亲民金融";
    public static String ContactUs="联系我们";

    /*
     * 主要模块
     */
    //public static String Discovery="发现";
    public static String xfxchome="幸福乡村";
    public static String[] home_str={"幸福乡村","商会帮","智慧乡村"};
    public static String More="更多";
    public static String Dynamic="动态";
    public static String Chilean_media="智媒体";
    public static String DigitalVillage="数字村谱";
    /**
     * contacts，不同的产品线不一样,用于随便看看
     */
    public static String Contacts="数字村谱";
    public static String HomePage="幸福乡村";
    
	
    /*
     * 调试用文字
     */
    public static String crash_handler_toast_info="很抱歉，程序发生错误，即将关闭！\n请稍后发送报告给我们来解决此问题";
    

    /**
     * 调试用日志
     */
    public static String SearchText="花园";
    public static String TAG="xfxc_log";
    public static String Warn_TAG="Method_not_found";
    public static String Error_TAG="result_error";
    public static String getfailedmessage="获取信息失败";
    public static String getcrashmessage="应用崩溃";
    public static String getsuccessmessage="运行正常";
    public static String Logfilesavapath="/sdcard/KnowingLife/Log_";
    
    /*
     * 加载提示语
     * 动态页面加载--初始化
     */
    /*
     * 加载站点数据
     * 
     */
    public static String[] loadingStrings={"释放立即刷新","下拉刷新","正在刷新","正在读取中....","组织刷新组织数据，请稍候","请稍后...","正在获取数据..."};
    
    public static String[] UnNormalNetwork={""};
    /**
     * 弹出的提示框内容判断
     * {提示框标题，提示框内容，提示框-取消按钮，提示框--确定按钮）
     */
    public static String[] PopUpBox_Loading={};
    
    
    /**
     * 站点信息
     */
    public static String site_name="文祥";
    public static String site_desc="我们是来打酱油，";
    public static String site_mobile="13067905358";
    public static String site_contact_name="王宇";
    
    
    public static String[] Createsiteinfo={"必填","未选择(可选)","未填写","","","",""};
  //  public static String site_
    /*
     * 第一个是指搜索框的id，第2个是指立即搜索的按钮id，第3个是查找的页面的标题
     */
    public static String[] Search_Village=
    	{CommonPageIdName.SearchVillageEdit_ID,CommonPageIdName.SearchVillageBtn_id,
    	CommonPageIdName.SearchVillageResult_Title_str};
    public static String[] Search_Site=
    	{CommonPageIdName.SearchSiteEdit,CommonPageIdName.SearchSiteBtn_id,
    	CommonPageIdName.SearchSiteTitle_str};
    
    
    /*
	public static int Entertainment = 8;
	public static int Funny = 9;
	public static int Game = 10;
	public static int Life = 11;
	public static int Music = 12;
	public static int Documentary = 13;
	public static int Original = 14;

	public static int clickcount = 3;                //设置视频播放页面推荐列表点击循环次数
	public static int downloadcount = 7;               //下载页面下载的视频数目
	
    public static String[] a = {"榜单","专题"};         //设置榜单类型子栏目
    
    public static int TuijianMode = 1;               //宏定义，用在Classification_AlbumPlay_CheckTuijianPage(int mode)函数中，定义操作类型
    public static int CaptureMode = 2; 
    public static int ResolutionMode = 3;
    public static int SourceMode = 4;
    */
}