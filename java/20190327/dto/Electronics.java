package gs.mvc.dto;

public class Electronics {
	private int modelNo;
	private String modelName;
	private int modelPrice;
	private String modelDetail;
	
	
	public Electronics() {
		
	}
	public Electronics(int modelNo, String modelName) {
		this.modelNo = modelNo;
		this.modelName = modelName;
	}
	public Electronics(int modelNo, int modelPrice, String modelDetail) {
		this.modelNo = modelNo;
		this.modelDetail = modelDetail;
		this.modelPrice = modelPrice;
	}
	public Electronics(int modelNo, String modelName, int modelPrice, String modelDetail) {
		this(modelNo, modelPrice, modelDetail);
		this.modelName = modelName;
	}  
	
	
	
	public int getModelNo() {
		return modelNo;
	}
	public void setModelNo(int modelNo) {
		this.modelNo = modelNo;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getModelPrice() {
		return modelPrice;
	}
	public void setModelPrice(int modelPrice) {
		this.modelPrice = modelPrice;
	}
	public String getModelDetail() {
		return modelDetail;
	}
	public void setModelDetail(String modelDetail) {
		this.modelDetail = modelDetail;
	}
	
	
	@Override
	public String toString() {
		return "Electronics [modelNo=" + modelNo + ", modelName=" + modelName + ", modelPrice=" + modelPrice
				+ ", modelDetail=" + modelDetail + "]";
	}
	
	
	
	

}
