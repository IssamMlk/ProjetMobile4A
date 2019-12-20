package com.example.projetmobile4a.View;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetmobile4a.R;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    List<YoutubeVideos> youtubeVideosList;

    public VideoAdapter(){

    }

    public VideoAdapter(List<YoutubeVideos> youtubeVideosList){
        this.youtubeVideosList=youtubeVideosList;
    }

    @NonNull
    @Override
    public VideoAdapter.VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_view, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {

        holder.videoWeb.loadData(youtubeVideosList.get(position).getVideoUrl(),"text/html","utf-8");

    }

    @Override
    public int getItemCount() {
        return youtubeVideosList.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder{
        WebView videoWeb;

        public VideoViewHolder(View itemView){
            super(itemView);

            videoWeb = (WebView) itemView.findViewById(R.id.VideoWebView);

            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient(){



            });
        }
    }
}
