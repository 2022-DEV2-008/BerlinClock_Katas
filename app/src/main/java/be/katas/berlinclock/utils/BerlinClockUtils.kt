package be.katas.berlinclock.utils

import be.katas.berlinclock.Domain.BerlinClockModel
import be.katas.berlinclock.Domain.HoursModel
import be.katas.berlinclock.Domain.MinutesModel

/**
 * Class to perform logic to return data to update recycler view and UI
 */
class BerlinClockUtils {

    /**
     * [Returns] BerlinClockModel to update UI
     * [Param] Current time in string format HH:mm:ss
     */
    fun getBerlinClock(time: String): BerlinClockModel {
        val currentTimeSplit = time.split(":")
        val hoursColors = getBerlinClockHoursList(currentTimeSplit[0].toInt())
        val minutesColors = getBerlinClockMinutesList(currentTimeSplit[1].toInt())
        val secondsValue = getSecondsValue(currentTimeSplit[2].toInt())
        return BerlinClockModel( secondsValue, minutesColors, hoursColors)
    }

    /**
     * [Returns] Hours model which contains top colors list and bottom colors of list
     * [Param] current Hour value in Int 'HH'
     * hours less than 5 return only top colors and greater than 5 returns both top and bottom display colors
     */
    private fun getBerlinClockHoursList(hours: Int): HoursModel = when {
        hours < 5 -> HoursModel(bottomColors = getHoursColors(hours))
        hours >= 5 -> HoursModel(getHoursColors(hours / 5), getHoursColors(hours % 5))
        else -> HoursModel()
    }

    /**
     * [Returns] mutable List of display colors for hours
     * getting the initial list and updating through for loop
     */
    private fun getHoursColors(hours: Int): MutableList<DisplayColor> {
        val hourState = HoursModel.initialHours()
        (1..hours).forEach { i ->
            hourState[i - 1] = DisplayColor.RED
        }
        return hourState
    }

    /**
     * [Returns] Minutes model which contains top colors list and bottom colors of list
     * [Param] current Minute value in Int 'mm'
     * minute less than 5 return only top colors and greater than 5 returns both top and bottom display colors
     */
    private fun getBerlinClockMinutesList(minutes: Int): MinutesModel = when {
        minutes < 5 -> MinutesModel(bottomColors = getBottomMinuteColors(minutes))
        minutes >= 5 -> MinutesModel(getTopMinuteColors(minutes / 5), getBottomMinuteColors(minutes % 5))
        else -> MinutesModel()
    }

    /**
     * [Returns] mutable bottom minute List of display colors for minutes
     * getting the initial bottom minute list and updating through for loop
     */
    private fun getBottomMinuteColors(minutes: Int): MutableList<DisplayColor> {
        val minuteBottomState = MinutesModel.initialMinuteBottom()
        (1..minutes).forEach { i ->
            minuteBottomState[i - 1] = DisplayColor.YELLOW
        }
        return minuteBottomState
    }

    /**
     * [Returns] mutable top minute List of display colors for minutes
     * getting the initial top minute list and updating through for loop
     */
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

    /**
     * [Returns] boolean value true if second is even else false
     * [Param] seconds in current time
     */
    private fun getSecondsValue(second: Int): Boolean = second % 2 == 0

    /**
     * [Returns] String of current time with only hours and minutes 'HH:mm'
     * [Param] current time in string
     */
    fun getHourAndMinuteToDisplay(time:String): String {
        val currentTimeSplit = time.split(":")
        return currentTimeSplit[0]+":"+currentTimeSplit[1]
    }
}
