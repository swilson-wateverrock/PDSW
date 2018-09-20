import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "guessBean")
@ApplicationScoped
public class BackingBean {
	
	private int number, attemps, acumulatedAward;
	private boolean gameState;
	
	public BackingBean() {
		restart();
		
	}
	
	public void guess(int tried) {
		setAttemps(attemps++);
		if(getNumber() == tried) {
			setGameState(true);
		}else {
			setAcumulatedAward(acumulatedAward-10000);			
		}
	}
	
	public void restart(){
		number = (int)(Math.random()*100)+1;
		attemps = 0;
		acumulatedAward = 100000;
		gameState = false;
	}
	

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getAttemps() {
		return attemps;
	}

	public void setAttemps(int attemps) {
		this.attemps = attemps;
	}

	public int getAcumulatedAward() {
		return acumulatedAward;
	}

	public void setAcumulatedAward(int acumulatedAward) {
		this.acumulatedAward = acumulatedAward;
	}

	public boolean isGameState() {
		return gameState;
	}

	public void setGameState(boolean gameState) {
		this.gameState = gameState;
	}
	
	
	
	
}
