package com.example.jetpackcompose.data

import com.example.jetpackcompose.R
import com.example.jetpackcompose.model.ProfileAffirmation

class ProfileDatasource {
    fun loadProfileAffirmations(): List<ProfileAffirmation> {
        return listOf(
            ProfileAffirmation(R.string.affirmation1, R.string.subtitle1, R.drawable.image1),
            ProfileAffirmation(R.string.affirmation2, R.string.subtitle2, R.drawable.image2),
            ProfileAffirmation(R.string.affirmation3, R.string.subtitle3, R.drawable.image3),
            ProfileAffirmation(R.string.affirmation4, R.string.subtitle4, R.drawable.image4),
            ProfileAffirmation(R.string.affirmation5, R.string.subtitle5, R.drawable.image5),
            ProfileAffirmation(R.string.affirmation6, R.string.subtitle6, R.drawable.image6),
            ProfileAffirmation(R.string.affirmation7, R.string.subtitle7, R.drawable.image7),
            ProfileAffirmation(R.string.affirmation8, R.string.subtitle8, R.drawable.image8),
            ProfileAffirmation(R.string.affirmation9, R.string.subtitle9, R.drawable.image9),
            ProfileAffirmation(R.string.affirmation10, R.string.subtitle10, R.drawable.image10)
        )
    }
}