package beans;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author am
 */
public class DBAccess extends SuperBb {

    protected Integer user_id;
    protected Integer theater_id;
    protected Integer seat_id;
    protected String field_users;
    protected String search_users;
    protected String operator_users;
    protected String field_theaters;
    protected String search_theaters;
    protected String operator_theaters;

    protected static Map<String, String> items_users_field;

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

    protected static Map<String, String> items_users_operator;

    static {
        items_users_operator = new LinkedHashMap<>();
        items_users_operator.put("を含む", "users_include");
        items_users_operator.put("以上", "users_and_over");
        items_users_operator.put("以下", "users_and_less");
    }

    public Map<String, String> getItems_users_operator() {
        return items_users_operator;
    }

    protected static Map<String, String> items_theators_field;

    static {
        items_theators_field = new LinkedHashMap<>();
        items_theators_field.put("ID", "theater_info_id");
        items_theators_field.put("シアターNo", "room_num");
        items_theators_field.put("映画タイトル", "movietitle");
        items_theators_field.put("上映日時", "showtime");
    }

    public Map<String, String> getItems_theators_field() {
        return items_theators_field;
    }

    protected static Map<String, String> items_theators_operator;

    static {
        items_theators_operator = new LinkedHashMap<>();
        items_theators_operator.put("を含む", "theaters_inclede");
        items_theators_operator.put("以上", "theaters_and_over");
        items_theators_operator.put("以下", "theaters_and_less");
    }

    public Map<String, String> getItems_theators_operator() {
        return items_theators_operator;
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

    public String getField_users() {
        return field_users;
    }

    public void setField_users(String field_users) {
        this.field_users = field_users;
    }

    public String getSearch_users() {
        return search_users;
    }

    public void setSearch_users(String search_users) {
        this.search_users = search_users;
    }

    public String getOperator_users() {
        return operator_users;
    }

    public void setOperator_users(String operator_users) {
        this.operator_users = operator_users;
    }

    public String getField_theaters() {
        return field_theaters;
    }

    public void setField_theaters(String field_theaters) {
        this.field_theaters = field_theaters;
    }

    public String getSearch_theaters() {
        return search_theaters;
    }

    public void setSearch_theaters(String search_theaters) {
        this.search_theaters = search_theaters;
    }

    public String getOperator_theaters() {
        return operator_theaters;
    }

    public void setOperator_theaters(String operator_theaters) {
        this.operator_theaters = operator_theaters;
    }

    private void init() {
    }

    public void addUser() {
    }

    public void updateUser() {
    }

    public void searchUsers() {
    }

    public void deleteUser() {
    }

    public void getResultUsers() {
    }

    public void addTheater() {
    }

    public void updateTheater() {
    }

    public void searchTheaters() {
    }

    public void deleteTheater() {
    }

    public void getResultTheaters() {
    }

    public void getHasSeat() {
    }

    public String theatersVarClear() {
        theater_info_id = room_num = seat_id = null;
        movietitle = showdate = showtime = null;
        return null;
    }

}
