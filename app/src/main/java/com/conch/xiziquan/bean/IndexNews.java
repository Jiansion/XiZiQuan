package com.conch.xiziquan.bean;

import java.util.List;

/**
 * Created by conch on 2016/10/22.
 */

public class IndexNews {


    /**
     * subject : 惠州可以直飞南宁啦！
     * tid : 4011558
     */

    private List<HeadlineBean> headline;
    /**
     * image : http://bbsimg.xizi.com/attachments/pushpic/20161021004929.jpg
     * pushtime : 1477010969
     * tid : 4012199
     * title : 鹅城墙头尽种木芙蓉，秋天嫣然繁花似锦绣
     * url : http://bbs.xizi.com/thread-4012199-1-1.html
     */

    private List<HotimageBean> hotimage;
    /**
     * author : 省思中成长
     * forumtwoname : 惠城
     * hits : 14
     * postdate : 5分钟前
     * subject : 无语！这“海马哥”居然把红绿灯都吹歪了
     * tid : 4014473
     */

    private List<PushdataBean> pushdata;

    public List<HeadlineBean> getHeadline() {
        return headline;
    }

    public void setHeadline(List<HeadlineBean> headline) {
        this.headline = headline;
    }

    public List<HotimageBean> getHotimage() {
        return hotimage;
    }

    public void setHotimage(List<HotimageBean> hotimage) {
        this.hotimage = hotimage;
    }

    public List<PushdataBean> getPushdata() {
        return pushdata;
    }

    public void setPushdata(List<PushdataBean> pushdata) {
        this.pushdata = pushdata;
    }

    public static class HeadlineBean {
        private String subject;
        private String tid;

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }
    }

    public static class HotimageBean {
        private String image;
        private String pushtime;
        private String tid;
        private String title;
        private String url;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getPushtime() {
            return pushtime;
        }

        public void setPushtime(String pushtime) {
            this.pushtime = pushtime;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class PushdataBean {
        private String author;
        private String forumtwoname;
        private String hits;
        private String postdate;
        private String subject;
        private String tid;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getForumtwoname() {
            return forumtwoname;
        }

        public void setForumtwoname(String forumtwoname) {
            this.forumtwoname = forumtwoname;
        }

        public String getHits() {
            return hits;
        }

        public void setHits(String hits) {
            this.hits = hits;
        }

        public String getPostdate() {
            return postdate;
        }

        public void setPostdate(String postdate) {
            this.postdate = postdate;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }
    }
}
