package com.exequiel.challenge.beers.features.detail.view

import androidx.navigation.fragment.navArgs
import com.exequiel.challenge.R
import com.exequiel.challenge.beers.core.toGone
import com.exequiel.challenge.beers.core.toVisible
import com.exequiel.challenge.beers.core.view.BaseFragment
import com.exequiel.challenge.beers.core.viewmodel.Event
import com.exequiel.challenge.beers.core.viewmodel.observe
import com.exequiel.challenge.beers.features.detail.navigation.BeerDetailNavigation
import com.exequiel.challenge.beers.features.detail.viewmodel.BeerDetailViewModel
import com.exequiel.challenge.databinding.BeerDetailFragmentBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.Exception

class BeerDetailFragment: BaseFragment<BeerDetailFragmentBinding>() {

    private val detailViewModel: BeerDetailViewModel by viewModel()
    private val router: BeerDetailNavigation by inject()
    private val viewInputArgument: BeerDetailFragmentArgs by navArgs()

    override fun getViewModel() = detailViewModel

    override fun viewOnReady() {
        super.viewOnReady()
        initRemoteCalls()
    }

    private fun initRemoteCalls() {
        viewInputArgument.movieId.apply {
            detailViewModel.callDetailMovie(id = this)
        }
    }

    override fun bindObserversToLiveData() {
        super.bindObserversToLiveData()
        observe(detailViewModel.bindingDelegate.showImageBackground, this::showImageBackground)
        observe(detailViewModel.bindingDelegate.showTitle, this::showTitle)
        observe(detailViewModel.bindingDelegate.showTagline, this::showTagline)
        observe(detailViewModel.bindingDelegate.showDate, this::showDate)
        observe(detailViewModel.bindingDelegate.showFoodParing, this::showFoodParing)
        observe(detailViewModel.bindingDelegate.showDescription, this::showDescription)
    }

    private fun showImageBackground(event: Event<String>) {
        event.getContentIfNotHandled().let {
            if (it.isNullOrBlank()) {
                bindingView.movieImage.setImageResource(R.drawable.ic_baseline_image_24)
                return
            }else{
                bindingView.movieImageProgressBar.toVisible()
                Picasso.get().load(it).fit()
                    .transform(RoundedCornersTransformation(4, 1))
                    .centerInside()
                    .error(R.drawable.ic_baseline_image_24)
                    .into(bindingView.movieImage, object : Callback {
                        override fun onSuccess() {
                            bindingView.movieImageProgressBar.toGone()
                        }

                        override fun onError(e: Exception?) {
                            bindingView.movieImageProgressBar.toGone()
                        }
                    })
            }
        }
    }

    private fun showTitle(event: Event<String>){
        event.getContentIfNotHandled().let {
            it?.apply {
                bindingView.nameText.text = this
            }
        }
    }

    private fun showTagline(event: Event<String>){
        event.getContentIfNotHandled().let {
            it?.apply {
                bindingView.taglineText.text = this
            }
        }
    }

    private fun showDate(event: Event<String>){
        event.getContentIfNotHandled().let {
            it?.apply {
                bindingView.dateText.text = this
            }
        }
    }

    private fun showFoodParing(event: Event<String>){
        event.getContentIfNotHandled().let {
            it?.apply {
                bindingView.foodParingText.text = this
            }
        }
    }

    private fun showDescription(event: Event<String>){
        event.getContentIfNotHandled().let {
            it?.apply {
                bindingView.overviewText.text = this
            }
        }
    }

}


