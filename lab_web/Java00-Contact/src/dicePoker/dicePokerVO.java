package dicePoker;

public class dicePokerVO {
	private String userId;
    private String passWd;
    private String title;
    private int win;
    private int lose;
    private int gold;
    private int totalGame;
    private int gameOn;
    private int diceSkin;
    private int backSkin;   
    private int voice;
	
	public dicePokerVO(){}
	public dicePokerVO(String userId, String passWd, String title, int win, int lose, int gold, int totalGame,
			int gameOn, int diceSkin, int backSkin, int voice) {
		this.userId = userId;
		this.passWd = passWd;
		this.title = title;
		this.win = win;
		this.lose = lose;
		this.gold = gold;
		this.totalGame = totalGame;
		this.gameOn = gameOn;
		this.diceSkin = diceSkin;
		this.backSkin = backSkin;
		this.voice = voice;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassWd() {
		return passWd;
	}
	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getTotalGame() {
		return totalGame;
	}
	public void setTotalGame(int totalGame) {
		this.totalGame = totalGame;
	}
	public int getGameOn() {
		return gameOn;
	}
	public void setGameOn(int gameOn) {
		this.gameOn = gameOn;
	}
	public int getDiceSkin() {
		return diceSkin;
	}
	public void setDiceSkin(int diceSkin) {
		this.diceSkin = diceSkin;
	}
	public int getBackSkin() {
		return backSkin;
	}
	public void setBackSkin(int backSkin) {
		this.backSkin = backSkin;
	}
	public int getVoice() {
		return voice;
	}
	public void setVoice(int voice) {
		this.voice = voice;
	}
}