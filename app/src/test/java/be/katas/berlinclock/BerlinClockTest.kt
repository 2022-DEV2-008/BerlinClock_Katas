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

    @Test
    fun `should return yellow state for first 2 top minute and all bottom minute when minute is 14`(){
        val clockState = berlinClockUtil.getBerlinClock("00:14:00")

        assertThat(clockState.minutesLights.topColors).isEqualTo(listOf(YELLOW,YELLOW,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF))
        assertThat(clockState.minutesLights.bottomColors).isEqualTo(listOf(YELLOW,YELLOW,YELLOW,YELLOW))
    }

    @Test
    fun `should return yellow state for first 2 top minute and red state for third top minute when minute is 15`(){
        val clockState = berlinClockUtil.getBerlinClock("00:15:00")

        assertThat(clockState.minutesLights.topColors).isEqualTo(listOf(YELLOW,YELLOW,RED,OFF,OFF,OFF,OFF,OFF,OFF,OFF,OFF))
        assertThat(clockState.minutesLights.bottomColors).isEqualTo(listOf(OFF,OFF,OFF,OFF))
    }

    @Test
    fun `should return expected yellow state and red state for top minute and bottom minute when minute is Ramdom 47`(){
        val clockState = berlinClockUtil.getBerlinClock("00:47:00")

        assertThat(clockState.minutesLights.topColors).isEqualTo(listOf(YELLOW,YELLOW,RED,YELLOW,YELLOW,RED,YELLOW,YELLOW,RED,OFF,OFF))
        assertThat(clockState.minutesLights.bottomColors).isEqualTo(listOf(YELLOW,YELLOW,OFF,OFF))
    }

    @Test
    fun `should return yellow state and red state for all top minute and bottom minute when minute is 59`(){
        val clockState = berlinClockUtil.getBerlinClock("00:59:00")

        assertThat(clockState.minutesLights.topColors).isEqualTo(listOf(YELLOW,YELLOW,RED,YELLOW,YELLOW,RED,YELLOW,YELLOW,RED,YELLOW,YELLOW))
        assertThat(clockState.minutesLights.bottomColors).isEqualTo(listOf(YELLOW,YELLOW,YELLOW,YELLOW))
    }

    @Test
    fun `should return yellow state and red state for all top minute and bottom minute and yellow state for second when minute is 59 and 2 seconds`(){
        val clockState = berlinClockUtil.getBerlinClock("00:59:02")

        assertThat(clockState.minutesLights.topColors).isEqualTo(listOf(YELLOW,YELLOW,RED,YELLOW,YELLOW,RED,YELLOW,YELLOW,RED,YELLOW,YELLOW))
        assertThat(clockState.minutesLights.bottomColors).isEqualTo(listOf(YELLOW,YELLOW,YELLOW,YELLOW))
        assertThat(clockState.secondsLights).isEqualTo(true)
    }

    @Test
    fun `should return white state for all when hour is 0`(){
        val clockState = berlinClockUtil.getBerlinClock("00:59:59")

        assertThat(clockState.hoursLights.topColors).isEqualTo(listOf(OFF,OFF,OFF,OFF))
        assertThat(clockState.hoursLights.bottomColors).isEqualTo(listOf(OFF,OFF,OFF,OFF))
    }

    @Test
    fun `should return red state for first bottom hour and remaining other white when hour is 1`(){
        val clockState = berlinClockUtil.getBerlinClock("01:00:00")

        assertThat(clockState.hoursLights.topColors).isEqualTo(listOf(OFF,OFF,OFF,OFF))
        assertThat(clockState.hoursLights.bottomColors).isEqualTo(listOf(RED,OFF,OFF,OFF))
    }

    @Test
    fun `should return red state for first 2 bottom hour and remaining other white when hour is 2`(){
        val clockState = berlinClockUtil.getBerlinClock("02:00:00")

        assertThat(clockState.hoursLights.topColors).isEqualTo(listOf(OFF,OFF,OFF,OFF))
        assertThat(clockState.hoursLights.bottomColors).isEqualTo(listOf(RED,RED,OFF,OFF))
    }

    @Test
    fun `should return red state for all 4 bottom hour when hour is 4`(){
        val clockState = berlinClockUtil.getBerlinClock("04:00:00")

        assertThat(clockState.hoursLights.topColors).isEqualTo(listOf(OFF,OFF,OFF,OFF))
        assertThat(clockState.hoursLights.bottomColors).isEqualTo(listOf(RED,RED,RED,RED))
    }

    @Test
    fun `should return red state for first top hour and remaining all white when hour is 5`(){
        val clockState = berlinClockUtil.getBerlinClock("05:00:00")

        assertThat(clockState.hoursLights.topColors).isEqualTo(listOf(RED,OFF,OFF,OFF))
        assertThat(clockState.hoursLights.bottomColors).isEqualTo(listOf(OFF,OFF,OFF,OFF))
    }

    @Test
    fun `should return red state for first top hour and 4 bottom hour when hour is 9`(){
        val clockState = berlinClockUtil.getBerlinClock("09:00:00")

        assertThat(clockState.hoursLights.topColors).isEqualTo(listOf(RED,OFF,OFF,OFF))
        assertThat(clockState.hoursLights.bottomColors).isEqualTo(listOf(RED,RED,RED,RED))
    }

    @Test
    fun `should return red state for all top hour when hour is 20`(){
        val clockState = berlinClockUtil.getBerlinClock("20:00:00")

        assertThat(clockState.hoursLights.topColors).isEqualTo(listOf(RED,RED,RED,RED))
        assertThat(clockState.hoursLights.bottomColors).isEqualTo(listOf(OFF,OFF,OFF,OFF))
    }

    @Test
    fun `should return expected yellow and red state for random time`(){
        val clockState = berlinClockUtil.getBerlinClock("16:42:38")

        assertThat(clockState.hoursLights.topColors).isEqualTo(listOf(RED,RED,RED,OFF))
        assertThat(clockState.hoursLights.bottomColors).isEqualTo(listOf(RED,OFF,OFF,OFF))
        assertThat(clockState.minutesLights.topColors).isEqualTo(listOf(YELLOW,YELLOW,RED,YELLOW,YELLOW,RED,YELLOW,YELLOW,OFF,OFF,OFF))
        assertThat(clockState.minutesLights.bottomColors).isEqualTo(listOf(YELLOW,YELLOW,OFF,OFF))
        assertThat(clockState.secondsLights).isEqualTo(true)
    }

    @Test
    fun `test random berlin clock time`(){
        val clockState = berlinClockUtil.getBerlinClock("23:59:59")

        assertThat(clockState.hoursLights.topColors).isEqualTo(listOf(RED,RED,RED,RED))
        assertThat(clockState.hoursLights.bottomColors).isEqualTo(listOf(RED,RED,RED,OFF))
        assertThat(clockState.minutesLights.topColors).isEqualTo(listOf(YELLOW,YELLOW,RED,YELLOW,YELLOW,RED,YELLOW,YELLOW,RED,YELLOW,YELLOW))
        assertThat(clockState.minutesLights.bottomColors).isEqualTo(listOf(YELLOW,YELLOW,YELLOW,YELLOW))
        assertThat(clockState.secondsLights).isEqualTo(false)
    }
}
