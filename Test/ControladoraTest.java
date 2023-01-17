/*
* Andre marroquin
* Gabriel Paz
* Andy Fuentes
* HT 1 ESTRUCTURA DE DATOS
*
* */


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControladoraTest {

    @Test
    void turn() {
        Controladora controladora = new Controladora();
        assertTrue(controladora.radio.isOn());
        assertFalse(controladora.radio.isOn());
    }

    @Test
    void cambioFrecuencia() {
    Controladora controladora = new Controladora();
    try {
        controladora.cambioFrecuencia();
        assertEquals("FM", controladora.radio.getFrequence());
        controladora.cambioFrecuencia();
        assertEquals("AM", controladora.radio.getFrequence());
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    @Test
    void adelantar() {
        Controladora controladora = new Controladora();
        controladora.adelantar();
        assertEquals(540, controladora.radio.getAMActualStation());
        controladora.adelantar();
        assertEquals(550, controladora.radio.getAMActualStation());

    }

    @Test
    void atrasar() {
        Controladora controladora = new Controladora();
        controladora.atrasar();
        assertEquals(1610, controladora.radio.getAMActualStation());
        controladora.atrasar();
        assertEquals(1600, controladora.radio.getAMActualStation());
    }

    @Test
    void guardar() {
        Controladora controladora = new Controladora();
        controladora.guardar(1);
        assertEquals(530, controladora.radio.getAMSlot(1));
        controladora.adelantar();
        controladora.guardar(2);
        assertEquals(540, controladora.radio.getAMSlot(2));
    }

    @Test
    void seleccionar() {
        Controladora controladora = new Controladora();
        controladora.guardar(1);
        controladora.guardar(2);
        controladora.seleccionar(1);
        assertEquals(530, controladora.radio.getAMActualStation());
        controladora.seleccionar(2);
        controladora.adelantar();
        assertEquals(540, controladora.radio.getAMActualStation());
    }
}