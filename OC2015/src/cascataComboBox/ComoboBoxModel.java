package cascataComboBox;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ComoboBoxModel extends AbstractListModel<Object> implements ComboBoxModel<Object> {

    private Estado estadoSelecionado;
    private List<Estado> lista;
    private final static int FIRSTINDEX = 0;

    public ComoboBoxModel() {
        this.lista = lista = new ArrayList<>();
    }

    public ComoboBoxModel(List<Estado> lista) {
        this();
        this.lista.addAll(lista);
        if (getSize() > 0) {
            setSelectedItem(this.lista.get(FIRSTINDEX));
        }
    }

    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Object getElementAt(int index) {
        return lista.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        estadoSelecionado = (Estado) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return estadoSelecionado;
    }
    
     public void addListEstado(List<Estado> listEstado) {
        int primeiraLinha = getSize();
        lista.addAll(listEstado);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha + listEstado.size());
        setSelectedItem(lista.get(getSize() - 1));
    }

}
