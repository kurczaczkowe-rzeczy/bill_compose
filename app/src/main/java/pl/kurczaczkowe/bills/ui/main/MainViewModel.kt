package pl.kurczaczkowe.bills.ui.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import pl.gungnir.components.toolbar.ToolbarManager
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    toolbarManager: ToolbarManager
): ViewModel(){
    val toolbarState = toolbarManager.toolbarState
}