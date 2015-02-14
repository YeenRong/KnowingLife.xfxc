package com.KnowingLifeTest.MethodGroup;

import java.io.IOException;

import com.KnowingLifeTest.Config.CommonPageIdName;
import com.KnowingLifeTest.Config.Config;
import com.robotium.solo.Solo;

import junit.framework.Assert;

public class GetName extends Assert{
	private Solo solo;
	private MethodGroup op;
	private OpenMethod om;
	private CommonMethod cm;
	public GetName(Solo so) {
		solo = so;
		op = new MethodGroup(solo);
		om=new OpenMethod(solo);
		cm=new CommonMethod(solo);
	}
	/*
	 * 加载提示框的文字判断及执行的方法
	 */
	/**
	 * 加载提示框是否弹出
	 * @param str
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean ProgressBar_Judge(String str[],String id) throws Exception{
		String content;
		boolean result;
		content=op.ReturnName(id);
		result=op.ToastFindLike(str);
		return result;
	}
	/**
	 * 判断加载框是否弹出：如果弹出，则等待加载完成；否则不操作
	 * @param str
	 * @param id
	 * @throws Exception
	 */
    public void WaitForLoadingProgressAndSuccess(String str[],String id) throws Exception{
    	if(ProgressBar_Judge(str, id)){
    		WaitForProgressDisplay(str,id);
    	}else{
    		System.out.print("没有加载提示框");
    	}
    	
	}
    /**
     * 检测提示框已经加载完成
     * @param str
     * @param id
     * @throws Exception
     */
    public void WaitForProgressDisplay(String str[],String id) throws Exception{
    	
    	solo.sleep(Config.Loading_timeout);
    	if(op.checkViewExitsInScreen(id)==-1){
    		System.out.print("加载提示框已经消失");
    	}else{
    		solo.sleep(Config.Loading_timeout);
    	}    	
	}


}
