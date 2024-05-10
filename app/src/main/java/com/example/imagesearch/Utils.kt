package com.example.imagesearch

import android.content.Context
import android.util.Log
import com.example.imagesearch.Constats.PREFS_NAME
import com.example.imagesearch.Constats.PREF_KEY
import java.util.Date
import java.text.ParseException
import java.text.SimpleDateFormat

object Utils {


    fun getDateFromTimestampWithFormat(
        timestamp: String?,
        fromFormatformat: String?,
        toFormatformat: String?
    ): String {
        var date: Date? = null
        var res = ""
        try {
            val format = SimpleDateFormat(fromFormatformat)
            date = format.parse(timestamp)//??
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        Log.d("date", "getDateFromTimestampWithFormat date >> $date")

        val df = SimpleDateFormat(toFormatformat)
        res = df.format(date)
        return res
    }

    fun saveLastSearch(context: Context): String? {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getString(PREF_KEY, null)
    }

}