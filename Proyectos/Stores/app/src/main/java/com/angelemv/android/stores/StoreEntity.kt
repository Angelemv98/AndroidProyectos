package com.angelemv.android.stores

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "StoreEntity")
data class StoreEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var name: String = "",
    var phone: String = "",
    var website: String = "",
    var isfavorite: Boolean = false
) {


}