package com.edu.ykt003.education.util;

import android.widget.Toast;

import com.edu.ykt003.education.application.BaseApplication;

/**
 * Toast提示类
 * @author YL
 * @date 2017/2/28 9:10
 */
public class ShowToast {

	/**
	 * 短提示
	 * @param sequence
     */
	public static void Short(CharSequence sequence) {
		Toast.makeText(BaseApplication.getContext(), sequence, Toast.LENGTH_SHORT).show();
	}

	/**
	 * 长提示
	 * @param sequence
     */
	public static void Long(CharSequence sequence) {
		Toast.makeText(BaseApplication.getContext(), sequence, Toast.LENGTH_SHORT).show();
	}

}
