package state


/**
 * 错误面板的状态
 *
 */
class ErrorPanelState{

    companion object{
        /** 默认显示的错误信息 */
        const val default_errorMsg="应用遇到错误"

        /** 配置默认是否退出应用,true 为退出，false 反之 */
        const val default_isExitApplication=false

        /** 退出时间，单位：毫秒 */
        const val default_delayExit=5000

        /** 默认在错误界面关闭后打开的界面 */
        val default_nextPanel=Panel.MAIN_PANEL
    }
}