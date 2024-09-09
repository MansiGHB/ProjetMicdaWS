package com.banking.account.service;

import com.banking.account.dto.TransfertDto;
import com.banking.account.dto.TransfertResponse;

public interface TransfertService {
    TransfertDto createTransfert(TransfertDto Transfert);
    TransfertResponse getAllTransfert(int pageNo, int pageSize);
    TransfertDto getTransfertById(int id);
    TransfertDto updateTransfert(TransfertDto transfertDto, int id);
    void deleteTransfertById(int id);
}
