package com.danteandroid.transformviewpager

import android.content.Context

/**
 * @author Dante
 * 2019-11-07
 */
object UiUtils {

    fun getScreenWidth(context: Context): Int {
        return context.getResources().getDisplayMetrics().widthPixels
    }

}