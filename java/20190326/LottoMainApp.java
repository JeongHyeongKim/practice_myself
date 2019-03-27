package ex0326.lotto;

public class LottoMainApp {

	public static void main(String[] args) {
		LottoService lottoservice = new LottoService();
		lottoservice.createData();
		lottoservice.sortDesc();
		lottoservice.printData();
		

	}

}
