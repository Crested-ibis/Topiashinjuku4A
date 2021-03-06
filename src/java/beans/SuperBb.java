package beans;

import entity.Theaters;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.context.FacesContext;

/**
 *
 * @author am
 */
public class SuperBb implements Serializable {

    // サーブレットにMapするキーを定数にして取り出し可能にする
    // 定数名に大文字を用いるとなんか妙なことになるので注意
    protected String deleteTheaterId = "deleteTheaterId";
    
    protected String u_id = "uUserId";
    protected String u_kanji = "uUserNKanji";
    protected String u_kana = "uUserNKana";
    protected String u_tel = "uUserTel";
    protected String u_email = "uUserEmail";
    protected String u_age = "uUserAge";
    protected String u_sex = "uUserSex";
    protected String u_password = "uUserPassword";
    protected String u_register = "uUserRegister";

    protected String t_id = "tid";
    protected String t_room = "troom";
    protected String t_mtitle ="tmtitle";
    protected String t_sdate = "tsdate";
    protected String t_stime = "tstime";

    protected Integer user_id;
    protected Integer theater_id;
    protected Integer seat_id;

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
    protected Boolean is_editable_add_reservation = false;

    public Boolean getIs_editable_add_reservation() {
        return is_editable_add_reservation;
    }

    public void setIs_editable_add_reservation(Boolean is_editable_add_reservation) {
        this.is_editable_add_reservation = is_editable_add_reservation;
    }

    protected static Map<String, String> items_users_field;
    protected static Map<String, String> items_users_operator;
    protected static Map<String, String> items_theaters_field;
    protected static Map<String, String> items_theaters_operator;

    static {
        items_users_field = new LinkedHashMap<>();
        items_users_field.put("ID", "id");
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
        items_users_operator.put("を含む", "include");
        items_users_operator.put("以上", "andover");
        items_users_operator.put("以下", "andless");
    }

    public Map<String, String> getItems_users_operator() {
        return items_users_operator;
    }

    static {
        items_theaters_field = new LinkedHashMap<>();
        items_theaters_field.put("ID", "id");
        items_theaters_field.put("シアターNo", "room_num");
        items_theaters_field.put("映画タイトル", "movietitle");
        items_theaters_field.put("上映月日", "showdate");
        items_theaters_field.put("上映時間", "showtime");
    }

    public Map<String, String> getItems_theaters_field() {
        return items_theaters_field;
    }

    static {
        items_theaters_operator = new LinkedHashMap<>();
        items_theaters_operator.put("を含む", "include");
        items_theaters_operator.put("以上", "andover");
        items_theaters_operator.put("以下", "andless");
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
        SuperBb.items_sex = items_sex;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(Integer theater_id) {
        this.theater_id = theater_id;
    }

    public Integer getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(Integer seat_id) {
        this.seat_id = seat_id;
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

    public String getDeleteTheaterId() {
        return deleteTheaterId;
    }

    public String getU_id() {
        return u_id;
    }

    public String getU_kanji() {
        return u_kanji;
    }

    public String getU_kana() {
        return u_kana;
    }

    public String getU_tel() {
        return u_tel;
    }

    public String getU_email() {
        return u_email;
    }

    public String getU_age() {
        return u_age;
    }

    public String getU_sex() {
        return u_sex;
    }

    public String getU_password() {
        return u_password;
    }

    public String getU_register() {
        return u_register;
    }

    public String getT_id() {
        return t_id;
    }

    public String getT_room() {
        return t_room;
    }

    public String getT_mtitle() {
        return t_mtitle;
    }

    public String getT_sdate() {
        return t_sdate;
    }

    public String getT_stime() {
        return t_stime;
    }
    
    

}
