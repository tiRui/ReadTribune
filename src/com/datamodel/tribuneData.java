package com.datamodel;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class tribuneData implements Parcelable {

	private String tribuneTitle;
	private int tribuneImage;
	private String tribuneAthor;

	public String getTribuneTitle() {
		return tribuneTitle;
	}

	public void setTribuneTitle(String tribuneTitle) {
		this.tribuneTitle = tribuneTitle;
	}

	public int getTribuneImage() {
		return tribuneImage;
	}

	public void setTribuneImage(int tribuneImage) {
		this.tribuneImage = tribuneImage;
	}

	public String getTribuneAthor() {
		return tribuneAthor;
	}

	public void setTribuneAthor(String tribuneAthor) {
		this.tribuneAthor = tribuneAthor;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static final Parcelable.Creator<tribuneData> CREATOR = new Creator<tribuneData>() {
		public tribuneData createFromParcel(Parcel source) {
			tribuneData mtribuneData = new tribuneData();
			mtribuneData.tribuneAthor = source.readString();
			mtribuneData.tribuneTitle = source.readString();
			mtribuneData.tribuneImage = source.readInt();
			return mtribuneData;
		}

		public tribuneData[] newArray(int size) {
			return new tribuneData[size];
		}
	};

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(tribuneAthor);
		dest.writeString(tribuneTitle);
		dest.writeInt(tribuneImage);
	}
}
