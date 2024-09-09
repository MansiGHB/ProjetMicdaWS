package com.banking.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banking.account.dto.TransfertDto;
import com.banking.account.dto.TransfertResponse;
import com.banking.account.service.TransfertService;

@RestController
@RequestMapping("/account/")
public class TransfertController {
    private final TransfertService transfertService;

    @Autowired
    public TransfertController(TransfertService transfertService) {
        this.transfertService = transfertService;
    }

    @GetMapping("transfert")
    public ResponseEntity<TransfertResponse> gettransferts(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ){
        return new ResponseEntity<>(transfertService.getAllTransfert(pageNo, pageSize), HttpStatus.OK);
    }

    @GetMapping("transfert/{id}")
    public ResponseEntity<TransfertDto> transfertDetail(@PathVariable int id){
        return new ResponseEntity<>(transfertService.getTransfertById(id), HttpStatus.OK);
    }

    @PostMapping("transfert")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TransfertDto> createtransfert(@RequestBody TransfertDto transfert){
        return new ResponseEntity<>(transfertService.createTransfert(transfert), HttpStatus.CREATED);
    }

    @PutMapping("transfert/{id}")
    public ResponseEntity<TransfertDto> updatetransfert(@RequestBody TransfertDto transfertDto, @PathVariable("id") int transfertId){
        TransfertDto response = transfertService.updateTransfert(transfertDto, transfertId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("transfert/{id}")
    public ResponseEntity<String> deletetransfert(@PathVariable("id") int transfertId){
        transfertService.deleteTransfertById(transfertId);
        return new ResponseEntity<>("Transfert deleted", HttpStatus.OK);
    }
}
