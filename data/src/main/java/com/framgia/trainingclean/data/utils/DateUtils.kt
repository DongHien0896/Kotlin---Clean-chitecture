package com.framgia.trainingclean.data.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun String.toDate(
    format: String, locale: Locale = Locale.getDefault()
): Date? {
    if (this.isBlank() || format.isBlank()) return null
    return try {
        SimpleDateFormat(format, locale).parse(this)
    } catch (ex: ParseException) {
        null
    }
}

fun String.toTimeLong(
    format: String, locale: Locale = Locale.getDefault()
): Long? {
    return toDate(format, locale)?.time
}

fun Long.toTimeString(
    format: String, locale: Locale = Locale.getDefault()
): String? {
    if (format.isBlank()) return null
    return SimpleDateFormat(format, locale)?.format(Date(this))
}