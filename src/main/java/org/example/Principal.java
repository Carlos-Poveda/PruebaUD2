package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Principal extends javax.swing.JFrame {
    private JTable tablaUsuarios;
    private JPanel panelPrincipal;
    private JButton btnAgregar;
    private JButton btnSalir;
    private JLabel lblTitulo;
    private ArrayList<Usuario> usuarios = new ArrayList<>();



    public Principal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Usuarios");
        setResizable(false);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setContentPane(panelPrincipal);
        setVisible(true);

        var modelo = new DefaultTableModel();
        modelo.addColumn("Correo");
        modelo.addColumn("País");
        modelo.addColumn("Plataforma");
        tablaUsuarios.setModel(modelo);
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("user1@example.com","España","Linux"));
        usuarios.add(new Usuario("user2@example.com","España","Linux"));
        usuarios.add(new Usuario("user3@example.com","España","Linux"));
        usuarios.add(new Usuario("user4@example.com","España","Linux"));
        usuarios.add(new Usuario("user5@example.com","España","Linux"));
        usuarios.add(new Usuario("user6@example.com","España","Linux"));

        loadDataTable();

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarUsuario agregar = new AgregarUsuario(Principal.this);
                agregar.setVisible(true);
            }
        });

        tablaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        tablaUsuarios.getSelectionModel().addListSelectionListener( (e)->{
            if(!e.getValueIsAdjusting() && tablaUsuarios.getSelectedRow() >= 0 ){

                int selectedRow = tablaUsuarios.getSelectedRow();
                Usuario usuario = usuarios.get(selectedRow);
                Detalles detalles = new Detalles(Principal.this,usuario);
                detalles.setVisible(true);
            }
        });


        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        lblTitulo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
    }



    private void loadDataTable() {
        DefaultTableModel modelo = (DefaultTableModel) tablaUsuarios.getModel();
        modelo.setRowCount(0);
        usuarios.forEach( (usuario) -> {
            var fila =  new Object[]{ usuario.getCorreo(), usuario.getPais(), usuario.getPlataforma() };
            modelo.addRow(fila);
        });
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        loadDataTable();
    }
}

