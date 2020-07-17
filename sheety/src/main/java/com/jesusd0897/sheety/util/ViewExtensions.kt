package com.jesusd0897.sheety.util

import android.view.View

fun View.setSafeOnClickListener(onSafeClick: ((View) -> Unit)?) {
    val safeClickListener = SafeClickListener {
        if (onSafeClick != null) onSafeClick(it)
    }
    setOnClickListener(if (onSafeClick != null) safeClickListener else null)
}

fun View.setSafeOnLongClickListener(onSafeLongClick: ((View) -> Unit)?): Boolean {
    val safeClickListener = SafeLongClickListener {
        if (onSafeLongClick != null) onSafeLongClick(it)
    }
    setOnLongClickListener(if (onSafeLongClick != null) safeClickListener else null)
    return true
}

