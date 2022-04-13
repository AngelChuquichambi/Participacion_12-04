package com.emergentes.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class gestortareas {
    
    private ArrayList<tarea> lista;

    public gestortareas() {
        
        lista = new ArrayList<tarea>();
    }

    public ArrayList<tarea> getLista() {
        return lista;
    }

    public void setLista(ArrayList<tarea> lista) {
        this.lista = lista;
    }

    public void insertarTarea(tarea item)
    {
        lista.add(item);
    }
    
    public void modificarTarea(int pos, tarea item)
    {
        lista.set(pos, item);
    }
    
    public void eliminarTarea(int pos)
    {
        lista.remove(pos);
    }
    
    public int obtieneId()
    {
        int id = 0;
        
        for(tarea item: lista)
        {
            id = item.getId();
        }
        return id + 1;
    }
    
    public int ubicarTarea(int id)
    {
        int pos = -1;
        Iterator<tarea> it = lista.iterator();
        
        while(it.hasNext())
        {
            ++pos;
            tarea aux = it.next();
            
            if (aux.getId() == id) {
                break;
            }
        }
        return pos;
    }
    
}
