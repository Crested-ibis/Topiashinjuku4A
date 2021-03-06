package katabami;

import entity.Theaters;
import entity.Users;
import entity.Seats;
import java.util.ArrayList;
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
public class MyBb extends MyDBAccess {

    public MyBb() {
    }

    @PostConstruct
    private void init() {
        // ココで初期化するのは本来適切ではないだろうから、後で適当な場所に書き直せ 
        seat_nums = new ArrayList<Integer>();
        
        // 入れ子構造で登録する
        Users u = new Users("斎藤 隆", "サイトウ タカシ", "042-565-2967", "takashi_revolution@ezweb.ne.jp", "1976-01-01", "男 ", "abcd9999", "2016-10-10");
        usersDb.add(u);
        Integer uId = u.getId();
        u=null;

        u = (Users) usersDb.find(uId);
        Theaters th = new Theaters(4, "渚にて", "1958-07-31", "12:00", u);

        // thにおけるList<Seats>を先に入れる
        List<Seats> ls = th.getSeatses();

        int[] nums = {50, 51, 52, 53};
        for (int num : nums) {
            ls.add(new Seats(num));
        }

        // uにおけるList<Theaters>を入れる
        List<Theaters> li = u.getTheaterses();
        li.add(th);

        usersDb.update(u);
        li.clear();
        
        Users us = new Users("京極夏彦","キョウゴク ナツヒコ","034-6616-8769", "ubume@gmail.com","1970-12-03","男","dbsi8758","2016-10-11");
        usersDb.add(us);
        Integer usId = us.getId();
        us=null;
        
        Users editU = (Users)usersDb.find(usId);
        Theaters ths = new Theaters(3, "姑獲鳥の夏", "2010-08-05", "18:00", editU);
        
        List<Seats> ls2 = ths.getSeatses();
        int[] nums2 = {15,16,17};
        
        for(int num:nums2){
            ls2.add(new Seats(num));
        }
        
        List<Theaters> lt = editU.getTheaterses();
        lt.add(ths);
        usersDb.update(editU);
        lt.clear();

//        // thsのIDを取得する手段が思いつかない。以下だとthsにまだIDが作成されていないので、何も取れない
//        Integer thsId = ths.getId();
//        
//        Theaters editTh =(Theaters) theatersDb.find(thsId);
//        Seats ses = new Seats(false, editTh);
//        List<Seats> lss = editTh.getSeatses();
//        lss.add(ses);
//        theatersDb.update(editTh);
//        lss.clear();

    // テスト用にSuperBbの変数に値を予め入れておく
        name_kanji="三島 由紀夫";
        name_kana="ミシマ ユキオ";
        tel="068-365-8754";
        email = "seppuku@gmail.com";
        age="1940-03-5";
        password="biyt97645";
        register="2016-10-12";
        
        room_num = 1;
        movietitle ="金閣寺";
        showdate = "1976-01-26";
        showtime = "09:16";

    }
    
    public void addSeat_num(){
        seat_nums.add(seat_num);
        
        System.out.println(String.valueOf(seat_num) + "をseat_numsに追加");
        
        seat_num = null;
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
        return "/db/index_content_users.xhtml";
    }

    public String goRegister() {
        return "/db/index_content_register.xhtml";
    }

    public String goTheaters() {
        return "/db/index_content_theaters.xhtml";
    }

    public String goEdit() {
        return "/db/index_content_edit.xhtml";
    }

    public String goIndex() {
        return "index_2.xhtml";
    }

    public String goSeat() {
        return "/db/index_content_select_seat.xhtml";
    }

    // テストページ用
    public String goOutput() {
        return "output.xhtml";
    }

}
