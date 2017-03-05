package com.edu.ykt003.education.config;

/**
 * 系统参数配置
 * @author YL
 * @date 2017/2/28 9:15
 */
public class SystemConfig {

    public static final String picUrlWai = "http://file01.16sucai.com/d/file/2013/0618/20130618100511487.jpg";
    public static final String videoUrlNei_H = "http://192.168.169.18:8000/test_video.mp4";
    public static final String videoUrlNei_V = "http://192.168.169.18:8000/sunshine_animation.mp4";
    public static final String videoUrlWai = "http://www.modrails.com/videos/passenger_nginx.mov";

    /**
     * 是否需要打印bug
     */
    public static boolean isDebug = true;
    /**
     * 异常信息文件保存路径
     */
    public static String creash_path="/sdcard/Education/";
    
}
