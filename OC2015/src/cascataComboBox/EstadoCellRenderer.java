package cascataComboBox;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class EstadoCellRenderer extends DefaultListCellRenderer {
    
     @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
     super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
        if (value instanceof Estado) {
            Estado estado = (Estado) value;
            setText(estado.getNome());
        }
        return this;
    }

}
