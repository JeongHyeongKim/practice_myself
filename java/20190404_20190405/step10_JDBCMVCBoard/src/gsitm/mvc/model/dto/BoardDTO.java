package gsitm.mvc.model.dto;

public class BoardDTO {
	
	private int boardNo;
	private String subject;
	private String writer;
	private String content;
	private String boardDate;
	
	
	public BoardDTO() {}


	public BoardDTO(int boardNo, String subject, String writer, String content, String boardDate) {
		super();
		this.boardNo = boardNo;
		this.subject = subject;
		this.writer = writer;
		this.content = content;
		this.boardDate = boardDate;
	}


	public int getBoardNo() {
		return boardNo;
	}


	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getBoardDate() {
		return boardDate;
	}


	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}


	@Override
	public String toString() {
		return "BoardDTO [boardNo=" + boardNo + ", subject=" + subject + ", writer=" + writer + ", content=" + content
				+ ", boardDate=" + boardDate + "]\n";
	}
	
	

}
