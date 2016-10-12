package beans;

import db.SeatsDb;
import db.TheatersDb;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.ejb.EJB;
import db.UsersDb;
import entity.Theaters;
import entity.Users;
import entity.Seats;
import java.util.ArrayList;
import java.util.List;
import beans.UsersManager;

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
    
    // この配列の位置の席を予約済みとする
    // addTheatersを動かす際には予め埋めておくこと
    protected List<Integer> seat_nums;

    // seat_numsを作るために用意
    protected Integer seat_num;
    
    private Users kari_user;

    protected Users result_user;

    @EJB
    UsersDb usersDb;
    @EJB
    TheatersDb theatersDb;
    @EJB
    SeatsDb seatsDb;

    @EJB
    UsersManager um;
    
    @EJB
    TheatersManager tm;

    public DBAccess() {
        super();
    }

    private void init() {
    }

    public void addUser() {
        kari_user = new Users(name_kanji, name_kana, tel, email, age, sex, password, register);
        usersDb.add(kari_user);
    }

    public void updateUser() {
        Users renewUser = new Users(user_id, name_kanji, name_kana, tel, email, age, sex, password, register);
        usersDb.update(renewUser);

    }

    public List<Users> getAllUsers() {
        return um.getAllUsers();
    }

    public void searchUsers() {
        result_user = (Users) usersDb.find(theater_info_id);
    }

    public void deleteUser() {
    }

    public List<Users> getResultUsers() {
        if (search_users != null) {
            return um.getFromDb(field_users, search_users, operator_users);
        } else {
            return null;
        }

    }
    

    public void addTheater() {
//        現在入力中のユーザ以外のシアター情報を更新したいなら、コッチを使う
//        Users kari_user = (Users) usersDb.find(1);
        
        // Users,Theaters,Seatsは入れ子構造で更新する

        // kari_userはaddUserで保存したUsersオブジェクトそのもの。いちいちDBにアクセスるのも良くないかと思い、そのまま使った。
        Theaters th1 = new Theaters(room_num, movietitle, showdate, showtime, kari_user);

            List<Seats> ls = th1.getSeatses();
            // Theaters追加時にSeatsを初期化する

            // seat_numsに基づき空席情報を埋める;
            String str = "";
            for(Integer num : seat_nums){
                ls.add(new Seats(num));
                str += String.valueOf(num) + ", ";
            }
            
            System.out.println(str + "を席テーブルに追加");

        List<Theaters> li = kari_user.getTheaterses();
        li.add(th1);
        // 「追加」メソッドではあるが、実際には更新処理を行う
        usersDb.update(kari_user);
        // 追加した後にList< Theaters>を空にしないと前の入力が一緒に書き込まれる。なぜ？
        li.clear();
    }
    

    public void updateTheater() {
        Theaters theater = (Theaters) theatersDb.find(theater_info_id);

        Integer nowId = theater.getId();
        theater = new Theaters(nowId, room_num, movietitle, showdate, showtime);
        theatersDb.update(theater);
    }
    
    public List<Theaters> getAllTheaters(){
        return tm.getAllTheaters();
    }


    public void searchTheaters() {
    }

    public void deleteTheater() {
    }

    public void getResultTheaters() {
    }

    public void getHasSeat() {
    }

    public Users getResult_user() {
        return result_user;
    }

    public void setResult_user(Users result_user) {
        this.result_user = result_user;
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

    public List<Integer> getSeat_nums() {
        return seat_nums;
    }

    public void setSeat_nums(List<Integer> seat_nums) {
        this.seat_nums = seat_nums;
    }

    public Integer getSeat_num() {
        return seat_num;
    }

    public void setSeat_num(Integer seat_num) {
        this.seat_num = seat_num;
    }

    
    

}
