package be.katas.berlinclock.Domain

data class BerlinClockModel (
    val secondsOnLamp: Boolean,
    val minutesOnLamps: MinutesModel,
    val hoursOnLamps: HoursModel
) {
    companion object {
        fun initial() = BerlinClockModel(false, MinutesModel(), HoursModel())
    }
}