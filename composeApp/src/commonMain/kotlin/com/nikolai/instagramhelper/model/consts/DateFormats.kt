package com.nikolai.instagramhelper.model.consts

import kotlinx.datetime.LocalDate
import kotlinx.datetime.UtcOffset
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.format.char

val noteCreateDateFormat = DateTimeComponents.Format {
    date(LocalDate.Formats.ISO)
}