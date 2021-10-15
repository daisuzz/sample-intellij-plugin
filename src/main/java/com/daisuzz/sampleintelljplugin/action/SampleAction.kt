package com.daisuzz.sampleintelljplugin.action

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class SampleAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        Messages.showMessageDialog("Hello World", "Title", null)
    }
}
