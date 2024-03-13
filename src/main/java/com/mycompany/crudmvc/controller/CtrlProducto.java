package com.mycompany.crudmvc.controller;

import com.mycompany.crudmvc.model.ConsultasProducto;
import com.mycompany.crudmvc.model.Producto;
import com.mycompany.crudmvc.view.frmProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlProducto implements ActionListener {

    private Producto mod;
    private ConsultasProducto modC;
    private frmProducto frm;

    public CtrlProducto(Producto mod, ConsultasProducto modC, frmProducto frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Productos");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);
        frm.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnGuardar) {
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            if (modC.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Guardado exitoso");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }
        }

        if (e.getSource() == frm.btnModificar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            if (modC.modificar(mod)) {
                JOptionPane.showMessageDialog(null, "Registo modificado exitosamente");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        }

        if (e.getSource() == frm.btnEliminar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            if (modC.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }

        if (e.getSource() == frm.btnBuscar) {
            mod.setCodigo(frm.txtCodigo.getText());
            if (modC.buscar(mod)) {
                frm.txtId.setText(String.valueOf(mod.getId()));
                frm.txtCantidad.setText(String.valueOf(mod.getCantidad()));
                frm.txtCodigo.setText(mod.getCodigo());
                frm.txtPrecio.setText(String.valueOf(mod.getPrecio()));
                frm.txtNombre.setText(mod.getNombre());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el registro");
                limpiar();
            }
        }

        if (e.getSource() == frm.btnLimpiar) {
            limpiar();
        }
    }

    public void limpiar() {
        frm.txtCantidad.setText(null);
        frm.txtCodigo.setText(null);
        frm.txtId.setText(null);
        frm.txtNombre.setText(null);
        frm.txtPrecio.setText(null);
    }
}
