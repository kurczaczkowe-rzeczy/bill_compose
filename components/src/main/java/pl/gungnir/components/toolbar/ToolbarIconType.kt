package pl.gungnir.components.toolbar

sealed class ToolbarIconType(val onClick: () -> Unit) {
    class Additional(onClick: () -> Unit) : ToolbarIconType(onClick)
    class Add(onClick: () -> Unit) : ToolbarIconType(onClick)
    class Filter(onClick: () -> Unit) : ToolbarIconType(onClick)
    class Back(onClick: () -> Unit) : ToolbarIconType(onClick)
    class Close(onClick: () -> Unit) : ToolbarIconType(onClick)
    class Menu(onClick: () -> Unit) : ToolbarIconType(onClick)
}