package com.functionactivity;

import com.datamodel.MyOwnAdapter;
import com.readtribune.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class MoreContentShow extends Activity {
	private GridView gridview;
	private MyOwnAdapter madapter;
	private int[] images;
	private String[] titles;
	private String[] descr;
	private String[] authors;
	private int numShow = 15;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.more_content_show);
		images = new int[numShow];
		titles = new String[numShow];
		descr = new String[numShow];
		authors = new String[numShow];
		for (int i = 0; i < numShow; i++) {
			images[i] = R.drawable.ic_launcher;
			titles[i] = "����" + i;
			descr[i] = "����" + i;
			authors[i] = "����" + i;
		}
		gridview = (GridView) findViewById(R.id.more_choice);
		madapter = new MyOwnAdapter(images, titles, descr, authors, MoreContentShow.this);
		gridview.setAdapter(madapter);
	}
}
