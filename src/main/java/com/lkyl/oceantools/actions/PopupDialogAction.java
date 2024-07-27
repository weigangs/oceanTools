package com.lkyl.oceantools.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;
import com.lkyl.oceantools.ui.ComboBoxPanel;
import org.jetbrains.annotations.NotNull;

public class PopupDialogAction extends AnAction {

  @Override
  public void update(@NotNull AnActionEvent event) {
    // Using the event, evaluate the context,
    // and enable or disable the action.
    Project project = event.getProject();
    event.getPresentation().setEnabledAndVisible(project != null);
  }

  @Override
  public void actionPerformed(@NotNull AnActionEvent event) {
    // Using the event, create and show a dialog
    new ComboBoxPanel().show();
  }

  // Override getActionUpdateThread() when you target 2022.3 or later!

}