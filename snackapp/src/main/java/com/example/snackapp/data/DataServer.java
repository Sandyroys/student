package com.example.snackapp.data;

import android.annotation.SuppressLint;

import com.example.snackapp.R;
import com.example.snackapp.model.Order;
import com.example.snackapp.model.Snack;
import com.example.snackapp.model.User;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//该系统所用信息数据
public class DataServer {

    private static List<String> snackOrderList;

    private static List<Snack> homeList;

    private static List<Snack> guizhouList;

    private static List<Snack> guangxiList;

    private static List<Snack> guangzhouList;

    private static List<Snack> beijingList;

    private static List<Snack> chongqingList;

    private static List<User> accountList;


   //  * 首页数据
    public static List<Snack> getHomeList() {
        if (homeList == null) {
            homeList = new ArrayList<Snack>() {{

                add(new Snack("凉拌折耳根", 12, R.mipmap.zheergen, "凉拌折耳根是一道菜品，制作原料主要为新鲜折耳根。凉拌折耳根脆嫩爽口，细细咀嚼，越嚼越香。"));
                add(new Snack("抄手", 9, R.mipmap.chaoshou, "抄手是中国西南地区的一种面食。以面皮包肉馅，煮熟后加清汤、红油和其它调料即可食用。此种小吃柔嫩鲜美，汤汁微辣浓香。（同饺子差不多，不同的是抄手和饺子的包法不同，饺子是用圆面皮包而抄手则是用正方形面皮包），抄手包的时候可以明显看到是要折叠好几次才包好，而馄饨的包法可以是可以只需要捏来封口就能下锅，他们的馅料也有所不同，馄饨的馅料有猪肉、虾肉、蔬菜等，但抄手只用猪绞肉。"));
                add(new Snack("老干妈", 15, R.mipmap.laoganma, "其产品沿用传统工艺，具有优雅细腻、香辣突出、回味悠长等特点，[1]主要有风味豆豉、风味鸡油辣椒、香辣菜、风味腐乳等20余个系列产品。老干妈曾入选2019中国品牌强国盛典榜样100品牌。"));
                add(new Snack("桂林米粉", 8, R.mipmap.guilinmifen, "桂林米粉是以早籼米、卤水为原料制作的在广西桂林历史悠久的特色传统名小吃。"));
                add(new Snack("北京烤鸭", 88, R.mipmap.kaoya, "烤鸭是具有世界声誉的北京著名菜式，起源于中国南北朝时期，《食珍录》中已记有炙鸭，在当时是宫廷食品。用料为优质肉食鸭北京鸭，果木炭火烤制，色泽红润，肉质肥而不腻，外脆里嫩。北京烤鸭分为两大流派，而北京最著名的烤鸭店也即是两派的代表。它以色泽红艳，肉质细嫩，味道醇厚，肥而不腻的特色，被誉为“天下美味”。"));
                add(new Snack("贵州酸汤鱼", 120, R.mipmap.huoguo, "酸汤鱼，制作原料主要有鱼肉、酸汤、山仓子等香料。成菜后，略带酸味、幽香沁人、鲜嫩爽口开胃，是贵州“黔系菜肴的代表作之一。"));
                add(new Snack("羊肉粉", 12, R.mipmap.yangroufen, "羊肉粉是贵州地区的著名小吃，有着300多年的传承历史。其是以新鲜羊肉和爽滑的米粉搭配制成，加入鲜羊肉汤及各种调料和具有特色的油辣椒，闻起来香，吃起来鲜。羊肉肥瘦适中，油而不；米粉入口即化，老少兼宜。"));
                add(new Snack("叉烧", 28, R.mipmap.chashao, "叉烧是广东省传统的名菜，属于粤菜系。是广东烧味的一种。多呈红色，瘦肉做成，略甜。是把腌制后的瘦猪肉挂在特制的叉子上，放入炉内烧烤。好的叉烧应该肉质软嫩多汁、色泽鲜明、香味四溢。当中又以肥、瘦肉均衡为上佳，称之为“半肥瘦”。以叉烧做的其他菜色包括有：叉烧饭、叉烧包、叉烧酥等。"));
            }};
        }
        return homeList;
    }
  //   * 点菜页面分类左边列表数据
    public static List<String> getSnackOrderList() {
        if (snackOrderList == null) {
            snackOrderList = new ArrayList<String>() {{
                add("贵州小吃");
                add("广西小吃");
                add("广州小吃");
                add("北京小吃");
                add("重庆小吃");
            }};
        }
        return snackOrderList;
    }

 //    * 福建小吃数据
    public static List<Snack> getFujianList() {
        if (guizhouList == null) {
            guizhouList = new ArrayList<Snack>() {{
                add(new Snack("凉拌折耳根", 12, R.mipmap.zheergen, "凉拌折耳根是一道菜品，制作原料主要为新鲜折耳根。凉拌折耳根脆嫩爽口，细细咀嚼，越嚼越香。"));
                add(new Snack("老干妈", 15, R.mipmap.laoganma, "其产品沿用传统工艺，具有优雅细腻、香辣突出、回味悠长等特点，[1]主要有风味豆豉、风味鸡油辣椒、香辣菜、风味腐乳等20余个系列产品。老干妈曾入选2019中国品牌强国盛典榜样100品牌。"));
                add(new Snack("贵州酸汤鱼", 120, R.mipmap.huoguo, "酸汤鱼，制作原料主要有鱼肉、酸汤、山仓子等香料。成菜后，略带酸味、幽香沁人、鲜嫩爽口开胃，是贵州“黔系菜肴的代表作之一。"));
                add(new Snack("羊肉粉", 12, R.mipmap.yangroufen, "羊肉粉是贵州地区的著名小吃，有着300多年的传承历史。其是以新鲜羊肉和爽滑的米粉搭配制成，加入鲜羊肉汤及各种调料和具有特色的油辣椒，闻起来香，吃起来鲜。羊肉肥瘦适中，油而不；米粉入口即化，老少兼宜。"));
                add(new Snack("恋爱豆腐果", 10.2, R.mipmap.lianaidoufuguo, "恋爱豆腐果是贵阳有名的风味小吃，食用时用薄竹片将豆腐当腰剖开，添进由胡辣椒、生姜米、葱、蒜泥、酱油、醋等调制而成的佐料，趁热吃下，咸辣爽滑、满口喷香。"));

            }};
        }
        return guizhouList;
    }


 //    * 广西小吃数据
    public static List<Snack> getGuangxiList() {
        if (guangxiList == null) {
            guangxiList = new ArrayList<Snack>() {{
                add(new Snack("桂林米粉", 8, R.mipmap.guilinmifen, "桂林米粉是以早籼米、卤水为原料制作的在广西桂林历史悠久的特色传统名小吃。"));
                add(new Snack("螺蛳粉", 8.5, R.mipmap.luoshifen, "螺蛳粉是广西壮族自治区柳州市的特色小吃之一，具有辣、爽、鲜、酸、烫的独特风味。是柳州最具地方特色的名小吃。螺蛳粉的味美还因为它有着独特的汤料。汤料由螺蛳、山奈、八角、肉桂、丁香、多种辣椒、等天然香料和味素配制而成。"));
                add(new Snack("荔蒲芋头糕", 12, R.mipmap.yutougao, "荔蒲芋头糕，是广西的著名食品，是以荔浦香芋、粘米粉、腊肠、腊肉、叉烧、南乳、虾米和鲜虾为主要材料制作而成，营养丰富，老幼皆宜。"));
                add(new Snack("叉烧", 28, R.mipmap.chashao, "叉烧是广东省传统的名菜，属于粤菜系。是广东烧味的一种。多呈红色，瘦肉做成，略甜。是把腌制后的瘦猪肉挂在特制的叉子上，放入炉内烧烤。好的叉烧应该肉质软嫩多汁、色泽鲜明、香味四溢。当中又以肥、瘦肉均衡为上佳，称之为“半肥瘦”。以叉烧做的其他菜色包括有：叉烧饭、叉烧包、叉烧酥等。"));
            }};
        }
        return guangxiList;
    }


 //    * 广州小吃数据
    public static List<Snack> getGuangzhouList() {
        if (guangzhouList == null) {
            guangzhouList = new ArrayList<Snack>() {{
                add(new Snack("肠粉", 6, R.mipmap.changfen, "肠粉是广州十大名吃之首，因形状像bai猪肠子被乾隆皇帝赐名为肠粉，du肠粉分甜咸两种，咸肠粉的馅料主要有猪肉、牛肉、虾仁、猪肝等，而甜肠粉的馅料则主要是糖浸的蔬果，再拌上炒香芝麻。肠粉按流派分主要分为两种，一种是主要品尝馅料的布拉肠粉，另一种是品尝酱汁调料的抽屉式肠粉。"));
                add(new Snack("叉烧", 28, R.mipmap.chashao, "叉烧是广东省传统的名菜，属于粤菜系。是广东烧味的一种。多呈红色，瘦肉做成，略甜。是把腌制后的瘦猪肉挂在特制的叉子上，放入炉内烧烤。好的叉烧应该肉质软嫩多汁、色泽鲜明、香味四溢。当中又以肥、瘦肉均衡为上佳，称之为“半肥瘦”。以叉烧做的其他菜色包括有：叉烧饭、叉烧包、叉烧酥等。"));
                add(new Snack("炒河粉  ", 8, R.mipmap.chaohefen, "炒河粉是广东省广州市著名的传统风味小吃，属于广州小吃，后来传至广东各地。制作原料有河粉、猪肉 、鸡蛋、各种青菜 等。"));
                add(new Snack("艇仔粥", 12, R.mipmap.tingzaizhou, "艇仔粥一开始是为这些以小艇为生，专营供应水边及船上顾客的小商贩所经营的粥品，配料有生鱼片、瘦肉、油条丝、花生、葱花、蛋丝、浮皮、海蜇丝、叉烧丝、烧鸭丝和鱿鱼等，制作时只需将配料倒入滚烫的粥底中烫熟就能食用，因口感绵滑、味道鲜美而发扬光大，现成为广州十大名吃之一。"));
                add(new Snack("虾饺", 18, R.mipmap.xiajiao, "虾饺是广东地区著名的传统小吃，属粤菜系，虾饺始创于20世纪初广州市郊伍村五凤乡的一间家庭式小茶楼，已经有百年历史。传统的虾饺是半月形、蜘蛛肚共有十二褶的，馅料有虾，有肉，有笋，味道鲜美爽滑，美味可口。"));
            }};
        }
        return guangzhouList;
    }

   //  * 北京小吃数据

    public static List<Snack> getBeijingList() {
        if (beijingList == null) {
            beijingList = new ArrayList<Snack>() {{
                add(new Snack("北京烤鸭", 88, R.mipmap.kaoya, "烤鸭是具有世界声誉的北京著名菜式，起源于中国南北朝时期，《食珍录》中已记有炙鸭，在当时是宫廷食品。用料为优质肉食鸭北京鸭，果木炭火烤制，色泽红润，肉质肥而不腻，外脆里嫩。北京烤鸭分为两大流派，而北京最著名的烤鸭店也即是两派的代表。它以色泽红艳，肉质细嫩，味道醇厚，肥而不腻的特色，被誉为“天下美味”。"));
                add(new Snack("豆汁", 5.8, R.mipmap.douzhi, "豆汁是老北京独具特色的传统小吃，根据文字记载有300年的历史。豆汁是以绿豆为原料，将淀粉滤出制作粉条等食品后的剩余残渣进行发酵产生的，具有养胃、解毒、清火的功效。"));
                add(new Snack("老北京炸酱面", 12.2, R.mipmap.zhajiangmian, "老北京炸酱面是一道传统的中式面食，由菜码、炸酱拌面条而成，流行于北京 、天津、河北等地。"));
            }};
        }
        return beijingList;
    }

   //  * 重庆小吃数据
    public static List<Snack> getChongqingList() {
        if (chongqingList == null) {
            chongqingList = new ArrayList<Snack>() {{
                add(new Snack("重庆小面", 12, R.mipmap.xiaomian, "重庆小面，是重庆四大特色之一，归属于重庆面食的一类发源于重庆，是重庆的主食之一，尤其是早餐较常见。重庆小面是重庆面食中最简单的一种。"));
                add(new Snack("火锅", 120, R.mipmap.huoguo, "火锅（英语：Hot Pot），古称“古董羹”，因食物投入沸水时发出的“咕咚”声而得名，它是中国独创的美食，历史悠久，是一种老少皆宜的食物。据考证，战国时期即有火锅，时人以陶罐为锅，到宋代，火锅的吃法在民间已十分常见，南宋林洪的《山家清供》食谱中，便有同友人吃火锅的介绍。元代，火锅流传到蒙古一带。到明清时期，火锅不仅在民间流行，而且成了一道著名的“宫廷菜”，用料是山鸡等野味。"));
                add(new Snack("抄手", 9, R.mipmap.chaoshou, "抄手是中国西南地区的一种面食。以面皮包肉馅，煮熟后加清汤、红油和其它调料即可食用。此种小吃柔嫩鲜美，汤汁微辣浓香。（同饺子差不多，不同的是抄手和饺子的包法不同，饺子是用圆面皮包而抄手则是用正方形面皮包），抄手包的时候可以明显看到是要折叠好几次才包好，而馄饨的包法可以是可以只需要捏来封口就能下锅，他们的馅料也有所不同，馄饨的馅料有猪肉、虾肉、蔬菜等，但抄手只用猪绞肉。"));
                add(new Snack("豆花饭", 18, R.mipmap.douhuafan, "豆花饭是川渝贵一带常见的小吃。豆花鲜嫩，蘸水香辣， 清爽可口，开胃下饭。用豆花当做下饭菜的一种快餐食品，由一碗豆花，一碗大米饭，一小碟蘸水而组成。"));
            }};
        }
        return chongqingList;
    }


   //  * 用户账号信息
    public static List<User> getAccountList() {
        if (accountList == null) {
            accountList = new ArrayList<User>() {{
                add(new User("1", "123456", "hhh", R.mipmap.user1_head));
                add(new User("2", "123456", "aaa", R.mipmap.user2_head));
            }};
        }
        return accountList;
    }

    public static List<Order> getOrderTest() {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return new ArrayList<Order>() {{
            add(new Order("是我", R.mipmap.zhajiangmian, 10.9, simpleDateFormat.format(new Date())));
            add(new Order("是我", R.mipmap.zhajiangmian, 10.9, simpleDateFormat.format(new Date())));
            add(new Order("是我", R.mipmap.zhajiangmian, 10.9, simpleDateFormat.format(new Date())));
        }};
    }
}
