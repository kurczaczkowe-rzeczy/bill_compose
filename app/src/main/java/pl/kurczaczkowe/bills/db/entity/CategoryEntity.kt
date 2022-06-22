package pl.kurczaczkowe.bills.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", index = true)
    val idCategory: Int = 0,

    @ColumnInfo(name = "name")
    val nameCategory: String,

    @ColumnInfo(name = "color")
    val colorCategory: Int,

    @ColumnInfo(name = "is_premade")
    val isPremadeCategory: Boolean,
)