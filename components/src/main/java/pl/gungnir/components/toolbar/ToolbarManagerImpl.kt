package pl.gungnir.components.toolbar

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import javax.inject.Inject

class ToolbarManagerImpl @Inject constructor() : ToolbarManager {

    private val _toolbarState: MutableState<ToolbarState?> = mutableStateOf(null)
    override val toolbarState: MutableState<ToolbarState?>
        get() = _toolbarState

    override fun changeToolbar(toolbarState: ToolbarState) {
        _toolbarState.value = toolbarState
    }

    override fun removeToolbar() {
        _toolbarState.value = null
    }
}