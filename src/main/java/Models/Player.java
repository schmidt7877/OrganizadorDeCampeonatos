/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author cmate
 */
public class Player {
    
    private int id;
    private String nome;
    private int timeId;
    private int campeonatoId;

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public int getCampeonatoId() {
        return campeonatoId;
    }

    public void setCampeonatoId(int campeonatoId) {
        this.campeonatoId = campeonatoId;
    }

}