package beans;

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
    
    public String doSearchUsers(){
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
