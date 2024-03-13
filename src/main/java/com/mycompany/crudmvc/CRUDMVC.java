package com.mycompany.crudmvc;

import com.mycompany.crudmvc.controller.CtrlProducto;
import com.mycompany.crudmvc.model.ConsultasProducto;
import com.mycompany.crudmvc.model.Producto;
import com.mycompany.crudmvc.view.frmProducto;

public class CRUDMVC {

    public static void main(String[] args) {
        Producto mod = new Producto();
        ConsultasProducto modC = new ConsultasProducto();
        frmProducto frm = new frmProducto();

        CtrlProducto ctrl = new CtrlProducto(mod, modC, frm);
        ctrl.iniciar();
    }
}
