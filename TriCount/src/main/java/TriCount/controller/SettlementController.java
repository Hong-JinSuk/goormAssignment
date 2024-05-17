package TriCount.controller;

import TriCount.domain.Settlement;
import TriCount.service.SettlementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
