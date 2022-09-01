package be.katas.berlinclock

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import be.katas.berlinclock.Domain.BerlinClockModel
import be.katas.berlinclock.utils.BerlinClockUtils
import be.katas.berlinclock.viewmodel.BerlinClockViewModel
import org.junit.Before
import org.junit.Test
import com.google.common.truth.Truth.assertThat
import org.junit.Rule

class BerlinClickViewModelTest {

    private lateinit var berlinClockUtil: BerlinClockUtils
    private lateinit var viewModel: BerlinClockViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        berlinClockUtil = BerlinClockUtils()
        viewModel =  BerlinClockViewModel(berlinClockUtil)
    }

    @Test
    fun `livedata should return initial berlin clock data`() {
        viewModel.init()

        val value = viewModel.berlinClockData.value?.berlinClockModel?.value
        val expectedBerlinTime = BerlinClockModel.initial()
        assertThat(value).isEqualTo(expectedBerlinTime)
    }

    @Test
    fun `livedata should eturn initial second data`() {
        viewModel.init()

        val value = viewModel.berlinClockData.value?.secondColorEnable?.value
        val expectedBerlinTime = false
        assertThat(value).isEqualTo(expectedBerlinTime)
    }
}
