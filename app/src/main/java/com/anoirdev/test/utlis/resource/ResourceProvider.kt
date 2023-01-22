package com.anoirdev.test.utlis.resource

import android.content.Context
import androidx.annotation.ColorRes
import androidx.annotation.StringRes

class ResourceProvider(val context: Context) : IResourceProvider {

    override fun getString(@StringRes resId: Int) = context.getString(resId)
    override fun getColor(@ColorRes idColor: Int) = context.getColor(idColor)

}

