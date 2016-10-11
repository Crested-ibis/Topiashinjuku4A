package beans;

import entity.Theaters;
import entity.Users;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author am
 */
@Named
@SessionScoped
public class Bb extends DBAccess {

    public Bb() {
    }

    @PostConstruct
    private void init() {
        Users u = new Users("斎藤 隆", "サイトウ タカシ", "042-565-2967", "takashi_revolution@ezweb.ne.jp", "1976-01-01", "男 ", "abcd9999", "2016-10-10");
        usersDb.add(u);

        hasSeats = new Boolean[100];
        for (Boolean seat : hasSeats) {
            seat = false;
        }
        int[] num = {2, 3, 5, 10, 12, 30, 50, 70, 90, 99};
        for (int n : num) {
            hasSeats[n] = true;
        }
        Theaters th = new Theaters(4, "渚にて", "1958-07-31", "12:00", hasSeats, u);

        List<Theaters> li = u.getTheaterses();
        li.add(th);

        usersDb.update(u);
        li.clear();
    }

    private void initRegisterPage() {

    }

    private void RegisterPage() {
    }

    public void dispSeats() {
    }

    public String usersVarClear() {
        name_kanji = name_kana = tel = email = age = sex = register = null;
        return null;
    }

    public String theatersVarClear() {
        theater_info_id = room_num = seat_id = null;
        movietitle = showdate = showtime = null;
        return null;
    }

    public String doSearchUsers() {
        um.getFromDb(field_users, search_users, operator_users);
        return null;
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

    // テストページ用
    public String goOutput() {
        return "output.xhtml";
    }

}
