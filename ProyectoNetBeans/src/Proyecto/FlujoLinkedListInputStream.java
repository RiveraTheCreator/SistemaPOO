package Proyecto;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlujoLinkedListInputStream {
    private final String archivo;
    private ObjectInputStream ois;
    private FileInputStream fis;

    public FlujoLinkedListInputStream(String archivo) {
        this.archivo = archivo;
        ois = null;
        fis = null;
    }

    private void abrirFlujo() {
        try {
            fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FlujoLinkedListInputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FlujoLinkedListInputStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cerrarFlujo() {
        if (ois != null) {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(FlujoLinkedListInputStream.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Object> leerObjetos() {
        abrirFlujo();
        LinkedList<Object> lista = new LinkedList<>();
        try {

            lista = (LinkedList<Object>)ois.readObject();
        } catch (EOFException eof) {
            Logger.getLogger(FlujoLinkedListInputStream.class.getName()).log(Level.SEVERE, null, eof);

        } catch (IOException ex) {
            Logger.getLogger(FlujoLinkedListInputStream.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FlujoLinkedListInputStream.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cerrarFlujo();
        }
        return lista;
    }
}

