package com.baixun.lottery.utils;


/**
 * 全局常量
 */
public class Constants {

    public static final String PAGE_SIZE = "10";

    public static final String SP_FILENAME = "spFile";
    public static final String TOKEN = "token";
    public static final String USER_ID = "userId";

    public static final  int COUNTDOWN = 88888;

    /**
     * 第三方分享
     */
    public static class otherKey {
        public static final String qqKey = "1106343683";
    }

    public static class WeiXin {
        // 请同时修改 androidmanifest.xml里面，添加调用微信支付的activity里的属性<data
        // android:scheme="wxe9546a8b8614b7c6"/>
        // appid
        public static final String APP_ID = "wxd739dbafa812faf3";
        public static final String AppSecret = "20cad9387619215e52e15a0316fefc51";
        // 商户号
        public static final String MCH_ID = "1489269972";
        // API密钥，在商户平台设置
        public static final String API_KEY = "wuchangredian2017102709365526539";
        // 接收微信支付异步通知回调地址
//        public static final String notify_url = HttpMethods.BASE_URL
//                + "microPaylAction/payWeChat.html";
//        // 微信授权域
//        public static final String scope = "snsapi_userinfo";
//        public static BaseResp resp;// 登录信息
//        public static BaseResp PayResp;// 支付信息
    }

    public static final class Cache {
        public static final String CACHE_PIC_DIRECTORY = "zhimei/thumbs";
        public static final String APP_UPDATE = "zhimei/app";
        public static boolean ISREFRESH = true;

    }
}
