package beans;

import entity.Theaters;
import entity.Users;
import entity.Seats;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

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
        // ココで初期化するのは本来適切ではないだろうから、後で適当な場所に書き直せ 
        seat_nums = new ArrayList<Integer>();

        // 入れ子構造で登録する
        Users u = new Users("斎藤 隆", "サイトウ タカシ", "042-565-2967", "takashi_revolution@ezweb.ne.jp", "1976-01-01", "男 ", "abcd9999", "2016-10-10");
        usersDb.add(u);
        Integer uId = u.getId();
        u = null;

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

        Users us = new Users("京極夏彦", "キョウゴク ナツヒコ", "034-6616-8769", "ubume@gmail.com", "1970-12-03", "男", "dbsi8758", "2016-10-11");
        usersDb.add(us);
        Integer usId = us.getId();
        us = null;

        Users editU = (Users) usersDb.find(usId);
        Theaters ths = new Theaters(3, "姑獲鳥の夏", "2010-08-05", "18:00", editU);
        List<Seats> ls2 = ths.getSeatses();
        int[] nums2 = {15, 16, 17};

        for (int num : nums2) {
            ls2.add(new Seats(num));
        }

        List<Theaters> lt = editU.getTheaterses();
        lt.add(ths);

        Theaters th3 = new Theaters(4, "魍魎の匣", "2005-03-14", "9:00", editU);
        List<Seats> ls3 = th3.getSeatses();
        int[] nums3 = {30, 31};
        for (int num : nums3) {
            ls3.add(new Seats(num));
        }
        lt.add(th3);

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
        name_kanji = "三島 由紀夫";
        name_kana = "ミシマ ユキオ";
        tel = "068-365-8754";
        email = "seppuku@gmail.com";
        age = "1940-03-5";
        sex = "男";
        password = "biyt97645";
        register = "2016-10-12";

//        addUser();
        room_num = 1;
        movietitle = "金閣寺";
        showdate = "1976-01-26";
        showtime = "09:16";

//        seat_num = 18;
//        addSeat_num();
//        seat_num = 19;
//        addSeat_num();
    }

    public void addSeat_num() {
        System.out.println("beans.Bb.addSeat_num()");

        if (seat_nums == null) {
            seat_nums = new ArrayList<>();
        }
        if (seat_num != null) {
            seat_nums.add(seat_num);
            System.out.println(String.valueOf(seat_num) + "をseat_numsに追加");
            seat_num = null;
        }
    }

    public String usersVarClear() {
        name_kanji = name_kana = tel = email = age = sex = register = null;
        seat_nums = null;
        return null;
    }

    public String theatersVarClear() {
        theater_info_id = room_num = seat_id = null;
        movietitle = showdate = showtime = null;
        return null;
    }

    public void attrListener(ActionEvent event) {
        try {
            user_id = (Integer) event.getComponent().getAttributes().get(u_id);
            name_kanji = (String) event.getComponent().getAttributes().get("u_kanji");
            name_kana = (String) event.getComponent().getAttributes().get(u_kana);
            tel = (String) event.getComponent().getAttributes().get(u_tel);
            email = (String) event.getComponent().getAttributes().get(u_email);
            age = (String) event.getComponent().getAttributes().get(u_age);
            sex = (String) event.getComponent().getAttributes().get(u_sex);
            password = (String) event.getComponent().getAttributes().get(u_password);
            register = (String) event.getComponent().getAttributes().get(u_register);
        } catch (Exception e) {
            System.err.println("チェック時にプロパティの変数入れられず");
        }
    }

    public void attrListenerTheater(ActionEvent event) {
        try {
            theater_id = (Integer) event.getComponent().getAttributes().get(t_id);
            room_num = (Integer) event.getComponent().getAttributes().get(t_room);
            movietitle = (String) event.getComponent().getAttributes().get(t_mtitle);
            showdate = (String) event.getComponent().getAttributes().get(t_sdate);
            showtime = (String) event.getComponent().getAttributes().get(t_stime);
        } catch (Exception e) {
            System.err.println("チェック時にプロパティの変数入れられず");
        }

    }

    public String reload() {
        return null;
    }

    public String goUsers() {
        return doGetRequestURL(1);
    }

    public String goRegister() {
        return doGetRequestURL(2);
    }

    public String goTheaters() {
        return doGetRequestURL(3);
    }

    public String goEdit() {
        return doGetRequestURL(4);
    }

    public String goIndex() {
        return doGetRequestURL(5);
    }

    public String goSeat() {
        return doGetRequestURL(6);
    }

    public String doGetRequestURL(int which) {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = request.getRequestURL().toString();
        switch (which) {
            case 1:
                if (url.equals("http://localhost:8080/CinemaTopia/faces/index_2.xhtml")) {
                    url = "db/index_content_users.xhtml";
                } else {
                    url = "index_content_users.xhtml";
                }
                break;
            case 2:
                if (url.equals("http://localhost:8080/CinemaTopia/faces/index_2.xhtml")) {
                    url = "db/index_content_register.xhtml";
                } else {
                    url = "index_content_register.xhtml";
                }
                break;
            case 3:
                if (url.equals("http://localhost:8080/CinemaTopia/faces/index_2.xhtml")) {
                    url = "db/index_content_theaters.xhtml";
                } else {
                    url = "index_content_theaters.xhtml";
                }
                break;
            case 4:
                if (url.equals("http://localhost:8080/CinemaTopia/faces/index_2.xhtml")) {
                    url = "db/index_contentedit.xhtml";
                } else {
                    url = "index_content_edit.xhtml";
                }
                break;
            case 5:
                if (url.equals("http://localhost:8080/CinemaTopia/faces/index_2.xhtml")) {
                    url = "index_2.xhtml";
                } else {
                    url = "../index_2.xhtml";
                }
                break;
            case 6:
                if (url.equals("http://localhost:8080/CinemaTopia/faces/index_2.xhtml")) {
                    url = "db/select_seat.xhtml";
                } else {
                    url = "select_seat.xhtml";
                }
                break;
            default:
                System.out.println("該当なし");
        }
        return url;
    }

}
