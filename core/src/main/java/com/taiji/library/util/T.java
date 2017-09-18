package com.taiji.library.util;

import android.content.Context;
import android.widget.Toast;

/**
 * 封装有Toast消息的工具类，所有弹Toast的消息只有一
 * */
public class T {

	private T(){};
	private static Toast toast;
	/**
	 * 短时间显示Toast
	 * 
	 * @param context
	 * @param message
	 */
	public static void showShort(Context context, CharSequence message) {
		if (null == toast) {
			toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	/**
	 * 短时间显示Toast
	 * 
	 * @param context
	 * @param message
	 */
	public static void showShort(Context context, int message) {
		if (null == toast) {
			toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	/**
	 * 长时间显示Toast
	 * 
	 * @param context
	 * @param message
	 */
	public static void showLong(Context context, CharSequence message) {
		if (null == toast) {
			toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	/**
	 * 长时间显示Toast
	 * 
	 * @param context
	 * @param message
	 */
	public static void showLong(Context context, int message) {
		if (null == toast) {
			toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	/**
	 * 自定义显示Toast时间
	 * 
	 * @param context
	 * @param message
	 * @param duration
	 */
	public static void show(Context context, CharSequence message, int duration) {
		if (null == toast) {
			toast = Toast.makeText(context, message, duration);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	/**
	 * 自定义显示Toast时间
	 * 
	 * @param context
	 * @param message
	 * @param duration
	 */
	public static void show(Context context, int message, int duration) {
		if (null == toast) {
			toast = Toast.makeText(context, message, duration);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	/**
	 * 显示网络请求错误信息
	 * @param context
	 * @param errorid
	 * @param error
	 */
	public static void showHttpError(Context context,int errorid,String error){
		String message = "";
		switch (errorid) {
		case 404:
			message = errorid+":找不到文件或者目录不存在_"+error;
			break;
		case 403:
			message = errorid+":找不到默认首页_"+error;
			break;
		case 500:
			message = errorid+":服务端程序内部错误_"+error;
			break;
		case 505:
			message = errorid+":服务器内部错误_"+error;
			break;
		case 401:
			message = errorid+":访问被拒绝_"+error;
			break;
		case 413:
			message = errorid+":请求实体太长_"+error;
			break;
		case 405:
			message = errorid+":方法不被允许_"+error;
			break;
		case 0:
			message = errorid+":无法连接到远程服务器_"+error;
			break;
		default:
			message = errorid+":未知错误，请联系系统管理员_"+error;
			break;
		}
		if(null == toast){
			toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
		}else{
			toast.setText(message);
		}
		toast.show();
	}

	/** Hide the toast, if any. */
	public static void hideToast() {
		if (null != toast) {
			toast.cancel();
		}
	}
}
