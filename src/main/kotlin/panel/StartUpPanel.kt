package panel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import common_layout.WaittingWithLog
import state.ApplicationState
import state.Panel
import state.StartUpPanelState

/**
 * 初始化界面
 */
@ExperimentalFoundationApi
@Composable
fun StartUpPanel(
    applicationState: ApplicationState
){
    val panelState=remember{StartUpPanelState()}
    WaittingWithLog(
        applicationState=applicationState,
        successPanel = Panel.MAIN_PANEL,
        logTask = {

        }
    )
}