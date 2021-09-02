package com.dhxxn.contentproviderapp

import android.content.ContentUris
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import androidx.loader.content.Loader
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
        const val LOADER_BOYGROUPS = 1
    }

    private var groupAdapter: GroupAdapter = GroupAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populateInitialDataIfNeeded()

        val list = findViewById<RecyclerView>(R.id.list)
        list.layoutManager = LinearLayoutManager(list.context)
        list.adapter = groupAdapter

        LoaderManager.getInstance(this)
                .initLoader(`LOADER_BOYGROUPS`, null, loaderCallbacks)
    }

    private val loaderCallbacks: LoaderManager.LoaderCallbacks<Cursor> =
            object : LoaderManager.LoaderCallbacks<Cursor> {
                override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> {
                    return CursorLoader(
                            applicationContext,
                            SampleContentProvider.URI_MEMO,
                            arrayOf(Boygroups.COLUMN_NAME),
                            null,
                            null,
                            Boygroups.COLUMN_NAME
                    )
                }

                override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {
                    groupAdapter.setGroups(data)
                }

                override fun onLoaderReset(loader: Loader<Cursor>) {
                    groupAdapter.setGroups(null)
                }

            }

    internal class GroupAdapter : RecyclerView.Adapter<GroupAdapter.ViewHolder?>() {
        private var cursor: Cursor? = null

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupAdapter.ViewHolder {
            return ViewHolder(parent)
        }

        override fun onBindViewHolder(holder: GroupAdapter.ViewHolder, position: Int) {
            if (cursor!!.moveToPosition(position)) {
                holder.text.text = cursor!!.getString(
                        cursor!!.getColumnIndexOrThrow(Boygroups.COLUMN_NAME)
                )
            }
        }

        fun setGroups(cursor: Cursor?) {
            this.cursor = cursor
            notifyDataSetChanged()
        }

        internal class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        android.R.layout.simple_list_item_1, parent, false
                )) {
            val text: TextView = itemView.findViewById(android.R.id.text1)
        }

        override fun getItemCount(): Int {
            return if (cursor == null) {
                0
            } else {
                cursor!!.count
            }
        }
    }

    private fun populateInitialDataIfNeeded() {
        val cursor = contentResolver.query(
                SampleContentProvider.URI_MEMO,
                null,
                null,
                null,
                null
        )
        if (cursor != null && cursor.count == 0) {
            Log.d(TAG, "Add Initial data")
            for (group in Boygroups.MEMO) {
                val values = ContentValues()
                values.put(Boygroups.COLUMN_NAME, group)
                contentResolver.insert(SampleContentProvider.URI_MEMO, values)
            }
        }
    }

    fun addItem(view: View) {
        val values = ContentValues()
        values.put(Boygroups.COLUMN_NAME, "New Item")
        val uri = contentResolver.insert(SampleContentProvider.URI_MEMO, values)
        Log.d(TAG, "Add item $uri")
    }

    fun updateItem(view: View) {
        val uri = queryAndGetOne()
        if (uri != null) {
            Log.d(TAG, "Update item: $uri")
            val values = ContentValues()
            values.put(Boygroups.COLUMN_NAME, "Updated Item")
            contentResolver.update(uri, values, null, null)
        }
    }

    fun removeItem(view: View) {
        val uri = queryAndGetOne()
        if (uri != null) {
            Log.d(TAG, "Remove item: $uri")
            contentResolver.delete(
                    uri,
                    null,
                    null
            )
        }
    }

    private fun queryAndGetOne(): Uri? {
        val cursor = contentResolver.query(
                SampleContentProvider.URI_MEMO,
                null, null, null,
                Boygroups.COLUMN_NAME
        )
        return if (cursor != null && cursor.count != 0) {
            cursor.moveToFirst()
            val id = cursor.getString(cursor.getColumnIndex(Boygroups.COLUMN_ID))
            val name = cursor.getString(cursor.getColumnIndex(Boygroups.COLUMN_NAME))
            val uri = ContentUris.withAppendedId(SampleContentProvider.URI_MEMO, id.toLong())
            Log.d(TAG, "query and return uri: $uri (id: $id, name: $name)")
            uri
        } else {
            null
        }
    }
}