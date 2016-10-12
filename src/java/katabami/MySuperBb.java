package katabami;

import beans.*;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author am
 */
public class MySuperBb implements Serializable {
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
    protected Boolean[] hasSeats;
    protected Boolean is_editable_users = false;
    protected Boolean is_editable_theaters = false;

    protected static Map<String, String> items_users_field;
    protected static Map<String, String> items_users_operator;
    protected static Map<String, String> items_theaters_field;
    protected static Map<String, String> items_theaters_operator;

    static {
        items_users_field = new LinkedHashMap<>();
        items_users_field.put("ID", "user_id");
        items_users_field.put("氏名（漢字）", "name_kanji");
        items_users_field.put("氏名（カナ）", "name_kana");
        items_users_field.put("電話番号", "tel");
        items_users_field.put("メールアドレス", "email");
        items_users_field.put("生年月日", "age");
        items_users_field.put("性別", "sex");
        items_users_field.put("登録日", "register");
    }

    public Map<String, String> getItems_users_field() {
        return items_users_field;
    }

    static {
        items_users_operator = new LinkedHashMap<>();
        items_users_operator.put("を含む", "users_include");
        items_users_operator.put("以上", "users_and_over");
        items_users_operator.put("以下", "users_and_less");
    }

    public Map<String, String> getItems_users_operator() {
        return items_users_operator;
    }

    static {
        items_theaters_field = new LinkedHashMap<>();
        items_theaters_field.put("ID", "theater_info_id");
        items_theaters_field.put("シアターNo", "room_num");
        items_theaters_field.put("映画タイトル", "movietitle");
        items_theaters_field.put("上映日時", "showtime");
    }

    public Map<String, String> getItems_theaters_field() {
        return items_theaters_field;
    }

    static {
        items_theaters_operator = new LinkedHashMap<>();
        items_theaters_operator.put("を含む", "theaters_inclede");
        items_theaters_operator.put("以上", "theaters_and_over");
        items_theaters_operator.put("以下", "theaters_and_less");
    }

    public Map<String, String> getItems_theaters_operator() {
        return items_theaters_operator;
    }

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
        MySuperBb.items_sex = items_sex;
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

    public Boolean[] getHasSeats() {
        return hasSeats;
    }

    public void setHasSeats(Boolean[] hasSeats) {
        this.hasSeats = hasSeats;
    }
    
    
}
