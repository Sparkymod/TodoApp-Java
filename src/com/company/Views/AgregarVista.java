package com.company.Views;

import com.company.Database.DbStorage;
import com.company.Models.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;

public class AgregarVista extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel panelBotones;
    private JPanel panelTareaDatos;
    private JLabel labelTitulo;
    private JTextField txtTitulo;
    private JLabel labelDescripcion;
    private JTextField txtDescripcion;
    private JLabel labelCompletado;
    private JCheckBox boxCompletado;
    private JComboBox<String> boxCategorias;
    private JLabel labelPropietario;
    private JComboBox<String> boxPropietarios;
    private JLabel labelFechaInicial;
    private JComboBox boxFechaInicial;
    private JLabel labelFechaFinal;
    private JComboBox boxFechaFinal;

    private Tarea TareaActual;


    public AgregarVista() {
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

        cargarCategorias();
        cargarPropietarios();
    }

    private void asignarValoresATarea(){
        Categoria categoria = getCategoriaSeleccionado();
        Propietario propietario = getPropietarioSeleccionado();

        TareaActual.setTitulo(txtTitulo.getText());
        TareaActual.setDescripcion(txtDescripcion.getText());
        TareaActual.setCategoria(categoria);
        TareaActual.setPropietario(propietario);
        TareaActual.setCompletado(boxCompletado.isSelected());
    }

    private void onOK() {
        TareaActual = new Tarea();
        TareaActual.setTitulo("Prueba");
        TareaActual.setDescripcion("Prueba de tarea");
        TareaActual.setCompletado(true);

        DbStorage.agregarTarea(TareaActual);
        dispose();
    }

    private void cargarCategorias() {
        for (Categoria cat : DbStorage.Categorias) {
            boxCategorias.addItem(cat.getDescripcion());
        }
    }

    private void cargarPropietarios() {
        for (Propietario prop : DbStorage.Propietarios) {
            boxPropietarios.addItem(prop.getNombre());
        }
    }

    private Propietario getPropietarioSeleccionado() {
        Object categoriaSeleccionada = boxCategorias.getSelectedItem();

        if (categoriaSeleccionada != null) {
            Propietario propietario = DbStorage.obtenerPropietario(categoriaSeleccionada.toString());

            return propietario != null ? propietario : new Propietario();
        }
        return new Propietario();
    }

    private Categoria getCategoriaSeleccionado() {
        Object categoriaSeleccionada = boxCategorias.getSelectedItem();

        if (categoriaSeleccionada != null) {
            Categoria categoria = DbStorage.obtenerCategoria(categoriaSeleccionada.toString());

            return categoria != null ? categoria : new Categoria();
        }
        return new Categoria();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
