package com.dhxxn.contentproviderapp

import android.content.ContentProvider
import android.content.ContentUris
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.database.sqlite.SQLiteQueryBuilder
import android.net.Uri
import java.lang.IllegalArgumentException

class SampleContentProvider : ContentProvider() {

    companion object {
        const val AUTHORITY = "com.dhxxn.contentproviderapp.provider"
        val URI_MEMO : Uri = Uri.parse(
            "content:://$AUTHORITY/${Boygroups.TABLE_NAME}"
        )
        const val CODE_BOYGROUPS_DIR = 1
        const val CODE_BOYGROUPS_ITEM = 2
    }

    private var uriMatcher = UriMatcher(UriMatcher.NO_MATCH)
    init {
        uriMatcher.addURI(AUTHORITY, Boygroups.TABLE_NAME, CODE_BOYGROUPS_DIR)
        uriMatcher.addURI(AUTHORITY, "${Boygroups.TABLE_NAME}/#", CODE_BOYGROUPS_ITEM)
    }

    override fun onCreate(): Boolean {
        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        val code: Int = uriMatcher.match(uri)
        return when (uriMatcher.match(uri)) {
            CODE_BOYGROUPS_DIR, CODE_BOYGROUPS_ITEM -> {
                val queryBuilder = SQLiteQueryBuilder()
                queryBuilder.tables = Boygroups.TABLE_NAME
                val db = SampleDatabase.getInstance(context!!)
                val cursor = queryBuilder.query(
                    db, projection, selection, selectionArgs, null, null, sortOrder
                )
                cursor.setNotificationUri(context!!.contentResolver, uri)
                cursor
            }
            else -> {
                throw java.lang.IllegalArgumentException("Unknown URI: $uri")
            }
        }
    }

    override fun getType(uri: Uri): String? {
        return when (uriMatcher.match(uri)) {
            CODE_BOYGROUPS_DIR -> "vnd.android.cursor.dir/$AUTHORITY.${Boygroups.TABLE_NAME}"
            CODE_BOYGROUPS_ITEM -> "vnd.android.cursor.item/$AUTHORITY.${Boygroups.TABLE_NAME}"
            else -> throw IllegalArgumentException("Unknown URI: $uri")
        }
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        return when (uriMatcher.match(uri)) {
            CODE_BOYGROUPS_DIR -> {
                val id = SampleDatabase.getInstance(context!!)
                    .insert(Boygroups.TABLE_NAME, null, values)
                val insertedUri = ContentUris.withAppendedId(uri, id)
                context!!.contentResolver.notifyChange(insertedUri, null)
                insertedUri
            }
            CODE_BOYGROUPS_ITEM -> {
                throw java.lang.IllegalArgumentException("Invalid URI, cannot insert with ID: $uri")
            }
            else -> {
                throw java.lang.IllegalArgumentException("Unknown URI: $uri")
            }
        }
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        return when(uriMatcher.match(uri)) {
            CODE_BOYGROUPS_DIR -> {
                throw java.lang.IllegalArgumentException("Invalid URI, cannot update without ID: $uri")
            }
            CODE_BOYGROUPS_ITEM -> {
                val id = ContentUris.parseId(uri)
                val count = SampleDatabase.getInstance(context!!)
                        .delete(Boygroups.TABLE_NAME, "${Boygroups.COLUMN_ID} = ?",
                        arrayOf(id.toString()))
                context!!.contentResolver.notifyChange(uri, null)
                count
            }
            else -> {
                throw java.lang.IllegalArgumentException("Unknown URI: $uri")
            }
        }
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        return when (uriMatcher.match(uri)) {
            CODE_BOYGROUPS_DIR -> {
                throw java.lang.IllegalArgumentException("Invalid URI, cannot update withdout ID$uri")
            }
            CODE_BOYGROUPS_ITEM -> {
                val id = ContentUris.parseId(uri)
                val count = SampleDatabase.getInstance(context!!)
                    .update(Boygroups.TABLE_NAME, values, "${Boygroups.COLUMN_ID} = ?",
                    arrayOf(id.toString()))
                context!!.contentResolver.notifyChange(uri, null)
                count
            }
            else -> {
                throw java.lang.IllegalArgumentException("Unknown URI: $uri")
            }
        }
    }
}