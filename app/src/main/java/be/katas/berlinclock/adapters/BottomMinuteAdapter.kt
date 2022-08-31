package be.katas.berlinclock.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import be.katas.berlinclock.R
import be.katas.berlinclock.databinding.BerlinItemLayoutBinding
import be.katas.berlinclock.utils.DisplayColor
import be.katas.berlinclock.utils.SPAN_COUNT_BOTTOM_MINUTE

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
        holder.itemView.apply {
            when(position) {
                0 -> {
                    holder.binding.btnItem.background =
                        ContextCompat.getDrawable(context, R.drawable.left_curve_yellow_background)
                }
                3 -> {
                    holder.binding.btnItem.background =
                        ContextCompat.getDrawable(context, R.drawable.right_curve_yellow_background)
                }
            }
        }
    }

    override fun getItemCount() = SPAN_COUNT_BOTTOM_MINUTE

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
