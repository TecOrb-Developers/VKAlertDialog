package com.vkpal.alertlibrary

import android.app.Activity
import android.graphics.Typeface
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintSet
import com.vkpal.alertlibrary.extensions.invisible
import com.vkpal.alertlibrary.extensions.show
import kotlinx.android.synthetic.main.vkalert_dialog.*

/***
 * Created by Vinod Kumar Pal on 17-12-2022
 *
 * This will be used for creating the Alert Dialog
 * */

class VKAlertDialog {

    companion object {

        private lateinit var layoutInflater: LayoutInflater

        /***
         * This method will be used for inflating the layouts and style for Alert Dialog
         * */
        fun build(
            context: Activity
        ): AlertDialog {
            layoutInflater = LayoutInflater.from(context)
            val alertDialog = AlertDialog.Builder(context, R.style.beautiful_dialog)
                .setView(R.layout.vkalert_dialog)
            val alert: AlertDialog = alertDialog.create()
            alert.show()
            return alert
        }
    }
}

/***
 * Title Properties For Alert Dialog
 * */
fun AlertDialog.title(title: String, fontStyle: Typeface? = null, titleColor: Int = 0): AlertDialog {
    this.title.text = title.trim()
    if (fontStyle != null) {
        this.title.typeface = fontStyle
    }
    if (titleColor != 0) {
        this.title.setTextColor(titleColor)
    }
    this.title.show()
    return this
}

/***
 * Dialog Background properties For Alert Dialog
 * */
fun AlertDialog.background(dialogBackgroundColor: Int? = null): AlertDialog {
    if (dialogBackgroundColor != null) {
        this.mainLayout.setBackgroundResource(dialogBackgroundColor)
    }
    return this
}

/***
 * Positions of Alert Dialog
 * */
fun AlertDialog.position(position: Positions = Positions.BOTTOM): AlertDialog {
    val layoutParams = mainLayout.layoutParams as RelativeLayout.LayoutParams
    if (position == Positions.CENTER) {
        layoutParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
    } else if (position == Positions.BOTTOM) {
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE)
    }
    mainLayout!!.layoutParams = layoutParams
    return this
}

/***
 * Sub Title or Body of Alert Dialog
 * */
fun AlertDialog.subtitle(subtitle: String, fontStyle: Typeface? = null, color: Int = 0): AlertDialog {
    this.subHeading.text = subtitle.trim()
    this.subHeading.show()
    if (fontStyle != null) {
        this.subHeading.typeface = fontStyle
    }
    if (color != 0) {
        this.subHeading.setTextColor(color)
    }
    return this
}

/***
 * Icon of  Alert Dialog
 * */
fun AlertDialog.type(type: Type): AlertDialog {
    when (type) {
        Type.SUCCESS -> {
            this.image.setImageResource(R.drawable.ic_success)
        }
        Type.INFO -> {
            this.image.setImageResource(R.drawable.ic_info)
        }
        Type.ERROR -> {
            this.image.setImageResource(R.drawable.ic_error)
        }
    }
    this.image.show()

    return this
}

/***
 * onPositive Button Properties For Alert Dialog
 *
 * No Need to call dismiss(). It is calling already
 * */
fun AlertDialog.onPositive(text: String, buttonBackgroundColor: Int? = null, textColor: Int? = null, shouldIDismissOnClick: Boolean = true, action: (() -> Unit)? = null): AlertDialog {
    this.yesButton.show()
    if (buttonBackgroundColor != null) {
        this.yesButton.setBackgroundResource(buttonBackgroundColor)
    }
    if (textColor != null) {
        this.yesButton.setTextColor(textColor)
    }
    this.yesButton.text = text.trim()
    this.yesButton.setOnClickListener {
        action?.invoke()
        if (shouldIDismissOnClick) dismiss()
    }
    return this
}

/***
 * onNegative Button Properties For Alert Dialog
 *
 * No Need to call dismiss(). It is calling already
 * */
fun AlertDialog.onNegative(text: String, buttonBackgroundColor: Int? = null, textColor: Int? = null, shouldIDismissOnClick: Boolean = true, action: (() -> Unit)? = null): AlertDialog {
    this.noButton.show()
    this.noButton.text = text.trim()
    if (textColor != null) {
        this.noButton.setTextColor(textColor)
    }
    if (buttonBackgroundColor != null) {
        this.noButton.setBackgroundResource(buttonBackgroundColor)
    }
    this.noButton.setOnClickListener {
        action?.invoke()
        if (shouldIDismissOnClick) dismiss()
    }
    return this
}

/***
 * cancelNegativeButton defines if the cancel button should be displayed
 * */
fun AlertDialog.hideNegativeButton(hide: Boolean = false): AlertDialog {
    if (hide) {
        this.noButton.invisible()
        val constraintSet = ConstraintSet()

        constraintSet.clone(this.mainLayoutButtons)
        constraintSet.connect(R.id.yesButton, ConstraintSet.START, R.id.mainLayoutButtons, ConstraintSet.START, 0)
        constraintSet.applyTo(this.mainLayoutButtons)
    }
    return this
}
