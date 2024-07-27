package com.lkyl.oceantools.render;

import com.lkyl.oceantools.entity.DbConnEntity;

import javax.swing.*;
import java.awt.*;

public class DbConnRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value instanceof DbConnEntity) {
            DbConnEntity item = (DbConnEntity) value;
            setText(item.getDbName());
        }
        return this;
    }
}
