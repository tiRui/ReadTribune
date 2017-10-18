package com.fragmentmenu;

import java.util.ArrayList;
import java.util.List;

import com.datamodel.MyOwnAdapter;
import com.datamodel.showData;
import com.functionactivity.MoreContentShow;
import com.functionactivity.MoreTypeShow;
import com.readtribune.R;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainPager extends Fragment implements OnClickListener {
	private GridView gridview;
	private ViewPager mViewPager;
	private List<ImageView> mImageView;
	private List<ImageView> mView;
	private int currentItem;
	private int oldcurrentItem = 0;
	private boolean isStop;
	private ViewPagerAdapter adapter;
	private MyOwnAdapter gvAdapter;
	private PopupWindow minPopupWin;
	private View mainView;
	private LinearLayout main_type_show_1, main_type_show_2, main_type_show_3, main_type_show_4, main_type_show_5,
			main_type_show_6, main_type_show_7, main_type_show_more;
	private int[] showimages = new int[] { R.drawable.main_show_1, R.drawable.main_show_2, R.drawable.main_show_3,
			R.drawable.main_show_4 };
	private String[] titles = new String[] { "书名1", "书名2", "书名3", "书名4号" };
	private String[] descris = new String[] { "描述1", "描述2", "描述3", "描述4" };
	private String[] authors = new String[] { "作者1", "作者2", "作者3", "作者4" };
	private int[] images = new int[] { R.drawable.advert_1, R.drawable.advert_2, R.drawable.advert_3,
			R.drawable.advert_4, R.drawable.advert_5 };
	private Handler myHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			switch (msg.what) {
			case 0:
				mViewPager.setCurrentItem(currentItem);
				break;

			default:
				break;
			}
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mainView = inflater.inflate(R.layout.mainpager, container, false);
		mViewPager = (ViewPager) mainView.findViewById(R.id.viewpager);
		mImageView = new ArrayList<ImageView>();
		for (int i = 0; i < images.length; i++) {
			ImageView imageview = new ImageView(getContext());
			imageview.setBackgroundResource(images[i]);
			mImageView.add(imageview);
		}
		mView = new ArrayList<ImageView>();
		mView.add((ImageView) mainView.findViewById(R.id.point_1));
		mView.add((ImageView) mainView.findViewById(R.id.point_2));
		mView.add((ImageView) mainView.findViewById(R.id.point_3));
		mView.add((ImageView) mainView.findViewById(R.id.point_4));
		mView.add((ImageView) mainView.findViewById(R.id.point_5));
		adapter = new ViewPagerAdapter();
		mViewPager.setAdapter(adapter);
		mViewPager.addOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				mView.get(arg0).setImageResource(R.drawable.point_select);
				mView.get(oldcurrentItem).setImageResource(R.drawable.point);
				oldcurrentItem = arg0;
				currentItem = arg0;
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
		/*
		 * 分类显示展示实现
		 */
		showMoreTypeView();
		/*
		 * 单独显示功能实现
		 */
		gridview = (GridView) mainView.findViewById(R.id.main_gridview);
		gvAdapter = new MyOwnAdapter(showimages, titles, descris, authors, getActivity());
		gridview.setFocusable(false);
		gridview.setAdapter(gvAdapter);
		return mainView;
	}

	private void showMoreTypeView() {
		main_type_show_1 = (LinearLayout) mainView.findViewById(R.id.main_lin_1_1);
		main_type_show_1.setOnClickListener(this);
		main_type_show_2 = (LinearLayout) mainView.findViewById(R.id.main_lin_1_2);
		main_type_show_2.setOnClickListener(this);
		main_type_show_3 = (LinearLayout) mainView.findViewById(R.id.main_lin_1_3);
		main_type_show_3.setOnClickListener(this);
		main_type_show_4 = (LinearLayout) mainView.findViewById(R.id.main_lin_1_4);
		main_type_show_4.setOnClickListener(this);
		main_type_show_5 = (LinearLayout) mainView.findViewById(R.id.main_lin_2_1);
		main_type_show_5.setOnClickListener(this);
		main_type_show_6 = (LinearLayout) mainView.findViewById(R.id.main_lin_2_2);
		main_type_show_6.setOnClickListener(this);
		main_type_show_7 = (LinearLayout) mainView.findViewById(R.id.main_lin_2_3);
		main_type_show_7.setOnClickListener(this);
		main_type_show_more = (LinearLayout) mainView.findViewById(R.id.main_lin_2_4);
		main_type_show_more.setOnClickListener(this);
	}

	// public class myOwnAdapter extends BaseAdapter {
	//
	// private Context context;
	// private List<showData> showDatas = new ArrayList<showData>();
	//
	// public myOwnAdapter(int[] images, String[] titles, String[] descris,
	// String[] authors, Context context) {
	// super();
	// this.context = context;
	// for (int i = 0; i < authors.length; i++) {
	// showData showdata = new showData();
	// showdata.setImg(images[i]);
	// showdata.setTitle(titles[i]);
	// showdata.setWord(descris[i]);
	// showdata.setAuthor(authors[i]);
	// showDatas.add(showdata);
	// }
	//
	// }
	//
	// @Override
	// public int getCount() {
	// // TODO Auto-generated method stub
	// return showDatas.size();
	// }
	//
	// @Override
	// public Object getItem(int position) {
	// // TODO Auto-generated method stub
	// return showDatas.get(position);
	// }
	//
	// @Override
	// public long getItemId(int position) {
	// // TODO Auto-generated method stub
	// return position;
	// }
	//
	// @Override
	// public View getView(int position, View convertView, ViewGroup parent) {
	// // TODO Auto-generated method stub
	// if (convertView == null) {
	// convertView =
	// LayoutInflater.from(getActivity()).inflate(R.layout.main_show_item,
	// null);
	// }
	// showData showda = showDatas.get(position);
	// ImageView img = (ImageView) convertView.findViewById(R.id.main_show_img);
	// img.setImageResource(showda.getImg());
	// TextView txt_title = (TextView)
	// convertView.findViewById(R.id.main_show_title);
	// txt_title.setText(showda.getTitle());
	// TextView txt_descri = (TextView)
	// convertView.findViewById(R.id.main_show_descr);
	// txt_descri.setText(showda.getWord());
	// TextView txt_author = (TextView)
	// convertView.findViewById(R.id.main_show_author);
	// txt_author.setText(showda.getAuthor());
	// return convertView;
	// }
	//
	// }

	private class ViewPagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mImageView.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			container.removeView(mImageView.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			container.addView(mImageView.get(position));
			return mImageView.get(position);
		}
	}

	// public class showData {
	//
	// private int Img;
	// private String Title;
	// private String Word;
	// private String Author;
	//
	// public int getImg() {
	// return Img;
	// }
	//
	// public void setImg(int img) {
	// Img = img;
	// }
	//
	// public String getTitle() {
	// return Title;
	// }
	//
	// public void setTitle(String title) {
	// Title = title;
	// }
	//
	// public String getWord() {
	// return Word;
	// }
	//
	// public void setWord(String word) {
	// Word = word;
	// }
	//
	// public String getAuthor() {
	// return Author;
	// }
	//
	// public void setAuthor(String author) {
	// Author = author;
	// }
	//
	// }

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		menu.clear();
		View v = LayoutInflater.from(getActivity()).inflate(R.layout.mianpager_menu, null);
		ActionBar actionbar = getActivity().getActionBar();
		actionbar.setCustomView(v);
		actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		actionbar.setDisplayShowCustomEnabled(true);
		actionbar.setDisplayShowTitleEnabled(false);
		actionbar.setDisplayShowHomeEnabled(false);
		actionbar.getCustomView().findViewById(R.id.mian_title_more).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showMinPopupWindow();
			}
		});
		super.onCreateOptionsMenu(menu, inflater);
	}

	private void showMinPopupWindow() {
		View mView = LayoutInflater.from(getActivity()).inflate(R.layout.mian_popupwindow_min, null);
		minPopupWin = new PopupWindow(mView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,
				true);
		// minPopupWin.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
		// minPopupWin.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
		minPopupWin.setContentView(mView);
		TextView mian_minpopup_1 = (TextView) mView.findViewById(R.id.main_popup_1);
		TextView mian_minpopup_2 = (TextView) mView.findViewById(R.id.main_popup_2);
		TextView mian_minpopup_3 = (TextView) mView.findViewById(R.id.main_popup_3);
		TextView mian_minpopup_4 = (TextView) mView.findViewById(R.id.main_popup_4);

		mian_minpopup_1.setOnClickListener(this);
		mian_minpopup_2.setOnClickListener(this);
		mian_minpopup_3.setOnClickListener(this);
		mian_minpopup_4.setOnClickListener(this);

		View v = LayoutInflater.from(getActivity()).inflate(R.layout.activity_main, null);
		Drawable draw = getResources().getDrawable(R.drawable.main);
		minPopupWin.setBackgroundDrawable(draw);
		minPopupWin.setOutsideTouchable(true);
		minPopupWin.showAtLocation(v, Gravity.END, 0, -358);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.main_popup_1:
			minPopupWin.dismiss();
			break;

		case R.id.main_popup_2:
			minPopupWin.dismiss();
			break;

		case R.id.main_popup_3:
			minPopupWin.dismiss();
			break;

		case R.id.main_popup_4:
			minPopupWin.dismiss();
			break;
		case R.id.main_lin_1_1:
			Intent intent1_1 = new Intent(getActivity(), MoreContentShow.class);
			startActivity(intent1_1);
			break;

		case R.id.main_lin_1_2:
			Intent intent1_2 = new Intent(getActivity(), MoreContentShow.class);
			startActivity(intent1_2);
			break;
			
		case R.id.main_lin_1_3:
			Intent intent1_3 = new Intent(getActivity(), MoreContentShow.class);
			startActivity(intent1_3);
			break;
			
		case R.id.main_lin_1_4:
			Intent intent1_4 = new Intent(getActivity(), MoreContentShow.class);
			startActivity(intent1_4);
			break;
			
		case R.id.main_lin_2_1:
			Intent intent2_1 = new Intent(getActivity(), MoreContentShow.class);
			startActivity(intent2_1);
			break;
			
		case R.id.main_lin_2_2:
			Intent intent2_2 = new Intent(getActivity(), MoreContentShow.class);
			startActivity(intent2_2);
			break;
			
		case R.id.main_lin_2_3:
			Intent intent2_3 = new Intent(getActivity(), MoreContentShow.class);
			startActivity(intent2_3);
			break;
			
		case R.id.main_lin_2_4:
			Intent intent2_4 = new Intent(getActivity(), MoreTypeShow.class);
			startActivity(intent2_4);
			break;
		default:
			break;
		}

	}

	@Override
	public void onStart() {
		isStop = false;
		super.onStart();
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (!isStop) {
					try {
						Thread.sleep(3000);
						currentItem = (currentItem + 1) % images.length;
						myHandler.sendEmptyMessage(0);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}).start();
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		isStop = true;
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		myHandler.removeCallbacksAndMessages(null);
	}

}
