import javax.swing.*;
import java.awt.*;


public class Main extends JFrame {

    public Main() {
        this.setTitle("Gestion de contacts");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel contentPane = (JPanel)this.getContentPane();

        // Initialize the Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Fichier");
        JMenuItem closeMenuItem = new JMenuItem("Fermer");
        fileMenu.add(closeMenuItem);

        JMenu helpMenu = new JMenu("Aide");
        JMenuItem aboutMenuItem = new JMenuItem("A propos");
        helpMenu.add(aboutMenuItem);

        // Adding Menu Choices to our MenuBar
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        this.setJMenuBar(menuBar);

        // Add Event
        closeMenuItem.addActionListener((e) -> {
            this.dispose();
        });


        // Table
        MyModel model = new MyModel();
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);


        // Buttons
        JPanel southPanel = new JPanel();
        JButton addButton = new JButton("Ajouter");
        JButton removeButton = new JButton("Supprimer");
        southPanel.add(addButton);
        southPanel.add(removeButton);

        // Buttons Events
        addButton.addActionListener((e) -> {
            new AddPersonneDialog(this, model);
        });

        removeButton.addActionListener((e) -> {
            int index = table.getSelectedRow();
            if(index == -1) {
                JOptionPane.showMessageDialog(this, "Aucune ligne selectionnée", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else {
                int reponse = JOptionPane.showConfirmDialog(this, "Etes vous sur de supprimer ?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if(reponse == JOptionPane.YES_OPTION) {
                    model.removePersonne(index);
                }
            }
        });

        // Add Buttons to the ContentPane
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(southPanel, BorderLayout.SOUTH);



        this.setVisible(true);
    }


    public static void main(String[] args) {

        new Main();
    }
}