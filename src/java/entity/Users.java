/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author melli
 */
@Entity
@Table(name = "user_info")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name_kanji;
    private String name_kana;
    private String tel;
    private String email;
    private String age;
    private String sex;
    private String password;
    private String register;
    
    // UsersエンティティはTheatersエンティティに対するすべての権限を持つ
    @ManyToMany(mappedBy = "users",cascade = {CascadeType.ALL})
    private List<Theaters> theaterses;

    public Users() {
    }

    public Users(String name_kanji, String name_kana, String tel, String email, String age, String sex, String password, String register) {
        this.name_kanji = name_kanji;
        this.name_kana = name_kana;
        this.tel = tel;
        this.email = email;
        this.age = age;
        this.sex = sex;
        this.password = password;
        this.register = register;
    }

    public Users(String name_kanji, String name_kana, String tel, String email, String age, String sex, String password, String register, List<Theaters> theaterses) {
        this.name_kanji = name_kanji;
        this.name_kana = name_kana;
        this.tel = tel;
        this.email = email;
        this.age = age;
        this.sex = sex;
        this.password = password;
        this.register = register;
        this.theaterses = theaterses;
    }
    
    

    public String getName_kanji() {
        return name_kanji;
    }

    public void setName_kanji(String name_kanji) {
        this.name_kanji = name_kanji;
    }

    public String getName_kana() {
        return name_kana;
    }

    public void setName_kana(String name_kana) {
        this.name_kana = name_kana;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Theaters> getTheaterses() {
        return theaterses;
    }

    public void setTheaterses(List<Theaters> theaterses) {
        this.theaterses = theaterses;
    }
    

}
