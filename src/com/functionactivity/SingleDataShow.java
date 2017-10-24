package com.functionactivity;

import com.datamodel.showData;
import com.fragmentmenu.MainPager;
import com.readtribune.R;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleDataShow extends Activity{
	private boolean tag = true;
	private ImageView img ;
	private TextView title;
	private TextView author;
	private TextView descr;
	private Button show_hide;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.single_data_show);
	showData dat = new showData();
	dat = getIntent().getParcelableExtra(MainPager.KEY);
	img = (ImageView) findViewById(R.id.single_show_img);
	title = (TextView) findViewById(R.id.single_show_title);
	author = (TextView) findViewById(R.id.single_show_author);
	descr = (TextView) findViewById(R.id.single_show_descr);
	show_hide = (Button) findViewById(R.id.single_descr_show_hide);
	img.setImageResource(dat.getImg());
	title.setText(dat.getTitle());
	author.setText(dat.getAuthor());
	descr.setText(dat.getWord());
	show_hide.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if (tag) {
				tag = false;
				descr.setEllipsize(null);
				descr.setSingleLine(false);
				show_hide.setText("Òþ²Ø");
			}
			else{
				tag = true;
				descr.setMaxLines(2);
				descr.setEllipsize(TruncateAt.END);
				show_hide.setText("Õ¹¿ª");
			}
		}
	});
}
}
