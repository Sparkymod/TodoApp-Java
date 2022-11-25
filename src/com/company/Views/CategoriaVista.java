package com.company.Views;

import com.company.Database.DbStorage;
import com.company.Models.Categoria;
import com.company.Models.Propietario;
import com.company.Models.Tarea;

import javax.swing.*;
import java.awt.event.*;

public class CategoriaVista extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtCategoria;
    private JLabel labelDescripcion;

    private Categoria categoriaActual;
    private boolean editando = false;

    public CategoriaVista() {
        setContentPane(contentPane);
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

        asignarTextos();
    }

    private void onOK() {
        agregarTarea();
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void agregarTarea() {
        if (categoriaActual == null) {
            categoriaActual = new Categoria();
        }

        categoriaActual.setDescripcion(txtCategoria.getText());

        if (editando) {
            DbStorage.editarCategoria(categoriaActual);
        } else {
            DbStorage.agregarCategoria(categoriaActual);
        }
    }

    public void editarCategoria(Categoria categoria) {
        if (categoria == null) {
            editando = false;
        } else {
            editando = true;
            categoriaActual = categoria;
            txtCategoria.setText(categoriaActual.getDescripcion());
        }
    }

    private void asignarTextos() {
        labelDescripcion.setText("Descripción");
        buttonOK.setText("Aplicar");
    }
}
