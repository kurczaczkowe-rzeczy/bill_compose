package pl.gungnir.components.toolbar

data class ToolbarState(
    val title: String? = null,
    val navigationButton: ToolbarIconType? = null,
    val actionButton1: ToolbarIconType? = null,
    val actionButton2: ToolbarIconType? = null
)