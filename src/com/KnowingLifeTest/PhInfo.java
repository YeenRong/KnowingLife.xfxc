package com.KnowingLifeTest;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;

public class PhInfo {
	private String screenWidth;
	private String screenHeight;
	private String id;
	private String model;
	private String sdkVersion;
	private String release;

	private String memory;
	private String memSpace;
	private String sdSpace;
	private String netType;
	private String operator;

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	// add versionName versionCode
	private String apkVersion;// versionName;

	public String getApkVersion() {
		return apkVersion;
	}

	public void setApkVersion(String apkVersion) {
		this.apkVersion = apkVersion;
	}

	public String getApkSource() {
		return apkSource;
	}

	public void setApkSource(String apkSource) {
		this.apkSource = apkSource;
	}

	private String apkSource;

	public String getScreenWidth() {
		return screenWidth;
	}

	public void setScreenWidth(String screenWidth) {
		this.screenWidth = screenWidth;
	}

	public String getScreenHeight() {
		return screenHeight;
	}

	public void setScreenHeight(String screenHeight) {
		this.screenHeight = screenHeight;
	}

	public String getMemSpace() {
		return memSpace;
	}

	public void setMemSpace(String memSpace) {
		this.memSpace = memSpace;
	}

	public String getNetType() {
		return netType;
//		return "AT&T";
	}

	public void setNetType(String netType) {
		this.netType = netType;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setSdkVersion(String sdkVersion) {
		this.sdkVersion = sdkVersion;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public void setSdSpace(String sdSpace) {
		this.sdSpace = sdSpace;
	}
/*
	public PhInfo(Context context) {

		// memSpace�ڴ����и�ֵ�ˣ�Ҫ�Ķ�
		this.memory = initMemory();
		this.sdSpace = querySdSpace();
		this.netType = getNetType(context);

		getScreenInfo(context);
		this.id = android.os.Build.ID;
		this.model = android.os.Build.MODEL;
		this.sdkVersion = android.os.Build.VERSION.SDK;
		this.release = android.os.Build.VERSION.RELEASE;
		initVersionName(context);
		initSourceCode(context);
		initOperatorName(context);
	}

	private void getScreenInfo(Context context) {
		Point pt = KasUtil.getScreenSize(context);
		screenHeight = pt.y + "px";
		screenWidth = pt.x + "px";
	}

	// public void getId() {
	// id = android.os.Build.ID;
	// }
	//
	// public void getModel() {
	// model = android.os.Build.MODEL;
	// }
	//
	// public void getSdkVersion() {
	// sdkVersion = android.os.Build.VERSION.SDK;
	// }
	//
	// public void getRelease() {
	// release = android.os.Build.VERSION.RELEASE;
	// }

	public String getMemory() {
		return memory;
	}

	public String getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	public String getSdkVersion() {
		return sdkVersion;
	}

	public String getRelease() {
		return release;
	}

	public String getSdSpace() {
		return sdSpace;
	}

	private String querySdSpace() {
		// ʣ������
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state)) {
			File sdcardDir = Environment.getExternalStorageDirectory();
			StatFs sf = new StatFs(sdcardDir.getPath());
			long blockSize = 0;
			long blockCount = 0;
			if(Build.VERSION.SDK_INT < 18){
				blockSize = sf.getBlockSize();
				blockCount = sf.getBlockCount();
			}else{
				blockSize = sf.getBlockSizeLong();
				blockCount = sf.getBlockCountLong();
			}
			// long availCount = sf.getAvailableBlocks();
			return blockSize * blockCount / 1024 + "KB";
		}
		return "";
	}

	private String getNetType(Context context) {
		// TODO Auto-generated method stub
		String netType = "";
		ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity == null) {

		} else {
			NetworkInfo info = connectivity.getActiveNetworkInfo();
			if (info == null) {
			} else if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
				TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
				int type = tm.getNetworkType();
				switch (type) {
				case TelephonyManager.NETWORK_TYPE_EDGE:
					// Log.d(TAG, "EDGE");
					netType += "EDGE";
					break;
				case TelephonyManager.NETWORK_TYPE_GPRS:

					netType += "GPRS";
					break;
				case TelephonyManager.NETWORK_TYPE_UMTS:

					netType += "UMTS";
					break;
				case TelephonyManager.NETWORK_TYPE_UNKNOWN:

					netType += "UNKNOWN";
					break;
				}
			} else if (info.getType() == ConnectivityManager.TYPE_WIFI) {
				netType += "WIFI";
			}
		}
		return netType;
	}

	private String initMemory() {
		File root = Environment.getRootDirectory();
		StatFs sf = new StatFs(root.getPath());
		long blockSize = sf.getBlockSize();
		long blockCount = sf.getBlockCount();
		long availCount = sf.getAvailableBlocks();
		// Log.d, "Memory=" + (blockSize * blockCount / 1024) + "KB");
		this.memSpace = (blockSize * availCount / 1024) + "KB";
		return blockSize * blockCount / 1024 + "KB";
	}

	private void initVersionName(Context context) {
		if (context == null) {
			return;
		}
		PackageInfo pInfo = null;
		String versionName = null;
		try {
			pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (pInfo != null && pInfo.versionName != null) {
			versionName = pInfo.versionName;
			setApkVersion(versionName);
		}

	}
/*
	private void initSourceCode(Context context) {
		String content = "100";
		String fileName = "code.kas";
		if (context == null) {
			setApkSource(content);
			return;
		}
		AssetManager am = context.getAssets();
		if (am == null) {
			setApkSource(content);
			return;
		}
		InputStream is = null;
		byte[] buffer = null;
		try {
			is = am.open(fileName);
			if (is != null) {
				int size = is.available();
				buffer = new byte[size];
				is.read(buffer);
				is.close();
			}
		} catch (Exception e) {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			Config.Alog.d("PhInfo", e.toString());
		}
		if (buffer != null) {
			content = new String(buffer);
		}
		Config.Alog.d("PhInfo", "apkSource:" + content);
		setApkSource(content);
	}

	private void initOperatorName(Context context) {
		if (context == null) {
			return;
		}
		this.operator = getOperator3(context);
		if (this.operator == null || this.operator != null && this.operator.trim().equalsIgnoreCase("")) {
			this.operator = getOperator2(context);
		}
		if (this.operator == null || this.operator != null && this.operator.trim().equalsIgnoreCase("")) {
			this.operator = getOperator1(context);
		}
		Alog.d("PhInfo", "this.operator:"+this.operator);

	}

	private String getOperator1(Context context) {
		Alog.e("PhInfo", "getOperator1");
		if (context == null) {
			return null;
		}
		String operator = null;
		TelephonyManager tm = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);
		if (tm != null) {
			operator = tm.getSimOperatorName();
		}
		Alog.e("PhInfo", "operator:" + operator);
		return operator;
	}

	private String getOperator2(Context context) {
		Alog.d("PhInfo", "getOperator2");
		if (context == null) {
			return null;
		}
		String operator = null;
		String imsi=null;
		TelephonyManager tm = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);
		if (tm!=null) {
			imsi = tm.getSubscriberId();
		}
		if (imsi != null&&imsi.length()>=5) {
			Alog.d("PhInfo", "imsi:"+imsi);
			operator=imsi.substring(0, 5);
		} else {
			Alog.e("PhInfo", "imsi == null");
		}
		return operator;

	}

	private String getOperator3(Context context) {
		Alog.d("PhInfo", "getOperator3");
		if (context == null) {
			return null;
		}
		String operator = null;
		String o=null;
		TelephonyManager tm = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);
		if (tm!=null) {
			o = tm.getSimOperator();
		}
		if (o != null) {
			Alog.d("PhInfo", "o:"+o);
			operator=o;
		}else {
			Alog.e("PhInfo", "o == null");
		}
		return operator;

	}*/

}