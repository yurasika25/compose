package com.affirmation.app.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ProfileAffirmation(
    @StringRes val title: Int,
    @StringRes val subTitle: Int,
    @DrawableRes val imageResourceId: Int
)