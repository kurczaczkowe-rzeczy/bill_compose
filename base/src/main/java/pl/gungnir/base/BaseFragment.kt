package pl.gungnir.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import pl.gungnir.base.theme.BillsTheme

abstract class BaseFragment<E : SpecificEvent, T : BaseViewModel<E>> : Fragment() {

    abstract val viewModel: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initObservers()
        return ComposeView(requireContext()).apply {
            setContent {
                BillsTheme {
                    Box(modifier = Modifier.background(MaterialTheme.colors.background)) {
                        OnCreateView()
                    }
                }
            }
        }
    }

    @Composable
    abstract fun OnCreateView()

    private fun initObservers() {
        viewModel.apply {
            observeEvent(event, ::handleEvent)
            observeFailure(errorEvent, ::handleError)
        }
    }

    open fun handleEvent(event: E) = Unit

    open fun handleError(event: Failure?) = Unit

    private inline fun <T : Any, L : LiveData<Event<T>>> LifecycleOwner.observeEvent(
        liveData: L,
        crossinline body: (T) -> Unit
    ) {
        liveData.observe(this) {
            it.getContentIfNotHandled()?.let(body)
        }
    }

    private inline fun <T : Failure, L : LiveData<Event<T>>> LifecycleOwner.observeFailure(
        liveData: L,
        crossinline body: (T?) -> Unit
    ) {
        liveData.observe(this) { body(it.getContentIfNotHandled()) }
    }
}