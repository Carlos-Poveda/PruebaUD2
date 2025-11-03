package org.example;

import javax.swing.*;
import java.awt.event.*;

public class AgregarUsuario extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel lblAgregar;
    private JLabel lblCorreo;
    private JTextField tfCorreo;
    private JLabel lblPais;
    private JTextField tfPais;
    private JLabel lblPlataforma;
    private JTextField tfPlataforma;
    private Principal ventanaPrincipal;

    public AgregarUsuario(Principal parent) {
        super(parent, true);
        this.ventanaPrincipal = parent;
        setContentPane(contentPane);
        setModal(true);
        setSize(500, 300);
        setTitle("Agregar Usuario");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        Usuario usuario = new Usuario();
        if (tfCorreo.getText().isEmpty() || tfPais.getText().isEmpty() || tfPlataforma.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error en la inserción, no se permiten campos vacíos");
        } else {
            usuario.setCorreo(tfCorreo.getText());
            usuario.setPais(tfPais.getText());
            usuario.setPlataforma(tfPlataforma.getText());
        }

        ventanaPrincipal.agregarUsuario(usuario);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
