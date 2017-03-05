package com.edu.ykt003.education.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.edu.ykt003.education.R;
import com.edu.ykt003.education.config.SystemConfig;
import com.edu.ykt003.education.util.VideoUtils;

import java.io.ByteArrayOutputStream;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by ykt00 on 2017/3/2.
 */

public class VideoJCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiecaoplayer);

        JCVideoPlayerStandard jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.videoplayer);
        jcVideoPlayerStandard.setUp(SystemConfig.videoUrlNei_V,
                JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "测试视频");
        Bitmap bitmap = VideoUtils.createVideoThumbnail(SystemConfig.videoUrlNei_V,300,180);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] bytes=baos.toByteArray();
        Glide.with(this).load(bytes).into(jcVideoPlayerStandard.thumbImageView);
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
