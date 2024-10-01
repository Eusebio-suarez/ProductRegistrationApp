package com.inventario.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.inventario.model.Product;
import com.inventario.model.ProductTableModel;

import static java.awt.SystemColor.text;

public class ProductRegistrationFrame extends JFrame {
    // componentes de la UI
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtCantidad;
    private JButton btnGuardar;
    private ProductTableModel productTableModel;

    public ProductRegistrationFrame() {
        this.productTableModel =new ProductTableModel();
        setTitle("Registro de Productos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //inicializar componentes
        initComponents();
    }

    private void initComponents() {
        // Panel para ingresar datos
        JPanel panel = new JPanel(new GridLayout(5, 2, 15, 10));

        // Etiquetas y campos de texto
        panel.add(new JLabel("ID"));
        // campo para ingresar ID
        txtId = new JTextField();
        panel.add(txtId);

        panel.add(new JLabel("Nombre:"));
        //campo para ingresar Nombre
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Precio:"));
        //campo para ingresar precio
        txtPrecio = new JTextField();
        panel.add(txtPrecio);

        panel.add(new JLabel("Cantidad:"));
        //campo para ingresar Cantidad
        txtCantidad = new JTextField();
        panel.add(txtCantidad);

        // Botón de guardado
        btnGuardar = new JButton("Guardar");
        panel.add(btnGuardar);

        // Añadir acción al botón de guardar
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                saveProduct();
            }
        });

        // Agregar panel al frame
        add(panel, BorderLayout.CENTER);
    }

    private void saveProduct() {
        try {
            // Obtener los valores de los campos de texto ingresados
            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            double precio = Double.parseDouble(txtPrecio.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());

            // Crear un producto
            Product product = new Product(id, nombre, precio, cantidad);

            // Agregar el producto
            productTableModel.addProduct(product);

            // Limpiar los campos
            clearFields();


            JOptionPane.showMessageDialog(this, "Producto guardado.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //limpiar los campos luego de guardar
    private void clearFields() {
        txtId.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
    }
}
