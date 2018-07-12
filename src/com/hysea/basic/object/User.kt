package com.hysea.basic.`object`

/**
 * 使用伴生对象实现工厂方法
 */
class User private constructor(val nickname: String) {
    companion object {

        fun newSubscribeUser(email: String) = User(email.substringBefore("@"))

        fun newFacebookUser(accountId: Int) = User(getFacebookName(accountId))
    }
}

fun getFacebookName(accountId: Int) = "facebook:$accountId"