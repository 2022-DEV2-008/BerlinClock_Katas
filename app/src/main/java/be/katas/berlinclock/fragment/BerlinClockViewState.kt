package be.katas.berlinclock.fragment

import androidx.lifecycle.MutableLiveData
import be.katas.berlinclock.Domain.BerlinClockModel
import be.katas.berlinclock.adapters.BottomMinuteAdapter
import be.katas.berlinclock.adapters.HourAdapter
import be.katas.berlinclock.adapters.TopMinuteAdapter

/**
 * Class handles complete viewstate of Berlin Clock
 */
class BerlinClockViewState {

    /* Observable to display current in textview*/
    val displayTime: MutableLiveData<String> = MutableLiveData("")

    /* Observable to update the seconds circular drawable color*/
    val secondColorEnable: MutableLiveData<Boolean> = MutableLiveData(false)

    /* Observable to update the recycler view drawable color*/
    val berlinClockModel: MutableLiveData<BerlinClockModel> = MutableLiveData(BerlinClockModel.initial())

    /* Adapters to set to recycler views */
    val topMinuteAdapter: TopMinuteAdapter by lazy { TopMinuteAdapter() }
    val bottomMinuteAdapter: BottomMinuteAdapter by lazy { BottomMinuteAdapter() }
    val hourAdapter: HourAdapter by lazy { HourAdapter() }

}