package com.exequiel.challenge.beers.features.list.view.cell

import android.widget.ImageView
import androidx.viewbinding.ViewBinding
import com.exequiel.challenge.R
import com.exequiel.challenge.beers.core.datasource.TheBeerDatabaseAPI
import com.exequiel.challenge.beers.core.view.cell.BaseViewHolder
import com.exequiel.challenge.beers.core.view.cell.IOnItemClickViewHolder
import com.exequiel.challenge.beers.features.list.usecase.model.BeerItemModel
import com.exequiel.challenge.databinding.BeerListItemGridBinding
import com.exequiel.challenge.databinding.BeerListItemListBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation

class BeerListViewHolder(
    private val binding: ViewBinding,
    onItemClickListener: IOnItemClickViewHolder
) : BaseViewHolder<BeerItemModel>(binding, onItemClickListener) {

    override fun bindingDataInHolder(data: BeerItemModel) {
        super.bindingDataInHolder(data)
        when (binding) {
            is BeerListItemListBinding -> {
                bindPosterImage(binding)
            }
            is BeerListItemGridBinding -> {
                bindPosterImage(binding)
            }
            else -> throw Exception("Invalid list binding")
        }
    }

    private fun bindPosterImage(listBinding: BeerListItemListBinding) {
        data?.apply {
            bindImage(this.imageUrl, listBinding.image)
            listBinding.nameText.text = this.name
        }
    }

    private fun bindPosterImage(gridBinding: BeerListItemGridBinding) {
        data?.apply {
            bindImage(this.imageUrl, gridBinding.image)
            gridBinding.nameText.text = this.name
        }
    }

    private fun bindImage(path: String?, imgView: ImageView){
        if (path.isNullOrBlank()) {
            imgView.setImageResource(R.drawable.ic_baseline_image_24)
            return
        }
        Picasso.get().load(path).fit().centerInside()
            .transform(RoundedCornersTransformation(4, 1))
            .error(R.drawable.ic_baseline_image_24).into(imgView)
    }
}