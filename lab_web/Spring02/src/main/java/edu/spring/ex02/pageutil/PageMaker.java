package edu.spring.ex02.pageutil;

// 페이지 번호들의 링크를 만들기 위한 유틸리티 클래스
public class PageMaker {

	private PageCriteria criteria; //
	private int totalCount; //총 게시글 개수
	private int numsOfPageLinks; // 페이지 번호 링크의 개수 //보통열개
	private int startPageNo;  //시작 페이지 링크 번호
	private int endPageNo; //끝 페이지 링크 번호
	private boolean hasPrev; // 화면에 보이는 시작 페이지 번호보다 작은 숫자의 페이지가 있는지(처음 1번 페이지인지)
	private boolean hasNext; //화면에 보이는 끝 페이지 번호보다 큰 숫자의 페이지가 있는 지
	public PageMaker() {
		this.numsOfPageLinks=3;
	}
	public PageCriteria getCriteria() {
		return criteria;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public int getNumsOfPageLinks() {
		return numsOfPageLinks;
	}
	public int getStartPageNo() {
		return startPageNo;
	}
	public int getEndPageNo() {
		return endPageNo;
	}
	public boolean isHasPrev() {
		return hasPrev;
	}
	public boolean isHasNext() {
		return hasNext;
	}
	
	
	//////////////////////////setter///////////
	
	public void setCriteria(PageCriteria criteria) {
		this.criteria = criteria;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	// startPageNo, endPageNo, hasPrev, hasNext 값을 계산, 세팅
	public void setPageData(){
				//ceil은 올림하는 메소드. floor는 내림  몫이 딱떨어지짖않고 나머지가 있을 경우 올림해야하지
		int totalLinkNo=(int)Math.ceil((double)totalCount / criteria.getNumsPerPage());
		int temp=(int)Math.ceil((double)criteria.getPage()/numsOfPageLinks) * numsOfPageLinks;
		if(temp>totalLinkNo){
			endPageNo=totalLinkNo;
		}else{
			endPageNo=temp;
		}
		
		startPageNo= ((endPageNo-1)/ numsOfPageLinks)*numsOfPageLinks +1;
		
		if(startPageNo==1){
			hasPrev=false;
		}else{
			hasPrev=true;
		}
		
		if(endPageNo * criteria.getNumsPerPage() >= totalCount){
			hasNext = false;
		}else{
			hasNext = true;
		}
	
	}
}
