/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author melli
 */
@Entity
@Table(name = "seat_info")
public class Seats implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer seatId;
    private Boolean hasSeat;

    private String test;
    
    private Theaters theaters;


    public Seats() {}

    /**
     * 新規登録用のIDなしバージョン
     * @param hasSeat
     * @param theaters 
     */
    public Seats(Boolean hasSeat, Theaters theaters) {
        this.hasSeat = hasSeat;
        this.theaters = theaters;
        
        this.test = "test";
    }

    /**
     * 更新用のIDありバージョン
     * @param id
     * @param hasSeat
     * @param theaters 
     */
    public Seats(Integer id, Boolean hasSeat, Theaters theaters) {
        this.seatId = id;
        this.hasSeat = hasSeat;
        this.theaters = theaters;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }
    
    public Boolean getHasSeat() {
        return hasSeat;
    }

    public void setHasSeat(Boolean hasSeat) {
        this.hasSeat = hasSeat;
    }

    public Theaters getTheaters() {
        return theaters;
    }

    public void setTheaters(Theaters theaters) {
        this.theaters = theaters;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
    
    

}
