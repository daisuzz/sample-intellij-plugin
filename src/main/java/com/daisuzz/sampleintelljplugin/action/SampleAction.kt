package com.daisuzz.sampleintelljplugin.action

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.command.WriteCommandAction

class SampleAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.getRequiredData(CommonDataKeys.PROJECT)
        val editor = e.getRequiredData(CommonDataKeys.EDITOR)

        val primaryCaret = editor.caretModel.primaryCaret

        WriteCommandAction.runWriteCommandAction(project) {
            editor.document.replaceString(primaryCaret.selectionStart, primaryCaret.selectionEnd, "xxxxxx")
        }

        primaryCaret.removeSelection()
    }

    override fun update(e: AnActionEvent) {
        val editor = e.getData(CommonDataKeys.EDITOR)
        val project = e.getData(CommonDataKeys.PROJECT)
        val caret = e.getData(CommonDataKeys.CARET)
        e.presentation.isEnabled = project != null
                && editor != null
                && caret != null
                && caret.selectionEnd - caret.selectionStart > 0
    }
}
