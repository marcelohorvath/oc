package cascataComboBox;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class ComboDoisModel extends AbstractListModel<Object> implements ComboBoxModel<Object> {

    private Cidade cidadeSelecionada;
    private List<Cidade> lista;
    private final static int FIRSTINDEX = 0;

    public ComboDoisModel() {
        this.lista = lista = new ArrayList<>();
    }

    public ComboDoisModel(List<Cidade> lista) {
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
        cidadeSelecionada = (Cidade) anItem;
    }

    @Override
    public Object getSelectedItem() {
        return cidadeSelecionada;
    }

    public void addListCidade(List<Cidade> listCidade) {
        int primeiraLinha = getSize();
        lista.addAll(listCidade);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha + listCidade.size());
        setSelectedItem(lista.get(getSize() - 1));
    }

}
