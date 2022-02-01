package com.exequiel.challenge.beers.features.list.view.cell

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.exequiel.challenge.beers.core.InfiniteContentScrollListener
import com.exequiel.challenge.beers.core.view.cell.IOnItemClickViewHolder
import com.exequiel.challenge.beers.features.list.usecase.model.BeerItemModel
import com.exequiel.challenge.databinding.BeerListItemGridBinding
import com.exequiel.challenge.databinding.BeerListItemListBinding

class BeerListAdapter internal constructor(
    private val onItemClickListener: IOnItemClickViewHolder,
    private val infiniteContentScrollListener: InfiniteContentScrollListener
) : ListAdapter<(BeerItemModel), BeerListViewHolder>(MovieDiffCallback()) {

    private var isMovieItemGrid: Boolean = false

    override fun submitList(list: List<BeerItemModel>?) {
        val newList: MutableList<BeerItemModel> = arrayListOf()
        if (list != null) newList.addAll(list)
        super.submitList(newList)
        infiniteContentScrollListener.itemsLoaded()
    }

    override fun onBindViewHolder(holder: BeerListViewHolder, position: Int) {
        holder.bindingDataInHolder(getItem(position))
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        if (recyclerView.layoutManager is GridLayoutManager) isMovieItemGrid = true
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewBinding = if (isMovieItemGrid) {
            BeerListItemGridBinding.inflate(layoutInflater, parent, false)
        } else {
            BeerListItemListBinding.inflate(layoutInflater, parent, false)
        }
        return BeerListViewHolder(binding, onItemClickListener)
    }

    private class MovieDiffCallback : DiffUtil.ItemCallback<BeerItemModel>() {
        override fun areItemsTheSame(oldItem: BeerItemModel, newItem: BeerItemModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: BeerItemModel, newItem: BeerItemModel): Boolean {
            return oldItem.id == newItem.id
        }
    }
}
