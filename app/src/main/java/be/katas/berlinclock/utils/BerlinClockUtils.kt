package be.katas.berlinclock.utils

import be.katas.berlinclock.Domain.BerlinClockModel
import be.katas.berlinclock.Domain.HoursModel
import be.katas.berlinclock.Domain.MinutesModel

class BerlinClockUtils {

    fun getBerlinClock(time: String): BerlinClockModel {
        val currentTimeSplit = time.split(":")
        val hoursColors = getBerlinClockHoursList(currentTimeSplit[0].toInt())
        val minutesColors = getBerlinClockMinutesList(currentTimeSplit[1].toInt())
        val secondsValue = getSecondsValue(currentTimeSplit[2].toInt())
        return BerlinClockModel( secondsValue, minutesColors, hoursColors)
    }


    private fun getBerlinClockHoursList(hours: Int): HoursModel = when {
        hours < 5 -> HoursModel(bottomColors = getHoursColors(hours))
        hours >= 5 -> HoursModel(getHoursColors(hours / 5), getHoursColors(hours % 5))
        else -> HoursModel()
    }

    private fun getHoursColors(hours: Int): MutableList<DisplayColor> {
        val hourState = HoursModel.initialHours()
        (1..hours).forEach { i ->
            hourState[i - 1] = DisplayColor.RED
        }
        return hourState
    }

    private fun getBerlinClockMinutesList(minutes: Int): MinutesModel = when {
        minutes < 5 -> MinutesModel(bottomColors = getBottomMinuteColors(minutes))
        minutes >= 5 -> MinutesModel(getTopMinuteColors(minutes / 5), getBottomMinuteColors(minutes % 5))
        else -> MinutesModel()
    }

    private fun getBottomMinuteColors(minutes: Int): MutableList<DisplayColor> {
        val minuteBottomState = MinutesModel.initialMinuteBottom()
        (1..minutes).forEach { i ->
            minuteBottomState[i - 1] = DisplayColor.YELLOW
        }
        return minuteBottomState
    }

    private fun getTopMinuteColors(minutes: Int): MutableList<DisplayColor> {
        val minuteTopState = MinutesModel.initialMinuteTop()
        (1..minutes).forEach { i ->
            if (i % 3 == 0) {
                minuteTopState[i - 1] = DisplayColor.RED
            } else {
                minuteTopState[i - 1] = DisplayColor.YELLOW
            }
        }
        return minuteTopState
    }

    private fun getSecondsValue(second: Int): Boolean = second % 2 == 0

}
