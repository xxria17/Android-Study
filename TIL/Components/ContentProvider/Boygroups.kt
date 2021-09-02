package com.dhxxn.contentproviderapp

import android.provider.BaseColumns

class Boygroups {
    companion object {
        const val TABLE_NAME = "boygroups"
        const val COLUMN_ID = BaseColumns._ID
        const val COLUMN_NAME = "name"

        val MEMO = arrayOf(
            "Seventeen", "The boys", "Monsta X", "Astro", "NCT", "TXT", "Wei",
            "Pentagon", "Cravity"
        )
    }
}