package com.edu.ykt003.education.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.edu.ykt003.education.Bean.CardBean;
import com.edu.ykt003.education.R;

import java.util.ArrayList;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * XRecyclerView适配器
 * @author YL
 * @date 2017/3/2 9:27
 */
public class XRecyclerViewAdapter extends RecyclerView.Adapter<XRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<CardBean> list;
    private OnItemClickListener onItemClickListener;

    public XRecyclerViewAdapter(Context context, ArrayList<CardBean> list) {
        this.context = context;
        this.list = list;
    }

    /**
     * 创建新View，被LayoutManager所调用
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    /**
     * 将数据与界面进行绑定的操作
     *
     * @param holder
     * @param position
     * @return
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.jcVideoPlayerStandard.setUp(list.get(position).getVideBean().getVideoUrl(),
                JCVideoPlayerStandard.SCREEN_LAYOUT_LIST, list.get(position).getVideBean().getTitle());
       // Bitmap bitmap = VideoUtils.createVideoThumbnail(SystemConfig.videoUrlNei_H,300,200);
        //ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
       // byte[] bytes=baos.toByteArray();

        Glide.with(context)
//                .load(bytes)
                .load(list.get(position).getVideBean().getThumbImageUrl())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher)
                .crossFade()
                .into(holder.jcVideoPlayerStandard.thumbImageView);

        holder.img.setVisibility(View.GONE);
        holder.tv01.setText(list.get(position).getTv01());
        holder.tv02.setText(list.get(position).getTv02());
        holder.tv03.setText(list.get(position).getTv03());

        //如果activity设置了回调
        if (onItemClickListener != null) {

            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.OnItemClickImg(holder.img,position);
                }
            });

            holder.tv01.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.OnItemClickPing(holder.tv01, position);
                }
            });
            holder.tv02.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.OnItemClickShare(holder.tv02, position);
                }
            });
            holder.tv03.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.OnItemClickZan(holder.tv03, position);
                }
            });


        }
    }

    /**
     * 获取数据的数量
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return list.size();
    }
    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    /**
     * 自定义的ViewHolder，持有每个Item的的所有界面元素
     *
     * @author YL
     * @date 2017/2/28 10:57
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView img;
        public TextView tv01;
        public TextView tv02;
        public TextView tv03;
        public JCVideoPlayerStandard jcVideoPlayerStandard;

        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            tv01 = (TextView) itemView.findViewById(R.id.tv01);
            tv02 = (TextView) itemView.findViewById(R.id.tv02);
            tv03 = (TextView) itemView.findViewById(R.id.tv03);
            jcVideoPlayerStandard = (JCVideoPlayerStandard) itemView.findViewById(R.id.videoplayer);
        }
    }

    /**
     * 回调接口
     */
    public interface OnItemClickListener {
        void OnItemClickImg(View view, int position);
        void OnItemClickZan(View view, int position);
        void OnItemClickPing(View view, int position);
        void OnItemClickShare(View view, int position);
    }

    /**
     * 设置监听
     * @param onItemClickListener
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

}
