package com.exequiel.challenge.beers.core.view.cell

import android.os.SystemClock
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<T>(
    binding: ViewBinding,
    private val onItemClickListener: IOnItemClickViewHolder? = null
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            if (isActionEnable()) onItemClickListener?.onItemClick(it, bindingAdapterPosition)
        }
    }

    var data: T? = null
        private set

    open fun bindingDataInHolder(data: T) {
        this.data = data
    }

    private var mLastClickTime: Long = 0

    private fun isActionEnable(): Boolean {
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
            return false
        }
        mLastClickTime = SystemClock.elapsedRealtime()
        return true
    }
}

interface IOnItemClickViewHolder {
    fun onItemClick(caller: View?, position: Int)
}
