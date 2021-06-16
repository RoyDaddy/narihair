package com.dh.narihair.service;

import com.dh.narihair.util.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TempService {
	@Autowired
    private FileStorageProperties prop;
}
