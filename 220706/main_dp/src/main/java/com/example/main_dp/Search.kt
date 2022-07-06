package com.example.main_dp

import android.content.Context
import kotlinx.android.synthetic.main.activity_sauce.*
import kotlinx.android.synthetic.main.activity_vege.*

class Search {
    val searchlist = arrayOf("가래떡", "떡국떡", "떡볶이떡", "바게트", "베이글", "식빵",
        "닭고기", "닭다리", "닭안심", "닭봉", "닭발",
        "홍합", "모시조개", "참소라살", "가리비", "재첩", "굴", "바지락",
        "골뱅이", "맛조개", "조갯살", "피조개", "전복", "맛살조개",
        "소고기", "다진소고기", "소꼬리", "소고기안심", "소고기등심", "양지머리", "선지",
        "새우", "꽃게", "게", "대하", "칵테일새우",
        "계란", "치즈", "요거트", "우유",
        "두부", "순두부", "콩비지", "유부",
        "멸치", "오징어", "북어", "생태", "연어", "삶은 문어살", "갑오징어", "꼴뚜기",
        "쭈꾸미", "도미", "동태", "잔멸치", "갈치", "대구", "전어", "메기", "잉어",
        "송어", "아구", "조기", "낙지", "말린 오징어", "참치", "문어", "꽁치", "고등어",
        "훈제연어", "코다리", "광어", "장어",
        "청어알", "연어알", "명란젓", "전어젓갈", "날치알", "해파리", "미더덕", "명란", "해삼",
        "사과", "자몽", "딸기", "건포도", "레몬", "포도", "체리", "아보카도", "바나나", "오렌지", "라임", "건블루베리",
        "쌀", "찹쌀", "수수", "차조", "전분", "밀가루", "찹쌀가루", "녹말", "들깨가루",
        "녹말가루", "강력분", "잣가루", "튀김가루", "콩", "팥", "흑임자", "완두콩", "땅콩", "깨",
        "다시마", "미역", "김", "파래", "해초", "우묵",
        "곱창", "육회",
        "당면", "냉면", "칼국수", "쫄면", "쌀국수", "우동", "스파게티", "라면", "국수",
        "올리브유", "참기름", "식물성기름", "고추기름", "튀김기름", "엿기름", "식용유", "샐러드오일", "포도씨유", "들기름",
        "돼지고기", "돼지등갈비", "돼지고기안심", "다진돼지고기", "돼지갈비",
        "게맛살", "장식용어묵", "햄", "베이컨", "프랑크소세지", "비엔나소세지", "골뱅이통조림", "꽁치통조림", "참치통조림", "과일통조림",
        "간장", "고추장", "고추가루", "소금", "꿀", "다진마늘", "된장", "마요네즈", "머스타드", "물엿",
        "버터", "설탕", "미원", "쌈장", "쇠고기 다시다", "식초", "올리고당", "청국장", "초고추장", "춘장", "칠리소스",
        "케첩", "후추", "젓국", "레몬즙", "새우젓", "건새우가루", "육수용멸치", "가쓰오브시", "건새우",
        "콩나물", "숙주", "미나리", "파", "도라지", "고사리", "시금치", "표고", "양송이버섯", "느타리버섯", "목이버섯", "새송이버섯",
        "팽이버섯", "애호박", "호박", "당근", "부추", "고추", "마늘", "대추", "감자", "양파", "피망", "파프리카", "오이", "상추",
        "깻잎", "무", "브로콜리", "청경채", "방울토마토", "토마토", "밤", "배추", "김치", "연근", "양상추", "양배추", "고구마", "옥수수"
    )

    fun Searchfun(inputText: String, context: Context){
        if (inputText == searchlist[0]){
            Datafun().Garefun(context)
        }
        if (inputText == searchlist[1]){
            Datafun().Dduckfun(context)
        }
        if (inputText == searchlist[2]){
            Datafun().Dduckbokkifun(context)
        }
        if (inputText == searchlist[3]){
            Datafun().Baguettefun(context)
        }
        if (inputText == searchlist[4]){
            Datafun().Baeglefun(context)
        }
        if (inputText == searchlist[5]){
            Datafun().Shickbbangfun(context)
        }
        if (inputText == searchlist[6]){
            Datafun().Chickmeatfun(context)
        }
        if (inputText == searchlist[7]){
            Datafun().Chicklegfun(context)
        }
        if (inputText == searchlist[8]){
            Datafun().Chickanshimfun(context)
        }
        if (inputText == searchlist[9]){
            Datafun().Chickbongfun(context)
        }
        if (inputText == searchlist[10]){
            Datafun().Chickfeetfun(context)
        }
        if (inputText == searchlist[11]) {
            Datafun().Honghapfun(context)
        }
        if (inputText == searchlist[12]) {
            Datafun().Moshifun(context)
        }
        if (inputText == searchlist[13]) {
            Datafun().Chamsorafun(context)
        }
        if (inputText == searchlist[14]) {
            Datafun().Garibifun(context)
        }
        if (inputText == searchlist[15]) {
            Datafun().Jaechupfun(context)
        }
        if (inputText == searchlist[16]) {
            Datafun().Gulfun(context)
        }
        if (inputText == searchlist[17]) {
            Datafun().Bajirakfun(context)
        }
        if (inputText == searchlist[18]) {
            Datafun().Golbangfun(context)
        }
        if (inputText == searchlist[19]) {
            Datafun().Matclamfun(context)
        }
        if (inputText == searchlist[20]) {
            Datafun().Clamsalfun(context)
        }
        if (inputText == searchlist[21]) {
            Datafun().Piclamfun(context)
        }
        if (inputText == searchlist[22]) {
            Datafun().Junbokfun(context)
        }
        if (inputText == searchlist[23]) {
            Datafun().Matsalclamfun(context)
        }
        if (inputText == searchlist[24]) {
            Datafun().Cowmeatfun(context)
        }
        if (inputText == searchlist[25]) {
            Datafun().Cowcutfun(context)
        }
        if (inputText == searchlist[26]) {
            Datafun().Cowtailfun(context)
        }
        if (inputText == searchlist[27]) {
            Datafun().Cowanshimfun(context)
        }
        if (inputText == searchlist[28]) {
            Datafun().Cowdungshimfun(context)
        }
        if (inputText == searchlist[29]) {
            Datafun().Cowheadfun(context)
        }
        if (inputText == searchlist[30]) {
            Datafun().Cowbloodfun(context)
        }
        if (inputText == searchlist[31]) {
            Datafun().Shirimpfun(context)
        }
        if (inputText == searchlist[32]) {
            Datafun().Flowercrapfun(context)
        }
        if (inputText == searchlist[33]) {
            Datafun().Crapfun(context)
        }
        if (inputText == searchlist[34]) {
            Datafun().Daehafun(context)
        }
        if (inputText == searchlist[35]) {
            Datafun().Cocktailshirimpfun(context)
        }
        if (inputText == searchlist[36]) {
            Datafun().Eggfun(context)
        }
        if (inputText == searchlist[37]) {
            Datafun().Cheesefun(context)
        }
        if (inputText == searchlist[38]) {
            Datafun().Yogartfun(context)
        }
        if (inputText == searchlist[39]) {
            Datafun().Milkfun(context)
        }
        if (inputText == searchlist[40]) {
            Datafun().Dubufun(context)
        }
        if (inputText == searchlist[41]) {
            Datafun().Sundubufun(context)
        }
        if (inputText == searchlist[42]) {
            Datafun().Kongbijifun(context)
        }
        if (inputText == searchlist[43]) {
            Datafun().Yubufun(context)
        }
        if (inputText == searchlist[44]) {
            Datafun().Mylchifun(context)
        }
        if (inputText == searchlist[45]) {
            Datafun().Squidfun(context)
        }
        if (inputText == searchlist[46]) {
            Datafun().Bukuhfun(context)
        }
        if (inputText == searchlist[47]) {
            Datafun().Sangtaefun(context)
        }
        if (inputText == searchlist[48]) {
            Datafun().Salmonfun(context)
        }
        if (inputText == searchlist[49]) {
            Datafun().Boiledoctofun(context)
        }
        if (inputText == searchlist[50]) {
            Datafun().Gapsquidfun(context)
        }
        if (inputText == searchlist[51]) {
            Datafun().Ggolddugifun(context)
        }
        if (inputText == searchlist[52]) {
            Datafun().Jjukumifun(context)
        }
        if (inputText == searchlist[53]) {
            Datafun().Domifun(context)
        }
        if (inputText == searchlist[54]) {
            Datafun().Janmylchifun(context)
        }
        if (inputText == searchlist[55]) {
            Datafun().Galchifun(context)
        }
        if (inputText == searchlist[56]) {
            Datafun().Daegufun(context)
        }
        if (inputText == searchlist[57]) {
            Datafun().Dongtaefun(context)
        }
        if (inputText == searchlist[58]) {
            Datafun().Junuhfun(context)
        }
        if (inputText == searchlist[59]) {
            Datafun().Maegifun(context)
        }
        if (inputText == searchlist[60]) {
            Datafun().Inguhfun(context)
        }
        if (inputText == searchlist[61]) {
            Datafun().Songuhfun(context)
        }
        if (inputText == searchlist[62]) {
            Datafun().Agufun(context)
        }
        if (inputText == searchlist[63]) {
            Datafun().Jogifun(context)
        }
        if (inputText == searchlist[64]) {
            Datafun().Nakjifun(context)
        }
        if (inputText == searchlist[65]) {
            Datafun().Driedsquidfun(context)
        }
        if (inputText == searchlist[66]) {
            Datafun().Chamchifun(context)
        }
        if (inputText == searchlist[67]) {
            Datafun().Octopusfun(context)
        }
        if (inputText == searchlist[68]) {
            Datafun().Ggongchifun(context)
        }
        if (inputText == searchlist[69]) {
            Datafun().Godungfun(context)
        }
        if (inputText == searchlist[70]) {
            Datafun().Hunjaesalmonfun(context)
        }
        if (inputText == searchlist[71]) {
            Datafun().Codarifun(context)
        }
        if (inputText == searchlist[72]) {
            Datafun().Gwanguhfun(context)
        }
        if (inputText == searchlist[73]) {
            Datafun().Janguhfun(context)
        }
        if (inputText == searchlist[74]) {
            Datafun().Chunguhalfun(context)
        }
        if (inputText == searchlist[75]) {
            Datafun().Salmonalfun(context)
        }
        if (inputText == searchlist[76]) {
            Datafun().Myungranjutfun(context)
        }
        if (inputText == searchlist[77]) {
            Datafun().Junuhjutgalfun(context)
        }
        if (inputText == searchlist[78]) {
            Datafun().Nalchialfun(context)
        }
        if (inputText == searchlist[79]) {
            Datafun().Haeparifun(context)
        }
        if (inputText == searchlist[80]) {
            Datafun().Midudukfun(context)
        }
        if (inputText == searchlist[81]) {
            Datafun().Myungranfun(context)
        }
        if (inputText == searchlist[82]) {
            Datafun().Haesamfun(context)
        }
        if (inputText == searchlist[83]) {
            Datafun().Applefun(context)
        }
        if (inputText == searchlist[84]) {
            Datafun().Grapefruitfun(context)
        }
        if (inputText == searchlist[85]) {
            Datafun().Strawberryfun(context)
        }
        if (inputText == searchlist[86]) {
            Datafun().Driedgrapefun(context)
        }
        if (inputText == searchlist[87]) {
            Datafun().Lemonfun(context)
        }
        if (inputText == searchlist[88]) {
            Datafun().Grapefun(context)
        }
        if (inputText == searchlist[89]) {
            Datafun().Cherryfun(context)
        }
        if (inputText == searchlist[90]) {
            Datafun().Avocadofun(context)
        }
        if (inputText == searchlist[91]) {
            Datafun().Bananafun(context)
        }
        if (inputText == searchlist[92]) {
            Datafun().Orangefun(context)
        }
        if (inputText == searchlist[93]) {
            Datafun().Limefun(context)
        }
        if (inputText == searchlist[94]) {
            Datafun().Blueberryfun(context)
        }
        if (inputText == searchlist[95]) {
            Datafun().Ssalfun(context)
        }
        if (inputText == searchlist[96]) {
            Datafun().Chapssalfun(context)
        }
        if (inputText == searchlist[97]) {
            Datafun().Susufun(context)
        }
        if (inputText == searchlist[98]) {
            Datafun().Chajofun(context)
        }
        if (inputText == searchlist[99]) {
            Datafun().Junbunfun(context)
        }
        if (inputText == searchlist[100]) {
            Datafun().Milgarufun(context)
        }
        if (inputText == searchlist[101]) {
            Datafun().Chapsslagarufun(context)
        }
        if (inputText == searchlist[102]) {
            Datafun().Nokmalfun(context)
        }
        if (inputText == searchlist[103]) {
            Datafun().Delggaegarufun(context)
        }
        if (inputText == searchlist[104]) {
            Datafun().Nokmalgarufun(context)
        }
        if (inputText == searchlist[105]) {
            Datafun().Gangryuckfun(context)
        }
        if (inputText == searchlist[106]) {
            Datafun().Jatgarufun(context)
        }
        if (inputText == searchlist[107]) {
            Datafun().Frygarufun(context)
        }
        if (inputText == searchlist[108]) {
            Datafun().Kongfun(context)
        }
        if (inputText == searchlist[109]) {
            Datafun().Patfun(context)
        }
        if (inputText == searchlist[110]) {
            Datafun().Hukimjafun(context)
        }
        if (inputText == searchlist[111]) {
            Datafun().Wandufun(context)
        }
        if (inputText == searchlist[112]) {
            Datafun().Peanutfun(context)
        }
        if (inputText == searchlist[113]) {
            Datafun().Ggaefun(context)
        }
        if (inputText == searchlist[114]) {
            Datafun().Dashimafun(context)
        }
        if (inputText == searchlist[115]) {
            Datafun().Seaweedfun(context)
        }
        if (inputText == searchlist[116]) {
            Datafun().Gimfun(context)
        }
        if (inputText == searchlist[117]) {
            Datafun().Paraefun(context)
        }
        if (inputText == searchlist[118]) {
            Datafun().Haechofun(context)
        }
        if (inputText == searchlist[119]) {
            Datafun().womukfun(context)
        }
        if (inputText == searchlist[120]) {
            Datafun().Gopchangfun(context)
        }
        if (inputText == searchlist[121]) {
            Datafun().Rawmeatfun(context)
        }
        if (inputText == searchlist[122]) {
            Datafun().Dangfun(context)
        }
        if (inputText == searchlist[123]) {
            Datafun().Naengfun(context)
        }
        if (inputText == searchlist[124]) {
            Datafun().Kalfun(context)
        }
        if (inputText == searchlist[125]) {
            Datafun().Jjolfun(context)
        }
        if (inputText == searchlist[126]) {
            Datafun().Ssalguksufun(context)
        }
        if (inputText == searchlist[127]) {
            Datafun().Udongfun(context)
        }
        if (inputText == searchlist[128]) {
            Datafun().Spafun(context)
        }
        if (inputText == searchlist[129]) {
            Datafun().Ramenfun(context)
        }
        if (inputText == searchlist[130]) {
            Datafun().Guksufun(context)
        }
        if (inputText == searchlist[131]) {
            Datafun().Oliveoilfun(context)
        }
        if (inputText == searchlist[132]) {
            Datafun().Chamoilfun(context)
        }
        if (inputText == searchlist[133]) {
            Datafun().Vegeoilfun(context)
        }
        if (inputText == searchlist[134]) {
            Datafun().Gochuoilfun(context)
        }
        if (inputText == searchlist[135]) {
            Datafun().Fryoilfun(context)
        }
        if (inputText == searchlist[136]) {
            Datafun().Yutoilfun(context)
        }
        if (inputText == searchlist[137]) {
            Datafun().Sikoilfun(context)
        }
        if (inputText == searchlist[138]) {
            Datafun().Saladoilfun(context)
        }
        if (inputText == searchlist[139]) {
            Datafun().Podossioilfun(context)
        }
        if (inputText == searchlist[140]) {
            Datafun().Duloilfun(context)
        }
        if (inputText == searchlist[141]) {
            Datafun().Pigmeatfun(context)
        }
        if (inputText == searchlist[142]) {
            Datafun().Pigbackfun(context)
        }
        if (inputText == searchlist[143]) {
            Datafun().Piganshimfun(context)
        }
        if (inputText == searchlist[144]) {
            Datafun().Pigcutfun(context)
        }
        if (inputText == searchlist[145]) {
            Datafun().Piggalbifun(context)
        }
        if (inputText == searchlist[146]) {
            Datafun().Crapmatsalfun(context)
        }
        if (inputText == searchlist[147]) {
            Datafun().Umukfun(context)
        }
        if (inputText == searchlist[148]) {
            Datafun().Hamfun(context)
        }
        if (inputText == searchlist[149]) {
            Datafun().Baconfun(context)
        }
        if (inputText == searchlist[150]) {
            Datafun().Franksausagefun(context)
        }
        if (inputText == searchlist[151]) {
            Datafun().Viennasausagefun(context)
        }
        if (inputText == searchlist[152]) {
            Datafun().Golbangcanfun(context)
        }
        if (inputText == searchlist[153]) {
            Datafun().Ggongchicanfun(context)
        }
        if (inputText == searchlist[154]) {
            Datafun().Chamchicanfun(context)
        }
        if (inputText == searchlist[155]) {
            Datafun().Fruitcanfun(context)
        }
        if (inputText == searchlist[156]) {
            Datafun().Soysaucefun(context)
        }
        if (inputText == searchlist[157]) {
            Datafun().Gochujangfun(context)
        }
        if (inputText == searchlist[158]) {
            Datafun().Gochugarufun(context)
        }
        if (inputText == searchlist[159]) {
            Datafun().Saltfun(context)
        }
        if (inputText == searchlist[160]) {
            Datafun().Honeyfun(context)
        }
        if (inputText == searchlist[161]) {
            Datafun().Dajingarlicfun(context)
        }
        if (inputText == searchlist[162]) {
            Datafun().Doanjangfun(context)
        }
        if (inputText == searchlist[163]) {
            Datafun().Mayonnaisefun(context)
        }
        if (inputText == searchlist[164]) {
            Datafun().Mustardfun(context)
        }
        if (inputText == searchlist[165]) {
            Datafun().Mulyotfun(context)
        }
        if (inputText == searchlist[166]) {
            Datafun().Butterfun(context)
        }
        if (inputText == searchlist[167]) {
            Datafun().Sugerfun(context)
        }
        if (inputText == searchlist[168]) {
            Datafun().Miwonfun(context)
        }
        if (inputText == searchlist[169]) {
            Datafun().Ssamjangfun(context)
        }
        if (inputText == searchlist[170]) {
            Datafun().Dashidafun(context)
        }
        if (inputText == searchlist[171]) {
            Datafun().Vinegerfun(context)
        }
        if (inputText == searchlist[172]) {
            Datafun().Oligodangfun(context)
        }
        if (inputText == searchlist[173]) {
            Datafun().Chungukjangfun(context)
        }
        if (inputText == searchlist[174]) {
            Datafun().Chojangfun(context)
        }
        if (inputText == searchlist[175]) {
            Datafun().Chunjangfun(context)
        }
        if (inputText == searchlist[176]) {
            Datafun().Chilisaucefun(context)
        }
        if (inputText == searchlist[177]) {
            Datafun().Ketchupfun(context)
        }
        if (inputText == searchlist[178]) {
            Datafun().Pepperfun(context)
        }
        if (inputText == searchlist[179]) {
            Datafun().Jutgukfun(context)
        }
        if (inputText == searchlist[180]) {
            Datafun().Lemonjuicefun(context)
        }
        if (inputText == searchlist[181]) {
            Datafun().Shirimpjutfun(context)
        }
        if (inputText == searchlist[182]) {
            Datafun().Driedshirimpgarufun(context)
        }
        if (inputText == searchlist[183]) {
            Datafun().Yuksumulchifun(context)
        }
        if (inputText == searchlist[184]) {
            Datafun().Katsuobushifun(context)
        }
        if (inputText == searchlist[185]) {
            Datafun().Driedshirimpfun(context)
        }
        if (inputText == searchlist[186]) {
            Datafun().Kongnamulfun(context)
        }
        if (inputText == searchlist[187]) {
            Datafun().Sukjufun(context)
        }
        if (inputText == searchlist[188]) {
            Datafun().Minarifun(context)
        }
        if (inputText == searchlist[189]) {
            Datafun().Greenonionfun(context)
        }
        if (inputText == searchlist[190]) {
            Datafun().Dorajifun(context)
        }
        if (inputText == searchlist[191]) {
            Datafun().Gosarifun(context)
        }
        if (inputText == searchlist[192]) {
            Datafun().Shigumchifun(context)
        }
        if (inputText == searchlist[193]) {
            Datafun().Pyogofun(context)
        }
        if (inputText == searchlist[194]) {
            Datafun().Yangsongfun(context)
        }
        if (inputText == searchlist[195]) {
            Datafun().Nutarifun(context)
        }
        if (inputText == searchlist[196]) {
            Datafun().Mokifun(context)
        }
        if (inputText == searchlist[197]) {
            Datafun().Saesongfun(context)
        }
        if (inputText == searchlist[198]) {
            Datafun().Pangefun(context)
        }
        if (inputText == searchlist[199]) {
            Datafun().Aehobakfun(context)
        }
        if (inputText == searchlist[200]) {
            Datafun().Hobakfun(context)
        }
        if (inputText == searchlist[201]) {
            Datafun().Carrotfun(context)
        }
        if (inputText == searchlist[202]) {
            Datafun().Buchufun(context)
        }
        if (inputText == searchlist[203]) {
            Datafun().Gochufun(context)
        }
        if (inputText == searchlist[204]) {
            Datafun().Garlicfun(context)
        }
        if (inputText == searchlist[205]) {
            Datafun().Daechufun(context)
        }
        if (inputText == searchlist[206]) {
            Datafun().Potatofun(context)
        }
        if (inputText == searchlist[207]) {
            Datafun().Onionfun(context)
        }
        if (inputText == searchlist[208]) {
            Datafun().Pimangfun(context)
        }
        if (inputText == searchlist[209]) {
            Datafun().Papricafun(context)
        }
        if (inputText == searchlist[210]) {
            Datafun().Cucumberfun(context)
        }
        if (inputText == searchlist[211]) {
            Datafun().Sangchufun(context)
        }
        if (inputText == searchlist[212]) {
            Datafun().Ggatipfun(context)
        }
        if (inputText == searchlist[213]) {
            Datafun().Mufun(context)
        }
        if (inputText == searchlist[214]) {
            Datafun().Brocolifun(context)
        }
        if (inputText == searchlist[215]) {
            Datafun().Chunggyungfun(context)
        }
        if (inputText == searchlist[216]) {
            Datafun().Bangtofun(context)
        }
        if (inputText == searchlist[217]) {
            Datafun().Tomatofun(context)
        }
        if (inputText == searchlist[218]) {
            Datafun().Bamfun(context)
        }
        if (inputText == searchlist[219]) {
            Datafun().Baechufun(context)
        }
        if (inputText == searchlist[220]) {
            Datafun().Kimchifun(context)
        }
        if (inputText == searchlist[221]) {
            Datafun().Yungeunfun(context)
        }
        if (inputText == searchlist[222]) {
            Datafun().Yangsangchufun(context)
        }
        if (inputText == searchlist[223]) {
            Datafun().Yangbaechufun(context)
        }
        if (inputText == searchlist[224]) {
            Datafun().Gogumafun(context)
        }
        if (inputText == searchlist[225]) {
            Datafun().Oksusufun(context)
        }
    }
}