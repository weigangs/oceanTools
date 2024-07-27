package com.lkyl.oceantools.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.IdeActions;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.editor.actionSystem.EditorActionManager;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class EditorHandlerIllustration extends AnAction {
  @Override
  public void update(@NotNull AnActionEvent event) {
    Project project = event.getProject();
    Editor editor = event.getData(CommonDataKeys.EDITOR);

    // Make sure at least one caret is available
    boolean menuAllowed = false;
    if (editor != null && project != null) {
      // Ensure the list of carets in the editor is not empty
      menuAllowed = !editor.getCaretModel().getAllCarets().isEmpty();
    }
    event.getPresentation().setEnabledAndVisible(menuAllowed);
  }

  @Override
  public void actionPerformed(@NotNull AnActionEvent event) {
    Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
    EditorActionManager actionManager = EditorActionManager.getInstance();
    EditorActionHandler actionHandler =
            actionManager.getActionHandler(IdeActions.ACTION_EDITOR_CLONE_CARET_BELOW);
    actionHandler.execute(editor,
            editor.getCaretModel().getPrimaryCaret(), event.getDataContext());
  }
}