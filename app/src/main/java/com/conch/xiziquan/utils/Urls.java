package com.conch.xiziquan.utils;

/**
 * Created by jiansion on 2016/4/18.
 */
public class Urls {

    //首页数据,第一屏数据
    public final static String INDEX_NEWS = "http://mobile.xizi.com/server2/index.php?a=bbs&m=thread&f=newhomehot";

    public final static String INDEXLAST = "http://mobile.xizi.com/server2/index.php?a=bbs&m=thread&f=newhomemorehot";

    //跳到详情页
    public final static String CONTENTURL = "http://bbs.xizi.com/read.php?tid=$&mobile=1&client=1&page=1&ordertype=asc&toread=1";


    //论坛板块item
    public final static String FORUMITEMURL = "http://mobile.xizi.com/server2/index.php?a=bbs&m=thread&f=allthread&fid=$&page=1&ordertype=0";

    //活动版块
    public final static String ACTIVITEURL = "http://mobile.xizi.com/server2/index.php?a=bbs&m=activity&f=newactivity";

    //各项活动的链接 替换 typeid
    public final static String ACTIVITECONTENTURL = "http://mobile.xizi.com/server2/index.php?a=bbs&m=activity&f=newactivitylist&typeid=$&page=1";


    //搜索的Url,将美元符号替换为搜索内容
    public final static String SEARCHURL = "http://mobile.xizi.com/server2/index.php?a=bbs&m=thread&f=search&count=0&keyword=$";


}
