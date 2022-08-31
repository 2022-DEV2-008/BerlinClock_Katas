package be.katas.berlinclock.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import be.katas.berlinclock.R
import be.katas.berlinclock.databinding.BerlinItemLayoutBinding
import be.katas.berlinclock.utils.DisplayColor
import be.katas.berlinclock.utils.SPAN_COUNT_TOP_MINUTE

class TopMinuteAdapter :
    RecyclerView.Adapter<TopMinuteAdapter.ViewHolder>() {

    private lateinit var topMinutesList: List<DisplayColor>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView =
            BerlinItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(topMinutesList[position])
        when(position) {
            2,5,8 -> {
                holder.itemView.apply {
                    holder.binding.btnItem.background =
                        ContextCompat.getDrawable(context, R.drawable.red_background)
                }
            }
        }
    }

    override fun getItemCount() = SPAN_COUNT_TOP_MINUTE

    fun updateList(updatedTopMinuteList: List<DisplayColor>) {
        topMinutesList = updatedTopMinuteList
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: BerlinItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(minute: DisplayColor) {
            if (minute != DisplayColor.RED)
                binding.btnItem.isEnabled = minute != DisplayColor.OFF
            else binding.btnItem.isEnabled = minute == DisplayColor.RED
        }
    }
}
