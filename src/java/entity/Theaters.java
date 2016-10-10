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
@Table(name = "theater_info")
public class Theaters implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer room_num;
    private String movietitle;
    private String showdate;
    private String showtime;
    private Boolean[] hasSeats;
    
    private Users users;

    public Theaters() {
    }

    public Theaters(Integer room_num, String movietitle, String showdate, String showtime) {
        this.room_num = room_num;
        this.movietitle = movietitle;
        this.showdate = showdate;
        this.showtime = showtime;
    }

    public Theaters(Integer room_num, String movietitle, String showdate, String showtime, Boolean[] hasSeats, Users users) {
        // コンストラクタ起動時に中身を作り、全てfalseにする。
        // booleanではなくbooleanなので、初期値がfalseではなくnullになるはずなので
        hasSeats = new Boolean[100];
        for(Boolean seat:hasSeats){
            seat=false;
        }
        
        this.room_num = room_num;
        this.movietitle = movietitle;
        this.showdate = showdate;
        this.showtime = showtime;
        this.hasSeats = hasSeats;
        this.users = users;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoom_num() {
        return room_num;
    }

    public void setRoom_num(Integer room_num) {
        this.room_num = room_num;
    }

    public String getMovietitle() {
        return movietitle;
    }

    public void setMovietitle(String movietitle) {
        this.movietitle = movietitle;
    }

    public String getShowdate() {
        return showdate;
    }

    public void setShowdate(String showdate) {
        this.showdate = showdate;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }

    public Boolean[] getHasSeats() {
        return hasSeats;
    }

    public void setHasSeats(Boolean[] hasSeats) {
        this.hasSeats = hasSeats;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }


}
