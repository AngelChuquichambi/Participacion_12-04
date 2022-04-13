package com.emergentes.modelo;

public class tarea {

    private int id;
    private String tarea;
    private String prioridad;

    public tarea() {
    }

    public tarea(int id, String tarea, String prioridad) {
        this.id = id;
        this.tarea = tarea;
        this.prioridad = prioridad;
    }

    public int getId() {
        return id;
    }

    public String getTarea() {
        return tarea;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

}
