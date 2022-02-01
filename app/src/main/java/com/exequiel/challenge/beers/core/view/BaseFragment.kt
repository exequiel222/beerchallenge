package com.exequiel.challenge.beers.core.view

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.exequiel.challenge.R
import com.exequiel.challenge.beers.core.BaseViewActionsInterface
import com.exequiel.challenge.beers.core.toGone
import com.exequiel.challenge.beers.core.toVisible
import com.exequiel.challenge.beers.core.viewmodel.BaseViewModel
import com.exequiel.challenge.beers.core.viewmodel.Event
import com.exequiel.challenge.beers.core.viewmodel.observe
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<T : ViewBinding> : Fragment(), BaseViewActionsInterface {

    lateinit var bindingView: T

    private lateinit var TAG_SCREEN: String

    //Generics views
    private lateinit var progressView: View

    //No internet connection
    lateinit var noInternetConnectionView: View
    lateinit var retryNoInternetConnectionView: View
    lateinit var btnReload: Button
    lateinit var txtRetryInternetConnection: TextView

    //Error generic
    private var dialogErrorGeneric: Dialog? = null
    private lateinit var errorGenericView: View
    private lateinit var txtRetryErrorGeneric: TextView

    private var mLastClickTime: Long = 0

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val type = javaClass.genericSuperclass as ParameterizedType
        val clazz = type.actualTypeArguments[0] as Class<*>
        val method = clazz.getMethod(
                "inflate",
                LayoutInflater::class.java,
                ViewGroup::class.java,
                Boolean::class.java
        )
        bindingView = method.invoke(null, layoutInflater, container, false) as T
        TAG_SCREEN = "[" + javaClass.simpleName + "]"
        Log.i("SCREEN", "*********************")
        Log.i("SCREEN", TAG_SCREEN)
        Log.i("SCREEN", "*********************")

        return bindingView.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initGenericsViews()
        viewOnReady()
        bindObserversToLiveData()
    }

    override fun onResume() {
        super.onResume()
    }

    abstract fun getViewModel(): BaseViewModel

    override fun bindObserversToLiveData() {
        observe(getViewModel().bindingDelegate.showProgressView, this::showProgressView)
        observe(getViewModel().bindingDelegate.hideProgressView, this::hideProgressView)
        observe(getViewModel().bindingDelegate.showErrorInternetConnection, this::showErrorInternetConnection)
        observe(getViewModel().bindingDelegate.hideErrorInternetConnection, this::hideErrorInternetConnection)
    }

    private fun initGenericsViews() {
        (view as? ViewGroup)?.let { viewGroup ->
            initProgressView(viewGroup)
            initNoInternetConnectionView(viewGroup)
            initGenericError(viewGroup)
        }
    }

    private fun initProgressView(viewGroupRoot: ViewGroup) {
        progressView = View.inflate(context, R.layout.custom_loading, viewGroupRoot).findViewById(R.id.v_progress)
        progressView.toGone()
    }

    private fun initNoInternetConnectionView(viewGroupRoot: ViewGroup) {
        //Implementar
    }

    private fun initGenericError(viewGroupRoot: ViewGroup) {
        //Implementar
    }

    //region Generic actions

    open val listenerErrorConnection = View.OnClickListener {
        //Implementar
    }

    //region Progress View
    override fun showProgressView(event: Event<Unit>) {
        event.getContentIfNotHandled().let {
            it?.apply {
                progressView.toVisible()
            }
        }
    }

    override fun hideProgressView(event: Event<Unit>) {
        event.getContentIfNotHandled().let {
            it?.apply {
                progressView.toGone()
            }
        }
    }

    //endregion

    override fun showErrorInternetConnection(event: Event<Unit>) {
        event.getContentIfNotHandled().let {
            it?.apply {
                noInternetConnectionView.toVisible()
                retryNoInternetConnectionView.toVisible()
            }
        }
    }

    override fun hideErrorInternetConnection(event: Event<Unit>) {
        event.getContentIfNotHandled().let {
            it?.apply {
                retryNoInternetConnectionView.toGone()
                noInternetConnectionView.toGone()
            }
        }
    }
    //endregion
}
