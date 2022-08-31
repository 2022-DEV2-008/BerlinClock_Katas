package be.katas.berlinclock.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import be.katas.berlinclock.databinding.BerlinItemLayoutBinding
import be.katas.berlinclock.utils.DisplayColor

class BottomMinuteAdapter :
    RecyclerView.Adapter<BottomMinuteAdapter.ViewHolder>() {

    private lateinit var bottomMinutesList: List<DisplayColor>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView =
            BerlinItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(bottomMinutesList[position])
    }

    override fun getItemCount() = 4

    fun updateList(updatedBottomMinuteList: List<DisplayColor>) {
        bottomMinutesList = updatedBottomMinuteList
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: BerlinItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(minute: DisplayColor) {
            binding.btnItem.isEnabled = minute != DisplayColor.OFF
        }
    }
}
