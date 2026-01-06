package ru.sharaev.ui_compose_lib.navigation

import android.content.Intent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch


sealed interface ComposeNavigator {

    val navActions: SharedFlow<NavAction?>

    fun finishActivity()

    fun back()

    fun navigate(destination: Destination)

    fun replaceAll(destination: Destination)

    fun openBrowser(intent: Intent, onError: (Exception) -> Unit)

    class Impl(
        mainDispatcher: CoroutineDispatcher,
    ) : ComposeNavigator {

        private val scope = CoroutineScope(mainDispatcher + SupervisorJob())
        private val _navActions: MutableSharedFlow<NavAction?> = MutableSharedFlow()
        override val navActions = _navActions.asSharedFlow()


        override fun finishActivity() = emit(action = NavAction.FinishActivity)

        override fun back() = emit(action = NavAction.Back)

        override fun navigate(destination: Destination) = emit(
            NavAction.Navigate(destination = destination)
        )

        override fun replaceAll(destination: Destination) = emit(
            NavAction.ReplaceAll(destination = destination)
        )

        override fun openBrowser(intent: Intent, onError: (Exception) -> Unit) = emit(
            NavAction.OpenBrowser(intent = intent, onError = onError)
        )

        private fun emit(action: NavAction) {
            scope.launch { _navActions.emit(action) }
        }
    }
}