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
		System.out.println(getCode()+"��ǰ TV�� ä�� "+channel+"���� ����." );
		
	}
	@Override
	public void stop() {
		System.out.println();
		
	}
	@Override
	public void display() {
		System.out.println();
		
	}
	
	/*A01��ǰ TV�� 12�� ����
	A02��ǰ TV�� 20�� ����
	A03��ǰ TV�� 30�� ����
	A04�� Audio�� 200���� ��´�.
	A05�� Audio�� 100���� ��´�.*/

}
