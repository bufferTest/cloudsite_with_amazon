package com.softuvo.cloudsight.utils

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

/**
 * Methods for dealing with timestamps
 */
object TimestampUtils {

    /**
     * Return an ISO 8601 combined date and time string for current date/time
     *
     * @return String with format "yyyy-MM-dd'T'HH:mm:ss'Z'"
     */
    val isO8601StringForCurrentDate: String
        get() {
            val now = Date()
            return getISO8601StringForDate(now)
        }

    /**
     * Return an ISO 8601 combined date and time string for specified date/time
     *
     * @param date
     * Date
     * @return String with format "yyyy-MM-dd'T'HH:mm:ss'Z'"
     */
    private fun getISO8601StringForDate(date: Date): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)
        dateFormat.timeZone = TimeZone.getTimeZone("UTC")
        return dateFormat.format(date)
    }
}
/**
 * Private constructor: class cannot be instantiated
 */