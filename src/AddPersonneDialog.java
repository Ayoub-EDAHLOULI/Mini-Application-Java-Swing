import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddPersonneDialog extends JDialog {

    public AddPersonneDialog(JFrame mainFrame, MyModel model) {
        this.setTitle("Ajouter un contact");
        this.setSize(400, 250);
        this.setLocationRelativeTo(mainFrame);


        JPanel contentPane = (JPanel)this.getContentPane();

        // Implement The North
        JPanel northPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        JTextField nomTextField = new JTextField();
        JLabel prenomLabel = new JLabel("Prenom");
        JTextField prenomTextField = new JTextField();
        JLabel telLabel = new JLabel("Telephone");
        JTextField telTextField = new JTextField();

        northPanel.add(new JLabel("Nom"));
        northPanel.add(nomTextField);
        northPanel.add(prenomLabel);
        northPanel.add(prenomTextField);
        northPanel.add(telLabel);
        northPanel.add(telTextField);

        // Buttons
        JPanel southPanel = new JPanel();
        JButton saveButton = new JButton("Enregister");
        JButton closeButton = new JButton("Fermer");
        southPanel.add(saveButton);
        southPanel.add(closeButton);

        // Add Events
        closeButton.addActionListener((e) -> {
            this.dispose();
        });

        saveButton.addActionListener((e) -> {
            Personne personne = new Personne(nomTextField.getText(), prenomTextField.getText(), telTextField.getText());
            model.addPersonne(personne);

            // Empty the textfields
            nomTextField.setText("");
            prenomTextField.setText("");
            telTextField.setText("");
        });



        // Add To ContentPane
        contentPane.add(northPanel, BorderLayout.NORTH);
        contentPane.add(southPanel, BorderLayout.SOUTH);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


        this.setVisible(true);
    }

}
