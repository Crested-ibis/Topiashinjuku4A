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
    private Integer reservedSeatId;
    private Theaters theaters;

    public Seats() {}

    public Seats(Integer reservedSeatId) {
        this.reservedSeatId = reservedSeatId;
    }
    
    

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Integer getReservedSeatId() {
        return reservedSeatId;
    }

    public void setReservedSeatId(Integer reservedSeatId) {
        this.reservedSeatId = reservedSeatId;
    }

    public Theaters getTheaters() {
        return theaters;
    }

    public void setTheaters(Theaters theaters) {
        this.theaters = theaters;
    }

    
}
