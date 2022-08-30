package be.katas.berlinclock.fragment

import be.katas.berlinclock.R
import be.katas.berlinclock.databinding.FragmentBerlinBinding
import be.katas.berlinclock.ui.DataBindingBaseFragment

class BerlinClockFragment : DataBindingBaseFragment<FragmentBerlinBinding>() {

    override val layoutResource: Int
        get() = R.layout.fragment_berlin

    override fun onViewDataBindingCreated(binding: FragmentBerlinBinding) {

    }
}
