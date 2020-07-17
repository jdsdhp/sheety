package com.jesusd0897.sheety

import android.view.View
import androidx.annotation.DrawableRes
import com.jesusd0897.sheety.util.SafeClickListener

data class SheetyItem(
    var label: String,
    @DrawableRes var icon: Int? = null,
    var clickListener: View.OnClickListener? = null
)