package com.exequiel.challenge.beers.features.list.view

import android.os.Bundle
import android.view.View
import com.exequiel.challenge.beers.core.InfiniteContentScrollListener
import com.exequiel.challenge.beers.core.view.BaseFragment
import com.exequiel.challenge.beers.core.view.cell.IOnItemClickViewHolder
import com.exequiel.challenge.beers.core.viewmodel.Event
import com.exequiel.challenge.beers.core.viewmodel.observe
import com.exequiel.challenge.beers.features.list.navigation.BeerListNavigation
import com.exequiel.challenge.beers.features.list.usecase.model.BeerItemModel
import com.exequiel.challenge.beers.features.list.view.cell.BeerListAdapter
import com.exequiel.challenge.beers.features.list.viewmodel.BeerListViewModel
import com.exequiel.challenge.databinding.BeerListFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class BeerListFragment: BaseFragment<BeerListFragmentBinding>() {

    private val listViewModel: BeerListViewModel by viewModel()
    private val router: BeerListNavigation by inject()
    private var adapter : BeerListAdapter? = null

    override fun getViewModel() = listViewModel

    override fun viewOnReady() {
        super.viewOnReady()
        initGridRecyclerView()
        listViewModel.loadMoreMovies()
    }

    override fun bindObserversToLiveData() {
        super.bindObserversToLiveData()
        observe(listViewModel.bindingDelegate.updateListItems, this::updateListItems)
    }

    private fun updateListItems(event: Event<List<BeerItemModel>>){
        event.getContentIfNotHandled().let {
            it?.apply {
                (bindingView.moviesRecyclerView.adapter as BeerListAdapter).submitList(this)
            }
        }
    }

    private fun initGridRecyclerView() {
        if(this.adapter == null){
            this.adapter = BeerListAdapter(onItemClickListener = itemClickHandler,
                infiniteContentScrollListener = InfiniteContentScrollListener(bindingView.moviesRecyclerView) {
                    listViewModel.loadMoreMovies()
                }
            )
        }
        bindingView.moviesRecyclerView.adapter = adapter
    }

    private val itemClickHandler = object : IOnItemClickViewHolder {
        override fun onItemClick(caller: View?, position: Int) {
            val id = (bindingView.moviesRecyclerView.adapter as BeerListAdapter).currentList[position].id
            router.goToDetailMovie(requireView(), id)
        }
    }
}