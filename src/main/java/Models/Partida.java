/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.time.OffsetDateTime;

/**
 *
 * @author cmate
 */
public class Partida {
    
    private int id;
    private OffsetDateTime data;
    private String vencedor;
    private String perdedor;
    private int campeonatoId;

    public Partida() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OffsetDateTime getData() {
        return data;
    }

    public void setData(OffsetDateTime data) {
        this.data = data;
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    public String getPerdedor() {
        return perdedor;
    }

    public void setPerdedor(String perdedor) {
        this.perdedor = perdedor;
    }

    public int getCampeonatoId() {
        return campeonatoId;
    }

    public void setCampeonatoId(int campeonatoId) {
        this.campeonatoId = campeonatoId;
    }

    @Override
    public String toString() {
        return id + " " + " " + data + " " + vencedor + " " + perdedor + " " +campeonatoId;
    }
    
    
    
    
}
