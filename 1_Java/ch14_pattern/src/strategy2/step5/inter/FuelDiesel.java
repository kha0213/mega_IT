package strategy2.step5.inter;

public class FuelDiesel implements IFuel {

	@Override
	public void fuel() {
		System.out.println("경유 차량입니다.");
	}

}
