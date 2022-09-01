package be.katas.berlinclock.fragment

import android.os.CountDownTimer
import be.katas.berlinclock.R
import be.katas.berlinclock.databinding.FragmentBerlinBinding
import be.katas.berlinclock.ui.DataBindingBaseFragment
import be.katas.berlinclock.utils.COUNT_DOWN_INTERVAL
import be.katas.berlinclock.utils.COUNT_DOWN_MILLIS
import be.katas.berlinclock.viewmodel.BerlinClockViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class BerlinClockFragment : DataBindingBaseFragment<FragmentBerlinBinding>() {

    /**
     * Object to perform 60 sec timer
     */
    private lateinit var timer: CountDownTimer

    /**
     * Object of viewmodel which hold and manage UI related data in a life-cycle conscious way
     */
    private val viewModel: BerlinClockViewModel by viewModel()

    /**
     * Setting the layout for the current fragment
     */
    override val layoutResource: Int
        get() = R.layout.fragment_berlin

    override fun onViewDataBindingCreated(binding: FragmentBerlinBinding) {
        binding.viewModel = viewModel
        viewModel.init()
        setUpRecyclerView(binding)
        startTimer()
    }

    /**
     * Setting adapters to  Recycler views
     */
    private fun setUpRecyclerView(binding: FragmentBerlinBinding) {
        binding.rvTopMinute.adapter = viewModel.berlinClockData.value?.topMinuteAdapter
        binding.rvBottomMinute.adapter = viewModel.berlinClockData.value?.bottomMinuteAdapter
        binding.rvHours.adapter = viewModel.berlinClockData.value?.hourAdapter
        viewModel.berlinClockData.value?.berlinClockModel?.value?.let { viewModel.updateUI(it) }
    }

    /**
     * Starting timer to 60 sec timer for the interval of 1 sec
     * Updating UI for every 1 sec
     * restart timer after every 60 sec
     */
    private fun startTimer() {
        timer = object : CountDownTimer(COUNT_DOWN_MILLIS, COUNT_DOWN_INTERVAL) {
            override fun onTick(millisUntilFinished: Long) = viewModel.getActualBerlinTime()
            override fun onFinish() {
                start()
            }
        }
        timer.start()
    }
}
