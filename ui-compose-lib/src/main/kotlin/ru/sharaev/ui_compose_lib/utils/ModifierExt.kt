package ru.sharaev.ui_compose_lib.utils

import androidx.compose.ui.Modifier

inline fun Modifier.conditional(condition: Boolean, modifier: Modifier.() -> Modifier): Modifier =
    if (condition) then(modifier(Modifier)) else this
