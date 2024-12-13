import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class MyModel extends AbstractTableModel {

    private String[] headers = {"Nom", "Prenom", "Teléphone"};
    private List<Personne> list = new ArrayList<>();

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Personne p = list.get(rowIndex);
        switch (columnIndex) {
            case 0: return p.getNom();
            case 1: return p.getPrenom();
            case 2: return p.getTelephone();
            default: return null;
        }
    }

    public void addPersonne(Personne p) {
        System.out.println("Nom : " +p.getNom() + " - " + "Prenom : " + p.getPrenom() + " - " + "Telephone " + p.getTelephone());
        list.add(p);
        this.fireTableDataChanged();
    }

    public void removePersonne(int index) {
        list.remove(index);
        this.fireTableDataChanged();
    }
}
