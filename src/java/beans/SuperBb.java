package beans;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author am
 */
public class SuperBb implements Serializable {
    // DBAccess 用スーパークラス

    protected String name_kanji;
    protected String name_kana;
    protected String tel;
    protected String email;
    protected String age;
    protected String sex;
    protected String password;
    protected String register;
    protected Integer theater_info_id;
    protected Integer room_num;
    protected String movietitle;
    protected String showdate;
    protected String showtime;
    protected Boolean is_editable_users;
    protected Boolean is_editable_theaters;

    public Boolean getIs_editable_users() {
        return is_editable_users;
    }

    public void setIs_editable_users(Boolean is_editable_users) {
        this.is_editable_users = is_editable_users;
    }

    public Boolean getIs_editable_theaters() {
        return is_editable_theaters;
    }

    public void setIs_editable_theaters(Boolean is_editable_theaters) {
        this.is_editable_theaters = is_editable_theaters;
    }
    protected static Map<String, String> items_sex;

    static {
        items_sex = new LinkedHashMap<>();
        items_sex.put("男性", "male");
        items_sex.put("女性", "female");
    }

    public Map<String, String> getItems_sex() {
        return items_sex;
    }

    public void setItems_sex(Map<String, String> items_sex) {
        SuperBb.items_sex = items_sex;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        if (sex.equals("male")) {
            this.sex = "男";
        } else {
            this.sex = "女";
        }
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

    public Integer getTheater_info_id() {
        return theater_info_id;
    }

    public void setTheater_info_id(Integer theater_info_id) {
        this.theater_info_id = theater_info_id;
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

    public String goUsers() {
        return "db/users.xhtml";
    }

    public String goRegister() {
        return "db/register.xhtml";
    }

    public String goTheaters() {
        return "db/theaters.xhtml";
    }

    public String goEdit() {
        return "db/edit.xhtml";
    }

    public String goIndex() {
        return "index.xhtml";
    }

    public String goSeat() {
        return "db/select_seat.xhtml";
    }

    public String goOutput() {
        return "db/output.xhtml";
    }

}
