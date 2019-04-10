package com.c.news;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.c.news.adapter.NewsAdapter;
import com.c.news.coustom.AdvanceDrawerLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MainActivity extends Activity implements View.OnClickListener {
    ImageView menu;
    LinearLayout ll_menu;
    NavigationView nav_view_notification;
    RecyclerView RecyclerViewPromation;
    LinearLayout ll_LogOut;
    private AdvanceDrawerLayout drawer;
    private ProgressDialog pDialog;
    private NewsAdapter HomeFragmentRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        setContentView(R.layout.activity_main);
        menu = findViewById(R.id.menu);
        ll_menu = findViewById(R.id.ll_menu);
        menu.setOnClickListener(this);
        ll_menu.setOnClickListener(this);
        drawer = findViewById(R.id.drawer_layout);
        ll_LogOut = findViewById(R.id.ll_LogOut);
        RecyclerViewPromation = findViewById(R.id.RecyclerViewPromation);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        drawer.setViewScale(Gravity.END, 0.9f);
        drawer.setRadius(Gravity.END, 35);
        drawer.setViewElevation(Gravity.END, 20);

        GridLayoutManager Promation = new GridLayoutManager(this, 1);
        RecyclerViewPromation.setLayoutManager(Promation);
        RecyclerViewPromation.setHasFixedSize(true);
        RecyclerViewPromation.setNestedScrollingEnabled(false);


        nav_view_notification = findViewById(R.id.nav_view_notification);
        getRelatedVideosCategoryData();
        ShowRelatedVideosCategoryData(PrefrenceServices.getInstance().getRelatedVideosCategoryData());
        ll_LogOut.setOnClickListener(this);
    }

    private void getRelatedVideosCategoryData() {
        String url = "http://dummy.restapiexample.com/api/v1/employees";
        Log.e("url", url);
        showpDialog();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, response -> {
            ShowRelatedVideosCategoryData(response);
            hidepDialog();
            PrefrenceServices.getInstance().setRelatedVideosCategoryData(response);
        }, error -> {
            hidepDialog();
            String message = null;
            if (error instanceof NetworkError) {
                message = "Cannot connect to Internet...Please check your connection!";
            } else if (error instanceof ServerError) {
                message = "The server could not be found. Please try again after some time!!";
            } else if (error instanceof AuthFailureError) {
                message = "Cannot connect to Internet...Please check your connection!";
            } else if (error instanceof ParseError) {
                message = "Parsing error! Please try again after some time!!";
            } else if (error instanceof TimeoutError) {
                message = "Connection TimeOut! Please check your internet connection.";
            }
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        });
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void ShowRelatedVideosCategoryData(String response) {
        final ArrayList<HashMap<String, String>> listVideosCategoryData = new ArrayList<>();
        boolean responseSuccess;
        try {
            responseSuccess = true;
            JSONArray jArrayValue = new JSONArray(response);
            for (int i = 0; i < 50; i++) {
                JSONObject jObjectsValue = jArrayValue.getJSONObject(i);
                HashMap<String, String> map = new HashMap<>();
                map.put("id", jObjectsValue.getString("id"));
                listVideosCategoryData.add(map);
            }

        } catch (JSONException e1) {
            e1.printStackTrace();
            responseSuccess = false;
        }
        if (responseSuccess) {
            HomeFragmentRecyclerAdapter = new NewsAdapter(this, listVideosCategoryData);
            RecyclerViewPromation.setAdapter(HomeFragmentRecyclerAdapter);
        }
    }


    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        switch (viewId) {


            case R.id.ll_LogOut:
                drawer.closeDrawer(nav_view_notification);
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("Exit");
                adb.setMessage(("Do you want to Logout!"));
                adb.setPositiveButton("OK", (dialog, which) -> {
                    finish();
                });
                adb.setNegativeButton("CANCEL", (dialog, which) -> dialog.dismiss());
                AlertDialog alert = adb.create();
                alert.show();

                break;


            case R.id.ll_NoArea:
                break;

        }
    }

    private void showpDialog() {
        if (!pDialog.isShowing()) {
            pDialog.show();
            pDialog.setContentView(R.layout.progress_bar);
            Objects.requireNonNull(pDialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        }
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}
