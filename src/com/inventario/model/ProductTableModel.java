package com.inventario.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.ArrayList;

public class ProductTableModel extends AbstractTableModel {
    private final List<Product> productList;
    private final String[] columnNames = {"ID", "Nombre", "Precio", "Cantidad"};

    public ProductTableModel() {
        this.productList = new ArrayList<>();
    }

    // Implementa los métodos requeridos (getRowCount, getColumnCount, getValueAt)

    public int getRowCount() {
        return productList.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = productList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return product.getId();
            case 1:
                return product.getName();
            case 2:
                return product.getPrice();
            case 3:
                return product.getQuantity();
            default:
                return null;
        }
    }

    // Agrega el método addProduct
    public void addProduct(Product product) {
        productList.add(product);
        fireTableRowsInserted(productList.size() - 1, productList.size() - 1);
        // Notifica a la tabla sobre la nueva fila
    }
}