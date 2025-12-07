package com.horizonguard.common_ui_compose_lib.navigation

import android.content.Context
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.navOptions

@Composable
fun NavigationHandler(
    navigator: ComposeNavigator,
    navController: NavHostController,
) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        navigator.navActions.collect {
            when (it) {
                is NavAction.Back -> {
                    val result = navController.navigateUp()
                    if (!result) {
                        navigator.finishActivity()
                    }
                }

                is NavAction.Navigate -> {
                    navController.customNavigate(destination = it.destination)
                }

                is NavAction.ReplaceAll -> {
                    navController.customNavigate(destination = it.destination) {
                        popUpTo(0) { inclusive = true }
                    }
                }

                is NavAction.FinishActivity -> {
                    finishActivity(context = context)
                }

                null -> {}
            }
        }
    }
}

private fun NavController.customNavigate(
    destination: Destination,
    builder: NavOptionsBuilder.() -> Unit = {},
) {
    val nodeId = graph.findNode(route = destination.destination)?.id
    if (nodeId != null && destination.args != null) {
        navigate(
            resId = nodeId,
            args = destination.args,
            navigatorExtras = null,
            navOptions = navOptions(builder),
        )
    } else {
        navigate(
            route = destination.destination,
            navOptions = navOptions(builder),
        )
    }
}

private fun finishActivity(
    context: Context,
    resultCode: Int? = null,
    intent: Intent? = null,
) {
    (context as? ComponentActivity)?.let { activity ->
        resultCode?.let {
            activity.setResult(it, intent)
        }
        activity.finish()
    }
}
