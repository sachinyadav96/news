package com.c.news.adapter;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.c.news.R;
import com.c.news.WebViewActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<HashMap<String, String>> mItems;
    private ProgressDialog pDialog;

    public NewsAdapter(Context context, ArrayList<HashMap<String, String>> mItems) {
        this.context = context;
        this.mItems = mItems;
        pDialog = new ProgressDialog(context);
        pDialog.setCancelable(false);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_top_news, parent, false);
        return new NewsAdapter.MyViewHolder(itemView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final HashMap<String, String> home = mItems.get(position);
        holder.Id = (home.get("id"));
        RequestOptions requestOptions1 = new RequestOptions().placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background);
        Glide.with(context).setDefaultRequestOptions(requestOptions1).load("https://www.theindianwire.com/wp-content/uploads/2018/11/cashrich.png").into(holder.ImgVideoThumbnail);
        holder.main.setOnClickListener(view1 -> {
            context.startActivity(new Intent(context, WebViewActivity.class)
                    .putExtra("url", "https://cashrich.com/")
                    .putExtra("title", "Cash Rich")
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_Title, txt_msg_count;
        LinearLayout main;
        String Id = "";
        ImageView ImgVideoThumbnail;
        TextView txt_view_count;
        TextView txt_likes;
        CardView card_view;

        MyViewHolder(View view) {
            super(view);
            txt_Title = view.findViewById(R.id.txt_Title);
            main = view.findViewById(R.id.main);
            ImgVideoThumbnail = view.findViewById(R.id.ImgVideoThumbnail);
            txt_view_count = view.findViewById(R.id.txt_view_count);
            txt_likes = view.findViewById(R.id.txt_likes);
            txt_msg_count = view.findViewById(R.id.txt_msg_count);
            card_view = view.findViewById(R.id.card_view);

        }
    }

}
