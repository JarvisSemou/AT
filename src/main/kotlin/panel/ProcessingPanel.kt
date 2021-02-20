package panel


import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import state.ApplicationState
import state.Panel

/**
 * 任务执行界面
 *
 * @author Jarvis Semou
 */
@Composable
fun ProcessingPanel(
    applicationState: ApplicationState
){
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        //状态显示列
        Surface(
            color = Color.LightGray,
            modifier = Modifier.fillMaxSize()
                .weight(0.382f,fill = false)
        ){
            Box(
                contentAlignment = Alignment.Center
            ){
                Column(
                    verticalArrangement = Arrangement.Center,
                ){
                    Text("总成功数量 200")
                    Text("当前连接设备数量  4")
                    Button(
                        modifier = Modifier.padding(top = 20.dp),
                        onClick={
                            applicationState.showingPanel= Panel.MAIN_PANEL
                        }
                    ){
                        Text("停止执行")
                    }
                }
            }
        }
        //任务显示列
        Surface(
            color = Color.Gray,
            modifier = Modifier.fillMaxSize()
                .weight(0.618f,fill=true)
        ){
            ScrollableColumn(
                verticalArrangement = Arrangement.Top,
            ){
              for(i in 1..100){
                  Text("任务进度 $i")
              }

            }
        }
    }
}