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

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n

fun Canvas.drawLineCenterSquare(scale : Float, w : Float, h : Float, paint : Paint) {
    val size : Float = Math.min(w, h) / sizeFactor
    val sc1 : Float = scale.divideScale(0, parts)
    val sc2 : Float = scale.divideScale(1, parts)
    val sc3 : Float = scale.divideScale(2, parts)
    save()
    translate(w / 2, h / 2)
    for (j in 0..3) {
        val y : Float = size * 0.5f * sc2
        val upSize : Float = size * (1 - j % 2)  + size * (j % 2)* sc2
        save()
        translate((-w / 2 - size) * (1 - sc1), 0f)
        rotate(90f * j)
        drawLine(-upSize / 2 + size * sc3, y, upSize / 2, y, paint)
        restore()
    }
    restore()
}

fun Canvas.drawLCSNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = colors[i]
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    drawLCSNode(i, scale, paint)
}