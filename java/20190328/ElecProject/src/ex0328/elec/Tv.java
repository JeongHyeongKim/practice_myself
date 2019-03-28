package ex0328.elec;

public class Tv extends Elec implements ElecFunction{
	private int channel;
	
	public Tv() {}
	public Tv(String code, int cost, int channel) {
		super(code, cost);
		this.channel=channel;
	}
	
	
	@Override
	public void start() {
		System.out.println(getCode()+"제품 TV의 채널 "+channel+"번을 본다." );
		
	}
	@Override
	public void stop() {
		System.out.println();
		
	}
	@Override
	public void display() {
		System.out.println();
		
	}
	
	/*A01제품 TV를 12을 본다
	A02제품 TV를 20을 본다
	A03제품 TV를 30을 본다
	A04의 Audio를 200으로 듣는다.
	A05의 Audio를 100으로 듣는다.*/

}
