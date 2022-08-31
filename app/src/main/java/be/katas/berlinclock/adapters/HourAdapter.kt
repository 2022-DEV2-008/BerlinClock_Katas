package be.katas.berlinclock.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import be.katas.berlinclock.Domain.HoursModel
import be.katas.berlinclock.R
import be.katas.berlinclock.databinding.BerlinItemLayoutBinding
import be.katas.berlinclock.utils.DisplayColor
import be.katas.berlinclock.utils.SPAN_COUNT_HOUR

class HourAdapter :
    RecyclerView.Adapter<HourAdapter.ViewHolder>() {

    private lateinit var hourList: List<DisplayColor>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView =
            BerlinItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {
            holder.bind(hourList[position], context)
            when (position) {
                0, 4 -> {
                    holder.binding.btnItem.background =
                        ContextCompat.getDrawable(context, R.drawable.left_curve_red_background)
                }

                3, 7 -> {
                    holder.binding.btnItem.background =
                        ContextCompat.getDrawable(context, R.drawable.right_curve_red_background)
                }
            }
        }
    }

    override fun getItemCount() = SPAN_COUNT_HOUR

    fun updateList(updatedHourList: HoursModel) {
        hourList = updatedHourList.topColors + updatedHourList.bottomColors
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: BerlinItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(minute: DisplayColor, context: Context) {
            binding.btnItem.background =
                ContextCompat.getDrawable(context, R.drawable.red_background)
            binding.btnItem.isEnabled = minute != DisplayColor.OFF
        }
    }
}