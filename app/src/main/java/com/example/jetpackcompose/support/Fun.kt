package com.example.jetpackcompose.support

import android.content.Context
import android.widget.Toast

fun showToast(context: Context, title: String?) {
    Toast.makeText(context, title, Toast.LENGTH_SHORT).show()
}