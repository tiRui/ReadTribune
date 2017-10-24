package com.datamodel;

import android.os.Parcel;
import android.os.Parcelable;

public class showData implements Parcelable {
	private int Img;
	private String Title;
	private String Word;
	private String Author;

	public int getImg() {
		return Img;
	}

	public void setImg(int img) {
		Img = img;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getWord() {
		return Word;
	}

	public void setWord(String word) {
		Word = word;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static final Parcelable.Creator<showData> CREATOR = new Creator<showData>() {
		public showData createFromParcel(Parcel source) {
			showData mshowData = new showData();
			mshowData.Title = source.readString();
			mshowData.Word = source.readString();
			mshowData.Author = source.readString();
			mshowData.Img = source.readInt();
			return mshowData;
		}

		public showData[] newArray(int size) {
			return new showData[size];
		}
	};

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(Title);
		dest.writeString(Word);
		dest.writeString(Author);
		dest.writeInt(Img);
	}
}
