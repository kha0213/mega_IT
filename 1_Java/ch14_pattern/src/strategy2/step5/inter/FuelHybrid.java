package strategy2.step5.inter;

public class FuelHybrid implements IFuel {

	@Override
	public void fuel() {
		System.out.println("전기 하이브리드로 움직입니다.");
	}

}
