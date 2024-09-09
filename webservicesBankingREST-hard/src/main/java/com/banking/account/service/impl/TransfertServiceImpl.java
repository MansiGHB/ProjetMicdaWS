package com.banking.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.banking.account.dto.TransfertDto;
import com.banking.account.dto.TransfertResponse;
import com.banking.account.exception.TransfertNotFoundException;
import com.banking.account.mapper.TransfertMapper;
import com.banking.account.model.Transfert;
import com.banking.account.repository.TransfertRepository;
import com.banking.account.service.TransfertService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransfertServiceImpl implements TransfertService {

    private TransfertRepository transfertRepository;

    @Autowired
    public TransfertServiceImpl(TransfertRepository transfertRepository) {
        this.transfertRepository = transfertRepository;
    }

    @Override
    public TransfertDto createTransfert(TransfertDto transfertDto) {
        Transfert transfert = TransfertMapper.mapToEntity(transfertDto);
        Transfert newTransfert = transfertRepository.save(transfert);
        return TransfertMapper.mapToDto(newTransfert);
    }

    @Override
    public TransfertResponse getAllTransfert(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Transfert> transfert = transfertRepository.findAll(pageable);
        List<Transfert> listOfTransfert = transfert.getContent();
        List<TransfertDto> content = listOfTransfert.stream().map(TransfertMapper::mapToDto).collect(Collectors.toList());

        TransfertResponse transfertResponse = new TransfertResponse();
        transfertResponse.setContent(content);
        transfertResponse.setPageNo(transfert.getNumber());
        transfertResponse.setPageSize(transfert.getSize());
        transfertResponse.setTotalElements(transfert.getTotalElements());
        transfertResponse.setTotalPages(transfert.getTotalPages());
        transfertResponse.setLast(transfert.isLast());

        return transfertResponse;
    }

    @Override
    public TransfertDto getTransfertById(int id) {
        Transfert transfert = transfertRepository.findById(id).orElseThrow(() -> new TransfertNotFoundException("Transfert could not be found"));
        return TransfertMapper.mapToDto(transfert);
    }

    @Override
    public TransfertDto updateTransfert(TransfertDto transfertDto, int id) {
        Transfert transfert = transfertRepository.findById(id).orElseThrow(() -> new TransfertNotFoundException("Transfert could not be found"));

        transfert.setValue(transfertDto.getValue());
        transfert.setFee(transfertDto.getFee());

        Transfert updatedTransfert = transfertRepository.save(transfert);

        return TransfertMapper.mapToDto(updatedTransfert);
    }

    @Override
    public void deleteTransfertById(int id) {
        Transfert transfert = transfertRepository.findById(id).orElseThrow(() -> new TransfertNotFoundException("Transfert could not be found"));
        transfertRepository.delete(transfert);
    }

}
