package com.readtribune;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BottomBar extends LinearLayout {

	private Context mContext;
	private LinearLayout first_bottom;
	private LinearLayout second_bottom;
	private LinearLayout third_bottom;
	private LinearLayout fourth_bottom;
	private LinearLayout zhongxin_bottom;
//	private ImageView first_img, second_img, third_img, fourth_img, zhongxin_img;
//	private TextView first_txt, second_txt, third_txt, fourth_txt;
	private OnBottombarClick mOnBottombarClick;

	public BottomBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public BottomBar(Context context) {
		super(context);
		init(context);
	}

	public BottomBar(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context);
	}

	private void init(Context context) {
		mContext = context;
		LayoutInflater.from(mContext).inflate(R.layout.item_tab, this, true);
		initview();
		onBottomBarClick();
	}

	private void initview() {
		first_bottom = (LinearLayout) findViewById(R.id.first);
		// first_img = (ImageView) findViewById(R.id.first_img_id);
		// first_txt = (TextView) findViewById(R.id.first_txt_id);

		second_bottom = (LinearLayout) findViewById(R.id.second);
		// second_img = (ImageView) findViewById(R.id.second_img_id);
		// second_txt = (TextView) findViewById(R.id.second_txt_id);

		third_bottom = (LinearLayout) findViewById(R.id.third);
		// third_img = (ImageView) findViewById(R.id.third_img_id);
		// third_txt = (TextView) findViewById(R.id.third_txt_id);

		fourth_bottom = (LinearLayout) findViewById(R.id.fourth);
		// fourth_img = (ImageView) findViewById(R.id.fourth_img_id);
		// fourth_txt = (TextView) findViewById(R.id.fourth_txt_id);

		zhongxin_bottom = (LinearLayout) findViewById(R.id.zhongxin);
		// zhongxin_img = (ImageView) findViewById(R.id.zhongxin_img_id);
	}

	private void onBottomBarClick() {
		first_bottom.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mOnBottombarClick != null) {
					mOnBottombarClick.onFirstClick();
				}
			}
		});

		second_bottom.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mOnBottombarClick != null) {
					mOnBottombarClick.onSecondClick();
				}
			}
		});

		third_bottom.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mOnBottombarClick != null) {
					mOnBottombarClick.onThirdClick();
				}
			}
		});

		fourth_bottom.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mOnBottombarClick != null) {
					mOnBottombarClick.onFourthClick();
				}
			}
		});

		zhongxin_bottom.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (mOnBottombarClick != null) {
					mOnBottombarClick.onZhognXinClick();
				}
			}
		});
	}

	public void setOnBottombarOnclick(OnBottombarClick onBottombarClick) {
		this.mOnBottombarClick = onBottombarClick;
	}

}
