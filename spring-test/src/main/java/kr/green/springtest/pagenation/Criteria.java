package kr.green.springtest.pagenation;

public class Criteria {
	private int perPagenum;
	private int page;

	public Criteria() {
    page = 1;
    perPagenum = 5;
  }
	
	public int getPerPagenum() {
		return perPagenum;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0)
			this.page = 1;
		else
			this.page = page;
	}

	public int getStartPage() {
		return (page - 1) * perPagenum;
	}

	@Override
	public String toString() {
		return "Criteria [perPagenum=" + perPagenum + ", page=" + page + "]";
	}

}