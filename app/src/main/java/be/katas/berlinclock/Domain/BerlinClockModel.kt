package be.katas.berlinclock.Domain

data class BerlinClockModel (
    val secondsLights: Boolean,
    val minutesLights: MinutesModel,
    val hoursLights: HoursModel
) {
    companion object {
        fun initial() = BerlinClockModel(false, MinutesModel(), HoursModel())
    }
}