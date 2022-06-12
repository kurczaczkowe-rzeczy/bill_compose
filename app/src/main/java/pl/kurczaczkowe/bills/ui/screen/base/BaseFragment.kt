package pl.kurczaczkowe.bills.ui.screen.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import pl.kurczaczkowe.bills.ui.theme.BillsTheme

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
                    OnCreateView()
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