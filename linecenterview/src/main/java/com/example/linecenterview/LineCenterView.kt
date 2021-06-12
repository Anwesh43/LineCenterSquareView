package com.example.linecenterview

import android.view.View
import android.content.Context
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.view.MotionEvent
import android.app.Activity

val colors : Array<Int> = arrayOf(
    "#f44336",
    "#01579B",
    "#00C853",
    "#FFC107",
    "#2962FF"
).map {
    Color.parseColor(it)
}.toTypedArray()
val parts : Int = 3
val strokeFactor : Float = 90f
val sizeFactor : Float = 3.9f
val delay : Long = 20
val scGap : Float = 0.02f / parts
val backColor : Int = Color.parseColor("#BDBDBD")
