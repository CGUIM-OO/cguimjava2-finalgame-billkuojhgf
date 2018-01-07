
public class Player_B0544148 extends Player {
	
	private int mybet_prev = 1000;//���e��bet
	private int mybet_made = 10;
	private int DealerUpCard = 0;
	

	public Player_B0544148(int chips){
		super("BillKuo(B0544148)" ,chips );
	}
	
	

	@Override
	public int make_bet() { //���B�溸(�ӧQ����A���ѦV�e)
		if(mybet_prev > get_current_chips()){
			mybet_made = 10;
		}if(mybet_prev < get_current_chips()){
			mybet_made = mybet_made * 2;
		}
		return mybet_made;
	}

	@Override
	public boolean hit_me(Table table) {
		int Ace_Count = 0;
		int OneRoundRank = 0;
		
		Card deal = table.get_face_up_card_of_dealer();
		DealerUpCard = deal.getRank();
		
		for(Card c : getOneRoundCard()){
			if (Ace_Count == 0 && c.getRank() == 1) {
				Ace_Count = 1;
				continue;
			} else {
				if (c.getRank() == 11 || c.getRank() == 12 || c.getRank() == 13)
					OneRoundRank += 10;
				else
					OneRoundRank += c.getRank();
			}
		}
		if (Ace_Count != 0) {
			if (OneRoundRank < 11) {
				OneRoundRank += 11;
			} else {
				OneRoundRank += 1;
			}

		}
		
		if(OneRoundRank == 12){
			if(DealerUpCard >= 4 && DealerUpCard <= 6){
				return false;
			}else{
				return true;
			}
		}
		
		if(OneRoundRank >= 13 && OneRoundRank <= 16){
			if(DealerUpCard >= 2 && DealerUpCard <= 6){
				return false;
			}else{
				return true;
			}
		}
		
		if(Ace_Count >= 1 && OneRoundRank == 18){
			if(DealerUpCard >= 2 && DealerUpCard <= 8){
				return false;
			}else{
				return true;
			}
		}
			
		if(OneRoundRank >=17){
			return false;
		}
		
		return true;

	}

}
