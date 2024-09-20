package com.myretail.myretail.controller;

import com.myretail.myretail.entity.MonthlyRewars;
import com.myretail.myretail.entity.TotalRewards;
import com.myretail.myretail.service.RewardsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class RewardsController {
    private RewardsService rewardsService;
    @GetMapping("/getTotalRewardsByCust")
    public ResponseEntity<TotalRewards> getTotalRewardsByCustomer(@RequestParam int customerID){
        TotalRewards totalRewards = rewardsService.getTotalRewardsByCustomer(customerID);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(totalRewards);
    }
    @GetMapping("/getMonthlyRewardsByCust")
    public ResponseEntity<List<MonthlyRewars>> getMonthlyRewardsByCustomer(@RequestParam int customerID){

        List<MonthlyRewars> monthlyRewards = rewardsService.getMonthlyRewardsByCustomer(customerID);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(monthlyRewards);
    }

}
