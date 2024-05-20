package TriCount.controller;

import TriCount.domain.Settlement;
import TriCount.service.SettlementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member/settlement")
public class SettlementController {

    private final SettlementService settlementService;

    @PostMapping("/create")
    public ResponseEntity<Settlement> createSettlement(@RequestParam String settlementName) {
        Settlement settlement = settlementService.createSettlement(settlementName);
        return new ResponseEntity<>(settlement, HttpStatus.OK);
    }

    @PostMapping("/{id}/join")
    public ResponseEntity<Void> joinSettlement(@PathVariable Long id) {
        settlementService.joinSettlement(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/get")
    public ResponseEntity<Settlement> getSettlement(@PathVariable Long id) {
        Settlement settlement = settlementService.getSettlement(id);
        return new ResponseEntity<>(settlement, HttpStatus.OK);
    }

//    @GetMapping("/{id}/balance")
//    public ResponseEntity<Settlement> getSettlementBalanceResult(@PathVariable("id") Long settlementId) {
//
//    }
}
