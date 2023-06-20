package com.dkgtech.expensemanager.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense")
data class ExpenseModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "desc") val desc: String,
    @ColumnInfo(name = "amt") val amount: Double,
    @ColumnInfo(name = "bal") val balance: Double,
    @ColumnInfo(name = "type") val type: Int,
    @ColumnInfo(name = "cat_type") val catType: Int,
    @ColumnInfo(name = "date") val date: String

)
