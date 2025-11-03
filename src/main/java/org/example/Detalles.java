package org.example;

import javax.swing.*;
import java.awt.event.*;

public class Detalles extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel lblDetalles;
    private JLabel lblCorreo;
    private JLabel lblPais;
    private JLabel lblPlataforma;
    private Principal ventanaPrincipal;
    private Usuario usuario;

    public Detalles(Principal principal,Usuario usuario) {
        super(principal, true);
        this.ventanaPrincipal = principal;
        this.usuario = usuario;
        setContentPane(contentPane);
        setSize(400,300);
        setLocationRelativeTo(null);
        setModal(true);
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

        cargarDetalles();
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

    private void cargarDetalles() {
        lblCorreo.setText("Correo: "+usuario.getCorreo());
        lblPais.setText("Pais: "+usuario.getPais());
        lblPlataforma.setText("Plataforma: "+usuario.getPlataforma());
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
