package com.fragmentmenu;

import java.util.ArrayList;
import java.util.List;

import com.datamodel.tribuneData;
import com.functionactivity.TribuneItem;
import com.readtribune.R;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class TribunePager extends Fragment {

	private ListView mlistview;
	private MyListAdapter listAdapter;
	public final static String VAL_KEY = "com.TribunePager.key";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.tribunepager, container, false);
		mlistview = (ListView) v.findViewById(R.id.tribune_listview);
		listAdapter = new MyListAdapter();
		mlistview.setAdapter(listAdapter);
		mlistview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				tribuneData mTribuneData = new tribuneData();
				mTribuneData = (tribuneData) listAdapter.getItem(position);
				Bundle bundel = new Bundle();
				bundel.putParcelable(VAL_KEY, mTribuneData);
				Intent intent = new Intent(getActivity(),TribuneItem.class);
				intent.putExtras(bundel);
				startActivity(intent);
			}
		});
		return v;
	};

	private class MyListAdapter extends BaseAdapter {
		private List<tribuneData> triDatas = new ArrayList<tribuneData>();

		public MyListAdapter() {
			super();
			for (int i = 0; i < 20; i++) {
				tribuneData da = new tribuneData();
				da.setTribuneTitle("#标题" + i);
				da.setTribuneImage(R.drawable.ic_launcher);
				da.setTribuneAthor("#作者" + i);
				triDatas.add(da);
			}
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return triDatas.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return triDatas.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if (convertView == null) {
				convertView = LayoutInflater.from(getActivity()).inflate(R.layout.tribune_list_item, null);
			}
			TextView tri_title = (TextView) convertView.findViewById(R.id.tribune_item_title);
			tri_title.setText(triDatas.get(position).getTribuneTitle());
			ImageView tri_img = (ImageView) convertView.findViewById(R.id.tribune_item_img);
			tri_img.setImageResource(triDatas.get(position).getTribuneImage());
			TextView tri_author = (TextView) convertView.findViewById(R.id.tribune_item_author);
			tri_author.setText(triDatas.get(position).getTribuneAthor());
			return convertView;
		}
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		View v2 = LayoutInflater.from(getActivity()).inflate(R.layout.tribunepager_menu, null);
		ActionBar actionbar = getActivity().getActionBar();
		actionbar.setCustomView(v2);
		actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		actionbar.setDisplayShowCustomEnabled(true);
		actionbar.setDisplayShowTitleEnabled(false);
		actionbar.setDisplayShowHomeEnabled(false);
		super.onCreateOptionsMenu(menu, inflater);
	}
}
