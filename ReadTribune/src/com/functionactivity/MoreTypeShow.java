package com.functionactivity;

import java.util.ArrayList;

import com.datamodel.showDataMore;
import com.readtribune.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MoreTypeShow extends Activity {
	private GridView gridview;
	private MoreTypeShowAdapter madapter;
	private int[] images;
	private String[] id;
	private int numShowD = 50;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.more_type_show);
		images = new int[numShowD];
		id = new String[numShowD];
		for (int i = 0; i < numShowD; i++) {
			images[i] = R.drawable.ic_launcher;
			id[i] = "ÊéÃû" + i;
		}
		gridview = (GridView) findViewById(R.id.more_type_show);
		madapter = new MoreTypeShowAdapter(MoreTypeShow.this, images, id);
		gridview.setAdapter(madapter);

	}

	private class MoreTypeShowAdapter extends BaseAdapter {

		private ArrayList<showDataMore> showMore = new ArrayList<showDataMore>();
		private Context context;

		public MoreTypeShowAdapter(Context context, int[] images, String[] ids) {
			this.context = context;
			for (int i = 0; i < ids.length; i++) {
				showDataMore showdatamore = new showDataMore();
				showdatamore.setImage(images[i]);
				showdatamore.setId(ids[i]);
				showMore.add(showdatamore);
			}

		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return showMore.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return showMore.get(position);
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
				convertView = LayoutInflater.from(context).inflate(R.layout.more_type_show_item, null);
			}
			showDataMore showdata = showMore.get(position);
			ImageView img = (ImageView) convertView.findViewById(R.id.more_type_img);
			img.setImageResource(showdata.getImage());
			TextView txt = (TextView) convertView.findViewById(R.id.more_type_txt);
			txt.setText(showdata.getId());
			return convertView;
		}

	}
}
