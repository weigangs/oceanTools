package com.lkyl.oceantools.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.LogicalPosition;
import com.intellij.openapi.editor.VisualPosition;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.diagnostic.Logger;

public class EditorAreaIllustration extends AnAction {
  private static final Logger LOG = Logger.getInstance(EditorAreaIllustration.class);


  @Override
  public void actionPerformed(@NotNull AnActionEvent event) {
    // Get access to the editor and caret model.
    Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
    CaretModel caretModel = editor.getCaretModel();

    // Getting the primary caret ensures we get the correct one of a possible many.
    Caret primaryCaret = caretModel.getPrimaryCaret();
    // Get the caret information
    LogicalPosition logicalPos = primaryCaret.getLogicalPosition();
    VisualPosition visualPos = primaryCaret.getVisualPosition();
    int caretOffset = primaryCaret.getOffset();

    // Build and display the caret report.
    String report = logicalPos.toString() + "\n" +
            visualPos.toString() + "\n" +
            "Offset: " + caretOffset;
    Messages.showInfoMessage(report, "Caret Parameters Inside The Editor");
  }
}