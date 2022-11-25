package com.company.Views;

import com.company.Database.DbStorage;
import com.company.Models.Categoria;
import com.company.Models.Propietario;

import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;

public class PropietarioVista extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textNombre;
    private JLabel labelNombre;
    private JLabel labelFecha;
    private JComboBox boxFecha;
    private JCheckBox boxActivo;

    private Propietario propietarioActual;
    private boolean editando = false;

    public PropietarioVista() {
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
        if (propietarioActual == null) {
            propietarioActual = new Propietario();
        }

        propietarioActual.setNombre(textNombre.getText());
        propietarioActual.setFechaCreacion(Calendar.getInstance().getTime());
        propietarioActual.setActivo(boxActivo.isSelected());

        if (editando) {
//            DbStorage.editarCategoria(propietarioActual);
        } else {
            DbStorage.agregarPropietario(propietarioActual);
        }
    }

    public void editarPropietario(Propietario propietario) {
        if (propietario == null) {
            editando = false;
        } else {
            editando = true;
            propietarioActual = propietario;
            textNombre.setText(propietarioActual.getNombre());
            boxActivo.setSelected(propietarioActual.isActivo());
        }
    }

    private void asignarTextos() {
        labelNombre.setText("Nombre");
        labelFecha.setText("Fecha Creación");
        buttonOK.setText("Aplicar");
    }
}
