package com.jazz.deck.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LogRepository {

	private static final String TABLE = "deck.log";
	private static final String KEY_FIELDS = "id";
	private static final String DATA_FIELDS = "code, text";
	private static final String ALL_FIELDS = KEY_FIELDS + ", ctime, " + DATA_FIELDS;
	private static final String SELECT = "SELECT " + ALL_FIELDS + " FROM " + TABLE;
			
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public LogRepository() {}
	
    ////////////////////////////////
    /// GETERS
    ////////////////////////////////
	@SuppressWarnings("deprecation")
	public List<LogEntity> get() {
		return jdbcTemplate.query(SELECT, 
                	new Object[]{},
                	(rs, rowNum) ->
                		new LogEntity(
            				rs.getInt("id"),
            				rs.getDate("ctime"),
            				rs.getString("code"),
            				rs.getString("text")
                		)
                	);
    }

    @SuppressWarnings("deprecation")
	public LogEntity get(Integer id) {
        return jdbcTemplate
                .queryForObject(SELECT + " WHERE id = ?", 
                	new Object[]{id},
                	(rs, rowNum) ->
                		new LogEntity(
            				rs.getInt("id"),
            				rs.getDate("ctime"),
            				rs.getString("code"),
            				rs.getString("text")
                		)
                	);
    }

    ////////////////////////////////
    /// SETTERS
    ////////////////////////////////
    public int set(String code, String text) {
    	return insert(new LogEntity(code, text));
    }
    
    public int set(LogEntity log) {
    	if (log.getId() != null && log.getId() > 0) {
    		return update(log);
    	} else {
    		return insert(log);
    	}
    }
    
    public int insert(LogEntity log) {
        return jdbcTemplate.update(
                "INSERT INTO " + TABLE + "(" + DATA_FIELDS + ")"
                + "VALUES(?,?)", log.getCode(), log.getText());
    }
	
    public int update(LogEntity log) {
        return jdbcTemplate.update(
                "UPDATE " + TABLE + " SET code = ?, text = ? "
                + "WHERE id = ?",
                log.getCode(), log.getText(), log.getId());
    }

    ////////////////////////////////
    /// REMOVERS
    ////////////////////////////////
    public int remove(LogEntity log) {
        return remove(log.getId());
    }
	
    public int remove(Integer id) {
        return jdbcTemplate.update(
                "DELETE FROM " + TABLE + " "  
                + "WHERE id = ?", id);
    }
	
}
