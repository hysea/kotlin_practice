package com.hysea.basic.`object`

class Button {
    fun setOnClickListener(listener: OnClickListener) {
        listener.onClick()
    }
}

fun main(args: Array<String>) {
    // 使用object创建匿名类
    val button = Button()
    button.setOnClickListener(object : OnClickListener {
        override fun onClick() {
            
        }
    })
}