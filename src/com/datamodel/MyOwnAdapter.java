package com.datamodel;

import java.util.ArrayList;
import java.util.List;

import com.readtribune.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyOwnAdapter extends BaseAdapter{
	private Context context;
	private List<showData> showDatas = new ArrayList<showData>();

	public MyOwnAdapter(int[] images, String[] titles, String[] descris, String[] authors, Context context) {
		super();
		this.context = context;
		for (int i = 0; i < authors.length; i++) {
			showData showdata = new showData();
			showdata.setImg(images[i]);
			showdata.setTitle(titles[i]);
			showdata.setWord(descris[i]);
			showdata.setAuthor(authors[i]);
			showDatas.add(showdata);
		}

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return showDatas.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return showDatas.get(position);
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
			convertView = LayoutInflater.from(context).inflate(R.layout.main_show_item, null);
		}
		showData showda = showDatas.get(position);
		ImageView img = (ImageView) convertView.findViewById(R.id.main_show_img);
		img.setImageResource(showda.getImg());
		TextView txt_title = (TextView) convertView.findViewById(R.id.main_show_title);
		txt_title.setText(showda.getTitle());
		TextView txt_descri = (TextView) convertView.findViewById(R.id.main_show_descr);
		txt_descri.setText(showda.getWord());
		TextView txt_author = (TextView) convertView.findViewById(R.id.main_show_author);
		txt_author.setText(showda.getAuthor());
		return convertView;
	}
}
