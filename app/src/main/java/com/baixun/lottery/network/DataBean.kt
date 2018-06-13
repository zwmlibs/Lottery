package com.baixun.lottery.network

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by zwm on 2018/2/2.
 */
@SuppressLint("ParcelCreator")// 用于处理 Lint 的错误提示
@Parcelize
data class ActivityInfoHotBean(
		var id: Int,
		var address: String?,
		var imgUrl: String?,
		var title: String?
) : Parcelable

@SuppressLint("ParcelCreator")
@Parcelize
data class UserBean(
		val nickName: String,
		val loginWay: String,
		val hierarchy: String,
		val type: String,
		val accountBalance: Double,
		val account: String
) : Parcelable
