package com.dkgtech.expensemanager.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dkgtech.expensemanager.model.ExpenseModel

@Database(entities = [ExpenseModel::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        val DATABASE_NAME = "expense_db"
        var DATABASE_INSTANCE: AppDatabase? = null


        @Synchronized
        fun getDatabase(context: Context): AppDatabase {
            if (DATABASE_INSTANCE == null) {
                DATABASE_INSTANCE =
                    Room.databaseBuilder(
                        context.applicationContext, AppDatabase::class.java,
                        DATABASE_NAME
                    ).allowMainThreadQueries().build()
            }

            return DATABASE_INSTANCE!!
        }

    }

    abstract fun ExpenseDao(): ExpenseDao

}