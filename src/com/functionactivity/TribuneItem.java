package com.functionactivity;

import com.datamodel.tribuneData;
import com.fragmentmenu.TribunePager;
import com.readtribune.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class TribuneItem extends Activity {
	private TextView use_title;
	private ImageView use_head;
	private TextView use_id;
	private TextView use_date;
	private TextView show_content;
	private ImageView show_img;
	private ListView mlistview;
	private ImageView pinglun_head_img;
	private EditText input_cotent;
	private Button btn_send;
	private listAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tribune_item);
		initView();
		tribuneData date = getIntent().getParcelableExtra(TribunePager.VAL_KEY);
		use_title.setText(date.getTribuneTitle());
		use_id.setText(date.getTribuneAthor());
		show_img.setImageResource(date.getTribuneImage());
		mlistview = (ListView) findViewById(R.id.tribune_item_listview);
		mAdapter = new listAdapter();
		mlistview.setFocusable(false);
		mlistview.setAdapter(mAdapter);
	}
	private class listAdapter extends BaseAdapter{
		int[] a = new int[20];
		int h = 1;
		 public listAdapter() {
			 super();
			 for (int i = 0; i < a.length; i++) {
				h =h + 1;
				a[i] = h;
			}
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return a.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return a[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return a[position];
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(TribuneItem.this).inflate(R.layout.tribune_item_listview_item, null);
			}
			//ImageView head_img = (ImageView) convertView.findViewById(R.id.tribune_item_listview_item_use_head_);
			TextView use_id = (TextView) convertView.findViewById(R.id.tribune_item_listview_item_use_id);
			use_id.setText("评论用户#" + a[position]);
			TextView number_show = (TextView) convertView.findViewById(R.id.tribune_item_listview_item_use_number);
			number_show.setText(a[position] + "楼");
			TextView content_show = (TextView) convertView.findViewById(R.id.tribune_item_listview_item_show_content);
			content_show.setText("显示评论内容## " + a[position]);
			return convertView;
		}
		
	}

	private void initView() {
		use_title = (TextView) findViewById(R.id.tribune_item_title);
		use_head = (ImageView) findViewById(R.id.tribune_item_use_head);
		use_id = (TextView) findViewById(R.id.tribune_item_use_id);
		use_date = (TextView) findViewById(R.id.tribune_item_use_date);
		show_content = (TextView) findViewById(R.id.tribune_item_use_content);
		show_img = (ImageView) findViewById(R.id.tribune_item_use_img);
		pinglun_head_img = (ImageView) findViewById(R.id.tribune_item_use_head_img);
		input_cotent = (EditText) findViewById(R.id.tribune_item_pinglun_content);
		btn_send = (Button) findViewById(R.id.tribune_item_pinglun_send);
	}
}
