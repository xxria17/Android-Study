package com.dhxxn.contentproviderapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SampleDatabase {
    companion object {
        private const val DATABASE_NAME = "boygroup.db"
        private const val DATABASE_VERSION = 1
        private var sInstance: DatabaseHelper? = null

        @Synchronized
        fun getInstance(context: Context): SQLiteDatabase {
            if (sInstance == null) {
                sInstance = DatabaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION)
            }
            return sInstance!!.writableDatabase
        }

        class DatabaseHelper(
                context: Context?,
                name: String?,
                factory: SQLiteDatabase.CursorFactory?,
                version: Int) : SQLiteOpenHelper(context, name, factory, version) {
            override fun onCreate(db: SQLiteDatabase?) {
                db?.execSQL("CREATE TABLE ${Boygroups.TABLE_NAME}"
                        + " (${Boygroups.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + " ${Boygroups.COLUMN_NAME} TEXT NOT NULL);")
            }

            override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
                db?.execSQL("DROP TABLE IF EXISTS ${Boygroups.TABLE_NAME}")
                onCreate(db)
            }
        }
    }
}