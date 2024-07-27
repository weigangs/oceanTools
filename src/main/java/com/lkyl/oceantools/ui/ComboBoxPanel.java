package com.lkyl.oceantools.ui;

import com.google.gson.Gson;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.openapi.ui.DialogWrapper;
import com.lkyl.oceantools.entity.DbConnEntity;
import com.lkyl.oceantools.render.DbConnRenderer;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class ComboBoxPanel extends DialogWrapper {
    private static final String SELECTED_OPTION_KEY = "com.swg1024.oceantools.dbconn.selections";
    private JPanel panel;
    private ComboBox<DbConnEntity> comboBox;

    public ComboBoxPanel() {
        super(true); // use current window as parent
        init();
        setTitle("ConnEntity ComboBox Panel");
        PropertiesComponent properties = PropertiesComponent.getInstance();
        List<String> cachedDbConnStrList = properties.getList(SELECTED_OPTION_KEY);
        if (cachedDbConnStrList == null) {
            cachedDbConnStrList = List.of();
        }
        Gson gson = new Gson();
        List<DbConnEntity> dbConnEntityList = cachedDbConnStrList.stream().map(e -> gson.fromJson(e, DbConnEntity.class)).toList();
        comboBox = new ComboBox<>(dbConnEntityList.toArray(new DbConnEntity[0]));
        comboBox.setRenderer(new DbConnRenderer());
    }

    @Override
    protected JComponent createCenterPanel() {
        panel = new JPanel(new BorderLayout());
        panel.add(comboBox, BorderLayout.CENTER);
        return panel;
    }

    @Override
    protected void doOKAction() {
        // Save the selected entity when the OK button is pressed
        PropertiesComponent properties = PropertiesComponent.getInstance();
        DbConnEntity selectedEntity = (DbConnEntity) comboBox.getSelectedItem();
        if (selectedEntity != null) {
            properties.setValue(SELECTED_OPTION_KEY, selectedEntity.getDbName());
        }

        super.doOKAction();
    }
}