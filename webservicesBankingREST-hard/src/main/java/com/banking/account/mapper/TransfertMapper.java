package com.banking.account.mapper;

import com.banking.account.dto.TransfertDto;
import com.banking.account.model.Transfert;

public class TransfertMapper {
    public static TransfertDto mapToDto(Transfert transfert){
        TransfertDto transfertDto = new TransfertDto();
        transfertDto.setAccountId(transfert.getAccountId());
        transfertDto.setAccountIdRcv(transfert.getAccountIdRcv());
        transfertDto.setValue(transfert.getValue());
        transfertDto.setFee(transfert.getFee());
        transfertDto.setCurrency(transfert.getCurrency());
        return transfertDto;
    }

    public static Transfert mapToEntity(TransfertDto transfertDto){
        Transfert transfert = new Transfert();
        transfert.setAccountId(transfertDto.getAccountId());
        transfert.setAccountIdRcv(transfertDto.getAccountIdRcv());
        transfert.setValue(transfertDto.getValue());
        transfert.setFee(transfertDto.getFee());
        transfert.setCurrency(transfertDto.getCurrency());
        return transfert;
    }
}
