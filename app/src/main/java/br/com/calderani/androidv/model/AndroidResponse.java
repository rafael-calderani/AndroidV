package br.com.calderani.androidv.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by logonrm on 21/06/2017.
 */

public class AndroidResponse {

    @SerializedName("android")
    private List<Android> androidList;
    public List<Android> getAndroidList() { return androidList; }
    public void setAndroidList(List<Android> androidList) { this.androidList = androidList; }
}
