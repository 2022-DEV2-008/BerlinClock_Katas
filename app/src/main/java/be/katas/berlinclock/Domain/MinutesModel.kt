package be.katas.berlinclock.Domain

import be.katas.berlinclock.utils.DisplayColor

data class MinutesModel(
    val topColors: List<DisplayColor> = initialMinuteTop(),
    val bottomColors: List<DisplayColor> = initialMinuteBottom()
) {
    companion object {
        fun initialMinuteBottom() = MutableList(4) { DisplayColor.OFF }
        fun initialMinuteTop() = MutableList(11) { DisplayColor.OFF }
    }
}