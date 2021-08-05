package com.akadatsky.dbsample.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.OffsetDateTime

@Entity
data class User(
    @ColumnInfo(name = "first_name")
    val firstName: String?,
    @ColumnInfo(name = "last_name")
    val lastName: String?,
    @ColumnInfo(name = "register_date")
    val registerDate: OffsetDateTime?, // 2021.08.21T21:08:27
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}