package com.c.news;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;


public class PrefrenceServices {
    private static final String isFirstTime = "isFirstTime";
    private static final String loginStatus = "loginStatus";
    private static final String VideoURL = "VideoURL";
    private static final String USERId = "USERId";
    private static final String SessionId = "SessionId";
    private static final String HOMESLIDER = "HOMESLIDER";
    private static final String USERNAME = "USERNAME";
    private static final String LCatID = "LCatID";
    private static final String ADD = "ADD";
    private static final String DownloadOffline = "DownloadOffline";
    private static final String FCM_TOKEN = "FCM_TOKEN";
    private static final String TopTrendingData = "TopTrendingData";
    private static final String RecentlyData = "RecentlyData";
    private static final String CatVideoData = "CatVideoData";
    private static final String Recently_Viewed = "Recently_Viewed";
    private static final String VideosPromotionData = "VideosPromotionData";
    private static final String RelatedVideosCategory = "RelatedVideosCategory";
    private static final String SubscribeVideosData = "SubscribeVideosData";
    private static final String DeviceImei = "DeviceImei";
    private static final String AccessCode = "AccessCode";
    private static final String AutoPlay = "AutoPlay";
    private static final String CITY = "CITY";
    private static final String STATE = "STATE";
    private static final String latitude = "latitude";
    private static final String longitude = "longitude";
    private static final String ACTIVE = "ACTIVE";
    private static final String COUNTRY = "COUNTRY";
    private static final String AreaAddress = "AreaAddress";
    private static final String PINCODE = "PINCODE";
    private static final String IsPrivacyOn = "IsPrivacyOn";
    private static final String Notification = "Notification";
    private static final String HomePage = "HomePage";

    private static final String PREFS_NAME = "PrimeTimeMagnet";
    @SuppressLint("StaticFieldLeak")
    private static PrefrenceServices mSingleton = new PrefrenceServices();
    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    private PrefrenceServices() {
    }

    public static PrefrenceServices instance() {
        return mSingleton;
    }

    public static PrefrenceServices getInstance() {
        return mSingleton;
    }

    public static void init(Context context) {
        mContext = context;
    }

    private SharedPreferences getPrefs() {
        return mContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public boolean getIsFirstTime() {
        return getPrefs().getBoolean(isFirstTime, false);
    }

    public void setIsFirstTime(boolean id) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putBoolean(isFirstTime, id);
        editor.apply();
    }

    public boolean getLoginStatus() {
        return getPrefs().getBoolean(loginStatus, false);
    }

    public void setLoginStatus(boolean status) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putBoolean(loginStatus, status);
        editor.apply();
    }

    public boolean getAutoPlayStatus() {
        return getPrefs().getBoolean(AutoPlay, false);
    }

    public void setAutoPlayStatus(boolean id) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putBoolean(AutoPlay, id);
        editor.apply();
    }

    public boolean getNotification() {
        return getPrefs().getBoolean(Notification, true);
    }

    public void setNotification(boolean notifi) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putBoolean(Notification, notifi);
        editor.apply();
    }

    public String getUserId() {
        return getPrefs().getString(USERId, "");
    }

    public void setUserId(String UserId) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(USERId, UserId);
        editor.apply();
    }

    public String getDeviceImeiId() {
        return getPrefs().getString(DeviceImei, "");
    }

    public void setDeviceImeiId(String Imei) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(DeviceImei, Imei);
        editor.apply();
    }

    public String getUserName() {
        return getPrefs().getString(USERNAME, "");
    }

    public void setUserNamed(String UserName) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(USERNAME, UserName);
        editor.apply();
    }

    public String getUserAdd() {
        return getPrefs().getString(ADD, "");
    }

    public void setUserAdd(String UserAdd) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(ADD, UserAdd);
        editor.apply();
    }

    public String getLastCatID() {
        return getPrefs().getString(LCatID, "");
    }

    public void setLastCatID(String LastCat) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(LCatID, LastCat);
        editor.apply();
    }

    public String getUserImage() {
        return getPrefs().getString(SessionId, "");
    }

    public void setUserImage(String Sessionid) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(SessionId, Sessionid);
        editor.apply();
    }

    public String getHomeSlider() {
        return getPrefs().getString(HOMESLIDER, "");
    }

    public void setHomeSlider(String id) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(HOMESLIDER, id);
        editor.apply();
    }

    public String getFcmToken() {
        return getPrefs().getString(FCM_TOKEN, "");
    }

    public void saveFcmToken(String fcmToken) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(FCM_TOKEN, fcmToken);
        editor.apply();
    }

    public String getDownloadOfflineData() {
        return getPrefs().getString(DownloadOffline, "");
    }

    public void setDownloadOfflineData(String Download) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(DownloadOffline, Download);
        editor.apply();
    }

    public String getTopTrendingData() {
        return getPrefs().getString(TopTrendingData, "");
    }

    public void setTopTrendingData(String TopTrending) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(TopTrendingData, TopTrending);
        editor.apply();
    }

    public String getHomePageData() {
        return getPrefs().getString(HomePage, "");
    }

    public void setHomePageData(String home) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(HomePage, home);
        editor.apply();
    }

    public String getRecentlyData() {
        return getPrefs().getString(RecentlyData, "");
    }

    public void setRecentlyData(String Recently) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(RecentlyData, Recently);
        editor.apply();
    }

    public String getCatVideoData() {
        return getPrefs().getString(CatVideoData, "");
    }

    public void setCatVideoData(String CatVideo) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(CatVideoData, CatVideo);
        editor.apply();
    }

    public String getRecentlyViewedVideosData() {
        return getPrefs().getString(Recently_Viewed, "");
    }

    public void setRecentlyViewedVideosData(String RecentlyViewed) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(Recently_Viewed, RecentlyViewed);
        editor.apply();
    }

    public String getVideosPromotionData() {
        return getPrefs().getString(VideosPromotionData, "");
    }

    public void setVideosPromotionData(String VideosPromotion) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(VideosPromotionData, VideosPromotion);
        editor.apply();
    }

    public String getRelatedVideosCategoryData() {
        return getPrefs().getString(RelatedVideosCategory, "");
    }

    public void setRelatedVideosCategoryData(String RelatedVideos) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(RelatedVideosCategory, RelatedVideos);
        editor.apply();
    }

    public String getSubscribeVideosData() {
        return getPrefs().getString(SubscribeVideosData, "");
    }

    public void setSubscribeVideosData(String Subscribe) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(SubscribeVideosData, Subscribe);
        editor.apply();
    }

    public String getAccessCode() {
        return getPrefs().getString(AccessCode, "");
    }

    public void setAccessCode(String Access) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(AccessCode, Access);
        editor.apply();
    }

    public String getCITY() {
        return getPrefs().getString(CITY, "");
    }

    public void setCITY(String CurrentCity) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(CITY, CurrentCity);
        editor.apply();
    }

    public String getSTATE() {
        return getPrefs().getString(STATE, "");
    }

    public void setSTATE(String CurrentCity) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(STATE, CurrentCity);
        editor.apply();
    }

    public String getlatitude() {
        return getPrefs().getString(latitude, "");
    }

    public void setlatitude(String lat) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(latitude, lat);
        editor.apply();
    }

    public String getlongitude() {
        return getPrefs().getString(longitude, "");
    }

    public void setlongitude(String lon) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(longitude, lon);
        editor.apply();
    }

    public String getCountry() {
        return getPrefs().getString(COUNTRY, "");
    }

    public void setCountry(String country) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(COUNTRY, country);
        editor.apply();
    }

    public String getAreaAddress() {
        return getPrefs().getString(AreaAddress, "");
    }

    public void setAreaAddress(String Address) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(AreaAddress, Address);
        editor.apply();
    }

    public String getPinCode() {
        return getPrefs().getString(PINCODE, "");
    }

    public void setPinCode(String pin_code) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(PINCODE, pin_code);
        editor.apply();
    }

    public String getActive() {
        return getPrefs().getString(ACTIVE, "");
    }

    public void setActive(String activeuser) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString(ACTIVE, activeuser);
        editor.apply();
    }

    public boolean getIsPrivacyOn() {
        return getPrefs().getBoolean(IsPrivacyOn, false);
    }

    public void setIsPrivacyOn(boolean Privacy) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putBoolean(IsPrivacyOn, Privacy);
        editor.apply();
    }


}


