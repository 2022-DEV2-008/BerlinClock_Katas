package be.katas.berlinclock

import be.katas.berlinclock.utils.BerlinClockUtils
import be.katas.berlinclock.utils.DisplayColor.*
import org.junit.Before
import org.junit.Test
import com.google.common.truth.Truth.assertThat

class BerlinClockTest {

    private lateinit var berlinClockUtil: BerlinClockUtils

    @Before
    fun setUp(){
        berlinClockUtil = BerlinClockUtils()
    }

    @Test
    fun `should return yellow state for even second`(){
        val clockState = berlinClockUtil.getBerlinClock("00:00:00")
        assertThat(clockState.secondsLights).isEqualTo(true)
    }

    @Test
    fun `should return white state for odd second`(){
        val clockState = berlinClockUtil.getBerlinClock("00:00:01")
        assertThat(clockState.secondsLights).isEqualTo(false)
    }

    @Test
    fun `should return yellow state for random even second`(){
        val clockState = berlinClockUtil.getBerlinClock("00:00:58")
        assertThat(clockState.secondsLights).isEqualTo(true)
    }

    @Test
    fun `should return white state for ramdom odd second`(){
        val clockState = berlinClockUtil.getBerlinClock("00:00:43")
        assertThat(clockState.secondsLights).isEqualTo(false)
    }

    @Test
    fun `should return white state for all when minute is 0`(){
        val clockState = berlinClockUtil.getBerlinClock("00:00:59")

        assertThat(clockState.minutesLights.topColors).isEqualTo(listOf(OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF))
        assertThat(clockState.minutesLights.bottomColors).isEqualTo(listOf(OFF,OFF,OFF,OFF))
    }

    @Test
    fun `should return yellow state for first bottom minute state and other all white when minute is 1`(){
        val clockState = berlinClockUtil.getBerlinClock("00:01:30")

        assertThat(clockState.minutesLights.topColors).isEqualTo(listOf(OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF))
        assertThat(clockState.minutesLights.bottomColors).isEqualTo(listOf(YELLOW,OFF,OFF,OFF))
    }

    @Test
    fun `should return yellow state for all 4 bottom minute state when minute is 4`(){
        val clockState = berlinClockUtil.getBerlinClock("00:04:30")

        assertThat(clockState.minutesLights.topColors).isEqualTo(listOf(OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF))
        assertThat(clockState.minutesLights.bottomColors).isEqualTo(listOf(YELLOW,YELLOW,YELLOW,YELLOW))
    }

    @Test
    fun `should return yellow state for first top minute state other all white when minute is 5`(){
        val clockState = berlinClockUtil.getBerlinClock("00:05:00")

        assertThat(clockState.minutesLights.topColors).isEqualTo(listOf(YELLOW,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF))
        assertThat(clockState.minutesLights.bottomColors).isEqualTo(listOf(OFF,OFF,OFF,OFF))
    }

    @Test
    fun `should return yellow state for first top minute and first bottom minute when minute is 6`(){
        val clockState = berlinClockUtil.getBerlinClock("00:06:00")

        assertThat(clockState.minutesLights.topColors).isEqualTo(listOf(YELLOW,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF))
        assertThat(clockState.minutesLights.bottomColors).isEqualTo(listOf(YELLOW,OFF,OFF,OFF))
    }

}