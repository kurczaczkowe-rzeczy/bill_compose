package pl.gungnir.components.toolbar

import androidx.compose.runtime.MutableState

interface ToolbarManager {
    val toolbarState: MutableState<ToolbarState?>

    fun changeToolbar(toolbarState: ToolbarState)
    fun removeToolbar()
}