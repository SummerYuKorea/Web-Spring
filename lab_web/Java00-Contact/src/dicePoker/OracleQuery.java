package dicePoker;

public interface OracleQuery {
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "scott";
	public static final String PASSWD = "123456";
	public static final String TABLE_USER="dicepoker_user";
 
	public static final String SQL_SELECT =
		"select * from "+TABLE_USER+" where userid = " + "?" + " and passwd = " + "?";
			//"select * from dicepoker_user where userid='Chae' and passwd='1234' ";
	public static final String SQL_INSERT =
			"insert into "+TABLE_USER+"(userid, passwd) values(" + "?" + ", " + "?" + ")";
	public static final String SQL_UPDATE =
			"update "+TABLE_USER+" set title = " + "?" +
					", win = " + "?" +
					", lose = " + "?" +
					", gold = " + "?" +
					", totalGame = " + "?" +
					", gameOn = " + "?" +
					", diceSkin = " + "?" +
					", backSkin = " + "?" +
					", voice = " + "?" +
			" where userid = " + "?";
	public static final String SQL_COMSELECT =
			"select * from (select * from "+TABLE_USER+" order by DBMS_RANDOM.RANDOM) where rownum = 1 and userid != " + "?";
}