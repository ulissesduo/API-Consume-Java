package ConsumeAPI.AlphaVantageAPI.controller;

import ConsumeAPI.AlphaVantageAPI.service.FinanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/finance")
@RequiredArgsConstructor
public class FinanceController {

    private final FinanceService financeService;

    @GetMapping("get")
    public ResponseEntity<?> callFinanceEndPointToGetFinanceData(@RequestParam String symbol) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(financeService.getAllFinanceData(symbol));
    }
    @GetMapping("getNasdac")
    public ResponseEntity<?> callFinanceEndPointToGetFinanceDataNasdac(@RequestParam String symbol) {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(financeService.getAllFinanceDataNasdac(symbol));
    }
}
