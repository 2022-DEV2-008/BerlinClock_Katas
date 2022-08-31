package be.katas.berlinclock.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.katas.berlinclock.fragment.BerlinClockViewState
import be.katas.berlinclock.utils.BerlinClockUtils
import be.katas.berlinclock.utils.TIME_FORMAT
import java.text.SimpleDateFormat
import java.util.*

class BerlinClockViewModel(private val berlinClock: BerlinClockUtils) : ViewModel() {

    private val _berlinClockLiveData = MutableLiveData<BerlinClockViewState>()

    val berlinClockData: LiveData<BerlinClockViewState> = _berlinClockLiveData

    fun init() {
      _berlinClockLiveData.value = BerlinClockViewState()
    }

    fun updateUi() {
        val currentTime: String = SimpleDateFormat(TIME_FORMAT, Locale.getDefault()).format(Date())
        _berlinClockLiveData.value?.displayTime?.postValue(currentTime)
    }

}
