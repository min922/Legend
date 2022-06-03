# Legend


### main_dp : 재료 선택 화면
> * exist_indata : data가 DB에 있는지 확인 후 addData실행(선택 화면들에서 불러서 씀)
> * addData : SaveDate를 이용하여 유통기한을 받은 후 유통기한과 재료 data를 DB에 저장
> * SaveDate : 유통기한 입력



### home_dp : 내 냉장고 & 북마크 탭화면(북마크 구현 아직)
> * MyAdapter : 내 냉장고 어댑터
> * Item : 재료 출력용 class
> * RefTab : 내 냉장고 탭 프래그먼트
> * ContactDiffUtil : 리사이클러뷰 갱신 확인 용



### map_dp : 지도 & 가격 화면
> * MapsActivity : 메인 화면(지도랑 가격화면)
> * Marketlist : 서울시 시장 목록에 있는 시장 중 거리 순으로 5개 뽑아서 시장 명 list, 해당 시장 위, 경도 list 2개 return
> * DataClass : api출력용 class
