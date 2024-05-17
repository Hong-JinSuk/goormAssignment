package TriCount.service;

import TriCount.MemberContext;
import TriCount.domain.Settlement;
import TriCount.repository.SettlementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SettlementService {

    private final SettlementRepository settlementRepository;

    public Settlement createSettlement(String settlementName) {
        Settlement settlement = settlementRepository.create(settlementName);
        settlementRepository.addParticipantToSettlement(settlement.getId(), MemberContext.getMember().getId());
        settlement.getJoinMember().add(MemberContext.getMember());

        return settlement;
    }
}
