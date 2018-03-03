/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

/**
 *
 * @author Alumnos
 */
public class Productos extends TipoProducto {
    private String nombre;
    private String fecha;
    private String gerente;

    public Productos(String nombre, String fecha, String gerente, char owner) {
        super(owner);
        this.nombre = nombre;
        this.fecha = fecha;
        this.gerente = gerente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getGerente() {
        return gerente;
    }
    
}
