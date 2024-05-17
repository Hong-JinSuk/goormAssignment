package TriCount.repository;

import TriCount.domain.Settlement;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementRepository {

    public Settlement create(String settlementName);

    public void addParticipantToSettlement(Long settlementId, Long memberId);

}
