package com.horizonguard.common_ui_compose_lib.navigation

import android.os.Bundle

data class Destination(
    val destination: String,
    val args: Bundle? = null,
)

sealed interface NavAction {

    data object Back : NavAction

    data object FinishActivity : NavAction

    data class Navigate(val destination: Destination) : NavAction

    data class ReplaceAll(val destination: Destination) : NavAction
}
