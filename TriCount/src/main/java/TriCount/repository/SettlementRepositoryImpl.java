package TriCount.repository;

import TriCount.domain.Settlement;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
public class SettlementRepositoryImpl implements SettlementRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;

    public SettlementRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("settlement")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public Settlement create(String name) {
        Map<String, Object> param = new HashMap<>();
        param.put("name", name);

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(param));
        Settlement settlement = new Settlement();
        settlement.setId(key.longValue());
        settlement.setName(name);

        return settlement;
    }

    @Override
    public Optional<Settlement> findById(Long id) {
        String sql = "select * from settlement where id = :id";
        Map<String, Long> param = Map.of("id", id);
        try {
            Settlement settlement = jdbcTemplate.queryForObject(sql, param, settlementRowMapper());
            return Optional.of(settlement);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void addParticipantToSettlement(Long settlementId, Long memberId) {
        String sql = "insert into settlement_participant (settlement_id, member_id) values (:settlementId, :memberId)";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("settlementId", settlementId)
                .addValue("memberId", memberId);

        jdbcTemplate.update(sql, params);
    }

    private RowMapper<Settlement> settlementRowMapper() {
        return BeanPropertyRowMapper.newInstance(Settlement.class);
    }

}
