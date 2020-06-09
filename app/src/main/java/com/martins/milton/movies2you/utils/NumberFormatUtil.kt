package com.martins.milton.movies2you.utils

import kotlin.math.ln
import kotlin.math.pow

object NumberFormatUtil {
    fun getFormattedNumber(number: Int): String {
        return when {
            number < 1000 -> number.toString()
            else -> {
                val exp = (ln(number.toDouble()) / ln(1000.0)).toInt()
                String.format(
                    "%.1f %c",
                    number / 1000.0.pow(exp.toDouble()),
                    "kMGTPE"[exp - 1]
                )
            }
        }
    }
}