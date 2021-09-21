package com.example.rest.controller;

import com.example.rest.data.VPosApiRequest;
import com.example.rest.data.VPosApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SalesController {

    @PostMapping(value = "/sale/{type}")
    public ResponseEntity<VPosApiResponse> doSalesCard(
            @PathVariable(name = "type") String type,
            @Valid @RequestBody VPosApiRequest request)  {

        switch (type) {
            case "masterpass":
                request.setPc("16");
                break;

            default:
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        VPosApiResponse response = VPosApiResponse.builder()
                .id(request.getId())
                .pc("16")
                .pcDesc("Masterpass Sale Transactions")
                .build();

        return ResponseEntity.ok(response);
    }

}
