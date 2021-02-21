package panel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.*
import state.ApplicationState
import state.ErrorPanelState
import state.Panel
import kotlin.system.exitProcess

/**
 * 错误界面
 *
 * @param applicationState 应用状态
 * @param errorMsg 错误信息
 * @param isExitApplication 是否退出应用，true 为退出，false 则打开 nextPanel 指定的界面
 * @param delayExit 退出时间，单位：毫秒
 * @param nextPanel 默认在错误界面关闭后打开的界面
 */
@Composable
fun ErrorPanel(
    applicationState: ApplicationState,
    errorMsg: String = ErrorPanelState.default_errorMsg,
    isExitApplication: Boolean = ErrorPanelState.default_isExitApplication,
    delayExit: Int = ErrorPanelState.default_delayExit,
    nextPanel: Panel = ErrorPanelState.default_nextPanel,

    ) {
    val cs = remember {
        //延时关闭程序
        if (isExitApplication) {
            CoroutineScope(Dispatchers.IO).launch {
                delay(delayExit.toLong())
                exitProcess(1)
            }
        } else null
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column() {
            Text(errorMsg)
            Row() {
                if (!isExitApplication) {
                    Button(
                        onClick = {
                            CoroutineScope(Dispatchers.IO).launch {
                                cs?.cancelAndJoin()
                            }
                            applicationState.showingPanel = nextPanel
                        }
                    ) { Text("返  回") }
                }
                Button(
                    onClick = { System.exit(1) }
                ) { Text("关  闭") }
            }
        }
    }
}