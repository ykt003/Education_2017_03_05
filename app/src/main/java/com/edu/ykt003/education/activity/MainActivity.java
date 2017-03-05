package com.edu.ykt003.education.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edu.ykt003.education.Bean.CardBean;
import com.edu.ykt003.education.Bean.VideBean;
import com.edu.ykt003.education.R;
import com.edu.ykt003.education.adapter.GlideImageLoader;
import com.edu.ykt003.education.adapter.XRecyclerViewAdapter;
import com.edu.ykt003.education.adapter.XRecyclerViewAdapter.OnItemClickListener;
import com.edu.ykt003.education.config.SystemConfig;
import com.edu.ykt003.education.util.ShowToast;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private XRecyclerView mRecyclerView;
    private View header;
    private XRecyclerViewAdapter mAdapter;
    private Banner banner;
    private ArrayList<CardBean> listData;
    private List<String> images;
    private List<String> titles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        setRecyclerView();
        getBannerData();
        initBanner();
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView(){
        mRecyclerView = (XRecyclerView)this.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        //设置样式
        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.Pacman);
        mRecyclerView.setArrowImageView(R.mipmap.iconfont_downgrey);
        //添加header
        header =   LayoutInflater.from(this).inflate(R.layout.recyclerview_header, (ViewGroup)findViewById(android.R.id.content),false);
        mRecyclerView.addHeaderView(header);
        //添加自定义的分隔线
        //mRecyclerView.addItemDecoration(new CustomDecoration(this, CustomDecoration.VERTICAL_LIST));
    }

    /**
     * 设置XRecyclerView
     */
    private void setRecyclerView(){
        listData = new ArrayList<>();
        mAdapter = new XRecyclerViewAdapter(this,listData);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new MyOnItemClickListener());
        mRecyclerView.setLoadingListener(new MyLoadingListener());
    }

    /**
     * 获取Banner数据
     */
    private void getBannerData(){
        String url1="http://file01.16sucai.com/d/file/2013/0618/20130618100511487.jpg";
        String url2="http://img39.51tietu.net/pic/2017-011003/20170110030923zgwnujrdwlu107946.jpg";
        String url3="http://c.hiphotos.baidu.com/zhidao/pic/item/9c16fdfaaf51f3de869cd51592eef01f3a297990.jpg";
        images= new ArrayList<>();
        images.add(url1);
        images.add(url2);
        images.add(url3);
        titles= new ArrayList<>();
        titles.add("VideoActivity");
        titles.add("VideoIjkPlayerActivity");
        titles.add("VideoJCActivity");
    }

    /**
     * 初始化Banner
     */
    private void initBanner(){
        banner = (Banner) header.findViewById(R.id.banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);//DepthPage
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        //监听Banner
        banner.setOnBannerListener(new MyOnBannerListener());
    }

    /**
     * 对Banner的Item点击事件监听
     */
    private class MyOnBannerListener implements OnBannerListener{
        @Override
        public void OnBannerClick(int position) {
            if(position == 0){
                ShowToast.Short("banner" + position);
                startActivity(new Intent(MainActivity.this,VideoActivity.class));
            }else if(position ==1){
                ShowToast.Short("banner" + position);
                startActivity(new Intent(MainActivity.this,VideoIjkPlayerActivity.class));
            }else if(position == 2){
                ShowToast.Short("banner" + position);
                startActivity(new Intent(MainActivity.this,VideoJCActivity.class));
            }
        }
    }
    /**
     * 对RecyclerView 的Item 中的子控件监听
     */
    private class MyOnItemClickListener implements OnItemClickListener{
        @Override
        public void OnItemClickImg(View view, int position) {
            if (view != null)
                ShowToast.Short("img");
        }
        @Override
        public void OnItemClickZan(View view, int position) {
            if (view != null)
                ShowToast.Short("zan");
        }
        @Override
        public void OnItemClickPing(View view, int position) {
            if (view != null)
                ShowToast.Short("ping");
        }
        @Override
        public void OnItemClickShare(View view, int position) {
            if (view != null)
                ShowToast.Short("share");
        }
    }

    /**
     * 对RecyclerView 下拉刷新/上滑更多的监听事件
     */
    private class  MyLoadingListener implements XRecyclerView.LoadingListener{
        @Override
        public void onRefresh() {
           new Handler().postDelayed(new Runnable(){
                public void run() {
                    listData.clear();
                    for(int i = 0; i < 15 ;i++){
                        CardBean cardBean = new CardBean();
                        VideBean videBean = new VideBean();
                        videBean.setVideoUrl(SystemConfig.videoUrlNei_H);
                        videBean.setThumbImageUrl(SystemConfig.picUrlWai);
                        videBean.setTitle("标题"+i);
                        cardBean.setVideBean(videBean);
                        cardBean.setTv01(i+"赞");
                        cardBean.setTv02(i+"评论");
                        cardBean.setTv03(i+"分享");
                        listData.add(cardBean);
                    }
                    mAdapter.notifyDataSetChanged();
                    mRecyclerView.refreshComplete();
                }
            }, 1500);
        }

        @Override
        public void onLoadMore() {
            new Handler().postDelayed(new Runnable(){
                public void run() {
                    int count = mAdapter.getItemCount();
                    for(int i = 0; i < 15 ;i++){

                        CardBean cardBean = new CardBean();
                        VideBean videBean = new VideBean();
                        if (count%2==0){
                            videBean.setVideoUrl(SystemConfig.videoUrlNei_H);
                        }else{
                            videBean.setVideoUrl(SystemConfig.videoUrlNei_V);
                        }
                        videBean.setThumbImageUrl(SystemConfig.picUrlWai);
                        videBean.setTitle(i + count + "标题");
                        cardBean.setVideBean(videBean);
                        cardBean.setTv01(i+ count +"赞");
                        cardBean.setTv02(i+ count +"评论");
                        cardBean.setTv03(i+ count +"分享");
                        listData.add(cardBean);
                    }
                    mAdapter.notifyDataSetChanged();
                    mRecyclerView.loadMoreComplete();
                }
            }, 1500);
        }
    }


}
