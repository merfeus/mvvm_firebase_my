package com.example.mvvm_firebase.utils

import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.mvvm_firebase.R
import com.google.android.material.snackbar.Snackbar

fun FragmentActivity.replaceView(fragment: Fragment, @IdRes containerId: Int = R.id.container) {
    supportFragmentManager.beginTransaction()
        .replace(containerId, fragment)
        .commitNow()
}

//fun FragmentActivity.snackbar(view: View, @StringRes resId: Int) {
//    setupSnackbar(view, resId, R.color.purple_200).apply {
//        show()
//    }
//}
//
//fun setupSnackbar(v: View, @StringRes resId: Int, @ColorRes color: Int) : Snackbar {
//    return Snackbar.make(v, resId, Snackbar.LENGTH_LONG).apply {
//        view.setBackgroundColor(ContextCompat.getColor(context, color))
//        view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text).apply {
//            gravity = Gravity.CENTER
//            textAlignment = View.TEXT_ALIGNMENT_CENTER
//        }
//    }
//
//}

