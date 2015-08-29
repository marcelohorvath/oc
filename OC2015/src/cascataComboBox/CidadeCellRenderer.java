package cascataComboBox;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class CidadeCellRenderer extends DefaultListCellRenderer {
    
     @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
     super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
        if (value instanceof Cidade) {
            Cidade cidade = (Cidade) value;
            setText(cidade.getNome());
        }
        return this;
    }

}