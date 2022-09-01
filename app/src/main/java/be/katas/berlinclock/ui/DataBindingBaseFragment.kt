package be.katas.berlinclock.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

/**
 * Base class which extends fragment class and perform required databinding posibility so ne need to repeat same thing in each and every fragment
 */
abstract class DataBindingBaseFragment<in V : ViewDataBinding> : Fragment() {

    companion object {
        const val NO_LAYOUT = 0
    }

    protected open val layoutResource = NO_LAYOUT

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (layoutResource == NO_LAYOUT) return null

        val binding = DataBindingUtil.inflate<V>(inflater, layoutResource, container, false)
        binding.lifecycleOwner = this
        onViewDataBindingCreated(binding)
        return binding.root
    }

    protected abstract fun onViewDataBindingCreated(binding: V)

}