package com.baixun.lottery.bean

data class SplitPointsBean(
		var currentTime: String?,
		var nextTime: String?,
		var haveAward: Boolean?,
		var dragons: List<Dragon?>?,
		var winList: List<Win?>?,
		var hotCold: HotCold?,
		var omit: Omit?
)

data class HotCold(
		var x1: List<X?>?,
		var x2: List<X?>?,
		var x3: List<X?>?,
		var x4: List<X?>?,
		var x5: List<X?>?
)

data class X(
		var num: String?,
		var count: String?,
		var hotCold: Any?
)

data class Omit(
		var x1: List<X?>?,
		var x2: List<X?>?,
		var x3: List<X?>?,
		var x4: List<X?>?,
		var x5: List<X?>?
)

data class Dragon(
		var figure: String?,
		var bigType: String?,
		var bigNum: String?,
		var singleType: String?,
		var singleNum: String?
)

data class Win(
		var awardNum: Any?,
		var awarPeriod: String?,
		var isAward: String?,
		var awardTime: String?
)