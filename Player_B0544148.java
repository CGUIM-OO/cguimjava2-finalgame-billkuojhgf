
public class Player_B0544148 extends Player {
	
	private int mybet_prev = 1000;//先前的bet
	private int mybet_made = 80;
	

	public Player_B0544148(int chips){
		super("BillKuo(B0544148)" ,chips );
	}
	
	

	@Override
	public int make_bet() { //馬丁格爾(勝利重返，失敗向前)
		if(mybet_prev < get_current_chips()){
			mybet_made = 80;
		}if(mybet_prev > get_current_chips()){
			mybet_made = mybet_made * 2;
		}
		mybet_prev = get_current_chips();
		return mybet_made;
	}

	@Override
	public boolean hit_me(Table table) {
		int total_value = getTotalValue();

		if (total_value >= 17) {
			return false;
		} else {
			return true;
		}
	}

}
