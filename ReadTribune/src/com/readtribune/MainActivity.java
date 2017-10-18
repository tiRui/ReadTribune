package com.readtribune;

import java.util.ArrayList;
import java.util.List;

import com.fragmentmenu.MainPager;
import com.fragmentmenu.NewsPager;
import com.fragmentmenu.OwnPager;
import com.fragmentmenu.TribunePager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;

public class MainActivity extends FragmentActivity {

	private FragmentManager fragmentManager;
	private Fragment currentFragment = new Fragment();
	private List<Fragment> fragments = new ArrayList<>();
	private int currentIndex = 0;
	private BottomBar mBottomBar;
	private PopupWindow mpopupWindow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	//	requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		fragmentManager = getSupportFragmentManager();
		fragments.add(new MainPager());
		fragments.add(new TribunePager());
		fragments.add(new NewsPager());
		fragments.add(new OwnPager());

		showFragment();
		mBottomBar = (BottomBar) findViewById(R.id.bar);
		mBottomBar.setOnBottombarOnclick(new OnBottombarClick() {

			@Override
			public void onZhognXinClick() {
				// TODO Auto-generated method stub
				showPopupWindow();
			}

			@Override
			public void onThirdClick() {
				// TODO Auto-generated method stub
				currentIndex = 2;
				showFragment();
			}

			@Override
			public void onSecondClick() {
				// TODO Auto-generated method stub
				currentIndex = 1;
				showFragment();
			}

			@Override
			public void onFourthClick() {
				// TODO Auto-generated method stub
				currentIndex = 3;
				showFragment();
			}

			@Override
			public void onFirstClick() {
				// TODO Auto-generated method stub
				currentIndex = 0;
				showFragment();
			}
		});
	}

	private void showPopupWindow() {
		// TODO Auto-generated method stub
		View showView = LayoutInflater.from(MainActivity.this).inflate(R.layout.center_popupwindow, null);
		mpopupWindow = new PopupWindow(showView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, true);
		mpopupWindow.setContentView(showView);
		ImageButton offBtn = (ImageButton) showView.findViewById(R.id.center_off_btn);
		offBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mpopupWindow.dismiss();
			}
		});
		View rootView  = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main, null);
		mpopupWindow.showAtLocation(rootView, Gravity.BOTTOM, 0, 0);
	}

	private void showFragment() {
		// TODO Auto-generated method stub
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		if (!fragments.get(currentIndex).isAdded()) {
			transaction.hide(currentFragment).add(R.id.fragview, fragments.get(currentIndex), "" + currentIndex);
		} else {
			transaction.hide(currentFragment).show(fragments.get(currentIndex));
		}
		currentFragment = fragments.get(currentIndex);
		transaction.commit();
	}

}
