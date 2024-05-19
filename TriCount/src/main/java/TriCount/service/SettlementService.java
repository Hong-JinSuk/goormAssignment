package TriCount.service;

import TriCount.MemberContext;
import TriCount.domain.Balance;
import TriCount.domain.Settlement;
import TriCount.repository.SettlementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Settlement getSettlement(Long id) {
        Optional<Settlement> settlementOptional = settlementRepository.findById(id);
        return settlementOptional.get();
    }

    public void joinSettlement(Long settlementId) {
        // 정산방이 있는지 체크해야함
        Optional<Settlement> settlementOptional = settlementRepository.findById(settlementId);
        if(!settlementOptional.isPresent()){
            throw new RuntimeException("정산방이 없습니다.");
        }
        settlementRepository.addParticipantToSettlement(settlementId, MemberContext.getMember().getId());
    }

//    public List<Balance> getBalance(Long settlementId) {
//
//    }
}
