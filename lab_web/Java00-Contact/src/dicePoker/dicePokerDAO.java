package dicePoker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.driver.OracleDriver;
import static dicePoker.OracleQuery.*;

public class dicePokerDAO {
	private static dicePokerDAO instance = null;
	Connection con = null;
	
	private dicePokerDAO(){
		try {
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			   e.printStackTrace();
		}
	}
	
	public static dicePokerDAO getInstance(){
		if(instance == null){
			instance = new dicePokerDAO();
		}
		return instance;
	}
	
	public dicePokerVO select(String userId, String passWd) {
		dicePokerVO vo = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWD);
			ps = con.prepareStatement(SQL_SELECT);
			System.out.println("userId: "+userId+"  "+passWd);
			ps.setString(1, userId);
			ps.setString(2, passWd);
			rs = ps.executeQuery();
			System.out.println("1");
			if(rs.next()){
				System.out.println("2");
				userId = rs.getString("userId");
				passWd = rs.getString("passWd");
				String title = rs.getString("title");
				int win = rs.getInt("win");
				int lose = rs.getInt("lose");
				int gold = rs.getInt("gold");
				int totalGame = rs.getInt("totalGame");
				int gameOn = rs.getInt("gameOn");
				int diceSkin = rs.getInt("diceSkin");
				int backSkin = rs.getInt("backSkin");
				int voice = rs.getInt("voice");
				
				vo = new dicePokerVO(userId, passWd, title, win, lose, gold, totalGame, gameOn, diceSkin, backSkin, voice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	public void insert(String userId, String passWd) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWD);
			ps = con.prepareStatement(SQL_INSERT);
			ps.setString(1, userId);
			ps.setString(2, passWd);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update(String title, int win, int lose, int gold, int totalGame,
			int gameOn, int diceSkin, int backSkin, int voice, String userId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWD);
			ps = con.prepareStatement(SQL_UPDATE);
			ps.setString(1, title);
			ps.setInt(2, win);
			ps.setInt(3, lose);
			ps.setInt(4, gold);
			ps.setInt(5, totalGame);
			ps.setInt(6, gameOn);
			ps.setInt(7, diceSkin);
			ps.setInt(8, backSkin);
			ps.setInt(9, voice);
			ps.setString(10, userId);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public dicePokerVO comSelect(String userId) {
		dicePokerVO vo = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWD);
			ps = con.prepareStatement(SQL_COMSELECT);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			
			if(rs.next()){
				userId = rs.getString("userId");
				String passWd = rs.getString("passWd");
				String title = rs.getString("title");
				int win = rs.getInt("win");
				int lose = rs.getInt("lose");
				int gold = rs.getInt("gold");
				int totalGame = rs.getInt("totalGame");
				int gameOn = rs.getInt("gameOn");
				int diceSkin = rs.getInt("diceSkin");
				int backSkin = rs.getInt("backSkin");
				int voice = rs.getInt("voice");
				
				vo = new dicePokerVO(userId, passWd, title, win, lose, gold, totalGame, gameOn, diceSkin, backSkin, voice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
}