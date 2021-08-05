package com.akadatsky.dbsample.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Message(val text: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
