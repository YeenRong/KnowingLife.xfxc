package com.KnowingLifeTest.MethodGroup;

import java.util.ArrayList;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.TabWidget;
//import android.view.View.AttachInfo;
import com.KnowingLifeTest.Config.Config;
import com.robotium.solo.Solo;
import junit.framework.Assert;
/**
 * 这个类里包含以下方法：
 * 1.获取
 * @author lau
 *
 */
public class OpenMethod extends Assert{

	private Solo solo;
	private MethodGroup op;
	final String TAG = Config.TAG;
	public OpenMethod(Solo so) {
		solo = so;
		op = new MethodGroup(solo);
	}

	/**
	 * 重写drag方法，主要用于滑动选择地区的选项框
	 * 从view的最底部滑倒view的最上方，用来判断区域的滑动比例
	 */
	public void dragPage(View view){
		// 存储view的高度和宽度
		int[] xyLocation = new int[2];
		// 存储view的xy坐标，左下角坐标值
		float[] xyToClick = new float[2];
		// 获取左下角坐标值
		view.getLocationOnScreen(xyLocation);
		// 获取view的宽度
		final int viewWidth = view.getWidth();
		// 获取view的高度
		final int viewHeight = view.getHeight();
		// 计算view的左上角的x坐标
		final float viewLeftTop_x=xyLocation[0];
		// 计算view的左上角的y坐标
	    final float viewLeftTop_y=xyLocation[1];
		// 计算view中间点x坐标
		final float x = xyLocation[0] + (viewWidth / 2.0f);
		// 计算view中间点y坐标
		float y = xyLocation[1] + (viewHeight / 2.0f);
		
        //点击的坐标
		xyToClick[0] = x;
		xyToClick[1] = y;
		solo.drag(xyLocation[0]+viewWidth/2, xyLocation[0]+viewWidth/2, xyLocation[1]+viewHeight*7/8, xyLocation[1]+viewHeight/8, 20);
		Log.d(Config.TAG, "viewwidth"+" :"+String.valueOf(viewWidth)+" "+"viewheight"+":"+String.valueOf(viewHeight));
		Log.d(Config.TAG, "xylocation［0］"+" :"+String.valueOf(xyLocation[0])+" "+"xylocation[1]"+":"+String.valueOf(xyLocation[1]));	
		}
	/**
	 * 重写drag方法，
	 * 可以从view的任意点滑倒任意点
	 * 从view的最底部滑倒view的最上方，用来判断区域的滑动比例，可以选择滑动的比例是多少
	 * dragPage(View view,float dragPercentFrom_X,float dragPercentFrom_Y,float dragPercentTo_X,float dragPercentTo_Y)
	 * 第一个参数是指定的view名称
	 * 第二个参数是设置起点位置x的百分比
	 * 第三个参数是设置起点位置y的百分比
	 * 第四个参数是设置终点位置x的百分比
	 * 第五个参数是设置终点位置x的百分比
	 * 
	 * drag(fromX, toX, fromY, toY, stepCount); 
	 * 第一个参数是从起始点的横轴x点，等于view的左上角x坐标点＋view的宽度百分比；默认百分比是view的0.5倍
	 * 第二个参数是从起始点的横轴y点，等于view的左上角y坐标点＋view的高度百分百
	 * 第三个参数是从终点的横轴y点（滑动到的坐标点x轴），fromX＋view的滑动的百分百
	 * 第四个参数是从终点的横轴y点（滑动到的坐标点y轴），fromY＋view的滑动的百分百
	 * 第5个参数是拖动的步骤数，等于（屏幕滑动高度的平方+屏幕滑动高度的平方）的开根号/100
	 */
	public void dragPage(View view,float dragPercentFrom_X,float dragPercentFrom_Y,
			float dragPercentTo_X,float dragPercentTo_Y){
		// 存储view的高度和宽度
		int[] xyLocation = new int[2];
		// 存储view的xy坐标，左下角坐标值
		view.getLocationOnScreen(xyLocation);
		// 获取view的宽度
		final int viewWidth = view.getWidth();
		// 获取view的高度
		final int viewHeight = view.getHeight();
		// 计算view的左上角的x坐标
		final float viewLeftTop_x=xyLocation[0];
		// 计算view的左上角的y坐标
	    final float viewLeftTop_y=xyLocation[1];
	    float FromX=viewLeftTop_x+viewWidth*dragPercentFrom_X;
	    float FromY=viewLeftTop_y+viewHeight*dragPercentFrom_Y;   
	    float ToX=viewLeftTop_x+viewWidth*dragPercentTo_X;
	    float ToY=viewLeftTop_y+viewHeight*dragPercentTo_Y;
	    float MoveX=ToX-FromX;
	    float MoveY=ToY-FromY;
	    int StepCount=(int)((Math.sqrt(Math.pow(MoveX,2.0)+Math.pow(MoveY, 2.0)))/100);
		solo.drag(FromX, ToX, FromY, ToY, StepCount);
		Log.d(TAG, "viewwidth"+" :"+String.valueOf(viewWidth)+" "+"viewheight"+":"+String.valueOf(viewHeight));
		Log.d(TAG, "xylocation［0］"+" :"+String.valueOf(xyLocation[0])+" "+"xylocation[1]"+":"+String.valueOf(xyLocation[1]));	
	}
	/**
	 * 有id的view，返回view
	 */
	public View idToView(String id){
		Activity act=solo.getCurrentActivity();
		assertTrue(Config.TAG, op.checkViewExitsInScreen(id)>0);
		int id2 = act.getResources().getIdentifier(id, "id",
				solo.getCurrentActivity().getPackageName());
		View view=act.findViewById(id2);
		return view;
	}

	/**
	* 获取View点击的中间位置坐标
	* view 需要点击的view
	* Returns click coordinates for the specified view.
	*
	* @param view the view to get click coordinates from
	* @return click coordinates for a specified view
	*/

	public float[] getClickCoordinates(View view){
	// 存储view的高度和宽度
	int[] xyLocation = new int[2];
	// 存储view的xy坐标，左下角坐标值
	float[] xyToClick = new float[2];
	// 获取左下角坐标值
	view.getLocationOnScreen(xyLocation);
	// 获取宽度
	final int viewWidth = view.getWidth();
	// 获取高度
	final int viewHeight = view.getHeight();
	// 计算中间点x坐标
	final float x = xyLocation[0] + (viewWidth / 2.0f);
	// 计算中间点y坐标
	float y = xyLocation[1] + (viewHeight / 2.0f);

	xyToClick[0] = x;
	xyToClick[1] = y;
	Log.d(TAG, "viewwidth"+" :"+String.valueOf(viewWidth)+" "+"viewheight"+":"+String.valueOf(viewHeight));
	Log.d(TAG, "xylocation［0］"+" :"+String.valueOf(xyLocation[0])+" "+"xylocation[1]"+":"+String.valueOf(xyLocation[1]));

	return xyToClick;	
	}
	public void returnXY(String id){
		String id1=id;
		Activity act=solo.getCurrentActivity();
		assertTrue(Config.TAG, op.checkViewExitsInScreen(id)>0);
		int id2 = act.getResources().getIdentifier(id1, "id",
				solo.getCurrentActivity().getPackageName());
		View view=act.findViewById(id2);
		getClickCoordinates(view);	
	}

	/**
	 * 获取到设备的屏幕宽和高
	 * 
	 */

      /**
         * Simulate touching a specific location and dragging to a new location
         * by percent.
         * 
         * @param fromX
         *            X coordinate of the initial touch, in screen coordinates
         * @param toX
         *            Xcoordinate of the drag destination, in screen coordinates
         * @param fromY
         *            X coordinate of the initial touch, in screen coordinates
         * @param toY
         *            Y coordinate of the drag destination, in screen
         *            coordinates
         * @param stepCount
         *            stepCount How many move steps to include in the drag
         * 
         */
        public float toScreenX(float persent) {
            return getDisplayX() * persent;
        }

        public float toScreenY(float persent) {
            return getDisplayY() * persent;
        }

        public float toPercentX(float x) {
            return x / getDisplayX();
        }

        public float toPercentY(float y) {
            return y / getDisplayY();
        }
        public float getDisplayX() {
        Activity mActivity=solo.getCurrentActivity();
        DisplayMetrics dm = new DisplayMetrics();
        mActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
        }

        public float getDisplayY(){
        	Activity mActivity=solo.getCurrentActivity();
            DisplayMetrics dm = new DisplayMetrics();
            mActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
            return dm.heightPixels;
    }
        /**
         * click on screen, the point is on the down
         */
        public void clickOnScreenDown() {
            float x = getDisplayX();
            float y = getDisplayY();
            solo.clickOnScreen(x / 2, y - y / 4);
        }

        /**
         * drag on screen to right
         */
        public void dragScreenToLeft(int stepCount) {
            float x = getDisplayX();
            float y = getDisplayY();
            solo.drag(x - x / 4, x / 4, y / 2, y / 2, stepCount);
        }

        /**
         * drag on screen to Left
         */
        public void dragScreenToRight(int stepCount) {
            float x = getDisplayX();
            float y = getDisplayY();
            solo.drag(x / 4, x - x / 4, y / 2, y / 2, stepCount);
        }

        /**
         * drag on screen to up
         */
        public void dragScreenToUp(int stepCount) {
            float x = getDisplayX();
            float y = getDisplayY();
            solo.drag(x / 2, x / 2, y - y / 4, y / 4, stepCount);
        }

        /**
         * drag on screen to Down
         */
        public void dragScreenToDown(int stepCount) {
            float x = getDisplayX();
            float y = getDisplayY();
            solo.drag(x / 2, x / 2, y / 4, y - y / 4, stepCount);
        }
        /**
         * Returns an ArrayList with the Tab located in the current activity
         * 
         * @return ArrayList of the Tabs contained in the current activity
         */
        public ArrayList<TabWidget> getCurrentTabs() {
            ArrayList<TabWidget> tabList = new ArrayList<TabWidget>();
            ArrayList<View> viewList = solo.getCurrentViews();
            for (View view : viewList) {
                if (view instanceof android.widget.TabWidget) {
                    tabList.add((TabWidget) view);
                }
            }
            return tabList;
        }
        /**
         * This method returns a tab with a certain index.
         * 
         * @param index
         *            the index of the Tab
         * @return the tab with the specific index
         */
        public TabWidget getTab(int index) {
            ArrayList<TabWidget> tabList =getCurrentTabs();
            TabWidget tab = null;
            try {
                tab = tabList.get(index);
            } catch (Throwable e) {
            }
            return tab;
        }

        /**
         * Click on a tab with a certain item
         * 
         * @param index
         *            the index of the tab
         * @param item
         *            the item of the tab will be clicked
         */
        public void clickOnTab(int index, int item) {
            TabWidget tab = null;
            try {
                tab = getTab(index);
                Assert.assertTrue("Tab is null", tab != null);
                solo.clickOnView(tab.getChildAt(item));
            } catch (IndexOutOfBoundsException e) {
                Assert.assertTrue("Index is not valid", false);
            }
        }
	 
}