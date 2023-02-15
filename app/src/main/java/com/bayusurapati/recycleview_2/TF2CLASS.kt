package com.bayusurapati.recycleview_2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TF2CLASS (
    var name: String = "",
    var from: String = "",
    var photo: Int? = null
) :Parcelable