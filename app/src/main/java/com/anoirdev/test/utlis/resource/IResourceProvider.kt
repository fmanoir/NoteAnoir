package com.anoirdev.test.utlis.resource

import androidx.annotation.ColorRes
import androidx.annotation.StringRes

interface IResourceProvider {

    fun getString(@StringRes resId: Int): String

    fun getColor(@ColorRes idColor: Int): Int

}