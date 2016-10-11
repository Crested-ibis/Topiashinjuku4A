/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    private Users users;

    @OneToMany(mappedBy = "theaters",cascade = {CascadeType.ALL})
    private List<Seats> seatses;
    
    public Theaters() {
    }

        // 編集用のID付きコンストラクタ。Usersは編集しない
    public Theaters(Integer id, Integer room_num, String movietitle, String showdate, String showtime) {
        this.id = id;
        this.room_num = room_num;
        this.movietitle = movietitle;
        this.showdate = showdate;
        this.showtime = showtime;

    }


    public Theaters(Integer room_num, String movietitle, String showdate, String showtime,Users users) {
        this.seatses = new ArrayList<>();

        this.room_num = room_num;
        this.movietitle = movietitle;
        this.showdate = showdate;
        this.showtime = showtime;
        this.users = users;
    }

    /**
     * インスタンス化時にList<Seats>を予め入れておく場合
     * @param room_num
     * @param movietitle
     * @param showdate
     * @param showtime
     * @param users
     * @param seatses 
     */
    public Theaters(Integer room_num, String movietitle, String showdate, String showtime, Users users, List<Seats> seatses) {
        this.room_num = room_num;
        this.movietitle = movietitle;
        this.showdate = showdate;
        this.showtime = showtime;
        this.users = users;
        this.seatses = seatses;
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


    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public List<Seats> getSeatses() {
        return seatses;
    }

    public void setSeatses(List<Seats> seatses) {
        this.seatses = seatses;
    }
}
