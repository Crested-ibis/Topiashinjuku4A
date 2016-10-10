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
    private Integer id;
    private Boolean[] hasSeat;

    public Seats() {
//        コンストラクタ起動時に配列の中身を制作し、全てfalseにする
        hasSeat = new Boolean[100];
        for (boolean seat : hasSeat) {
            seat = false;
        }
    }

}
