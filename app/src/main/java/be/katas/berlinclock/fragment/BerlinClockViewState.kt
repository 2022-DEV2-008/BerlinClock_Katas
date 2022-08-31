package be.katas.berlinclock.fragment

import androidx.lifecycle.MutableLiveData
import be.katas.berlinclock.Domain.BerlinClockModel
import be.katas.berlinclock.adapters.BottomMinuteAdapter
import be.katas.berlinclock.adapters.HourAdapter
import be.katas.berlinclock.adapters.TopMinuteAdapter

class BerlinClockViewState {

    val displayTime: MutableLiveData<String> = MutableLiveData("")
    val secondColorEnable: MutableLiveData<Boolean> = MutableLiveData(false)
    val berlinClockModel: MutableLiveData<BerlinClockModel> = MutableLiveData(BerlinClockModel.initial())
    val topMinuteAdapter: TopMinuteAdapter by lazy { TopMinuteAdapter() }
    val bottomMinuteAdapter: BottomMinuteAdapter by lazy { BottomMinuteAdapter() }
    val hourAdapter: HourAdapter by lazy { HourAdapter() }

}