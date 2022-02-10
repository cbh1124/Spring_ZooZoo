function categoryChange(e) {
    var good_city = ["가평군","고양시","과천시","광명시","광주시","구리시","군포시","김포시","남양주시","동두천시","부천시","성남시","수원시","시흥시","안산시","안성시","안양시","양주시","양평군","여주군","연천군","오산시","용인시","의왕시","의정부시","이천시","파주시","평택시","포천시","하남시","화성시"];
    var good_tot = ["가평군유기동물보호소","고양시동물보호센터","광명반함센터","광주TNR동물병원초월","광주TNR동물병원송정","남양주동물보호협회","대관령동물병원","24시아이동물메디컬","부천시수의사회","가나동물병원","cj동물병원","가야동물병원","펫토피아동물병원","수원시 동물보호센터","한국야생동물보호협회","스타캣츠","이성준동물병원","한국동물구조관리협회","양평군유기동물보호소","위더스 동물보호센터","오산 유기동물보호소","용인시 동물보호센터","버디종합동물병원","나은동물병원","파주24시동물병원","파주독 애견호텔","웰니스클리닉","로뎀동물병원","금릉동물병원","문산동물병원","미엘동물병원","행복한동물병원","평택시유기동물보호소","하남동물병원","남양동물보호센터"];
    var good_none = ["없음"];
    var good_a = ["가평군유기동물보호소"];
    var good_b = ["고양시동물보호센터"];
    var good_d = ["광명반함센터"];
    var good_e = ["광주TNR동물병원초월","광주TNR동물병원송정"];
    var good_i = ["남양주동물보호협회","대관령동물병원"];
    var good_k = ["24시아이동물메디컬","부천시수의사회","가나동물병원","cj동물병원","가야동물병원"];
    var good_l = ["펫토피아동물병원"];
    var good_m = ["수원시 동물보호센터"];
    var good_o = ["한국야생동물보호협회","스타캣츠"];
    var good_p = ["이성준동물병원"];
	var good_r = ["한국동물구조관리협회"];
	var good_s = ["양평군유기동물보호소"];
	var good_t = ["위더스 동물보호센터"];
	var good_v = ["오산 유기동물보호소"];
	var good_w = ["용인시 동물보호센터"];
    var good_aa = ["버디종합동물병원","나은동물병원","파주24시동물병원","파주독 애견호텔","웰니스클리닉","로뎀동물병원","금릉동물병원","문산동물병원","미엘동물병원","행복한동물병원"];
    var good_bb = ["평택시유기동물보호소"];
    var good_dd = ["하남동물병원"];
    var good_ee = ["남양동물보호센터"];

    var target = document.getElementById("cals09");

    if(e.value == "total") var d = good_tot;
    else if(e.value == "c" || e.value == "f" || e.value == "g" || e.value == "h" || e.value == "i" ||
        e.value == "j" || e.value == "n" || e.value == "q" || e.value == "u" || e.value == "x" || e.value == "y" || e.value == "z" || e.value == "cc")
    var d = good_none;
    else if(e.value == "a") var d = good_a;
    else if(e.value == "b") var d = good_b;
    else if(e.value == "d") var d = good_d;
    else if(e.value == "e") var d = good_e;
    else if(e.value == "i") var d = good_i;
    else if(e.value == "k") var d = good_k;
    else if(e.value == "l") var d = good_l;
    else if(e.value == "m") var d = good_m;
    else if(e.value == "o") var d = good_o;
    else if(e.value == "p") var d = good_p;
    else if(e.value == "r") var d = good_r;
    else if(e.value == "s") var d = good_s;
    else if(e.value == "t") var d = good_t;
    else if(e.value == "v") var d = good_v;
    else if(e.value == "w") var d = good_w;
    else if(e.value == "aa") var d = good_aa;
    else if(e.value == "bb") var d = good_bb;
    else if(e.value == "dd") var d = good_dd;
    else if(e.value == "ee") var d = good_ee;

    target.options.length = 0;

    for (x in d) {
        var opt = document.createElement("option");
        opt.value = d[x];
        opt.innerHTML = d[x];
        target.appendChild(opt);
    }
}