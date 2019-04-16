package test.zimad.mypets.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PetInfo implements Parcelable {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("title")
    @Expose
    private String title;

    protected PetInfo(Parcel in) {
        url = in.readString();
        title = in.readString();
    }

    public static final Creator<PetInfo> CREATOR = new Creator<PetInfo>() {
        @Override
        public PetInfo createFromParcel(Parcel in) {
            return new PetInfo(in);
        }

        @Override
        public PetInfo[] newArray(int size) {
            return new PetInfo[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(title);
    }
}