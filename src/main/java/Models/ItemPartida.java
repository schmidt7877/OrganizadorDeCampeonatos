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
public class ItemPartida {
    
    private int id;
    private int mapaId;
    private int timeAId;
    private int timeBId;
    private int partidaId;
    private int campeonatoId;
    private OffsetDateTime dataInicio;
    private OffsetDateTime dataFinal;
    private String status;

    public ItemPartida() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMapaId() {
        return mapaId;
    }

    public void setMapaId(int mapaId) {
        this.mapaId = mapaId;
    }

    public int getTimeAId() {
        return timeAId;
    }

    public void setTimeAId(int timeAId) {
        this.timeAId = timeAId;
    }

    public int getTimeBId() {
        return timeBId;
    }

    public void setTimeBId(int timeBId) {
        this.timeBId = timeBId;
    }

    public int getPartidaId() {
        return partidaId;
    }

    public void setPartidaId(int partidaId) {
        this.partidaId = partidaId;
    }

    public int getCampeonatoId() {
        return campeonatoId;
    }

    public void setCampeonatoId(int campeonatoId) {
        this.campeonatoId = campeonatoId;
    }

    public OffsetDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(OffsetDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public OffsetDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(OffsetDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }

     public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
 
    
    
}
