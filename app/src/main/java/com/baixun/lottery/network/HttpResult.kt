package com.baixun.lottery.network

import com.baixun.lottery.bean.SplitPointsBean

/**
 * Description 描述
 * Created by 张伟明 on 2018/2/2
 */
class HttpResult {

    class BaseResponse (var code: String?,var msg: String?)

    class LoginResponse(var code: Int?,var msg: String?,var data: UserBean?)

    class RegisterResponse(var code: Int?,var msg: String?,var data: UserBean?)

    class SplitPointsResponse(var code: Int?,var msg: String?,var data: SplitPointsBean?)
//    class HomeResponse(var code: String?, var msg: String?,
//                       var listNavigation: ArrayList<NavigationBean?>,
//                       var listResourcesAge: List<ResourcesAgeBean?>,
//                       var listResourcesHot: List<ResourcesHotBean?>,
//                       var listResourcesBook: List<ResourcesHotBean?>,
//                       var listResourcesGame: List<ResourcesHotBean?>,
//                       var listPostsInfoHot: ArrayList<PostsInfoHotBean?>,
//                       var listActivityInfoHot: List<ActivityInfoHotBean?>)
}
