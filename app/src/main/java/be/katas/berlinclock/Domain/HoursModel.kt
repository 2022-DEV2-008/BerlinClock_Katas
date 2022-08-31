package be.katas.berlinclock.Domain

import be.katas.berlinclock.utils.DisplayColor

data class HoursModel (
    val topColors: List<DisplayColor> = initialHours(),
    val bottomColors: List<DisplayColor> = initialHours()
) {
    companion object {
        fun initialHours() = MutableList(4) { DisplayColor.OFF }
    }
}