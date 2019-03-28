package ex0328.elec;

public class Audio extends Elec implements ElecFunction{
	private int vol;
	
	public Audio () {}
	public Audio(int vol) {
		this.vol = vol;
	}
	public Audio(String code, int cost, int vol) {
		super(code, cost);
		this.vol = vol;
	}
			


	@Override
	public void start() {
		System.out.println(getCode()+"의 Audio를 음량 "+vol+" 크기로 듣는다." );
		
	}
	@Override
	public void stop() {
		System.out.println();
		
	}
	@Override
	public void display() {
		System.out.println();
		
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Audio [vol=");
		builder.append(vol);
		builder.append("]");
		return builder.toString();
	}
	
	
}
