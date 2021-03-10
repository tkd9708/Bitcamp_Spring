package mycar.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class MyCarDao extends JdbcDaoSupport{

	// 출력에 필요한 내부 클래스
	class CarMapper implements RowMapper<MyCarDto>{
		@Override
		public MyCarDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			
			MyCarDto dto = new MyCarDto();
			dto.setNum(rs.getString("num"));
			dto.setCarname(rs.getString("carname"));
			dto.setCarcolor(rs.getString("carcolor"));
			dto.setCarprice(rs.getInt("carprice"));
			dto.setCarguip(rs.getString("carguip"));
			
			return dto;
		}
	}
	
	//전체출력
	public List<MyCarDto> getAllDatas(){
		String sql = "select * from mycar order by num asc";
		List<MyCarDto> list = getJdbcTemplate().query(sql, new CarMapper());
		
		return list;
	}
	
	// insert
	public void insertCar(MyCarDto dto) {
		String sql = "insert into mycar (carname, carcolor, carprice, carguip) values (?,?,?,?)";
		
		// insert, delete, update는 모두 메서드 update로 한다.
		// select만 query
		getJdbcTemplate().update(sql, new Object[] {dto.getCarname(), dto.getCarcolor(), dto.getCarprice(), dto.getCarguip()});
	}
	
	public MyCarDto getData(String num) {
		MyCarDto dto = null;
		String sql = "select * from mycar where num=?";
		dto = getJdbcTemplate().queryForObject(sql, new Object[] {num}, new CarMapper());
		
		return dto;
	}
	
	// 수정
	public void updateCar(MyCarDto dto) {
		String sql="update mycar set carname=?, carprice=?, carcolor=?, carguip=? where num=?";
		getJdbcTemplate().update(sql, new Object[] {dto.getCarname(), dto.getCarprice(), dto.getCarcolor(), dto.getCarguip(), dto.getNum()});
	}
	
	// 삭제
	public void deleteCar(String num) {
		String sql = "delete from mycar where num=?";
		getJdbcTemplate().update(sql, new Object[] {num});
		
		
	}
}
