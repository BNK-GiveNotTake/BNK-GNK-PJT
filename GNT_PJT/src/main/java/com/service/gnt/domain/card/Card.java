package com.service.gnt.domain.card;

public class Card {
	
	private String cardId;
	private int cvc;
	private String createTime; // date
	private String endTime; // date
	private String background;
	//private Emo emo; // fk
	private int emoId;
	private String emoInfo;
	private String font;
	private String cardContent;
	
	
	public Card() {}

	public Card(String cardId, int cvc, String createTime, String endTime, String background, int emoId, String emoInfo,
			String font, String cardContent) {
		super();
		this.cardId = cardId;
		this.cvc = cvc;
		this.createTime = createTime;
		this.endTime = endTime;
		this.background = background;
		this.emoId = emoId;
		this.emoInfo = emoInfo;
		this.font = font;
		this.cardContent = cardContent;
	}


	public int getEmoId() {
		return emoId;
	}


	public void setEmoId(int emoId) {
		this.emoId = emoId;
	}


	public String getCardId() {
		return cardId;
	}


	public void setCardId(String cardId) {
		this.cardId = cardId;
	}


	public int getCvc() {
		return cvc;
	}


	public void setCvc(int cvc) {
		this.cvc = cvc;
	}


	public String getCreateTime() {
		return createTime;
	}


	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public String getBackground() {
		return background;
	}


	public void setBackground(String background) {
		this.background = background;
	}

	public String getEmoInfo() {
		return emoInfo;
	}


	public void setEmoInfo(String emoInfo) {
		this.emoInfo = emoInfo;
	}


	public String getFont() {
		return font;
	}


	public void setFont(String font) {
		this.font = font;
	}


	public String getCardContent() {
		return cardContent;
	}


	public void setCardContent(String cardContent) {
		this.cardContent = cardContent;
	}


	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", cvc=" + cvc + ", createTime=" + createTime + ", endTime=" + endTime
				+ ", background=" + background  + ", emoInfo=" + emoInfo + ", font=" + font
				+ ", cardContent=" + cardContent + "]";
	}
	
	
	
	
}
