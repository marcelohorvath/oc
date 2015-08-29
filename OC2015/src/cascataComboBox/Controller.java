package cascataComboBox;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.ListSelectionModel;

public class Controller implements MouseListener, ItemListener {

    private View viewCombo;
    private Estado estadoUm = new Estado("Rio Grande Do Sul");
    private Estado estadoDois = new Estado("Santa Catarina");
    private Cidade cidadeUm = new Cidade("Porto Alegre", estadoUm);
    private Cidade cidadeDois = new Cidade("Pelotas", estadoUm);
    private Cidade cidadeTres = new Cidade("Florianópolis", estadoDois);
    private Cidade cidadeQuatro = new Cidade("Joinvile", estadoDois);

    public Controller(View viewCombo) {
        this.viewCombo = viewCombo;
    }

    public void iniciar() {
        montarEassinar();
        viewCombo.setVisible(true);
        viewCombo.setDefaultCloseOperation(EXIT_ON_CLOSE);
        atualizarComboBoxEstado();

    }

    public void montarEassinar() {
        viewCombo.getComboCidade().addMouseListener(this);
        viewCombo.getComboCidade().setSelectedItem(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        viewCombo.getComboEstado().addMouseListener(this);
        viewCombo.getComboEstado().addItemListener(listener);
        viewCombo.getComboEstado().setRenderer(new EstadoCellRenderer());
        viewCombo.getComboCidade().setRenderer(new CidadeCellRenderer());
        viewCombo.getComboEstado().setSelectedItem(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

    }

    ItemListener listener = new ItemListener() {

        @Override
        public void itemStateChanged(ItemEvent e) {
            JComboBox combo = (JComboBox) e.getSource();
            if (combo.equals(viewCombo.getComboEstado())) {
                atualizarComboBoxCidade();
            }
        }

    };

    private void atualizarComboBoxEstado() {

        List<Estado> listaEstado = new ArrayList<>();
        listaEstado.add(estadoDois);
        listaEstado.add(estadoUm);

        ComoboBoxModel model = new ComoboBoxModel();
        model.addListEstado(listaEstado);
        viewCombo.getComboEstado().setModel(model);

    }

    public void atualizarComboBoxCidade() {

        List<Cidade> listaCidade = new ArrayList<>();
        listaCidade.add(cidadeUm);
        listaCidade.add(cidadeDois);
        listaCidade.add(cidadeTres);
        listaCidade.add(cidadeQuatro);

        List<Cidade> listaCidadeModel = new ArrayList<>();

        for (Cidade cidade : listaCidade) {
            if (cidade.getEstado().equals(viewCombo.getComboEstado().getSelectedItem())) {
                listaCidadeModel.add(cidade);
            }
        }

        ComboDoisModel model2 = new ComboDoisModel();
        model2.addListCidade(listaCidadeModel);
        viewCombo.getComboCidade().setModel(model2);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    }

}
