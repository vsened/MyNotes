package com.vsened.mynotes.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vsened.mynotes.ui.theme.BabyBlue
import com.vsened.mynotes.ui.theme.LightGreen
import com.vsened.mynotes.ui.theme.RedOrange
import com.vsened.mynotes.ui.theme.RedPink
import com.vsened.mynotes.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}
