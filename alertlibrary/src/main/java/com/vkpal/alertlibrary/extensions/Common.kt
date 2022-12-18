package com.vkpal.alertlibrary.extensions

import android.view.View

/**
 * Create by Vinod Kumar Pal on 17-12-2022
 *
 * This will be used for showing and hiding the views.
 * */

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.invisible(){
    this.visibility=View.INVISIBLE
}