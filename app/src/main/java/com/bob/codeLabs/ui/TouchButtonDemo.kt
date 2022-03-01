package com.bob.codeLabs.ui

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.Button

/**
 * created by cly on 2022/2/9
 */
@SuppressLint("AppCompatCustomView")
class TouchButtonDemo : Button {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
//        Logger.d(event)
        Log.d("@cly", event.toString())
        return super.dispatchTouchEvent(event)
    }

}