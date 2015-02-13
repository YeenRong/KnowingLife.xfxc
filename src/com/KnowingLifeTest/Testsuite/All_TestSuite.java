package com.KnowingLifeTest.Testsuite;

import com.KnowingLifeTest.test.More_Personal.LoginIn;
import com.KnowingLifeTest.test.More_Personal.TravelGridView;
import com.KnowingLifeTest.test.TongXinLu.BindVillage;
import com.KnowingLifeTest.test.TongXinLu.TongXingLuPage;
import com.KnowingLifeTest.test.UI.UITravel;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
public class All_TestSuite extends TestCase{

	public static Test suite() {
		TestSuite suite = new TestSuite();
		//$JUnit-BEGIN$
		//suite.addTestSuite(LoginIn.class);//执行登陆操作
		//suite.addTestSuite(UITravel.class);
		//suite.addTestSuite(TravelGridView.class);
		suite.addTestSuite(BindVillage.class);
		//suite.addTestSuite(SHBHome.class);
		//suite.addTestSuite(TongXingLuPage.class);//进入到通讯录页面
		
		//$JUnit-END$
		return suite;
	}

}
