# Legend


### main_dp : 재료 선택 화면
> * SelectMainActivity : 메인 액티비티
> * exist_indata : data가 DB에 있는지 확인 후 addData실행(SelectActivity들에서 불러서 씀)
> * addData : SaveDate를 이용하여 유통기한을 받은 후 유통기한과 재료 data를 DB에 저장(exist_indata에서 씀)
> * SaveDate : 유통기한 입력(addData에서 씀)



### home_dp : 내 냉장고 & 북마크 탭화면
> * RefMainActivity : 화면 전체 액티비티
> * RefAdapter : 내 냉장고 어댑터
> * Item : 재료 출력용 class
> * RefTab : 내 냉장고 탭 프래그먼트
> * EditDate : 유통기한 수정 및 재료 삭제
> * BookmarkAdapter : 북마크 어댑터
> * BookmarkFood : 북마크용 class
> * BookmarkTab : 북마크 탭 프래그먼트
> * ContactDiffUtil : 리사이클러뷰 갱신 확인 용



### map_dp : 지도 & 가격 화면
> * MapsActivity : 메인 화면(지도랑 가격화면)
> * Marketlist : 서울시 시장 목록에 있는 시장 중 거리 순으로 5개 뽑아서 시장 명 list와 해당 시장 위, 경도 list의 2개 list를 pair로 return
> * DataClass : api출력용 class
> * LoadingDialog : 로딩창
