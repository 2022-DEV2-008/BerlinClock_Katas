package be.katas.berlinclock.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.katas.berlinclock.Domain.BerlinClockModel
import be.katas.berlinclock.fragment.BerlinClockViewState
import be.katas.berlinclock.utils.BerlinClockUtils
import be.katas.berlinclock.utils.TIME_FORMAT
import java.text.SimpleDateFormat
import java.util.*

/**
 * View model require to maintain UI related data
 * [Param BerlinClockUtils injects using Koin]
 */
class BerlinClockViewModel(private val berlinClock: BerlinClockUtils) : ViewModel() {

    /**
     * Observable object of complete items.
     * BerlinClockViewState contains data to change the state of UI.
     */
    private val _berlinClockLiveData = MutableLiveData<BerlinClockViewState>()

    val berlinClockData: LiveData<BerlinClockViewState> = _berlinClockLiveData

    /**
     * Initial function to initialise ViewState and Update initial UI state.
     */
    fun init() {
      _berlinClockLiveData.value = BerlinClockViewState()
    }

    /**
     * Operations to update UI.
     * Below function calls every second get current time to update the Display color on Recycler View.
     * Display current time.
     */
    fun getActualBerlinTime() {
        val currentTime: String = SimpleDateFormat(TIME_FORMAT, Locale.getDefault()).format(Date())
        _berlinClockLiveData.value?.displayTime?.postValue(berlinClock.getHourAndMinuteToDisplay(currentTime))
        updateUI(berlinClock.getBerlinClock(currentTime))
    }

    /**
     * Updates Recycler View with updated list of colors to Display.
     */
    fun updateUI(berlinClockModel: BerlinClockModel) {
       _berlinClockLiveData.value?.topMinuteAdapter?.updateList(berlinClockModel.minutesLights.topColors)
       _berlinClockLiveData.value?.bottomMinuteAdapter?.updateList(berlinClockModel.minutesLights.bottomColors)
       _berlinClockLiveData.value?.hourAdapter?.updateList(berlinClockModel.hoursLights)
       _berlinClockLiveData.value?.secondColorEnable?.postValue(berlinClockModel.secondsLights)
    }
}
