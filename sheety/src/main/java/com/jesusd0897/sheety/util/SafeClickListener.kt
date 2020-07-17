package com.jesusd0897.sheety.util

import android.os.SystemClock
import android.view.View

class SafeClickListener(
    private var defaultInterval: Int = 500,
    private val onSafeCLick: (View) -> Unit
) : View.OnClickListener {

    private var lastTimeClicked: Long = 0

    override fun onClick(v: View) {
        if (SystemClock.elapsedRealtime() - lastTimeClicked < defaultInterval) return
        lastTimeClicked = SystemClock.elapsedRealtime()
        onSafeCLick(v)
    }

}

class SafeLongClickListener(
    private var defaultInterval: Int = 1000,
    private val onSafeCLick: (View) -> Unit
) : View.OnLongClickListener {

    private var lastTimeClicked: Long = 0

    override fun onLongClick(v: View): Boolean {
        if (SystemClock.elapsedRealtime() - lastTimeClicked < defaultInterval) return false
        lastTimeClicked = SystemClock.elapsedRealtime()
        onSafeCLick(v)
        return true
    }

}