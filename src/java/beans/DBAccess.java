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
import javax.faces.context.FacesContext;

/**
 *
 * @author am
 */
public class DBAccess extends SuperBb {

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

    public void addUser() {
        kari_user = new Users(name_kanji, name_kana, tel, email, age, sex, password, register);
        usersDb.add(kari_user);
    }

    public void addRegisterUser() {
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
        try {
            usersDb.delete(kari_user);
        } catch (Exception e) {
            System.err.println("ユーザ削除失敗");
        }
    }

    public List<Users> findUsers() {
        List<Users> li = new ArrayList<>();

        // サーブレットから値を取得
        // ここはリクエストスコープなので、ページを遷移すると消えてしまうので注意
        Map<String, String> param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String uid = param.get("ed_user");

        Users u = null;

        if (uid != null) {
            Integer id = Integer.valueOf(uid);
            u = (Users) usersDb.find(id);
            kari_user = u;
        } else {
            u = kari_user;
        }

        li.add(u);

        return li;
    }

    public List<Users> getResultUsers() {
        if (search_users != null) {
            return um.getFromDb(field_users, search_users, operator_users);
        } else {
            return null;
        }
    }

    public List<Theaters> getResultTheaters() {
        if (search_theaters != null) {
            return tm.getFromDb(field_theaters, search_theaters, operator_theaters);
        } else {
            return null;
        }
    }

    public void addTheater() {
//        現在入力中のユーザ以外のシアター情報を更新したいなら、コッチを使う
        Map<String, String> param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String uid = param.get("ed_user");
        Users u = null;

        if (uid != null) {
            Integer id = Integer.valueOf(uid);
            u = (Users) usersDb.find(id);
        } else {
            u = kari_user;
        }

        // Users,Theaters,Seatsは入れ子構造で更新する
        // kari_userはaddUserで保存したUsersオブジェクトそのもの。いちいちDBにアクセスるのも良くないかと思い、そのまま使った。
        Theaters th1 = new Theaters(room_num, movietitle, showdate, showtime, u);

        List<Seats> ls = th1.getSeatses();
        // Theaters追加時にSeatsを初期化する

        // seat_numsに基づき空席情報を埋める;
        String str = "";
        for (Integer num : seat_nums) {
            ls.add(new Seats(num));
            str += String.valueOf(num) + ", ";
        }

        System.out.println(str + "を席テーブルに追加");

        List<Theaters> li = u.getTheaterses();
        li.add(th1);
        // 「追加」メソッドではあるが、実際には更新処理を行う
        usersDb.update(u);
        // 追加した後にList< Theaters>を空にしないと前の入力が一緒に書き込まれる。なぜ？
        li.clear();

    }

    public void updateTheater() {

        Theaters theater = (Theaters) theatersDb.find(theater_info_id);

        Integer nowId = theater.getId();
        theater = new Theaters(nowId, room_num, movietitle, showdate, showtime);
        theatersDb.update(theater);
    }

    public List<Theaters> getAllTheaters() {
        return tm.getAllTheaters();
    }

    public void searchTheaters() {
    }

    public void deleteTheater() {
        Map<String, String> param = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String tid = param.get(deleteTheaterId);

        if (tid != null) {
            Integer itid = Integer.valueOf(tid);
            Theaters dth = (Theaters) theatersDb.find(itid);
            theatersDb.delete(dth);
        }

    }

    public void getHasSeat() {
    }

    public Users getResult_user() {
        return result_user;
    }

    public void setResult_user(Users result_user) {
        this.result_user = result_user;
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
