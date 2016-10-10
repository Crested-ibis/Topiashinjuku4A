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

}
