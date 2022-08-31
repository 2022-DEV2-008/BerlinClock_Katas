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

    private lateinit var timer: CountDownTimer
    private val viewModel: BerlinClockViewModel by viewModel()

    override val layoutResource: Int
        get() = R.layout.fragment_berlin

    override fun onViewDataBindingCreated(binding: FragmentBerlinBinding) {
        binding.viewModel = viewModel
        viewModel.init()
        setUpRecyclerView(binding)
        startTimer()
    }

    private fun setUpRecyclerView(binding: FragmentBerlinBinding) {
        binding.rvTopMinute.adapter = viewModel.berlinClockData.value?.topMinuteAdapter
        binding.rvBottomMinute.adapter = viewModel.berlinClockData.value?.bottomMinuteAdapter
        binding.rvHours.adapter = viewModel.berlinClockData.value?.hourAdapter
    }

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
