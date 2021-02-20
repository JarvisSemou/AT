package panel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import state.ApplicationState
import state.Panel

/**
 * 开始界面
 *
 * @author Jarvis Semou
 */
@Composable
fun MainPanel(
    applicationState: ApplicationState
){
    Surface(
        color = Color(50,50,50)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    applicationState.showingPanel = Panel.PROCESSING_PANEL
                }
            ) {
                Text("开始")
            }
        }
    }

}