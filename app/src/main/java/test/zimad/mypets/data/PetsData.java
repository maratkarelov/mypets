package test.zimad.mypets.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PetsData {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<PetInfo> data = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<PetInfo> getData() {
        return data;
    }

    public void setData(ArrayList<PetInfo> data) {
        this.data = data;
    }

}
