package com.edu.ykt003.education.Bean;

/**
 * 
 * @author YL
 * @date 2017/2/28 10:51
 */
public class CardBean {

    private Object object;
    private String tv01;
    private String tv02;
    private String tv03;
    private VideBean videBean;


    public VideBean getVideBean() {
        return videBean;
    }

    public void setVideBean(VideBean videBean) {
        this.videBean = videBean;
    }

    public Object getObject() {

        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getTv01() {
        return tv01;
    }

    public void setTv01(String tv01) {
        this.tv01 = tv01;
    }

    public String getTv02() {
        return tv02;
    }

    public void setTv02(String tv02) {
        this.tv02 = tv02;
    }

    public String getTv03() {
        return tv03;
    }

    public void setTv03(String tv03) {
        this.tv03 = tv03;
    }
}
