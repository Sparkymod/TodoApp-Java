package com.company.Views;

import com.company.Models.Categoria;
import com.company.Models.Tarea;
import com.company.TodoApp;

import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;

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
    private JComboBox<Categoria> boxCategorias;

    private Tarea TareaActual;

    public AgregarVista() {
        if (TareaActual == null){
            TareaActual = new Tarea();
        }
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
    }

    private void onOK() {
        TareaActual = new Tarea();

        TareaActual.setTitulo("Prueba");
        TareaActual.setId(0);
        TareaActual.setDescripcion("Prueba de tarea");
        TareaActual.setCompletado(true);
        TareaActual.setFechaInicio(new Date(2022, Calendar.NOVEMBER,21));
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
